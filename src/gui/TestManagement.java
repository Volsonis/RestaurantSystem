package gui;

import javax.swing.JFrame;

public class TestManagement
{
	public static void main(String[] args)
	{
		//create and set up the window
		JFrame frame= new Management();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//display the window
		frame.pack();
		frame.setVisible(true);
	}
}
