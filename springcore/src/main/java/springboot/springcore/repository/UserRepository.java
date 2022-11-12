package springboot.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserNameIgnoreCaseContaining(@Param("userName") String userName);
    
}
