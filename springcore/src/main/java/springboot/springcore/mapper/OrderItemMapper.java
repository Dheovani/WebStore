package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.OrderItemDTO;
import springboot.springcore.entity.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    List<OrderItemDTO> mapListOrderItem(OrderItem orderItem);
    List<OrderItem> mapListOrderItemDTO(OrderItemDTO orderItem);

    OrderItemDTO mapOrderItem(OrderItem orderItem);
    OrderItem mapOrderItemDTO(OrderItemDTO orderItem);
    
}
