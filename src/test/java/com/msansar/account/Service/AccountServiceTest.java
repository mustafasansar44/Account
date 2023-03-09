package com.msansar.account.Service;

import com.msansar.account.dto.converter.AccountDtoConverter;
import com.msansar.account.repository.AccountRepository;
import com.msansar.account.service.AccountService;
import com.msansar.account.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;

import java.time.Clock;

import static org.mockito.Mockito.*;

public class AccountServiceTest {
    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerService customerService;
    private AccountDtoConverter accountDtoConverter;

    private Clock clock;
    @BeforeEach
    void setUp(){
        accountRepository = mock(AccountRepository.class);
        customerService = mock(CustomerService.class);
        accountDtoConverter = mock(AccountDtoConverter.class);
        clock = mock(Clock.class);
        accountService = new AccountService(accountRepository, customerService, accountDtoConverter, clock);
    }


}
