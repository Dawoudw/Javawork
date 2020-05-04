package dev.wsd.services;

import java.util.ArrayList;

import dev.wsd.collections.AccountTypeCollection;
import dev.wsd.collections.TransTypeCollection;
import dev.wsd.daos.DataDAO;
import dev.wsd.entities.AccountType;
import dev.wsd.entities.Department;
import dev.wsd.entities.TransactionType;

public class DataService {

	public static IDataService DataServiceOperaion = new IDataService() {
		
		@Override
		public TransTypeCollection<TransactionType> getTransactionTypes() {
			// TODO Auto-generated method stub
			return  DataDAO.DataServiceImplementaion.getTransactionTypes();
		}
		
		@Override
		public TransactionType getTransactionTypeById(int id) {
			// TODO Auto-generated method stub
			return DataDAO.DataServiceImplementaion.getTransactionTypeById(id);
		}
		
		@Override
		public Department getDepartmentById(int id) {
			// TODO Auto-generated method stub
			return DataDAO.DataServiceImplementaion.getDepartmentById(id);
		}
		
		@Override
		public ArrayList<Department> getAllDepartments() {
			// TODO Auto-generated method stub
			return DataDAO.DataServiceImplementaion.getAllDepartments();
		}
		
		@Override
		public AccountTypeCollection<AccountType> getAccountTypes() {
			// TODO Auto-generated method stub
			return DataDAO.DataServiceImplementaion.getAccountTypes();
		}
		
		@Override
		public AccountType getAccountTypeById(int id) {
			// TODO Auto-generated method stub
			return DataDAO.DataServiceImplementaion.getAccountTypeById(id);
		}
	};
}
