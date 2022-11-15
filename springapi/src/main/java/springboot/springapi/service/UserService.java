package springboot.springapi.service;

import springboot.springcore.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO product);
    UserDTO delete(Long id);
    
}
