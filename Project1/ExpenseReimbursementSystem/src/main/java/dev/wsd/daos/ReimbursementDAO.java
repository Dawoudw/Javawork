package dev.wsd.daos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dev.wsd.entities.Reimbursement;
import dev.wsd.enums.REIMBURSEMENT_STATUS;
import dev.wsd.utils.DBConnectionUtil;

public class ReimbursementDAO {

	public static IReimbursementDAO ReimbursementDAOImp = new IReimbursementDAO() {

		@Override
		public ArrayList<Reimbursement> getAllReimbursements() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean changeReimbursementStatus(int id, REIMBURSEMENT_STATUS status) {
			// UPDATE banksysdb.tbl_reimbursement SET submitEmp=NULL, approveEmp=NULL,
			// amount=0, status=0, postDate='0000-00-00 00:00:00', reason=NULL, comment=NULL
			// WHERE ID=0;
			int result = 0;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con
							.prepareStatement("UPDATE banksysdb.tbl_reimbursement SET status=? WHERE ID=?");) {
				ps.setShort(1, status.getValue());
				ps.setInt(2, id);
				result = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
			} finally {
			}
			// TODO Auto-generated method stub
			return (result > 0);
		}

		@Override
		public Reimbursement addReimbursement(Reimbursement reimbursmnt) {

			String sql = "INSERT INTO banksysdb.tbl_reimbursement (submitEmp, approveEmp, amount, status, postDate, reason, comment) VALUES(?, ?, ?, ?, ?, ?, ?)";
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

				ps.setInt(1, reimbursmnt.getSubmitEmp());
				ps.setInt(2, reimbursmnt.getApprovalEmp());
				ps.setDouble(3, reimbursmnt.getAmount());
				ps.setShort(4, reimbursmnt.getStatusValue());
//				java.util.Date date = new Date();
//				Object param = new java.sql.Timestamp(date.getTime());
//				ps.setObject(5, param);
				ps.setTimestamp(5, java.sql.Timestamp.from(java.time.Instant.now()));
				ps.setString(6, reimbursmnt.getReason());
				ps.setString(7, reimbursmnt.getComment());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				reimbursmnt.setId(rs.getInt("ID"));
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return reimbursmnt;
		}

		@Override
		public boolean updateReimbursement(Reimbursement reimbursmnt) {
			int result = 0;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(
							"UPDATE banksysdb.tbl_reimbursement SET submitEmp=?, approveEmp=?, amount=?, status=?, postDate=?, reason=?, comment=? WHERE ID=?");) {
				ps.setInt(1, reimbursmnt.getSubmitEmp());
				ps.setInt(2, reimbursmnt.getApprovalEmp());
				ps.setDouble(3, reimbursmnt.getAmount());
				ps.setShort(4, reimbursmnt.getStatusValue());
//				java.util.Date date = new Date();
//				Object param = new java.sql.Timestamp(date.getTime());
//				ps.setObject(5, param);
				ps.setTimestamp(5, java.sql.Timestamp.from(java.time.Instant.now()));
				ps.setString(6, reimbursmnt.getReason());
				ps.setString(7, reimbursmnt.getComment());
				ps.setInt(8, reimbursmnt.getId());
				result = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
			} finally {
			}
			// TODO Auto-generated method stub
			return (result > 0);
		}

		@Override
		public float getTotalRequestsByMangerId(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getTotalDeniedMoneyByMangerId(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getTotalApprovedMoneyByMangerId(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getTotalApprovedGroupByManger() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Reimbursement getReimbursementById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getMaxRequestsByEmpId(int id) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getAvgReimbursements() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ArrayList<Reimbursement> getAllReimbursementsByEmployeeId(int employeeId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Reimbursement> getAllReimbursementsByApproverId(int approverId) {
			// TODO Auto-generated method stub
			return null;
		}

	};
}
