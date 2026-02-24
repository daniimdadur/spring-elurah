package com.gentara.elurah.master.model.entity;

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
@Table(name = "t_cash_transaction")
public class CashTransaction {
    @Id
    private String id;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
}
