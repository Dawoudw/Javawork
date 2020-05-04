package dev.wsd.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;

import dev.wsd.collections.*;
import dev.wsd.entities.*;
import dev.wsd.utils.*;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:25 AM
 */
public class UserDAOmaria {

	public UserDAOmaria() {

	}

	public static IUserDAO UserDAOImplementaion = new IUserDAO() {

		UserCollection<User> userCollection;

		@Override
		public User createUser(User user) {
			// "{ CALL banksysdb.sp_UserInsert(:fname,:lname,:dob,:phone,:email,:isadmin) }
			// ";INSERT INTO banksysdb.tbl_user (Fname, Lname, DOB, Email, Phone, IsAdmin)
			// VALUES('', '', NULL, '', '', b'0');CallableStatement statement =
			// con.prepareCall("{CALL banksysdb.sp_UserInsert(?, ?,?, ?,?,?)}")

			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement statement1 = con.prepareStatement(
							"INSERT INTO banksysdb.tbl_user (Fname, Lname, Email,IsAdmin) VALUES(?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
					PreparedStatement statement2 = con.prepareStatement(
							"INSERT INTO banksysdb.tbl_userCredential (UserID, LoginName, Password) VALUES(?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);) {
				try {
					con.setAutoCommit(false);
					statement1.setString(1, user.getFname());
					statement1.setString(2, user.getLname());

					// statement.setDate(3, new Date(1999, 01, 01));
					// statement.setString(4, "");
					statement1.setString(3, user.getEmail());
					statement1.setBoolean(4, user.isAdmin());
					statement1.executeUpdate();
					ResultSet rs = statement1.getGeneratedKeys();
					rs.next();// gets first record

					int id = rs.getInt("ID");
					user.setId(id);

					statement2.setInt(1, user.getId());
					statement2.setString(2, user.getFname());
					statement2.setString(3, "123");
					statement2.executeUpdate();
					con.commit();
					statement1.close();
					statement2.close();
					con.close();

				} catch (SQLException e) {
					con.rollback();
				}

				// System.out.println("Stored procedure called successfully!");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

//				con.close();
//				String txt = con.isClosed() ? "Connection Closed" : "COnnection still oppned";
//				PrintUtil.printInfo(txt);
			}
			return user;
		}

		@Override
		public boolean deleteUser(User user) {
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement statement1 = con
							.prepareStatement("DELETE FROM banksysdb.tbl_userCredential WHERE UserID= ?");
					PreparedStatement statement2 = con
							.prepareStatement("DELETE FROM banksysdb.tbl_user WHERE ID= ?");) {
				con.setAutoCommit(false);
				statement1.setInt(1, user.getId());
				int effectedrows = statement1.executeUpdate();
				if (effectedrows > 0) {
					statement2.setInt(1, user.getId());
					if (statement2.executeUpdate() > 0) {
						con.commit();
						statement1.close();
						statement2.close();
						con.close();
						return true;
					} else
						con.rollback();

				} else
					con.rollback();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {

			}
			return false;

		}

		@Override
		public User updateUser(User user) throws SQLException {
			// UPDATE banksysdb.tbl_user SET Fname='', Lname='', DOB=NULL, Email='',
			// Phone='', IsAdmin=b'0' WHERE ID=0;

			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement statement = con
							.prepareStatement("UPDATE banksysdb.tbl_user SET Fname=?, Lname=?, Email=?  WHERE ID=?");) {
				statement.setString(1, user.getFname());
				statement.setString(2, user.getLname());
//				statement.setDate(3, (Date) user.getDob());
//				statement.setString(5, "");
				statement.setString(3, user.getEmail());
				statement.setInt(4, user.getId());
				statement.execute();
				statement.close();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {

			}
			return user;
		}

		@Override
		public User getUserById(int id) {

			User user = null;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement("select * from tbl_user where ID = ?");) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("ID"));
					user.setAdmin(rs.getBoolean("IsAdmin"));
					user.setFname(rs.getString("Fname"));
					user.setLname(rs.getString("Lname"));
					user.setEmail(rs.getString("Email"));
					user.setDob(rs.getDate("DOB"));

				}
				ps.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return user;

		}

		@Override
		public UserCollection<User> getAllUsers() throws SQLException {
			// TODO Auto-generated method stub

			userCollection = new UserCollection<User>();
			User user;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement("select * from tbl_user");) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt("ID"));
					user.setAdmin(rs.getBoolean("IsAdmin"));
					user.setFname(rs.getString("Fname"));
					user.setLname(rs.getString("Lname"));
					user.setEmail(rs.getString("Email"));
					user.setDob(rs.getDate("DOB"));
					userCollection.add(user);
				}

				ps.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
