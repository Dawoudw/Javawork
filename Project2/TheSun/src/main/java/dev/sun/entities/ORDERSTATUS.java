package dev.sun.entities;

import java.util.HashMap;
import java.util.Map;

public enum ORDERSTATUS {

	Submitted((short) 1), InProgress((short) 2), Ready((short) 3), OutForDelivery((short) 4), Delivered((short) 5),
	Canceled((short) 6);

	private short value;
	private static Map map = new HashMap<>();

	private ORDERSTATUS(short value) {
		this.value = value;
	}

	static {
		for (ORDERSTATUS status : ORDERSTATUS.values()) {
			map.put(status.value, status);
		}
	}

	public static ORDERSTATUS valueOf(short status) {
		return (ORDERSTATUS) map.get(status);
	}

	public short getValue() {
		return value;
	}

}
