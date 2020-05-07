package dev.sun.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.sun.entities.ORDERSTATUS;
import dev.sun.entities.Pizza;
import dev.sun.entities.Ticket;
import dev.sun.entities.User;
import dev.sun.services.TicketServiceImpl;
import dev.sun.services.UserServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = dev.sun.app.TheSunApplication.class)
//@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceImplTest {

	@Autowired
	TicketServiceImpl ticketImpl;
	@Autowired
	UserServiceImpl usrImpl;
	static int newId;

	@Order(1)
	@Test
	void createTicket() {
		User u = usrImpl.getUserById(3);
		Ticket ticket = new Ticket();
		ticket.setNote("test pizza");
		ticket.setStatus(ORDERSTATUS.Submitted.name());
		ticket.setUser(u);
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now"
		Date now = calendar.getTime();
		// 3) a java current time (now) instance is the Local machine time , not the
		// server time .
		java.sql.Timestamp ptamp = new java.sql.Timestamp(now.getTime());
		ticket.setPlacementTime(ptamp);
		ticket = ticketImpl.createTicket(ticket);
		newId = ticket.getTicketId();
		System.out.println("NEW ID IS " + newId);
		System.out.println(ticket);

	}

	@Order(2)
	@Test
	void updateTicketStatus() {
		Ticket t1 = ticketImpl.updateStatus(1, ORDERSTATUS.InProgress.toString());
		System.out.println(t1);
	}

	@Order(3)
	@Test
	void updateTicketNote() {
		Ticket t = ticketImpl.updateNote(newId, "Add some more tomato sauce");
		System.out.println(t);
	}

	@Order(4)
	@Test
	void updateTicket() {
		Ticket t = ticketImpl.getTicketById(newId);
		t.setNote("Add some more chicken sauce");
		t.setStatus(ORDERSTATUS.OutForDelivery.toString());
		int s = ticketImpl.updateTicket(t);
		System.out.println("Update Result" + s);
		System.out.println(t);
	}

	@Order(5)
	@Test
	void deleteTicket() {
		boolean isDeleted = false;
		Ticket t = ticketImpl.getTicketById(newId);

		try {
			isDeleted = ticketImpl.deleteTicket(t);

		} catch (Exception e) {

			isDeleted = false;
		} finally {
			System.out.println("the Ticket with Id#" + newId + " is deleted = " + isDeleted);
		}

	}

	@Order(6)
	@Test
	void getAllTickets() {
		List<Ticket> list = ticketImpl.getAllTickets();
		System.out.println(list);
	}

	@Order(7)
	@Test
	void getTicketsByUserId() {
		List<Ticket> list = ticketImpl.getTicketsByUserId(3);
		System.out.println(list);
	}

	@Order(8)
	@Test
	void findTickePizzaByTicketId() {
		List<Pizza> list = ticketImpl.findTickePizzaByTicketId(3);
		System.out.println(list);
	}
}
