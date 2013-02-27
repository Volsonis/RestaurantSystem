package db;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	//establish connection
	public static Connection connect() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection con = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
    return con;
	}
	
	//ADD
	//Ingredient
  //without stock(=0)
	public static void addIngredient(String ingredient, Double price) throws SQLException
	{
		IngredientTable.Row row = IngredientTable.getRow();
		row.setName(ingredient);
		row.setPrice(price);
		row.setStock(0);
		row.insert();
		
	}
	
  public static void addIngredient(String ingredient, Double price, int stock) throws SQLException
  {
		IngredientTable.Row row = IngredientTable.getRow();
		row.setName(ingredient);
		row.setPrice(price);
		row.setStock(stock);
		row.insert();
  }
  
  
  //Dish
  //just to test, later it should not be possible to add a dish without ingredients again
  public static void addDish(int dish_id, String name,String description, Double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow();
  	row.setDish_id(dish_id);
  	row.setName(name);
  	row.setDescription(description);
  	row.setPrice(price);
  	row.insert();
  }
  
  //automatic ID
  public static void addDish(String name,String description, Double price, String[] ingredients) throws SQLException
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
  public static void editIngredientStock(String name, int stock) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow("name", name);
  	row.setStock(stock);
  	row.update("name", name);
  }
  
  public static void editIngredientPrice(String name, double price) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow("name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
  
  //Dish
  public static void editDishName(int dish_id, String name) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setName(name);
  	row.update();
  }
  
  //edit description by id
  public static void editDishDescription(int dish_id, String description) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setDescription(description);
  	row.update();
  }
  
  //edit description by name
  public static void editDishDescription(String name, String description) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow("name", name);
  	row.setDescription(description);
  	row.update("name", name);
  }
  
  //by id
  public static void editDishPrice(int dish_id, double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(dish_id);
  	row.setPrice(price);
  	row.update();
  }
  
  //by name
  public static void editDishPrice(String name, double price) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow("name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
  
  
  /* Ingredients
   * this is slightly more complicated as the "ingredients" table is linked to this to store this information
   * 
   */
  public static void addIngredients(String name, String ingredient) throws SQLException
  {
  	DishTable.Row drow = DishTable.getRow("name", name);
  	
  	IngredientsTable.Row irow = IngredientsTable.getRow();
  	irow.setDish_id(drow.getDish_id());
  	irow.setIngredient_name(ingredient);
  	irow.insert();
  }
  
  public static void addIngredients(int dish_id, String ingredient) throws SQLException
  {
  	IngredientsTable.Row row = IngredientsTable.getRow();
  	row.setDish_id(dish_id);
  	row.setIngredient_name(ingredient);
  	row.insert();
  }
  
  public static void deleteIngredients(String name, String ingredient) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
  {
  	IngredientsTable.Row drow = IngredientsTable.getRow();
  	
  	//unfortunately jenny does not provide deleting with 2 clauses
  	Class.forName("com.mysql.jdbc.Driver");
  	Connection conn = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
  	Statement stmt = conn.createStatement();
  	String sql = "DELETE FROM ingredients WHERE dish_id='"+drow.getDish_id()+"' AND ingredient_name='"+ingredient+"'";
  	Boolean rs = stmt.execute(sql);
  }
  
  public static void deleteIngredients(int dish_id, String ingredient) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    //unfortunately jenny does not provide deleting with 2 clauses
  	Class.forName("com.mysql.jdbc.Driver") ;
  	Connection conn = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
  	Statement stmt = conn.createStatement() ;
  	String query = "DELETE FROM ingredients WHERE dish_id='"+dish_id+"' AND ingredient_name='"+ingredient+"'";
  	ResultSet rs = stmt.executeQuery(query) ;
  }
  
  
  
  //DELETE
  //Ingredient
  /* on deleting an ingredient I have to delete all the entries in the IngredientsTable associated with it first*/
  public static void deleteIngredient(String ingredient) throws SQLException
  {
  	IngredientsTable.delete("ingredient_name", ingredient);
  	
  	IngredientTable.delete("name", ingredient);
  }
  
  
  //Dish
  public static void deleteDish(String name) throws SQLException
  {
  	int dish_id = DishTable.getRow("name", name).getDish_id();
  	
  	//delete ingredients table lists first
  	IngredientsTable.delete("dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete("name", name);
  }
  
  public static void deleteDish(int dish_id) throws SQLException
  {
  	IngredientsTable.delete("dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete(dish_id);
  }
  
  
  
  //GET ALL
  public static Row[] getAllDishes()
  {
  	return DishTable.getAllRows();
  }  
  
  
  //for efficiency, there should be a way to provide a connection for the SQL queries, so that jenny doesn't have to establish a new one every time
  //therefore i will provide all the previous methods, with an option for a given SQL connection
  //EDIT
  //Ingredient
  //stock
  public static void editIngredientStock(String name, int stock, Connection con) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow(con, "name", name);
  	row.setStock(stock);
  	row.update("name", name);
  }
  
  public static void editIngredientPrice(String name, double price, Connection con) throws SQLException
  {
  	IngredientTable.Row row = IngredientTable.getRow(con, "name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
  
  
  //Dish
  public static void editDishName(int dish_id, String name, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setName(name);
  	row.update();
  }
  
  //edit description by id
  public static void editDishDescription(int dish_id, String description, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setDescription(description);
  	row.update();
  }
  
  //edit description by name
  public static void editDishDescription(String name, String description, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, "name", name);
  	row.setDescription(description);
  	row.update("name", name);
  }
  
  //by id
  public static void editDishPrice(int dish_id, double price, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setPrice(price);
  	row.update();
  }
  
  //by name
  public static void editDishPrice(String name, double price, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, "name", name);
  	row.setPrice(price);
  	row.update("name", name);
  }
   
  //DELETE
  //Ingredient
  /* on deleting an ingredient I have to delete all the entries in the IngredientsTable associated with it first*/
  public static void deleteIngredient(String ingredient, Connection con) throws SQLException
  {
  	IngredientsTable.delete(con, "ingredient_name", ingredient);
  	
  	IngredientTable.delete(con, "name", ingredient);
  }
  
  
  //Dish
  public static void deleteDish(String name, Connection con) throws SQLException
  {
  	int dish_id = DishTable.getRow(con, "name", name).getDish_id();
  	
  	//delete ingredients table lists first
  	IngredientsTable.delete(con, "dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete(con, "name", name);
  }
  
  public static void deleteDish(int dish_id, Connection con) throws SQLException
  {
  	IngredientsTable.delete(con, "dish_id", String.valueOf(dish_id));
  	
  	DishTable.delete(con, dish_id);
  }
  
  public static Row[] getAllDishes(Connection con)
  {
  	return DishTable.getAllRows(con);
  }  
  
  
}
