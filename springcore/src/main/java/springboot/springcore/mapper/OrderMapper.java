package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.OrderDTO;
import springboot.springcore.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    
    List<OrderDTO> mapListOrder(List<Order> order);
    List<Order> mapListOrderDTO(List<OrderDTO> order);

    OrderDTO mapOrder(Order order);
    Order mapOrderDTO(OrderDTO order);

}
