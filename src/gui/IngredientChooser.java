package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

import main.Dish;
import main.Ingredient;
import main.IngredientFactory;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;

public class IngredientChooser extends JDialog
{

  private final JPanel contentPanel = new JPanel();

  /**
   * Launch the application.
   */
  /*
   * public static void main(String[] args) { try { IngredientChooser dialog =
   * new IngredientChooser();
   * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
   * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
   */

  /**
   * Create the dialog.
   */
  public IngredientChooser(Component parent, final Dish dish) {
    super((Frame) parent); // for modailty i need to pass the parent through to
                           // here and use the super constructor to lock that
                           // parent down
    final Component parentFrame = parent;

    final ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    IngredientFactory.refreshIngredients(ingredients);
    // TODO sort the ingredients by alphabet
    Collections.sort(ingredients, new Ingredient());

    final JCheckBox[] checkboxes = new JCheckBox[ingredients.size()];

    // if this is not a new Dish, it will already have dishes added to it
    String[] containedIngredients;
    List<String> containedIngredientsList = null;
    if (dish.getIngredients() != null)
    {
      containedIngredients = dish.getIngredients();
      containedIngredientsList = Arrays.asList(containedIngredients);
    }

    setTitle("IngredientChooser");
    setBounds(100, 100, 307, 415);
    setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setMaximumSize(new Dimension(250, 32767));
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      JScrollPane scrollPane = new JScrollPane();
      scrollPane
          .setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setMaximumSize(new Dimension(250, 32767));
      contentPanel.add(scrollPane, BorderLayout.CENTER);

      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(260, 600));
      scrollPane.setViewportView(panel);
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      // TODO add quantities
      // add a checkbox for each ingredient
      for (int i = 0; i < checkboxes.length; i++)
      {
        checkboxes[i] = new JCheckBox(ingredients.get(i).getName());
        // if this is not a new dish, it will already have dishes added to it,
        // make sure they are ticked in the chooser
        if (containedIngredientsList != null
            && containedIngredientsList.contains(ingredients.get(i).getName()))
          checkboxes[i].setSelected(true);

        panel.add(checkboxes[i]);
      }// for
    }

    JPanel buttonPane = new JPanel();
    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
    getContentPane().add(buttonPane, BorderLayout.SOUTH);
    {
      JButton okButton = new JButton("OK");
      okButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          ArrayList<Ingredient> chosenIngredients = new ArrayList<Ingredient>();
          for (int i = 0; i < checkboxes.length; i++)
          {
            if (checkboxes[i].isSelected())
            {
              // TODO check that at least one ingredient was ticked
              // find that ingredient in the ingredient arraylist and add it to
              // the chosenIngredients
              chosenIngredients.add(ingredients.get(i));

            }
          }// for

          // set the ingredients_id and ingredient array of the input dish
          String[] ingredients = new String[chosenIngredients.size()];
          int[] ingredient_ids = new int[chosenIngredients.size()];
          for (int i = 0; i < ingredients.length; i++)
          {
            ingredients[i] = chosenIngredients.get(i).getName();
            ingredient_ids[i] = chosenIngredients.get(i).getId();
          }
          dish.setIngredient_id(ingredient_ids);
          dish.setIngredients(ingredients);

          // close the chooser
          setVisible(false);

        }
      });
      okButton.setActionCommand("OK");
      buttonPane.add(okButton);
      getRootPane().setDefaultButton(okButton);

      {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            setVisible(false);
          }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
