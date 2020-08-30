import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Feedback {

	public JFrame frame;
	private JTextField textField;
	String ss = "";
	int chef_rating =0;
	int amb_rating = 0;
	int service_rating = 0;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback window = new Feedback();
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
	public Feedback() {
		initialize();  
		xx();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void xx()
	{
		Invoice i = new Invoice();
		ss = i.qq();
		textField_1.setText(ss);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450,600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(25, 300, 384, 47);
		frame.getContentPane().add(textField);
		
		JLabel label = new JLabel("Suggestion Box : ");
		label.setBounds(25, 274, 116, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Ambiance Rating :");
		label_1.setBounds(25, 237, 116, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Service Rating :");
		label_2.setBounds(25, 205, 91, 16);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Chef Rating :");
		label_3.setBounds(25, 172, 80, 16);
		frame.getContentPane().add(label_3);
		
		JLabel lblFeedback = new JLabel("FEEDBACK ");
		lblFeedback.setFont(new Font("Sitka Text", Font.PLAIN, 24));
		lblFeedback.setBounds(145, 101, 168, 16);
		frame.getContentPane().add(lblFeedback);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef_rating = 1;
			}
		});
		radioButton.setBounds(149, 168, 35, 25);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef_rating = 2;
			}
		});
		radioButton_1.setBounds(196, 168, 35, 25);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef_rating = 3;
			}
		});
		radioButton_2.setBounds(248, 168, 35, 25);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef_rating = 4;
			}
		});
		radioButton_3.setBounds(298, 168, 35, 25);
		frame.getContentPane().add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chef_rating = 5;
			}
		});
		radioButton_4.setBounds(348, 168, 35, 25);
		frame.getContentPane().add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("5");
		radioButton_5.setBounds(348, 202, 35, 25);
		frame.getContentPane().add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("4");
		radioButton_6.setBounds(298, 202, 35, 25);
		frame.getContentPane().add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("3");
		radioButton_7.setBounds(248, 202, 35, 25);
		frame.getContentPane().add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("2");
		radioButton_8.setBounds(196, 202, 35, 25);
		frame.getContentPane().add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("1");
		radioButton_9.setBounds(149, 202, 35, 25);
		frame.getContentPane().add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("1");
		radioButton_10.setBounds(149, 232, 35, 25);
		frame.getContentPane().add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("2");
		radioButton_11.setBounds(196, 232, 35, 25);
		frame.getContentPane().add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("3");
		radioButton_12.setBounds(248, 232, 35, 25);
		frame.getContentPane().add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("4");
		radioButton_13.setBounds(298, 232, 35, 25);
		frame.getContentPane().add(radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("5");
		radioButton_14.setBounds(348, 232, 35, 25);
		frame.getContentPane().add(radioButton_14);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			Connect ccc = new Connect();
			PreparedStatement pt;
			public void actionPerformed(ActionEvent e) {
				//pt = cn.main("arg").preparestatement("insert into")
			}
		});
		btnNewButton.setBounds(169, 420, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(68, 25, 43, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(ss);
		
		JLabel lblBill = new JLabel("Bill_ID : ");
		lblBill.setBounds(12, 28, 56, 16);
		frame.getContentPane().add(lblBill);
	}
}
