package springboot.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {}
