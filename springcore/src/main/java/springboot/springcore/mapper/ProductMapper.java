package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.ProductDTO;
import springboot.springcore.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductDTO> mapListProduct(Product product);
    List<Product> mapListProductDTO(ProductDTO product);

    ProductDTO mapProduct(Product product);
    Product mapProductDTO(ProductDTO product);
    
}
