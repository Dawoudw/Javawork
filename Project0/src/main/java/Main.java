
import java.io.Console;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import javax.print.attribute.standard.DateTimeAtCompleted;

import dev.wsd.collections.AccountTransCollection;
import dev.wsd.collections.AccountTypeCollection;
import dev.wsd.collections.TransTypeCollection;
import dev.wsd.collections.UserAccountCollection;
import dev.wsd.collections.UserCollection;
import dev.wsd.daos.UserDAOmaria;
import dev.wsd.entities.*;
import dev.wsd.services.AdminService;
import dev.wsd.services.ClientService;
import dev.wsd.services.DataDAO;
import dev.wsd.utils.PrintUtil;
import dev.wsd.utils.ScannerUtil;

public class Main {

	public static UserCredential ValidateCredentials(String usernaem, String password) {
		ClientService.CurrentUserCredential = ClientService.ClientServiceOperation.login(password, usernaem);
//		if (crusr.getUser().getId() <= 0)
//			return ValidateCredentials(usernaem, password);
//		 
		return ClientService.CurrentUserCredential;
	}

	public static AccountTypeCollection<AccountType> accountTypeCollection = DataDAO.DataServiceOperation
			.getAccountTypes();;
	public static TransTypeCollection<TransactionType> transTypeCollection = DataDAO.DataServiceOperation
			.getTransactionTypes();

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		///// =========== Setup =========//////
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = java.util.Calendar.getInstance().getTime();

		PrintUtil.printLine("Welcome to MY Banking System , Today is :" + date);
		PrintUtil.drawHyphenLn();

