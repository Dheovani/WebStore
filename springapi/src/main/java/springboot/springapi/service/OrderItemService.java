package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.ItemDTO;

public interface OrderItemService {

    List<ItemDTO> getAll();
    ItemDTO save(ItemDTO orderItem);
    ItemDTO findById(Long id);
    ItemDTO delete(Long id);
    
}
