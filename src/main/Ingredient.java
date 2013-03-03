package main;

public class Ingredient
{
	
	private String name;
	private int stock;
	private double price;
	
	public Ingredient(String name, int stock, double price)
	{
		super();
		this.name = name;
		this.stock = stock;
		this.price = price;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
}
