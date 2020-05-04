package dev.wsd.daos;

import java.util.ArrayList;

import dev.wsd.entities.DepartmentEmployee;

public interface IDepartmentEmployeeDAO {

	public DepartmentEmployee getDepartmentEmployeeById(int id);

	public DepartmentEmployee getDepartmentEmployeeByUserId(int id);

	public ArrayList<DepartmentEmployee> getAllDepEmployeesByDepId(int id);

	public ArrayList<DepartmentEmployee> getAllDepEmployees();
	public ArrayList<DepartmentEmployee> getAllDepMangers();
}
