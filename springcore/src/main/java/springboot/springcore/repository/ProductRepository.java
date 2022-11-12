package springboot.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductIgnoreCaseContaining(@Param("userName") String product);
    
}
