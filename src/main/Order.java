package main;

public class Order
{

  private int number;
  private double price;
  private String notes;
  private int customer_id;
  private int tablenumber;
  private int[] dish_id;
  private String[] dishes;
  
  public Order(int number, double price, String notes, int customer_id,
      int tablenumber, int[] dish_id, String[] dishes) {
    super();
    this.number = number;
    this.price = price;
    this.notes = notes;
    this.customer_id = customer_id;
    this.tablenumber = tablenumber;
    this.dish_id = dish_id;
    this.dishes = dishes;
  }

  public Order(int number, double price, String notes, int tablenumber,
      int[] dish_id, String[] dishes) {
    super();
    this.number = number;
    this.price = price;
    this.notes = notes;
    this.tablenumber = tablenumber;
    this.dish_id = dish_id;
    this.dishes = dishes;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public int getCustomer_id()
  {
    return customer_id;
  }

  public void setCustomer_id(int customer_id)
  {
    this.customer_id = customer_id;
  }

  public int getTablenumber()
  {
    return tablenumber;
  }

  public void setTablenumber(int tablenumber)
  {
    this.tablenumber = tablenumber;
  }

  public int[] getDish_id()
  {
    return dish_id;
  }

  public void setDish_id(int[] dish_id)
  {
    this.dish_id = dish_id;
  }

  public String[] getDishes()
  {
    return dishes;
  }

  public void setDishes(String[] dishes)
  {
    this.dishes = dishes;
  }

  public int getNumber()
  {
    return number;
  }
  
  
  
}
