package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public ArrayList<Dish> createDishes()
	{
		//initialize the arraylist
		ArrayList<Dish> dishes = new ArrayList<Dish>();
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
						String[] ingredients = new String[isrows.length];
      			for(int j=0; j<isrows.length; j++)
      			{
      				//add an ingredient of that dish to the string array
      				irow = IngredientTable.getRow(con, isrows[j].getIngredient_id());
      				ingredients[j] = irow.getName();
      			}
      			dishes.add(new Dish(drows[i].getDish_id(), drows[i].getName(), drows[i].getDescription(), drows[i].getPrice(), ingredients));
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
	
	public ArrayList<Dish> refreshDishes(ArrayList<Dish> dishes)
	{
		dishes.clear();
		
		dishes = createDishes();
		
		return dishes;
	}
}
