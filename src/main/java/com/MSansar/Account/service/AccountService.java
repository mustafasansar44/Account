package com.MSansar.Account.service;


import com.MSansar.Account.dto.AccountDto;
import com.MSansar.Account.dto.request.CreateAccountRequest;
import com.MSansar.Account.dto.converter.AccountDtoConverter;
import com.MSansar.Account.model.Account;
import com.MSansar.Account.model.Customer;
import com.MSansar.Account.model.Transaction;
import com.MSansar.Account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){ // Create Account Yazılacak

        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = Account.builder()
                .customer(customer)
                .balance(createAccountRequest.getInitialCredit())
                .build();

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
             account.getTransactions().add(
                     Transaction.builder()
                             .account(account)
                             .amount(createAccountRequest.getInitialCredit())
                             .build()
             );
        }

        return accountDtoConverter.convert(accountRepository.save(account));
    }


    public AccountDto findById(UUID id){
        return accountDtoConverter.convert(accountRepository.findAccountByUUID(id));
    }

}
