package dev.wsd.enums;

import java.util.HashMap;
import java.util.Map;

public enum REIMBURSEMENT_STATUS {

	Submitted((short) 1), Approved((short) 2), Denied((short) 3);

	private short value;
	private static Map map = new HashMap<>();

	private REIMBURSEMENT_STATUS(short value) {
		this.value = value;
	}

	static {
		for (REIMBURSEMENT_STATUS status : REIMBURSEMENT_STATUS.values()) {
			map.put(status.value, status);
		}
	}

	public static REIMBURSEMENT_STATUS valueOf(short status) {
		return (REIMBURSEMENT_STATUS) map.get(status);
	}

	public short getValue() {
		return value;
	}
}
