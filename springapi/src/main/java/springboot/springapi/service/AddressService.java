package springboot.springapi.service;

import java.util.List;

import springboot.springcore.entity.Address;

public interface AddressService {

    List<Address> getAll();
    Address save(Address address);
    Address findById(long id);
    Address delete(long id);
    
}
