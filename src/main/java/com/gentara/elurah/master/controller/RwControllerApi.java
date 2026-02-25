package com.gentara.elurah.master.controller;

import com.gentara.elurah.base.BaseController;
import com.gentara.elurah.base.Response;
import com.gentara.elurah.master.model.request.RwReq;
import com.gentara.elurah.master.model.response.RwRes;
import com.gentara.elurah.master.service.RwService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/rw")
@Validated
public class RwControllerApi extends BaseController<RwRes> {
    private final RwService rwService;

    @GetMapping
    public ResponseEntity<Response> get() {
        return super.getResponse(rwService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") @NotBlank String id) {
        return super.getResponse(rwService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody @Valid RwReq request) {
        return super.getResponse(rwService.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Response> patch(@PathVariable("id") @NotBlank String id, @RequestBody @Valid RwReq request) {
        return super.getResponse(rwService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") @NotBlank String id) {
        return super.getResponse(rwService.delete(id));
    }
}
