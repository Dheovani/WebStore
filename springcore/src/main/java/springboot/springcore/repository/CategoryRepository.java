package springboot.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByCategoryIgnoreCaseContaining(@Param("category") String category);
    
}
