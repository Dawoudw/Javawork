package dev.sun.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.sun.entities.UserRole;

@Component
@Repository
public interface UserRoleRepository  extends CrudRepository<UserRole, Integer>{

}
