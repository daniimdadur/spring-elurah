package com.gentara.elurah.master.service.contribution;

import com.gentara.elurah.master.model.request.ContributionReq;
import com.gentara.elurah.master.model.response.ContributionRes;
import com.gentara.elurah.master.repository.ContributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {
    private final ContributionRepository contributionRepository;

    @Override
    public List<ContributionRes> getAll() {
        return List.of();
    }

    @Override
    public Optional<ContributionRes> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ContributionRes> create(ContributionReq request) {
        return Optional.empty();
    }

    @Override
    public Optional<ContributionRes> update(ContributionReq request, String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ContributionRes> delete(String id) {
        return Optional.empty();
    }
}
