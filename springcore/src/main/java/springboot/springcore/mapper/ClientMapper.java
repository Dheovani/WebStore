package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.ClientDTO;
import springboot.springcore.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    List<ClientDTO> mapListClient(List<Client> client);
    List<Client> mapListClientDTO(List<ClientDTO> client);

    ClientDTO mapClient(Client client);
    Client mapClientDTO(ClientDTO client);
    
}
