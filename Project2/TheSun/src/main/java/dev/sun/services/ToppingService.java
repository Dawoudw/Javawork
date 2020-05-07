package dev.sun.services;

import java.util.List;

import dev.sun.entities.Topping;

public interface ToppingService {

	Topping createTopping(Topping topping);
	List<Topping> getAllToppings();
	Topping getToppingById(int id);
	Topping updateTopping(Topping topping);
	boolean deleteTopping(Topping topping);
}
