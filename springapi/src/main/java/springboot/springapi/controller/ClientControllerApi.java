package springboot.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.springapi.service.impl.ClientServiceImpl;
import springboot.springcore.dto.AddressDTO;
import springboot.springcore.dto.ClientDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/user")
public class ClientControllerApi {

    @Autowired
    private ClientServiceImpl service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<ClientDTO> clients = service.getAll();
        return new ResponseEntity<List<ClientDTO>>(clients, HttpStatus.OK);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<ClientDTO>> getByName(@PathVariable("name") String name) {
        List<ClientDTO> client = service.getByName(null);
        return new ResponseEntity<List<ClientDTO>>(client, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable("id") Long id) {
        ClientDTO client = service.findById(id);
        return new ResponseEntity<ClientDTO>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insertClient(@RequestBody ClientDTO client) {
        if (client.getId() == 0) {
            service.save(client);

            AddressDTO address = client.getAddress();
            service.saveAddress(client.getId(), address);

            return new ResponseEntity<ClientDTO>(client, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(
        @RequestBody ClientDTO client,
        @PathVariable("id") Long id
    ) {
        ClientDTO clientEntity = service.findById(id);

        if (clientEntity != null) {
            clientEntity.setAddress(client.getAddress());
            clientEntity.setAddressId(client.getAddressId());
            clientEntity.setEmail(client.getEmail());
            clientEntity.setName(client.getName());

            return new ResponseEntity<ClientDTO>(clientEntity, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable("id") Long id) {
        ClientDTO client = service.findById(id);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return ResponseEntity.accepted().build();
    }
    
}
