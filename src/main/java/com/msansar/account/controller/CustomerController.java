package com.msansar.account.controller;


import com.msansar.account.dto.AccountCustomerDto;
import com.msansar.account.dto.CustomerDto;
import com.msansar.account.dto.request.CreateCustomerRequest;
import com.msansar.account.dto.request.UpdateCustomerRequest;
import com.msansar.account.model.Customer;
import com.msansar.account.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getById/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CreateCustomerRequest request){
        return ResponseEntity.ok(customerService.save(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable String id,
                                         @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return ResponseEntity.ok(customerService.updateCustomer(id, updateCustomerRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}
