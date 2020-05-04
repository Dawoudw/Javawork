package dev.wsd.entities;

import dev.wsd.daos.DataDAO;
import dev.wsd.daos.UserDAOmaria;

public class DepartmentEmployee extends User {
	private int ID;
	private Department department;
	private boolean isManager;

	public DepartmentEmployee() {

	}

	public DepartmentEmployee(int userid) {
		super(UserDAOmaria.UserDAOImplementaion.getUserById(userid));
	}

	public DepartmentEmployee(int userid, int depid) {
		super(UserDAOmaria.UserDAOImplementaion.getUserById(userid));
 
		this.department = DataDAO.DataServiceImplementaion.getDepartmentById(depid);
	}

	public int getID() {
		return this.ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public Department getDepartmentId() {
		return department;
	}

	public void setDepartmentId(Department departmentId) {
		this.department = departmentId;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}
}
