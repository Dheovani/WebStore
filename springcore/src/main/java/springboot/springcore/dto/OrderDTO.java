package springboot.springcore.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class OrderDTO {

    @Getter
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date orderDate;

    @Getter @Setter
    private Long clientId;

    @Getter @Setter
    private ClientDTO client;
    
    @Getter @Setter
    private OrderStatus orderStatus;
    
    @Getter @Setter
    private Integer session;
    
}
