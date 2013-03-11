package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import db.*;
import db.wrapper.DishTable;
import db.wrapper.IngredientsTable;
import db.wrapper.IngredientTable;

public class DishFactory
{
	
	
	public DishFactory()
	{
		
	}
	
	//get all dishes from the database into a java ArrayList
	public static void createDishes(ArrayList<Dish> dishes)
	{
		//initialize the arraylist
	  if(dishes == null)
	    dishes = new ArrayList<Dish>();
		//create needed variables
		DishTable.Row drows[]; //rows of dishes
		IngredientTable.Row irow; //current ingredient row
		IngredientsTable.Row isrows[]; //row of all ingredients of a dish
		try
    {
      Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
      try
      {
      	Connection con = DBInterface.connect();
      	try
      	{
      		//get all dishes
      		drows = DishTable.getAllRows(con);
      		for(int i=0; i<drows.length; i++)
      		{
      			//get ingredients of this dish
      			isrows = DBInterface.getIngredientsOf(drows[i].getDish_id());
						int[] ingredient_ids = new int[isrows.length];
						String[] ingredients = new String[isrows.length];
      			for(int j=0; j<isrows.length; j++)
      			{
      				//add an ingredient of that dish to the string array
      				irow = IngredientTable.getRow(con, isrows[j].getIngredient_id());
      				ingredient_ids[j] = irow.getIngredient_id();
      				ingredients[j] = irow.getName();
      			}
      			dishes.add(new Dish(drows[i].getDish_id(), drows[i].getName(), drows[i].getDescription(), drows[i].getPrice(), ingredient_ids, ingredients));
      		}
      	}
      	catch(Exception e)
      	{
      	  gui.Error err = new gui.Error(new JFrame(), "Error: ", e.toString());
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
        gui.Error err = new gui.Error(new JFrame(), "Could not connect to the database: ", e.toString());
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
	
	public static void refreshDishes(ArrayList<Dish> dishes)
	{
		if(dishes != null)
		  dishes.clear();
		
		createDishes(dishes);
	}
}
