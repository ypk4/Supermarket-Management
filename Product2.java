
public class Product2
{
	private String name2;

	private double price2;

	private int quantity2;

	private double amount2;


	public Product2()
	{
		this.name2 = "";

		this.price2 = 0.0;

		this.quantity2 = 0;

		this.amount2 = 0.0;

	}


	public Product2(String name2, double price2, int quantity2, Double amount2)
	{
		this.name2 = name2;

		this.price2 = price2;

		this.quantity2 = quantity2;

		this.amount2= amount2;
		System.out.println(this.name2 + this.quantity2 + this.price2 + this.amount2);
	}


	
	public String getName2() {

		return name2;

	}


	public void setName2(String name2) {

		this.name2 = name2;

	}


	public double getPrice2() {

		return price2;

	}


	public void setPrice2(double price2) {

		this.price2 = price2;

	}


	public int getQuantity2() {

		return quantity2;

	}


	public void setQuantity2(int quantity2) {

		this.quantity2 = quantity2;

	}

	
public double getAmount2() {

		return amount2;

	}

	
public void setAmount2(double amount2) {

		this.amount2 = amount2;

	}


}
