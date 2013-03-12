package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class Management extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setTitle("RestaurantSystem - Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent arg0) {
		    System.exit(0);
		  }
		});
		mntmExit.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/dialog-close-2.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/view-refresh-4.png")));
		mnEdit.add(mntmRefresh);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmIngredients = new JMenuItem("Ingredients");
		mntmIngredients.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/code-block.png")));
		mnView.add(mntmIngredients);
		
		JMenuItem mntmDishes = new JMenuItem("Dishes");
		mnView.add(mntmDishes);
		
		JMenuItem mntmMenu = new JMenuItem("Menu");
		mntmMenu.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/mail-new.png")));
		mnView.add(mntmMenu);
		
		JMenuItem mntmStaff = new JMenuItem("Staff");
		mntmStaff.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/identity.png")));
		mnView.add(mntmStaff);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmRestaurantsystem = new JMenuItem("RestaurantSystem");
		mntmRestaurantsystem.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img16x16/help.png")));
		mnAbout.add(mntmRestaurantsystem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnStock = new JButton("Stock");
		
		btnStock.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/code-block.png")));
		toolBar.add(btnStock);
		
		JButton btnDishes = new JButton("Menu");
		btnDishes.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/mail-new.png")));
		toolBar.add(btnDishes);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/identity.png")));
		toolBar.add(btnStaff);
		
		JButton btnTables = new JButton("Tables");
		btnTables.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/draw-square-inverted-corners.png")));
		toolBar.add(btnTables);
		
		JButton btnReservations = new JButton("Reservations");
		btnReservations.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/view-calendar.png")));
		toolBar.add(btnReservations);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/edit-group.png")));
		toolBar.add(btnCustomers);
		
		JButton btnNewButton = new JButton("Discounts");
		btnNewButton.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/emblem-advertisement-pound.png")));
		toolBar.add(btnNewButton);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		  }
		});
		button.setIcon(new ImageIcon(Management.class.getResource("/gui/resources/img32x32/dialog-close-2.png")));
		button.setAlignmentX(1.0f);
		toolBar.add(button);
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		//i added this
		//standard start display: Ingredients Frame
		final IngredientsFrame ingredientsFrame = new IngredientsFrame(this);
		panel.add(ingredientsFrame);
		
		//action performed on ingredients button
		btnStock.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //remove whatever was there first
        panel.removeAll();
        //load the IngredientsFrame into the main panel
        panel.add(ingredientsFrame);
        
        revalidate();
        repaint();
      }
    });
		
		final DishesFrame dishesFrame = new DishesFrame(this);
		//action performed on dishes button
		btnDishes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //remove whatever was there first
        panel.removeAll();
        //load the IngredientsFrame into the main panel
        panel.add(dishesFrame);
        
        revalidate();
        repaint();
      }
    });
		
		
		
		
	}

}
