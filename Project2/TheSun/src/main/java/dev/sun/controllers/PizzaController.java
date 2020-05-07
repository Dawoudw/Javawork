package dev.sun.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import dev.sun.entities.Pizza;
import dev.sun.services.PizzaService;

@Component
@Controller
public class PizzaController {

	@Autowired //to call AssociateService here.
	PizzaService ps;
	
	//Create Pizza
	@RequestMapping(value="/pizzas", method= RequestMethod.POST)
	@ResponseBody
	public Pizza createPizza(@RequestBody Pizza pizza) {
		return ps.createPizza(pizza);
	}
	
	//Read All pizzas
	@RequestMapping(value="/pizzas", method = RequestMethod.GET)
	@ResponseBody 
	public List<Pizza> getAllPizzas() {
		return ps.getAllPizzas();
	}
	
	
	//Read pizza by Id
	@ResponseBody
	@RequestMapping(value="/pizzas/{id}", method = RequestMethod.GET)
	public Pizza getPizzaById(@PathVariable int id) {
	  try {
		return ps.getPizzaById(id);
	  }catch (NoSuchElementException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not Find Pizza");
	    }
	}
	
	//Update Pizza
	@RequestMapping(value="/pizzas", method = RequestMethod.PUT)
	@ResponseBody
	public Pizza updatePizza(@RequestBody Pizza pizza) {
		return ps.updatePizza(pizza);
	}

	//Delete Pizza
	@RequestMapping(value = "/pizzas", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePizza(@RequestBody Pizza pizza) { //void since we can just return status 200 saying success
	  boolean result=ps.deletePizza(pizza);
	  
	  if(result==false) {
		  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not find Request");
	  }
	}
	
		
}
