package dev.wsd.services;

 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import dev.wsd.entities.MG;
import dev.wsd.entities.Reimbursement;
import dev.wsd.entities.ReimbursementView;
import dev.wsd.entities.User;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

public interface IReimbursementService {

	public abstract Reimbursement addReimbursement(Reimbursement reimbursmnt);

	public abstract boolean updateReimbursement(Reimbursement reimbursmnt);

	public abstract boolean changeReimbursementStatus(int id, REIMBURSEMENT_STATUS status);

	public abstract  Collection<Reimbursement> getAllReimbursements();

	public abstract Reimbursement getReimbursementById(int id);

	public abstract Collection<Reimbursement> getAllReimbursementsByEmployeeId(int employeeId);

	public abstract Collection<Reimbursement> getAllReimbursementsByApproverId(int approverId);

	// 7.1 I want to view a reimbursement statistics about How much each manager has
	// approved
	public abstract ArrayList<MG> getTotalApprovedGroupByManger();

	// 7.2 I want to view a reimbursement statistics about Who submitted the most
	// requests
	public abstract Hashtable<Integer, Double> getHighestRequester();

	// 7.3 I want to view a reimbursement statistics about Average reimbursement
	// request.
	public abstract double getAvgReimbursements();

	// 7.4 I want to view a reimbursement statistics about Amount of approved money
	public abstract double getTotalApprovedMoneyByMangerId(int id);

	// 7.5 I want to view a reimbursement statistics about Amount of denied money .
	public abstract double getTotalDeniedMoneyByMangerId(int id);

	// 7.6 I want to view a reimbursement statistics about Amount of total requests.
	public abstract double getTotalRequestsByMangerId(int id);
	
	public abstract Collection<ReimbursementView> getReimbursementsViewByEmployeeId(int employeeId);
	public abstract Collection<ReimbursementView> getReimbursementsViewByManagerId(int managerId);

}
