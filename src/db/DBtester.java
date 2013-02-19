package db;

import java.sql.SQLException;

public class DBtester
{
	public static void main(String[] args) throws SQLException, Exception
	{
		String name = "rice";
		Double price = 0.99;
		int stock = 5;
		
		DBInterface dbif = new DBInterface();
		
		//test as I go along
		
		//add
		dbif.addIngredient(name, price, stock);
		
		//String[] ingredients = {"rice"};
		//dbif.addDish("Boiled Rice", "Simply boiled rice", 1.99, ingredients);
		
		//edit
		//dbif.editIngredientStock("rice", 5);
		//dbif.editIngredientPrice("rice", 0.5);
		
		//dbif.editDishName(0, "Boiled Rice");
		//dbif.editDishDescription(0, "Rice");
		//dbif.editDishDescription("Boiled Rice", "Simply boiled rice");
		
		//dbif.deleteIngredients("Boiled Rice", "rice");
		dbif.addIngredients("Boiled Rice", "rice");
		
		//delete
		//dbif.deleteDish(0);
		
		//dbif.deleteIngredient("rice");
		
		
		
	}
}
