package com.gentara.elurah.master.model.request;

import com.gentara.elurah.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CashTransactionReq {
    private String id;
    private String rtId;
    private TransactionType transactionType;
    private Integer amount;
    private String description;
    private LocalDateTime transactionDate;
}
