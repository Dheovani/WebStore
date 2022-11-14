package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.OrderItemService;
import springboot.springcore.dto.ItemDTO;
import springboot.springcore.entity.Item;
import springboot.springcore.mapper.OrderItemMapper;
import springboot.springcore.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository repository;
    OrderItemMapper mapper = Mappers.getMapper(OrderItemMapper.class);

    @Override
    public List<ItemDTO> getAll() {
        List<Item> items = repository.findAll();
        return mapper.mapListOrderItem(items);
    }

    @Override
    public ItemDTO save(ItemDTO orderItem) {
        Item item = mapper.mapOrderItemDTO(orderItem);
        repository.save(item);

        return mapper.mapOrderItem(item);
    }

    @Override
    public ItemDTO findById(Long id) {
        Optional<Item> item = repository.findById(id);

        if (item.isPresent()) {
            return mapper.mapOrderItem(item.get());
        }

        return null;
    }

    @Override
    public ItemDTO delete(Long id) {
        Optional<Item> item = repository.findById(id);

        if (item.isPresent()) {
            repository.delete(item.get());
        }

        return null;
    }
    
}
