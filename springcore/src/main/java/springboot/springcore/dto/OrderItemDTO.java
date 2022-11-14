package springboot.springcore.dto;

import lombok.Getter;
import lombok.Setter;

public class OrderItemDTO {
    
    @Getter
    private Long id;
    
    @Getter @Setter
    private Long productId;

    @Getter @Setter
    private ProductDTO product;

    @Getter @Setter
    private Integer amount;

    @Getter @Setter
    private Double subtotal;

    public OrderItemDTO() {
        this.setSubtotal(this.product.getPrice() * this.amount);
    }

}
