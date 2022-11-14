package springboot.springcore.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import springboot.springcore.entity.Item;

public class CartDTO {

    @Getter
    private Long id;

    @Getter @Setter
    private Long orderId;

    @Getter @Setter
    private List<Item> items;

    @NotNull
    @Getter @Setter
    private Integer session;
    
}
