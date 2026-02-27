package com.gentara.elurah.master.controller;

import com.gentara.elurah.base.BaseController;
import com.gentara.elurah.base.Response;
import com.gentara.elurah.master.model.request.RtReq;
import com.gentara.elurah.master.model.response.RtRes;
import com.gentara.elurah.master.service.region.RtService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/rt")
@Validated
public class RtControllerApi extends BaseController<RtRes> {

    private final RtService rtService;

    @GetMapping
    public ResponseEntity<Response> get() {
        return super.getResponse(rtService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") @NotBlank String id) {
        return super.getResponse(rtService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody @Valid RtReq request){
        return super.getResponse(rtService.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> patch(@PathVariable("id") @NotBlank String id, @RequestBody @Valid RtReq request){
        return super.getResponse(rtService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") @NotBlank String id) {
        return super.getResponse(rtService.delete(id));
    }
}
