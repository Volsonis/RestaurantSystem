package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame
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
          Order frame = new Order();
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
  public Order() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(Order.class.getResource("/gui/resources/img16x16/cart-go.png")));
    setTitle("RestaurantSystem - Order");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 860, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    contentPane.add(toolBar, BorderLayout.NORTH);
    
    JButton btnNew = new JButton("New");
    btnNew.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    btnNew.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/document-new-6.png")));
    toolBar.add(btnNew);
    
    JButton btnOrders = new JButton("Orders");
    
    btnOrders.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/edit-copy-9.png")));
    toolBar.add(btnOrders);
    
    //glue to stick components to the right
    toolBar.add(Box.createHorizontalGlue());
    JButton btnExit = new JButton("Exit");
    btnExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }
    });
    btnExit.setAlignmentX(Component.RIGHT_ALIGNMENT);
    toolBar.add(btnExit);
    btnExit.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/dialog-close-2.png")));
    
    final JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    
    final NewOrderPanel newOrderPanel = new NewOrderPanel(this);
    panel.add(newOrderPanel);
    
    btnNew.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        panel.add(newOrderPanel);
        revalidate();
        repaint();
      }
    });
    
    final OrdersFrame ordersFrame = new OrdersFrame(this);
    
    btnOrders.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        panel.add(ordersFrame);
        revalidate();
        repaint();
      }
    });
    
  }

}
