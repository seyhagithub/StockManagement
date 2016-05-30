import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stock implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String Name;
	private int ID;
	private double Price;
	private String dateImported ;
	private int qty;
	public Stock(){};
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String getDateImported() {
		return dateImported;
	}
	public void setDateImported(String dateImported) {
		this.dateImported = dateImported;
	}
	
	public Stock(int ID, String Name, double Price, int qty, String dateImported){
		this.Name = Name;
		this.ID = ID;
		this.Price = Price;
		this.dateImported = dateImported;
		this.qty = qty;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	

}
