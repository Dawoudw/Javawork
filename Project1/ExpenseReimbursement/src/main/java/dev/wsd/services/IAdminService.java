package dev.wsd.services;

import java.sql.SQLException;

import dev.wsd.collections.*;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IAdminService extends IUserService {

	/**
	 * 
	 * @param user
	 */
	public User createUser(User user);

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
	public UserCredential logout(UserCredential usercerdenial);

	/**
	 * 
	 * @param user
	 */
	public boolean deleteUser(User user);

	/**
	 * 
	 * @param usercredential
	 * @param user
	 */
	public UserCredential userRegister(UserCredential usercredential, User user);

	public UserCollection<User> getAllUsers() throws SQLException;

	/**
	 * 
	 * @param user
	 * @throws SQLException 
	 */
	public User updateUser(User user) throws SQLException;

}