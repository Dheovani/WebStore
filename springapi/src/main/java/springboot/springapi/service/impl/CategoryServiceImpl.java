package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.CategoryService;
import springboot.springcore.dto.CategoryDTO;
import springboot.springcore.entity.Category;
import springboot.springcore.mapper.CategoryMapper;
import springboot.springcore.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;
    CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> category = repository.findAll();
        return mapper.mapListCategory(category);
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        Category categoryEntity = mapper.mapCategoryDTO(category);
        repository.save(categoryEntity);

        return mapper.mapCategory(categoryEntity);
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            return mapper.mapCategory(category.get());
        }

        return null;
    }

    @Override
    public CategoryDTO delete(Long id) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            repository.delete(category.get());
        }

        return null;
    }

    @Override
    public List<CategoryDTO> getByCategory(String category) {
        List<Category> categories = repository.findByCategoryIgnoreCaseContaining(category);
        return mapper.mapListCategory(categories);
    }
    
}
