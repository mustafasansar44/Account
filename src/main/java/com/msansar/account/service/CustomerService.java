package com.msansar.account.service;

import com.msansar.account.dto.AccountCustomerDto;
import com.msansar.account.dto.CustomerDto;
import com.msansar.account.dto.converter.CustomerAccountDtoConverter;
import com.msansar.account.dto.converter.CustomerDtoConverter;
import com.msansar.account.dto.request.CreateCustomerRequest;
import com.msansar.account.dto.request.UpdateCustomerRequest;
import com.msansar.account.exception.CustomerNotFoundException;
import com.msansar.account.model.Customer;
import com.msansar.account.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter, CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException(id + " id'li kullanıcı bulunamadı."));

    }


    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.customerToCustomerDto(findCustomerById(customerId));
    }

    public Set<CustomerDto> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerDtoConverter::customerToCustomerDto)
                .collect(Collectors.toSet());
    }

    public CustomerDto save(CreateCustomerRequest request){
        Customer customer = new Customer(request.getName(), request.getSurname());
        customerRepository.save(customer);
        return customerDtoConverter.customerToCustomerDto(customer);
    }


    public String updateCustomer(String id,UpdateCustomerRequest updateCustomerRequest){
        Customer customer = findCustomerById(id);
        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customerRepository.save(customer);
        return "Kullanıcı güncellendi.";
    }

    public String deleteCustomer(String id){
        customerRepository.deleteById(id);
        return "Kullanıcı Silindi.";
    }

}