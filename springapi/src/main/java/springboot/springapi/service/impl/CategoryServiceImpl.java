package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.CategoryService;
import springboot.springcore.entity.Category;
import springboot.springcore.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
        repository.save(category);
        return category;
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }

    @Override
    public Category delete(Long id) {
        Optional<Category> category = repository.findById(id);

        if (category.isPresent()) {
            repository.delete(category.get());
        }

        return null;
    }

    @Override
    public List<Category> getByCategory(String category) {
        return repository.findByCategoryIgnoreCaseContaining(category);
    }
    
}
