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
import dev.wsd.daos.ReimbursementDAO;
import dev.wsd.entities.*;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

class ReimbursementTest {

	@Test
	void test() {
		Controller c = new Controller();
		User user = c.getuserbyId(0);
		user.printOptions();
//		assertFalse(user == null);
//		System.out.println(REIMBURSEMENT_STATUS.valueOf((short) 2));
//		System.out.println(REIMBURSEMENT_STATUS.valueOf((short) 2).getValue());
//
//		System.out.println(
//				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		java.util.Date date = new Date();
//		try {
//			date = format.parse(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		Object param = new java.sql.Timestamp(date.getTime());
//		System.out.println(param);

		// Since Java 8
//		System.out.println(java.sql.Date.valueOf(java.time.LocalDate.now()));
//
//		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));
//
//		// Since Java 8
//		System.out.println(java.sql.Timestamp.from(java.time.Instant.now()));
//		System.out.println(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

	}

	@Test
	void InserReimbursement() {
		Reimbursement re = new Reimbursement();
		re.setAmount(100.00);
		re.setApprovalEmp(1);
		re.setSubmitEmp(3);
		re.setComment("Test");
		re.setReason("Test");
		re.setStatus((short) 1);
		// re = ReimbursementDAO.ReimbursementDAOImp.addReimbursement(re);
		// assertTrue(re.getId() > 0);
		System.out.println(re.getId());
	}

	@Test
	void UdateReimbursement() {
		Reimbursement re = new Reimbursement();
		re.setAmount(100.00);
		re.setApprovalEmp(1);
		re.setSubmitEmp(2);
		re.setComment("Test");
		re.setReason("Test");
		re.setStatus((short) 2);
		re.setId(2);
		assertTrue(ReimbursementDAO.ReimbursementDAOImp.updateReimbursement(re));
	}

	@Test
	void UdateReimbursementStatus() {
		System.out.println("UdateReimbursementStatus ");
		assertTrue(ReimbursementDAO.ReimbursementDAOImp.changeReimbursementStatus(1, REIMBURSEMENT_STATUS.Denied));
	}

	@Test
	void getTotalRequestsByMangerId() {
		System.out.println("TotalRequestsByMangerId ");
		System.out.println(ReimbursementDAO.ReimbursementDAOImp.getTotalRequestsByMangerId(2));
	}

	@Test
	void getAvgReimbursements() {
		System.out.println("AvgReimbursements ");
		System.out.println(ReimbursementDAO.ReimbursementDAOImp.getAvgReimbursements());
	}

	@Test
	void getHighestRequester() {
		Hashtable<Integer, Double> ht = ReimbursementDAO.ReimbursementDAOImp.getHighestRequester();

		System.out.println("HighestRequester " + ht.size());

		for (Map.Entry entry : ht.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	@Test
	void getAllReimbursementsByApproverId() {
		ArrayList<Reimbursement> rlist = (ArrayList<Reimbursement>) ReimbursementDAO.ReimbursementDAOImp
				.getAllReimbursementsByApproverId(1);

		System.out.println("AllReimbursementsByApproverId ");

		for (Reimbursement entry : rlist) {
			System.out.println(entry.getId() + " " + entry.getAmount());
		}
	}

	@Test
	void getAllReimbursementsByEmployeeId() {
		ArrayList<Reimbursement> rlist = (ArrayList<Reimbursement>) ReimbursementDAO.ReimbursementDAOImp
				.getAllReimbursementsByEmployeeId(5);

		System.out.println("AllReimbursementsByEmployeeId ");

		for (Reimbursement entry : rlist) {
			System.out.println(entry.getId() + " " + entry.getAmount());
			System.out.println("ApprovalEmp ");
			entry.getApprovalEmp(entry.getApprovalEmp()).printOptions();
			System.out.println("SubmitEmp ");
			entry.getSubmitEmp(entry.getSubmitEmp()).printOptions();
		}
	}

	@Test
	void getReimbursementById() {
		Reimbursement rlist = ReimbursementDAO.ReimbursementDAOImp.getReimbursementById(2);

		System.out.println("ReimbursementById ");

		System.out.println(rlist.getId() + " " + rlist.getAmount());

	}
}
