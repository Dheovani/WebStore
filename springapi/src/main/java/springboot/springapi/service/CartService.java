package springboot.springapi.service;

import java.util.List;

import springboot.springcore.entity.Cart;

public interface CartService {

    List<Cart> getAll();
    Cart save(Cart cart);
    Cart findById(Long id);
    Cart delete(Long id);
    
}
