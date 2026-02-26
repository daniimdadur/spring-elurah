package com.gentara.elurah.master.model.request;

import com.gentara.elurah.enums.ContributionType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContributionReq {

    @NotBlank(message = "rt id is required")
    private String rtId;

    @NotBlank(message = "name is required")
    private String contributionName;

    @NotBlank(message = "type is required")
    private ContributionType contributionType;

    @NotNull(message = "amount is required")
    private Integer amount;

    @NotNull(message = "start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "due date is required")
    @Future(message = "due data must be in the future")
    private LocalDateTime dueDate;

    @NotNull(message = "penalty percentage is required")
    private Integer penaltyPercentage;

    @NotNull(message = "is active is required")
    private boolean isActive;
}
