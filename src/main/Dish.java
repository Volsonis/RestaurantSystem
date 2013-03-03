package main;

public class Dish
{
	private int ID;
	private String name;
	private String descripton;
	private double price;
	private String[] ingredients;
	
	public Dish(int iD, String name, String descripton, double price, String[] ingredients)
	{
		super();
		ID = iD;
		this.name = name;
		this.descripton = descripton;
		this.price = price;
		this.ingredients = ingredients;
	}
	
	public Dish(int iD, String name, String descripton, double price)
	{
		super();
		ID = iD;
		this.name = name;
		this.descripton = descripton;
		this.price = price;
	}

	public String[] getIngredients()
	{
		return ingredients;
	}

	public void setIngredients(String[] ingredients)
	{
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
