package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.ClientService;
import springboot.springcore.dto.AddressDTO;
import springboot.springcore.dto.ClientDTO;
import springboot.springcore.entity.Address;
import springboot.springcore.entity.Client;
import springboot.springcore.mapper.AddressMapper;
import springboot.springcore.mapper.ClientMapper;
import springboot.springcore.repository.AddressRepository;
import springboot.springcore.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;
    private ClientMapper mapper = Mappers.getMapper(ClientMapper.class);

    @Autowired
    private AddressRepository addressRepository;
    private AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = repository.findAll();
        return mapper.mapListClient(clients);
    }

    @Override
    public ClientDTO save(ClientDTO client) {
        Client clientEntity = mapper.mapClientDTO(client);
        repository.save(clientEntity);
        
        return mapper.mapClient(clientEntity);
    }

    @Override
    public ClientDTO saveAddress(Long id, AddressDTO address) {
        Optional<Client> client = repository.findById(id);
        
        if (client.isPresent()) {
            Address addressEntity = addressMapper.mapAddressDTO(address);
            addressRepository.save(addressEntity);
            
            client.get().setAddress(addressEntity);
            repository.save(client.get());

            return mapper.mapClient(client.get());
        }

        return null;
    }


    @Override
    public ClientDTO findById(Long id) {
        Optional<Client> client = repository.findById(id);

        if (client.isPresent()) {
            return mapper.mapClient(client.get());
        }

        return null;
    }

    @Override
    public ClientDTO delete(Long id) {
        Optional<Client> client = repository.findById(id);

        if (client.isPresent()) {
            repository.delete(client.get());
        }

        return null;
    }

    @Override
    public List<ClientDTO> getByName(String name) {
        List<Client> clients = repository.findByNameIgnoreCaseContaining(name);
        return mapper.mapListClient(clients);
    }
    
}
