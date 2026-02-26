package com.gentara.elurah.master.service.region;

import com.gentara.elurah.exception.NotFoundException;
import com.gentara.elurah.master.model.entity.RwEntity;
import com.gentara.elurah.master.model.request.RwReq;
import com.gentara.elurah.master.model.response.RwRes;
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
public class RwServiceImpl implements RwService {
    private final RwRepository rwRepository;

    @Override
    public List<RwRes> get() {
        List<RwEntity> result = this.rwRepository.findAll();
        return result.stream().map(this::entityToRes).collect(Collectors.toList());
    }

    @Override
    public Optional<RwRes> getById(String id) {
        return Optional.of(this.entityToRes(this.getEntity(id)));
    }

    @Override
    public Optional<RwRes> create(RwReq request) {
        RwEntity result = this.requestToEntity(request);
        try {
            rwRepository.save(result);
            return Optional.of(this.entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RwRes> update(RwReq request, String id) {
        RwEntity result = this.requestToEntity(this.getEntity(id), request);
        try {
            rwRepository.save(result);
            return Optional.of(this.entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RwRes> delete(String id) {
        RwEntity result = this.getEntity(id);
        try {
            rwRepository.delete(result);
            return Optional.of(this.entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RwRes entityToRes(RwEntity entity) {
        return RwRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .build();
    }

    private RwEntity getEntity(String id) {
        return this.rwRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Rw with id %s not found", id)));
    }

    private RwEntity requestToEntity(RwReq request) {
        return RwEntity.builder()
                .id(CommonUtil.getUUID())
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    private RwEntity requestToEntity(RwEntity rwEntity, RwReq request) {
        return RwEntity.builder()
                .id(rwEntity.getId())
                .name(rwEntity.getName())
                .address(request.getAddress())
                .build();
    }
}
