
package gamingstoresystem;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class ProdcutAdminOperation {
	private Scanner input;
	private StoreSystem store;
	private Handle handle;
	private Menu menu;
	private final String LINE = "\n\t==========================\n";// for good looking 
	
	public ProdcutAdminOperation(Scanner input, Menu menu, StoreSystem store, Handle handle) {
		this.input = input;
		this.store = store;
		this.handle = handle;
		this.menu = menu;
	}
	// for add a product
	public void addProduct() {
		boolean check = false;
		do {

			System.out.println(LINE + "\t  -- Add a New Product --" + LINE);
			int id = handle.checkIdProduct();

			String name = handle.checkName("Product Name").toUpperCase();

			String description = handle.checkName("Product Description");

			double price = handle.checkPrice();

			// add the product
			int order = store.getCountProductOrder();
			Product product = new Product(order, id, name, price, description);
			store.addProduct(product);

			// print product add
			System.out.println(product.printForAdmin());
			System.out.println(LINE + "\t- Product Added Successfully!"+ LINE);

			if (!handle.confirmYN("Add More Product")) {
				check = true;
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayAddGPC();

	}
	
	// search product for admin
	public void searchProduct() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t-- Search for a Product --" + LINE);
		
			// no data will out 
			if (!store.checkProducts()) {
				store.printAllProductAdmin();
				System.out.print(">> Press Enter to back..");
				input.nextLine();
				System.out.println();
				menu.displaySearchAdminGPC();
				
			}

			int id = handle.checkNumSUD("Product");

			if (id == -1) {
				System.out.println("\n");
				store.printAllProductAdmin();
			} else {
				// 0 for back
				if (id == 0) {
					check = true;
				} else {
					// earch use the stor search Product
					Product product = store.searchProduct(id);
					if (product != null) {
						System.out.println("\n>> Product Found ID: " + id);
						System.out.println(product.printForAdmin());
					} else {
						System.out.println(">> No Product Found with ID: " + id);
					}
					if (!handle.confirmYN("Search For More Products")) {
						check = true;
					}

				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displaySearchAdminGPC();

	}
	// update a prodcut
	public void updateProduct() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t  -- Update a Product --" + LINE);

			// if no data 
			if (!store.checkProducts()) {
				store.printAllProductAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayUpdateGPC();
				return;
			}

			int id = handle.checkNumSUD("Product");

			if (id == -1) {
				System.out.println("\n");
				store.printAllProductAdmin();
			} else {
				// zero to back
				if (id == 0) {
					check = true;
				} else {
					// search before the update by id
					Product product = store.searchProduct(id);
					if (product != null) {
						System.out.println("\n>> Product Found ID: " + id);
						System.out.println(product.printForAdmin());

						
						// confirm the update
						if (!handle.confirmYN("Do You Want To Update This Product")) {
							System.out.println(">> Update Product Cancelled!");
						} else {
							// update the id
							if (handle.confirmYN("Product Game ID")) {
								boolean idCheck = false;
								do{
								System.out.println(">> Current ID: " + product.getId());
								int newId = handle.checkIdProduct();
								
									if (store.searchProduct(newId) == null) {
										product.setId(newId); 
										idCheck = true;
									} else {
										System.out.println(">> Error: ID " + newId + " Already Exists!");
									}
								}while(!idCheck);
							}
							// udpate the game and confirm before to change the value
							if (handle.confirmYN("Update Product Name")) {
								input.nextLine();
								String name = handle.checkName("New Product Name (Current: " + product.getName() + ")").toUpperCase();
								product.setName(name);
							}

							if (handle.confirmYN("Update Product Description")) {
								input.nextLine();
								String description = handle.checkName("New Product Description (Current: " + product.getProductDescribe() + ")");
								product.setProductDescribe(description);
							}

							if (handle.confirmYN("Update Price")) {
								System.out.println(">> Current Price: " + product.getPrice() + "$ Ryial");
								double price = handle.checkPrice();
								product.setPrice(price);
							}

							store.getCountProductUpdate();
							System.out.println(LINE + "\t- Product Updated Successfully!" + LINE);
							System.out.println(product.printForAdmin());
						}
					} else {
						System.out.println(">> No Product Found With ID: " + id);
					}
					if (!handle.confirmYN("Do You Want To Update More Products")) {
						check = true;
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayUpdateGPC();
	}
	// delete product
	public void deleteProduct() {
		boolean check = false;
		do {
			System.out.println(LINE + "\t  -- Delete a Product --" + LINE);

			// if there not data will be out 
			if (!store.checkProducts()) {
				store.printAllProductAdmin();
				System.out.print(">> Press Enter to Back..");
				input.nextLine();
				System.out.println();
				menu.displayDeleteGPC();
				return;
			}

			int id = handle.checkNumSUD("Product");
			if (id == -1) {
				System.out.println("\n");
				store.printAllProductAdmin();
			} else {
				if (id == 0) {
					check = true;
				} else {
					Product product = store.searchProduct(id);
					if (product != null) {
						System.out.println("\n>> Product to Delete ID: " + id);
						System.out.println(product.printForAdmin());
						// confirm the delete
						if (!handle.confirmYN("Are You Sure You Want to Delete This Product Data")) {
							System.out.println(">> Delete Product Cancelled!");
							check = true;
						} else {
							// delete the product
							if (store.deleteProduct(id)) {
								System.out.println(LINE + "\t- Product Deleted Successfully!" + LINE);

								// check if no left to before ask for delete
								if (!store.checkProducts()) {
									System.out.print(">> No Products Left to Delete, Press Enter to Back..");
									input.nextLine();
									check = true;
								} else {
									if (!handle.confirmYN("Delete More Products")) {
										check = true;
									}
								}
							} else {
								System.out.println(">> Failed to Delete The Product!");
							}
						}
					} else {
						System.out.println(">> No Product Found With ID: " + id);
					}
				}
			}
		} while (!check);

		System.out.println("\n");
		input.nextLine();
		menu.displayDeleteGPC();
	}
}
