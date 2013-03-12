package test;

import java.awt.Component;

import gui.IngredientChooser;
import gui.Management;

import javax.swing.JDialog;
import javax.swing.JFrame;

import main.Dish;

public class TestIngredientsChooser
{

  public static void main(String[] args)
  {
    Dish dish = new Dish(0, null, null, 0);
    //create and set up the window
    JDialog dialog= new IngredientChooser(new JFrame(), dish);
    dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    //display the window
    //frame.pack();
    dialog.setVisible(true);
  }
}
