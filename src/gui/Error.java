package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class Error extends JDialog {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public Error(Component parent, String errortype, String message)
	{
	  super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Error.class.getResource("/gui/resources/img16x16/dialog-close-2.png")));
		setTitle(errortype);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(100, 100, 450, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addGap(168)
		      .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
		      .addContainerGap(164, Short.MAX_VALUE))
		    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
		  gl_contentPane.createParallelGroup(Alignment.LEADING)
		    .addGroup(gl_contentPane.createSequentialGroup()
		      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
		      .addPreferredGap(ComponentPlacement.RELATED)
		      .addComponent(btnOk, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(errortype + ": " + message);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
