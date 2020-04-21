package dev.wsd.entities;

import java.sql.Date;

import dev.wsd.enums.REIMBURSEMENT_STATUS;

public class Reimbursement {

	int id;
	int submitEmp  ;
	int approvalEmp  ;
	double amount;
	REIMBURSEMENT_STATUS status;
	Date postdate;
	String reason;
	String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmitEmp() {
		return submitEmp;
	}

	public void setSubmitEmp(int submitEmp) {
		this.submitEmp = submitEmp;
	}

	public int getApprovalEmp() {
		return approvalEmp;
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

	public REIMBURSEMENT_STATUS getStatus() {
		return status;
	}

	public short getStatusValue() {
		return status.getValue();
	}

	public void setStatus(short status) {
		this.status = REIMBURSEMENT_STATUS.valueOf(status);
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
