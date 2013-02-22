package gui;

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

public class IngredientPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public IngredientPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setBounds(10, 11, 250, 32);
		add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Calibri", Font.PLAIN, 14));
		spinner.setBounds(341, 11, 65, 32);
		add(spinner);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(604, 11, 136, 32);
		add(toolBar);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
		toolBar.add(btnDelete);
		btnEdit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnEdit.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img32x32/edit-4.png")));
		toolBar.add(btnEdit);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(270, 11, 61, 32);
		add(label_1);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setFloatable(false);
		toolBar_1.setBounds(416, 11, 87, 32);
		add(toolBar_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(IngredientPanel.class.getResource("/gui/resources/img32x32/update_misc.png")));
		toolBar_1.add(btnUpdate);

	}
}
