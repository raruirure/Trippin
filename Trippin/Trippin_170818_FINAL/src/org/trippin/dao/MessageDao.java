package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageDao {
	private Connection conn;
	private static MessageDao instance = null;
	private MessageDao(){}
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public static MessageDao getInstance(){
		if(instance==null){
			instance = new MessageDao();
		}
		return instance;
	}
	
	public int SendNormalMessage(MessageVo message_vo){
		String sql = "INSERT INTO MESSAGE_COMMNON(TITLE,SEND_USER_ID,RES_USER_ID,CONTENT,SEND_DATE) VALUES(?,?,?,?,now())";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message_vo.getTitle());
			pstmt.setString(2, message_vo.getSend_user_id());
			pstmt.setString(3, message_vo.getRes_user_id());
			pstmt.setString(4, message_vo.getMessage_content());
			res = pstmt.executeUpdate();
			if(res>0){
				System.out.println("입력 성공!");
			}else{
				System.out.println("입력 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
		}
		return res;
	}

	public int SendReportMessage(MessageVo message_vo) {
		String sql = "INSERT INTO MESSAGE_REPORT(TITLE,SEND_USER_ID,RES_USER_ID,CONTENT,SEND_DATE,WRITE_CLASS,WRITE_ADDRESS) VALUES(?,?,?,?,now(),?,?)";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message_vo.getTitle());
			pstmt.setString(2, message_vo.getSend_user_id());
			pstmt.setString(3, message_vo.getRes_user_id());
			pstmt.setString(4, message_vo.getMessage_content());
			pstmt.setString(5, message_vo.getWrite_class());
			pstmt.setString(6, message_vo.getWrite_address());
			res = pstmt.executeUpdate();
			if(res>0){
				System.out.println("입력 성공!");
			}else{
				System.out.println("입력 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
		}
		return res;
	}
	
	
	public ArrayList<MessageVo> getMessageNormalAll(String userid){
		ArrayList<MessageVo> message_list = new ArrayList<MessageVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MESSAGE_COMMNON WHERE RES_USER_ID=? ORDER BY NO DESC";
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			while(rs.next()){
				int no = rs.getInt("no");
				String send_user_id = rs.getString("SEND_USER_ID");
				String title = rs.getString("TITLE");
				String send_date = rs.getString("SEND_DATE");
				message_list.add(new MessageVo(no, send_user_id,title,send_date));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
		return message_list;
	}

	public ArrayList<MessageVo> getMessageReportAll() {
		ArrayList<MessageVo> message_list = new ArrayList<MessageVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MESSAGE_REPORT ORDER BY NO DESC";
			
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()){
				int no = rs.getInt("no");
				String send_user_id = rs.getString("SEND_USER_ID");
				String title = rs.getString("TITLE");
				String send_date = rs.getString("SEND_DATE");
				message_list.add(new MessageVo(no, send_user_id,title,send_date));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
		return message_list;
	}

	public MessageVo getMessageDetail(int idx) {
		String sql = "SELECT * FROM MESSAGE_COMMNON WHERE NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		MessageVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new MessageVo();
				vo.setNo(rs.getInt("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSend_user_id(rs.getString("SEND_USER_ID"));
				vo.setMessage_content(rs.getString("CONTENT"));
				vo.setSend_date(rs.getString("SEND_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return vo;		
	}
	
	
	public MessageVo getReportDetail(int idx) {
		String sql = "SELECT * FROM MESSAGE_REPORT WHERE NO=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		MessageVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new MessageVo();
				vo.setNo(rs.getInt("NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setSend_user_id(rs.getString("SEND_USER_ID"));
				vo.setRes_user_id(rs.getString("RES_USER_ID"));
				vo.setMessage_content(rs.getString("CONTENT"));
				vo.setSend_date(rs.getString("SEND_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return vo;		
	}

	public void DeleteNormalMessage(String checkbox) {
		String sql = "DELETE FROM MESSAGE_COMMNON WHERE NO=?";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkbox);
			res = pstmt.executeUpdate();
			if(res>0){
				System.out.println("삭제 성공!");
			}else{
				System.out.println("삭제 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
		}
	}

	public void DeleteReportMessage(String checkbox) {
		String sql = "DELETE FROM MESSAGE_REPORT WHERE NO=?";
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkbox);
			res = pstmt.executeUpdate();
			if(res>0){
				System.out.println("입력 성공!");
			}else{
				System.out.println("입력 실패!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
		}
	}
}