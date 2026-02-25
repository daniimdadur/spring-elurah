package com.gentara.elurah.master.model.response;

import com.gentara.elurah.enums.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CashTransactionRes {
    private String id;
    private String rtId;
    private String rtName;
    private TransactionType transactionType;
    private Integer amount;
    private String description;
    private LocalDateTime transactionDate;
}
