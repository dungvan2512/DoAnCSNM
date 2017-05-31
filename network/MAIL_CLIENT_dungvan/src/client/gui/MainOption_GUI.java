/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import client.connetion.ConnectionServerOption;

/**
 *
 * @author DungVan
 */
public class MainOption_GUI extends javax.swing.JFrame {

	/**
	 * Creates new form MainOption_GUI
	 */
	public MainOption_GUI() {
		initComponents();
		clientOption.add(banana);
		clientOption.add(custardapple);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		setContentPane(new JLabel(new javax.swing.ImageIcon(getClass().getResource("/client/image/background.jpg"))));

		clientOption = new javax.swing.ButtonGroup();
		submit = new javax.swing.JButton();
		banana = new javax.swing.JRadioButton();
		custardapple = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setType(java.awt.Window.Type.POPUP);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		submit.setText("Done");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				submitMouseClicked();
			}
		});
		getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 99, -1, -1));

		banana.setText("bananatieu.ddns.net");
		getContentPane().add(banana, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 20, 170, -1));

		custardapple.setText("custardapple.ddns.net");
		getContentPane().add(custardapple, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 50, 170, -1));

		setSize(new java.awt.Dimension(228, 165));
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void submitMouseClicked() {
		// TODO add your handling code here:
		if (banana.isSelected())
			Client_GUI.setCLIENT_TYPE("bananatieu.ddns.net");
		else if (custardapple.isSelected())
			Client_GUI.setCLIENT_TYPE("custardapple.ddns.net");
		else
			Client_GUI.setCLIENT_TYPE("localhost");
		ConnectionServerOption.setSERVER_NAME(Client_GUI.getCLIENT_TYPE());

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login_GUI().setVisible(true);
			}
		});
		this.dispose();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainOption_GUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup clientOption;
	private javax.swing.JRadioButton custardapple;
	private javax.swing.JRadioButton banana;
	private javax.swing.JButton submit;
	// End of variables declaration
}
