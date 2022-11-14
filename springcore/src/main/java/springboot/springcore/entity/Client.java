package springboot.springcore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(length = 100)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @OneToOne(
        mappedBy = "client",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @Getter @Setter
    private Address address;
    
}
