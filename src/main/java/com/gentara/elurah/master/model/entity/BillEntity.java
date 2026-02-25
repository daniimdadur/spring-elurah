package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import com.gentara.elurah.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_bill")
public class BillEntity extends BaseAuditableSoftDelete {

    @Id
    @Column
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ContributionEntity contribution;

    @ManyToOne(fetch = FetchType.EAGER)
    private HouseHoldEntity houseHold;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "total_penalty")
    private Integer totalPenalty;

    @Column(name = "status")
    private PaymentStatus status;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentEntity> paymentEntities;
}
