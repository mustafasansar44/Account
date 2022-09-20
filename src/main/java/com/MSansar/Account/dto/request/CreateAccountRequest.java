package com.MSansar.Account.dto.request;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class CreateAccountRequest {

    // sonra bi validasyon yap.
    private UUID customerId;
    @Min(0)
    private BigDecimal initialCredit;
}
