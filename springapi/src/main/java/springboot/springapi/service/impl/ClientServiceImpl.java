package springboot.springapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.springapi.service.ClientService;
import springboot.springcore.entity.Address;
import springboot.springcore.entity.Client;
import springboot.springcore.repository.AddressRepository;
import springboot.springcore.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client save(Client client) {
        repository.save(client);
        return client;
    }

    @Override
    public Client saveAddress(Long id, Address address) {
        Optional<Client> client = repository.findById(id);
        
        if (client.isPresent()) {
            addressRepository.save(address);
            
            client.get().setAddress(address);
            repository.save(client.get());
        }

        return null;
    }


    @Override
    public Client findById(Long id) {
        Optional<Client> client = repository.findById(id);

        if (client.isPresent()) {
            return client.get();
        }

        return null;
    }

    @Override
    public Client delete(Long id) {
        Optional<Client> client = repository.findById(id);

        if (client.isPresent()) {
            repository.delete(client.get());
        }

        return null;
    }

    @Override
    public List<Client> getByName(String name) {
        return repository.findByNameIgnoreCaseContaining(name);
    }
    
}
