package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import db.*;
import db.wrapper.DishTable;

public class DishFactory
{
	public ArrayList<Dish> getAllDishes()
	{
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		DishTable.Row rows[];
		try
    {
      Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
      try
      {
      	Connection con = DBInterface.connect();
      	try
      	{
      		rows = DBInterface.getAllDishes(con);
      		for(int i=0; i<rows.length; i++)
      		{
      			dishes.add(new Dish(rows[i].getDish_id(), rows[i].getName(), rows[i].getDescription(), rows[i].getPrice()));
      		}
      	}
      	catch(Exception e)
      	{
      		System.out.println("Error: " + e);
      	}
      	finally
      	{
      		con.close();
      	}
      }//try
      catch(SQLException e)
      {
      	System.out.println("Could not connect to the database: " + e);
      }
    }//try
    catch (Exception e)
    {
    	System.out.println("Could not load DB driver: " + e);
    }    
		
		return dishes;
		
	}
}
