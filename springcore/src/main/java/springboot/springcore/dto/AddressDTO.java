package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AddressDTO {

    private Long id;
    
    @NotBlank(message = "Insert a valid street name")
    @NotNull
    String street;

    @NotBlank(message = "Insert a valid city name")
    @NotNull
    String city;

    @NotBlank(message = "Insert a valid zipcode")
    @NotNull
    @Pattern(
        regexp = "[0-9]{5}-[\\d]{3}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid zipcode."
    )
    private String zipCode;

    @NotBlank(message = "Insert a valid state name")
    @NotNull
    @Pattern(
        regexp = "[A-Z]{2}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid state."
    )
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
