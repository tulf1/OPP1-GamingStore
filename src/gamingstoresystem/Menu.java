package gamingstoresystem;

import java.util.logging.*;

/**
 *
 * @author Administrator
 */
public class Menu {

	private final String[] TEAM_LOGO = {
		"     _          _",
		"    |_|_      _|_|",
		"     _| |____| |_",
		"   _|  _      _  |_ ",
		" _|   |_|    |_|   |_",
		"|  _              _  |",
		"| | |  ________  | | |",
		"|_| |_|__    __|_| |_|",
		"      |__|  |__|",
		"   By - Gaming Team"
	};
	private final String WELCOME
		= "\n\t==========================\n"
		+ "\t       -- WELCOME --\n"
		+ "\t==========================\n\n";

	private final String SYSTEM_LOGO
		= "\t>>======================<<\n"
		+ "\t||     _____________    ||\n"
		+ "\t||    /            /|   ||\n"
		+ "\t||   /___________ / |   ||\n"
		+ "\t||  |            |  |   ||\n"
		+ "\t||  |   GAMING   |  |   ||\n"
		+ "\t||  |   STORE    |  /   ||\n"
		+ "\t||  |____________| /    ||";

	private final String HOME_PAGE
		= "\t||  (__HOMEPAGE__)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - CUSTOMER PAGE   ||\n"
		+ "\t||  2 - ADMIN PAGE      ||\n"
		+ "\t||  0 - EXIT            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String ADMIN_PAGE
		= "\t||  (_ADMINPLACE_)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - ADD ITEM        ||\n"
		+ "\t||  2 - SEARCH ITEM     ||\n"
		+ "\t||  3 - UPDATE ITEM     ||\n"
		+ "\t||  4 - DELETE ITEM     ||\n"
		+ "\t||  5 - SYSTEM REPORT   ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String CUSTOMER_PAGE
		= "\t||  (CUSTOMERPAGE)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - BUY GAMES       ||\n"
		+ "\t||  2 - BUY PRODUCTS    ||\n"
		+ "\t||  3 - SEE ALL         ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String ADD_GPC_PAGE
		= "\t||  (__ADDITEM___)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - GAME            ||\n"
		+ "\t||  2 - PRODUCT         ||\n"
		+ "\t||  3 - CUSTOMER        ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String SEARCH_ADMIN_GPC_PAGE
		= "\t||  (_SEARCHITEM_)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - GAME            ||\n"
		+ "\t||  2 - PRODUCT         ||\n"
		+ "\t||  3 - CUSTOMER        ||\n"
		+ "\t||  4 - PRINT ALL       ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String UPDATE_GPC_PAGE
		= "\t||  (_UPDATEITEM_)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - GAME            ||\n"
		+ "\t||  2 - PRODUCT         ||\n"
		+ "\t||  3 - CUSTOMER        ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String DELETE_GPC_PAGE
		= "\t||  (_DELETEITEM_)/     ||\n"
		+ "\t||                      ||\n"
		+ "\t||  1 - GAME            ||\n"
		+ "\t||  2 - PRODUCT         ||\n"
		+ "\t||  3 - CUSTOMER        ||\n"
		+ "\t||  0 - BACK            ||\n"
		+ "\t||                      ||\n"
		+ "\t>>======================<<";

	private final String EXIT_PAGE
		= "\t>>=========================<<\n"
		+ "\t||                         ||\n"
		+ "\t||     >> EXIT PAGE <<     ||\n"
		+ "\t||                         ||\n"
		+ "\t||    y - YES    n - NO    ||\n"
		+ "\t||                         ||\n"
		+ "\t>>=========================<<";	
	
	private StartMenu startMenu;

	public Menu() {
		this.startMenu = new StartMenu(this);// for start the startmenu

		try {
			this.displayStartLogo(); // for the logo
		} catch (InterruptedException ex) {
			Logger.getLogger("Errore: Unable To Download The Logo!");
		}
		this.displayHomeMenu();// display the home page
		
	}

	// display start logo
	public void displayStartLogo() throws InterruptedException {

		for (String logo : TEAM_LOGO) {
			System.out.println("\t" + logo);
			Thread.sleep(150); // delay the logo print by ms 
		}

		System.out.println("\n\t Loading Gaming Store...");
		System.out.print("\t ");

		for (int i = 0; i < 22; i++) {
			System.out.print("=");
			Thread.sleep(100); // delay the start by ms
		}
		System.out.println("\n\t" + WELCOME + "\n");
	}

	
	public void displayHomeMenu() {

		System.out.println(SYSTEM_LOGO + "\n" + HOME_PAGE);
		startMenu.userChoiceHPage();
	}
	// admin menu

	public void displayAdminMenu() {

		System.out.println(SYSTEM_LOGO + "\n" + ADMIN_PAGE);
		startMenu.userChoiceAdminPage();
	}
	// customer menu

	public void displayCustomerMenu() {
		System.out.println(SYSTEM_LOGO + "\n" + CUSTOMER_PAGE);
		startMenu.userChoiceCustomerPage();
	}
	// add menu

	public void displayAddGPC() {

		System.out.println(SYSTEM_LOGO + "\n" + ADD_GPC_PAGE);
		startMenu.userChoiceAddPage();
	}
	// search menu

	public void displaySearchAdminGPC() {

		System.out.println(SYSTEM_LOGO + "\n" + SEARCH_ADMIN_GPC_PAGE);
		startMenu.userChoiceSearchPage();
	}
	public void displayUpdateGPC() {
		System.out.println(SYSTEM_LOGO+ "\n" + UPDATE_GPC_PAGE);
		startMenu.userChoiceUpdatePage();
	}

	// delete menu
	public void displayDeleteGPC() {

		System.out.println(SYSTEM_LOGO + "\n" + DELETE_GPC_PAGE);
		startMenu.userChoiceDeletePage();
	}
	// 

	public void displayExitMenu() {
		System.out.println(EXIT_PAGE);
		startMenu.closeSystem();
	}
}
