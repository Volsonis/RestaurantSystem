package gui;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

import db.DBInterface;

import main.Dish;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class OrderPanel extends JPanel
{

  /**
   * Create the panel.
   */
  public OrderPanel(final Component parentWindow, final main.Order order, final OrdersFrame parentFrame) {
    setMaximumSize(new Dimension(1024, 80));
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{217, 98, 120, 0, 0};
    gridBagLayout.rowHeights = new int[]{40, 40, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);
    
    JLabel numberLabel = new JLabel(String.valueOf(order.getNumber()));
    numberLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_numberLabel = new GridBagConstraints();
    gbc_numberLabel.insets = new Insets(0, 0, 5, 5);
    gbc_numberLabel.gridx = 0;
    gbc_numberLabel.gridy = 0;
    add(numberLabel, gbc_numberLabel);
    
    JLabel tableLabel = new JLabel(String.valueOf(order.getTablenumber()));
    tableLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_tableLabel = new GridBagConstraints();
    gbc_tableLabel.insets = new Insets(0, 0, 5, 5);
    gbc_tableLabel.gridx = 1;
    gbc_tableLabel.gridy = 0;
    add(tableLabel, gbc_tableLabel);
    
    JLabel priceLabel = new JLabel(String.valueOf(order.getPrice()));
    priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    GridBagConstraints gbc_priceLabel = new GridBagConstraints();
    gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
    gbc_priceLabel.gridx = 2;
    gbc_priceLabel.gridy = 0;
    add(priceLabel, gbc_priceLabel);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    GridBagConstraints gbc_toolBar = new GridBagConstraints();
    gbc_toolBar.gridheight = 2;
    gbc_toolBar.insets = new Insets(0, 0, 5, 0);
    gbc_toolBar.gridx = 3;
    gbc_toolBar.gridy = 0;
    add(toolBar, gbc_toolBar);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        //delete order and references from db
        try
        {
          DBInterface.deleteOrder(order);
        } catch (SQLException e1)
        {
          Error err = new Error(parentWindow,"Database Error", e1.getMessage());
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
    btnDelete.setIcon(new ImageIcon(OrderPanel.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
    toolBar.add(btnDelete);
    
    JButton btnNotes = new JButton("Notes");
    btnNotes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JDialog editNote = new NotesEditor(parentWindow, order);
        editNote.setVisible(true);
      }
    });
    btnNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnNotes.setIcon(new ImageIcon(OrderPanel.class.getResource("/gui/resources/img32x32/view-pim-notes.png")));
    toolBar.add(btnNotes);
    
    JButton btnEdit = new JButton("Edit");
    btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnEdit.setIcon(new ImageIcon(OrderPanel.class.getResource("/gui/resources/img32x32/edit-4.png")));
    toolBar.add(btnEdit);
    
    JLabel dishesLabel = new JLabel(order.dishesToString());
    dishesLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_dishesLabel = new GridBagConstraints();
    gbc_dishesLabel.gridwidth = 3;
    gbc_dishesLabel.insets = new Insets(0, 0, 0, 5);
    gbc_dishesLabel.gridx = 0;
    gbc_dishesLabel.gridy = 1;
    add(dishesLabel, gbc_dishesLabel);

  }

}
