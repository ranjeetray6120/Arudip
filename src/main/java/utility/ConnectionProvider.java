package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static final String url = "jdbc:mysql://localhost:3306/libarary";
	private static final String user ="root";
	private static final String passwords = "1234";
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,user,passwords);
			System.out.println("Connection Successful");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Not connection");
		}
		return connection;
	}
}
