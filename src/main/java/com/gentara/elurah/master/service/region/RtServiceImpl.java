package com.gentara.elurah.master.service.region;

import com.gentara.elurah.exception.NotFoundException;
import com.gentara.elurah.master.model.entity.RtEntity;
import com.gentara.elurah.master.model.entity.RwEntity;
import com.gentara.elurah.master.model.request.RtReq;
import com.gentara.elurah.master.model.response.RtRes;
import com.gentara.elurah.master.repository.RtRepository;
import com.gentara.elurah.master.repository.RwRepository;
import com.gentara.elurah.util.CommonUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RtServiceImpl implements RtService {

    private final RtRepository rtRepository;
    private final RwRepository rwRepository;

    @Override
    public List<RtRes> getAll() {
        List<RtEntity> result = this.rtRepository.findAll();
        return result.stream().map(this::entityToRes).collect(Collectors.toList());
    }

    @Override
    public Optional<RtRes> getById(String id) {
        return Optional.of(this.entityToRes(this.getEntity(id)));
    }

    @Override
    public Optional<RtRes> create(RtReq request) {
        RtEntity result = this.requestToEntity(request);
        try {
            rtRepository.save(result);
            return Optional.of(this.entityToRes(result));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<RtRes> update(RtReq request, String id) {
        RtEntity result = this.requestToEntity(this.getEntity(id), request);
        try {
            rtRepository.save(result);
            return Optional.of(this.entityToRes(result));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RtRes> delete(String id) {
        RtEntity result = this.getEntity(id);
        try {
            rtRepository.delete(result);
            return Optional.of(this.entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RtRes entityToRes(RtEntity entity) {
        return RtRes.builder()
                .id(entity.getId())
                .rwId(entity.getRw().getId())
                .rwName(entity.getRw().getName())
                .name(entity.getName())
                .build();
    }

    private RtEntity getEntity(String id) {
        return this.rtRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Rt with id %s not found", id)));
    }

    private RtEntity requestToEntity( RtEntity rtEntity,  RtReq request) {
        return RtEntity.builder()
                .id(rtEntity.getId())
                .rw(getRwEntity(request.getRwId()))
                .name(rtEntity.getName())
                .build();
    }

    private RtEntity requestToEntity(RtReq request){
        return RtEntity.builder()
                .id(CommonUtil.getUUID())
                .name(request.getName())
                .rw(getRwEntity(request.getRwId()))
                .build();
    }

    private RwEntity getRwEntity(String id) {
        return this.rwRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Rw with id %s not found", id)));
    }
}
