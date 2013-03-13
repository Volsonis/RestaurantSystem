package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import db.DBInterface;

public class ArchivePanel extends JPanel
{

  /**
   * Create the panel.
   */
  public ArchivePanel(final main.Order order, final ArchiveFrame parentFrame) {
    setMaximumSize(new Dimension(1024, 80));
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{99, 101, 99, 100, 101, 100, 100, 42, 43, 47, 0};
    gridBagLayout.rowHeights = new int[]{40, 40, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);
    
    JLabel numberLabel = new JLabel(String.valueOf(order.getPendingorders_id()));
    numberLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_numberLabel = new GridBagConstraints();
    gbc_numberLabel.insets = new Insets(0, 0, 5, 5);
    gbc_numberLabel.gridx = 0;
    gbc_numberLabel.gridy = 0;
    add(numberLabel, gbc_numberLabel);
    
    JLabel customerLabel = new JLabel(String.valueOf(order.getTablenumber()));
    customerLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_customerLabel = new GridBagConstraints();
    gbc_customerLabel.insets = new Insets(0, 0, 5, 5);
    gbc_customerLabel.gridx = 1;
    gbc_customerLabel.gridy = 0;
    add(customerLabel, gbc_customerLabel);
    
    JLabel tabelLabel = new JLabel(String.valueOf(order.getTablenumber()));
    tabelLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_tabelLabel = new GridBagConstraints();
    gbc_tabelLabel.insets = new Insets(0, 0, 5, 5);
    gbc_tabelLabel.gridx = 2;
    gbc_tabelLabel.gridy = 0;
    add(tabelLabel, gbc_tabelLabel);
    
    JLabel discountLabel = new JLabel("0");
    discountLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_discountLabel = new GridBagConstraints();
    gbc_discountLabel.insets = new Insets(0, 0, 5, 5);
    gbc_discountLabel.gridx = 3;
    gbc_discountLabel.gridy = 0;
    add(discountLabel, gbc_discountLabel);
    
    JLabel priceLabel = new JLabel(String.valueOf(order.getPrice()));
    priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    GridBagConstraints gbc_priceLabel = new GridBagConstraints();
    gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
    gbc_priceLabel.gridx = 5;
    gbc_priceLabel.gridy = 0;
    add(priceLabel, gbc_priceLabel);
    
    JLabel dateLabel = new JLabel(order.getDate().toString());
    dateLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_dateLabel = new GridBagConstraints();
    gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
    gbc_dateLabel.gridx = 6;
    gbc_dateLabel.gridy = 0;
    add(dateLabel, gbc_dateLabel);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    GridBagConstraints gbc_toolBar = new GridBagConstraints();
    gbc_toolBar.gridwidth = 3;
    gbc_toolBar.gridheight = 2;
    gbc_toolBar.gridx = 7;
    gbc_toolBar.gridy = 0;
    add(toolBar, gbc_toolBar);
    
    JButton btnDelete = new JButton("Reverse");
    //TODO make reverse button disabled, if order.getDate() is not today
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        //delete order and references from db
        try
        {
          DBInterface.deleteOrder(order);//reverse
        } catch (SQLException e1)
        {
          Error err = new Error(null,"Database Error", e1.getMessage());
          err.setVisible(true);
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        //refresh parent frame
        parentFrame.refresh();
        parentFrame.revalidate();
        parentFrame.repaint();
      }
      
    });
    btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnDelete.setIcon(new ImageIcon(ArchivePanel.class.getResource("/gui/resources/img32x32/edit-undo-6.png")));
    toolBar.add(btnDelete);
    
    
    JLabel dishesLabel = new JLabel(order.dishesToString());
    dishesLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_dishesLabel = new GridBagConstraints();
    gbc_dishesLabel.gridwidth = 4;
    gbc_dishesLabel.insets = new Insets(0, 0, 0, 5);
    gbc_dishesLabel.gridx = 0;
    gbc_dishesLabel.gridy = 1;
    add(dishesLabel, gbc_dishesLabel);
    
    JLabel notesLabel = new JLabel(order.getNotes());
    notesLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_notesLabel = new GridBagConstraints();
    gbc_notesLabel.gridwidth = 3;
    gbc_notesLabel.insets = new Insets(0, 0, 0, 5);
    gbc_notesLabel.gridx = 4;
    gbc_notesLabel.gridy = 1;
    add(notesLabel, gbc_notesLabel);

  }

}
