package test;

import java.util.ArrayList;

import main.*;
import main.Ingredient;
import main.IngredientFactory;

public class TestFactories
{

  public static void main(String[] args)
  {
    
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    IngredientFactory.refreshIngredients(ingredients);
    
    System.out.println("Ingredients in DB: " + ingredients.size());
    
    for(int i=0; i<ingredients.size(); i++)
    {
      System.out.println(ingredients.get(i).toString());
    }
    
    
  }
}
