package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {

    @Getter
    private Long id;

    @NotBlank(message = "Insert a valid username")
    @NotNull
    @Getter @Setter
    private String userName;

    @NotBlank(message = "Insert a valid password")
    @NotNull
    @Pattern(
        regexp = "{10,100}",
        flags = Pattern.Flag.CANON_EQ,
        message = "Invalid password. \nMin of 10 characters \nMax of 100 characters."
    )
    @Getter @Setter
    private String passWord;
    
}
