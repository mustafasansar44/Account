package com.MSansar.Account.service;

import com.MSansar.Account.dto.CustomerDto;
import com.MSansar.Account.dto.converter.CustomerDtoConverter;
import com.MSansar.Account.dto.request.CreateCustomerRequest;
import com.MSansar.Account.exception.CustomerNotFoundException;
import com.MSansar.Account.model.Customer;
import com.MSansar.Account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }



    public CustomerDto getById(UUID id){
        return customerDtoConverter.convert(findCustomerById(id));
    }

    public List<CustomerDto> getAll(){
        return customerRepository.findAll().stream().map(customer -> customerDtoConverter.convert(customer)).collect(Collectors.toList());
    }

    public String delete(UUID id){
        customerRepository.delete(findCustomerById(id));
        return "Kullanıcı silindi...";
    }
    public String add(Customer customer){
        customerRepository.save(customer);
        return "Kaydedildi.";
    }

    protected Customer findCustomerById(UUID id){
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Böyle biri yok.")
        );
    }

}
