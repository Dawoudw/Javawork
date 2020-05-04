package dev.wsd.entities;

import java.sql.Date;

import dev.wsd.daos.UserDAOmaria;
import dev.wsd.enums.REIMBURSEMENT_STATUS;

public class Reimbursement {

	int id;
	int submitEmp;
	int approvalEmp;
	double amount;
	short status;
	Date postdate;	
	String reason;
	String comment;
	
	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmitEmp() {
		return submitEmp;
	}

	public User getSubmitEmp(int userid) {
		return UserDAOmaria.UserDAOImplementaion.getUserById(userid);
	}

	public void setSubmitEmp(int submitEmp) {
		this.submitEmp = submitEmp;
	}

	public int getApprovalEmp() {
		return approvalEmp;
	}

	public User getApprovalEmp(int userid) {
		return UserDAOmaria.UserDAOImplementaion.getUserById(userid);
	}

	public void setApprovalEmp(int approvalEmp) {
		this.approvalEmp = approvalEmp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

 
 
 
	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
