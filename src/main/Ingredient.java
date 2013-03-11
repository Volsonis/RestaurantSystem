package main;

import java.sql.Date;
import java.util.Comparator;

public class Ingredient implements Comparator<Ingredient>
{
	
	private int id;
	private String name;
	private int stock;
	private Double price;
	private Date expires;
	
	public Ingredient(int id, String name, int stock, double price, Date expires)
	{
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.expires = expires;
	}

	public Ingredient(String name, int stock, Double price, Date expires) {
    super();
    this.name = name;
    this.stock = stock;
    this.price = price;
    this.expires = expires;
  }

  public Ingredient() {
    //empty constructor
  }

  public Date getExpires()
  {
    return expires;
  }



  public void setExpires(Date expires)
  {
    this.expires = expires;
  }



  public void setName(String name)
  {
    this.name = name;
  }

  public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
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

  @Override
  public String toString()
  {
    return "Ingredient [id=" + id + ", name=" + name + ", stock=" + stock
        + ", price=" + price + ", expires=" + expires + "]";
  }

  @Override
  public int compare(Ingredient arg0, Ingredient arg1)
  {
    //standart sorting in an arraylist will be by alphabet
    return arg0.getName().compareToIgnoreCase(arg1.getName());
  }
	
	
}
