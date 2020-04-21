package dev.wsd.entities;

import java.util.Date;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class UserCredential extends User{

	private User user;
	private String loginName;
	private String password;
	private Date lastLogin;
	private boolean isActive;

	public UserCredential(){

	}

	public void finalize() throws Throwable {

	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	 

}