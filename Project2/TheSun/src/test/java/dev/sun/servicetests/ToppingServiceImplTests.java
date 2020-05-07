package dev.sun.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.sun.entities.Topping;
import dev.sun.services.ToppingServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = dev.sun.app.TheSunApplication.class)
class ToppingServiceImplTests {
	
	@Autowired
	ToppingServiceImpl ts;

	@Test
	public void createTopping() {
		Topping topping = new Topping(0, "Banana", 0.99);
		ts.createTopping(topping);
	}
	
	@Test
	public void getAllToppings() {
		System.out.println(ts.getAllToppings());
	}
	
	@Test
	public void getToppingById() {
		System.out.println(ts.getToppingById(3));
	}
	
	@Test
	public void updateTopping() {
		Topping topping = ts.getToppingById(2);
		topping.setToppingCost(0.50);
		System.out.println(ts.updateTopping(topping));
	}
	
	@Test
	public void deleteTopping() {
		Topping topping = ts.getToppingById(2);
		System.out.println(ts.deleteTopping(topping));
	}

}
