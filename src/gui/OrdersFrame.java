package gui;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

import main.DishFactory;
import main.OrderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OrdersFrame extends JPanel
{

  Box box;
  ArrayList<main.Order> orders;
  final Component parentFrame;
  
  /**
   * Create the panel.
   */
  public OrdersFrame(Component parent) {
    
    orders = new ArrayList<main.Order>();
    
    setLayout(new BorderLayout(0, 0));
    parentFrame = parent;
    JSeparator separator = new JSeparator();
    this.add(separator, BorderLayout.NORTH);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setOrientation(SwingConstants.VERTICAL);
    toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
    toolBar.setFloatable(false);
    add(toolBar, BorderLayout.WEST);
    
    JButton button = new JButton("Refresh");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        refresh();
        revalidate();
        repaint();
      }
    });
    button.setIcon(new ImageIcon(OrdersFrame.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
    button.setFont(new Font("Tahoma", Font.PLAIN, 14));
    button.setVerticalTextPosition(SwingConstants.BOTTOM);
    button.setHorizontalTextPosition(SwingConstants.CENTER);
    button.setAlignmentX(0.5f);
    toolBar.add(button);
    
    JScrollPane scrollPane = new JScrollPane();
    add(scrollPane, BorderLayout.CENTER);

    
    
    box = Box.createVerticalBox();
    box.setAutoscrolls(true);
    scrollPane.setViewportView(box);
    
    //refresh();
  }
  
  public void refresh()
  {
    
    box.removeAll();
    
    OrderFactory.refreshOrders(orders);
    
    JPanel[] ip = new JPanel[orders.size()];
    for(int i=0; i<orders.size(); i++)
    {
      ip[i] = new OrderPanel(parentFrame, orders.get(i), this);
      box.add(ip[i]);
    }
    
    box.revalidate();
    box.repaint();
  }

}
