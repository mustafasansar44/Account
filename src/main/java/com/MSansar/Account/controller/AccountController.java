package com.MSansar.Account.controller;

import com.MSansar.Account.dto.AccountDto;
import com.MSansar.Account.dto.request.CreateAccountRequest;
import com.MSansar.Account.model.Account;
import com.MSansar.Account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public String add(@Valid @RequestBody CreateAccountRequest createAccountRequest){
        accountService.createAccount(createAccountRequest);
        return "Hesap Kaydedildi.";
    }

    @GetMapping("/findById")
    public ResponseEntity<AccountDto> findById(@RequestParam UUID id){
        return ResponseEntity.ok(accountService.findById(id));
    }
}
