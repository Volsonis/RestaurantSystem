package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

import main.Ingredient;
import main.IngredientFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.ComponentOrientation;

public class IngredientsFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	
	Box box;
	ArrayList<Ingredient> ingredients;
	final Component parentFrame;
	
	public IngredientsFrame(Component parent) {
	  
	  ingredients = new ArrayList<Ingredient>();
	  
		setLayout(new BorderLayout(0, 0));
		parentFrame = parent;
		JSeparator separator = new JSeparator();
		this.add(separator, BorderLayout.NORTH);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.WEST);
		
		JButton btnAdd = new JButton("   New   ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog addIngredient = new AddIngredient(parentFrame);
				addIngredient.setVisible(true);
				
				refresh();
				revalidate();
				repaint();
			}
		});
		toolBar.add(btnAdd);
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdd.setIcon(new ImageIcon(IngredientsFrame.class.getResource("/gui/resources/img32x32/list-add-5.png")));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    refresh();
		    
		    revalidate();
		    repaint();
		  }
		});
		toolBar.add(btnRefresh);
		btnRefresh.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setIcon(new ImageIcon(IngredientsFrame.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		add(scrollPane, BorderLayout.CENTER);
		
		box = Box.createVerticalBox();
		box.setAutoscrolls(true);
		scrollPane.setViewportView(box);
		
		refresh();
		
	}
	
	public void refresh()
	{
	  
	  box.removeAll();
	  
	  IngredientFactory.refreshIngredients(ingredients);
	  
	  JPanel[] ip = new JPanel[ingredients.size()];
    for(int i=0; i<ingredients.size(); i++)
    {
      ip[i] = new IngredientPanel(parentFrame, ingredients.get(i), this);
      box.add(ip[i]);
    }
    
    box.revalidate();
    box.repaint();
	}
}
