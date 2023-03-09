package com.msansar.account.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// CreateCustomerRequest ile aynı SOLID e aykırı gelebilir ama proje ilerledikçe farklı column'lar işin içine
// girdiğinde ayırmak durumunda kalmayalım diye ekledim.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @NotBlank(message = "isim alanı boş olamaz!")
    private String name;

    @NotBlank(message = "soyisim alanı boş olamaz!")
    private String surname;
}
