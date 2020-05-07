package dev.sun.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.sun.entities.Pizza;

@Component
@Repository
public interface PizzaRepository  extends CrudRepository<Pizza, Integer>{

}
