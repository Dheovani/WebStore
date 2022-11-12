package springboot.springcore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private OrderItem item;
    private Integer session;

    public Long getId() {
        return id;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }
    
}
