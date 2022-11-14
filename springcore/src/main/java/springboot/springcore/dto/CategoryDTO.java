package springboot.springcore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CategoryDTO {

    @Getter
    private Long id;

    @NotBlank(message = "Insert a valid category name")
    @NotNull
    @Getter @Setter
    private String category;
    
}