//				con.close();
//				String txt = con.isClosed() ? "Connection Closed" : "COnnection still oppned";
//				PrintUtil.printInfo(txt);
			}

			return userCollection;
		}

		@Override
		public UserCredential userLogin(String password, String loginName) {
			// SELECT UserID, LoginName, Password, LastLogin, IsActive FROM
			// banksysdb.tbl_userCredential;
			UserCredential ucusr = new UserCredential();
			String sql = "SELECT userID, loginName, password, lastLogin, isActive FROM banksysdb.tbl_usercredential where password=? and loginName=? ";
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setString(2, loginName);
				ps.setString(1, password);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					ucusr = new UserCredential();
					ucusr.setUserId(rs.getInt("userID"));
					ucusr.setActive(rs.getBoolean("isActive"));
					ucusr.setLastLogin(rs.getDate("lastLogin"));
					ucusr.setLoginName(rs.getString("loginName"));
					ucusr.setPassword(rs.getString("password"));
					ucusr.setUser(ucusr.getUser(rs.getInt("userID")));
					break;

				}
				System.out.println(ucusr);
				System.out.println("con.isClosed()" + con.isClosed());
				ps.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return ucusr;
		}

		@Override
		public UserCredential userRegister(UserCredential usercredentials, User user) {
			// INSERT INTO banksysdb.tbl_userCredential (UserID, LoginName, Password,
			// LastLogin, IsActive) VALUES(NULL, '', '', '', b'1');

			// SELECT UserID, LoginName, Password, LastLogin, IsActive FROM
			// banksysdb.tbl_userCredential;

			UserCredential ucusr = null;
			user = this.createUser(user);
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(
							"INSERT INTO banksysdb.tbl_userCredential (UserID, LoginName, Password, LastLogin, IsActive) VALUES(?, ?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);) {
				ps.setInt(1, user.getId());
				ps.setString(2, usercredentials.getLoginName());
				ps.setString(3, usercredentials.getPassword());
				ps.setDate(4, (Date) usercredentials.getLastLogin());
				ps.setBoolean(5, usercredentials.isActive());

				ps.execute();

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return ucusr;
		}

		@Override
		public UserCredential changePassword(User user, String newPassword, String oldPassword) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UserCredentialCollection<UserCredential> getUserByLoginName(String loginname) {
			UserCredentialCollection<UserCredential> usrCredColl = new UserCredentialCollection<UserCredential>();
			UserCredential ucusr = null;
			User user = null;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con
							.prepareStatement("select * FROM banksysdb.tbl_userCredential where LoginName = ? ");) {
				ps.setString(1, loginname);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					ucusr = new UserCredential();
					ucusr.setActive(rs.getBoolean("IsActive"));
					ucusr.setLastLogin(rs.getDate("LastLogin"));
					ucusr.setLoginName(rs.getString("LoginName"));
					ucusr.setPassword(rs.getString("Password"));
					user = this.getUserById(rs.getInt("UserID"));
					ucusr.setUser(user);
					usrCredColl.add(ucusr);
				}

				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

			}
			return usrCredColl;
		}

		@Override
		public User getUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User getUserByPhone(String phone) {
			// TODO Auto-generated method stub
			return null;
		}

	};

}