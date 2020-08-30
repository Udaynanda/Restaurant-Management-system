import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class ConnectDB {
	//DB connection Variables
	
	static Connection connection = null;
	static String databaseName = "inventory";
	static String url = "jdbc:mysql://localhost:3307/" +databaseName;
	
	static String username = "root";
	static String password = "man1210$$$9934984456";
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, username, password);
		//PreparedStatement ps = connection.prepareStatement("insert into customer(customer_id) values(3010)");
		String query = "select * from customer";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			int id = rs.getInt("customer_id");
			String name = rs.getString("cust_name");
			String c = rs.getString("city");
			int grade = rs.getInt("grade");
			int sale = rs.getInt("salesman_id");
	
			System.out.print("ID : " + id);
			System.out.print(", Name : " + name);
			System.out.print(", city :  " + c);
			System.out.print(", Grade : " + grade);
			System.out.println(", sale : " + sale);
		}
		//int status = ps.executeUpdate();
//		if(status != 0) {
//			System.out.println("Database was connected");
//			System.out.println("Record was Inserted");
//		}
	}

}
