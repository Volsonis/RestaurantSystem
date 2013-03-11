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
    setTitle("Order");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    contentPane.add(toolBar, BorderLayout.NORTH);
    
    JButton btnExit = new JButton("New");
    btnExit.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/document-new-6.png")));
    toolBar.add(btnExit);
    
    JButton btnOrders = new JButton("Orders");
    btnOrders.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/edit-copy-9.png")));
    toolBar.add(btnOrders);
    
    //glue to stick components to the right
    toolBar.add(Box.createHorizontalGlue());
    JButton btnExit_1 = new JButton("Exit");
    btnExit_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }
    });
    btnExit_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    toolBar.add(btnExit_1);
    btnExit_1.setIcon(new ImageIcon(Order.class.getResource("/gui/resources/img32x32/dialog-close-2.png")));
    
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.CENTER);
    
    NewOrderPanel newOrderPanel = new NewOrderPanel(this);
    panel.add(newOrderPanel);
  }

}
