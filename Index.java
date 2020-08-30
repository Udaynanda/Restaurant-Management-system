import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
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
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Restaurant Management System");
		frame.setBounds(100, 5, 825, 1024);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Customers Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer c = new Customer();
				c.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(58, 238, 270, 128);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEmployeesRecord = new JButton("Employees Record");
		btnEmployeesRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee ee = new Employee();
				ee.frame.setVisible(true);
			}
		});
		btnEmployeesRecord.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnEmployeesRecord.setBackground(Color.LIGHT_GRAY);
		btnEmployeesRecord.setBounds(58, 442, 270, 128);
		frame.getContentPane().add(btnEmployeesRecord);
		
		JButton btnDishes = new JButton("Dishes ");
		btnDishes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dish d = new Dish();
				d.frame.setVisible(true);
			}
		});
		btnDishes.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnDishes.setBackground(Color.LIGHT_GRAY);
		btnDishes.setBounds(58, 654, 270, 128);
		frame.getContentPane().add(btnDishes);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Invoice in = new Invoice();
				in.frame.setVisible(true);
			}
		});
		btnGenerateBill.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnGenerateBill.setBackground(Color.LIGHT_GRAY);
		btnGenerateBill.setBounds(460, 238, 270, 128);
		frame.getContentPane().add(btnGenerateBill);
		
		JButton btnVendorsRecord = new JButton("Vendors Record");
		btnVendorsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendor vi = new Vendor();
				vi.frame.setVisible(true);
			}
		});
		btnVendorsRecord.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnVendorsRecord.setBackground(Color.LIGHT_GRAY);
		btnVendorsRecord.setBounds(460, 442, 270, 128);
		frame.getContentPane().add(btnVendorsRecord);
		
		JButton btnRawMaterialsRecord = new JButton("Raw Materials Record");
		btnRawMaterialsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RawUpdateinsert rw = new RawUpdateinsert();
				rw.frame.setVisible(true);
			}
		});
		btnRawMaterialsRecord.setFont(new Font("Chaparral Pro Light", Font.PLAIN, 28));
		btnRawMaterialsRecord.setBackground(Color.LIGHT_GRAY);
		btnRawMaterialsRecord.setBounds(460, 654, 270, 128);
		frame.getContentPane().add(btnRawMaterialsRecord);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\12.jpg");
		
		JLabel lblRecordManagemet = new JLabel("Record Management");
		lblRecordManagemet.setForeground(new Color(255, 255, 255));
		lblRecordManagemet.setFont(new Font("MV Boli", Font.PLAIN, 32));
		lblRecordManagemet.setBounds(235, 90, 358, 73);
		frame.getContentPane().add(lblRecordManagemet);
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-120,818,1176);
		frame.getContentPane().add(background);
	}
}
