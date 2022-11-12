package springboot.springcore.dto;

public enum OrderStatus {

    DENIED(-1),
    CANCELED(0),
    WAITING_FOR_PAYMENT(1),
    PAYMENT_APROVED(2),
    FINISHED(3);

    private Integer status;

    private OrderStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }
    
}
