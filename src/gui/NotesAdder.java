package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Dish;
import main.Ingredient;
import main.InputVerifier;
import db.DBInterface;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class NotesAdder extends JDialog
{

  private final JPanel contentPanel = new JPanel();

  /**
   * Launch the application.
   */
  /*
  public static void main(String[] args)
  {
    try
    {
      NotesEditor dialog = new NotesEditor();
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
  public NotesAdder(Component parent, final main.Order order){
    super((Frame) parent); //for modailty i need to pass the parent through to here and use the super constructor to lock that parent down
    setIconImage(Toolkit.getDefaultToolkit().getImage(NotesAdder.class.getResource("/gui/resources/img16x16/view-pim-notes.png")));
    final Component parentFrame = parent;
    setTitle("Note");
    setBounds(100, 100, 450, 300);
    setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    final JTextPane textPane = new JTextPane();
    textPane.setText(order.getNotes());
    contentPanel.setLayout(new BorderLayout(0, 0));
    {
      contentPanel.add(textPane, BorderLayout.CENTER);
      textPane.setText(order.getNotes());
    }
    {
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        JButton okButton = new JButton("Accept");
        okButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            order.setNotes(textPane.getText());
            setVisible(false);
          }
        });
        okButton.setActionCommand("OK");
        okButton.setIcon(new ImageIcon(EditIngredient.class.getResource("/gui/resources/img32x32/dialog-ok-apply-2.png")));
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
        cancelButton.setIcon(new ImageIcon(EditIngredient.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
        cancelButton.setBounds(199, 0, 118, 38);
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

}
