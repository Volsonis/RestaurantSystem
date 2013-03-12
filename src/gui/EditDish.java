package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import main.Dish;
import main.InputVerifier;
import db.DBInterface;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditDish extends JDialog
{

  private final JPanel contentPanel = new JPanel();
  private JTextField nameTextField;
  private JTextField descriptionTextField;
  private JTextField priceTextField;
  private JTextField ingredientsTextField;

  /**
   * Launch the application.
   */
  /*
  public static void main(String[] args)
  {
    try
    {
      EditDish dialog = new EditDish();
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  */
  
  /**
   * Create the dialog.
   */
  public EditDish(Component parent, final Dish dish) {
    super((Frame) parent); //for modailty i need to pass the parent through to here and use the super constructor to lock that parent down
    final Component parentFrame = parent;
    setIconImage(Toolkit.getDefaultToolkit().getImage(AddIngredient.class.getResource("/gui/resources/img16x16/list-add-5.png")));
    setTitle("Add Dish");
    
    setBounds(100, 100, 500, 330);
    setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    
    JLabel lblName = new JLabel("Name: ");
    
    nameTextField = new JTextField();
    nameTextField.setColumns(10);
    nameTextField.setText(dish.getName());
    
    JLabel lblDescription = new JLabel("Description:");
    
    descriptionTextField = new JTextField();
    descriptionTextField.setColumns(10);
    descriptionTextField.setText(dish.getDescripton());
    
    JLabel lblPrice = new JLabel("Price:");
    
    priceTextField = new JTextField();
    priceTextField.setColumns(10);
    priceTextField.setText(String.valueOf(dish.getPrice()));
    
    JLabel lblIngredients = new JLabel("Ingredients:");
    
    ingredientsTextField = new JTextField();
    ingredientsTextField.setEditable(false);
    ingredientsTextField.setColumns(10);
    ingredientsTextField.setText(dish.ingredientsToString());
    
    JButton ingredientsChooserButton = new JButton("Choose Ingredients");
    ingredientsChooserButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //open the ingredientChooser
        IngredientChooser ic = new IngredientChooser(parentFrame, dish);
        ic.setVisible(true);
        
        //put the new text in and revalidate
        ingredientsTextField.setText(dish.ingredientsToString());
        ingredientsTextField.revalidate();
      }
    });
    
    final JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mains", "Starters", "Desserts", "Sides", "Alcoholic", "Non-Alcoholic"}));
    comboBox.setSelectedItem(dish.getType());
    
    JLabel lblType = new JLabel("Type: ");
    GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
    gl_contentPanel.setHorizontalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addContainerGap()
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPanel.createSequentialGroup()
              .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(lblDescription)
                .addComponent(lblName)
                .addComponent(lblPrice))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addComponent(descriptionTextField, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addGroup(gl_contentPanel.createSequentialGroup()
                  .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addGap(18)
                  .addComponent(lblType)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(comboBox, 0, 248, Short.MAX_VALUE))))
            .addGroup(gl_contentPanel.createSequentialGroup()
              .addComponent(lblIngredients)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(ingredientsTextField, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(ingredientsChooserButton)))
          .addContainerGap())
    );
    gl_contentPanel.setVerticalGroup(
      gl_contentPanel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPanel.createSequentialGroup()
          .addGap(25)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblName)
            .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblDescription)
            .addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblPrice)
            .addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblType))
          .addGap(18)
          .addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblIngredients)
            .addComponent(ingredientsTextField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
            .addComponent(ingredientsChooserButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(28, Short.MAX_VALUE))
    );
    contentPanel.setLayout(gl_contentPanel);
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Accept");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            
            try
            {
                                                                 
              dish.setName(nameTextField.getText());
              dish.setDescripton(descriptionTextField.getText());
              dish.setPrice(Double.parseDouble(priceTextField.getText()));
              dish.setType((String)comboBox.getSelectedItem());
              
              InputVerifier.verifyDish(dish);
              
              DBInterface.editDish(dish.getID(), dish);
              
              //then close the window
              setVisible(false);
              
            } catch (SQLException e)
            {
              Error err = new Error(parentFrame,"Database Error", e.getMessage());
              err.setVisible(true);
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            catch(Exception e)
            {
              Error err = new Error(parentFrame,"Error", e.getMessage());
              err.setVisible(true);
              e.printStackTrace();
            }
            
            
           
          }
        });
        okButton.setActionCommand("OK");
        okButton.setIcon(new ImageIcon(AddIngredient.class.getResource("/gui/resources/img32x32/dialog-ok-apply-2.png")));
        okButton.setBounds(69, 0, 118, 38);
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            //logic goes here
            //just close the window on cancel
            setVisible(false);
          }
        });
        cancelButton.setIcon(new ImageIcon(AddIngredient.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
        cancelButton.setBounds(199, 0, 118, 38);
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
