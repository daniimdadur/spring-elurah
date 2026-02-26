package com.gentara.elurah.master.model.response;

import com.gentara.elurah.enums.ContributionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContributionRes {
    private String id;
    private String rtId;
    private String rtName;
    private String contributionName;
    private ContributionType contributionType;
    private Integer amount;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private Integer penaltyPercentage;
    private boolean isActive;
}
