package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import main.ProcessedOrderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArchiveFrame extends JPanel
{
  ArrayList<main.Order> orders;
  Box box;
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
    btnRefresh.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        refresh();
      }
    });
    btnRefresh.setIcon(new ImageIcon(FeedFrame.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
    toolBar.add(btnRefresh);
    
    JScrollPane scrollPane = new JScrollPane();
    add(scrollPane, BorderLayout.CENTER);
    
    box = Box.createVerticalBox();
    box.setAutoscrolls(true);
    scrollPane.setViewportView(box);
    
    atp = new ArchiveTitlePanel();
    box.add(atp);
    //add to the panel
    for(int i=0; i<archivePanels.size(); i++)
      box.add(archivePanels.get(i));

  }
  
  public void refresh()
  {
    //remove all
    box.removeAll();
    atp = new ArchiveTitlePanel();
    box.add(atp);
    //refresh
    ProcessedOrderFactory.refreshOrders(orders);
    //reload the orderPanels
    archivePanels.removeAll(archivePanels);
    for(int i=0; i<orders.size(); i++)
    {
      archivePanels.add(new ArchivePanel(orders.get(i), this));
      //add them back to the frame
      box.add(archivePanels.get(i));
    }//for
    
    box.revalidate();
    box.repaint();
  }//refresh
  
  
  //TODO update() //as this can get very costly, as the number of orders processed increases
}
