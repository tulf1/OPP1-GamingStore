
package gamingstoresystem;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class CustomerAdminOperation{
	private Scanner input;
	private StoreSystem store;
	private Handle handle;
	private Menu menu;
	private final String LINE = "\n\t==========================\n";// for good looking 
	
	public CustomerAdminOperation(Scanner input, Menu menu, StoreSystem store, Handle handle) {
		this.input = input;
		this.store = store;
		this.handle = handle;
		this.menu = menu;
	}
	
	// for add a customer
	public void addCustomer() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t -- Add a New Customer --" + LINE);
			int id = handle.checkIdCustomer();

			String firstName = handle.checkName("First Name").toUpperCase();

			String lastName = handle.checkName("Last Name").toUpperCase();

			String email = handle.checkEmail();

			int phone = handle.checkPhoneNumber();

			boolean gender = handle.checkGender();

			// add the customer
			int order = store.getCountCustomerOrder();
			Customer customer = new Customer(order, id, firstName, lastName, email, phone, gender);
			store.addCustomer(customer);
			
			// print the cutomer add
			System.out.println(customer.toString());
			System.out.println(LINE + "\t- Customer Added Successfully!" + LINE);

			if (!handle.confirmYN("Add More Customer")) {
				check = true;
			}

		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayAddGPC();

	}
	
	// search for customer ffor admin
	public void searchCustomer() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t-- Search for a Customer --" + LINE);

			// if there not data will be out 
			if (!store.checkCustomers()) {
				store.printAllCustomerAdmin();
				System.out.print(">> Press Enter to back..");
				input.nextLine();
				System.out.println();
				menu.displaySearchAdminGPC();
				return;
			}

			int id = handle.checkNumSUD("Customer");

			if (id == -1) {
				System.out.println("\n");
				store.printAllCustomerAdmin();
			} else {
				// 0 to back
				if (id == 0) {
					check = true;
				} else {
					// earch use the stor search Customer
					Customer customer = store.searchCustomer(id);
					if (customer != null) {
						System.out.println("\n>> Customer Found ID: " + id);
						System.out.println(customer.toString());
					} else {
						System.out.println(">> No Customer Found with ID: " + id);
					}
					if (!handle.confirmYN("Search For More Customers")) {
						check = true;
					}

				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displaySearchAdminGPC();
	}
	
	// update a customer
	public void updateCustomer() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t  -- Update a Customer --" + LINE);

			// if no data 
			if (!store.checkCustomers()) {
				store.printAllCustomerAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayUpdateGPC();
				return;
			}

			int id = handle.checkNumSUD("Customer");
			if (id == -1) {
				System.out.println("\n");
				store.printAllCustomerAdmin();
			} else {
				if (id == 0) {
					check = true;
				} else {
					Customer customer = store.searchCustomer(id);
					if (customer != null) {
						System.out.println("\n>> Customer Found ID: " + id);
						System.out.println(customer.toString());

						if (!handle.confirmYN("Do You Want To Update This Customer")) {
							System.out.println(">> Update Customer Cancelled!");
						} else {
							// update the id
							if (handle.confirmYN("Update Customer ID")) {
								boolean idCheck = false;
								do {
									System.out.println(">> Current ID: " + customer.getId());
									int newId = handle.checkIdCustomer();

									if (store.searchCustomer(newId) == null) {
										customer.setId(newId);
										idCheck = true;
									} else {
										System.out.println(">> Error: ID " + newId + " Already Exists!");
									}
								} while (!idCheck);
							}
							// udpate the game and confirm before to change the value
							if (handle.confirmYN("Update Customer Fisrt Name")) {
								input.nextLine();
								String fName = handle.checkName("New Customer Fisrt Name (Current: " + customer.getCustomerFName() + ")").toUpperCase();
								customer.setCustomerFName(fName);
							}

							if (handle.confirmYN("Update Customer Last Name")) {
								input.nextLine();
								String lName = handle.checkName("New Customer Last Name (Current: " + customer.getCustomerLName() + ")").toUpperCase();
								customer.setCustomerLName(lName);
							}

							if (handle.confirmYN("Update Email")) {
								input.nextLine();
								System.out.println(">> Current Email: " + customer.getCustomerEmail());
								String email = handle.checkEmail();
								customer.setCustomerEmail(email);
							}

							if (handle.confirmYN("Update Phone Number")) {
								System.out.println(">> Current Phone Number: +966|" + customer.getCustomerPhone());
								int phone = handle.checkPhoneNumber();
								customer.setCustomerPhone(phone);
							}

							if (handle.confirmYN("Update Gender")) {
								input.nextLine();
								System.out.println(">> Current Gender: " + customer.getCustomerGender());
								boolean gender = handle.checkGender();
								customer.setCustomerGender(gender);
							}

							store.getCountCustomerUpdate();
							System.out.println(LINE + "\t- Customer Updated Successfully!" + LINE);
							System.out.println(customer.toString());
						}
					} else {
						System.out.println(">> No Customer Found With ID: " + id);
					}
					if (!handle.confirmYN("Do You Want To Update More Customers")) {
						check = true;
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayUpdateGPC();
	}
	// delete the customer
	public void deleteCustomer() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t  -- Delete a Customer --" + LINE);

			// if there not data will be out 
			if (!store.checkCustomers()) {
				store.printAllCustomerAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayDeleteGPC();
				return;
			}

			int id = handle.checkNumSUD("Customer");
			if (id == -1) {
				System.out.println("\n");
				store.printAllCustomerAdmin();
			} else {
				if (id == 0) {
					check = true;
				} else {
					Customer customer = store.searchCustomer(id);
					if (customer != null) {
						System.out.println("\n>> Customer to Delete ID: " + id);
						System.out.println(customer.toString());
						// confirm the delete
						if (!handle.confirmYN("Are You Sure You Want to Delete This Customer Data")) {
							System.out.println(">> Delete Customer Cancelled!");
							check = true;
						} else {
							// delete the customer
							if (store.deleteCustomer(id)) {
								System.out.println(LINE + "\t- Customer Deleted Successfully!" + LINE);

								// check if no left to before ask for delete
								if (!store.checkCustomers()) {
									System.out.print(">> No Customers Left to Delete, Press Enter to Back..");
									input.nextLine();
									check = true;
								} else {
									if (!handle.confirmYN("Delete More Customers")) {
										check = true;
									}
								}
							} else {
								System.out.println(">> Failed to Delete The Customer!");
							}
						}
					} else {
						System.out.println(">> No Customer Found With ID: " + id);
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayDeleteGPC();
	}
}
