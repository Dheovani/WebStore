package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.CategoryDTO;
import springboot.springcore.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    List<CategoryDTO> mapListCategory(List<Category> category);
    List<Category> mapListCategoryDTO(List<CategoryDTO> category);

    CategoryDTO mapCategory(Category category);
    Category mapCategoryDTO(CategoryDTO category);

}
