package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.AddressDTO;
import springboot.springcore.entity.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    List<AddressDTO> mapListAddress(List<Address> address);
    List<Address> mapListAddressDTO(List<AddressDTO> address);

    AddressDTO mapAddress(Address address);
    Address mapAddressDTO(AddressDTO address);

}
