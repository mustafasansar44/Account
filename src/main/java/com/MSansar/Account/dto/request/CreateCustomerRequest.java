package com.MSansar.Account.dto.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerRequest {

    private String name;
    private String surname;

}
