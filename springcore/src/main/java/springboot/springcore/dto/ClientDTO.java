package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import springboot.springcore.entity.Address;

public class ClientDTO {

    @Getter
    private Long id;

    @NotBlank(message = "Insert a valid name")
    @NotNull
    @Getter @Setter
    private String name;

    @NotBlank(message = "Insert a valid email")
    @NotNull
    @Pattern(
        regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid email."
    )
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private Long addressId;

    @Getter @Setter
    private Address address;
    
}
