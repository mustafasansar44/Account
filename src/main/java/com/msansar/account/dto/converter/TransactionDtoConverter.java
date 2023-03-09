package com.msansar.account.dto.converter;

import com.msansar.account.dto.TransactionDto;
import com.msansar.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getCreationDate());
    }
}