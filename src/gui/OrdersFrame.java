package gui;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JScrollPane;

public class OrdersFrame extends JPanel
{

  /**
   * Create the panel.
   */
  public OrdersFrame(Component parent) {
    setLayout(new BorderLayout(0, 0));
    final Component frameParent = parent;
    JSeparator separator = new JSeparator();
    this.add(separator, BorderLayout.NORTH);
    
    JToolBar toolBar = new JToolBar();
    toolBar.setOrientation(SwingConstants.VERTICAL);
    toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
    toolBar.setFloatable(false);
    add(toolBar, BorderLayout.WEST);
    
    JScrollPane scrollPane = new JScrollPane();
    add(scrollPane, BorderLayout.CENTER);

    
    
    Box box = Box.createVerticalBox();
    box.setAutoscrolls(true);
    scrollPane.setViewportView(box);
  }

}
