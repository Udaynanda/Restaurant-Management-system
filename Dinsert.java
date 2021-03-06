import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Dinsert {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dinsert window = new Dinsert();
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
	public Dinsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 920);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDishDetails = new JLabel("Dish Details");
		lblDishDetails.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 30));
		lblDishDetails.setBounds(302, 118, 183, 33);
		frame.getContentPane().add(lblDishDetails);
		
		JLabel lblDishName = new JLabel("Dish Name :");
		lblDishName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDishName.setBounds(176, 230, 118, 46);
		frame.getContentPane().add(lblDishName);
		
		JLabel lblCookingTime = new JLabel("Cooking Time :");
		lblCookingTime.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblCookingTime.setBounds(176, 323, 150, 46);
		frame.getContentPane().add(lblCookingTime);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPrice.setBounds(176, 411, 135, 46);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblRecipe = new JLabel("Recipe : ");
		lblRecipe.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblRecipe.setBounds(176, 499, 135, 46);
		frame.getContentPane().add(lblRecipe);
		
		JLabel lblCookingStyle = new JLabel("Cooking Style :");
		lblCookingStyle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblCookingStyle.setBounds(176, 602, 150, 46);
		frame.getContentPane().add(lblCookingStyle);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(417, 241, 172, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(417, 338, 156, 31);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(417, 426, 156, 31);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(417, 514, 156, 31);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(417, 617, 172, 31);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Insert Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement pt;
				Connect cn = new Connect();
				try {
					pt = cn.main("arg").prepareStatement("insert into dish(dish_name,c_time, price, recipe, cooking_style) values(?,?,?,?,?)");
					pt.setString(1, textField.getText());
					pt.setString(2, textField_1.getText());
					pt.setInt(3, Integer.parseInt(textField_2.getText()));
					pt.setString(4, textField_3.getText());
					pt.setString(5, textField_4.getText());
					pt.execute();
					JOptionPane.showMessageDialog(frame, "Successful");
					frame.dispose();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(302, 726, 135, 25);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
}
