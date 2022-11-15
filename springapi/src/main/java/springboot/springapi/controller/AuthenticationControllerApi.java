package springboot.springapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.springapi.security.JWTUtil;
import springboot.springapi.service.impl.UserServiceImpl;
import springboot.springcore.dto.UserDTO;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerApi {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JWTUtil serviceJWT;
    private Logger logger = LoggerFactory.getLogger(AuthenticationControllerApi.class);

    @PostMapping("/signin") @SuppressWarnings("rawtypes")
    public ResponseEntity signin(@RequestBody UserDTO user) {
        UserDetails userDetails = userService.loadUserByUsername(user.getUserName());

        if (userDetails.getPassword().equals(user.getPassWord())) {
            String token = serviceJWT.generateToken(userDetails);
            logger.info("Login successfully performed!!");
            return ResponseEntity.ok(token);
        }

        logger.error("Invalid user or password.");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signup(@RequestBody UserDTO user) {
        if (user.getId() == 0) {
            userService.save(user);
            return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }
    
}
