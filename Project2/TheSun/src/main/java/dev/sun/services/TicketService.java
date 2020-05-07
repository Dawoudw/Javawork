package dev.sun.services;

import java.sql.Timestamp;
import java.util.List;

import dev.sun.entities.ORDERSTATUS;
import dev.sun.entities.Pizza;
import dev.sun.entities.Ticket;

public interface TicketService {
	List<Ticket> getAllTickets();

	Ticket createTicket(Ticket ticket);

	Ticket getTicketById(int id);

	int updateTicket(Ticket ticket);

	boolean deleteTicket(Ticket ticket);

	Ticket updateNote(int id, String notes);

	List<Ticket> getTicketsByUserId(int userId);

	List<Pizza> findTickePizzaByTicketId(int ticketId);

	Ticket updateStatus(int id, String status);
}
