package com.MSansar.Account.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class CustomerDto {

    private UUID id;
    private String name;
    private String surname;
    private List<CustomerAccountDto> accounts;

}
