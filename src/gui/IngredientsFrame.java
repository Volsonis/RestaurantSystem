package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IngredientsFrame extends JPanel {

	/**
	 * Create the panel.
	 */
	
	Box box;
	
	public IngredientsFrame() {
		setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		this.add(separator, BorderLayout.NORTH);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.WEST);
		
		JButton btnAdd = new JButton("New");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		toolBar.add(btnAdd);
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdd.setIcon(new ImageIcon(IngredientsFrame.class.getResource("/gui/resources/img32x32/list-add-5.png")));
		
		JButton btnRefresh = new JButton("Refresh");
		toolBar.add(btnRefresh);
		btnRefresh.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRefresh.setIcon(new ImageIcon(IngredientsFrame.class.getResource("/gui/resources/img32x32/view-refresh-4.png")));
		
		JButton btnUpdate = new JButton("Update All");
		toolBar.add(btnUpdate);
		btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUpdate.setIcon(new ImageIcon(IngredientsFrame.class.getResource("/gui/resources/img32x32/update_misc.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		add(scrollPane, BorderLayout.CENTER);
		
		box = Box.createVerticalBox();
		box.setAutoscrolls(true);
		scrollPane.setViewportView(box);
		
		
		JPanel[] ip = new JPanel[20];
		for(int i=0; i<20; i++)
		{
			ip[i] = new IngredientPanel();
			box.add(ip[i]);
		}
		
	}
}
