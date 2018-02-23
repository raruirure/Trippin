package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MemberDao {
	private Connection conn;
	
	private static MemberDao instance; 
	private MemberDao() {}
	public static MemberDao getInstance(){
		if(instance == null){
			instance = new MemberDao();
		}
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public boolean setTRMember(MemberVo member) {
		// for member join
		boolean isOk = false;
		String sql = "INSERT INTO TR_MEMBER(USER_ID,USER_PASS,USER_NAME,USER_BIRTH,USER_LEVEL) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPass());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserBirth());
			pstmt.setInt(5, member.getUserLevel());
			res = pstmt.executeUpdate();
			if(res>0) {
				isOk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return isOk;
	}
	public boolean setTRMemberSeller(MemberVo member) {
		// for member join
		boolean isOk = false;
		String sql = "INSERT INTO TR_MEMBER_SELLER(USER_ID,SELLER_NUMBER) values(?,?)";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getSellerNo());
			res = pstmt.executeUpdate();
			if(res>0) {
				isOk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return isOk;
	}
	public MemberVo selectById(String userId) {
		// login
		MemberVo member = null;
		String sql = "SELECT * FROM TR_MEMBER WHERE USER_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVo();
				member.setUserId(userId);
				member.setUserPass(rs.getString("USER_PASS"));
				member.setUserName(rs.getString("USER_NAME"));
				member.setUserLevel(rs.getInt("USER_LEVEL"));
				member.setUserOutCheck(rs.getInt("USER_OUT_CHECK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	public MemberVo selectSellerInfo(MemberVo memLogin) {
		String sql = "SELECT SELLER_NUMBER, SELLER_STATE FROM TR_MEMBER_SELLER WHERE USER_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memLogin.getUserId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memLogin.setSellerNo(rs.getString(1));
				memLogin.setSellerState(rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return memLogin;
	}
}
