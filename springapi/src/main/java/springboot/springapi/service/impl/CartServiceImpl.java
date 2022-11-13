package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.CartService;
import springboot.springcore.entity.Cart;
import springboot.springcore.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;

    @Override
    public List<Cart> getAll() {
        return repository.findAll();
    }

    @Override
    public Cart save(Cart cart) {
        repository.save(cart);
        return cart;
    }

    @Override
    public Cart findById(Long id) {
        Optional<Cart> cart = repository.findById(id);

        if (cart.isPresent()) {
            return cart.get();
        }

        return null;
    }

    @Override
    public Cart delete(Long id) {
        Optional<Cart> cart = repository.findById(id);

        if (cart.isPresent()) {
            repository.delete(cart.get());
        }

        return null;
    }
    
}
