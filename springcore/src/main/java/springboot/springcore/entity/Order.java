package springboot.springcore.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import springboot.springcore.dto.OrderStatus;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Temporal(value = TemporalType.DATE)
    @Getter @Setter
    private Date orderDate;
    
    @OneToOne(
        mappedBy = "client",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @Getter @Setter
    private Client client;

    @Getter @Setter
    private OrderStatus status;

    @Getter @Setter
    private Integer session;
    
}
