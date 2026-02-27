package com.gentara.elurah.master.service.contribution;

import com.gentara.elurah.master.model.request.ContributionCreateReq;
import com.gentara.elurah.master.model.request.ContributionReq;
import com.gentara.elurah.master.model.response.ContributionRes;

import java.util.List;
import java.util.Optional;

public interface ContributionService {
    List<ContributionRes> getAllByRt(String rtId);
    Optional<ContributionRes> getById(String id);
    Optional<ContributionRes> create(ContributionCreateReq request);
    Optional<ContributionRes> update(ContributionReq request, String id);
    Optional<ContributionRes> delete(String id);
}
