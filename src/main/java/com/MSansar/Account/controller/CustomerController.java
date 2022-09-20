package com.MSansar.Account.controller;
import com.MSansar.Account.dto.CustomerDto;
import com.MSansar.Account.model.Customer;
import com.MSansar.Account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getById")
    private ResponseEntity<CustomerDto> getById(@RequestParam UUID id){
        return ResponseEntity.ok(customerService.getById(id));
    }


    @GetMapping("/getAll")
    private ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/add")
    private ResponseEntity<String> add(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.add(customer));
    }

    @PostMapping("/delete")
    private ResponseEntity<String> delete(@RequestParam UUID id){
        return ResponseEntity.ok(customerService.delete(id));
    }

}

