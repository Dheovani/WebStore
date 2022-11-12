package springboot.springcore.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderDTO {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    private Long clientId;
    private ClientDTO client;
    private OrderStatus orderStatus;
    private Integer session;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public Long getClientId() {
        return clientId;
    }
    
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public ClientDTO getClient() {
        return client;
    }
    
    public void setClient(ClientDTO client) {
        this.client = client;
    }
    
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public Integer getSession() {
        return session;
    }
    
    public void setSession(Integer session) {
        this.session = session;
    }
    
}
