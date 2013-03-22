package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

import db.DBInterface;

import main.Dish;
import main.DishFactory;
import main.InputVerifier;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTextField;

public class NewOrderPanel extends JPanel
{
  private JTable table;
  final DefaultTableModel model;
  final JLabel totalLabel;
  final main.Order order;
  final ArrayList<Dish> dishesOrdered;
  private ArrayList<Dish> allDishes;
  private JTextField tableLabel;
  private JPanel mainButtonPanel;

  /**
   * Create the panel.
   * @throws SQLException 
   */
  public NewOrderPanel(final Component parent) throws SQLException {
    
    final Component parentFrame = parent;
    //new order
    order = new main.Order();
    dishesOrdered = new ArrayList<Dish>();
    
    model = new DefaultTableModel();
    //table.setModel(new DefaultTableModel(new Object[][] {null, null},new String[] {"New column", "New column"}));
    //add columns
    model.addColumn("Dish");
    model.addColumn("Price");
    table = new JTable(model);
    //this is how to add rows
    //model.addRow(new String[]{"testDish", "testPrice"});
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    toolBar.setOrientation(SwingConstants.VERTICAL);
    
    JToolBar toolBar_1 = new JToolBar();
    toolBar_1.setFloatable(false);
    
    JLabel lblNewLabel = new JLabel("Dish");
    
    JLabel lblNewLabel_1 = new JLabel("Price");
    
    JLabel lblNewLabel_2 = new JLabel("Total:");
    
    totalLabel = new JLabel("0.0 £");
    totalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JSeparator separator = new JSeparator();
    
    JLabel lblNewLabel_3 = new JLabel("New Order");
    
    JLabel lblTable = new JLabel("Table:");
    
    JScrollPane scrollPane = new JScrollPane();
    
    tableLabel = new JTextField();
    tableLabel.setEditable(false);
    tableLabel.setColumns(10);
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(separator, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
            .addComponent(table, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblTable)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(tableLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblNewLabel_3))
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
          .addGap(9)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTable)
                .addComponent(tableLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_3))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(table, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                .addComponent(scrollPane)))
            .addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
          .addContainerGap())
    );
    
    JButton btnStarters = new JButton("Starters");
    btnStarters.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createButtons("Starters");
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnStarters.setPreferredSize(new Dimension(110, 40));
    btnStarters.setMinimumSize(new Dimension(110, 40));
    btnStarters.setMaximumSize(new Dimension(110, 40));
    btnStarters.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-fried_egg_sunny.png")));
    toolBar.add(btnStarters);
    
    Component verticalStrut = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut);
    
    JButton btnMains = new JButton("Mains");
    btnMains.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createButtons("Mains");
        } catch (SQLException e1)
        {

          e1.printStackTrace();
        }
      }
    });
    btnMains.setPreferredSize(new Dimension(110, 40));
    btnMains.setMinimumSize(new Dimension(110, 40));
    btnMains.setMaximumSize(new Dimension(110, 40));
    btnMains.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-circle-2.png")));
    toolBar.add(btnMains);
    
    Component verticalStrut_5 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_5);
    
    JButton btnSides = new JButton("Sides");
    btnSides.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try
        {
          createButtons("Sides");
        } catch (SQLException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    btnSides.setMinimumSize(new Dimension(110, 40));
    btnSides.setMaximumSize(new Dimension(110, 40));
    btnSides.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-halfcircle1.png")));
    btnSides.setPreferredSize(new Dimension(110, 40));
    toolBar.add(btnSides);
    
    Component verticalStrut_1 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_1);
    
    JButton btnDeserts = new JButton("Desserts");
    btnDeserts.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createButtons("Desserts");
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnDeserts.setPreferredSize(new Dimension(110, 40));
    btnDeserts.setMinimumSize(new Dimension(110, 40));
    btnDeserts.setMaximumSize(new Dimension(110, 40));
    btnDeserts.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-cupcake_iced_with_cherry.png")));
    toolBar.add(btnDeserts);
    
    Component verticalStrut_2 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_2);
    
    JButton btnSoftDrinks = new JButton("S. Drinks");
    btnSoftDrinks.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createButtons("Non-Alcoholic");
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnSoftDrinks.setPreferredSize(new Dimension(110, 40));
    btnSoftDrinks.setMinimumSize(new Dimension(110, 40));
    btnSoftDrinks.setMaximumSize(new Dimension(110, 40));
    btnSoftDrinks.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/water_drop_1.png")));
    toolBar.add(btnSoftDrinks);
    
    Component verticalStrut_3 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_3);
    
    JButton btnDrinks = new JButton("Drinks");
    btnDrinks.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createButtons("Alcoholic");
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnDrinks.setPreferredSize(new Dimension(110, 40));
    btnDrinks.setMinimumSize(new Dimension(110, 40));
    btnDrinks.setMaximumSize(new Dimension(110, 40));
    btnDrinks.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-beer.png")));
    toolBar.add(btnDrinks);
    
    Component verticalStrut_4 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_4);
    
    JButton btnAll = new JButton("All");
    btnAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
          createAllButtons();
        } catch (SQLException e1)
        {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnAll.setPreferredSize(new Dimension(110, 40));
    btnAll.setMinimumSize(new Dimension(110, 40));
    btnAll.setMaximumSize(new Dimension(110, 40));
    btnAll.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-donut.png")));
    toolBar.add(btnAll);
    
    mainButtonPanel = new JPanel();
    mainButtonPanel.setPreferredSize(new Dimension(450, 400));
    scrollPane.setViewportView(mainButtonPanel);
    mainButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    JButton btnRemove = new JButton("Remove");
    btnRemove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //if there are still dishes in the list
        if(model.getRowCount() > 0)
        {
          //remove last item added
          //update price
          order.setPrice(rtd(order.getPrice() - dishesOrdered.get(dishesOrdered.size()-1).getPrice()));
          totalLabel.setText(String.valueOf(order.getPrice()) + " £");
          //remove from dish list
          dishesOrdered.remove(dishesOrdered.size()-1);
          //remove from table
          model.removeRow(model.getRowCount()-1);
        }
      }
    });
    btnRemove.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/archive-remove.png")));
    toolBar_1.add(btnRemove);
    
    Component horizontalStrut = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut);
    
    Component horizontalStrut_1 = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut_1);
    
    Component horizontalStrut_2 = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut_2);
    
    JButton btnCancel = new JButton("Clear");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        //reset the order
        try
        {
          reset();
        } catch (SQLException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    btnCancel.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
    toolBar_1.add(btnCancel);
    
    Component horizontalGlue = Box.createHorizontalGlue();
    toolBar_1.add(horizontalGlue);
    
    JButton btnPay = new JButton("Pay");
    btnPay.setEnabled(false);
    btnPay.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/kwallet.png")));
    toolBar_1.add(btnPay);
    
    JButton btnDiscount = new JButton("Discount");
    btnDiscount.setEnabled(false);
    btnDiscount.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/emblem-advertisement-pound.png")));
    toolBar_1.add(btnDiscount);
    
    JButton btnCustomer = new JButton("Customer");
    btnCustomer.setEnabled(false);
    btnCustomer.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/identity.png")));
    toolBar_1.add(btnCustomer);
    
    JButton btnNote = new JButton("Note");
    btnNote.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JDialog notesAdder = new NotesAdder(parentFrame, order);
        notesAdder.setVisible(true);
      }
    });
    btnNote.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/view-pim-notes.png")));
    toolBar_1.add(btnNote);
    
    JButton btnTable = new JButton("Table");
    btnTable.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //open tableselecter (touchscreen optimised)
        JDialog ts = new TableSelecter(parentFrame, order);
        ts.setVisible(true);
        //update table label
        tableLabel.setText(String.valueOf(order.getTablenumber()));
      }
    });
    btnTable.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-square-inverted-corners.png")));
    toolBar_1.add(btnTable);
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        try
        {
          //add the dish ids to the order
          int[] dish_ids = new int[dishesOrdered.size()];
          for(int i=0; i<dish_ids.length; i++)
            dish_ids[i] = dishesOrdered.get(i).getID();
          order.setDish_id(dish_ids);
          //verify order
          InputVerifier.verifyOrder(order);
          //submit order
          DBInterface.addOrder(order);
          
          //then reset the new order window
          reset();
              
        } catch (SQLException e)
        {
          Error err = new Error(null,"Database Error", e.getMessage());
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
    btnSubmit.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/document-import.png")));
    toolBar_1.add(btnSubmit);
    setLayout(groupLayout);
    
    allDishes = new ArrayList<Dish>();
    DishFactory.refreshDishes(allDishes);
    
    createAllButtons();
    
  }
  
  private void createAllButtons() throws SQLException
  {
    mainButtonPanel.removeAll();
    JButton[] allButtons = new JButton[allDishes.size()];
    for(int i=0 ; i<allDishes.size() ; i++)
    {
      allButtons[i] = createDishButton(allDishes.get(i));
      mainButtonPanel.add(allButtons[i]);
      //TODO check if out of stock and disable button
    }
    
    mainButtonPanel.revalidate();
    mainButtonPanel.repaint();
  }
  
  private void createButtons(String type) throws SQLException
  {
    mainButtonPanel.removeAll();
    JButton[] allButtons = new JButton[allDishes.size()];
    for(int i=0 ; i<allDishes.size() ; i++)
    {
      allButtons[i] = createDishButton(allDishes.get(i));
      if(allDishes.get(i).getType().equals(type))
        mainButtonPanel.add(allButtons[i]);
    }
    
    mainButtonPanel.revalidate();
    mainButtonPanel.repaint();
  }
  
  private JButton createDishButton(final Dish dish) throws SQLException
  {
    JButton newButton = new JButton(dish.getName());
    newButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //add to order
        dishesOrdered.add(dish);
        //update table
        model.addRow(new Object[]{dish.getName(), dish.getPrice()});
        //update price
        order.setPrice(rtd(order.getPrice() + dish.getPrice()));
        totalLabel.setText(String.valueOf(rtd(order.getPrice())) + " £");
        System.out.println(dishesOrdered.size());
      }
    });
    
    //TODO check if out of stock and disable button
    if(!InputVerifier.checkStock(dish))
      newButton.setEnabled(false);
    
    return newButton;
  }
  
  public void reset() throws SQLException
  {
    for(int i=model.getRowCount()-1 ; i>=0 ; i--)
      model.removeRow(i);
    
    totalLabel.setText("0.0 £");
    order.setPrice(0.0);
    order.setNotes("");
    order.setDish_id(null);
    order.setTablenumber(0);
    order.setCustomer_id(0);
    order.setDishes(null);
    dishesOrdered.removeAll(dishesOrdered);
    tableLabel.setText("");
    DishFactory.refreshDishes(allDishes);
    createAllButtons();
    revalidate();
    repaint();
  }
  
  //round to 2 decimals
  double rtd(double d) 
  {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
      return Double.valueOf(twoDForm.format(d));
  }
}
