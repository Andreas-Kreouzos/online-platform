package util

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class ValidatedBean {
    @NotBlank
    private String blank;

    @NotNull
    private Integer id;

    @Min(value = 0, message = 'must be greater than or equal to 0')
    int age

    ValidatedBean() {
    }
}
