package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.Building;
import object.Room;

public class BuildingDb {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet ret = null;

	public static boolean add(Building admin) throws SQLException {
		List<Building> list = query(admin.getName());
		if (list.size() == 1) {
			return false;
		} else {
			try {
				conn = DbConnection.getConn();
				pstmt = null;
				String sql = "INSERT INTO building (name,location,sumofroom,postcode) VALUES(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, admin.getName());
				pstmt.setString(2, admin.getLocation());
				pstmt.setInt(3, admin.getSumOfRoom());
				pstmt.setString(4, admin.getPostcode());
				pstmt.executeUpdate();
				return true;
			} catch (Exception e) {
				return false;
			} finally {
				DbConnection.closeConnection(conn, pstmt, ret);
			}
		}
	}

	public static boolean delete(String id) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "DELETE FROM building WHERE id = "
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

	public static boolean update(Building building) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "UPDATE building b SET b.name =?, b.location =?, b.sumofroom =?, b.postcode =? WHERE b.id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, building.getName());
			pstmt.setString(2, building.getLocation());
			pstmt.setInt(3, building.getSumOfRoom());
			pstmt.setString(4, building.getPostcode());
			pstmt.setInt(5, building.getId());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static List<Building> query(String name) throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM building a WHERE a.name = '" + name
					+ "'";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<Building> list = new ArrayList<Building>();
			while (ret.next()) {
				Building admin = new Building(ret.getString("name"),
						ret.getString("location"), ret.getInt("sumofroom"),
						ret.getString("postcode"));
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

	public static List<Building> query() throws SQLException {
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			String sql = "SELECT * FROM building";
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			List<Building> list = new ArrayList<Building>();
			while (ret.next()) {
				Building building = new Building(ret.getString("name"),
						ret.getString("location"), ret.getInt("sumofroom"),
						ret.getString("postcode"));
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

	public static Building queryById(String id) throws SQLException{
		try {
			conn = DbConnection.getConn();
			pstmt = null;
			Building admin = null;
			String sql = "SELECT * FROM building WHERE id = "
					+ Integer.valueOf(id);
			pstmt = conn.prepareStatement(sql);
			ret = pstmt.executeQuery(sql);
			while (ret.next()) {
				admin = new Building(ret.getString("name"),
						ret.getString("location"), ret.getInt("sumofroom"),
						ret.getString("postcode"));
				admin.setId(ret.getInt("id"));
			}
			return admin;
		} catch (Exception e) {
			return null;
		} finally {
			DbConnection.closeConnection(conn, pstmt, ret);
		}
	}

	public static List<Building> queryByPercent(String precent) throws SQLException{
		int percents = Integer.valueOf(precent);
		List<Building> result = new ArrayList<Building>();
		List<Building> building = query();
		for(Building build:building){
			Double sum = Double.valueOf(build.getSumOfRoom());
			Double count = 0.00;
			List<Room> rooms = RoomDb.queryByBid(build.getId());
			for(Room room:rooms){
				if(UserDb.isExit(room.getUid())){
					count = count + 1.00;
				}
			}
			Double temp = Double.valueOf(percents)/100.00;
			if((count/sum)>=temp){
				result.add(build);
			}
		}
		return result;
	}
	
}
