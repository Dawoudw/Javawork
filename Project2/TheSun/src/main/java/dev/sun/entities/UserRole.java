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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role_title")
	private String roleTitle;
	
//	@OneToMany(mappedBy = "user_role", fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
//	Set<User> users = new HashSet<User>();
	public UserRole(int roleId, String roleTitle) {
		super();
		this.roleId = roleId;
		this.roleTitle = roleTitle;
	}
	public UserRole() {
		super();
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roletTitle=" + roleTitle + "]";
	}
	
	
	
	
	

}
