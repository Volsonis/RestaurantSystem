package test;

import gui.Management;
import gui.Order;

import javax.swing.JFrame;

public class TestOrder
{
  public static void main(String[] args)
  {
    //create and set up the window
    JFrame order= new Order();
    order.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //display the window
    //frame.pack();
    order.setVisible(true);
  }
}
