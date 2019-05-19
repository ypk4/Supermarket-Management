// 19_20 Editable table

public class Product5
{
	//private String code;

	private String name;

	//private double price;

	private int quantity;

	private int srno;
	//private double amount;


	public Product5()
	{
	this.name = "";

		//this.price = 0.0;

		this.quantity = 0;

		this.srno = 1;
		//this.amount = 0.0;

	}


	public Product5(int srno, String name, int quantity)
	{
	//this.code = code;

		this.name = name;

		this.srno = srno;
		//this.price = price;
	
	this.quantity = quantity;

		//this.amount = Math.round((this.price * this.quantity) * 100.0) / 100.0;

	}

	

public String getName() {
	
	return name;

	}

	
public int getQuantity() {
	
	return quantity;

	}

	

public int getSrno() {
	
	return srno;

	}



}
