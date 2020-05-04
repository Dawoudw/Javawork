package dev.wael.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyStore.Entry;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dev.wael.controllers.*;
import dev.wsd.daos.DepartmentEmployeeDAO;
import dev.wsd.daos.ReimbursementDAO;
import dev.wsd.daos.UserDAOmaria;
import dev.wsd.entities.*;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

class DepartmentEmpTest {

	@Test
	void getAllDepEmployees() {
		ArrayList<DepartmentEmployee> rlist = DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getAllDepEmployees();

		System.out.println("AllReimbursementsByEmployeeId ");

		for (DepartmentEmployee entry : rlist) {

			System.out.println("ID: " + entry.getId() + " DepID: " + entry.getDepartmentId().getId() + " DepName: "
					+ entry.getDepartmentId().getName() + "  DepLocation " + entry.getDepartmentId().getLocation()
					+ " Is Manger " + entry.isManager());
			entry.printOptions();
		}
	}

	@Test
	void getAllDepEmployeesByDepId() {
		ArrayList<DepartmentEmployee> rlist = DepartmentEmployeeDAO.DepartmentEmployeeDAOImp
				.getAllDepEmployeesByDepId(2);

		System.out.println("AllDepEmployeesByDepId ");

		for (DepartmentEmployee entry : rlist) {

			System.out.println("ID: " + entry.getId() + " DepID: " + entry.getDepartmentId().getId() + " DepName: "
					+ entry.getDepartmentId().getName() + "  DepLocation " + entry.getDepartmentId().getLocation()
					+ " Is Manger " + entry.isManager());
			entry.printOptions();
		}
	}

	@Test
	void getDepartmentEmployeeById() {
		DepartmentEmployee entry = DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getDepartmentEmployeeById(14);

		System.out.println("getDepartmentEmployeeById ");

		System.out.println("ID: " + entry.getId() + " DepID: " + entry.getDepartmentId().getId() + " DepName: "
				+ entry.getDepartmentId().getName() + "  DepLocation " + entry.getDepartmentId().getLocation()
				+ " Is Manger " + entry.isManager());
		entry.printOptions();

	}
	@Test
	void getDepartmentEmployeeByUserId() {
		DepartmentEmployee entry = DepartmentEmployeeDAO.DepartmentEmployeeDAOImp.getDepartmentEmployeeByUserId(5);

		System.out.println("getDepartmentEmployeeByUserId ");

		System.out.println("ID: " + entry.getId() + " DepID: " + entry.getDepartmentId().getId() + " DepName: "
				+ entry.getDepartmentId().getName() + "  DepLocation " + entry.getDepartmentId().getLocation()
				+ " Is Manger " + entry.isManager());
		entry.printOptions();

	}
	@Test
	public void userLogin( ) {
		UserCredential cr =  UserDAOmaria.UserDAOImplementaion.userLogin("123", "admin");
	System.out.println("userLogin");	System.out.println(cr.getLastLogin() ) ; cr.getUser(cr.getUserId()).printOptions();
	}
	 
}
