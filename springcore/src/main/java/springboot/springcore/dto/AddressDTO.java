package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class AddressDTO {

    @Getter
    private Long id;
    
    @NotBlank(message = "Insert a valid street name")
    @NotNull
    @Getter @Setter
    String street;

    @NotBlank(message = "Insert a valid city name")
    @NotNull
    @Getter @Setter
    String city;

    @NotBlank(message = "Insert a valid zipcode")
    @NotNull
    @Pattern(
        regexp = "[0-9]{5}-[\\d]{3}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid zipcode."
    )
    @Getter @Setter
    private String zipCode;

    @NotBlank(message = "Insert a valid state name")
    @NotNull
    @Pattern(
        regexp = "[A-Z]{2}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid state."
    )
    @Getter @Setter
    private String state;

}
