package dev.wael.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hamcrest.core.IsNull;

import com.google.gson.Gson;

import dev.wsd.entities.DepartmentEmployee;
import dev.wsd.entities.Reimbursement;
import dev.wsd.entities.UserCredential;
import dev.wsd.services.ClientService;
import dev.wsd.services.DepartEmpService;

public class UserController {

	/*
	 * getDepartmentEmployeeByUserId getDepartmentEmployeeById
	 * getAllDepEmployeesByDepId getAllDepEmployees getAllDepMangers
	 */
	public UserController() {

	}
 
	public DepartmentEmployee doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		boolean login = false;
		DepartmentEmployee depemp = null;
		try {

			String usrname = request.getParameter("username");
			String pass = request.getParameter("password");
			System.out.println(usrname + "" + pass);
			UserCredential userCredential = ClientService.ClientServiceOperation.login(pass, usrname);
			System.out.println(userCredential);
			PrintWriter pw = response.getWriter();
			if (userCredential != null && userCredential.getUserId() > 0) {
				login = true;
				Gson gson = new Gson();
				depemp = DepartEmpService.DepartEmpServiceOps.getDepartmentEmployeeByUserId(userCredential.getUserId());
				pw = response.getWriter();
				String json = gson.toJson(depemp, DepartmentEmployee.class);
				pw.append(json);
			}

			else {
				login = false;
				pw = response.getWriter().append(Boolean.toString(login));
			}
		} catch (Exception e) {
			response.sendError(333);
			System.out.println(e.getMessage());
		}
		return depemp;
	}

	public void getDepartmentEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String userid = request.getParameter("userid");
			int usrid = Integer.parseInt(userid);
			Gson gson = new Gson();
		 
			DepartmentEmployee depemp = DepartEmpService.DepartEmpServiceOps.getDepartmentEmployeeById(usrid);
			PrintWriter pw = response.getWriter();
			String json = gson.toJson(depemp);
			pw.append(json);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getAllDepMangers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			Gson gson = new Gson();
			String json = gson.toJson(DepartEmpService.DepartEmpServiceOps.getAllDepMangers());
			response.getWriter().append(json);

		} catch (Exception e) {
			response.sendError(333);
			System.out.println(e.getMessage());
		}

	}

	public void getDepManger(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String depid = request.getParameter("depid");
			int id = Integer.parseInt(depid);
			Gson gson = new Gson();
			ArrayList<DepartmentEmployee> depemp = DepartEmpService.DepartEmpServiceOps.getAllDepMangers();
			DepartmentEmployee depM = depemp.stream().filter((b) -> b.getDepartmentId().getId() == id).findFirst()
					.get();
			PrintWriter pw = response.getWriter();
			String json = gson.toJson(depM, DepartmentEmployee.class);
			pw.append(json);
		} catch (Exception e) {
			response.sendError(333);
			System.out.println(e.getMessage());
		}

	}
}
