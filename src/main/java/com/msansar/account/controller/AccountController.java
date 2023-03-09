package com.msansar.account.controller;


import com.msansar.account.dto.AccountDto;
import com.msansar.account.dto.request.AccountRequest;
import com.msansar.account.model.Account;
import com.msansar.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }


}
