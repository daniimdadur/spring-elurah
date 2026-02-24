package com.gentara.elurah.master.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_bill")
public class Bill {
    @Id
    private String id;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "total_penalty")
    private Integer totalPenalty;

    @Column(name = "status")
    private String status;

}
