package gui;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import db.DBInterface;

import main.Dish;
import main.Ingredient;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class DishPanel extends JPanel
{

  /**
   * Create the panel.
   */
  public DishPanel(final Component parentWindow, final Dish dish, final DishesFrame parentFrame) {
    setBorder(new LineBorder(Color.LIGHT_GRAY));
    setMaximumSize(new Dimension(1024, 50));
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{262, 191, 93, 133, 0};
    gridBagLayout.rowHeights = new int[]{26, 20, 0};
    gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
    setLayout(gridBagLayout);
    
    JLabel nameLabel = new JLabel(dish.getName());
    nameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
    GridBagConstraints gbc_nameLabel = new GridBagConstraints();
    gbc_nameLabel.anchor = GridBagConstraints.WEST;
    gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
    gbc_nameLabel.gridx = 0;
    gbc_nameLabel.gridy = 0;
    add(nameLabel, gbc_nameLabel);
    
    JLabel ingredientsLabel = new JLabel(dish.ingredientsToString());
    ingredientsLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
    GridBagConstraints gbc_ingredientsLabel = new GridBagConstraints();
    gbc_ingredientsLabel.anchor = GridBagConstraints.WEST;
    gbc_ingredientsLabel.insets = new Insets(0, 0, 5, 5);
    gbc_ingredientsLabel.gridx = 1;
    gbc_ingredientsLabel.gridy = 0;
    add(ingredientsLabel, gbc_ingredientsLabel);
    
    JLabel priceLabel = new JLabel(String.valueOf(dish.getPrice()) + "£");
    GridBagConstraints gbc_priceLabel = new GridBagConstraints();
    gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
    gbc_priceLabel.gridx = 2;
    gbc_priceLabel.gridy = 0;
    add(priceLabel, gbc_priceLabel);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    GridBagConstraints gbc_toolBar = new GridBagConstraints();
    gbc_toolBar.gridheight = 2;
    gbc_toolBar.gridx = 3;
    gbc_toolBar.gridy = 0;
    add(toolBar, gbc_toolBar);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      
        //delete dish and references from db
        try
        {
          DBInterface.deleteDish(dish);
        } catch (SQLException e)
        {
          Error err = new Error(parentWindow,"Database Error", e.getMessage());
          err.setVisible(true);
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        //refresh parent frame
        parentFrame.refresh();
      }
    });
    btnDelete.setIcon(new ImageIcon(DishPanel.class.getResource("/gui/resources/img22x22/dialog-cancel-2.png")));
    toolBar.add(btnDelete);
    
    JButton btnEdit = new JButton("Edit");
    btnEdit.setIcon(new ImageIcon(DishPanel.class.getResource("/gui/resources/img22x22/edit-4.png")));
    toolBar.add(btnEdit);
    
    JLabel descriptionLabel = new JLabel(dish.getDescripton());
    descriptionLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
    GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
    gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
    gbc_descriptionLabel.insets = new Insets(0, 0, 0, 5);
    gbc_descriptionLabel.gridwidth = 3;
    gbc_descriptionLabel.gridx = 0;
    gbc_descriptionLabel.gridy = 1;
    add(descriptionLabel, gbc_descriptionLabel);

  }

}
