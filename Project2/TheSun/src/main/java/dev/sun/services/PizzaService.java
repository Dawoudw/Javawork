package dev.sun.services;

import java.util.List;

import dev.sun.entities.Pizza;

public interface PizzaService {


	Pizza createPizza(Pizza pizza);
	
	Pizza getPizzaById(int id);
	List<Pizza> getAllPizzas();
	//Associate getAssociateByPoints();
	
	Pizza updatePizza(Pizza associate);
	
	boolean deletePizza(Pizza associate);

	//Pizza getMostPopularToppings();
	
	//List<Pizza> findAssociatesInPointRange(int min, int max);
}
