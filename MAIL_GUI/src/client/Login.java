/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author DungVan
 */
public class Login extends JFrame {

	/**
	 * Creates new form Login
	 */
	public Login() {
		initComponents();
		this.moveFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
		this.moveFrame.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				setLocation(e.getXOnScreen() - posX, e.getYOnScreen() - posY);
			}
		});
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		register = new JLabel();
		moveFrame = new JLabel();
		bt_login = new JButton();
		tf_email = new JTextField();
		passField = new JPasswordField();
		close = new JLabel();
		minimize = new JLabel();
		background = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		setFocusTraversalPolicyProvider(true);
		setUndecorated(true);
		getContentPane().setLayout(new AbsoluteLayout());

		moveFrame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				moveFrameMousePressed(evt);
			}
		});
		getContentPane().add(moveFrame, new AbsoluteConstraints(0, 0, 240, 30));

		register.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		register.setFont(new Font("Tahoma", 0, 10));
		register.setForeground(new Color(0, 0, 204));
		register.setText("Register a @cuatardapple.com here!");
		register.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				registerMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				registerMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				registerMousePressed(evt);
			}
		});
		getContentPane().add(register, new AbsoluteConstraints(120, 480, 160, -1));

		bt_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/login.png")));
		bt_login.setBorder(null);
		bt_login.setFocusCycleRoot(true);
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bt_loginActionPerformed(evt);
			}
		});
		getContentPane().add(bt_login, new AbsoluteConstraints(100, 360, 110, 40));

		tf_email.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_email.setBackground(new Color(0, 169, 235));
		tf_email.setFont(new Font("Tekton Pro", 0, 18));
		tf_email.setForeground(new Color(255, 255, 255));
		tf_email.setBorder(null);
		getContentPane().add(tf_email, new AbsoluteConstraints(100, 160, 180, 20));

		passField.setFont(new Font("Tahoma", 0, 18));
		passField.setHorizontalAlignment(SwingConstants.RIGHT);
		passField.setBackground(new Color(0, 169, 235));
		passField.setBorder(null);
		getContentPane().add(passField, new AbsoluteConstraints(100, 270, 180, 30));

		close.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				closeMouseClicked(evt);
			}
		});
		getContentPane().add(close, new AbsoluteConstraints(270, 0, 30, 30));

		minimize.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				minimizeMouseClicked(evt);
			}
		});
		getContentPane().add(minimize, new AbsoluteConstraints(240, 0, 30, 30));

		background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/mangcau.png"))); // NOI18N
		background.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
		getContentPane().add(background, new AbsoluteConstraints(0, 0, 300, 500));

		getAccessibleContext().setAccessibleParent(this);

		pack();
		setLocationRelativeTo(null);
	}

	protected void registerMouseExited(MouseEvent evt) {
		// TODO Auto-generated method stub
		register.setText("<html>Register a @custardapple.com here!</html>");
	}

	protected void registerMouseEntered(MouseEvent evt) {
		register.setText("<html><u>Register a @custardapple.com here!</u></html>");

	}

	private void closeMouseClicked(MouseEvent evt) {
		System.exit(0);
	}

	@SuppressWarnings("deprecation")
	private void bt_loginActionPerformed(ActionEvent evt) {

		/*
		 * check validate email and pass textfield
		 */

		/*
		 * do request to server to authentication login here
		 */
		try {
			Socket socket = new Socket("localhost", 3001);
			OutputStream _out = socket.getOutputStream();
			BufferedReader _in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			_out.write("auth login\n".getBytes());
			_out.write((this.tf_email.getText() + " " + this.passField.getText().toString() + "\n").getBytes());
			if (_in.readLine().equals("true")) {
				_in.close();
				_out.close();
				socket.close();
				/*
				 * open mail client here
				 */
				this.dispose();
				return;
			} else {
				JOptionPane.showMessageDialog(this, "Email or password went wrong!\nPlease try again.");
				_in.close();
				_out.close();
				socket.close();
				return;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void registerMousePressed(java.awt.event.MouseEvent evt) {
		/*
		 * call GUI register here
		 */
		new Register().setVisible(true);
		this.dispose();
	}

	private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {
		this.setState(Frame.ICONIFIED);
	}

	private void moveFrameMousePressed(java.awt.event.MouseEvent evt) {
		posX = evt.getX();
		posY = evt.getY();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private int posX, posY;
	private JLabel register;
	private JLabel background;
	private JButton bt_login;
	private JLabel close;
	private JLabel minimize;
	private JLabel moveFrame;
	private JPasswordField passField;
	private JTextField tf_email;
	// End of variables declaration
}