package dev.wsd.services;

import java.sql.SQLException;

import dev.wsd.collections.*;
import dev.wsd.daos.AccountDAOmaria;
import dev.wsd.daos.AccountTransDAOmaria;
import dev.wsd.daos.UserDAOmaria;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class ClientService {

	public ClientService() {

	}

	public static User CurrentUser = new User();
	public static UserAccount CurrentUserAcount = new UserAccount();
	public static UserCredential CurrentUserCredential = new UserCredential();
	public static IClientService ClientServiceOperation = new IClientService() {

		@Override
		public AccountTransCollection<AccountTransaction> viewTransaction(int userid) {

			// TODO Auto-generated method stub
			return AccountTransDAOmaria.AccountTransDAOImplementaion.viewUserTransactions(userid);

		}

		@Override
		public AccountTransaction addTransaction(AccountTransaction transaction) {
			// TODO Auto-generated method stub

			return AccountTransDAOmaria.AccountTransDAOImplementaion.addTransaction(transaction);
		}

		@Override
		public UserCredential userRegister(UserCredential usercredential, User user) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.userRegister(usercredential, user);
		}

		@Override
		public UserCredential login(String password, String loginname) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.userLogin(password, loginname);
		}

		@Override

		public User updateUser(User user) {
			// TODO Auto-generated method stub

			try {
				user = UserDAOmaria.UserDAOImplementaion.updateUser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}

		@Override
		public UserAccount openAccount(UserAccount account) {
			// TODO Auto-generated method stub
			return AccountDAOmaria.AccountDAOImplementaion.openAccount(account);
		}

		@Override
		public UserCredential logout(UserCredential usercerdenial) {
			// TODO Auto-generated method stub
			usercerdenial = null;
			return usercerdenial;
		}

		@Override
		public boolean closeAccount(UserAccount account) {
			account = AccountDAOmaria.AccountDAOImplementaion.closeAccount(account);

			// TODO Auto-generated method stub
			return !account.isActive();
		}

		@Override
		public UserAccountCollection<UserAccount> getAccountInfoByUserId(int userId) {
			// TODO Auto-generated method stub
			return AccountDAOmaria.AccountDAOImplementaion.getAccountsByUserId(userId);
		}

	};

}