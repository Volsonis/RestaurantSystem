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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeedPanel extends JPanel
{
  private JTextField textField;
  private JTextField timeTextField;
  private JTextArea textArea;
  private JTextArea notesTextArea;
  /**
   * Create the panel.
   */
  public FeedPanel(final main.Order order) {
    setPreferredSize(new Dimension(300, 400));
    setMinimumSize(new Dimension(300, 400));
    setSize(new Dimension(300, 400));
    setMaximumSize(new Dimension(300, 400));
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
    
    JLabel lblNewLabel = new JLabel("At: ");
    lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
    
    timeTextField = new JTextField();
    timeTextField.setEditable(false);
    timeTextField.setFont(new Font("Calibri", Font.PLAIN, 18));
    timeTextField.setColumns(10);
    //TODO add time the order was first seen
    //timeTextField.setText(String.valueOf(order.getDate().getTime()));
    
    textArea = new JTextArea();
    textArea.setFont(new Font("Calibri", Font.PLAIN, 18));
    textArea.setEditable(false);
    
    JButton btnRefresh = new JButton("Refresh");
    btnRefresh.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        refresh(order);
      }
    });
    btnRefresh.setIcon(new ImageIcon(FeedPanel.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
    
    notesTextArea = new JTextArea();
    notesTextArea.setFont(new Font("Calibri", Font.PLAIN, 18));
    notesTextArea.setEditable(false);
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(notesTextArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
            .addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
              .addComponent(lblOrder)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(textField, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(timeTextField, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
              .addComponent(btnRefresh)
              .addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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
            .addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(notesTextArea, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(btnRefresh)
            .addComponent(btnDismiss))
          .addContainerGap())
    );
    setLayout(groupLayout);
    
    textArea.setText(order.dishesToFeed());
    notesTextArea.setText(order.getNotes());
    
    revalidate();
    repaint();
  }
  
  public void refresh(main.Order order)
  {
    textArea.setText(order.dishesToFeed());
    notesTextArea.setText(order.getNotes());
    revalidate();
    repaint();
  }
  
}
