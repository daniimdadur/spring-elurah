package com.gentara.elurah.master.service.contribution;

import com.gentara.elurah.exception.NotFoundException;
import com.gentara.elurah.master.model.entity.ContributionEntity;
import com.gentara.elurah.master.model.request.ContributionCreateReq;
import com.gentara.elurah.master.model.request.ContributionReq;
import com.gentara.elurah.master.model.response.ContributionRes;
import com.gentara.elurah.master.repository.ContributionRepository;
import com.gentara.elurah.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {
    private final ContributionRepository contributionRepository;

    @Override
    public List<ContributionRes> getAllByRt(String rtId) {
        List<ContributionEntity> result = this.contributionRepository.findAllByRtId(rtId);
        return result.stream().map(this::entityToRes).collect(Collectors.toList());
    }

    @Override
    public Optional<ContributionRes> getById(String id) {
        return Optional.of(this.entityToRes(this.getContributionEntity(id)));
    }

    @Override
    public Optional<ContributionRes> create(ContributionCreateReq request) {
        ContributionEntity result = this.reqToEntity(request);
        try {
            contributionRepository.save(result);
            return Optional.of(entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ContributionRes> update(ContributionReq request, String id) {
        ContributionEntity result = this.reqToEntity(request, this.getContributionEntity(id));
        try {
            contributionRepository.save(result);
            return Optional.of(entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<ContributionRes> delete(String id) {
        ContributionEntity result = this.getContributionEntity(id);
        try {
            contributionRepository.delete(result);
            return Optional.of(entityToRes(result));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ContributionRes entityToRes(ContributionEntity entity) {
        return ContributionRes.builder()
                .id(entity.getId())
                .contributionName(entity.getContributionName())
                .contributionType(entity.getContributionType())
                .amount(entity.getAmount())
                .startDate(entity.getStartDate())
                .dueDate(entity.getDueDate())
                .penaltyPercentage(entity.getPenaltyPercentage())
                .isActive(entity.isActive())
                .build();
    }

    private ContributionEntity reqToEntity(ContributionCreateReq request) {
        return ContributionEntity.builder()
                .id(CommonUtil.getUUID())
                .contributionName(request.getContributionName())
                .contributionType(request.getContributionType())
                .amount(request.getAmount())
                .startDate(request.getStartDate())
                .dueDate(request.getDueDate())
                .penaltyPercentage(request.getPenaltyPercentage())
                .isActive(false)
                .build();
    }

    private ContributionEntity reqToEntity(ContributionReq request, ContributionEntity entity) {
        return ContributionEntity.builder()
                .id(entity.getId())
                .contributionName(request.getContributionName())
                .contributionType(request.getContributionType())
                .amount(request.getAmount())
                .startDate(request.getStartDate())
                .dueDate(request.getDueDate())
                .penaltyPercentage(request.getPenaltyPercentage())
                .isActive(request.isActive())
                .build();
    }

    private ContributionEntity getContributionEntity(String id) {
        return this.contributionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("contribution with id %s not found", id)));
    }
}
