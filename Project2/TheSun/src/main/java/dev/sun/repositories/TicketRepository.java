package dev.sun.repositories;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sun.entities.Pizza;
import dev.sun.entities.Ticket;

@Component
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {
	@Modifying
	@Transactional
	@Query("update Ticket t  set t.status = :status  ,  t.placementTime = :pTime where t.ticketId = :id")
	public void updateTicketStatus(@Param("id") int id, @Param("status") String status,
			@Param("pTime") Timestamp placementTime);

	@Modifying
	@Transactional
	@Query("update Ticket t  set t.note = :note  ,  t.placementTime = :pTime where t.ticketId = :id")
	public void updateTicketNote(@Param("id") int id, @Param("note") String note,
			@Param("pTime") Timestamp placementTime);

	@Modifying
	@Transactional
	@Query("update Ticket t set t.placementTime = :pTime , t.status = :status , t.note = :note   where t.ticketId = :id")
	public Integer updateTicket(@Param("id") int id, @Param("pTime") Timestamp placementTime, @Param("status") String status, @Param("note") String note);

	public final static String FIND_WITH_DESC_QUERY = "SELECT t ,u.userId FROM Ticket t  INNER  JOIN t.user u  WHERE  u.userId =  :id";
	@Query(FIND_WITH_DESC_QUERY)
	public List<Ticket> findTicketsByUserId(@Param("id") int userId);
	
	public final static String GET_TICKET_PIZZA= "SELECT p  ,t.ticketId FROM Pizza p  INNER  JOIN p.ticket t  WHERE  t.ticketId =  :id";
	@Query(GET_TICKET_PIZZA)
	public List<Pizza> findTickePizzaByTicketId(@Param("id") int ticketId);
	
//	public final static String GET_TICKET_TOPPING = "SELECT tp  ,p.pizzaId FROM Topping tp  INNER  JOIN tp.pizza p  WHERE  p.pizzaId =  :id";
//	@Query(GET_TICKET_TOPPING)
//	public List<Pizza> findTickeToppingByPizzaId(@Param("id") int ticketId);

}
