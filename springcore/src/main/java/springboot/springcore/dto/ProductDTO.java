package springboot.springcore.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ProductDTO {

    @Getter
    private Long id;
    
    @Getter @Setter
    private Long idCategory;

    @Getter @Setter
    private CategoryDTO category;

    @NotBlank(message = "Insert a valid product name")
    @NotNull
    @Getter @Setter
    private String product;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String foto;

    @NonNull
    @Getter @Setter
    private Double price;
    
}
