package dev.wsd.services;
import dev.wsd.entities.UserCredential;

import java.sql.SQLException;

import dev.wsd.entities.User;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IUserService {

	/**
	 * 
	 * @param password
	 * @param loginname
	 */
	public UserCredential login(String password, String loginname);

	/**
	 * 
	 * @param usercerdenial
	 */
	public UserCredential  logout(UserCredential usercerdenial);

	/**
	 * 
	 * @param usercredential
	 * @param user
	 */
	public UserCredential userRegister(UserCredential usercredential, User user);

	/**
	 * 
	 * @param user
	 * @throws SQLException 
	 */
	public User updateUser(User user) throws SQLException;

}