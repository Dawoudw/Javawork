package dev.sun.entities;

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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private UserRole userRole;

	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public User() {
		super();
	}

	public User(int userId, String userName, String password, UserRole userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userRole=" + userRole.toString()
				+ ", tickets=" + tickets.toString() + "]";
	}



}
