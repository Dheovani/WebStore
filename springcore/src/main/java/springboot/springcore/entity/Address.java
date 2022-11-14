package springboot.springcore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(length = 50)
    @Getter @Setter
    private String street;

    @Column(length = 20)
    @Getter @Setter
    private String city;

    @Getter @Setter
    private String zipCode;

    @Getter @Setter
    private String state;

}
