package com.gentara.elurah.master.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RwRes {
    private String id;
    private String name;
    private String address;
    private List<RtRes> rtList;
}
