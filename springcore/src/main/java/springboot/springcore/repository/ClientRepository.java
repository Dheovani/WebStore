package springboot.springcore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNameIgnoreCaseContaining(@Param("name") String name);
    
}
