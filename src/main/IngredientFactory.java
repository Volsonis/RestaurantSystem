package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import db.DBInterface;
import db.wrapper.IngredientTable;

public class IngredientFactory
{

	public IngredientFactory()
	{
	  
	}
	
	public static void createIngredients(ArrayList<Ingredient> ingredients)
	{
		
		IngredientTable.Row[] rows;
		try
    {
      Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
      try
      {
      	Connection con = DBInterface.connect();
      	try
      	{
      		//get all ingredients
      		rows = IngredientTable.getAllRows(con);
      		for(int i=0; i<rows.length; i++)
      		{
      			//get ingredients of this dish
      		  Date date = Date.valueOf(rows[i].getExpires()); //converts a string in JDBC date escape format to a Date value
      			ingredients.add(new Ingredient(rows[i].getIngredient_id(), rows[i].getName(), rows[i].getStock(), rows[i].getPrice(), date));
      		}
      	}
      	catch(Exception e)
      	{
      	  gui.Error err = new gui.Error(new JFrame(), "Error", e.toString());
      	  err.setVisible(true);
      		System.out.println("Error: " + e);
      	}
      	finally
      	{
      		con.close();
      	}
      }//try
      catch(SQLException e)
      {
        gui.Error err = new gui.Error(new JFrame(), "Error connecting to database: ", e.toString());
        err.setVisible(true);
      	System.out.println("Could not connect to the database: " + e);
      }
    }//try
    catch (Exception e)
    {
      gui.Error err = new gui.Error(new JFrame(), "Could not load Database driver: ", e.toString());
      err.setVisible(true);
    	System.out.println("Could not load DB driver: " + e);
    }
		
	}
	
	public static void refreshIngredients(ArrayList<Ingredient> ingredients)
	{
	  if(ingredients != null)
	    ingredients.removeAll(ingredients);
		
		createIngredients(ingredients);
	}
}
