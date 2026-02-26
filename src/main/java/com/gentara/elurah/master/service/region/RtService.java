package com.gentara.elurah.master.service.region;

import com.gentara.elurah.master.model.request.RtReq;
import com.gentara.elurah.master.model.response.RtRes;

import java.util.List;
import java.util.Optional;

public interface RtService {
    List<RtRes> getAll();
    Optional<RtRes> getById(String id);
    Optional<RtRes> create(RtReq request);
    Optional<RtRes> update(RtReq request, String id);
    Optional<RtRes> delete(String id);
}
