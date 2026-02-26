package com.gentara.elurah.master.service.region;

import com.gentara.elurah.master.model.request.RwReq;
import com.gentara.elurah.master.model.response.RwRes;

import java.util.List;
import java.util.Optional;

public interface RwService {
    List<RwRes> get();
    Optional<RwRes> getById(String id);
    Optional<RwRes> create(RwReq request);
    Optional<RwRes> update(RwReq request, String id);
    Optional<RwRes> delete(String id);
}
