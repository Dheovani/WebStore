package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.CartService;
import springboot.springcore.dto.CartDTO;
import springboot.springcore.entity.Cart;
import springboot.springcore.mapper.CartMapper;
import springboot.springcore.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;
    CartMapper mapper = Mappers.getMapper(CartMapper.class);

    @Override
    public List<CartDTO> getAll() {
        List<Cart> cart = repository.findAll();
        return mapper.mapListCart(cart);
    }

    @Override
    public CartDTO save(CartDTO cart) {
        Cart cartEntity = mapper.mapCartDTO(cart);
        repository.save(cartEntity);

        return mapper.mapCart(cartEntity);
    }

    @Override
    public CartDTO findById(Long id) {
        Optional<Cart> cart = repository.findById(id);

        if (cart.isPresent()) {
            return mapper.mapCart(cart.get());
        }

        return null;
    }

    @Override
    public CartDTO delete(Long id) {
        Optional<Cart> cart = repository.findById(id);

        if (cart.isPresent()) {
            repository.delete(cart.get());
        }

        return null;
    }
    
}
