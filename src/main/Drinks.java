package main;

public class Drinks
{

  private int drinks_id;
  private String name;
  private double price;
  
  public Drinks(int drinks_id, String name, double price) {
    super();
    this.drinks_id = drinks_id;
    this.name = name;
    this.price = price;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public int getDrinks_id()
  {
    return drinks_id;
  }
  
  
  
}
