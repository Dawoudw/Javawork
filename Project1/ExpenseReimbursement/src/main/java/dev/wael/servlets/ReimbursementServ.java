package dev.wael.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.wael.controllers.ReimburementController;
import dev.wael.controllers.UserController;
import dev.wsd.entities.DepartmentEmployee;

/**
 * Servlet implementation class EmpReimbrs
 */
public class ReimbursementServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReimbursementServ() {
		super();

	}

	/*
	 * updateReimbursement getTotalRequestsByMangerId getTotalDeniedMoneyByMangerId
	 * getTotalApprovedMoneyByMangerId getTotalApprovedGroupByManger
	 * getReimbursementById getHighestRequester getAvgReimbursements
	 * getAllReimbursementsByEmployeeId getAllReimbursementsByApproverId
	 * getAllReimbursements changeReimbursementStatus addReimbursement
	 */
	/*
	 * getDepartmentEmployeeByUserId getDepartmentEmployeeById
	 * getAllDepEmployeesByDepId getAllDepEmployees getAllDepMangers
	 */
	ReimburementController ReimbusCtr = new ReimburementController();
	UserController UsrCtr = new UserController();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			System.out.println(uri);
			System.out.println(request.getPathInfo());
			switch (uri) {

			case "/ExpenseReimbursement/ReimbursementServ/login":
				HttpSession depuser = request.getSession();
				DepartmentEmployee depemp = UsrCtr.doLogin(request, response);
				depuser.setAttribute("depuser", depemp);
//			if (UsrCtr.doLogin(request, response)) {
//				RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/ExpenseReimbursement/Employee.html");
//				rd.forward(request, response);
//			} else {
//				response.getWriter().append("Sorry UserName or Password Error!");
//				RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/ExpenseReimbursement/Employee.html");
//				rd.include(request, response);
//
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getAllMangReimbursements":
				ReimbusCtr.getAllReimbursementsByMangerId(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getAllEmpReimbursements":
				ReimbusCtr.getAllReimbursementsByEmployeeId(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getDepartmentEmployeeById":
				UsrCtr.getDepartmentEmployeeById(request, response);
				break;

			case "/ExpenseReimbursement/ReimbursementServ/addReimbursement":
				ReimbusCtr.addReimbursement(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/changeReimbursementStatus":
				ReimbusCtr.changeReimbursementStatus(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getDepManger":
				UsrCtr.getDepManger(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getAllDepMangers":
				UsrCtr.getAllDepMangers(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getGroupStatisticsTotalApproval":
				ReimbusCtr.getGroupStatisticsTotalApproval(request, response);
				break;
			case "/ExpenseReimbursement/ReimbursementServ/getBasicStatisticsbyMangerId":
				ReimbusCtr.getBasicStatisticsbyMangerId(request, response);
				break;
			default:
				response.getWriter().append("Sorry , The requested URL is incorrect or not available .... ");
				response.sendError(333, "Sorry , The requested URL is incorrect or not available .... ");
				break;
			}
		} catch (Exception e) {
			response.sendError(333);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
