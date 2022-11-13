package springboot.springapi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springboot.springcore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userEntity = repository.findByUser(username);

        if (userEntity.isPresent()) {
            var user = userEntity.get();
            return new User(user.getUserName(), user.getPassWord(), new ArrayList<>());
        }

        return null;
    }
    
}
