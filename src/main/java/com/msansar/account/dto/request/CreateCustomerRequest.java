package com.msansar.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    @NotBlank(message = "isim alanı boş olamaz!")
    private String name;

    @NotBlank(message = "soyisim alanı boş olamaz!")
    private String surname;
}
