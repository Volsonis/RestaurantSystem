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

public class OrderTitlePanel extends JPanel
{


  /**
   * Create the panel.
   */
  public OrderTitlePanel() {
    setMaximumSize(new Dimension(1024, 30));
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{217, 98, 120, 0, 0};
    gridBagLayout.rowHeights = new int[]{30, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);
    
    JLabel numberLabel = new JLabel("Order Number");
    numberLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_numberLabel = new GridBagConstraints();
    gbc_numberLabel.insets = new Insets(0, 0, 0, 5);
    gbc_numberLabel.gridx = 0;
    gbc_numberLabel.gridy = 0;
    add(numberLabel, gbc_numberLabel);
    
    JLabel tableLabel = new JLabel("Table");
    tableLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_tableLabel = new GridBagConstraints();
    gbc_tableLabel.insets = new Insets(0, 0, 0, 5);
    gbc_tableLabel.gridx = 1;
    gbc_tableLabel.gridy = 0;
    add(tableLabel, gbc_tableLabel);
    
    JLabel priceLabel = new JLabel("Price");
    priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    GridBagConstraints gbc_priceLabel = new GridBagConstraints();
    gbc_priceLabel.insets = new Insets(0, 0, 0, 5);
    gbc_priceLabel.gridx = 2;
    gbc_priceLabel.gridy = 0;
    add(priceLabel, gbc_priceLabel);
  }


}
