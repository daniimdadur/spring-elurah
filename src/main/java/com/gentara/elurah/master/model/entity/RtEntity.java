package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_rt")
public class RtEntity extends BaseAuditableSoftDelete {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private RwEntity rw;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "rt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashTransactionEntity> cashTransactionEntities;

    @OneToMany(mappedBy = "rt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContributionEntity> contributionEntities;

    @OneToMany(mappedBy = "rt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HouseHoldEntity> houseHoldEntities;
}
