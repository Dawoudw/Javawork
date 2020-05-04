package dev.wsd.entities;

import java.util.Date;

import dev.wsd.utils.PrintUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class User {

	private int id;
	private String fname;
	private String lname;
	private Date dob;
	private String email;
	private boolean isAdmin;

	public User() {
	}

	public User(User user) {

		this.id = user.getId();
		this.fname = user.getFname();
		this.lname = user.getLname();
		this.dob = user.getDob();
		this.email = user.getEmail();
		this.isAdmin = user.isAdmin();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void finalize() throws Throwable {

	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void printOptions() {
		if (this != null) {

			PrintUtil.drawHyphenLn();

			PrintUtil.printLine("[User ID: " + this.getId() + " | First Name: " + this.getFname() + " | Last Name: "
					+ this.getLname() + " | Email:" + this.getEmail() + " | Is Admin:" + this.isAdmin() + " ]");
			PrintUtil.drawHyphenLn();

		}
	}

	@Override
	public String toString() {
		String S = "";
		if (this != null) {

			S = ("[User ID: " + this.getId() + " | First Name: " + this.getFname() + " | Last Name: " + this.getLname()
					+ " | Email:" + this.getEmail() + " | Is Admin:" + this.isAdmin() + " ]");

		}
		return S;
	}
}