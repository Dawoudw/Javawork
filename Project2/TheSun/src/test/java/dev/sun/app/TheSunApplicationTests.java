package dev.sun.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.sun.entities.Pizza;
import dev.sun.entities.Ticket;
import dev.sun.entities.User;
import dev.sun.entities.UserRole;
import dev.sun.repositories.PizzaRepository;
import dev.sun.repositories.TicketRepository;
import dev.sun.repositories.UserRepository;
import dev.sun.repositories.UserRoleRepository;

@SpringBootTest
@ContextConfiguration(classes = dev.sun.app.TheSunApplication.class)
class TheSunApplicationTests {

	@Autowired
	UserRepository ur;
	@Autowired
	UserRoleRepository urr;
	@Autowired
	TicketRepository tr;
	
	@Autowired
	PizzaRepository pr;
	
	@Test
	void getAllUsers() {
		
		System.out.println((List<User> ) ur.findAll());
	}
	
	
	@Test
	void getAllUserRoles() {
		
		System.out.println((List<UserRole> ) urr.findAll());
	}

	@Test
	void getAllTickets() {
		
		System.out.println((List<Ticket> ) tr.findAll());
	}
	
	@Test
	void getAllPizzas() {
		
		System.out.println((List<Pizza> ) pr.findAll());
	}
	
	@Test
	void getAllTicketsByUserId() {
		System.out.println(ur.findById(2).get());
	}
}

