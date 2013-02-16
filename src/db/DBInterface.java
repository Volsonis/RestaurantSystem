package db;

import java.sql.SQLException;
import java.util.* ;
import com.javaranch.db.* ;

import db.wrapper.DishTable;
import db.wrapper.DishTable.Row;
import db.wrapper.IngredientTable;
import db.wrapper.IngredientsTable;

public class DBInterface
{
	
  //without stock(=0)
	public void addIngredient(String ingredient, Double price) throws SQLException
	{
		IngredientTable.Row row = IngredientTable.getRow();
		row.setName(ingredient);
		row.setPrice(price);
		row.setStock(0);
		row.insert();
		
	}
	
  public void addIngredient(String ingredient, Double price, int stock) throws SQLException
  {
		IngredientTable.Row row = IngredientTable.getRow();
		row.setName(ingredient);
		row.setPrice(price);
		row.setStock(stock);
		row.insert();
  }
  
  //just to test, later it should not be possible to add a dish without ingredients again
  public void addDish(int dish_id, String name,String description, Double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow();
  	row.setDish_id(dish_id);
  	row.setName(name);
  	row.setDescription(description);
  	row.setPrice(price);
  	row.insert();
  }
  
  //automatic ID
  public void addDish(String name,String description, Double price, String[] ingredients) throws SQLException
  {
  	//add dish
  	DishTable.Row drow = DishTable.getRow();
  	drow.setName(name);
  	drow.setDescription(description);
  	drow.setPrice(price);
  	drow.insert();
  	
  	Row row = DishTable.getRow("name", name);
  	int dish_id = row.getDish_id();
  	
  	//add ingredient
  	for(int i=0; i < ingredients.length; i++)
  	{
  		IngredientsTable.Row irow = IngredientsTable.getRow();
  		irow.setDish_id(dish_id);
  		irow.setIngredient_name(ingredients[i]);
  		irow.insert();
  	}//for
  	
  }//addDish
  
}
