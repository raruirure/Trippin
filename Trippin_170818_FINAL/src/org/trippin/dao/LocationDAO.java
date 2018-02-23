package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ListIterator;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.LocationBean;
import org.trippin.vo.PlanBean;

public class LocationDAO {
	Connection conn;
	private static LocationDAO locationDAO;

	private LocationDAO() {
		// TODO Auto-generated constructor stub
	}

	public static LocationDAO getInstance(){
		if(locationDAO == null){
			locationDAO = new LocationDAO();
		}
		return locationDAO;
	}

	public void setConnection(Connection conn){
		this.conn = conn;
	}

	public boolean insertCode(String code, ArrayList<String> codeList, String sql) {
		boolean locInsert = false;
		ListIterator<String> iterator = codeList.listIterator();
		PreparedStatement pstmt = null;
		int res = 0;
		int idx = 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(idx, code);
			idx++;
			while(iterator.hasNext()) {
				pstmt.setString(idx, iterator.next());
				idx++;
			}
			res = pstmt.executeUpdate();
			if(res!=0) {
				locInsert = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return locInsert;
	}

	public LocationBean selectByCode(String codeN) {
		LocationBean loc = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM location WHERE code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codeN);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String code = rs.getString(2);
				String pointX1 = rs.getString(3);
				String pointY1 = rs.getString(4);
				String pointX2 = rs.getString(5);
				String pointY2 = rs.getString(6);
				String pointX3 = rs.getString(7);
				String pointY3 = rs.getString(8);
				String pointX4 = rs.getString(9);
				String pointY4 = rs.getString(10);
				String pointX5 = rs.getString(11);
				String pointY5 = rs.getString(12);
				String pointX6 = rs.getString(13);
				String pointY6 = rs.getString(14);
				String pointX7 = rs.getString(15);
				String pointY7 = rs.getString(16);
				String pointX8 = rs.getString(17);
				String pointY8 = rs.getString(18);
				String pointX9 = rs.getString(19);
				String pointY9 = rs.getString(20);
				String pointX10 = rs.getString(21);
				String pointY10 = rs.getString(22);
				loc = new LocationBean(no, code, pointX1, pointY1, pointX2, pointY2, pointX3, pointY3, pointX4, pointY4, pointX5, pointY5, pointX6, pointY6, pointX7, pointY7, pointX8, pointY8, pointX9, pointY9, pointX10, pointY10);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return loc;
	}

	public boolean deleteLocByCode(String code) {
		boolean delLocOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM location where code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			res = pstmt.executeUpdate();
			if(res != 0) {
				System.out.println("삭제가 완료되었습니다.");
				delLocOK = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return delLocOK;
	}
	
}
