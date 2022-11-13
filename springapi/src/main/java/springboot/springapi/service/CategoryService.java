package springboot.springapi.service;

import java.util.List;

import springboot.springcore.entity.Category;

public interface CategoryService {

    List<Category> getAll();
    Category save(Category category);
    Category findById(Long id);
    Category delete(Long id);
    List<Category> getByCategory(String category);
    
}
