package dev.wsd.collections;

import java.util.ArrayList;

import dev.wsd.entities.*;
import dev.wsd.utils.PrintUtil;

/**
 * @author Admin
 * @version 1.0
 * @created 07-Apr-2020 8:56:23 AM
 */
public class AccountTransCollection<T> extends ArrayList<AccountTransaction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountTransCollection() {

	}

	// name = city.getName() == null ? city.getName() : "N/A"
	public void printOptions() {
		if (this != null) {
			PrintUtil.drawHyphenLn();
			PrintUtil.printLine("Your  Account Transaction(s) Summary  :");
			PrintUtil.drawHyphenLn();
		
			for (AccountTransaction tr : this) {
				float AmountAfter = 0;
				PrintUtil.printLine("[ Account Num: " + tr.getAccount().getAccountNum() + "| Account Type: "
						+ tr.getAccount().getAccountType().getTypeName() + "| Transaction Type: "
						+ tr.getTransType().getTransName() + "| Transaction Date:" + tr.getTransDate() + "]");

				PrintUtil.printLine("[ Balance Before: " + tr.getAmountBefore() + "| Tansaction Amount: "
						+ tr.getTransAmount() + "| Balance After: "
						+ (AmountAfter = tr.getTransType().getId() == 1 ? tr.getTransAmount() + tr.getAmountBefore()
								: tr.getAmountBefore() - tr.getTransAmount())
						+ " ].");
				PrintUtil.drawHyphenLn();

			}
			PrintUtil.drawUnderscoreLn();
 
		}
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}