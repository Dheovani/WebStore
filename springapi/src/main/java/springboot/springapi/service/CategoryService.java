package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.CategoryDTO;

public interface CategoryService {

    List<CategoryDTO> getAll();
    CategoryDTO save(CategoryDTO category);
    CategoryDTO findById(Long id);
    CategoryDTO delete(Long id);
    List<CategoryDTO> getByCategory(String category);
    
}
