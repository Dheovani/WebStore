package springboot.springapi.service.impl;

import java.util.ArrayList;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springboot.springapi.service.UserService;
import springboot.springcore.dto.UserDTO;
import springboot.springcore.mapper.UserMapper;
import springboot.springcore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository repository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = repository.findByUser(username);

        if (userEntity.isPresent()) {
            var user = userEntity.get();
            return new User(user.getUserName(), user.getPassWord(), new ArrayList<>());
        }

        return null;
    }

    @Override
    public UserDTO save(UserDTO user) {
        var userEntity = mapper.mapUserDTO(user);
        repository.save(userEntity);

        return mapper.mapUser(userEntity);
    }

    @Override
    public UserDTO delete(Long id) {
        var user = repository.findById(id);

        if (user.isPresent()) {
            repository.delete(user.get());
        }

        return null;
    }
    
}
