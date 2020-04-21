package dev.wael.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import dev.wael.controllers.*;
import dev.wsd.daos.ReimbursementDAO;
import dev.wsd.entities.*;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

class AdminTest {

	@Test
	void test() {
		Controller c = new Controller();
		User user = c.getuserbyId(0);
		user.printOptions();
		assertFalse(user == null);
		System.out.println(REIMBURSEMENT_STATUS.valueOf((short) 2));
		System.out.println(REIMBURSEMENT_STATUS.valueOf((short) 2).getValue());

		System.out.println(
				new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		java.util.Date date = new Date();
//		try {
//			date = format.parse(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Object param = new java.sql.Timestamp(date.getTime());
		System.out.println(param);

		// Since Java 8
		System.out.println(java.sql.Date.valueOf(java.time.LocalDate.now()));

		System.out.println(new java.sql.Timestamp(System.currentTimeMillis()));

		// Since Java 8
		System.out.println(java.sql.Timestamp.from(java.time.Instant.now()));
		System.out.println(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

	}

	@Test
	void InserReimbursement() {
		Reimbursement re = new Reimbursement();
		re.setAmount(100.00);
		re.setApprovalEmp(1);
		re.setSubmitEmp(2);
		re.setComment("Test");
		re.setReason("Test");
		re.setStatus((short) 1);
		re = ReimbursementDAO.ReimbursementDAOImp.addReimbursement(re);
		assertTrue(re.getId() > 0);
		System.out.println(re.getId());
	}

}
