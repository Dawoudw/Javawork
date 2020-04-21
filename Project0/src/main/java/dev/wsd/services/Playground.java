package dev.wsd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dev.wsd.entities.User;
import dev.wsd.utils.DBConnectionUtil;

public class Playground {
	public static void main(String[] args) throws SQLException {
		System.err.println("Hello World");
		for(User u:getAllUsers())
		{
			System.out.print(u.getId() + "\n" + u.getFname() + "\n" + u.getLname() + "\n");
		}
		System.out.println(getAllUsers().toString());
		Connection con = DBConnectionUtil.openCon();
		try {

			PreparedStatement ps = con.prepareStatement("select * from tbl_user where id=1");

			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("ID");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			System.out.print(id + "\n" + fname + "\n" + lname + "\n");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			String txt = con.isClosed() ? "Connection Closed" : "COnnection still oppned";
			System.out.println(txt);
		}

	}

	public static ArrayList<User> getAllUsers() {
		String sql = "select * from tbl_user";
		ArrayList<User> list = new ArrayList<User>();
		try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {

			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					User user = new User();
					list.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{}
  
		return list;
		// I think this is more optimized that we wrapped all objects in try parentheses , so every connection going to be closed and all objects
		// will become safe to be garbage collected
	}

}
