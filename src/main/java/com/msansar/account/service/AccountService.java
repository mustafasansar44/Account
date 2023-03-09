package com.msansar.account.service;

import com.msansar.account.dto.AccountDto;
import com.msansar.account.dto.request.AccountRequest;
import com.msansar.account.dto.converter.AccountDtoConverter;
import com.msansar.account.model.Account;
import com.msansar.account.model.Customer;
import com.msansar.account.model.Transaction;
import com.msansar.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;
    private final Clock clock;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter, Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
        this.clock = clock;
    }


    public AccountDto createAccount(AccountRequest accountRequest) {
        Customer customer = customerService.findCustomerById(accountRequest.getCustomerId());

        Account account = new Account(
                customer,
                accountRequest.getBalance(),
                getLocalDateTimeNow());

        if (accountRequest.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    accountRequest.getBalance(),
                    getLocalDateTimeNow(),
                    account);

            account.getTransaction().add(transaction);
        }
        return converter.accountToAccountDto(accountRepository.save(account));
    }

    public String deleteAccount(String id){
        accountRepository.deleteById(id);
        return "Hesap silindi.";
    }

    private LocalDateTime getLocalDateTimeNow() {
        Instant instant = clock.instant();
        return LocalDateTime.ofInstant(
                instant,
                Clock.systemDefaultZone().getZone());
    }
}
