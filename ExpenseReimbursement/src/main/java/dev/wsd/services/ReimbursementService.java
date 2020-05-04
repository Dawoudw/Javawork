package dev.wsd.services;

import java.util.Collection;
import java.util.Hashtable;

import dev.wsd.daos.ReimbursementDAO;
import dev.wsd.entities.Reimbursement;
import dev.wsd.entities.ReimbursementView;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

public class ReimbursementService {

	public ReimbursementService() {
	}

	public static IReimbursementService ReimbursementServiceOps = new IReimbursementService() {
		/*
		 * updateReimbursement getTotalRequestsByMangerId getTotalDeniedMoneyByMangerId
		 * getTotalApprovedMoneyByMangerId getTotalApprovedGroupByManger
		 * getReimbursementById getHighestRequester getAvgReimbursements
		 * getAllReimbursementsByEmployeeId getAllReimbursementsByApproverId
		 * getAllReimbursements changeReimbursementStatus addReimbursement
		 */
		@Override
		public boolean updateReimbursement(Reimbursement reimbursmnt) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.updateReimbursement(reimbursmnt);
		}

		@Override
		public double getTotalRequestsByMangerId(int id) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getTotalRequestsByMangerId(id);
		}

		@Override
		public double getTotalDeniedMoneyByMangerId(int id) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getTotalDeniedMoneyByMangerId(id);
		}

		@Override
		public double getTotalApprovedMoneyByMangerId(int id) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getTotalApprovedMoneyByMangerId(id);
		}

		@Override // 5
		public Hashtable<Integer, Double> getTotalApprovedGroupByManger() {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getTotalApprovedGroupByManger();
		}

		@Override // 6
		public Reimbursement getReimbursementById(int id) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getReimbursementById(id);
		}

		@Override // 7
		public Hashtable<Integer, Double> getHighestRequester() {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getHighestRequester();
		}

		@Override // 8
		public double getAvgReimbursements() {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getAvgReimbursements();
		}

		@Override // 9
		public Collection<Reimbursement> getAllReimbursementsByEmployeeId(int employeeId) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getAllReimbursementsByEmployeeId(employeeId);
		}

		@Override // 10
		public Collection<Reimbursement> getAllReimbursementsByApproverId(int approverId) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getAllReimbursementsByApproverId(approverId);
		}

		@Override // 11
		public Collection<Reimbursement> getAllReimbursements() {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getAllReimbursements();
		}

		@Override // 12
		public boolean changeReimbursementStatus(int id, REIMBURSEMENT_STATUS status) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.changeReimbursementStatus(id, status);
		}

		@Override // 13
		public Reimbursement addReimbursement(Reimbursement reimbursmnt) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.addReimbursement(reimbursmnt);
		}

		@Override
		public Collection<ReimbursementView> getReimbursementsViewByEmployeeId(int employeeId) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getReimbursementsViewByEmployeeId(employeeId);

		}

		@Override
		public Collection<ReimbursementView> getReimbursementsViewByManagerId(int managerId) {
			// TODO Auto-generated method stub
			return ReimbursementDAO.ReimbursementDAOImp.getReimbursementsViewByManagerId(managerId);
		}
	};

}
