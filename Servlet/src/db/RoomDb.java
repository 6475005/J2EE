package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Room;

public class RoomDb {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet ret = null;

	public static boolean add(Room admin) throws SQLException {
			try {
				conn = DbConnection.getConn();
				pstmt = null;
				String sql = "INSERT INTO room (bid,uid,floor,area) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, admin.getBid());
				pstmt.setInt(2, admin.getUid());
				pstmt.setInt(3, admin.getFloor());
				pstmt.setFloat(4, admin.getArea());
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
			String sql = "DELETE FROM room WHERE id = "
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

	public static boolean update(Room building) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "UPDATE room b SET b.bid =?, b.uid =?, b.floor =?, b.area =? WHERE b.id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, building.getBid());
			pstmt.setInt(2, building.getUid());
			pstmt.setInt(3, building.getFloor());
			pstmt.setFloat(4, building.getArea());
			pstmt.setInt(5, building.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static List<Room> query() throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM room";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<Room> list = new ArrayList<Room>();
			while (ret.next()) {
				Room building = new Room(ret.getInt("bid"),
						ret.getInt("uid"), ret.getInt("floor"),
						ret.getFloat("area"));
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

	public static Room queryById(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			Room admin = null;
			String sql = "SELECT * FROM room WHERE id = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new Room(ret.getInt("bid"),
						ret.getInt("uid"), ret.getInt("floor"),
						ret.getFloat("area"));
				admin.setId(ret.getInt("id"));
			}
			return admin;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}
	
	public static List<Room> queryByBid(int bid) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM room WHERE bid = "
					+ bid;
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<Room> list = new ArrayList<Room>();
			while (ret.next()) {
				Room building = new Room(ret.getInt("bid"),
						ret.getInt("uid"), ret.getInt("floor"),
						ret.getFloat("area"));
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
}
