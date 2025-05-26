package gamingstoresystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StoreSystem {
      	private List<Game> game;// ArrayList for Game
	private List<Product> product;// ArrayList for product
	private List<Customer> customer;// ArrayList for customer
        
        // counting the avalible decrease in delete
	private int countGameAvalible;
	private int countProductAvalible;
	private int countCustomerAvalible;
	
	// count the add without delete
	private int countGameOrder;
	private int countProductOrder;
	private int countCustomerOrder;
	
	// update item
	private int countGameUpdate;
	private int countProductUpdate;
	private int countCustomerUpdate;
	
	// delete item coutn
	private int countGameDelete;
	private int countProductDelete;
	private int countCustomerDelete;
	
	// count buy
	private int countBuyGame;
	private int countBuyProduct;
	
	// count sales
	private double countSalesGame;
	private double countSalesProduct;
	
	private final String LINE_BIG = "\n\t==============================\n";
	
	public StoreSystem() {
		// arraylist of object
		this.game = new ArrayList<>();
		this.product = new ArrayList<>();
		this.customer = new ArrayList<>();

		// count avalible
		this.countGameAvalible = 0;
		this.countProductAvalible = 0;
		this.countCustomerAvalible = 0;
		
		// order count
		this.countGameOrder = 1;
		this.countProductOrder = 1;
		this.countCustomerOrder = 1;
		
		// update count
		this.countGameUpdate = 0;
		this.countProductUpdate = 0;
		this.countCustomerUpdate = 0;
		
		// deleted count
		this.countGameDelete = 0;
		this.countProductDelete = 0;
		this.countCustomerDelete = 0;
		
		// buy
		this.countBuyGame = 0;
		this.countBuyProduct = 0;	
		// sales
		this.countSalesGame = 0.0;
		this.countSalesProduct = 0.0;	
		
	}
	
	// for delete
	public int getCountGameUpdate() {
		return countGameUpdate++;
	}
	public int getCountProductUpdate() {
		return countProductUpdate++;
	}
	public int getCountCustomerUpdate() {
		return countCustomerUpdate++;
	}
	
	// for the add game count
	public int getCountGameOrder() {
		return countGameOrder++;
	}
	// for the add product count
	public int getCountProductOrder() {
		return countProductOrder++;
	}
	// for the add customer count
	public int getCountCustomerOrder(){
		return countCustomerOrder++;
	}
	
	// for check the emptiy
	public boolean checkGames() {
		return !game.isEmpty();
	}
        // for check the emptiy
	public boolean checkProducts() {
		return !product.isEmpty();
	}
        // for check the emptiy
	public boolean checkCustomers() {
		return !customer.isEmpty();
	}
	
	// add the game to the Game Arraylist
	public void addGame(Game game) {
		this.game.add(game);
		countGameAvalible++;
	}
	
        // add the game to the product Arraylist
	public void addProduct(Product product) {
		this.product.add(product);
		countProductAvalible++;
	}
        // add the game to the customer Arraylist
	public void addCustomer(Customer customer) {
		this.customer.add(customer);
		countCustomerAvalible++;
	}
	
        // search for game depand on id
	public Game searchGame(int id) {
		for (Game g : game) {
			if (g.getId() == id) {
				return g;
			}
		}
		return null;
	}
        // search for product depand on id
	public Product searchProduct(int id) {
		for (Product p : product) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
         // search for customer depand on id
	public Customer searchCustomer(int id) {
		for (Customer c : customer) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
        // delete game depand on id
	public boolean deleteGame(int id) {
		Game g = searchGame(id);
		if (g != null) {
			if (game.remove(g)) {
				countGameAvalible--;
				countGameDelete++;
			}
			return true;
		}
		return false;
	}
        // delete prodcut depand on id
	public boolean deleteProduct(int id) {
		Product p = searchProduct(id);
		if (p != null) {
			if (product.remove(p)) {
				countProductAvalible--;
				countProductDelete++;
			}
			return true;
		}
		return false;
	}
        // delete customer depand on id
	public boolean deleteCustomer(int id) {
		Customer c = searchCustomer(id);
		if (c != null) {
			if (customer.remove(c)) {
				countCustomerAvalible--;
				countCustomerDelete++;
			}
			return true;
		}
		return false;
	}
	
	// delete game depand on id //becuase we do not want the delete increase is buy
	public boolean deleteBuyGame(int id) {
		Game g = searchGame(id);
		if (g != null) {
			if (game.remove(g)) {
				countGameAvalible--;		
			}
			return true;
		}
		return false;
	}
        // delete prodcut depand on id //becuase we do not want the delete increase is buy
	public boolean deleteBuyProduct(int id) {
		Product p = searchProduct(id);
		if (p != null) {
			if (product.remove(p)) {
				countProductAvalible--;
			}
			return true;
		}
		return false;
	}
	// set new sales for game take a Game class for get the correct price for the object he buy
	public void setGameSales(Game game){
		if(game != null){
			this.countBuyGame++;
			this.countSalesGame += game.getPrice();
		}
	}
        // set sales for prdocut Product class for get the correct price for the object he buy
	public void setProductSales(Product product){
		if(product != null){
			this.countBuyProduct++;
			this.countSalesProduct += product.getPrice();
		}
	}
	// get the sales
	public double getTotalSales(){
		return  countSalesGame + countSalesProduct;
	}
	
        // to print the all game check before for user freindly
	public void printAllGameUser() {
		System.out.println(LINE_BIG + "\t-- All Game: Available(" + countGameAvalible + ") --" + LINE_BIG);
		if (!checkGames()) {
			System.out.println(LINE_BIG + "\t- No Games Available, Try Later." + LINE_BIG);
		} else {
			for (Game g : game) {
				System.out.println(g.toString());
			}
		}
	}
        // to print the all product check before for user freindly
	public void printAllProductUser() {
		System.out.println(LINE_BIG + "\t-- All Product: Available(" + countProductAvalible + ") --" + LINE_BIG);
		if (!checkProducts()) {
			System.out.println(LINE_BIG + "\t- No Products Available, Try Later." + LINE_BIG);
		} else {
			for (Product p : product) {
				System.out.println(p.toString());
			}
		}
	}
	 // to print the all game check before for user freindly
	public void printAllGameAdmin() {
		System.out.println(LINE_BIG + "\t-- All Game: Available(" + countGameAvalible + ") --" + LINE_BIG);
		if (!checkGames()) {
			System.out.println(LINE_BIG + "\t- No Games Available, Try Later." + LINE_BIG);
		} else {
			for (Game g : game) {
				System.out.println(g.printForAdmin());
			}
		}
	}
        // to print the all product check before for user freindly
	public void printAllProductAdmin() {
		System.out.println(LINE_BIG + "\t-- All Product: Available(" + countProductAvalible + ") --" + LINE_BIG);
		if (!checkProducts()) {
			System.out.println(LINE_BIG + "\t- No Products Available, Try Later." + LINE_BIG);
		} else {
			for (Product p : product) {
				System.out.println(p.printForAdmin());
			}
		}
	}
        // to print the all customer check before for user freindly
	public void printAllCustomerAdmin() {
		System.out.println(LINE_BIG + "\t-- All Customers: Available(" + countCustomerAvalible + ") --" + LINE_BIG);
		if (!checkCustomers()) {
			System.out.println(LINE_BIG + "\t- No Customers Available, Try Later." + LINE_BIG);
		} else {
			for (Customer c : customer) {
				System.out.println(c.toString());
			}
		}
	}
	
	
        // print the all game and product and customer for the admin
	public void printAllAdmin() {

		printAllGameAdmin();
		System.out.println();

		printAllProductAdmin();
		System.out.println();

		printAllCustomerAdmin();
		System.out.println();
	}
        // print for customer game and product 
	public void printAllUser() {

		printAllGameUser();
		System.out.println();
		
		printAllProductUser();
		System.out.println();
	}

	// for firint the all data in the system
	@Override
	public String toString() {
		return  LINE_BIG
			+ "\t     -- SYSTEM REPORT --"
			+ LINE_BIG + "\n"
			+ "\t   -- Sales Summary --\n"
			+ "\t- Games Bought       : " + countBuyGame + "\n"
			+ "\t- Game Sales         : " + countSalesGame + "$ Ryial\n"
			+ "\t- Products Bought    : " + countBuyProduct + "\n"
			+ "\t- Product Sales      : " + countSalesProduct + "$ Ryial\n"
			+ "\t- Total Sales        : " + getTotalSales() + "$ Ryial\n"
			+ LINE_BIG
			+ "\t   -- Game Inventory --\n"
			+ "\t- Games Added        : " + (countGameOrder - 1) + "\n"
			+ "\t- Games Updated      : " + countGameUpdate + "\n"
			+ "\t- Games Deleted      : " + countGameDelete + "\n"
			+ "\t- Games Available    : " + countGameAvalible + "\n"
			+ LINE_BIG
			+ "\t   -- Product Inventory --\n"
			+ "\t- Products Added     : " + (countProductOrder - 1) + "\n"
			+ "\t- Products Updated   : " + countProductUpdate + "\n"
			+ "\t- Products Deleted   : " + countProductDelete + "\n"
			+ "\t- Products Available : " + countProductAvalible + "\n"
			+ LINE_BIG
			+ "\t   -- Customer Records --\n"
			+ "\t- Customers Added    : " + (countCustomerOrder - 1) + "\n"
			+ "\t- Customers Updated  : " + countCustomerUpdate + "\n"
			+ "\t- Customers Deleted  : " + countCustomerDelete + "\n"
			+ "\t- Customers Available: " + countCustomerAvalible + "\n"
			+ LINE_BIG;

	}
}
