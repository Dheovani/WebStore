package springboot.springcore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @Getter @Setter
    private Order order;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @Getter @Setter
    private Product product;

    @Getter @Setter
    private Integer amount;

    @Getter @Setter
    private Double subtotal;
        
}
