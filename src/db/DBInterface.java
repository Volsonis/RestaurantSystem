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
import db.wrapper.PendingordersTable;
import db.wrapper.ProcessedarticlesTable;
import db.wrapper.ProcessedordersTable;
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
    row.setType(dish.getType());
    //id gets returned on insert
    int dish_id = (int) row.insert();
    
    //TODO handle multiplicities here
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
  
  /*
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
      
      row = ArticlesTable.getRow();
      row.setOrder_number(order_number);
      row.setDish_id(DishTable.getRow("name", dishes[i]).getDish_id());
      row.insert();
    }
  }
 */
  
  //order
  public static void addOrder(Order order) throws SQLException
  {
    PendingordersTable.Row row = PendingordersTable.getRow();
    row.setValue(order.getPrice());
    row.setNotes(order.getNotes());
    row.setCustomer_id(order.getCustomer_id());
    row.setTablenumber(order.getTablenumber());
    row.insert();
    
    //now insert the dishes associated with the order into the articles table
    int pendingorders_id = row.getPendingorders_id();
    
    //TODO handle multiplicities here
    for(int i=0; i<order.getDish_id().length; i++)
    {
      ArticlesTable.Row arow = ArticlesTable.getRow();
      arow.setPendingorders_id(pendingorders_id);
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
  public static void editIngredient(int ingredient_id, Ingredient ingredient) throws SQLException
  {
    IngredientTable.Row row = IngredientTable.getRow(ingredient_id);
    row.setName(ingredient.getName());
    row.setPrice(ingredient.getPrice());
    row.setStock(ingredient.getStock());
    row.setExpires(new java.sql.Date(ingredient.getExpires().getTime()).toString());
    row.update();
  }
  //for the quickupdate of date and stock only
  public static void editIngredient(int ingredient_id, java.util.Date date, int stock) throws SQLException
  {
    IngredientTable.Row row = IngredientTable.getRow(ingredient_id);
    row.setExpires(new java.sql.Date(date.getTime()).toString());
    row.setStock(stock);
    row.update();
  }
  //deprecated
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
  public static void editDish(int dish_id, Dish dish) throws SQLException
  {
    DishTable.Row row = DishTable.getRow(dish_id);
    row.setName(dish.getName());
    row.setDescription(dish.getDescripton());
    row.setPrice(dish.getPrice());
    row.setType(dish.getType());
    row.update();
    
    //now the ingredients
    IngredientsTable.Row[] isrows = IngredientsTable.getRows("dish_id", String.valueOf(dish_id));
    int[] updatedRows = dish.getIngredient_id();
    
    Boolean add = true;
    ArrayList<Integer> rowsToAdd = new ArrayList<Integer>();
    ArrayList<Integer> rowsToRemove = new ArrayList<Integer>();
    //i am tired and its late so this is going to be bad and not how i'd usually do it :/
    //check what should go in and see if it already is in
    for(int i=0; i<updatedRows.length; i++)
    {
      add = true;
      //rows to add are in newRows, but not in isrows
      for(int j=0; j<isrows.length; j++)
        //if its found, we dont have to add again
        if(updatedRows[i] == isrows[j].getIngredient_id())//if its already in, dont add
          add=false;
      if(add)
        rowsToAdd.add(updatedRows[i]); //here we want to get the id of the ingredient we want to add
    }
    
    //check whats in and see if its supposed to stay in
    Boolean remove = true;
    for(int i=0; i<isrows.length; i++)
    {
      remove = true;
      //rows to remove are in isrows, but not in newRows
      for(int j=0; j<updatedRows.length; j++)
        //
        if(isrows[i].getIngredient_id() == updatedRows[j])//if it is in the update, dont remove it
          remove = false;
      if(remove)
        rowsToRemove.add(isrows[i].getIngredients_id()); //here we want to get the id of the row in the ingredients table
    }
    //rows that are in both can be ignored
    
    //add whats to be added
    IngredientsTable.Row addisrow;
    for(int i=0; i<rowsToAdd.size(); i++)
    {
      addisrow = IngredientsTable.getRow();
      addisrow.setDish_id(dish.getID());
      addisrow.setIngredient_id(rowsToAdd.get(i));
      addisrow.insert();
    }
    
    //delete what needs to be deleted
    for(int i=0; i<rowsToRemove.size(); i++)
    {
      IngredientsTable.delete(rowsToRemove.get(i));
    }
    
  }
  //deprecated
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
  //deprecated
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
 
  //Order
  public static void editOrder(int pendingorders_id, Order order) throws SQLException
  {
    PendingordersTable.Row row = PendingordersTable.getRow(pendingorders_id);
    row.setValue(order.getPrice());
    row.setNotes(order.getNotes());
    row.setCustomer_id(order.getCustomer_id());
    row.setTablenumber(order.getTablenumber());
    row.update();
    
    //now the Dishes
    ArticlesTable.Row[] arows = ArticlesTable.getRows("order_number", String.valueOf(pendingorders_id));
    int[] updatedRows = order.getDish_id();
    
    Boolean add = true;
    ArrayList<Integer> rowsToAdd = new ArrayList<Integer>();
    ArrayList<Integer> rowsToRemove = new ArrayList<Integer>();
    
    //check what should go in and see if it already is in
    for(int i=0; i<updatedRows.length; i++)
    {
      add = true;
      //rows to add are in newRows, but not in arows
      for(int j=0; j<arows.length; j++)
        //if its found, we dont have to add again
        if(updatedRows[i] == arows[j].getDish_id())//if its already in, dont add
          add=false;
      if(add)
        rowsToAdd.add(updatedRows[i]); //here we want to get the id of the ingredient we want to add
    }
    
    //check whats in and see if its supposed to stay in
    Boolean remove = true;
    for(int i=0; i<arows.length; i++)
    {
      remove = true;
      //rows to remove are in arows, but not in newRows
      for(int j=0; j<updatedRows.length; j++)
        //
        if(arows[i].getDish_id() == updatedRows[j])//if it is in the update, dont remove it
          remove = false;
      if(remove)
        rowsToRemove.add(arows[i].getDish_id()); //here we want to get the id of the row in the ingredients table
    }
    //rows that are in both can be ignored
    
    //add whats to be added
    ArticlesTable.Row addarow;
    for(int i=0; i<rowsToAdd.size(); i++)
    {
      addarow = ArticlesTable.getRow();
      addarow.setDish_id(rowsToAdd.get(i));
      addarow.setPendingorders_id(pendingorders_id);
      addarow.insert();
    }
    
    //delete what needs to be deleted
    for(int i=0; i<rowsToRemove.size(); i++)
    {
      ArticlesTable.delete(rowsToRemove.get(i));
    }
    
  }
  public static void editOrderNote(Order order) throws SQLException
  {
    PendingordersTable.Row row = PendingordersTable.getRow(order.getPendingorders_id());
    row.setNotes(order.getNotes());
    row.update();
  }
  
  //DELETE
  //Ingredient
  public static void deleteIngredient(Ingredient ingredient) throws SQLException
  {
    IngredientsTable.Row[] rows = IngredientsTable.getRows("ingredient_id", ingredient.getId());
    //keep track of the dishes, that lost an ingredient

    IngredientsTable.delete("ingredient_id", String.valueOf(ingredient.getId()));
    
    //make sure there can't be a dish without ingredients
    //after deletion check if those dishes still have an entry in the IngredientsTable.
    //if not, remove this dish
    IngredientsTable.Row[] newRows = IngredientsTable.getAllRows();
    Boolean remove = true;
    for(int i=0; i<rows.length; i++)
    {
      remove = true;
      for(int j=0; j< newRows.length; j++)
      {
        if(rows[i].getDish_id() == newRows[i].getDish_id())
          remove = false;
      }
      if(remove)
        hardDeleteDish(rows[i].getDish_id()); //removes dish without ingredient
    }
    
    IngredientTable.delete(ingredient.getId());
  }
  //deprecated
  /* on deleting an ingredient I have to delete all the entries in the IngredientsTable associated with it first*/
  public static void deleteIngredient(String ingredient) throws SQLException
  {
  	IngredientsTable.delete("ingredient_name", ingredient);
  	
  	IngredientTable.delete("name", ingredient);
  }
  
  
  //Dish
  public static void hardDeleteDish(int dish_id) throws SQLException
  {
    //delete all references to that dish from associated tables first: articles, ingredients, processedArticles
    //articles
    //TODO check for interference in the ArticlesTable, if there is none, just delete the dish. Reasoning:
    //If the customer doesnt get a dish he paid for its bad. If it is deleted out of the reference inside the system, the monetary aspect is still preserved, so I dont worry about that
    ArticlesTable.delete("dish_id", String.valueOf(dish_id));
    
    //ingredients
    IngredientsTable.delete("dish_id", String.valueOf(dish_id));
    
    //processedArticles
    ProcessedarticlesTable.delete("dish_id", String.valueOf(dish_id));
    
    //now i can actually delete the dish
    DishTable.delete(dish_id);
  }
  public static void deleteDish(Dish dish) throws Exception
  {
    //check if dish is in AriclesTable, if so, do not allow to delete. The manager will have to wait till its cooked to alter it
    ArticlesTable.Row[] rows = ArticlesTable.getAllRows();
    for(int i=0; i<rows.length; i++)
    {
      if(rows[i].getDish_id() == dish.getID())
        throw new Exception("Cannot delete this dish right now, as it is being cooked!");
    }
    //ingredients
    IngredientsTable.delete("dish_id", String.valueOf(dish.getID()));
    
    //processedArticles
    ProcessedarticlesTable.delete("dish_id", String.valueOf(dish.getID()));
    
    //now i can actually delete the dish
    DishTable.delete(dish.getID());
  }
  //deprecated
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
  
  //Order
  public static void deleteOrder(Order order) throws SQLException
  {
    //first do the references
    ArticlesTable.delete("pendingorders_id", String.valueOf(order.getPendingorders_id()));
    //then the order
    PendingordersTable.delete(order.getPendingorders_id());
  }
  
  //ProcessOrder
  public static void processOrder(Order order) throws SQLException
  {
    //this puts an order from Pendingorders to Processedorders
    //remove articles
    ArticlesTable.Row[] arows = ArticlesTable.getRows("pendingorders_id", order.getPendingorders_id());
    ArticlesTable.delete("pendingorders_id", String.valueOf(order.getPendingorders_id()));
    
    //remove pendingorders
    PendingordersTable.Row prow = PendingordersTable.getRow(order.getPendingorders_id());
    PendingordersTable.delete(order.getPendingorders_id());
    
    //put into processedordersTable
    ProcessedordersTable.Row row = ProcessedordersTable.getRow();
    row.setNumber(prow.getPendingorders_id());
    row.setValue(prow.getValue());
    row.setDate(new java.sql.Date(new java.util.Date().getTime()).toString());
    row.setNotes(order.getNotes());
    row.setCustomer_id(order.getCustomer_id());
    row.setTablenumber(order.getTablenumber());
    row.setDiscount_id(order.getDiscount_id());
    row.insert();
    
    ProcessedarticlesTable.Row parow;
    //put into Processedarticles
    for(int i=0; i<arows.length; i++)
    {
      parow = ProcessedarticlesTable.getRow();
      parow.setDish_id(arows[i].getDish_id());
      parow.setProcessedorders_id(arows[i].getPendingorders_id());
      parow.insert();
    }
    
    //increase table revenue
    db.wrapper.Table.Row trow = db.wrapper.Table.getRow("table_id", String.valueOf(order.getTablenumber()));
    if(trow.getTable_id() != 0) // if this is not the second time we come past here
    {
      trow.setRevenue(trow.getRevenue()+order.getPrice());
      trow.update("table_id", String.valueOf(order.getTablenumber()));
    }

  }
  
  //ReverseOrder
  public static void reverseOrder(Order order) throws SQLException
  {
    //this puts an order from Processedorders to Pendingorders (but we can skip tablenumber, since we already harvested that information)
    //remove processedarticles
    ProcessedarticlesTable.Row[] parows = ProcessedarticlesTable.getRows("processedorders_id", order.getPendingorders_id());
    ProcessedarticlesTable.delete("processedorders_id", String.valueOf(order.getPendingorders_id()));
    
    //remove processedOrder
    ProcessedordersTable.Row porow = ProcessedordersTable.getRow(order.getPendingorders_id());
    ProcessedordersTable.delete(order.getPendingorders_id());
    
    //put into pendingordersTable
    PendingordersTable.Row row = PendingordersTable.getRow();
    row.setValue(porow.getValue());
    row.setTime(new java.sql.Time(new java.util.Date().getTime()).toString());
    row.setNotes(order.getNotes());
    row.setCustomer_id(order.getCustomer_id());
    row.setTablenumber(0); // when it gets put back we dont want the tablerevenuie to count
    row.setDiscount_id(order.getDiscount_id());
    row.insert();
    
    //put into articles
    ArticlesTable.Row arow;
    //put into Processedarticles
    for(int i=0; i<parows.length; i++)
    {
      arow = ArticlesTable.getRow();
      arow.setDish_id(parows[i].getDish_id());
      arow.setPendingorders_id((parows[i].getProcessedorders_id()));
      arow.insert();
    }
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
