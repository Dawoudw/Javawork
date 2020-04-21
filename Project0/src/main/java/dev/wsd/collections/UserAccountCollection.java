package dev.wsd.collections;
import java.util.ArrayList;

import dev.wsd.entities.*;
import dev.wsd.utils.PrintUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:24 AM
 */
public class UserAccountCollection<T>  extends ArrayList <UserAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAccountCollection(){

	}
	public void printOptions() {
		if (this != null) {
			PrintUtil.drawHyphenLn();
			PrintUtil.printLine("Your  Account (s) Summary  :");
			PrintUtil.drawEqualLn();
			for (UserAccount tr : this) {
				PrintUtil.printLine("[ Account Num: " + tr.getAccountNum() +  "| Account Type:  "+tr.getAccountType().getTypeName() +"| Available Balance:  " + tr.getCurrentBalance() + " ].");
				PrintUtil.drawHyphenLn();
			}
		PrintUtil.drawUnderscoreLn();
		}
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

}