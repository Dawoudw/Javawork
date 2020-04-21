package dev.wsd.services;

import dev.wsd.collections.*;
import dev.wsd.entities.*;


/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public interface IDataService {

	public AccountTypeCollection<AccountType> getAccountTypes();

	public TransTypeCollection<TransactionType> getTransactionTypes() ;
	
	public  AccountType  getAccountTypeById(int id);

	public  TransactionType getTransactionTypeById(int id) ;
	

}