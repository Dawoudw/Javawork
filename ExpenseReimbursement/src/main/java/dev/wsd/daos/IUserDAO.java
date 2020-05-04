package dev.wsd.daos;
import java.sql.SQLException;

import dev.wsd.collections.*;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IUserDAO {
	/**
	 * 
	 * @param email
	 */
	public User getUserById(int id);

	/**
	 * 
	 * @param user
	 */
	public User createUser(User user);

	/**
	 * 
	 * @param user
	 */
 

	/**
	 * 
	 * @param user
	 * @throws SQLException 
	 */
	public User updateUser(User user) throws SQLException  ;

	public UserCollection<User> getAllUsers() throws SQLException;

	/**
	 * 
	 * @param password
	 * @param loginName
	 */
	public UserCredential userLogin(String password, String loginName);

	/**
	 * 
	 * @param usercredentials
	 * @param user
	 */
	public UserCredential userRegister(UserCredential usercredentials, User user);

	/**
	 * 
	 * @param user
	 * @param newPassword
	 * @param oldPassword
	 */
	public UserCredential changePassword(User user, String newPassword, String oldPassword);

	/**
	 * 
	 * @param loginname
	 */
	public UserCredentialCollection<UserCredential> getUserByLoginName(String loginname);

	/**
	 * 
	 * @param email
	 */
	public User getUserByEmail(String email);

	/**
	 * 
	 * @param phone
	 */
	public User getUserByPhone(String phone);

	boolean deleteUser(User user);

}