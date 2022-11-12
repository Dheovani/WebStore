package springboot.springcore.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import springboot.springcore.entity.OrderItem;

public class CartDTO {

    private Long id;
    private Long orderId;
    private List<OrderItem> items;

    @NotNull
    private Integer session;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }
    
}
