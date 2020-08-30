import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Insert {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
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
	public Insert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("RESTAURANT MANAGEMENT SYSTEM");
		frame.setBounds(100, 100, 1024, 920);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 27));
		lblNewLabel.setBounds(351, 111, 358, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Customer ID : ");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerId.setBounds(144, 201, 158, 33);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel lblCustomerName = new JLabel("Customer Name : ");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerName.setBounds(144, 266, 182, 33);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(144, 329, 182, 33);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number : ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(144, 387, 182, 33);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth(YYYY-MM-DD) : ");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(144, 455, 242, 33);
		frame.getContentPane().add(lblDateOfBirth);
		
		JLabel lblCreditsEarned = new JLabel("Credits Earned : ");
		lblCreditsEarned.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreditsEarned.setBounds(144, 515, 182, 33);
		frame.getContentPane().add(lblCreditsEarned);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField.setBounds(398, 204, 116, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_1.setBounds(398, 269, 322, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Myriad Pro", Font.PLAIN, 19));
		textField_2.setColumns(10);
		textField_2.setBounds(398, 329, 322, 33);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_3.setColumns(10);
		textField_3.setBounds(398, 388, 182, 33);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_4.setColumns(10);
		textField_4.setBounds(398, 455, 182, 33);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_5.setColumns(10);	
		textField_5.setBounds(398, 516, 116, 33);
		frame.getContentPane().add(textField_5);
		
		JButton btnInsertRecord = new JButton("INSERT RECORD");
		btnInsertRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pt;
				Connect cn = new Connect();
				try {
					pt = cn.main("arg").prepareStatement("insert into customer(cust_id,cust_name, address, ph_no, dob, credits) values(?,?,?,?,?,?)");
					pt.setInt(1, Integer.parseInt(textField.getText()));
					pt.setString(2, textField_1.getText());
					pt.setString(3, textField_2.getText());
					pt.setString(4, textField_3.getText());
					pt.setString(5, textField_4.getText());
					pt.setInt(6, Integer.parseInt(textField_5.getText()));
					pt.execute();
					JOptionPane.showMessageDialog(frame, "Successful");
					frame.setVisible(false);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInsertRecord.setBounds(354, 633, 160, 25);
		frame.getContentPane().add(btnInsertRecord);
		
		JButton btnNewButton = new JButton("Access Records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ctable c = new Ctable();
				c.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(825, 835, 169, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
