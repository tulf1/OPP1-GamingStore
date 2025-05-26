package gamingstoresystem;


import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class StartMenu {

	private Menu menu;
	private StoreSystem store;
	private Handle handle;
	private AdminOperation admin;
	private UserOperation user;
	private GameAdminOperation gameOperation;
	private ProdcutAdminOperation prodcutOperation;
	private CustomerAdminOperation customerOperation;
	private Scanner input = new Scanner(System.in);
	private final String LINE = "\n\t==========================\n";
	private final String LINE_BIG = "\n\t========================================\n";
	private int welcome;
	
	public StartMenu(Menu menu) {
		this.menu = menu;
		this.store =  new StoreSystem();
		this.handle = new Handle(input, store);
		this.admin = new AdminOperation(input, menu, store, handle);
		this.user = new UserOperation(input, menu, store, handle);
		
		this.gameOperation = new GameAdminOperation(input, menu, store, handle);
		this.prodcutOperation = new ProdcutAdminOperation(input, menu, store, handle);
		this.customerOperation = new CustomerAdminOperation(input, menu, store, handle);
		
		this.welcome = 0;
	}

	public int getWelcome(){
		return welcome;
	}
	// scanner for home menu
	public void userChoiceHPage() {

		if(welcome == 0){
		  System.out.println(LINE + "\t- Welcome To The Gaming Store." + LINE);
		  welcome++;
		}
		System.out.println(">> Choose Your Role.");

		// return to the menu choice
		switch (handle.checkSwitch(2)) {
			case 1:
				menu.displayCustomerMenu();
				break;
			case 2:
				admin.adminLogin();
				break;
			case 0:
				menu.displayExitMenu();
				break;
		}
	}
	// scanner customer choice
	public void userChoiceCustomerPage() {

		System.out.println(">> What Do You Want To Buy?");

		switch (handle.checkSwitch(3)) {
			case 1:
				user.buyGame();
				break;
			case 2:
				user.buyProduct();
				break;
			case 3:
				user.searchAllGameProdsuct();
				break;
			case 0:
				menu.displayHomeMenu();
				break;
		}
	}
	// scanner admin choice page
	public void userChoiceAdminPage() {

		System.out.println(">> What Do You Want To Do Admin?");

		// return to the menu choice
		switch (handle.checkSwitch(5)) {
			case 1:
				menu.displayAddGPC();
				break;
			case 2:
				menu.displaySearchAdminGPC();
				break;
			case 3:
				menu.displayUpdateGPC();
				break;
			case 4:
				menu.displayDeleteGPC();
				break;
			case 5:
				admin.systemReport();
				break;
			case 0:
				menu.displayHomeMenu();
				break;
		}
	}
	// scanner add choice for admin
	public void userChoiceAddPage() {

		System.out.println(">> What Would You Like To Add?");

		// return to the menu choice
		switch (handle.checkSwitch(3)) {
			case 1:
				gameOperation.addGame();
				break;
			case 2:
				prodcutOperation.addProduct();
				break;
			case 3:
				customerOperation.addCustomer();
				break;
			case 0:
				menu.displayAdminMenu();
				break;
		}
	}
	// scanner search choice for the admin
	public void userChoiceSearchPage() {

		System.out.println(">> What Do You Want To Search For?");

		// return to the menu choice
		switch (handle.checkSwitch(4)) {
			case 1:
				gameOperation.searchGame();
				break;
			case 2:
				prodcutOperation.searchProduct();
				break;
			case 3:
				customerOperation.searchCustomer();
				break;
			case 4:
				admin.searchAllAdmin();
				break;
			case 0:
				menu.displayAdminMenu();
				break;
		}
	}
	
	// scanner update choice for admin
        public void userChoiceUpdatePage() {
		System.out.println(">> What Do You Want To Update?");

		// return to the menu choice
		switch (handle.checkSwitch(3)) {
			case 1:
				gameOperation.updateGame();
				break;
			case 2:
				prodcutOperation.updateProduct();
				break;
			case 3:
				customerOperation.updateCustomer();
				break;
			case 0:
				menu.displayAdminMenu();
				break;
		}
	}

	// scanner delete choice for admin
	public void userChoiceDeletePage() {

		System.out.println(">> What Do You Want To Delete?");

		// return to the menu choice
		switch (handle.checkSwitch(3)) {
			case 1:
				gameOperation.deleteGame();
				break;
			case 2:
				prodcutOperation.deleteProduct();
				break;
			case 3:
				customerOperation.deleteCustomer();
				break;
			case 0:
				menu.displayAdminMenu();
				break;
		}
	}
	// close the system
	public void closeSystem() {

		if (!handle.confirmYN("Are You Sure To Eixt The Gaming Store")) {
			menu.displayHomeMenu(); // back to the home
		} else {			
			System.out.println(LINE_BIG + "\t- Thank You For Using The Gaming Store, Good Bye :D" + LINE_BIG);
			input.close(); // close the scanner
			System.exit(0); // close the system
		}
	}
	
        
	
}
