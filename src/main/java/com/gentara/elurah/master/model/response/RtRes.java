package com.gentara.elurah.master.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RtRes {
    private String id;
    private String rwId;
    private String rwName;
    private String name;
    private List<ContributionRes> contributions;
}
