package dev.wsd.services;

import java.sql.SQLException;

import dev.wsd.collections.*;
import dev.wsd.daos.UserDAOmaria;
import dev.wsd.entities.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class AdminService {

	public AdminService() {

	}

	public static IAdminService AdminServiceOperation = new IAdminService() {

		public UserCredential userRegister(UserCredential usercredential, User user) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.userRegister(usercredential, user);
		}

		@Override
		public User updateUser(User user) throws SQLException {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.updateUser(user);
		}

		@Override
		public UserCredential logout(UserCredential usercerdenial) {
			usercerdenial = null;
			// TODO Auto-generated method stub
			return usercerdenial;
		}

		@Override
		public UserCredential login(String password, String loginname) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.userLogin(password, loginname);
		}

		@Override
		public UserCollection<User> getAllUsers() throws SQLException {
			// TODO Auto-generated method stub

			return UserDAOmaria.UserDAOImplementaion.getAllUsers();
		}

		@Override
		public boolean deleteUser(User user) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.deleteUser(user);
		}

		@Override
		public User createUser(User user) {
			// TODO Auto-generated method stub
			return UserDAOmaria.UserDAOImplementaion.createUser(user);
		}
	};

}