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

import dev.sun.entities.Pizza;
import dev.sun.entities.Ticket;
import dev.sun.services.TicketServiceImpl;

@Controller
@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TicketController {

	@Autowired
	TicketServiceImpl ticketImpl;

//1- Create Ticket
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.POST)
	Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketImpl.createTicket(ticket);
	}

//2- Get Ticket By ID
	@ResponseBody
	@RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
	public Ticket getTicketById(@PathVariable Integer id) {
		try {
			return ticketImpl.getTicketById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect Ticket Number");
		}
	}

//3- Get All Tickets 
	@ResponseBody
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getAllTickets() {
		return ticketImpl.getAllTickets();
	}

//4- Update Ticket
	@ResponseBody
	@RequestMapping(value = "ticktes", method = RequestMethod.PUT)
	public int updateTicket(@RequestBody Ticket ticket) {
		try {
			return ticketImpl.updateTicket(ticket);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Update Ticket Faild");
		}
	}

//5- Update Note 
	@ResponseBody
	@RequestMapping(value = "ticktes/editnote", method = RequestMethod.PUT)
	public Ticket updateTicketNote(@RequestBody Ticket tickt) {
		try {
			return ticketImpl.updateNote(tickt.getTicketId(), tickt.getNote());
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Update Ticket Note Faild");
		}
	}

//6- Update Status
	@ResponseBody
	@RequestMapping(value = "ticktes/editstatus", method = RequestMethod.PUT)
	public Ticket updateTicketStatus(@RequestBody Ticket tickt) {
		try {

			return ticketImpl.updateStatus(tickt.getTicketId(), tickt.getStatus());
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Update Ticket Status Faild");
		}
	}
//7- Get Tickets By User Id

	@ResponseBody
	@RequestMapping(value = "/tickets/usertickets/{userid}", method = RequestMethod.GET)
	public List<Ticket> getTicketsByUserId(@PathVariable Integer userid) {
		try {
			return ticketImpl.getTicketsByUserId(userid);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect User Number");
		}
	}
	@ResponseBody
	@RequestMapping(value = "/tickets/details/{tid}", method = RequestMethod.GET)
	public List<Pizza> getTicketDetailsById(@PathVariable Integer tid) {
		try {
			return ticketImpl.findTickePizzaByTicketId(tid);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect User Number");
		}
	}
}
