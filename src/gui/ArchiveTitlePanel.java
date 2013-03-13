package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;



import javax.swing.JLabel;
import javax.swing.JPanel;




public class ArchiveTitlePanel extends JPanel
{

  /**
   * Create the panel.
   */
  public ArchiveTitlePanel() {
    setMaximumSize(new Dimension(1024, 30));
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{15, 88, 99, 105, 98, 101, 100, 100, 0};
    gridBagLayout.rowHeights = new int[]{30, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);
    
    JLabel numberLabel = new JLabel("Order No.");
    numberLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_numberLabel = new GridBagConstraints();
    gbc_numberLabel.gridwidth = 2;
    gbc_numberLabel.insets = new Insets(0, 0, 0, 5);
    gbc_numberLabel.gridx = 0;
    gbc_numberLabel.gridy = 0;
    add(numberLabel, gbc_numberLabel);
    
    JLabel customerLabel = new JLabel("Customer ID");
    customerLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_customerLabel = new GridBagConstraints();
    gbc_customerLabel.insets = new Insets(0, 0, 0, 5);
    gbc_customerLabel.gridx = 2;
    gbc_customerLabel.gridy = 0;
    add(customerLabel, gbc_customerLabel);
    
    JLabel tabelLabel = new JLabel("Table");
    tabelLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_tabelLabel = new GridBagConstraints();
    gbc_tabelLabel.insets = new Insets(0, 0, 0, 5);
    gbc_tabelLabel.gridx = 3;
    gbc_tabelLabel.gridy = 0;
    add(tabelLabel, gbc_tabelLabel);
    
    JLabel discountLabel = new JLabel("Discount");
    discountLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_discountLabel = new GridBagConstraints();
    gbc_discountLabel.insets = new Insets(0, 0, 0, 5);
    gbc_discountLabel.gridx = 4;
    gbc_discountLabel.gridy = 0;
    add(discountLabel, gbc_discountLabel);
    
    JLabel priceLabel = new JLabel("Price");
    priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    GridBagConstraints gbc_priceLabel = new GridBagConstraints();
    gbc_priceLabel.insets = new Insets(0, 0, 0, 5);
    gbc_priceLabel.gridx = 6;
    gbc_priceLabel.gridy = 0;
    add(priceLabel, gbc_priceLabel);
    
    JLabel dateLabel = new JLabel("Date");
    dateLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
    GridBagConstraints gbc_dateLabel = new GridBagConstraints();
    gbc_dateLabel.gridx = 7;
    gbc_dateLabel.gridy = 0;
    add(dateLabel, gbc_dateLabel);
  }

}
