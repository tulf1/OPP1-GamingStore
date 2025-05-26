package gamingstoresystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Handle {

	private Scanner input;
	private StoreSystem store;

	public Handle(Scanner input, StoreSystem store) {
		this.input = input;
		this.store = store;
	}
	// check the switch option reguler exprestion
        public String checkAdmin() {
		String pass = "";
		boolean check = false;
		do {
			System.out.print(">> Enter Admin Password (or 0 to Back): ");
			pass = input.nextLine().trim();
			if (pass.equals("0")) {// for back
				return "0"; 
			} else if (pass.isEmpty()) {
				System.out.println("\n>> Password Can't Be Empty!");

			}
			// more than 6
			else if (pass.length() < 6) {
				System.out.println("\n>> Invalid Password Format! Must Be at Least 6 Characters.");
			} 
			// check the Uppeer
			else if (!pass.matches(".*[A-Z].*")) {
				System.out.println("\n>> Invalid Password Format! Must Contain at Least One Upper Letter.");
			}
			// for number
			else if (!pass.matches(".*\\d.*")) {
				System.out.println("\n>> Invalid Password Format! Must Contain at Least One Number.");

			} else {
				check = true;
			}
		} while (!check);
		return pass;

	}
	
	// check the swhitch input
	public int checkSwitch(int size) {
		int choice = -1;
		boolean check = false;
		String option = "";
		// make the option value 
		for (int i = 1; i <= size; i++) {
			option += i + ", ";
		}
		// check the input number and the size of the choice
		do {
			System.out.print(">> Please Enter a Number (" + option + "0): ");
			try {
				choice = input.nextInt();
				input.nextLine();

				if (choice >= 0 && choice <= size) {
					check = true;
				}

				if (check) {
					System.out.println(">> You Choice is: " + choice + "\n");
				} else {
					System.out.println(">> Invalid Choice. Please Enter " + option + "0!");
				}

			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return choice;
	}

	
	// check the id for the game it a true and not found before
	public int checkIdGame() {
		int id = -1;
		boolean check = false;
		do {
			System.out.print(">> Enter Game ID (Less 3 And Max 10 Numbers): ");
			try {
				id = input.nextInt();
				input.nextLine();

				if (id <= 0) {
					System.out.println(">> Invalid Input. Please Don't Enter Negative Numbers Or Zero!");
				} else if (String.valueOf(id).length() < 3) {
					System.out.println(">> Invalid Input. You Can't Enter Less than 3 Number!");
				} else if (String.valueOf(id).length() > 10) {
					System.out.println(">> Error: The ID Exceeds Maximum Length (10 Nmbuers)!");
				} else {
					// for check is the id already there
					Game game = store.searchGame(id);
					if (game != null) {
						System.out.println("\n>> Error: A Game With This ID (" + id + ") Already Exists!");
						System.out.println(game.printForAdmin());
						System.out.println(">> You Can't Add a Game With The Same ID: " + id);

					} else {
						check = true;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return id;
	}
	// check the id for the Product it a true and not found before
	public int checkIdProduct() {
		int id = -1;
		boolean check = false;
		do {
			System.out.print(">> Enter Product ID (Less 3 And Max 10 Numbers): ");
			try {
				id = input.nextInt();
				input.nextLine();

				if (id <= 0) {
					System.out.println(">> Invalid Input. Please Don't Enter Negative Numbers Or Zero!");
				} else if (String.valueOf(id).length() < 3) {
					System.out.println(">> Invalid Input. You Can't Enter Less than 3 Number!");
				} else if (String.valueOf(id).length() > 10) {
					System.out.println(">> Error: The ID Exceeds Maximum Length (10 Nmbuers)!");
				} else {
					// for check is the id already there
					Product product = store.searchProduct(id);
					if (product != null) {
						System.out.println("\n>> Error: A Product With This ID (" + id + ")  Already Exists!");
						System.out.println(product.printForAdmin());
						System.out.println(">> You Can't Add a Product With The Same ID: " + id);

					} else {
						check = true;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return id;
	}
	// check the id for the Product it a true and not found before
	public int checkIdCustomer() {
		int id = -1;
		boolean check = false;
		do {
			System.out.print(">> Enter Customer ID (Less 3 And Max 10 Numbers): ");
			try {
				id = input.nextInt();
				input.nextLine();

				if (id <= 0) {
					System.out.println(">> Invalid Input. Please Don't Enter Negative Numbers Or Zero!");
				} else if (String.valueOf(id).length() < 3) {
					System.out.println(">> Invalid Input. You Can't Enter Less than 3 Number!");
				} else if (String.valueOf(id).length() > 10) {
					System.out.println(">> Error: The ID Exceeds Maximum Length (10 Nmbuers)!");
				} else {
					// for check is the id already there
					Customer customer = store.searchCustomer(id);
					if (customer != null) {
						System.out.println("\n>> Error: A Customer With This ID (" + id + ") Already Exists!");
						System.out.println(customer.toString());
						System.out.println(">> You Can't Add a Customer With The Same ID: " + id);

					} else {
						check = true;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return id;
	}
		
	// check the input number in search and delete
	public int checkNumBuy(String name) {
		int searchId = -1; 
		boolean check = false;
		do {
			System.out.print(">> Enter " + name + " ID To Buy (or 0 to back): ");
			try {
				searchId = input.nextInt();
				if (searchId < 0) {
					System.out.println(">> Error: You Can't Enter Less than 0!");
				} else {
					check = true;
				}

			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return searchId;
	}
	
	// check the input number in search and delete we not can use the above because the -1 we need it
	public int checkNumSUD(String name) {
		int searchId = -2; // beacause the print all is -1
		boolean check = false;
		do {
			System.out.print(">> Enter " + name + " ID (or -1 to view all or 0 to back): ");
			try {
				searchId = input.nextInt();
				if (searchId < -1) {
					System.out.println(">> Error: You Can't Enter Less than -1!");
				} else {
					check = true;
				}

			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return searchId;
	}

	// check for name not empity of to long and for descripe also
	public String checkName(String namePlace) {

		String name = "";
		boolean check = false;
		do {
			System.out.print(">> Enter " + namePlace + ": ");
			name = input.nextLine().trim();
			if (name.isEmpty()) {
				System.out.println(">> " + namePlace + " Can't Be Empty!");
			} else if (name.length() > 45) {
				System.out.println(">> " + namePlace + " Is Too Long! Maximum 45 Characters.");
			} else {
				check = true;
			}
		} while (!check);

		return name;
	}

	// check for email use the Regular Expressions
	public String checkEmail() {
		String email = "";
		boolean check = false;

		do {
			System.out.print(">> Enter Email: ");
			email = input.nextLine().trim();

			if (email.isEmpty()) {
				System.out.println(">> Email Cannot Be Empty!");			
			} 
			// for check the @ and the . for email
			else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
				System.out.println(">> Invalid Email Format! Must Contain '@' and '.'");
			} else {
				check = true;
			}
		} while (!check);

		return email;
	}

	// Method to check and validate gender input
	public boolean checkGender() {
		boolean gender = false;
		boolean check = false;

		do {
			System.out.print(">> Enter Gender Male or Female (m/f): ");
			String genderInput = input.nextLine().toLowerCase().trim();// to lower to check the value

			if (genderInput.startsWith("m")) {
				gender = true;// for the getCustomer gneder true is the male
				check = true;
			} else if (genderInput.startsWith("f")) {
				gender = false;// for the getCustomer gneder false is the female
				check = true;
			} else {
				System.out.println(">> Invalid Input. Please Enter 'm' For Male Or 'f' For Female!");
			}
		} while (!check);

		return gender;
	}
	
	public double checkPrice() {
		double price = -1;
		boolean check = false;

		do {
			System.out.print(">> Enter The Price: ");
			String input_str = input.nextLine();

			try {
				input_str = input_str.replace(',', '.');
				price = Double.parseDouble(input_str);

				if (price <= 0) {
					System.out.println(">> Invalid Input. The Price Can't Be Negative Or Zero!");
				} else {
					return price; 
				}
			} catch (NumberFormatException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
			}
		} while (!check);
             
		return price;
	}
	
	//  check age rating from 
	public int checkAgeRating() {
		int age = -1;
		boolean check = false;

		do {
			System.out.print(">> Enter Age Rating (Max +18): ");
			try {
				age = input.nextInt();
				input.nextLine();

				// not can be 0
				if (age <= 0) {
					System.out.println(">> Invalid Input. Age Rating Can't Be Negative or Zero!");
				} 
				// not can be more then 18 becuase the max rating is +18
				else if (age > 18) {
					System.out.println(">> Warning: Age Rating Can't Be Greater Than +18!");
				} else {
					check = true;
				}
			} catch (InputMismatchException e) {
				System.out.println(">> Invalid Input. Please Enter a Number.");
				input.nextLine();
			}
		} while (!check);

		return age;
	}

	// check the phone number
	public int checkPhoneNumber() {

		boolean check = false;
		String phoneStr;
		int phone = -1;

		do {
			System.out.print(">> Enter Phone Number: +966| ");
			phoneStr = input.nextLine().trim();  // Read as string first

			try {
				// First check length before parsing to int
				if (phoneStr.length() != 9) {
					System.out.println(">> Invalid Input. Phone Number Must Be 9 Digits!");
					continue;
				}

				// Check if starts with 5
				if (!phoneStr.startsWith("5")) {
					System.out.println(">> Error: Phone Number Should Start With 5!");
					continue;
				}

				// Parse to int only after validation
				phone = Integer.parseInt(phoneStr);
				check = true;

			} catch (NumberFormatException e) {
				System.out.println(">> Invalid Input. Please Enter Numbers Only.");
			}
		} while (!check);

		return phone;
	}
	// check if the date corect // check to edit later
	public Date checkReleaseDate() {
		boolean check = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); // make the date not excpert any format only the yyyy-MM-dd
		Date releaseDate = null;

		do {
			System.out.print(">> Enter release date (yyyy-MM-dd): ");
			String date = input.nextLine().trim();

			try {
				releaseDate = dateFormat.parse(date); // format
				Date currentDate = new Date(); // for the date is now 

				// if the date in future give waring and chech for future game not release
				if (releaseDate.after(currentDate)) {
					System.out.println(">> Warning: Future release date!");
					if (!confirmYN("Confirm This Date")) {
						continue;
					}
				}
				return releaseDate; // the exit
				
			} catch (Exception e) {
				System.out.println("\n>> Invalid Date Format. Use yyyy-MM-dd.");
			}
		} while (!check);

		return releaseDate;// for the method
	}
	
	// check for yes and no awnser
	public boolean confirmYN(String name) {
		boolean check = false;
		do {
			System.out.print(">> " + name + " (y/n)? ");
			String checkYN = input.next().trim().toLowerCase();
			if (checkYN.isEmpty()) {
				System.out.println(">> Invalid input. Please enter 'y' or 'n'.");
			} else if (checkYN.startsWith("y")) {
				return true;
			} else if (checkYN.startsWith("n")) {
				return false;
			} else {
				System.out.println(">> Invalid input. Please enter 'y' or 'n'.");
			}
		} while (!check);

		return check;
	}

}
