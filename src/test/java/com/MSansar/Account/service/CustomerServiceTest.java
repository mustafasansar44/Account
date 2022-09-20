package com.MSansar.Account.service;

import com.MSansar.Account.dto.CustomerDto;
import com.MSansar.Account.dto.converter.CustomerDtoConverter;
import com.MSansar.Account.exception.CustomerNotFoundException;
import com.MSansar.Account.model.Customer;
import com.MSansar.Account.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerDtoConverter customerDtoConverter;


    @Test
    public void testFindCustomerById_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = Customer.builder()
                .id(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))
                .name("test1")
                .surname("test2")
                .accounts(List.of())
                .build();
        // Mockitoya dedik ki findById ile uuid aratıldığında sonuç belirledğimiz customeri verecek.
        Mockito.when(customerRepository.findById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))).thenReturn(Optional.of(customer));
        Customer result = customerService.findCustomerById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"));
        Assert.assertEquals(result, customer);
    }

    @Test
    public void testFindCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        // Mockitoya dedik ki findById ile uuid aratıldığında sonuç belirledğimiz customeri verecek.
        Mockito.when(customerRepository.findById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))).thenReturn(Optional.empty());

        // Lambda fonk çağırıldığında CustomerNotFoundExc gelecek.
        Assert.assertThrows(CustomerNotFoundException.class,
                () -> customerService.findCustomerById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a")));
    }

    @Test
    public void testGetById_whenCustomerIdExists_shouldReturnCustomerDto(){

        Customer customer = Customer.builder()
                .id(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))
                .name("Test1")
                .surname("Test2")
                .accounts(List.of())
                .build();

        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))
                .name("Test1")
                .surname("Test2")
                .accounts(List.of())
                .build();
        // Mockitoya dedik ki findById ile uuid aratıldığında sonuç belirledğimiz customeri verecek.
        Mockito.when(customerRepository.findById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))).thenReturn(Optional.of(customer));
        Mockito.when(customerDtoConverter.convert(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"));
        Assert.assertEquals(result, customerDto);
    }

    @Test
    public void testGetById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){
        // Mockitoya dedik ki findById ile uuid aratıldığında sonuç belirledğimiz customeri verecek.
        Mockito.when(customerRepository.findById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))).thenReturn(Optional.empty());
        Assert.assertThrows(CustomerNotFoundException.class,
                () -> customerService.getById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))
        );

        // Converter in hiçbir metodu çağırılmadı demek. çünkü hata üretildi.
        Mockito.verifyNoInteractions(customerDtoConverter);
    }
}
/*
        Mockito.when(customerRepository.findById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"))).thenReturn(Optional.of(customer));
        Customer result = customerService.findCustomerById(UUID.fromString("2f15184e-3a37-4134-88a7-038c0d0a6f8a"));

        Assert.assertEquals(customer, result);



*/