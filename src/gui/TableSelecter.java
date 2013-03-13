package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class TableSelecter extends JDialog
{

  private final JPanel contentPanel = new JPanel();
  private JTextField textField;

  /**
   * Launch the application.
   */
  /*
  public static void main(String[] args)
  {
    try
    {
      TableSelecter dialog = new TableSelecter();
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
  public TableSelecter(Component parent, final main.Order order) {
    setIconImage(Toolkit.getDefaultToolkit().getImage(TableSelecter.class.getResource("/gui/resources/img16x16/draw-square-inverted-corners.png")));
    setTitle("Table Selecter");
    setBounds(100, 100, 188, 300);
    setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    GridBagLayout gbl_contentPanel = new GridBagLayout();
    gbl_contentPanel.columnWidths = new int[]{0, 0, 50, 0, 0, 0, 0, 0};
    gbl_contentPanel.rowHeights = new int[]{79, 40, 40, 40, 40, 0};
    gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPanel.setLayout(gbl_contentPanel);
    {
     
      {
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 3;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 0;
        contentPanel.add(textField, gbc_textField);
        textField.setColumns(10);
      }
      JButton button = new JButton("1");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "1");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 2;
      gbc_button.gridy = 1;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("2");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "2");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 3;
      gbc_button.gridy = 1;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("3");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "3");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 4;
      gbc_button.gridy = 1;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("4");
      button.setMinimumSize(new Dimension(55, 40));
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "4");
        }
      });
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 2;
      gbc_button.gridy = 2;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("5");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "5");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 3;
      gbc_button.gridy = 2;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("6");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "6");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 4;
      gbc_button.gridy = 2;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("7");
      button.setMinimumSize(new Dimension(55, 40));
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "7");
        }
      });
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 2;
      gbc_button.gridy = 3;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("8");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "8");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      button.setMaximumSize(new Dimension(40, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 3;
      gbc_button.gridy = 3;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton button = new JButton("9");
      button.setMinimumSize(new Dimension(55, 40));
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "9");
        }
      });
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 5, 5);
      gbc_button.gridx = 4;
      gbc_button.gridy = 3;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton btnDel = new JButton("DEL");
      btnDel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText("");
        }
      });
      btnDel.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_btnDel = new GridBagConstraints();
      gbc_btnDel.insets = new Insets(0, 0, 0, 5);
      gbc_btnDel.gridx = 2;
      gbc_btnDel.gridy = 4;
      contentPanel.add(btnDel, gbc_btnDel);
    }
    {
      JButton button = new JButton("0");
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          textField.setText(textField.getText() + "0");
        }
      });
      button.setMinimumSize(new Dimension(55, 40));
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.insets = new Insets(0, 0, 0, 5);
      gbc_button.gridx = 3;
      gbc_button.gridy = 4;
      contentPanel.add(button, gbc_button);
    }
    {
      JButton btnOk = new JButton("OK");
      btnOk.setMinimumSize(new Dimension(55, 40));
      btnOk.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          order.setTablenumber(Integer.parseInt(textField.getText()));
          setVisible(false);
        }
      });
      GridBagConstraints gbc_btnOk = new GridBagConstraints();
      gbc_btnOk.insets = new Insets(0, 0, 0, 5);
      gbc_btnOk.gridx = 4;
      gbc_btnOk.gridy = 4;
      contentPanel.add(btnOk, gbc_btnOk);
    }
  }

}
