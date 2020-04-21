package dev.wsd.daos;

import java.util.ArrayList;

import dev.wsd.entities.Reimbursement;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

public interface IReimbursementDAO {

	public abstract Reimbursement addReimbursement(Reimbursement reimbursmnt);

	public abstract boolean updateReimbursement(Reimbursement reimbursmnt);

	public abstract boolean changeReimbursementStatus(int id , REIMBURSEMENT_STATUS status);

	public abstract ArrayList<Reimbursement> getAllReimbursements();

	public abstract Reimbursement getReimbursementById(int id);

	public abstract ArrayList<Reimbursement> getAllReimbursementsByEmployeeId(int employeeId);

	public abstract ArrayList<Reimbursement> getAllReimbursementsByApproverId(int approverId);

	// 7.1 I want to view a reimbursement statistics about How much each manager has
	// approved
	public abstract float getTotalApprovedGroupByManger();

	// 7.2 I want to view a reimbursement statistics about Who submitted the most
	// requests
	public abstract float getMaxRequestsByEmpId(int id);

	// 7.3 I want to view a reimbursement statistics about Average reimbursement
	// request.
	public abstract float getAvgReimbursements();

	// 7.4 I want to view a reimbursement statistics about Amount of approved money
	public abstract float getTotalApprovedMoneyByMangerId(int id);

	// 7.5 I want to view a reimbursement statistics about Amount of denied money .
	public abstract float getTotalDeniedMoneyByMangerId(int id);

	// 7.6 I want to view a reimbursement statistics about Amount of total requests.
	public abstract float getTotalRequestsByMangerId(int id);

}
