package com.MSansar.Account.service;

import com.MSansar.Account.dto.AccountDto;
import com.MSansar.Account.dto.converter.AccountDtoConverter;
import com.MSansar.Account.dto.request.CreateAccountRequest;
import com.MSansar.Account.model.Account;
import com.MSansar.Account.model.Customer;
import com.MSansar.Account.model.Transaction;
import com.MSansar.Account.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class AccountServiceTest {

    private AccountService accountService;

    private AccountRepository accountRepository;
    private CustomerService customerService;
    private AccountDtoConverter accountDtoConverter;

    @Before
    public void setUp() throws Exception {
        accountRepository = Mockito.mock(AccountRepository.class);
        customerService = Mockito.mock(CustomerService.class);
        accountDtoConverter = Mockito.mock(AccountDtoConverter.class);
        accountService = new AccountService(accountRepository, customerService, accountDtoConverter);

    }



}


/*

        Assert.assertEquals(result, accountDto);
        Mockito.verify(customerService).findCustomerByUUID(UUID.fromString("5f747eb9-db64-43e1-8a33-c6db4095a71e"));
        Mockito.verify(accountRepository).save(account);
        Mockito.verify(accountDtoConverter).convert(account);

*/