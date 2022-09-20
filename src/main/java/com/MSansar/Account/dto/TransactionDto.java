package com.MSansar.Account.dto;

import com.MSansar.Account.model.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class TransactionDto {

    private UUID id;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

}
