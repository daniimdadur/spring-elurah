package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import com.gentara.elurah.enums.ContributionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_contribution")
public class ContributionEntity extends BaseAuditableSoftDelete {

    @Id
    @Column
    private String id;

    @Column(name = "contribution_name")
    private String contributionName;

    @Column(name = "contribution_type")
    private ContributionType contributionType;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "penalty_percentage")
    private Integer penaltyPercentage;

    @Column(name = "is_active")
    private boolean isActive;
}
