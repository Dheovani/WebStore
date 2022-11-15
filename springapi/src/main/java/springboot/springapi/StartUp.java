package springboot.springapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import springboot.springcore.entity.User;
import springboot.springcore.repository.UserRepository;

public class StartUp {

    @Autowired
    private UserRepository repository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!repository.findByUser("admin").isPresent()) {
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassWord("admin");
            repository.save(admin);
        }
    }
    
}
