package dev.wsd.daos;
import dev.wsd.collections.*;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IAccountTransDAO {

	/**
	 * 
	 * @param transObj
	 */
	public AccountTransaction addTransaction(AccountTransaction transObj);

	/**
	 * 
	 * @param userId
	 */
	public AccountTransCollection<AccountTransaction> viewUserTransactions(int userid);

 

 

}