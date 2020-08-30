import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RawUpdateinsert {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	String sss = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RawUpdateinsert window = new RawUpdateinsert();
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
	public RawUpdateinsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public String xx()
	{
		return sss;
	}
	private void initialize() {
		frame = new JFrame("RESTAURANT MANAGEMENT SYSTEM");
		frame.setBounds(100, 100, 1024, 920);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\1234.jpg");
		JLabel lblNewLabel = new JLabel("Supplies");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 27));
		lblNewLabel.setBounds(351, 111, 358, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerId = new JLabel("Vendor ID : ");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomerId.setBounds(144, 201, 158, 33);
		frame.getContentPane().add(lblCustomerId);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField.setBounds(299, 202, 116, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect cn = new Connect();
				PreparedStatement pt;
				try {
					sss = textField.getText();
					pt = cn.main("arg").prepareStatement("select vendor_name, address, contact from vendors where vendor_id = ? ");
					pt.setString(1, textField.getText());
					ResultSet rs = pt.executeQuery();
					if(!rs.isBeforeFirst())JOptionPane.showMessageDialog(frame,"Not Found!");
					while(rs.next()) {
						textField_1.setText(rs.getString("vendor_name"));
						textField_2.setText(rs.getString("address"));
						textField_3.setText(rs.getString("contact"));
					}
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(437, 208, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblVendorName = new JLabel("Vendor Name : ");
		lblVendorName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVendorName.setBounds(144, 247, 158, 33);
		frame.getContentPane().add(lblVendorName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(299, 247, 235, 33);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(144, 293, 158, 33);
		frame.getContentPane().add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_2.setColumns(10);
		textField_2.setBounds(299, 293, 235, 33);
		frame.getContentPane().add(textField_2);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo.setBounds(144, 339, 158, 33);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_3.setColumns(10);
		textField_3.setBounds(299, 339, 235, 33);
		frame.getContentPane().add(textField_3);
		
		JLabel lblMaterial = new JLabel("Material Name : ");
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaterial.setBounds(144, 459, 158, 33);
		frame.getContentPane().add(lblMaterial);
		
		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantity.setBounds(144, 519, 158, 33);
		frame.getContentPane().add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_4.setColumns(10);
		textField_4.setBounds(299, 459, 235, 33);
		frame.getContentPane().add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		textField_6.setColumns(10);
		textField_6.setBounds(299, 520, 97, 33);
		frame.getContentPane().add(textField_6);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect cn = new Connect();
				PreparedStatement pt;
				try {
					sss = textField.getText();
					pt = cn.main("arg").prepareStatement("select qty_avail from raw_material where mat_name = ?");
					pt.setString(1, textField_4.getText());
					ResultSet rs = pt.executeQuery();
					if(!rs.isBeforeFirst()) {
						JOptionPane.showMessageDialog(frame, "No Records");
						Rminsert rm = new Rminsert();
						rm.frame.setVisible(true);
					}
					
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		JButton btnUpdate = new JButton("Insert");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect cn = new Connect();
				PreparedStatement pt;
				try {
					pt = cn.main("arg").prepareStatement("insert into supplies(vendor_id, mat_name, v_date, quantity) values (?, ?, now(), ?)");
					pt.setInt(1, Integer.parseInt(textField.getText()));
					pt.setString(2, textField_4.getText());
					pt.setInt(3, Integer.parseInt(textField_6.getText()));
					pt.execute();
					JOptionPane.showMessageDialog(frame, "successful!");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(400, 584, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(546, 466, 97, 25);
		frame.getContentPane().add(button);
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-132,1900,1000);
		frame.getContentPane().add(background);
		

		
	}
}
