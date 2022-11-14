package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.OrderItemDTO;

public interface OrderItemService {

    List<OrderItemDTO> getAll();
    OrderItemDTO save(OrderItemDTO orderItem);
    OrderItemDTO findById(Long id);
    OrderItemDTO delete(Long id);
    
}
