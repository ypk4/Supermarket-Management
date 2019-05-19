// 19_20 Editable table
public class Product
{	private String code;
	private String name;
	private double price;
	private int quantity;
	private double amount;

	public Product()
	{	this.name = "";
		this.price = 0.0;
		this.quantity = 0;
		this.amount = 0.0;
	}

	public Product(String code, String name, double price, int quantity)
	{	this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.amount = Math.round((this.price * this.quantity) * 100.0) / 100.0;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return amount;
	}
}
