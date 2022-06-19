package pl.training.shop.payments.adapters.rest;

import lombok.Data;
import pl.training.shop.commons.validator.Money;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class PaymentRequestDto {

    @Min(1)
    private Long requestId;
    // @Pattern(regexp = "\\d+ PLN")
    // @NotBlank
    @Money(minValue = 100)
    private String value;

}
