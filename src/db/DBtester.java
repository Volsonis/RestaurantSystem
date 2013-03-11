package db;

import java.sql.SQLException;
import java.util.Date;

public class DBtester
{
	public static void main(String[] args) throws SQLException, Exception
	{
		String name = "rice";
		Double price = 0.99;
		int stock = 5;
		
		
		//test as I go along
		
		//add
		//DBInterface.addIngredient(name, price, stock);
		
		//String[] ingredients = {"rice"};
		//DBInterface.addDish("Boiled Rice", "Simply boiled rice", 1.99, ingredients);
		
		//edit
		DBInterface.editIngredient(3, new Date(), 125);
		//DBInterface.editIngredientStock("rice", 5);
		//DBInterface.editIngredientPrice("rice", 0.5);
		
		//DBInterface.editDishName(0, "Boiled Rice");
		//DBInterface.editDishDescription(0, "Rice");
		//DBInterface.editDishDescription("Boiled Rice", "Simply boiled rice");
		
		//DBInterface.deleteIngredients("Boiled Rice", "rice");
		//DBInterface.addIngredients("Boiled Rice", "rice");
		
		//delete
		//DBInterface.deleteDish(0);
		
		//DBInterface.deleteIngredient("rice");
		
		
		
	}
}
