package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.ProductService;
import springboot.springcore.dto.ProductDTO;
import springboot.springcore.entity.Product;
import springboot.springcore.mapper.ProductMapper;
import springboot.springcore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
        return mapper.mapListProduct(products);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product productEntity = mapper.mapProductDTO(product);
        repository.save(productEntity);

        return mapper.mapProduct(productEntity);
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            return mapper.mapProduct(product.get());
        }

        return null;
    }

    @Override
    public ProductDTO delete(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()) {
            repository.delete(product.get());
        }

        return null;
    }
    
}
