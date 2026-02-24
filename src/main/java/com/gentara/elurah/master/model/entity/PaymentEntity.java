package com.gentara.elurah.master.model.entity;

import com.gentara.elurah.base.BaseAuditableSoftDelete;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_payment")
public class PaymentEntity extends BaseAuditableSoftDelete {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private BillEntity bill;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "paid_amount")
    private Integer paidAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "notes")
    private String notes;
}
