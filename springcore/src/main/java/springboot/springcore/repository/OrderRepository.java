package springboot.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
