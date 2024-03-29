package com.msansar.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDto {
    private String id;
    private BigDecimal balance;
    private Set<TransactionDto> transactions;
    private LocalDateTime creationDate;
}
