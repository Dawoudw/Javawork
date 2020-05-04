package dev.wael.controllers;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.wsd.collections.*;
import dev.wsd.daos.ReimbursementDAO;
import dev.wsd.entities.*;
import dev.wsd.services.*;

public class Controller {
	public Controller() {
	}

//	public static void main() throws SQLException {
//		ArrayList<User> userlist = AdminService.AdminServiceOperation.getAllUsers();
//		System.out.println(userlist.get(0).getFname());
//
//	}
	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) {

		try {
			Reimbursement re = new Reimbursement();
			re.setAmount(100.00);
			re.setApprovalEmp(1);
			re.setSubmitEmp(2);
			re.setComment("Test");
			re.setReason("Test");
			re.setStatus((short) 1);
			re = ReimbursementDAO.ReimbursementDAOImp.addReimbursement(re);

			Gson gson = new Gson();
			PrintWriter pw = response.getWriter();

			String json = gson.toJson(re);
			pw.append(json);

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getuser(HttpServletRequest request, HttpServletResponse response) {
		UserCollection<User> userlist = new UserCollection<User>();

		try {
			userlist = AdminService.AdminServiceOperation.getAllUsers();

			Gson gson = new Gson();
			PrintWriter pw = response.getWriter();
			String id = request.getParameter("id");
			if (id != null && !id.isEmpty()) {
				User usr = userlist.get(Integer.parseInt(id));
				String json = gson.toJson(usr);
				pw.append(json);
			} else {
				String json = gson.toJson(userlist);
				pw.append(json);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User getuserbyId(int id) {
		UserCollection<User> userlist = new UserCollection<User>();
		User usr = new User();

		try {
			userlist = AdminService.AdminServiceOperation.getAllUsers();

			Gson gson = new Gson();

			// id = Integer.parseInt(request.getParameter("id"));
			usr = userlist.get(id);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return usr;
	}


}
