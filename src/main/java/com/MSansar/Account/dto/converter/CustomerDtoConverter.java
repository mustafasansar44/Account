package com.MSansar.Account.dto.converter;

import com.MSansar.Account.dto.CustomerDto;
import com.MSansar.Account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public CustomerDto convert(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .accounts(customer.getAccounts().stream()
                        .map(customerAccountDtoConverter::convert).collect(Collectors.toList()))
                .build();
    }
}
