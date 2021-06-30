package p1.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnection {


	private static Connection con;
	private static final String URL = "jdbc:postgresql://localhost:5432/sms";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "Rajeev@2345";

	public static Connection getConnection() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return con;
	}
	
}
