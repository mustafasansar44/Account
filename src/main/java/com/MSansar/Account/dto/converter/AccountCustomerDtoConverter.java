package com.MSansar.Account.dto.converter;

import com.MSansar.Account.dto.AccountCustomerDto;
import com.MSansar.Account.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class AccountCustomerDtoConverter {

    public AccountCustomerDto convert(Customer customer){
        return AccountCustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .build();

    }
}
