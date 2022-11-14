package springboot.springapi.service;

import java.util.List;

import springboot.springcore.dto.AddressDTO;
import springboot.springcore.dto.ClientDTO;

public interface ClientService {

    List<ClientDTO> getAll();
    ClientDTO save(ClientDTO client);
    ClientDTO saveAddress(Long id, AddressDTO address);
    ClientDTO findById(Long id);
    ClientDTO delete(Long id);
    List<ClientDTO> getByName(String name);
    
}
