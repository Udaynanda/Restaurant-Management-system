import java.awt.EventQueue;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class Invoice {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JComboBox comboBox = new JComboBox();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;
	public JTextField textField_7;
	private JTextField Quantity;
	private JTextField textField_8;
	private JTextField textField_9;
	
	int count = 0;
	String sum = "00:00:00";
	
	String xc = "";
	int chef_rating ;
	int service_rating;
	int amb_rating;
	private JTextField textField_11;
	private JTextField textField_12;
	boolean qwe = false;
	boolean qwe1 = false;
	private JTextField textField_10;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice window = new Invoice();
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
	public Invoice() {
		initialize();
		xx();
		//d();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public String qq()
	{
		return xc;
	}
	
	

	public long calc(String s1, String s2)
	{
		int cc = 0;
		String[] first = s1.split(":");
		String[] second = s2.split(":");
		long h1 = Integer.parseInt(first[0]);
		long m1 = Integer.parseInt(first[1]);
		long ss1 = Integer.parseInt(first[2]);
		long h2 = Integer.parseInt(second[0]);
		long m2 = Integer.parseInt(second[1]);
		long ss2 = Integer.parseInt(second[2]);
		long fh = h1+h2;
		long fm = m1+m2;
		long fs = ss1+ss2;
		if(fs>59) {
			fs = fs-60;
			fm++;
			if(fm>59) {
				fm = fm-60;
				fh++;
			}
		}
		else {
			if(fm>59) {
				fm = fm-60;
				fh++;
				
			}
		}
		
		return (fh*60 + fm)*60 + fs;
	}
	public void  d()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalDateTime tm = LocalDateTime.now();
		String s = String.valueOf(dtf.format(tm));
		long x = calc(s,"0:0:0");
		System.out.println(x);
	}
	
	
	private void xx() {
		
		
		Connect connection = new Connect();
		String query = "select dish_name from dish";
		Statement st;
		try {
			st = connection.main("arg").createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String ss = rs.getString("dish_name");
				comboBox.addItem(ss);
		    }
			query = "select max(bill_id) from bill";
			st = connection.main("args").createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				int xx = Integer.parseInt(rs.getString("max(bill_id)")) + 1;
				textField_7.setText(Integer.toString(xx));
				 xc = Integer.toString(xx);
			}
			Calendar cc = Calendar.getInstance();
			Date date = new Date(cc.getTime().getTime());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat d1 = new SimpleDateFormat("hh:mm:ss");
			textField_9.setText(dateFormat.format(date));
			textField_15.setText(d1.format(date));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	private void initialize() {
		
		frame = new JFrame("RMS : INVOICE");
		frame.setBounds(100, 100, 1540, 940);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerId = new JLabel("customer id:");
		lblCustomerId.setBounds(398, 135, 80, 16);
		frame.getContentPane().add(lblCustomerId);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\1234.jpg");
		
		
		textField = new JTextField();
		textField.setBounds(476, 132, 51, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setBounds(398, 164, 80, 16);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(476, 161, 155, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(398, 193, 80, 16);
		frame.getContentPane().add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(476, 190, 155, 22);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect connection = new Connect();
				PreparedStatement pt;
				try {
					pt = connection.main("arg").prepareStatement("select cust_name, address, ph_no, credits from customer where cust_id = ?;");
					pt.setString(1,textField.getText());
					ResultSet rs = pt.executeQuery();
					while(rs.next()) {
						String ph = rs.getString("ph_no");
						String ad = rs.getString("address");
						
						textField_11.setText(rs.getString("cust_name"));
						textField_12.setText(Integer.toString(rs.getInt("credits")));
						textField_1.setText(ph);
						textField_2.setText(ad);
				    }
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(539, 131, 92, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Dish Name :");
		lblNewLabel.setBounds(112, 138, 70, 16);
		frame.getContentPane().add(lblNewLabel);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect cn = new Connect();
				PreparedStatement pt;
				try {
					pt = cn.main("arg").prepareStatement("select c_time, price, cooking_style from dish where dish_name = ?");
					pt.setString(1,(String)comboBox.getSelectedItem());
					ResultSet rs = pt.executeQuery();
					while(rs.next()) {
						String time = rs.getString("c_time");
						String ccc = rs.getString("cooking_style");
						textField_3.setText(time);
						textField_4.setText(rs.getString("price"));
						textField_5.setText(ccc);
				    }
									
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		comboBox.setBounds(203, 135, 155, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTime = new JLabel("Time : ");
		lblTime.setBounds(112, 167, 70, 16);
		frame.getContentPane().add(lblTime);
		
		textField_3 = new JTextField();
		textField_3.setBounds(203, 164, 116, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(112, 196, 70, 16);
		frame.getContentPane().add(lblPrice);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(203, 193, 116, 22);
		frame.getContentPane().add(textField_4);
		
		JLabel lblCookingStyle = new JLabel("Cooking Style :");
		lblCookingStyle.setBounds(112, 225, 92, 16);
		frame.getContentPane().add(lblCookingStyle);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(203, 222, 116, 22);
		frame.getContentPane().add(textField_5);
		
		JLabel lblAvailability = new JLabel("Availability : ");
		lblAvailability.setBounds(112, 291, 92, 16);
		frame.getContentPane().add(lblAvailability);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_6.setBackground(UIManager.getColor("Button.background"));
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.RED);
		textField_6.setColumns(10);
		textField_6.setBounds(203, 288, 51, 22);
		frame.getContentPane().add(textField_6);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(112, 254, 92, 16);
		frame.getContentPane().add(lblQuantity);
		
		Quantity = new JTextField();
		Quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sss  = Quantity.getText();
				int i = Integer.parseInt(sss);
				PreparedStatement pt;
				Connect cn = new Connect();
				ResultSet rs;
				try {
					pt = cn.main("arg").prepareStatement("select count(dish_name) as c from used where dish_name = ?;");
					pt.setString(1, (String)comboBox.getSelectedItem());
					rs = pt.executeQuery();
					String s1 = "";
					while(rs.next()) {
						s1 = rs.getString("c");
					}
					String s2 = "";
					pt = cn.main("arg").prepareStatement("select count(dish_name) as c from used u inner join raw_material r on u.mat_name = r.mat_name where u.dish_name = ? and ?*u.qty_required <= r.qty_avail");
					pt.setString(1,(String)comboBox.getSelectedItem());
					pt.setInt(2, i);
					rs = pt.executeQuery();
					while(rs.next()) {
						s2 = rs.getString("c");
					}
					if(s1.equals(s2)) {
						textField_6.setText("YES");
					}
					else {
						textField_6.setText("NO");
					}
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		});
		Quantity.setColumns(10);
		Quantity.setBounds(203, 251, 116, 22);
		frame.getContentPane().add(Quantity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 348, 1328, 322);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table_1 = new JTable(model);
		
		scrollPane.setViewportView(table_1);

		//model.addColumn("sl no");
		model.addColumn("Dish Name");
		model.addColumn("Price(Each)");
		model.addColumn("Qty");
		//model.addColumn("Tax");
		//model.addColumn("discount");
		model.addColumn("Total");
		
		JLabel lblBillId = new JLabel("Bill ID : ");
		lblBillId.setBounds(398, 262, 56, 16);
		frame.getContentPane().add(lblBillId);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(new Color(51, 102, 0));
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(476, 251, 51, 22);
		frame.getContentPane().add(textField_7);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 model.addRow(new Object[]{(String)comboBox.getSelectedItem(), textField_4.getText(),Quantity.getText(),Float.parseFloat(Quantity.getText())*Integer.parseInt(textField_4.getText())}); // add row			
				 String xx = (textField_8.getText());
				 int xx1 = Integer.parseInt(xx) + Integer.parseInt(Quantity.getText())*Integer.parseInt(textField_4.getText()); // new price
				 textField_8.setText(String.valueOf(xx1)); // price update
				 double xx2  =0;
				 count++;
				 
				 long result = calc(sum,textField_3.getText());
				 result += (Integer.parseInt(Quantity.getText())-1)*4;
				 result -= (count-1)*5;
				 long hh = result/3600;
				 long mm = (result/60)%60;
				 long ss = (result)%60;
				 sum = String.valueOf(hh)+":"+ String.valueOf(mm)+":"+ String.valueOf(ss);
				 System.out.println(sum);
				 if(xx1 > 3000) {
					 textField_13.setText("10");
					 xx2 = xx1 + xx1*0.1;
					 textField_10.setText("5");
					 xx2 = xx2*0.95;
					 textField_14.setText(String.valueOf(xx2));
					 
				 }
				 else {
					 textField_13.setText("6");
					 xx2 = xx1+xx1*0.06;
					 if(xx2 < 2000) {
						 xx2 = xx2*0.97;
						 textField_10.setText("3");
						 textField_14.setText(String.valueOf(xx2));
					 }
					 else {
						 xx2 = xx2*0.95;
						 textField_10.setText("5");
						 textField_14.setText(String.valueOf(xx2));
					 }
					 
				 }
				 
				 Connect ccc = new Connect();
				 PreparedStatement pt;
				 try {
					pt = ccc.main("arg").prepareStatement("update raw_material r inner join used on r.mat_name = used.mat_name set  r.qty_avail = r.qty_avail - ?*used.qty_required where used.dish_name = ?");
					pt.setInt(1,Integer.parseInt(Quantity.getText()));
					pt.setString(2,(String)comboBox.getSelectedItem());
					pt.execute();
					pt = ccc.main("arg").prepareStatement("insert into orders(bill_id, dish_name, quantity) values(?,?,?)");
					pt.setInt(1, Integer.parseInt(textField_7.getText()));
					pt.setString(2,(String)comboBox.getSelectedItem());
					pt.setInt(3, Integer.parseInt(Quantity.getText()));
					pt.execute();
				 } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(261, 287, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblTotalPrice = new JLabel("Sum(Rs.) : ");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalPrice.setBounds(1168, 700, 148, 22);
		frame.getContentPane().add(lblTotalPrice);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.RED);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_8.setColumns(10);
		textField_8.setBackground(SystemColor.menu);
		textField_8.setBounds(1308, 694, 117, 35);
		textField_8.setText("0");
		frame.getContentPane().add(textField_8);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(398, 288, 56, 16);
		frame.getContentPane().add(lblDate);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBounds(476, 288, 92, 22);
		frame.getContentPane().add(textField_9);
		
		JLabel lblInvoice = new JLabel("PLACE ORDER");
		lblInvoice.setForeground(Color.BLACK);
		lblInvoice.setFont(new Font("Segoe Print", Font.BOLD, 26));
		lblInvoice.setBackground(Color.WHITE);
		lblInvoice.setBounds(649, 13, 226, 60);
		frame.getContentPane().add(lblInvoice);
		

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setBounds(437, 697, 227, 40);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(649, 135, 108, 16);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblCredits = new JLabel("Credits : ");
		lblCredits.setBounds(649, 164, 108, 16);
		frame.getContentPane().add(lblCredits);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(755, 132, 155, 22);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(757, 161, 51, 22);
		frame.getContentPane().add(textField_12);
		
		JButton btnNewButton_1 = new JButton("Place Order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connect ccc = new Connect();
				 PreparedStatement pt;
				 try {
					pt = ccc.main("arg").prepareStatement("insert into bill(bill_id, bill_date, tax, discount, total_amt) values(?,now(), ?, ?, ?)");
					pt.setInt(1, Integer.parseInt(xc));
					pt.setInt(2, Integer.parseInt(textField_13.getText()));
					pt.setInt(3, Integer.parseInt(textField_10.getText()));
					pt.setFloat(4,Float.parseFloat(textField_14.getText()));
					pt.execute();
					qwe = true;
					JOptionPane.showMessageDialog(frame, "ORDER PLACED! THANKYOU");
				 } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(694, 697, 227, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.setBackground(Color.LIGHT_GRAY);
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!qwe && !qwe1) {
					JOptionPane.showMessageDialog(frame, "Order not Placed");
				}
				else {
					Connect cn  = new Connect();
					Feedback f = new Feedback();
					f.frame.setVisible(true);
				}
			}
		});
		btnFeedback.setBounds(1119, 131, 97, 25);
		frame.getContentPane().add(btnFeedback);
		
		JButton btnCancel_1 = new JButton("Cancel Order");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long temp = calc(sum,"0:0:0");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
				LocalDateTime tm = LocalDateTime.now();
				String s1 = (dtf.format(tm));
				long temp1 = calc(s1,"0:0:0");
				long temp3 = calc(textField_15.getText(), "0:0:0");
				System.out.println(temp);
				System.out.println(temp1);
				System.out.println(temp3);
				if(temp1 - temp3 > temp/3)JOptionPane.showMessageDialog(frame, "Cannot be Canceled!");
				if(!qwe1 && !qwe)JOptionPane.showMessageDialog(frame, "Order not Placed");
				else if(!qwe && qwe1)JOptionPane.showMessageDialog(frame, "cannot be canceled!");
				//else if()
				else {
					PreparedStatement pt;
					Connect cn = new Connect();
					try {
						pt = cn.main("arg").prepareStatement("delete from bill where bill_id = ?");
						pt.setInt(1,Integer.parseInt(xc));
						pt.execute();
						JOptionPane.showMessageDialog(frame, "Order Canceled!");
						
						  textField_7.setText(""); textField_1.setText(""); textField.setText("");
						  textField_2.setText(""); textField_3.setText(""); textField_4.setText("");
						  textField_11.setText(""); Quantity.setText(""); textField_5.setText("");
						  textField_12.setText(""); textField_6.setText(""); textField_8.setText("0");
						  model.setRowCount(0);
						 
						
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		btnCancel_1.setBackground(Color.LIGHT_GRAY);
		btnCancel_1.setBounds(1119, 192, 128, 25);
		frame.getContentPane().add(btnCancel_1);
		
		JLabel lblDiscount = new JLabel("Discount (%) : ");
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiscount.setBounds(1168, 750, 128, 22);
		frame.getContentPane().add(lblDiscount);
		
		JLabel lblTax = new JLabel("Tax (%) : ");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTax.setBounds(957, 750, 97, 22);
		frame.getContentPane().add(lblTax);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setForeground(Color.RED);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_10.setColumns(10);
		textField_10.setBackground(SystemColor.menu);
		textField_10.setBounds(1308, 740, 117, 35);
		frame.getContentPane().add(textField_10);
		
		textField_13 = new JTextField();
		textField_13.setText("0");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setForeground(Color.RED);
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_13.setColumns(10);
		textField_13.setBackground(SystemColor.menu);
		textField_13.setBounds(1039, 740, 117, 35);
		frame.getContentPane().add(textField_13);
		
		JLabel lblTotal = new JLabel("Total (in Rs) : ");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotal.setBounds(1168, 794, 128, 22);
		frame.getContentPane().add(lblTotal);
		
		textField_14 = new JTextField();
		textField_14.setText("0");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setForeground(Color.RED);
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_14.setColumns(10);
		textField_14.setBackground(SystemColor.menu);
		textField_14.setBounds(1308, 788, 117, 35);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("2019-11-15 01:52:24");
		textField_15.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		textField_15.setColumns(10);
		textField_15.setBounds(476, 313, 92, 22);
		frame.getContentPane().add(textField_15);
		
		JLabel lblTime_1 = new JLabel("Time : ");
		lblTime_1.setBounds(398, 317, 56, 16);
		frame.getContentPane().add(lblTime_1);
		
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-132,1900,1000);
		frame.getContentPane().add(background);
		
	}
}
	