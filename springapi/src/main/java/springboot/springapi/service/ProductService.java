package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.ProductDTO;

public interface ProductService {

    List<ProductDTO> getAll();
    ProductDTO save(ProductDTO product);
    ProductDTO findById(Long id);
    ProductDTO delete(Long id);
    
}
