package com.MSansar.Account.dto.converter;

import com.MSansar.Account.dto.CustomerAccountDto;
import com.MSansar.Account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account){
        return CustomerAccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .creationDate(account.getCreationDate())
                .transactions(account.getTransactions().stream()
                        .map(t -> transactionDtoConverter.convert(t)).collect(Collectors.toList()))
                .build();
    }
}
