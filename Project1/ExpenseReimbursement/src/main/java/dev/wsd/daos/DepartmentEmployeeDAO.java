package dev.wsd.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.wsd.entities.DepartmentEmployee;
import dev.wsd.entities.Reimbursement;
import dev.wsd.utils.DBConnectionUtil;

public class DepartmentEmployeeDAO {

	public static IDepartmentEmployeeDAO DepartmentEmployeeDAOImp = new IDepartmentEmployeeDAO() {
		/*
		 * SELECT ID, userId, depId, isManger FROM banksysdb.tbl_departmentemployee;
		 */
		@Override
		public DepartmentEmployee getDepartmentEmployeeByUserId(int userId) {
			String sql = "SELECT  *   FROM banksysdb.tbl_departmentemployee where userId=? ";
			DepartmentEmployee depEmp = null;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					depEmp = new DepartmentEmployee(rs.getInt("userId"), rs.getInt("depId"));
					depEmp.setId(rs.getInt("ID"));
					depEmp.setIsManager((rs.getBoolean("isManager")));
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return depEmp;
		}

		@Override
		public DepartmentEmployee getDepartmentEmployeeById(int ID) {

			String sql = "SELECT  *   FROM banksysdb.tbl_departmentemployee where ID= ? ";
			DepartmentEmployee depEmp = null;
			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, ID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					depEmp = new DepartmentEmployee(rs.getInt("userId"), rs.getInt("depId"));
					depEmp.setId(rs.getInt("ID"));
					depEmp.setIsManager((rs.getBoolean("isManager")));
				}
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {

			}
			return depEmp;
		}

		@Override
		public ArrayList<DepartmentEmployee> getAllDepEmployeesByDepId(int depId) {
			ArrayList<DepartmentEmployee> rlist = new ArrayList<DepartmentEmployee>();
			String sql = "SELECT  *   FROM banksysdb.tbl_departmentemployee where depId=? ";

			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ps.setInt(1, depId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DepartmentEmployee r = new DepartmentEmployee(rs.getInt("userId"), rs.getInt("depId"));
					r.setId(rs.getInt("ID"));
					r.setIsManager((rs.getBoolean("isManager")));
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
		public ArrayList<DepartmentEmployee> getAllDepEmployees() {
			ArrayList<DepartmentEmployee> rlist = new ArrayList<DepartmentEmployee>();
			String sql = "SELECT  *   FROM banksysdb.tbl_departmentemployee where isManager=0 ";

			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DepartmentEmployee r = new DepartmentEmployee(rs.getInt("userId"), rs.getInt("depId"));
					r.setId(rs.getInt("ID"));
					r.setIsManager((rs.getBoolean("isManager")));
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
		public ArrayList<DepartmentEmployee> getAllDepMangers() {
			ArrayList<DepartmentEmployee> rlist = new ArrayList<DepartmentEmployee>();
			String sql = "SELECT  *   FROM banksysdb.tbl_departmentemployee where isManager=1 ";

			try (Connection con = DBConnectionUtil.openCon(); PreparedStatement ps = con.prepareStatement(sql);) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DepartmentEmployee r = new DepartmentEmployee(rs.getInt("userId"), rs.getInt("depId"));
					r.setId(rs.getInt("ID"));
					r.setIsManager((rs.getBoolean("isManager")));
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
