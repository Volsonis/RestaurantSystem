package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;
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

public class NewOrderPanel extends JPanel
{
  private JTable table;

  /**
   * Create the panel.
   */
  public NewOrderPanel(Component parent) {
    
    table = new JTable();
    table.setModel(new DefaultTableModel(
      new Object[][] {
        {null, null},
      },
      new String[] {
        "New column", "New column"
      }
    ));
    
    JToolBar toolBar = new JToolBar();
    toolBar.setFloatable(false);
    toolBar.setOrientation(SwingConstants.VERTICAL);
    
    JToolBar toolBar_1 = new JToolBar();
    toolBar_1.setFloatable(false);
    
    JLabel lblNewLabel = new JLabel("Dish");
    
    JLabel lblNewLabel_1 = new JLabel("Price");
    
    JLabel lblNewLabel_2 = new JLabel("Total:");
    
    JLabel TotalLabel = new JLabel("0.0");
    TotalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JSeparator separator = new JSeparator();
    
    JLabel lblNewLabel_3 = new JLabel("New Order");
    
    JLabel lblNewLabel_4 = new JLabel("0");
    lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
    
    JLabel lblTable = new JLabel("Table:");
    
    JScrollPane scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.TRAILING)
        .addComponent(separator, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addComponent(toolBar_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(TotalLabel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                  .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addComponent(table, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(lblNewLabel_3)
                  .addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                  .addComponent(lblTable)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
          .addGap(9)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(toolBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel_3)
                .addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTable))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(table, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                .addComponent(scrollPane))))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
          .addContainerGap())
    );
    
    JButton btnStarters = new JButton("Starters");
    btnStarters.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-fried_egg_sunny.png")));
    toolBar.add(btnStarters);
    
    Component verticalStrut = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut);
    
    JButton btnMains = new JButton("Mains");
    btnMains.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-circle-2.png")));
    toolBar.add(btnMains);
    
    Component verticalStrut_1 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_1);
    
    JButton btnDeserts = new JButton("Desserts");
    btnDeserts.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-cupcake_iced_with_cherry.png")));
    toolBar.add(btnDeserts);
    
    Component verticalStrut_2 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_2);
    
    JButton btnSoftDrinks = new JButton("Soft Drinks");
    btnSoftDrinks.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/water_drop_1.png")));
    toolBar.add(btnSoftDrinks);
    
    Component verticalStrut_3 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_3);
    
    JButton btnDrinks = new JButton("Drinks");
    btnDrinks.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/food-beer.png")));
    toolBar.add(btnDrinks);
    
    Component verticalStrut_4 = Box.createVerticalStrut(20);
    toolBar.add(verticalStrut_4);
    
    JButton btnAll = new JButton("All");
    btnAll.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-donut.png")));
    toolBar.add(btnAll);
    
    JPanel panel = new JPanel();
    scrollPane.setViewportView(panel);
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    JButton btnRemove = new JButton("Remove");
    btnRemove.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/archive-remove.png")));
    toolBar_1.add(btnRemove);
    
    Component horizontalStrut = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut);
    
    Component horizontalStrut_1 = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut_1);
    
    Component horizontalStrut_2 = Box.createHorizontalStrut(20);
    toolBar_1.add(horizontalStrut_2);
    
    JButton btnCancel = new JButton("Clear");
    btnCancel.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/dialog-cancel-2.png")));
    toolBar_1.add(btnCancel);
    
    Component horizontalGlue = Box.createHorizontalGlue();
    toolBar_1.add(horizontalGlue);
    
    JButton btnPay = new JButton("Pay");
    btnPay.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/kwallet.png")));
    toolBar_1.add(btnPay);
    
    JButton btnDiscount = new JButton("Discount");
    btnDiscount.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/emblem-advertisement-pound.png")));
    toolBar_1.add(btnDiscount);
    
    JButton btnCustomer = new JButton("Customer");
    btnCustomer.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/identity.png")));
    toolBar_1.add(btnCustomer);
    
    JButton btnTable = new JButton("Table");
    btnTable.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/draw-square-inverted-corners.png")));
    toolBar_1.add(btnTable);
    
    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setIcon(new ImageIcon(NewOrderPanel.class.getResource("/gui/resources/img32x32/document-import.png")));
    toolBar_1.add(btnSubmit);
    setLayout(groupLayout);
  }
}
