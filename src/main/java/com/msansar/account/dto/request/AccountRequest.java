package com.msansar.account.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    @NotBlank(message = "customerId boş olamaz!")
    private String customerId;
    @Min(0)
    private BigDecimal balance;
}
