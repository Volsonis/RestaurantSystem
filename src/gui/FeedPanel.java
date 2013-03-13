package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class FeedPanel extends JPanel
{
  private JTextField textField;
  private JTextField textField_1;
  private JTextArea textArea;
  /**
   * Create the panel.
   */
  public FeedPanel(main.Order order) {
    setPreferredSize(new Dimension(300, 300));
    setMinimumSize(new Dimension(300, 300));
    setSize(new Dimension(300, 300));
    setMaximumSize(new Dimension(300, 300));
    setBorder(new LineBorder(Color.LIGHT_GRAY));
    
    JButton btnDismiss = new JButton("Done");
    btnDismiss.setIcon(new ImageIcon(FeedPanel.class.getResource("/gui/resources/img32x32/dialog-ok-apply-2.png")));
    
    JLabel lblOrder = new JLabel("Order:");
    lblOrder.setFont(new Font("Calibri", Font.PLAIN, 18));
    
    textField = new JTextField();
    textField.setEditable(false);
    textField.setFont(new Font("Calibri", Font.PLAIN, 18));
    textField.setColumns(10);
    textField.setText(String.valueOf(order.getPendingorders_id()));
    
    JLabel lblNewLabel = new JLabel("In: ");
    lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
    
    textField_1 = new JTextField();
    textField_1.setEditable(false);
    textField_1.setFont(new Font("Calibri", Font.PLAIN, 18));
    textField_1.setColumns(10);
    //TODO add time the order was first seen
    
    textArea = new JTextArea();
    textArea.setFont(new Font("Calibri", Font.PLAIN, 18));
    textArea.setEditable(false);
    
    JButton btnRefresh = new JButton("Refresh");
    btnRefresh.setIcon(new ImageIcon(FeedPanel.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(textArea, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblOrder)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(btnRefresh)
              .addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
              .addComponent(btnDismiss)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblOrder)
            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel)
            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textArea, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(btnRefresh)
            .addComponent(btnDismiss))
          .addContainerGap())
    );
    setLayout(groupLayout);
    
    textArea.setText(order.dishesToFeed());
    
    revalidate();
    repaint();
  }
  
  public void refresh(main.Order order)
  {
    textArea.setText(order.dishesToFeed());
    revalidate();
    repaint();
  }
  
}
