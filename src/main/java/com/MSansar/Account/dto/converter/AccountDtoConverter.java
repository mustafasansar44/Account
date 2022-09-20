package com.MSansar.Account.dto.converter;

import com.MSansar.Account.dto.AccountDto;
import com.MSansar.Account.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    private final AccountCustomerDtoConverter accountCustomerDtoConverter;

    public AccountDtoConverter(AccountCustomerDtoConverter accountCustomerDtoConverter) {
        this.accountCustomerDtoConverter = accountCustomerDtoConverter;
    }

    public AccountDto convert(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .creationDate(account.getCreationDate())
                .customerDto(accountCustomerDtoConverter.convert(account.getCustomer()))
                .build();
    }
}
