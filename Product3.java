// 19_20 Editable table
import java.lang.*;

public class Product3
{	private String code;
	private String name;
	private String category;
	private String distributor;	
	private double price;
	private int avail_quantity;
	private int order_quantity;	
//	private double amount;

	public Product3()
	{	this.name = this.distributor = "";
		this.price = 0.0;
		this.avail_quantity = 0;
		this.order_quantity = 0;		
//		this.amount = 0.0;
	}

	public Product3(String code, String name, String category, String distributor, double price, int avail_quantity, int order_quantity)
	{	this.code = code;
		this.name = name;
		this.category = category;		
		this.distributor = distributor;
		this.price = price;
		this.avail_quantity = avail_quantity;
		this.order_quantity = order_quantity;		
//		this.amount = Math.round((this.price * this.avail_quantity) * 100.0) / 100.0;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String name) {
		this.distributor = distributor;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvail_quantity() {
		return avail_quantity;
	}

	public void setAvail_quantity(int avail_quantity) {
		this.avail_quantity = avail_quantity;
	}
	
	public int getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
/*	public double getAmount() {
		return amount;
	}*/
}
