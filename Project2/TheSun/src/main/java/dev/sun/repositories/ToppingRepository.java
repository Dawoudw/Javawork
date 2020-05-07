package dev.sun.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.sun.entities.Topping;

@Component
@Repository
public interface ToppingRepository extends CrudRepository<Topping, Integer> {

}
