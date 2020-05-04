package dev.wsd.services;
import dev.wsd.collections.*;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IClientService extends IUserService {

	/**
	 * 
	 * @param password
	 * @param loginname
	 */
	public UserCredential login(String password, String loginname);

	/**
	 * 
	 * @param account
	 */
	public UserAccount openAccount(UserAccount account);

	/**
	 * 
	 * @param account
	 */
	public boolean closeAccount(UserAccount account);

	/**
	 * 
	 * @param usercerdenial
	 * @return 
	 */
	public UserCredential logout(UserCredential usercerdenial);

	/**
	 * 
	 * @param transaction
	 */
	public AccountTransaction addTransaction(AccountTransaction transaction);

	/**
	 * 
	 * @param usercredential
	 * @param user
	 */
	public UserCredential userRegister(UserCredential usercredential, User user);

	/**
	 * 
	 * @param user
	 */
	public User updateUser(User user);

	/**
	 * 
	 * @param userid
	 */
	public AccountTransCollection<AccountTransaction>  viewTransaction(int userid);

	/**
	 * to check the accounts info and balance
	 * 
	 * @param userId
	 */
	public UserAccountCollection<UserAccount> getAccountInfoByUserId(int userId);

}