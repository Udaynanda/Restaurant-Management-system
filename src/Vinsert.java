import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Vinsert {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vinsert window = new Vinsert();
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
	public Vinsert() {
		initialize();
		xx();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void xx()
	{
		RawUpdateinsert rw = new RawUpdateinsert();
		String ss = rw.xx();
		textField_3.setText(ss);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\1234.jpg");
		JLabel lblVendorsrecord = new JLabel("Vendors-Record");
		lblVendorsrecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendorsrecord.setForeground(new Color(0, 51, 51));
		lblVendorsrecord.setFont(new Font("Sitka Small", Font.BOLD, 27));
		lblVendorsrecord.setBackground(Color.WHITE);
		lblVendorsrecord.setBounds(41, 66, 358, 33);
		frame.getContentPane().add(lblVendorsrecord);
		
		JLabel lblNewLabel = new JLabel("Vendor Name : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 181, 137, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Address : ");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(51, 235, 137, 25);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblUnitPrice = new JLabel("Contact : ");
		lblUnitPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnitPrice.setBounds(51, 289, 137, 25);
		frame.getContentPane().add(lblUnitPrice);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(200, 177, 185, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(200, 232, 185, 33);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(200, 286, 185, 33);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("INSERT RECORD");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect cn = new Connect();
				PreparedStatement pt;
				try {
					pt = cn.main("arg").prepareStatement("insert into vendors (vendor_id, vendor_name, address, contact) values (?, ?, ?, ?)");
					pt.setInt(1, Integer.parseInt(textField_3.getText()));
					pt.setString(2, textField.getText());
					pt.setString(3, textField_1.getText());
					pt.setString(4, textField_2.getText());
					pt.execute();
					JOptionPane.showMessageDialog(frame, "successful");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(143, 365, 137, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblVendorId = new JLabel("Vendor ID : ");
		lblVendorId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVendorId.setBounds(51, 137, 137, 25);
		frame.getContentPane().add(lblVendorId);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(200, 133, 78, 33);
		frame.getContentPane().add(textField_3);
		
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-132,1900,1000);
		frame.getContentPane().add(background);
		
	}
}
