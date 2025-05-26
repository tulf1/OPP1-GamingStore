package gamingstoresystem;

/**
 *
 * @author Administrator
 */
public class Product extends StoreEntiry {

	private String productDescribe;

	public Product(int countOrder, int id, String name, double price, String productDescribe) {
		// call from the super calss first construct
		super(countOrder, id, name, price);
		this.productDescribe = productDescribe;
	}
	
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}
	
	public String getProductDescribe() {
		return productDescribe;
	}

	@Override
	public String toString() {
		return "\t==============================\n"
			+ "\t- Product ID        : " + getId() + "\n"
			+ "\t- Product Name      : " + getName() + "\n"
			+ "\t- Description       : " + getProductDescribe() + "\n"
			+ "\t- Price             : " + getPrice() + "$ Ryial\n"
			+ "\t==============================\n";
	}
        // print data for admin
	public String printForAdmin() {
		return "\t==============================\n"
			+ "\t- Product Number    : #" + getCountOrder() + "\n"
			+ "\t- ID                : " + getId() + "\n"
			+ "\t- Name              : " + getName() + "\n"
			+ "\t- Description       : " + getProductDescribe() + "\n"
			+ "\t- Price             : " + getPrice() + "$ Ryial\n"
			+ "\t- Time Added        : " + getFormatTime() + "\n"
			+ "\t==============================\n";
	}


}
