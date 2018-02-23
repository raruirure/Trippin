package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewBean;

public class ReviewDAO {
	Connection conn;
	private static ReviewDAO reviewDAO;

	private ReviewDAO() {
		// TODO Auto-generated constructor stub
	}

	public static ReviewDAO getInstance(){
		if(reviewDAO == null){
			reviewDAO = new ReviewDAO();
		}
		return reviewDAO;
	}

	public void setConnection(Connection conn){
		this.conn = conn;
	}

	public boolean insertReviewCommon(ReviewBean review) {
		boolean isOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "INSERT INTO REVIEW(CODE_CLASS,WRITE_NO,CODE,MAIN_TITLE,USER_ID,SDATE,EDATE,CATEGORY,BANNER_IMG,review_content,REVIEW_DAYCNT,hit) value(?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getCode_class());
			pstmt.setInt(2, review.getWrite_no());
			pstmt.setString(3, review.getCode());
			pstmt.setString(4, review.getMain_title());
			pstmt.setString(5, review.getUser_id());
			pstmt.setString(6, review.getSdate());
			pstmt.setString(7, review.getEdate());
			pstmt.setString(8, review.getCategory());
			pstmt.setString(9, review.getBanner_img());
			pstmt.setString(10, review.getReview_content());
			pstmt.setInt(11, review.getReview_DayCnt());
			pstmt.setInt(12, review.getHit());
			res = pstmt.executeUpdate();
			if(res!=0) {
				isOK = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return isOK;
	}

	public int getCount() {
		int cnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM REVIEW";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return cnt;
	}

	public ArrayList<ReviewBean> selectAll() {
		ArrayList<ReviewBean> reviewList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<ReviewBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String review_content = rs.getString(10);
				int review_DayCnt = rs.getInt(11);
				int hit = rs.getInt(12);
				reviewList.add(new ReviewBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, review_content, category, review_DayCnt, hit));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return reviewList;
	}
	public ArrayList<ReviewBean> selectById(String compId) {
		ArrayList<ReviewBean> reviewList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW WHERE user_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, compId);
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<ReviewBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String review_content = rs.getString(10);
				int review_DayCnt = rs.getInt(11);
				int hit = rs.getInt(12);
				reviewList.add(new ReviewBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, review_content, category, review_DayCnt, hit));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return reviewList;
	}

	public ArrayList<ReviewBean> selectByKey(String keyword) {
		ArrayList<ReviewBean> reviewList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW WHERE main_title LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<ReviewBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String review_content = rs.getString(10);
				int review_DayCnt = rs.getInt(11);
				int hit = rs.getInt(12);
				reviewList.add(new ReviewBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, review_content, category, review_DayCnt, hit));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return reviewList;
	}
	
	public ReviewBean selectByCode(String codeN) {
		ReviewBean review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM REVIEW WHERE code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codeN);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String review_content = rs.getString(10);
				int review_DayCnt = rs.getInt(11);
				int hit = rs.getInt(12);
				review = new ReviewBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, review_content,category,review_DayCnt,hit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return review;
	}

	public boolean deleteReviewByCode(String code) {
		boolean delReviewOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM review where code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			res = pstmt.executeUpdate();
			if(res != 0) {
				System.out.println("占쏙옙占쏙옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
				delReviewOK = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return delReviewOK;
	}
	
	
	// display pcw
	public ArrayList<ReviewBean> selectAll(String category, String select) {
		ArrayList<ReviewBean> selectAll = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String paramSelect = select;
		if(paramSelect.equals("s1")){
			String sql = "SELECT  CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, REVIEW_CONTENT, REVIEW_DAYCNT, HIT   FROM REVIEW  WHERE CODE_CLASS='R' AND CATEGORY = ?";
			switch (category) {
			case "99":
				sql = "SELECT CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, REVIEW_CONTENT, REVIEW_DAYCNT, HIT   FROM REVIEW WHERE CATEGORY in ('asia','europe','oseania','america','africa') order by code";
				break;
			} 
	
			try {
				pstmt = conn.prepareStatement(sql);
				if (!(category.equals("99")))
					pstmt.setString(1, category);
				rs = pstmt.executeQuery();
	
				selectAll = new ArrayList<ReviewBean>();
				while (rs.next()) {
					String code_class = rs.getString(1);
					int WRITE_NO = rs.getInt(2);
					String code = rs.getString(3);
					String user_id = rs.getString(4);
					String main_title = rs.getString(5);
					String sdate = rs.getString(6);
					String edate = rs.getString(7);
					String CATEGORY = rs.getString(8);
					String banner_img = rs.getString(9);
					String review_content = rs.getString(10);
					int review_daycnt = rs.getInt(11);
					int hit = rs.getInt(12);
					
	
					selectAll.add(new ReviewBean( code_class,  WRITE_NO,  code,  user_id,  main_title,  sdate,
							 edate,  banner_img,  review_content, CATEGORY, review_daycnt, hit));
					System.out.println(sql);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		} else if(paramSelect.equals("s2")){
			String sql = "SELECT  CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, REVIEW_CONTENT, REVIEW_DAYCNT, HIT   FROM REVIEW  WHERE CODE_CLASS='R' AND CATEGORY = ?";
			
			switch (category) {
			case "99":
				sql = "SELECT CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, REVIEW_CONTENT, REVIEW_DAYCNT, HIT   FROM REVIEW WHERE CATEGORY in ('1','2','3','4','5') order by code desc ";
				break;
			}
	
			try {
				pstmt = conn.prepareStatement(sql);
				if (!(category.equals("99")))
					pstmt.setString(1, category);
				rs = pstmt.executeQuery();
	
				selectAll = new ArrayList<ReviewBean>();
				while (rs.next()) {
					String code_class = rs.getString(1);
					int WRITE_NO = rs.getInt(2);
					String code = rs.getString(3);
					String user_id = rs.getString(4);
					String main_title = rs.getString(5);
					String sdate = rs.getString(6);
					String edate = rs.getString(7);
					String CATEGORY = rs.getString(8);
					String banner_img = rs.getString(9);
					String review_content = rs.getString(10);
					int review_daycnt = rs.getInt(11);
					int hit = rs.getInt(12);
	
					selectAll.add(new ReviewBean( code_class,  WRITE_NO,  code,  user_id,  main_title,  sdate,
							 edate,  banner_img,  review_content, CATEGORY, review_daycnt, hit));
					System.out.println(sql);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		return selectAll;

	}

	public ArrayList<ReviewBean> getReviewlistQuery(String query) {
		String sql = "SELECT CODE,MAIN_TITLE,BANNER_IMG,HIT FROM REVIEW WHERE MAIN_TITLE like ? order by hit desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReviewBean> list = new ArrayList<ReviewBean>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewBean bean = new ReviewBean();
				bean.setCode(rs.getString("CODE"));
				bean.setMain_title(rs.getString("MAIN_TITLE"));
				bean.setBanner_img(rs.getString("BANNER_IMG"));
				bean.setHit(rs.getInt("HIT"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}
}
