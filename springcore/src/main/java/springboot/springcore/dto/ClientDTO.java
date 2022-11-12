package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import springboot.springcore.entity.Address;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Insert a valid name")
    @NotNull
    private String name;

    @NotBlank(message = "Insert a valid email")
    @NotNull
    @Pattern(
        regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid email."
    )
    private String email;
    private Long addressId;
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
