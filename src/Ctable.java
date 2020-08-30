import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class Ctable {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ctable window = new Ctable();
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
	public Ctable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 458);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Connect cn = new Connect();
		DefaultTableModel model = new DefaultTableModel();
		Container cc = frame.getContentPane();
		JTable tbl = new JTable(model);
		tbl.setRowHeight(25);
		tbl.setFont(new Font("Sylfaen", Font.PLAIN, 17));
        cc.setLayout(new FlowLayout(FlowLayout.CENTER));
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("phone no.");
        model.addColumn("DOB");
        model.addColumn("Credits");
        try {
            PreparedStatement pstm = cn.main("arg").prepareStatement("SELECT * FROM customer");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6)});
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(tbl);
        pg.setFont(new Font("Tahoma", Font.PLAIN, 22));
        pg.setPreferredSize(new Dimension(1080, 960));
        cc.add(pg);
        frame.pack();
	}


}
