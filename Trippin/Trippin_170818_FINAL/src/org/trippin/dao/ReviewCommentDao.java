package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewCommentVo;


public class ReviewCommentDao {
	private Connection conn;
	private static ReviewCommentDao instance = null;
	private ReviewCommentDao(){}
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	
	public static ReviewCommentDao getInstance(){
		if(instance==null){
			instance = new ReviewCommentDao();
		}
		return instance;
	}
	
	public void insertReviewComment(ReviewCommentVo vo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;
		
		String sql = "INSERT INTO TR_REVIEW_COMMENT(CODE_CLASS,CODE_CMT,USER_ID,CODE,RE_CMT_CONTENT,RE_CMT_RGDT) VALUES(?,?,?,?,?,now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getcode_class());
			pstmt.setString(2, vo.getCodeCmt());
			pstmt.setString(3, vo.getUserId());
			pstmt.setString(4, vo.getcode());
			pstmt.setString(5, vo.getReCmtContent());
			res= pstmt.executeUpdate(); 
			if(res>0){
				System.out.println("ok");
			}else{
				System.out.println("miss");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(pstmt);
		}
	}
	
	public ArrayList<ReviewCommentVo> SelectAll(String pro_cd){
		ArrayList<ReviewCommentVo> read_list = new ArrayList<ReviewCommentVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int res = 0;
		
		String sql = "SELECT * FROM TR_REVIEW_COMMENT WHERE CODE=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_cd);
			rs= pstmt.executeQuery();
			while(rs.next()){
				String userId = rs.getString("USER_ID");
				String codeCmt = rs.getString("CODE_CMT");
				String reCmtContent = rs.getString("RE_CMT_CONTENT");
				String reCmtRgdt = rs.getString("RE_CMT_RGDT");
				read_list.add(new ReviewCommentVo(userId,codeCmt,reCmtContent,reCmtRgdt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
		return read_list;
	}

	public int getReviewNum(String pro_cd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "SELECT count(*) FROM TR_REVIEW_COMMENT WHERE CODE=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_cd);
			rs= pstmt.executeQuery();
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}	
		return num;
	}
}