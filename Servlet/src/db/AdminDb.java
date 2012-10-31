package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.Admin;

public class AdminDb {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet ret = null;

	public static boolean regist(Admin admin) throws SQLException {
		if (query(admin.getUsername()) != null) {
			return false;
		} else {
			try {
				conn = DbConnection.getConn();
				pstmt = null;
				String sql = "INSERT INTO admin (username,password) VALUES(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getUsername());
				pstmt.setString(2, admin.getPassword());
				pstmt.executeUpdate();
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				DbConnection.closeConnection(conn, pstmt, ret);
			}
		}
	}

	public static Admin query(String username) throws SQLException {
		Admin admin = null;
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM admin a WHERE a.username = '"
					+ username + "'";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new Admin(ret.getString("username"),
						ret.getString("password"));
			}
			return admin;
		} catch (Exception e) {
			return admin;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static boolean update(Admin admin) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "UPDATE admin b SET b.password =? WHERE b.username =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getPassword());
			pstmt.setString(2, admin.getUsername());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
}
