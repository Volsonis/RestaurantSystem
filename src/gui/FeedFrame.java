package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JScrollPane;

import main.OrderFactory;

public class FeedFrame extends JPanel
{

  ArrayList<main.Order> orders;
  JPanel panel;
  ArrayList<FeedPanel> orderPanels;
  /**
   * Create the panel.
   */
  public FeedFrame() {
    setLayout(new BorderLayout(0, 0));
    
    orders = new ArrayList<main.Order>();
    orderPanels = new ArrayList<FeedPanel>();
    
    OrderFactory.refreshOrders(orders);
    
    for(int i=0; i<orders.size(); i++)
      orderPanels.add(new FeedPanel(orders.get(i)));
    
    JToolBar toolBar = new JToolBar();
    toolBar.setOrientation(SwingConstants.VERTICAL);
    toolBar.setFloatable(false);
    add(toolBar, BorderLayout.WEST);
    
    JButton btnRefresh = new JButton("Refresh");
    btnRefresh.setIcon(new ImageIcon(FeedFrame.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
    toolBar.add(btnRefresh);
    
    JScrollPane scrollPane = new JScrollPane();
    add(scrollPane, BorderLayout.CENTER);
    
    panel = new JPanel();
    scrollPane.setViewportView(panel);
    panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
    
    //add to the panel
    for(int i=0; i<orderPanels.size(); i++)
      panel.add(orderPanels.get(i));

  }
  
  public void refresh()
  {
    //remove all
    panel.removeAll();
    //refresh
    OrderFactory.refreshOrders(orders);
    //reload the orderPanels
    orderPanels.removeAll(orderPanels);
    for(int i=0; i<orders.size(); i++)
    {
      orderPanels.add(new FeedPanel(orders.get(i)));
      //add them back to the frame
      panel.add(orderPanels.get(i));
    }//for
    
    revalidate();
    repaint();
  }//refresh

}
