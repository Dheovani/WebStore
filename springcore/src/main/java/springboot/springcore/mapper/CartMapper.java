package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.CartDTO;
import springboot.springcore.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {
    
    List<CartDTO> mapListCart(List<Cart> cart);
    List<Cart> mapListCartDTO(List<CartDTO> cart);

    CartDTO mapCart(Cart cart);
    Cart mapCartDTO(CartDTO cart);
    
}
