package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/myweb";
	private static String USERNAME = "root";
	private static String PASSWORD = "8840153";
	private static Connection conn;

	public static Connection getConn() throws ClassNotFoundException,
			SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}

	public static void closeConnection(Connection conn,
			PreparedStatement pstmt, ResultSet ret) throws SQLException {
		if (ret != null) {
			ret.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
