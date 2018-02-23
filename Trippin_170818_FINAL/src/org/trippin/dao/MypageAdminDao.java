package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MypageAdminDao {
	private Connection conn;
	private static MypageAdminDao instance;
	
	private MypageAdminDao() {};
	public static MypageAdminDao getInstance(){
		if(instance == null){
			instance = new MypageAdminDao();
		}
		return instance;
	}	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public ArrayList<MemberVo> selectByUser() {
		ArrayList<MemberVo> userList = new ArrayList<MemberVo>();
		MemberVo memUser = null;
		String sql = "select*from tr_member where user_level = 1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memUser = new MemberVo();
				memUser.setNo(rs.getInt("NO"));
				memUser.setUserId(rs.getString("USER_ID"));				
				memUser.setUserPass(rs.getString("USER_PASS"));
				memUser.setUserName(rs.getString("USER_NAME"));
				memUser.setUserBirth(rs.getString("USER_BIRTH"));
				memUser.setDate(rs.getString("USER_RDATE"));
				memUser.setUserOutCheck(rs.getInt("USER_OUT_CHECK"));
				userList.add(memUser);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
		return userList;
	}
	public ArrayList<MemberVo> selectBySeller() {
		ArrayList<MemberVo> sellerList = new ArrayList<MemberVo>();
		MemberVo memSeller = null;
		String sql = "select*from tr_member inner join  tr_member_seller on tr_member.USER_ID= tr_member_seller.USER_ID where user_level = 2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memSeller = new MemberVo();
				memSeller.setNo(rs.getInt("NO"));
				memSeller.setUserId(rs.getString("USER_ID"));				
				memSeller.setUserPass(rs.getString("USER_PASS"));
				memSeller.setUserName(rs.getString("USER_NAME"));
				memSeller.setSellerNo(rs.getString("SELLER_NUMBER"));
				memSeller.setSellerState(rs.getInt("SELLER_STATE"));
				memSeller.setUserBirth(rs.getString("USER_BIRTH"));
				memSeller.setDate(rs.getString("USER_RDATE"));
				memSeller.setUserOutCheck(rs.getInt("USER_OUT_CHECK"));
				
				sellerList.add(memSeller);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
		return sellerList;				
		
	}
	public ArrayList<MemberVo> selectByBlack() {
		ArrayList<MemberVo> blackList = new ArrayList<MemberVo>();
		MemberVo memBlack = null;
		String sql = "select*from tr_member where USER_OUT_CHECK=2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memBlack = new MemberVo();
				memBlack.setNo(rs.getInt("NO"));
				memBlack.setUserId(rs.getString("USER_ID"));				
				memBlack.setUserPass(rs.getString("USER_PASS"));
				memBlack.setUserName(rs.getString("USER_NAME"));
				memBlack.setUserBirth(rs.getString("USER_BIRTH"));
				memBlack.setDate(rs.getString("USER_RDATE"));
				memBlack.setUserOutCheck(rs.getInt("USER_OUT_CHECK"));
				
				blackList.add(memBlack);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
		return blackList;				
		
		
	}	
	
	public MemberVo serletByUserId(String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo memberVo = null;
		String sql = "Select*from tr_member where USER_ID = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memberVo = new MemberVo();
				memberVo.setNo(rs.getInt("no"));
				memberVo.setUserId(rs.getString("USER_ID"));
				memberVo.setUserName(rs.getString("USER_NAME"));
				memberVo.setUserPass(rs.getString("USER_PASS"));
				memberVo.setUserBirth(rs.getString("USER_BIRTH"));
				memberVo.setDate(rs.getString("USER_RDATE"));
				memberVo.setUserOutCheck(rs.getInt("USER_OUT_CHECK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return memberVo;
	}
	public int modifyUserMem(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update tr_member set USER_OUT_CHECK=? where USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberVo.getUserOutCheck());
			pstmt.setString(2, memberVo.getUserId());
			
			res = pstmt.executeUpdate();
		} catch (Exception ex) {			
			System.out.println("글 수정 에러"+ex);
		}finally{
			JdbcUtil.close(pstmt);
		}		
		
		return res;
	}	
	public int modifySellerMem(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update tr_member set USER_OUT_CHECK=? where USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberVo.getUserOutCheck());
			pstmt.setString(2, memberVo.getUserId());
			res = pstmt.executeUpdate();
		} catch (Exception ex) {	
			System.out.println("글 수정 에러 "+ex);
		}finally{
			JdbcUtil.close(pstmt);
		}	
		
		return res;
	}
	public int modifyBlackMem(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update tr_member set USER_OUT_CHECK=? where USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberVo.getUserOutCheck());
			pstmt.setString(2, memberVo.getUserId());
			
			res = pstmt.executeUpdate();
		} catch (Exception ex) {			
			System.out.println("글 수정 에러"+ex);
		}finally{
			JdbcUtil.close(pstmt);
		}		
		
		return res;
	}
	public int modifySellerOk(MemberVo memberVo) {
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update tr_member_seller set SELLER_STATE=? where USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberVo.isSellerState());
			pstmt.setString(2, memberVo.getUserId());
			
			res = pstmt.executeUpdate();
		} catch (Exception ex) {			
			System.out.println("글 수정 에러"+ex);
		}finally{
			JdbcUtil.close(pstmt);
		}		
		
		return res;
	}
	
}
	
	
