package main;

import java.util.Arrays;
import java.util.Date;

public class Order
{

 

  private int pendingorders_id;
  private double price;
  private Date date;
  private String notes;
  private int customer_id;
  private int tablenumber;
  private int[] dish_id;
  private String[] dishes;
  
  
  
  public Order() {
    super();
    //empty constructor to build an order
  }

  public Order(int number, double price, Date date, String notes, int customer_id,
      int tablenumber, int[] dish_id, String[] dishes) {
    super();
    this.pendingorders_id = number;
    this.price = price;
    this.date = date;
    this.notes = notes;
    this.customer_id = customer_id;
    this.tablenumber = tablenumber;
    this.dish_id = dish_id;
    this.dishes = dishes;
  }
  
  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Order(int number, double price, String notes, int customer_id,
      int tablenumber, int[] dish_id, String[] dishes) {
    super();
    this.pendingorders_id = number;
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
    this.pendingorders_id = number;
    this.price = price;
    this.notes = notes;
    this.tablenumber = tablenumber;
    this.dish_id = dish_id;
    this.dishes = dishes;
  }
  
  public ProcessedOrder process()
  {
    Date date = new Date();
    ProcessedOrder procOrder = new ProcessedOrder(pendingorders_id, price, date, notes, customer_id, tablenumber, dish_id, dishes);
    
    //remove itself from the databse
    
    //put itself into the ProcessedOrder Table
    
    //TODO implement delete Order in DBInterface
    
    
    return procOrder;
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

  public int getPendingorders_id()
  {
    return pendingorders_id;
  }
  
  public String dishesToString()
  {
    String names = "";
    
    for(int i=0; i<dishes.length; i++)
      names += dishes[i] + ", ";
    
    return names;
  }
  
  public String dishesToFeed()
  {
    String names = "";
    
    for(int i=0; i<dishes.length; i++)
      names += dishes[i] + "\n";
    
    return names;
  }

  @Override
  public String toString()
  {
    return "Order [number=" + pendingorders_id + ", price=" + price + ", notes=" + notes
        + ", customer_id=" + customer_id + ", tablenumber=" + tablenumber + "]";
  }
  
  
  
  
}
