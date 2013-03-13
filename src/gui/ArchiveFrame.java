package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import main.ProcessedOrderFactory;

public class ArchiveFrame extends JPanel
{
  ArrayList<main.Order> orders;
  JPanel panel;
  ArrayList<ArchivePanel> archivePanels;
  ArchiveTitlePanel atp;
  /**
   * Create the panel.
   */
  public ArchiveFrame() 
  {
    setLayout(new BorderLayout(0, 0));
    
    orders = new ArrayList<main.Order>();
    archivePanels = new ArrayList<ArchivePanel>();
    
    ProcessedOrderFactory.refreshOrders(orders);
    
    for(int i=0; i<orders.size(); i++)
      archivePanels.add(new ArchivePanel(orders.get(i), this));
    
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
    
    atp = new ArchiveTitlePanel();
    panel.add(atp);
    //add to the panel
    for(int i=0; i<archivePanels.size(); i++)
      panel.add(archivePanels.get(i));

  }
  
  public void refresh()
  {
    //remove all
    panel.removeAll();
    atp = new ArchiveTitlePanel();
    panel.add(atp);
    //refresh
    ProcessedOrderFactory.refreshOrders(orders);
    //reload the orderPanels
    archivePanels.removeAll(archivePanels);
    for(int i=0; i<orders.size(); i++)
    {
      archivePanels.add(new ArchivePanel(orders.get(i), this));
      //add them back to the frame
      panel.add(archivePanels.get(i));
    }//for
    
    revalidate();
    repaint();
  }//refresh
  
  
  //TODO update() //as this can get very costly, as the number of orders processed increases
}
