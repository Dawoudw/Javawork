package dev.wsd.collections;

import java.util.ArrayList;

import dev.wsd.entities.*;
import dev.wsd.utils.PrintUtil;

/**
 * User Collection Type extends ArrayList
 * 
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class UserCollection<T> extends ArrayList<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCollection() {

	}

	public void printOptions() {
		if (this != null) {
			PrintUtil.drawUnderscoreLn();
			PrintUtil.printLine("List of All Registred Users ");
			PrintUtil.drawUnderscoreLn();
		
			for (User tr : this) {
				PrintUtil.printLine("[User ID: " + tr.getId() + " | First Name: " + tr.getFname() + " | Last Name: "
						+ tr.getLname() + " | Email:" + tr.getEmail() + " | Is Admin:" + tr.isAdmin() + " ]");
				PrintUtil.drawHyphenLn();
			}
			PrintUtil.drawUnderscoreLn();
		}
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}