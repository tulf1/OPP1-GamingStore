package gamingstoresystem;

/**
 *
 * @author Administrator
 */
public class Customer extends StoreEntiry {

	private String customerFName;
	private String customerLName;
	private String customerEmail;
	private int customerPhone;
	private boolean customerGender;

	public Customer(int countOrder,int id, String customerFName, String customerLName, String customerEmail, int customerPhone, boolean customerGender) {
		// call from the super calss second construct
		super(countOrder, id);
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerGender = customerGender;
	}

	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}
	
	public String getCustomerFName() {
		return customerFName;
	}
	
	public void setCustomerLName(String customerLName) {
		this.customerLName = customerLName;
	}
	
	public String getCustomerLName() {
		return customerLName;
	}	
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	public int getCustomerPhone() {
		return customerPhone;
	}
	
	public void setCustomerGender(boolean customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerGender() {
		return customerGender ? "Male" : "Female";
	}	

	@Override
	public String toString() {
		return "\t==============================\n"
			+ "\t- Customer Number   : #" + getCountOrder() + "\n"
			+ "\t- Customer ID       : " + getId() + "\n"
			+ "\t- Name              : " + getCustomerFName() + " " + getCustomerLName() + "\n"
			+ "\t- Email             : " + getCustomerEmail() + "\n"
			+ "\t- Phone             : +966|" + getCustomerPhone() + "\n"
			+ "\t- Gender            : " + getCustomerGender() + "\n"
			+ "\t- Time Added        : " + getFormatTime() + "\n"
			+ "\t==============================\n";
	}
	
}
