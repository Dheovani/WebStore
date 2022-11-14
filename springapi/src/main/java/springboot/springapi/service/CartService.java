package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.CartDTO;

public interface CartService {

    List<CartDTO> getAll();
    CartDTO save(CartDTO cart);
    CartDTO findById(Long id);
    CartDTO delete(Long id);
    
}
