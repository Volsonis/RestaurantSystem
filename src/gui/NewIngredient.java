package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewIngredient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewIngredient frame = new NewIngredient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewIngredient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewIngredient.class.getResource("/gui/resources/img16x16/list-add-5.png")));
		setTitle("New Ingredient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelButtons = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelButtons, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
		);
		panelButtons.setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO validate input
				
				//after validation propagate input through to database
				
				//refresh the main window
				
				//close this window
			}
		});
		btnAccept.setIcon(new ImageIcon(NewIngredient.class.getResource("/gui/resources/img32x32/dialog-ok-apply-2.png")));
		btnAccept.setBounds(69, 0, 118, 38);
		panelButtons.add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// logic goes here
				// on cancel button just close the window without omitting any changes
				contentPane.setVisible(false);
			}
		});
		btnCancel.setIcon(new ImageIcon(NewIngredient.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
		btnCancel.setBounds(199, 0, 118, 38);
		panelButtons.add(btnCancel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 30, 52, 16);
		panel.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(12, 75, 52, 16);
		panel.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(55, 27, 307, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 72, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(203, 75, 52, 16);
		panel.add(lblStock);
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 72, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
}
