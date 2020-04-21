package dev.wsd.collections;

import java.util.ArrayList;

import dev.wsd.entities.*;
import dev.wsd.services.DataDAO;
import dev.wsd.utils.PrintUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class TransTypeCollection<T> extends ArrayList<TransactionType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransTypeCollection() {

	}

	public void printOptions() {
		if (this != null) {
			PrintUtil.drawHyphenLn();
			PrintUtil.printLine("Enter the number between the Brackets to Select the Transaction Type :");
			PrintUtil.drawEqualLn();
			for (TransactionType tr : this) {
				PrintUtil.printLine("[" + tr.getId() + "] for " + tr.getTransName() + " .");
			}
			PrintUtil.drawUnderscoreLn();
		}
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}