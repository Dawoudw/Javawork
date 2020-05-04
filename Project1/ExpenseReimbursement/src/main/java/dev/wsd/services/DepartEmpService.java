package dev.wsd.services;

import java.util.ArrayList;

import dev.wsd.daos.DepartmentEmployeeDAO;
import dev.wsd.daos.IDepartmentEmployeeDAO;
import dev.wsd.entities.DepartmentEmployee;

public class DepartEmpService {
	public DepartEmpService() {
	}

	public static IDepartEmpService DepartEmpServiceOps = new IDepartEmpService() {
	//	getDepartmentEmployeeByUserId getDepartmentEmployeeById getAllDepEmployeesByDepId getAllDepEmployees getAllDepMangers
		@Override
		public DepartmentEmployee getDepartmentEmployeeByUserId(int id) {
			// TODO Auto-generated method stub
			return DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getDepartmentEmployeeByUserId(id);
		}

		@Override
		public DepartmentEmployee getDepartmentEmployeeById(int id) {
			// TODO Auto-generated method stub
			return DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getDepartmentEmployeeById(id);
		}

		@Override
		public ArrayList<DepartmentEmployee> getAllDepEmployeesByDepId(int id) {
			// TODO Auto-generated method stub
			return DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getAllDepEmployeesByDepId(id);
		}

		@Override
		public ArrayList<DepartmentEmployee> getAllDepEmployees() {
			// TODO Auto-generated method stub
			return DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getAllDepEmployees();
		}

		@Override
		public ArrayList<DepartmentEmployee> getAllDepMangers() {
			// TODO Auto-generated method stub
			return   DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getAllDepMangers();
		}
	};

}
