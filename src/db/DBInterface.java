package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

import java.util.* ;
import com.javaranch.db.* ;

import db.wrapper.DishTable;
import db.wrapper.DishTable.Row;
import db.wrapper.ArticlesTable;
import db.wrapper.CustomerTable;
import db.wrapper.IngredientTable;
import db.wrapper.IngredientsTable;
import db.wrapper.OrderTable;
import db.wrapper.ReservationTable;
import main.*;

public class DBInterface
{
	
	//establish connection and return it
	public static Connection connect() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection con = DriverManager.getConnection("jdbc:mysql://ramen.cs.man.ac.uk:3306/S10_lesnjas0", "lesnjas0", "Stefan1991") ;
    return con;
	}
	
	//ADD
	//Ingredient
	//this is the right way it should be done
	public static void addIngredient(Ingredient ingredient) throws SQLException
	{
	  IngredientTable.Row row = IngredientTable.getRow(); //this will create a new row
	  row.setName(ingredient.getName());
	  row.setPrice(ingredient.getPrice());
	  row.setStock(ingredient.getStock());
	  row.setExpires(ingredient.getExpires().toString());
	  row.insert();
	}
	
	//deprecated
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
  public static void addIngredient(String ingredient, Double price, int stock, Date expiryDate) throws SQLException
  {
		IngredientTable.Row row = IngredientTable.getRow();
		row.setExpires(expiryDate.toString());
		row.setName(ingredient);
		row.setPrice(price);
		row.setStock(stock);
		row.insert();
  } 
  
  
  //Dish
  public static void addDish(Dish dish) throws SQLException
  {
    DishTable.Row row = DishTable.getRow();
    row.setName(dish.getName());
    row.setDescription(dish.getDescripton());
    row.setPrice(dish.getPrice());
    row.insert();
    
    Row drow = DishTable.getRow("name", dish.getName());
    int dish_id = drow.getDish_id();
    
    //add ingredients by id
    for(int i=0; i < dish.getIngredient_id().length; i++)
    {
      IngredientsTable.Row irow = IngredientsTable.getRow(); //creates a new row in the ingredients table
      irow.setDish_id(dish_id);
      irow.setIngredient_id(dish.getIngredient_id()[i]);
      irow.insert();
    }//for
    
  }
  
  
  //deprecated
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
  public static void addDish(String name, String description, Double price, int[] ingredients) throws SQLException
  {
  	//add dish
  	DishTable.Row drow = DishTable.getRow();
  	drow.setName(name);
  	drow.setDescription(description);
  	drow.setPrice(price);
  	drow.insert();
  	
  	Row row = DishTable.getRow("name", name);
  	int dish_id = row.getDish_id();
  	
  	//add ingredients by id
  	for(int i=0; i < ingredients.length; i++)
  	{
  	  IngredientsTable.Row irow = IngredientsTable.getRow();
  		irow.setDish_id(dish_id);
  		irow.setIngredient_id(ingredients[i]);
  		irow.insert();
  	}//for
  }//addDish
  
  //articles
  //deprecated
  public static void addArticle(int dish_id, int order_number) throws SQLException
  {
	  ArticlesTable.Row row = ArticlesTable.getRow();
	  row.setDish_id(dish_id);
	  row.setOrder_number(order_number);
	  row.insert();
  }
  public static void addArticles(int[] dish_ids, int order_number) throws SQLException
  {
	  ArticlesTable.Row row;
	  for(int i=0; i<dish_ids.length ; i++)
	  {
	    row = ArticlesTable.getRow();
	    row.setOrder_number(order_number);
	    row.setDish_id(dish_ids[i]);
	    row.insert();
	  }
  }
  public static void addArticles(String[] dishes, int order_number) throws SQLException
  {
    ArticlesTable.Row row;
    for(int i=0; i<dishes.length ; i++)
    {
      //TODO check input
      /*
      if(dishes[i] == null)
        throw new InvalidInputException("Array passed to addArticles by string has values == null");
      */
      row = ArticlesTable.getRow();
      row.setOrder_number(order_number);
      row.setDish_id(DishTable.getRow("name", dishes[i]).getDish_id());
      row.insert();
    }
  }
 
  
  //order
  public static void addOrder(Order order) throws SQLException
  {
    OrderTable.Row row = OrderTable.getRow();
    row.setValue(order.getPrice());
    row.setNotes(order.getNotes());
    row.setCustomer_id(order.getCustomer_id());
    row.setTablenumber(order.getTablenumber());
    row.insert();
    
    //now insert the dishes associated with the order into the articles table
    int order_number = row.getNumber();
    
    for(int i=0; i<order.getDish_id().length; i++)
    {
      ArticlesTable.Row arow = ArticlesTable.getRow();
      arow.setOrder_number(order_number);
      arow.setDish_id(order.getDish_id()[i]);
      arow.insert();
    }
  }
  
  //customer
  public static void addCustomer(Customer customer) throws SQLException
  {
  	CustomerTable.Row row = CustomerTable.getRow();
  	row.setName(customer.getName());
  	row.setEmail(customer.getEmail());
  	row.setPassword(customer.getPassword());
  	row.setAddress(customer.getAddress());
  	row.setPhone(customer.getPhone());
  	row.insert();
  }
  
  //reservation
  public static void addReservation(Reservation reservation) throws SQLException
  {
  	ReservationTable.Row row = ReservationTable.getRow();
  	row.setTablenumber(reservation.getTablenumber());
  	
  	java.sql.Date date = new java.sql.Date(reservation.getDateandtime().getTime());
  	row.setDate(date.toString()); //this needs to be converted into a sql date toString
  	
  	java.sql.Time time = new java.sql.Time(reservation.getDateandtime().getTime());
  	row.setTime(time.toString()); //this needs to be converted into a sql date toString
  	
  	row.setName(reservation.getName());
  	row.setPeople(reservation.getPeople());
  	row.setCustomer_id(reservation.getCustomer_id());
  	row.insert();
  }
  
  //table
  public static void addTable(Table table) throws SQLException
  {
    db.wrapper.Table.Row row = db.wrapper.Table.getRow();
    row.setTabledetails(table.getTabledetails());
    row.setRevenue(table.getRevenue());
    row.insert();
  }
  
  //Staff
  public static void addStaff(Staff staff)
  {
    
  }
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
  public static void addIngredients(String name, int ingredient) throws SQLException
  {
  	DishTable.Row drow = DishTable.getRow("name", name);
  	
  	IngredientsTable.Row irow = IngredientsTable.getRow();
  	irow.setDish_id(drow.getDish_id());
  	irow.setIngredient_id(ingredient);
  	irow.insert();
  }
  
  public static void addIngredients(int dish_id, int ingredient) throws SQLException
  {
  	IngredientsTable.Row row = IngredientsTable.getRow();
  	row.setDish_id(dish_id);
  	row.setIngredient_id(ingredient);
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
  
  
  
  //GET
  //ingredients of
  public static IngredientsTable.Row[] getIngredientsOf(int dish_id) throws SQLException
  {
  	return IngredientsTable.getRows("dish_id", dish_id);
  }
  
  //number of ingredients of
  public static int getNoOfIngredients(int dish_id) throws SQLException
  {
  	return IngredientsTable.getRows("dish_id", dish_id).length;
  }
  
  
  
  //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
  	row.update(con, "name", name);
  }
  
  
  //Dish
  public static void editDishName(int dish_id, String name, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setName(name);
  	row.update(con);
  }
  
  //edit description by id
  public static void editDishDescription(int dish_id, String description, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setDescription(description);
  	row.update(con);
  }
  
  //edit description by name
  public static void editDishDescription(String name, String description, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, "name", name);
  	row.setDescription(description);
  	row.update(con, "name", name);
  }
  
  //by id
  public static void editDishPrice(int dish_id, double price, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, dish_id);
  	row.setPrice(price);
  	row.update(con);
  }
  
  //by name
  public static void editDishPrice(String name, double price, Connection con) throws SQLException
  {
  	DishTable.Row row = DishTable.getRow(con, "name", name);
  	row.setPrice(price);
  	row.update(con, "name", name);
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
  
  //ingredients of
  public static IngredientsTable.Row[] getIngredientsOf(int dish_id, Connection con) throws SQLException
  {
  	return IngredientsTable.getRows(con, "dish_id", dish_id);
  }
  
  //number of ingredients of
  public static int getNoOfIngredients(int dish_id, Connection con) throws SQLException
  {
  	return IngredientsTable.getRows(con, "dish_id", dish_id).length;
  }
  
  
}
