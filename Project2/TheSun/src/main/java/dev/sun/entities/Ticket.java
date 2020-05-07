package dev.sun.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticketId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "placement_time")
	private Timestamp placementTime;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "note")
	private String note;
	
 
	@OneToMany(mappedBy = "ticket" , fetch = FetchType.EAGER)
	private Set<Pizza> pizzas = new HashSet<Pizza>();

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, User user, Timestamp placementTime, String status, String note) {
		super();
		this.ticketId = ticketId;
		this.user = user;
		this.placementTime = placementTime;
		this.status = status;
		this.note = note;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getPlacementTime() {
		return placementTime;
	}

	public void setPlacementTime(Timestamp placementTime) {
		this.placementTime = placementTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", user=" + user.getUserId() + ", placementTime=" + placementTime + ", status="
				+ status + ", note=" + note + ", pizzas=" + pizzas.toString() + "]";
	}



}
