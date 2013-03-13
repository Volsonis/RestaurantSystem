package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KitchenDisplay extends JFrame
{

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          KitchenDisplay frame = new KitchenDisplay();
          frame.setVisible(true);
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public KitchenDisplay() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(KitchenDisplay.class.getResource("/gui/resources/img16x16/burgerspace.png")));
    setTitle("RestaurantSystem - Kitchen Display");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1024, 768);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    contentPane.add(toolBar, BorderLayout.NORTH);
    
    final JPanel panel = new JPanel();
    final JPanel feed = new FeedFrame();
    final JPanel archive = new ArchiveFrame();
    JButton orderQueueButton = new JButton("Live Queue");
    orderQueueButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        
        panel.add(feed);
        
        feed.setVisible(true);
        
        revalidate();
        repaint();
        
      }
    });
    orderQueueButton.setIcon(new ImageIcon(KitchenDisplay.class.getResource("/gui/resources/img32x32/db_update.png")));
    toolBar.add(orderQueueButton);
    
    JButton btnArchive = new JButton("Archive");
    btnArchive.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        
        panel.add(archive);
        
        archive.setVisible(true);
        
        revalidate();
        repaint();
      }
    });
    btnArchive.setIcon(new ImageIcon(KitchenDisplay.class.getResource("/gui/resources/img32x32/document-open-8.png")));
    toolBar.add(btnArchive);
    
    Component horizontalGlue = Box.createHorizontalGlue();
    toolBar.add(horizontalGlue);
    
    JButton btnNewButton = new JButton("Exit");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    btnNewButton.setIcon(new ImageIcon(KitchenDisplay.class.getResource("/gui/resources/img32x32/dialog-close-2.png")));
    toolBar.add(btnNewButton);
    
    
    contentPane.add(panel, BorderLayout.CENTER);
    panel.setLayout(new BorderLayout(0, 0));
    
    panel.add(feed);
    feed.setVisible(true);
  }

}
