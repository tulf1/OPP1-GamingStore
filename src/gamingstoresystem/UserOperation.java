package gamingstoresystem;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class UserOperation {

	private Scanner input;
	private StoreSystem store;
	private Handle handle;
	private Menu menu; 
        private final String LINE_BIG = "\n\t==============================\n";
	
	public UserOperation(Scanner input, Menu menu, StoreSystem store, Handle handle) {
		this.input = input;
		this.store = store;
		this.handle = handle;
		this.menu = menu;
		
	}

	// buy a game for the customer
	public void buyGame() {
		boolean check = false;

		do {
			store.printAllGameUser();// change for the  print
			// if there not data will be out 	
			if (!store.checkGames()) {
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayCustomerMenu(); // for skip the code 
				return;
			}

			int id = handle.checkNumBuy("Game");
			// 0 for back
			if (id == 0) {
				check = true;
			} else {
				// seach the game by id 
				Game game = store.searchGame(id);
				if (game != null) {
					System.out.println("\n>> Game Found ID: " + id);
					System.out.println(game.toString());

					if (!handle.confirmYN("Are You Sure You Want to Buy This Game")) {
						System.out.println(LINE_BIG + "\t- Transaction Game Cancelled Successfully." + LINE_BIG);
					} else {
						// the game is bought
						System.out.println(">> You Bought Game: " + game.getName() + "\n");
						System.out.println(game.toString());
						System.out.println(gameReceipt(game));// print the receipt
						store.setGameSales(game); // count the sales
						store.deleteBuyGame(id); // delete the game						
						System.out.println(LINE_BIG + "\t- Thank You For Buying From Our Gaming Store. <3" + LINE_BIG);

						// if no still left out wiithout ask for by more
						if (!store.checkGames()) {

							System.out.print(LINE_BIG + "\t- There no Games Left to Buy, Press Enter To Back.." + LINE_BIG);
							input.nextLine();
							check = true;
						} else {
							if (!handle.confirmYN("Want to buy more Games")) {
								check = true;
							}
						}
					}
				} else {
					System.out.println(">> No Game Found with ID: " + id);
				}

			}

		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayCustomerMenu();
	}

	// buy a product for a customer
	public void buyProduct() {
		boolean check = false;

		do {
			store.printAllProductUser();
			// if there not data will be out 
			if (!store.checkProducts()) {
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayCustomerMenu(); // for skip the code
				return;
			}

			int id = handle.checkNumBuy("Product");
			if (id == 0) {
				check = true;
			} else {
				Product product = store.searchProduct(id);
				if (product != null) {
					System.out.println("\n>> Product Found ID: " + id);
					System.out.println(product.toString());

					if (!handle.confirmYN("Are You Sure You Want to Buy This Product")) {
						System.out.println(LINE_BIG + "\t- Transaction Product Cancelled Successfully.");
					} else {
						// the game is bought
						System.out.println(">> You Bought Product: " + product.getName() + "\n");
						System.out.println(product.toString());
						System.out.println(prodcutReceipt(product));
						store.setProductSales(product);// count the sales
						store.deleteBuyProduct(id); // delete the product 
						System.out.println(LINE_BIG + "\t- Thank You For Buying From Our Gaming Store. <3" + LINE_BIG);

						// if no still left out wiithout ask for by more
						if (!store.checkProducts()) {
							System.out.print(LINE_BIG + "\t- There no Products Left to Buy, Press Enter To Back.." + LINE_BIG);
							input.nextLine();
							check = true;
						} else {
							if (!handle.confirmYN("Want to Buy More Products")) {
								check = true;
							}
						}
					}
				} else {
					System.out.println(">> No Product Found with ID: " + id);
				}

			}

		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayCustomerMenu();
	}
	
	// print all for customer for the buy game and product
	public void searchAllGameProdsuct() {
		System.out.println(LINE_BIG + "\t   -- ALL Available To Buy --" + LINE_BIG);
		store.printAllUser();
		System.out.print(">> Press Enter To Back..");
		input.nextLine();
		menu.displayCustomerMenu();
	}
	
	public String gameReceipt(Game game) {
		return   LINE_BIG
			+"\t=== GAME PURCHASE RECEIPT ===\n"
			+ "\tOrder Number: #" + game.getCountOrder()+"\n"
			+ "\tGame: " + game.getName() + "\n"
			+ "\tID: " + game.getId() + "\n"
			+ "\tCategory: " + game.getGameCategory() + "\n"
			+ "\tAge Rating: +" + game.getGameAgeRating() + "\n"
			+ "\tPrice: " + game.getPrice() + " Ryial\n"
			+ "\tPurchase Date: " + new Date() + "\n"
			+ "\tFrom: Gaming Store"
			+ LINE_BIG;
	}
	public String prodcutReceipt(Product product) {
		return LINE_BIG
			+ "\t=== PRODUCT PURCHASE RECEIPT ===\n"
			+ "\tOrder Number: #" + product.getCountOrder() + "\n"
			+ "\tProduct: " + product.getName() + "\n"
			+ "\tID: " + product.getId() + "\n"
			+ "\tDescription: " + product.getProductDescribe() + "\n"
			+ "\tPrice: " + product.getPrice() + " Ryial\n"
			+ "\tPurchase Date: " + new Date() + "\n"
			+ "\tFrom: Gaming Store"
			+ LINE_BIG;
	}
}
