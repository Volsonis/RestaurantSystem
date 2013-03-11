package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.SpinnerNumberModel;

import main.Ingredient;
import com.toedter.calendar.JDateChooser;

import db.DBInterface;

public class IngredientPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public IngredientPanel(final Component parentWindow, final Ingredient ingredient, final IngredientsFrame parentFrame) {
	  setMaximumSize(new Dimension(730, 40));
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{203, 61, 118, 62, 101, 136, 0, 0};
		gridBagLayout.rowHeights = new int[]{32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel(ingredient.getName());
		nameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.fill = GridBagConstraints.BOTH;
		gbc_nameLabel.insets = new Insets(0, 0, 0, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		JLabel priceLabel = new JLabel(String.valueOf(ingredient.getPrice()) + "£");
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.fill = GridBagConstraints.BOTH;
		gbc_priceLabel.insets = new Insets(0, 0, 0, 5);
		gbc_priceLabel.gridx = 1;
		gbc_priceLabel.gridy = 0;
		add(priceLabel, gbc_priceLabel);
		
		final JDateChooser dateChooser = new JDateChooser(ingredient.getExpires());
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 0;
		add(dateChooser, gbc_dateChooser);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setPreferredSize(new Dimension(29, 15));
		spinner.setFont(new Font("Calibri", Font.PLAIN, 14));
		spinner.setValue(ingredient.getStock());
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 0, 5);
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.gridx = 3;
		gbc_spinner.gridy = 0;
		add(spinner, gbc_spinner);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		GridBagConstraints gbc_toolBar_1 = new GridBagConstraints();
		gbc_toolBar_1.fill = GridBagConstraints.BOTH;
		gbc_toolBar_1.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar_1.gridx = 4;
		gbc_toolBar_1.gridy = 0;
		add(toolBar_1, gbc_toolBar_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    //when this button is pressed we just want to update stock and expiry date in the database and the instantiated list, nothing else
		    
		    try
        {
          DBInterface.editIngredient(ingredient.getId(), dateChooser.getDate(), (Integer)spinner.getValue());
          revalidate();
          repaint();
        } catch (SQLException e)
        {
          Error err = new Error(parentWindow,"Database Error", e.getMessage());
          err.setVisible(true);
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
		  }
		});
		toolBar_1.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img22x22/run-build.png")));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.fill = GridBagConstraints.BOTH;
		gbc_toolBar.gridx = 5;
		gbc_toolBar.gridy = 0;
		add(toolBar, gbc_toolBar);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  JDialog editIngredient = new EditIngredient(parentWindow, ingredient);
        editIngredient.setVisible(true);
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    
		    //delete Ingredient from db
		    try
        {
          DBInterface.deleteIngredient(ingredient);
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
		btnDelete.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img22x22/dialog-cancel-2.png")));
		toolBar.add(btnDelete);
		btnEdit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnEdit.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img22x22/edit-4.png")));
		toolBar.add(btnEdit);

	}
}
