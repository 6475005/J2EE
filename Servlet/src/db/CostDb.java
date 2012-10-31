package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Cost;

public class CostDb {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet ret = null;

	public static boolean add(Cost admin) throws SQLException {
			try {
				conn = DbConnection.getConn();
				pstmt = null;
				String sql = "INSERT INTO cost (uid,monthlypay,year,month,state) VALUES(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, admin.getUid());
				pstmt.setFloat(2, admin.getMonthlyPay());
				pstmt.setString(3, admin.getYear());
				pstmt.setString(4, admin.getMonth());
				pstmt.setInt(5, admin.getState());
				pstmt.executeUpdate();
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				DbConnection.closeConnection(conn, pstmt, ret);
			}
	}

	public static boolean delete(String id) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "DELETE FROM cost WHERE id = "
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

	public static boolean update(Cost building) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "UPDATE cost b SET b.uid =?, b.monthlypay =?, b.year =?, b.month =?, b.state =? WHERE b.id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, building.getUid());
			pstmt.setFloat(2, building.getMonthlyPay());
			pstmt.setString(3, building.getYear());
			pstmt.setString(4, building.getMonth());
			pstmt.setInt(5, building.getState());
			pstmt.setInt(6, building.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static List<Cost> query() throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM cost";
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

	public static Cost queryById(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			Cost admin = null;
			String sql = "SELECT * FROM cost WHERE id = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new Cost(ret.getInt("uid"),
						ret.getFloat("monthlypay"), ret.getString("year"),
						ret.getString("month"),ret.getInt("state"));
				admin.setId(ret.getInt("id"));
			}
			return admin;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
}
