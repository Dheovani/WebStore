package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.ItemDTO;
import springboot.springcore.entity.Item;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    List<ItemDTO> mapListOrderItem(List<Item> orderItem);
    List<Item> mapListOrderItemDTO(List<ItemDTO> orderItem);

    ItemDTO mapOrderItem(Item orderItem);
    Item mapOrderItemDTO(ItemDTO orderItem);
    
}
