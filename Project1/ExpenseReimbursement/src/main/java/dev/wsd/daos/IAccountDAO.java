package dev.wsd.daos;
import dev.wsd.collections.*;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IAccountDAO {

	/**
	 * 
	 * @param userAccount
	 */
	public UserAccount openAccount(UserAccount userAccount);

	/**
	 * 
	 * @param userAccount
	 */
	public UserAccount closeAccount(UserAccount userAccount);

	/**
	 * 
	 * @param userAccount
	 */
	public UserAccount updateAccount(UserAccount userAccount);

	/**
	 * 
	 * @param val
	 */
	public int updateAccountBalance(float val , int accountId);

	/**
	 * 
	 * @param userid
	 */
	public UserAccountCollection<UserAccount> getAccountsByUserId(int userid);

	/**
	 * 
	 * @param accountId
	 */
	public UserAccount getAccountById(int accountId);

	/**
	 * 
	 * @param accountNum
	 */
	public UserAccount getUserByAccountNum(String accountNum);

}