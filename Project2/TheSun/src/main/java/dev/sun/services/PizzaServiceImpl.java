package dev.sun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.sun.entities.Pizza;
import dev.sun.repositories.PizzaRepository;

@Component
@Service
public class PizzaServiceImpl implements PizzaService{

	 @Autowired
	 PizzaRepository pr;
	 
	@Override
	public Pizza createPizza(Pizza pizza) {
		pizza=pr.save(pizza);
		return pizza;
	}

	@Override
	public Pizza getPizzaById(int id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Pizza> getAllPizzas() {
		List<Pizza> pizzas=(List<Pizza>) pr.findAll();
		return pizzas;				
	}

	@Override
	public Pizza updatePizza(Pizza pizza) {
		return pr.save(pizza);
	}

	@Override
	public boolean deletePizza(Pizza pizza) {
		pr.delete(pizza);
		return true;
	}

	/*
	 * @Override public Pizza getMostPopularToppings() { Topping }
	 */

}
