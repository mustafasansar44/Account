package com.MSansar.Account.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class CustomerAccountDto {

    private UUID id;
    private BigDecimal balance = BigDecimal.ZERO;
    private List<TransactionDto> transactions;
    private LocalDateTime creationDate;

}
