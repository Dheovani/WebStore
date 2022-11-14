package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.OrderDTO;

public interface OrderService {

    List<OrderDTO> getAll();
    OrderDTO save(OrderDTO order);
    OrderDTO findById(Long id);
    OrderDTO delete(Long id);
    
}
