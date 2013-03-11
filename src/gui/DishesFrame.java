package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import main.Dish;
import main.DishFactory;
import main.Ingredient;
import main.IngredientFactory;

public class DishesFrame extends JPanel
{

  Box box;
  ArrayList<Dish> dishes;
  final Component parentFrame;
  
  /**
   * Create the panel.
   */
  public DishesFrame(Component parent) {
    
    dishes = new ArrayList<Dish>();
    
    setLayout(new BorderLayout(0, 0));
    parentFrame = parent;
    JSeparator separator = new JSeparator();
    this.add(separator, BorderLayout.NORTH);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setOrientation(SwingConstants.VERTICAL);
    toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
    toolBar.setFloatable(false);
    add(toolBar, BorderLayout.WEST);
    
    JButton btnAdd = new JButton("New");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        JDialog addDish = new AddDish(parentFrame);
        addDish.setVisible(true);
        
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
    
    DishFactory.refreshDishes(dishes);
    
    JPanel[] ip = new JPanel[dishes.size()];
    for(int i=0; i<dishes.size(); i++)
    {
      ip[i] = new DishPanel(parentFrame, dishes.get(i), this);
      box.add(ip[i]);
    }
    
    box.revalidate();
    box.repaint();
  }

}
