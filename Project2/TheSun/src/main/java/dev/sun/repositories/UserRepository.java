package dev.sun.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.sun.entities.User;

@Component
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUserName(String userName);
	
}
