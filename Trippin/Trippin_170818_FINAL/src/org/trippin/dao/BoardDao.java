package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class BoardDao {
		public static long nboardNo=1;
		public static long fboardNo=1;
		public static long boardNo=0;
		private Connection conn;
		private static BoardDao instance = null;
		private BoardDao() {}
		public void setConnection(Connection conn) {
			this.conn = conn;
		}
		public static BoardDao getInstance() {
			if (instance == null) {
				instance = new BoardDao();
			}
			return instance;
		}
		
		// 글 목록 
		public ArrayList<BoardVo> selectAll(String _code_key, int page, int limit, String fBSSelect, String fBSText) {
			ArrayList<BoardVo> board_list = new ArrayList<BoardVo>();
			BoardVo boardVo = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int startRow=(page-1)*10; //읽기 시작할 row번호

			String sql = "SELECT * FROM notice_free_board WHERE code_key=?";
			
			if(fBSSelect != null && !fBSText.equals("")) {
				sql += " AND " + fBSSelect.trim() + " LIKE '%" + fBSText.trim() +"%' ORDER BY write_no DESC  limit ?,10";
			} else { 
				sql += "ORDER BY write_no DESC  limit ?,10";
			}
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, _code_key);
				pstmt.setInt(2, startRow);
				rs=pstmt.executeQuery();
				while(rs.next()){
					int no = rs.getInt("no");
					String write_no = rs.getString("write_no");
					String code_key = rs.getString("code_key");
					String user_id = rs.getString("user_id");
					String user_name = rs.getString("user_name");
					String title = rs.getString("title");
					String content = rs.getString("content");					
					String rdate = rs.getString("rdate");
					int hit = rs.getInt("hit");
					boardVo = new BoardVo(no, write_no, code_key, user_id, user_name, title, content, rdate, hit);
					board_list.add(boardVo);
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			return board_list;
		}
		
		// 글 보기
		public BoardVo seletByWriteNo(String _write_no) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BoardVo boardVo = null;
			String sql = "SELECT * FROM notice_free_board WHERE write_no=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, _write_no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					boardVo = new BoardVo();
					boardVo.setNo(rs.getInt("no"));
					boardVo.setWrite_no(rs.getString("write_no"));
					boardVo.setCode_key(rs.getString("code_key"));
					boardVo.setUser_id(rs.getString("user_id"));
					boardVo.setUser_name(rs.getString("user_name"));
					boardVo.setTitle(rs.getString("title"));
					boardVo.setContent(rs.getString("content"));
					boardVo.setRdate(rs.getString("rdate"));
					boardVo.setHit(rs.getInt("hit"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			return boardVo;
		}
		
		// 조회수 업데이트
		public int updateReadCount(String _write_no){
			PreparedStatement pstmt = null;
			int updateCount = 0;
			String sql="UPDATE notice_free_board SET hit = hit+1 WHERE write_no = ?";
			try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, _write_no);
				updateCount = pstmt.executeUpdate();
				
			}catch(SQLException ex){
				System.out.println("조회수 에러 : "+ex);
			} finally{
				JdbcUtil.close(pstmt);
			}

			return updateCount;
		}
		
		// 글 작성
		public int insert_Board(BoardVo boardVo) {		
			PreparedStatement pstmt = null;
			int res = 0;
			if(boardVo.getCode_key().equals("N")) {
				boardNo = nboardNo++;
			} else if(boardVo.getCode_key().equals("F")) {
				boardNo = fboardNo++;
			}
			String boardFNo = String.format("%05d", boardNo);
			String write_no =(boardVo.getCode_key()).concat(boardFNo);
			String sql = "insert into notice_free_board(write_no, code_key, user_id, user_name, title, content ,hit) values (?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, write_no);
				pstmt.setString(2, boardVo.getCode_key());
				pstmt.setString(3, boardVo.getUser_id());
				pstmt.setString(4, boardVo.getUser_name());
				pstmt.setString(5, boardVo.getTitle());
				pstmt.setString(6, boardVo.getContent());		
				pstmt.setInt(7, 0);
				res = pstmt.executeUpdate();
				
			} catch (SQLException e) {				
				e.printStackTrace();
				System.out.println("글 작성 에러");
			}finally{
				JdbcUtil.close(pstmt);
			}
			
			return res;
		}
		
		
		// 글 수정
		public int modify_Board(BoardVo boardVo) {
			PreparedStatement pstmt = null;
			int res = 0;
			String sql = "UPDATE notice_free_board SET title=?, content=? WHERE write_no=?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardVo.getTitle());
				pstmt.setString(2, boardVo.getContent());
				pstmt.setString(3, boardVo.getWrite_no());
				
				res = pstmt.executeUpdate();
			} catch (Exception ex) {
				System.out.println("글 수정 에러"+ex);
			} finally {
				JdbcUtil.close(pstmt);
			}
			return res;
		}

		// 글 삭제
		public int Delete_Board(String write_no) {

			PreparedStatement pstmt = null;
			int res = 0;
			String sql = "DELETE FROM notice_free_board WHERE write_no=?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, write_no);
				res = pstmt.executeUpdate();
			} catch (Exception ex) {
				System.out.println("글 삭제 에러"+ex);
			} finally {
				JdbcUtil.close(pstmt);
			}

			return res;
		}
		
		// 글 갯수 구하기
		public int selectListCount(String _codeKey, String fBSSelect, String fBSText) {
			int listCount= 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="SELECT COUNT(*) FROM notice_free_board WHERE code_key=?";
			
			if(fBSSelect != null && !fBSText.equals("")) {
				sql += " AND " + fBSSelect.trim() + " LIKE '%" + fBSText.trim() +"%'";
			}

			try{
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, _codeKey);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					listCount=rs.getInt(1);
				}
			}catch(Exception ex){
				System.out.println("getListCount 에러: " + ex);			
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}

			return listCount;

		}

		
}
