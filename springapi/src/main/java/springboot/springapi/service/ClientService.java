package springboot.springapi.service;

import java.util.List;

import springboot.springcore.entity.Address;
import springboot.springcore.entity.Client;

public interface ClientService {

    List<Client> getAll();
    Client save(Client client);
    Client saveAddress(Long id, Address address);
    Client findById(Long id);
    Client delete(Long id);
    List<Client> getByName(String name);
    
}
