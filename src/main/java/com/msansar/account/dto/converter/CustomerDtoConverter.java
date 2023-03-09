package com.msansar.account.dto.converter;

import com.msansar.account.dto.AccountCustomerDto;
import com.msansar.account.dto.CustomerDto;
import com.msansar.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
        this.customerAccountDtoConverter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDto customerToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::accountToCustomerAccountDto)
                        .collect(Collectors.toSet()));

    }



}