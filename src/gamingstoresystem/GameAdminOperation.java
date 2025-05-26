
package gamingstoresystem;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class GameAdminOperation {
	private Scanner input;
	private StoreSystem store;
	private Handle handle;
	private Menu menu;
	private final String LINE = "\n\t==========================\n";// for good looking 
	
	public GameAdminOperation(Scanner input, Menu menu, StoreSystem store, Handle handle) {
		this.input = input;
		this.store = store;
		this.handle = handle;
		this.menu = menu;
	}
	
	// for add a game use the handle for input
	public void addGame() {
		boolean check = false;
		do {
			System.out.println(LINE+ "\t   -- Add a New Game --"+LINE);
			
			int id = handle.checkIdGame();//123

			String name = handle.checkName("Game Name").toUpperCase();

			String category = handle.checkName("Game Category");

			Date releaseDate = handle.checkReleaseDate();

			int ageRating = handle.checkAgeRating();

			double price = handle.checkPrice();
			
			//game add
			int order = store.getCountGameOrder();
			Game game = new Game(order, id, name, category, releaseDate, ageRating, price);
			store.addGame(game);
                       
			// print the add game
                        System.out.println(game.printForAdmin());
			System.out.println(LINE + "\t- Game Added Successfully!" + LINE);
			
			if (!handle.confirmYN("Add More Game")) {
				check = true;
			}

		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayAddGPC();
	}
	
	// search game for admin
	public void searchGame() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t  -- Search for a Game --" + LINE);

			// no data will out 
			if (!store.checkGames()) {
				store.printAllGameAdmin();
				System.out.print(">> Press Enter to back..");
				input.nextLine();
				System.out.println();
				menu.displaySearchAdminGPC();
				return;
			}

			int id = handle.checkNumSUD("Game");
			if (id == -1) {
				System.out.println("\n");
				store.printAllGameAdmin();
			} else {
				// 0 for back
				if (id == 0) {
					check = true;
				} else {
					// earch use the stor search Game
					Game game = store.searchGame(id);
					if (game != null) {
						System.out.println("\n>> Game Found ID: " + id);
						System.out.println(game.printForAdmin());
					} else {
						System.out.println(">> No Game Found with ID: " + id);
					}
					if (!handle.confirmYN("Search For More Games")) {
						check = true;
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displaySearchAdminGPC();

	}
	// update a game
	public void updateGame() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t   -- Update a Game --" + LINE);

			// if no data 
			if (!store.checkGames()) {
				store.printAllGameAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayUpdateGPC();
				return;
			}

			int id = handle.checkNumSUD("Game");

			if (id == -1) {
				System.out.println("\n");
				store.printAllGameAdmin();
			} else {
				if (id == 0) {
					check = true;
				} else {
					Game game = store.searchGame(id);
					if (game != null) {
						System.out.println("\n>> Game Found ID: " + id);
						System.out.println(game.printForAdmin());

						if (!handle.confirmYN("Do You Want To Update This Game")) {
							System.out.println(LINE + "\t- Update Game Cancelled!" + LINE);
						} else {
							// udpate the id
							if (handle.confirmYN("Update Game ID")) {
								boolean idCheck = false;
								do {
									System.out.println(">> Current ID: " + game.getId());
									int newId = handle.checkIdGame();

									if (store.searchGame(newId) == null) {
										game.setId(newId);
										idCheck = true;
									} else {
										System.out.println(">> Error: ID " + newId + " Already Exists!");
									}
								} while (!idCheck);
							}
							// udpate the game and confirm before to change the value
							if (handle.confirmYN("Update Game Name")) {
								input.nextLine();
								String name = handle.checkName("New Game Name (Current: " + game.getName() + ")").toUpperCase();
								game.setName(name);
							}

							if (handle.confirmYN("Update Game Category")) {
								input.nextLine();
								String category = handle.checkName("New Game Category (Current: " + game.getGameCategory() + ")");
								game.setGameCategory(category);
							}

							if (handle.confirmYN("Update Release Date")) {
								input.nextLine();
								System.out.println(">> Current Release Date: " + game.getGameReleaseDate());
								Date releaseDate = handle.checkReleaseDate();
								game.setGameReleaseDate(releaseDate);
							}

							if (handle.confirmYN("Update Age Rating")) {
								System.out.println(">> Current Age Rating: +" + game.getGameAgeRating());
								int ageRating = handle.checkAgeRating();
								game.setGameAgeRating(ageRating);
							}

							if (handle.confirmYN("Update Price")) {
								System.out.println(">> Current Price: " + game.getPrice() + "$ Ryial");
								double price = handle.checkPrice();
								game.setPrice(price);
							}

							store.getCountGameUpdate();
							System.out.println(LINE + "\t- Game Updated Successfully!" + LINE);
							System.out.println(game.printForAdmin());
						}
					} else {
						System.out.println(">> No Game Found With ID: " + id);
					}
					if (!handle.confirmYN("Do You Want To Update More Games")) {
						check = true;
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayUpdateGPC();
	}
	// delete game
	public void deleteGame() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t   -- Delete a Games --" + LINE);
			// if there not data will be out 
			if (!store.checkGames()) {
				store.printAllGameAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayDeleteGPC();
				return;
			}
			int id = handle.checkNumSUD("Game");

			if (id == -1) {
				System.out.println("\n");
				store.printAllGameAdmin();
			} else {
				// 0 to back
				if (id == 0) {
					check = true;
				} else {
					// search before the delete 
					Game game = store.searchGame(id);
					if (game != null) {
						System.out.println("\n>> Game to Delete ID: " + id);
						System.out.println(game.printForAdmin());
						// confirm the delete
						if (!handle.confirmYN("Are You Sure You Want to Delete This Game Data")) {
							System.out.println(">> Delete Game Cancelled!");
						} else {
							// game deleted
							if (store.deleteGame(id)) {
								System.out.println(LINE + "\t- Game Deleted Successfully!" + LINE);

								// check if no left to before ask for delete
								if (!store.checkGames()) {
									System.out.print(">> No Games Left to Delete, Press Enter to Back..");
									input.nextLine();
									check = true;
								} else {
									if (!handle.confirmYN("Delete More Games")) {
										check = true;
									}
								}
							} else {
								System.out.println(">> Failed to Delete The Game!");
							}
						}
					} else {
						System.out.println(">> No Game Found With ID: " + id);
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayDeleteGPC();
	}
}
