package springboot.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Item;

@Repository
public interface OrderItemRepository extends JpaRepository<Item, Long> {}
