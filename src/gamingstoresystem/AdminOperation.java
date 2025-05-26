
package gamingstoresystem;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class AdminOperation {

	private Scanner input;
	private StoreSystem store;
	private Handle handle;
	private Menu menu;
	// admin pass
	private String adminPass;
	
	private final String LINE = "\n\t==========================\n";// for good looking 
	private final String LINE_BIG = "\n\t==============================\n";

	public AdminOperation(Scanner input, Menu menu, StoreSystem store, Handle handle) {
		this.input = input;
		this.store = store;
		this.handle = handle;
		this.menu = menu;
		this.adminPass = null; // no "" for check not emptiy
		
	}
	
	// for admin pass set
	public void setAdminPass(String adminPass){
		this.adminPass = adminPass;
	}
	// for get admin pass
	public String getAdminPass(){
		return adminPass;
	}
	
	// admin check pass and set
	public void adminLogin() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t    -- Admin Login --" + LINE);
                        // if the password not already set
			if (getAdminPass() == null) {
				String pass = handle.checkAdmin();
				// 0 to back
				if (pass.equals("0")) {
					System.out.println("\n");
					menu.displayHomeMenu();
					return;
				}
				System.out.println(LINE_BIG + "\t- The Password Can't Be Edited Later!" + LINE_BIG);
				// check to set the pass
				if (!handle.confirmYN("Are You Sure To Set This Password")) {
					System.out.println(">> You Need a Password to Enter!");
				} else {
					// set the apss
					setAdminPass(pass);
					System.out.println(">> Password Is Set.");
					check = true;
				}
			} else {
				
				System.out.print(">> Enter Your Password To Login (or 0 to Back): ");
				String pass = input.nextLine();
                                // 0 to back
				if (pass.equals("0")) {
					System.out.println("\n");
					menu.displayHomeMenu();
					return;
				} 
				// check the pass 
				else if (pass.equals(getAdminPass())) {
					System.out.println(LINE_BIG + "\t-- Welcome To The Admin Page --" + LINE_BIG);
					check = true;
				} else {
					System.out.println("\n>> Wrong Password, Try Again.");
				}
			}
		} while (!check);

		System.out.println("\n");
		menu.displayAdminMenu();
	}
	
	
	
       // print for the admin all game, product, customer.
	public void searchAllAdmin() {
		System.out.println(LINE_BIG + "\t     -- Print All Data --" + LINE_BIG);
		store.printAllAdmin();
		System.out.print(">> Press Enter To Back..");
		input.nextLine();
		menu.displaySearchAdminGPC();
	}

	// print the result for the buy and delete and avalible
	public void systemReport() {
		System.out.println(store.toString());
		System.out.print(">> Press Enter To Back..");
		input.nextLine();
		menu.displayAdminMenu();
	}    		
	
}
