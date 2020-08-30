import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class application {

	public JFrame frame;
	private JTextField username;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public application() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame("Restaurant Management System");
		frame.setBackground(Color.BLUE);
		frame.setBounds(600,250, 453, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRestaurantManagementSystem = new JLabel("Restaurant Management System");
		lblRestaurantManagementSystem.setBackground(Color.WHITE);
		lblRestaurantManagementSystem.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblRestaurantManagementSystem.setForeground(Color.WHITE);
		lblRestaurantManagementSystem.setBounds(38, 81, 397, 60);
		frame.getContentPane().add(lblRestaurantManagementSystem);
		
		JLabel lblNewLabel = new JLabel("Username* : ");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Century Gothic", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize()));
		lblNewLabel.setBounds(76, 184, 107, 16);
		frame.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setToolTipText("");
		username.setBackground(new Color(245, 245, 245));
		username.setBounds(76, 213, 196, 22);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password* :");
		lblPassword_1.setForeground(SystemColor.menu);
		lblPassword_1.setBackground(Color.BLACK);
		lblPassword_1.setBounds(76, 268, 107, 16);
		frame.getContentPane().add(lblPassword_1);
		
		pass = new JPasswordField();
		pass.setBackground(new Color(245, 245, 245));
		pass.setBounds(76, 300, 196, 22);
		frame.getContentPane().add(pass);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u = username.getText();
				String p = pass.getText();
				if(u.equals("user") && p.equals("password")) {
					JOptionPane.showMessageDialog(frame, "login successful");
					frame.dispose();
					Index c1 = new Index();
					c1.frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frame, "invalid credentials");
				}
				
			}
		});
		
		btnLogin.setBounds(76, 380, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblLoginPage = new JLabel("CARE: Username and password are case sensitive.");
		lblLoginPage.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 13));
		lblLoginPage.setForeground(UIManager.getColor("Button.background"));
		lblLoginPage.setBounds(76, 335, 347, 16);
		frame.getContentPane().add(lblLoginPage);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\12.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-132,446,725);
		frame.getContentPane().add(background);
		
		
	}
}
