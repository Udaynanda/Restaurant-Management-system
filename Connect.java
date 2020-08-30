import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class Connect {
	//DB connection Variables
	
	static Connection connection = null;
	static String databaseName = "restaurant";
	static String url = "jdbc:mysql://localhost:3307/" +databaseName;
	
	static String username = "root";
	static String password = "man1210$$$9934984456";
	
	
	public static Connection main(String args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}	
}
