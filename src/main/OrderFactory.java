package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import db.DBInterface;
import db.wrapper.ArticlesTable;
import db.wrapper.DishTable;
import db.wrapper.PendingordersTable;

public class OrderFactory
{
  public static void createOrders(ArrayList<Order> orders)
  {
    //initialize the arraylist
    if(orders == null)
      orders = new ArrayList<Order>();
    //create needed variables
    PendingordersTable.Row orows[]; //rows of orders
    DishTable.Row drow; //current Dish (article) row
    ArticlesTable.Row arows[]; //row of all dishes (articles) of an order
    try
    {
      Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
      try
      {
        Connection con = DBInterface.connect();
        try
        {
          //get all orders
          orows = PendingordersTable.getAllRows(con);
          for(int i=0; i<orows.length; i++)
          {
            //get dishes of this order
            arows = ArticlesTable.getRows("order_number", orows[i].getPendingorders_id());
            int[] dish_ids = new int[arows.length];
            String[] dishes = new String[arows.length];
            for(int j=0; j<arows.length; j++)
            {
              //add a dish of that order to the string array
              drow = DishTable.getRow(con, arows[j].getDish_id());
              dish_ids[j] = drow.getDish_id();
              dishes[j] = drow.getName();
            }
            orders.add(new Order(orows[i].getPendingorders_id(), orows[i].getValue(), orows[i].getNotes(), orows[i].getCustomer_id(), orows[i].getTablenumber(), dish_ids, dishes));
          }
        }
        catch(Exception e)
        {
          gui.Error err = new gui.Error(new JFrame(), "Error: ", e.toString());
          err.setVisible(true);
          System.out.println("Error: " + e);
          e.printStackTrace();
        }
        finally
        {
          con.close();
        }
      }//try
      catch(SQLException e)
      {
        gui.Error err = new gui.Error(new JFrame(), "Could not connect to the database: ", e.toString());
        err.setVisible(true);
        System.out.println("Could not connect to the database: " + e);
        e.printStackTrace();
      }
    }//try
    catch (Exception e)
    {
      gui.Error err = new gui.Error(new JFrame(), "Could not load Database driver: ", e.toString());
      err.setVisible(true);
      System.out.println("Could not load DB driver: " + e);
      e.printStackTrace();
    }    
  }
  
  public static void refreshOrders(ArrayList<Order> orders)
  {
    if(orders != null)
      orders.clear();
    
    createOrders(orders);
  }
}
