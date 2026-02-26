package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import com.gentara.elurah.enums.ContributionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private RtEntity rt;

    @Column(name = "contribution_name")
    private String contributionName;

    @Column(name = "contribution_type")
    @Enumerated(EnumType.STRING)
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

    @OneToMany(mappedBy = "contribution", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillEntity> billEntities;
}
