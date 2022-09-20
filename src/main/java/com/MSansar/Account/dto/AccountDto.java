package com.MSansar.Account.dto;

import com.MSansar.Account.model.Account;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@EqualsAndHashCode
public class AccountDto {

    private UUID id;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private AccountCustomerDto customerDto;
    // private List<Account> account;

}
