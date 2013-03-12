package test;

import gui.KitchenDisplay;
import gui.Management;

import javax.swing.JFrame;

public class TestKitchenDisplay
{
  public static void main(String[] args)
  {
    //create and set up the window
    JFrame frame= new KitchenDisplay();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //display the window
    //frame.pack();
    frame.setVisible(true);
  }
}
