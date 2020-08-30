import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vendor {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendor window = new Vendor();
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
	public Vendor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("RMS : Vendor");
		frame.setBounds(100, 100, 625, 750);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel background;
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\Kunal Kumar Sagar\\\\Desktop\\\\12.jpg");
		
		JLabel lblManageCustomers = new JLabel("Manage Vendors");
		lblManageCustomers.setForeground(Color.WHITE);
		lblManageCustomers.setFont(new Font("MV Boli", Font.PLAIN, 36));
		lblManageCustomers.setBounds(165, 75, 285, 73);
		frame.getContentPane().add(lblManageCustomers);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vupdate vu =new Vupdate();
				vu.frame.setVisible(true);
			}
		});
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnUpdate.setBounds(187, 375, 241, 79);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnAccesssRecords = new JButton("Accesss Records");
		btnAccesssRecords.setBackground(Color.LIGHT_GRAY);
		btnAccesssRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vtable cc = new Vtable();
				cc.frame.setVisible(true);
			}
		});
		btnAccesssRecords.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAccesssRecords.setBounds(187, 525, 241, 79);
		frame.getContentPane().add(btnAccesssRecords);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vinsert in = new Vinsert();
				in.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(187, 229, 241, 79);
		frame.getContentPane().add(btnNewButton);
		background = new JLabel("",img,JLabel.CENTER);
		background.setForeground(Color.GRAY);
		background.setBounds(-11,-132,618,835);
		frame.getContentPane().add(background);
	}

}