		///// =========== Decalration =========//////
		String userInput = "";
		String exit = "";
		UserCollection<User> col = new UserCollection<User>();
		User uer = new User();
		UserCredential currentUser = new UserCredential();
		boolean systemRunable = true;
		///// =========== Code =========//////
		Scanner sc = ScannerUtil.singleScan();
		while (systemRunable) {
			PrintUtil.printLine("Enter [1] for Client Login , [2] for Admin Login ,  [3] to Register .");
			PrintUtil.drawEqualLn();
			PrintUtil.printLine(">>");
			userInput = sc.nextLine();
			boolean tryToLogin = true;
			try {
				switch (userInput) {
				case "3":
					PrintUtil.printLine("New User Registration ");
					PrintUtil.drawEqualLn();
					User newuser = new User();
					try {
						PrintUtil.printLine("Enter Fisrt Name  value  : ");
						String fni = sc.nextLine();
						PrintUtil.printLine("Enter Last Name  value  : ");
						String lni = sc.nextLine();
						PrintUtil.printLine("Enter Email  value  : ");
						String emi = sc.nextLine();
						newuser.setEmail(emi);
						newuser.setFname(fni);
						newuser.setLname(lni);
						newuser.setAdmin(false);
					} catch (Exception e) {
					}
					AdminService.AdminServiceOperation.createUser(newuser);
					// AdminService.AdminServiceOperation.getAllUsers().printOptions();

					break;
				case "1":
				case "2":
					int itr = 0;
					while (tryToLogin) {
						++itr;
						String pass = "";
						String usrname = "";
//						if (sc.hasNext()) {
						PrintUtil.printLine("Enter Useranme: ");
						usrname = sc.nextLine();

						PrintUtil.printLine("Password: ");
						pass = sc.nextLine();
						ValidateCredentials(usrname, pass);

						if (ClientService.CurrentUserCredential == null) {

							if (itr <= 5) {
								PrintUtil.printLine("Worng Username OR Password ,Invalid Try Num# " + itr + " Of 5");
								continue;
							} else {
								currentUser = null;
								// exit = "exit";
								tryToLogin = false;
								break;
							}

						} else {
							if (ClientService.CurrentUserCredential.getUser() != null
									&& (ClientService.CurrentUserCredential.getUser().getId() > 0 && itr <= 5)) {
								break;
							} else if (ClientService.CurrentUserCredential.getUser() == null
									|| (ClientService.CurrentUserCredential.getUser().getId() <= 0 && itr <= 5)) {
								PrintUtil.printLine("Worng Username Or Password , Try Num# " + itr + " Of 5");
								continue;
							} else if (ClientService.CurrentUserCredential.getUser() == null
									|| (ClientService.CurrentUserCredential.getUser().getId() <= 0 && itr >= 5)) {

								// ClientService.CurrentUserCredential = null;
								tryToLogin = false;
								// exit = "exit";
								break;

							}
						}

					}
					boolean UserIsLogged = true;
					User user = new User();
					while (UserIsLogged) {
						if (ClientService.CurrentUserCredential != null
								&& ClientService.CurrentUserCredential.getUser() != null
								&& ClientService.CurrentUserCredential.getUser().isAdmin()) {
							PrintUtil.printLine(
									"Welcome Back " + ClientService.CurrentUserCredential.getUser().getFname()
											+ ClientService.CurrentUserCredential.getUser().getLname()
											+ " | Your last login was in: "
											+ ClientService.CurrentUserCredential.getLastLogin());
							PrintUtil.drawHyphenLn();
							PrintUtil.printLine("Administration Operations :");
							boolean adminbreak = true;
							String adminoption;
					//		while (adminbreak) {
								PrintUtil.printLine(
										"Enter[4] List users , [5] Create User, [6] Update User, [7] to Delete User ,[exit]To Logout.");
								PrintUtil.drawEqualLn();

								adminoption = sc.nextLine();
								switch (adminoption) {
								case "exit":
									ClientService.ClientServiceOperation.logout(currentUser);
									UserIsLogged = false;
									continue;
								case "5":
//									PrintUtil.printLine("Enter User ID ,  Integer Numbe Only : ");
//									int id = Integer.parseInt(sc.nextLine()) ;
//									user = UserDAOmaria.UserDAOImplementaion.getUserById(id);
//									user.printOptions();
									try {
										user = new User();
										PrintUtil.printLine("Enter Fisrt Name  value  : ");
										String fni = sc.nextLine();
										PrintUtil.printLine("Enter Last Name  value  : ");
										String lni = sc.nextLine();
										PrintUtil.printLine("Enter Email  value  : ");
										String emi = sc.nextLine();
										user.setEmail(emi);
										user.setFname(fni);
										user.setLname(lni);
										user.setAdmin(false);
									} catch (Exception e) {
									}
									AdminService.AdminServiceOperation.createUser(user);
									// AdminService.AdminServiceOperation.getAllUsers().printOptions();

									continue;

								case "4":
									AdminService.AdminServiceOperation.getAllUsers().printOptions();
									continue;
								case "6":

									PrintUtil.printLine("Enter User ID ,  Integer Numbe Only : ");
									int id = Integer.parseInt(sc.nextLine());
									user = UserDAOmaria.UserDAOImplementaion.getUserById(id);
									user.printOptions();
									PrintUtil.printLine("Enter Fisrt Name new value  : ");
									String fn = sc.nextLine();
									PrintUtil.printLine("Enter Last Name new value  : ");
									String ln = sc.nextLine();
									PrintUtil.printLine("Enter Email new value  : ");
									String em = sc.nextLine();
									user.setEmail(em);
									user.setFname(fn);
									user.setLname(ln);
									AdminService.AdminServiceOperation.updateUser(user);
									user = UserDAOmaria.UserDAOImplementaion.getUserById(user.getId());
									user.printOptions();
									continue;

								case "7":
									user = new User();
									PrintUtil.printLine("Enter User ID ,  Integer Numbe Only : ");
									int iddel = Integer.parseInt(sc.nextLine());
									user.setId(iddel);
									AdminService.AdminServiceOperation.deleteUser(user);
									AdminService.AdminServiceOperation.getAllUsers().printOptions();
									continue;

								}

						//1	}

						} else if (ClientService.CurrentUserCredential != null
								&& ClientService.CurrentUserCredential.getUser() != null
								&& !ClientService.CurrentUserCredential.getUser().isAdmin()) {

							PrintUtil.printLine(
									"Enter[8] To View your Account(s) Summry , [9] Transactions History , [10] Withdraw, [11] Deposit,");
							PrintUtil.printLine(
									"Enter[12] To Open an Account , [13] Close an Account  , [exit] To Logout.");
							PrintUtil.drawEqualLn();
							PrintUtil.printLine(">>");
							String userinoption = sc.nextLine();
							switch (userinoption) {
							case "exit":
								ClientService.ClientServiceOperation.logout(ClientService.CurrentUserCredential);
								UserIsLogged = false;
								break;
							case "8":

								ClientService.ClientServiceOperation
										.getAccountInfoByUserId(ClientService.CurrentUserCredential.getUser().getId())
										.printOptions();

								continue;
							case "9":

								ClientService.ClientServiceOperation
										.viewTransaction(ClientService.CurrentUserCredential.getUser().getId())
										.printOptions();

								continue;
							case "10":
								UserAccountCollection<UserAccount> acco = ClientService.ClientServiceOperation
										.getAccountInfoByUserId(ClientService.CurrentUserCredential.getUser().getId());
								if (null == acco || acco.size() <= 0) {
									PrintUtil.printErrorLine(
											"There is no open accounts for you , Please select option [12] to open an account");

								} else {
									PrintUtil.printLine("Enter The Account Number: ");

									acco.printOptions();
									String acid = sc.next();
									AccountTransaction at = new AccountTransaction();
									UserAccount account = new UserAccount();

									if (!acco.stream().filter((b) -> b.getAccountNum().equals(acid)).findFirst()
											.isPresent())
										PrintUtil.printErrorLine("Invalid Account number ");
									else {
										account = acco.stream().filter((b) -> b.getAccountNum().equals(acid))
												.findFirst().get();
										PrintUtil.printLine("Enter Tansaction Amount : ");
										at.setTransAmount(sc.nextFloat());
										// int id = Integer.parseInt(sc.nextLine()) ;

										at.setTransAmount(sc.nextFloat());

										if (account.getCurrentBalance() < at.getTransAmount())
											PrintUtil.printErrorLine("The Entered amount: (" + at.getTransAmount()
													+ ") is more than the current balance in your account: ("
													+ account.getCurrentBalance() + ")");
										else {
											at.setAmountBefore(account.getCurrentBalance());
											TransactionType transt = DataDAO.DataServiceOperation
													.getTransactionTypeById(2);
											at.setTransType(transt);
											at.setAccount(account);

											ClientService.ClientServiceOperation.addTransaction(at);

											ClientService.ClientServiceOperation
													.viewTransaction(
															ClientService.CurrentUserCredential.getUser().getId())
													.printOptions();
										}
									}
								}

								continue;
							case "11":
								UserAccountCollection<UserAccount> accot = ClientService.ClientServiceOperation
										.getAccountInfoByUserId(ClientService.CurrentUserCredential.getUser().getId());
								if (null == accot || accot.size() <= 0) {
									PrintUtil.printErrorLine(
											"There is no open accounts for you , Please select option [12] to open an account");
								} else {
									PrintUtil.printLine("Enter The Account Number: ");
									accot.printOptions();
									String acidt = sc.next();

									AccountTransaction att = new AccountTransaction();
									UserAccount accountt = new UserAccount();

									if (!accot.stream().filter((b) -> b.getAccountNum().equals(acidt)).findFirst()
											.isPresent())
										PrintUtil.printErrorLine("Invalid Account number ");
									else {
										accountt = accot.stream().filter((b) -> b.getAccountNum().equals(acidt))
												.findFirst().get();
										PrintUtil.printLine("Enter Tansaction Amount : ");
										// int id = Integer.parseInt(sc.nextLine()) ;

										att.setTransAmount(sc.nextFloat());
										att.setAmountBefore(accountt.getCurrentBalance());
										TransactionType transtt = DataDAO.DataServiceOperation
												.getTransactionTypeById(1);
										att.setTransType(transtt);
										att.setAccount(accountt);
										ClientService.ClientServiceOperation.addTransaction(att);
										ClientService.ClientServiceOperation
												.viewTransaction(ClientService.CurrentUserCredential.getUser().getId())
												.stream().filter((t) -> t.getId() == att.getId()).findFirst().get()
												.printOptions();
									}
								}
								// AdminService.AdminServiceOperation.getAllUsers().printOptions();

								continue;
							case "12":
								PrintUtil.printLine("Select Account Type");

								accountTypeCollection.printOptions();
								int acountt = Integer.parseInt(sc.nextLine());
								AccountType accountType = DataDAO.DataServiceOperation.getAccountTypeById(acountt);
								UserAccount newaccount = new UserAccount();

								Random rand = new Random();
								int n = rand.nextInt(100);
								int m = rand.nextInt(100) * n;
								newaccount.setAccountType(accountType);
								newaccount.setActive(true);
								newaccount.setUser(ClientService.CurrentUserCredential.getUser());
								newaccount.setAccountNum("" + m);
								PrintUtil.printLine("Enter Start Amount: ");
								int openamount = Integer.parseInt(sc.nextLine());
								newaccount.setCurrentBalance(openamount);
								ClientService.ClientServiceOperation.openAccount(newaccount);

								ClientService.ClientServiceOperation
										.getAccountInfoByUserId(ClientService.CurrentUserCredential.getUser().getId())
										.printOptions();

								continue;
							case "13":
								UserAccountCollection<UserAccount> accolst = ClientService.ClientServiceOperation
										.getAccountInfoByUserId(ClientService.CurrentUserCredential.getUser().getId());
								if (null == accolst || accolst.size() <= 0) {
									PrintUtil.printErrorLine(
											"There is no open accounts for you , Please select option [12] to open an account");
								} else {
									accolst.printOptions();
									PrintUtil.printLine("Select the account you want to close");
									String accountnum = sc.nextLine();
									UserAccount uerAccount = new UserAccount();
									if (!accolst.stream().filter((b) -> b.getAccountNum().equals(accountnum))
											.findFirst().isPresent())
										PrintUtil.printErrorLine("Invalid Account number ");
									else {
										uerAccount = accolst.stream()
												.filter((b) -> b.getAccountNum().contentEquals(accountnum)).findFirst()
												.get();
										AccountTransCollection<AccountTransaction> transcol = ClientService.ClientServiceOperation
												.viewTransaction(ClientService.CurrentUserCredential.getUser().getId());
										int xid = uerAccount.getId();
										boolean buftranscol = transcol.stream()
												.filter((v) -> v.getAccount().getId() == xid).findFirst().isPresent();

										if (buftranscol) {
											PrintUtil.printErrorLine(
													"You can not close this account , as it has the some transations , select [9] to list all transactions");
											// transcol.printOptions();
										} else {

											PrintUtil.printWarningLine("Are you sure you want to delete the account #"
													+ uerAccount.getAccountNum()
													+ " ? Enter (Y) to Confirm , or any key to Cancel");

											String confirm = sc.nextLine();
											if (confirm.equals("y") || confirm.equals("Y")) {
												ClientService.ClientServiceOperation.closeAccount(uerAccount);
												ClientService.ClientServiceOperation
														.getAccountInfoByUserId(
																ClientService.CurrentUserCredential.getUser().getId())
														.printOptions();
											}

										}
									}
								}
								continue;

							}

						} else
							break;
					}

				case "exit":
					PrintUtil.printLineMessage("You have Logged out Successfully .");
					UserIsLogged =false; 
					break;
				// default:
				// break;
				}
			} finally {
//				userInput = sc.nextLine();
//				System.out.println(userInput);
			}
//Display the Admin Menu 

			// if (sc.hasNext()) {

			// }
			/// break Task;

		}
		// while (exit.equals("exit") == false)
		;
		PrintUtil.drawHyphenLn();

		if (null == ClientService.CurrentUserCredential || exit.equals("exit"))
			PrintUtil.printLineMessage("You have Logged out Successfully .");

//		col = AdminService.AdminServiceOperation.getAllUsers();
//		for (User var : col) {
//			System.out.println(var.getId() + var.getFname() + var.getEmail());
//		}

//		User usr = new Admin();
//		Admin admin = new Admin();
//		usr.setFname("waaa")  ;
//		usr.id = 20;
//		usr.lname = "sdsds";
//		admin.fname = "Admin";
//		admin.lname = "Admin F";
//		admin.IsAdmin = 100;
//		admin.id = 30;
//		act.add(usr);
//		act.add(admin);
////		 Admin d = (Admin) usr;
////			d.IsAdmin = 10;
//		// User u = (User) admin;
//		// u.fname = "AHmed";
//
//		for (Actor a : act) {
//			Admin admin1 = (Admin) a;
//			System.out.println("IsAdmin:" + admin1.IsAdmin + " fname:" + admin1.fname + " lname:" + admin1.lname
//					+ " id:" + admin1.id);
//		}

	}

}
