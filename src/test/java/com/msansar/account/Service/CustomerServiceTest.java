package com.msansar.account.Service;

import com.msansar.account.dto.CustomerDto;
import com.msansar.account.dto.converter.CustomerAccountDtoConverter;
import com.msansar.account.dto.converter.CustomerDtoConverter;
import com.msansar.account.dto.request.CreateCustomerRequest;
import com.msansar.account.dto.request.UpdateCustomerRequest;
import com.msansar.account.exception.CustomerNotFoundException;
import com.msansar.account.model.Customer;
import com.msansar.account.repository.CustomerRepository;
import com.msansar.account.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    private CustomerService customerService;

    private CustomerRepository customerRepository;
    private CustomerDtoConverter customerDtoConverter;
    private CustomerAccountDtoConverter customerAccountDtoConverter;


    @BeforeEach
    void setUp(){
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock(CustomerDtoConverter.class);
        customerAccountDtoConverter = mock(CustomerAccountDtoConverter.class);

        customerService = new CustomerService(customerRepository, customerDtoConverter, customerAccountDtoConverter);


    }

    @Test
    void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomerDto(){
        Customer customer = new Customer("id", LocalDateTime.now(), "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        when(customerRepository.findById("id")).thenReturn(Optional.of(customer));  //Davranış
        when(customerDtoConverter.customerToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById("id");
        assertEquals(result, customerDto);
    }

    @Test
    void testGetCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){
        when(customerRepository.findById("id")).thenReturn(Optional.empty());  //Davranış
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById("id"));
        verifyNoInteractions(customerDtoConverter); // Converter'in hiçbir metodu çağırılmadı.
    }
    @Test
    void testGetAllCustomer_shouldReturnCustomerDtoList(){
        Customer customer = new Customer("name", "surname");
        when(customerRepository.findAll()).thenReturn(List.of(customer));
        assertEquals(1, customerService.getAllCustomer().size());
    }

    @Test
    void testSave_whenCreateCustomerRequestExistsCreateCustomerAndSave_shouldReturnCustomerDto(){
        CreateCustomerRequest createCustomerRequest = new CreateCustomerRequest("name", "surname");
        Customer customer = new Customer("id",LocalDateTime.now(), createCustomerRequest.getName(), createCustomerRequest.getSurname(), Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerService.save(createCustomerRequest)).thenReturn(customerDto);
        when(customerDtoConverter.customerToCustomerDto(customer)).thenReturn(customerDto);

        assertEquals(customerDtoConverter.customerToCustomerDto(customer), customerDto);
    }

    // Delete ve Update kaldı...




}
