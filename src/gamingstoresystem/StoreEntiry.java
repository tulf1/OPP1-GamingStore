package gamingstoresystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Administrator
 */
public class StoreEntiry {

	private int countOrder;
	private int id;
	private String name;
	private double price;
	private LocalDateTime addTime;// for the data time add
	private DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy (HH:mm)");// format the date for print
	private String formattedDate;// make it in string 

	public StoreEntiry(int countOrder, int id, String name, double price) {
		this.countOrder = countOrder;
		this.id = id;
		this.name = name;
		this.price = price;
		this.addTime = LocalDateTime.now();
		this.formattedDate = addTime.format(formatDate); // add the format 
	}
        // for the customer class
	public StoreEntiry(int countOrder, int id) {
		this.countOrder = countOrder;
		this.id = id;
		this.addTime = LocalDateTime.now();	
		this.formattedDate = addTime.format(formatDate);// add the format again for the customer 
	}
	public void setCountOrder(int countOrder) {
		this.countOrder = countOrder;
	}
	
	public int getCountOrder() {
		return countOrder;
	}	

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}	

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setAddTime(LocalDateTime addTime) {
		this.addTime = addTime;
	}
	
	public LocalDateTime getAddTime() {
		return addTime;
	}
	
	// format the add time date
	public String getFormatTime() {
		return formattedDate;
	}

}
