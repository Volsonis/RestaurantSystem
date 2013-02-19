package db;

import java.sql.SQLException;

import java.sql.*;

import java.util.* ;
import com.javaranch.db.* ;

import db.wrapper.DishTable;
import db.wrapper.DishTable.Row;
import db.wrapper.IngredientTable;
import db.wrapper.IngredientsTable;

public class DBInterface
{
	//ADD
	//Ingredient
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
  
  
  //Dish
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
  
  
  
  //EDIT
  //Ingredient
  //stock
  public void editIngredientStock(String name, int stock) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow("name", name);
  	row.setStock(stock);
  	row.update("name", name);
  }
  
  public void editIngredientPrice(String name, double price) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow("name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
  
  
  //Dish
  public void editDishName(int dish_id, String name) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setName(name);
  	row.update();
  }
  
  //edit description by id
  public void editDishDescription(int dish_id, String description) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setDescription(description);
  	row.update();
  }
  
  //edit description by name
  public void editDishDescription(String name, String description) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow("name", name);
  	row.setDescription(description);
  	row.update("name", name);
  }
  
  //by id
  public void editDishPrice(int dish_id, double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setPrice(price);
  	row.update();
  }
  
  //by name
  public void editDishPrice(String name, double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow("name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
  
  
  /* Ingredients
   * this is slightly more complicated as the "ingredients" table is linked to this to store this information
   * 
   */
  public void addIngredients(String name, String ingredient) throws SQLException
  {
  	DishTable.Row drow = DishTable.getRow("name", name);
  	
  	IngredientsTable.Row irow = IngredientsTable.getRow();
  	irow.setDish_id(drow.getDish_id());
  	irow.setIngredient_name(ingredient);
  	irow.insert();
  }
  
  public void addIngredients(int dish_id, String ingredient) throws SQLException
  {
  	IngredientsTable.Row row = IngredientsTable.getRow();
  	row.setDish_id(dish_id);
  	row.setIngredient_name(ingredient);
  	row.insert();
  }
  
  public void deleteIngredients(String name, String ingredient) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
  {
  	DishTable.Row drow = DishTable.getRow("name", name);
  	
  	//unfortunately jenny does not provide deleting with 2 clauses
  	Class.forName("com.mysql.jdbc.Driver");
  	Connection conn = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
  	Statement stmt = conn.createStatement();
  	String sql = "DELETE FROM ingredients WHERE dish_id='"+drow.getDish_id()+"' AND ingredient_name='"+ingredient+"'";
  	Boolean rs = stmt.execute(sql);
  	
  	//System.out.println(rs);
  }
  
  public void deleteIngredients(int dish_id, String ingredient) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
  {
  	
    //unfortunately jenny does not provide deleting with 2 clauses
  	Class.forName("com.mysql.jdbc.Driver") ;
  	Connection conn = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
  	Statement stmt = conn.createStatement() ;
  	String query = "DELETE FROM ingredients WHERE dish_id='"+dish_id+"' AND ingredient_name='"+ingredient+"'";
  	ResultSet rs = stmt.executeQuery(query) ;
  	
  	//System.out.println(rs);
  }
  
  
  
  //DELETE
  //Ingredient
  /* on deleting an ingredient I have to delete all the entries in the IngredientsTable associated with it first*/
  public void deleteIngredient(String ingredient) throws SQLException
  {
  	IngredientsTable.delete("ingredient_name", ingredient);
  	
  	IngredientTable.delete("name", ingredient);
  }
  
  
  //Dish
  public void deleteDish(String name) throws SQLException
  {
  	int dish_id = DishTable.getRow("name", name).getDish_id();
  	
  	//delete ingredients table lists first
  	IngredientsTable.delete("dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete("name", name);
  }
  
  public void deleteDish(int dish_id) throws SQLException
  {
  	IngredientsTable.delete("dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete(dish_id);
  }
}
