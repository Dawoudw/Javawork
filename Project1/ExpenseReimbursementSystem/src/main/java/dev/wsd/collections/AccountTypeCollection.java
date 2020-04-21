package dev.wsd.collections;
import java.util.ArrayList;

import dev.wsd.entities.*;
import dev.wsd.utils.PrintUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:23 AM
 */
public class AccountTypeCollection<T>  extends ArrayList <AccountType>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountTypeCollection(){

	}
	public void printOptions() {
		if (this != null) {
			PrintUtil.drawHyphenLn();
			PrintUtil.printLine("Enter the number between the Brackets to Select the Account Type :");
			PrintUtil.drawEqualLn();
			for (AccountType tr : this) {
				PrintUtil.printLine("[" + tr.getId() + "] for " + tr.getTypeName() + " .");
			}
			PrintUtil.drawUnderscoreLn();
		}
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

}