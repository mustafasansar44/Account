package com.MSansar.Account.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
public class AccountCustomerDto {

    private UUID id;
    private String name;
    private String surname;

}
