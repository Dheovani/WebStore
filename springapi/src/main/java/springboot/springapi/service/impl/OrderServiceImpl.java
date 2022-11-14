package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.OrderService;
import springboot.springcore.dto.OrderDTO;
import springboot.springcore.entity.Order;
import springboot.springcore.mapper.OrderMapper;
import springboot.springcore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;
    OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = repository.findAll();
        return mapper.mapListOrder(orders);
    }

    @Override
    public OrderDTO save(OrderDTO order) {
        Order orderEntity = mapper.mapOrderDTO(order);
        repository.save(orderEntity);

        return mapper.mapOrder(orderEntity);
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> order = repository.findById(id);

        if (order.isPresent()) {
            return mapper.mapOrder(order.get());
        }

        return null;
    }

    @Override
    public OrderDTO delete(Long id) {
        Optional<Order> order = repository.findById(id);

        if (order.isPresent()) {
            repository.delete(order.get());
        }

        return null;
    }
    
}
