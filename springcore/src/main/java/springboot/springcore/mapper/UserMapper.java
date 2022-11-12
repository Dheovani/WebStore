package springboot.springcore.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import springboot.springcore.dto.UserDTO;
import springboot.springcore.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDTO> mapListUser(User user);
    List<User> mapListUserDTO(UserDTO user);

    UserDTO mapUser(User user);
    User mapUserDTO(UserDTO user);
    
}
