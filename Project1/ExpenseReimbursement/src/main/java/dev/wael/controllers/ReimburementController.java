package dev.wael.controllers;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev.wsd.entities.Reimbursement;
import dev.wsd.entities.ReimbursementView;
import dev.wsd.enums.REIMBURSEMENT_STATUS;
import dev.wsd.services.ReimbursementService;

public class ReimburementController {

	public ReimburementController() {
	}
	/*
	 * updateReimbursement getTotalRequestsByMangerId getTotalDeniedMoneyByMangerId
	 * getTotalApprovedMoneyByMangerId getTotalApprovedGroupByManger
	 * getReimbursementById getHighestRequester getAvgReimbursements
	 * getAllReimbursementsByEmployeeId getAllReimbursementsByApproverId
	 * getAllReimbursements changeReimbursementStatus addReimbursement
	 */

	public void getGroupStatisticsTotalApproval(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			String jsn = gson.toJson(ReimbursementService.ReimbursementServiceOps.getTotalApprovedGroupByManger());

			response.getWriter().append(jsn);
		} catch (Exception e) {
			response.sendError(333);
		}

	}

	public void getBasicStatisticsbyMangerId(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			String userid = request.getParameter("userid");
			int mangrid = Integer.parseInt(userid);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Hashtable<String, Double> ht = new Hashtable<String, Double>();

			double avgrequets = ReimbursementService.ReimbursementServiceOps.getAvgReimbursements();
			double totaldenied = ReimbursementService.ReimbursementServiceOps.getTotalDeniedMoneyByMangerId(mangrid);
			double totalapproved = ReimbursementService.ReimbursementServiceOps
					.getTotalApprovedMoneyByMangerId(mangrid);
			double totalrequests = ReimbursementService.ReimbursementServiceOps.getTotalRequestsByMangerId(mangrid);
			ht.put("totalrequests", totalrequests);
			ht.put("totalrequests", totalrequests);
			ht.put("avgrequets", avgrequets);
			ht.put("totaldenied", totaldenied);
			ht.put("totalapproved", totalapproved);
			String jsn = gson.toJson(ht);
			response.getWriter().append(jsn);
		} catch (Exception e) {
			response.sendError(333);
		}

	}

	public void getAllReimbursementsByEmployeeId(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			String userid = request.getParameter("userid");
			int usrid = Integer.parseInt(userid);
			Gson gson = new Gson();

			List<ReimbursementView> list = (List<ReimbursementView>) ReimbursementService.ReimbursementServiceOps
					.getReimbursementsViewByEmployeeId(usrid);

			PrintWriter pw = response.getWriter();
			String json = gson.toJson(list);
			pw.append(json);
		} catch (Exception e) {
			response.sendError(333);
		}
	}

	public void getAllReimbursementsByMangerId(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try {
			String userid = request.getParameter("userid");
			int managerId = Integer.parseInt(userid);
			Gson gson = new Gson();

			List<ReimbursementView> list = (List<ReimbursementView>) ReimbursementService.ReimbursementServiceOps
					.getReimbursementsViewByManagerId(managerId);

			PrintWriter pw = response.getWriter();
			String json = gson.toJson(list);
			pw.append(json);
		} catch (Exception e) {
			response.sendError(333);
		}
	}

	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {

			// Reimbursement re = new Gson().fromJson(request.getReader(),
			// Reimbursement.class);
			String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
			Gson gson = new Gson();

			Reimbursement obj = gson.fromJson(body, Reimbursement.class);
			ReimbursementService.ReimbursementServiceOps.addReimbursement(obj);

			// response.sendRedirect("http://localhost:8080/ExpenseReimbursement/Employee.html");

		} catch (Exception e) {
			System.out.println(e);
			response.sendError(333);

		}
	}

	public void changeReimbursementStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String status = request.getParameter("state");
			if (null == status || status.toString().isEmpty())
				throw new Exception("Empty or Null Status");

			String reid = request.getParameter("reid");
			if (null == reid || reid.toString().isEmpty())
				throw new Exception("Empty or Null Reimbursement ID");

			int id = Integer.parseInt(reid);
			int sid = Integer.parseInt(status);
			REIMBURSEMENT_STATUS RS = null;
			switch (sid) {
			case 1:
				RS = REIMBURSEMENT_STATUS.Submitted;
				break;
			case 2:
				RS = REIMBURSEMENT_STATUS.Approved;
				break;
			case 3:
				RS = REIMBURSEMENT_STATUS.Denied;
				break;

			}

			ReimbursementService.ReimbursementServiceOps.changeReimbursementStatus(id, RS);
			response.getWriter().append("The Reimbursemnet Staus Has Been Changed Successfully");

		} catch (Exception e) {
			response.sendError(333);

		}
	}
}
