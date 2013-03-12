package main;

/*
 * A class to verify that the input passed to the database is within the constraints
 */

public class InputVerifier
{

	public static void verifyIngredient(Ingredient input) throws Exception
	{
		//first verify that the fields that have to be there have data in
	  //verify that the data is within the parameters of the database
	  if(input.getName() == null || input.getExpires() == null || input.getPrice() == 0.0)
	    throw new Exception("Please make sure all the fields are filled out");
	  
	  //name
	  if(input.getName().length() > 20)
	    throw new Exception("Name cannot be longer than 20 characters!");
	  
	  //price
	  if(input.getPrice() < 0.0)
	    throw new Exception("Price cannot be negative!");
	  //TODO price format greater than 4.2f
	  
	  //expires
	  //TODO make sure that expirydate is in the future!
	  
	  //stock
	  if(input.getStock() < 0)
	    throw new Exception("Stock can not be negative!");
	  //should be caught if java throws an exception that its not a number
	}
	
	public static void verifyDish(Dish input) throws Exception
	{
	  if(input.getName() == null || input.getDescripton() == null || input.getPrice() == 0.0 || input.getIngredient_id().length == 0)
	    throw new Exception("Please make sure all the fields are filld out, and there is at least one ingredient!");
	  
	  //name
	  if(input.getName().length() > 100)
	    throw new Exception("Name is too long! (100 characters maximum!)");
	  
	  //description
	  if(input.getDescripton().length() > 255)
	    throw new Exception("Description is too long! (255 characters maximum!");
	  
	  //price
	  //TODO price format greater than 4.2f
	  
	  //ingredients
	  if(input.getIngredient_id().length < 1)
	    throw new Exception("Add at least one Ingredient!");
	}
	
	public static void verifyOrder(Order input) throws Exception
	{
	  //price
	  if(input.getPrice() == 0.0)
	    throw new Exception("Price 0! Add something to your order to continue!");
	  
	  //give either table number or customer id
	  //if(input.getCustomer_id() == 0 && input.getTablenumber() == 0)
	   // throw new Exception("Provide a tablenumber for an internal order, or a customer for an external order");
	  
	  //dishes
	  //no dishes
	  if(input.getDishes() == null && input.getDish_id() == null)
	    throw new Exception("No dishes added to the order!");
	  
	  //notes
	  //too long if existant
	  if(input.getNotes() != null)
	    if(input.getNotes().length() > 255)
	      throw new Exception("Note too long! (255 characters maximum!)");
	  
	  
	}
	
	public static void verifyTable(Table input) throws Exception
	{
	  //details
	  //too long
	  if(input.getTabledetails().length() > 120)
	    throw new Exception("Details too long! (120 characters maximum!)");
	  
	  //revenue
	  //TODO revenue above 6.2f
	}
	
	public static void verifyReservation(Reservation input) throws Exception
	{
	  //tablenumber
	  if(input.getTablenumber() <= 0)
	    throw new Exception("Please enter a valid tablenumber! (greater than 0)");
	  //TODO check for max nr of tables, warn if too high
	  
	  //date and time
	  if(input.getDateandtime() == null)
	    throw new Exception("Please give a valid date and time!");
	  //TODO check for time
	  //TODO check that date and time are in the future
	  
	  //name
	  if(input.getName() == null)
	    throw new Exception("Please give a name!");
	  
	  //people
	  if(input.getPeople() <= 0)
	    throw new Exception("Please give a valid number of people!");
	  
	  //customer
	  //TODO valid customer id
	}
	
	public static void verifyCustomer(Customer input) throws Exception
	{
	  //email
	  if(input.getEmail().length() > 120)
	    throw new Exception("Email address too long! (120 characters maximum!)");
	  //TODO verify valid email address format "*@*.*"
	  
	  //name
	  if(input.getName() == null)
	    throw new Exception("Please enter a customer name!");
	  if(input.getName().length() > 80)
	    throw new Exception("Name too long! (80 character maximum!)");
	  
	  //password
	  if(input.getPassword().length() > 45)
	    throw new Exception("Password too long! (45 characters maximum!)");
	  
	  //address
	  if(input.getAddress().length() > 180)
	    throw new Exception("Address too long! (180 characers maximum!)");
	  
	  //phone
	  if(input.getPhone().length() > 16)
	    throw new Exception("Phonenumber too long! (16 characters maximum!)");
	  //TODO check phonenumber only numbers and valid
	}
	
	
}
