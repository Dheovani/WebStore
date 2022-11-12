package springboot.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.springcore.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}
