package db;

import java.sql.SQLException;

public class DBtester
{
	public static void main(String[] args) throws SQLException
	{
		String name = "rice";
		Double price = 0.99;
		int stock = 5;
		
		DBInterface dbif = new DBInterface();
		
		//dbif.addIngredient(name, price, stock);
		String[] ingredients = {"rice"};
		dbif.addDish("Boiled Rice", "Simply boiled rice", 1.99, ingredients);
		
	}
}
