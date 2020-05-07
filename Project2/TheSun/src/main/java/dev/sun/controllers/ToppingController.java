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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import dev.sun.entities.Topping;
import dev.sun.services.ToppingService;

@Controller
@Component
@CrossOrigin(origins="*", allowedHeaders="*")
public class ToppingController {
	
	@Autowired
	ToppingService ts;
	
	@ResponseBody
	@RequestMapping(value = "/toppings" , method = RequestMethod.POST)
	public Topping createTopping(@RequestBody Topping topping) {
		
		return ts.createTopping(topping);
	}
	
	@ResponseBody
	@RequestMapping(value = "/toppings" , method = RequestMethod.GET)
	public List<Topping> getAllToppings() {
		
		return ts.getAllToppings();
	}
	
	@ResponseBody
	@RequestMapping(value = "/toppings/{id}" , method = RequestMethod.GET)
	public Topping getToppingById(@PathVariable int id) {
		
		try {
			Topping topping = ts.getToppingById(id);
			return topping;
		} catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find UserRole");
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/toppings" , method = RequestMethod.PUT)
	public Topping updateTopping(@RequestBody Topping topping) {
		
		return ts.updateTopping(topping);
	}
	
	@ResponseBody
	@RequestMapping(value = "/toppings" , method = RequestMethod.DELETE)
	public boolean deleteTopping(@RequestBody Topping topping) {
		boolean result = ts.deleteTopping(topping);
		if(result == false ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
		return result;
	}
	
	

}
