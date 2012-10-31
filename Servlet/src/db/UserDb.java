package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Cost;
import object.User;

public class UserDb {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet ret = null;

	public static boolean regist(User admin) throws SQLException {
		if (query(admin.getUsername()) != null) {
			return false;
		} else {
			try {
				conn = DbConnection.getConn();
				pstmt = null;
				String sql = "INSERT INTO users (cid,username,password,name,lasttime) VALUES(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, admin.getCid());
				pstmt.setString(2, admin.getUsername());
				pstmt.setString(3, admin.getPassword());
				pstmt.setString(4, admin.getName());
				pstmt.setString(5, admin.getLasttime());
				pstmt.executeUpdate();
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				DbConnection.closeConnection(conn, pstmt, ret);
			}
		}
	}

	public static User query(String username) throws SQLException {
		User admin = null;
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM users a WHERE a.username = '"
					+ username + "'";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new User(ret.getInt("cid"),ret.getString("username"),
						ret.getString("password"),ret.getString("name"),ret.getString("lasttime"));
				admin.setId(ret.getInt("id"));
			}
			return admin;
		} catch (Exception e) {
			return admin;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static User queryById(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			User admin = null;
			String sql = "SELECT * FROM users WHERE id = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new User(ret.getInt("cid"),ret.getString("username"),
						ret.getString("password"),ret.getString("name"),ret.getString("lasttime"));
				admin.setId(ret.getInt("id"));
			}
			return admin;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	
	}

	public static List<User> query() throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM users";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<User> list = new ArrayList<User>();
			while (ret.next()) {
				User admin = new User(ret.getInt("cid"),ret.getString("username"),
						ret.getString("password"),ret.getString("name"),ret.getString("lasttime"));
				admin.setId(ret.getInt("id"));
				list.add(admin);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
	
	public static List<Cost> getCost(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM cost WHERE uid = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while (ret.next()) {
				Cost building = new Cost(ret.getInt("uid"),
						ret.getFloat("monthlypay"), ret.getString("year"),
						ret.getString("month"),ret.getInt("state"));
				building.setId(ret.getInt("id"));
				list.add(building);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
	
	public static boolean delete(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "DELETE FROM users WHERE id = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
	
	public static boolean update(User admin) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "UPDATE users b SET b.password =?, b.username =?, b.name =? WHERE b.id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getPassword());
			pstmt.setString(2, admin.getUsername());
			pstmt.setString(3, admin.getName());
			pstmt.setInt(4, admin.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static boolean isExit(int id) throws SQLException{
		User user = queryById(String.valueOf(id));
		if(user == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static void update(String username,String lasttime) throws SQLException{
		User user = query(username);
		user.setLasttime(lasttime);
		update(user);
	}

	public static void repassword(String username,String password) throws SQLException{
		User user = query(username);
		user.setPassword(password);
		update(user);
	}
}
