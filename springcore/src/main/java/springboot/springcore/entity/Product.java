package springboot.springcore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @Getter @Setter
    private Category category;

    @Column(length = 50)
    @Getter @Setter
    private String product;

    @Column(length = 500)
    @Getter @Setter
    private String description;

    @Getter @Setter
    private String foto;

    @Getter @Setter
    private Double price;
        
}
