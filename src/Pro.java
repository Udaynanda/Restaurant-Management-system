import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Pro {

	private JFrame frame;
	int a = 0;
	int b = 0;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro window = new Pro();
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
	public Pro() {
		initialize();
		f();
	}
	public void f()
	{
		Connect cn = new Connect();
		PreparedStatement pt;
		try {
			pt = cn.main("arg").prepareStatement("select sum(total_amt) from bill;");
			ResultSet rs = pt.executeQuery();
			if(!rs.isBeforeFirst())JOptionPane.showMessageDialog(frame, "No Data exists");
			while(rs.next()) {
				a = rs.getInt("sum(total_amt)");
			}
			pt = cn.main("arg").prepareStatement("select sum((used.qty_required)*(orders.quantity)*(raw_material.unit_price)) from used \r\n" + 
					"inner join orders on used.dish_name = orders.dish_name \r\n" + 
					"inner join raw_material on raw_material.mat_name = used.mat_name ;");
			rs = pt.executeQuery();
			while(rs.next()) {
				b = rs.getInt("sum((used.qty_required)*(orders.quantity)*(raw_material.unit_price))");
			}
			textField.setText(Integer.toString(a-b));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(182, 143, 130, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
