package dev.wsd.daos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import dev.wsd.entities.*;
import dev.wsd.entities.Reimbursement;
import dev.wsd.entities.ReimbursementView;
import dev.wsd.enums.REIMBURSEMENT_STATUS;
import dev.wsd.utils.DBConnectionUtil;

public class ReimbursementDAO {

	public static IReimbursementDAO ReimbursementDAOImp = new IReimbursementDAO() {
		/*
		 * // String sql = "SELECT ID, submitEmp, approveEmp, amount, status, postDate,
		 * // reason, comoent FROM banksysdb.tbl_reimbursement where approveEmp=? ; ";
		 */

		@Override
		public Reimbursement getReimbursementById(int id) {
			Reimbursement reimbursement = new Reimbursement();
			String sql = "SELECT  *   FROM banksysdb.tbl_reimbursement where ID=? ";
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					reimbursement.setId(rs.getInt("ID"));
					reimbursement.setSubmitEmp(rs.getInt("submitEmp"));
					reimbursement.setApprovalEmp(rs.getInt("approveEmp"));
					reimbursement.setAmount(rs.getDouble("amount"));
					reimbursement.setStatus(rs.getShort("status"));
					reimbursement.setPostdate(rs.getDate("postDate"));
					reimbursement.setReason(rs.getString("reason"));
					reimbursement.setComment(rs.getString("comment"));
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return reimbursement;
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
				System.out.println(e.getMessage());
			} finally {
			}
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
				ps.setShort(4, reimbursmnt.getStatus());
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
				ps.setShort(4, reimbursmnt.getStatus());
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
				System.out.println(e.getMessage());
			} finally {
			}
			return (result > 0);
		}

		@Override
		public double getTotalRequestsByMangerId(int id) {
			String sqlTotalMangerRequest = "SELECT  round( SUM(amount),2)  as TotalReimbursements FROM banksysdb.tbl_reimbursement  where approveEmp =?;";
			double total = 0.00;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(sqlTotalMangerRequest);) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getDouble("TotalReimbursements");
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				total = 0.00;
			}
			return total;
		}

		@Override
		public double getTotalDeniedMoneyByMangerId(int id) {
			String sqlTotalMangerRequest = "SELECT  round( SUM(amount),2)  as TotalReimbursements FROM banksysdb.tbl_reimbursement  where approveEmp =? and status=3;";
			double total = 0.00;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(sqlTotalMangerRequest);) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getDouble("TotalReimbursements");
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				total = 0.00;
			}
			return total;
		}

		@Override
		public double getTotalApprovedMoneyByMangerId(int id) {
			String sqlTotalMangerRequest = "SELECT  round( SUM(amount),2)  as TotalReimbursements FROM banksysdb.tbl_reimbursement  where approveEmp =? and status=3;";
			double total = 0.00;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(sqlTotalMangerRequest);) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getDouble("TotalReimbursements");
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				total = 0.00;
			}
			return total;
		}

		@Override
		public Hashtable<Integer, Double> getHighestRequester() {
			Hashtable<Integer, Double> ht = new Hashtable<Integer, Double>();
			String highestReq = "SELECT tbl.submitEmp, MAX(TotalReimbursements) as HighestRequest FROM  "
					+ "(SELECT  submitEmp ,  SUM(amount)  as TotalReimbursements FROM banksysdb.tbl_reimbursement   group by submitEmp  order by TotalReimbursements desc )  as tbl;";
			double total = 0.00;
			int id = 0;
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(highestReq);) {

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					id = rs.getInt("submitEmp");
					total = rs.getDouble("HighestRequest");
					ht.put(id, total);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				total = 0.00;
			}
			return ht;

		}

		@Override
		public double getAvgReimbursements() {

			String sqlAvg = "SELECT    round(Avg(amount),2) as  AvgReimbursements FROM banksysdb.tbl_reimbursement  ;";
			double total = 0.00;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sqlAvg);) {

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getDouble("AvgReimbursements");
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				total = 0.00;
			}
			return total;
		}

		@Override
		public ArrayList<MG> getTotalApprovedGroupByManger() {
			ArrayList<MG> ht = new ArrayList<MG>(); 
//			String totalpproved = "SELECT  approveEmp ,  SUM(amount)  as TotalApproved FROM banksysdb.tbl_reimbursement "
//					+ "WHERE  status =2  " + "group by approveEmp  " + "order by TotalApproved desc ";
	 
		 MG  obj = new MG();
			String totalpproved = "select gr.TotalApproved ,usr.mangerName  from  "
					+ "( SELECT  approveEmp ,  SUM(amount)  as TotalApproved FROM banksysdb.tbl_reimbursement   "
					+ "  WHERE  status =2  group by approveEmp order by TotalApproved desc) gr , "
					+ "(select u.ID, CONCAT( u.fName  ,' ', u.lName) as mangerName from tbl_user  u ) usr  "
					+ " where  usr.ID  = gr.approveEmp order by gr.TotalApproved desc ;";
			 
			try (Connection con = DBConnectionUtil.openCon();
					PreparedStatement ps = con.prepareStatement(totalpproved);) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					obj = new MG();
					obj.amount=rs.getDouble("TotalApproved"); 
					obj.mangername= rs.getString("mangerName");
					ht.add(obj);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
			 
			}
			return ht;
		}

		@Override
		public ArrayList<Reimbursement> getAllReimbursementsByEmployeeId(int employeeId) {
			ArrayList<Reimbursement> rlist = new ArrayList<Reimbursement>();
			String sql = "SELECT  *   FROM banksysdb.tbl_reimbursement where submitEmp=? ";
			int id = 0;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, employeeId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Reimbursement r = new Reimbursement();
					id = rs.getInt("ID");
					r.setId(id);
					r.setSubmitEmp(rs.getInt("submitEmp"));
					r.setApprovalEmp(rs.getInt("approveEmp"));
					r.setAmount(rs.getDouble("amount"));
					r.setStatus(rs.getShort("status"));
					r.setPostdate(rs.getDate("postDate"));
					r.setReason(rs.getString("reason"));
					r.setComment(rs.getString("comment"));
					rlist.add(r);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return rlist;
		}

		@Override
		public ArrayList<Reimbursement> getAllReimbursementsByApproverId(int approverId) {
			ArrayList<Reimbursement> rlist = new ArrayList<Reimbursement>();
			String sql = "SELECT  *   FROM banksysdb.tbl_reimbursement where approveEmp=? ";
			int id = 0;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, approverId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Reimbursement r = new Reimbursement();
					id = rs.getInt("ID");
					r.setId(id);
					r.setSubmitEmp(rs.getInt("submitEmp"));
					r.setApprovalEmp(rs.getInt("approveEmp"));
					r.setAmount(rs.getDouble("amount"));
					r.setStatus(rs.getShort("status"));
					r.setPostdate(rs.getDate("postDate"));
					r.setReason(rs.getString("reason"));
					r.setComment(rs.getString("comment"));
					rlist.add(r);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return rlist;

		}

		@Override
		public ArrayList<Reimbursement> getAllReimbursements() {
			ArrayList<Reimbursement> rlist = new ArrayList<Reimbursement>();
			String sql = "SELECT  *   FROM banksysdb.tbl_reimbursement ";
			int id = 0;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Reimbursement r = new Reimbursement();
					id = rs.getInt("ID");
					r.setId(id);
					r.setSubmitEmp(rs.getInt("submitEmp"));
					r.setApprovalEmp(rs.getInt("approveEmp"));
					r.setAmount(rs.getDouble("amount"));
					r.setStatus(rs.getShort("status"));
					r.setPostdate(rs.getDate("postDate"));
					r.setReason(rs.getString("reason"));
					r.setComment(rs.getString("comment"));
					rlist.add(r);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return rlist;
		}

		@Override
		public ArrayList<ReimbursementView> getReimbursementsViewByEmployeeId(int employeeId) {

			/*
			 * SELECT r.ID, r.submitEmp, r.approveEmp, r.amount, r.status, r.postDate,
			 * r.reason, r.comment , (select CONCAT( u.fName ,' ', u.lName) from tbl_user u
			 * where u.ID = r.submitEmp ) as empName , (select CONCAT( u.fName ,' ',
			 * u.lName) from tbl_user u where u.ID = r.approveEmp ) as mangerName FROM
			 * banksysdb.tbl_reimbursement r where r.submitEmp =?
			 * 
			 */
			ArrayList<ReimbursementView> rlist = new ArrayList<ReimbursementView>();
			String sql = "SELECT r.ID, r.submitEmp, r.approveEmp, r.amount, r.status, r.postDate, r.reason, r.comment , "
					+ " (select CONCAT( u.fName  ,' ', u.lName)  from tbl_user u  where  u.ID  = r.submitEmp )  as empName , "
					+ "(select CONCAT( u.fName  ,' ', u.lName)  from tbl_user u  where  u.ID  = r.approveEmp )  as mangerName  "
					+ "FROM banksysdb.tbl_reimbursement  r\r\n" + "where r.submitEmp =?";

			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, employeeId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ReimbursementView r = new ReimbursementView();
					r.setReid(rs.getInt("ID"));
					r.setEmpid(rs.getInt("submitEmp"));
					r.setMangid(rs.getInt("approveEmp"));
					r.setAmount(rs.getDouble("amount"));
					r.setStatus(rs.getShort("status"));
					r.setPostdate(rs.getDate("postDate"));
					r.setReason(rs.getString("reason"));
					r.setComment(rs.getString("comment"));
					r.setManagerName(rs.getString("mangerName"));
					r.setEmpName(rs.getString("empName"));
					rlist.add(r);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return rlist;

		}

		@Override
		public ArrayList<ReimbursementView> getReimbursementsViewByManagerId(int mangerid) {
			/*
			 * SELECT r.ID, r.submitEmp, r.approveEmp, r.amount, r.status, r.postDate,
			 * r.reason, r.comment , (select CONCAT( u.fName ,' ', u.lName) from tbl_user u
			 * where u.ID = r.submitEmp ) as empName , (select CONCAT( u.fName ,' ',
			 * u.lName) from tbl_user u where u.ID = r.approveEmp ) as mangerName FROM
			 * banksysdb.tbl_reimbursement r where r.approveEmp = 1
			 */
			ArrayList<ReimbursementView> rlist = new ArrayList<ReimbursementView>();
			String sql = "SELECT r.ID, r.submitEmp, r.approveEmp, r.amount, r.status, r.postDate, r.reason, r.comment , "
					+ " (select CONCAT( u.fName  ,' ', u.lName)  from tbl_user u  where  u.ID  = r.submitEmp )  as empName , "
					+ "(select CONCAT( u.fName  ,' ', u.lName)  from tbl_user u  where  u.ID  = r.approveEmp )  as mangerName  "
					+ "FROM banksysdb.tbl_reimbursement  r\r\n" + "where r.approveEmp =?";
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, mangerid);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					ReimbursementView r = new ReimbursementView();
					r.setReid(rs.getInt("ID"));
					r.setEmpid(rs.getInt("submitEmp"));
					r.setMangid(rs.getInt("approveEmp"));
					r.setAmount(rs.getDouble("amount"));
					r.setStatus(rs.getShort("status"));
					r.setPostdate(rs.getDate("postDate"));
					r.setReason(rs.getString("reason"));
					r.setComment(rs.getString("comment"));
					r.setManagerName(rs.getString("mangerName"));
					r.setEmpName(rs.getString("empName"));
					rlist.add(r);
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return rlist;
		}

	};
	
 
 
}
 