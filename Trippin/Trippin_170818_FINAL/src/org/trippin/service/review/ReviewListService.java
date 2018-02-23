package org.trippin.service.review;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ReviewDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewBean;

public class ReviewListService {
	public ArrayList<ReviewBean> selectReviewById(String userId) {
		ArrayList<ReviewBean> reviewList = null;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		reviewList = reviewDAO.selectById(userId);
		
		JdbcUtil.close(conn);
		return reviewList;
	}
	public ArrayList<ReviewBean> selectReviewByKey(String keyword) {
		ArrayList<ReviewBean> reviewList = null;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		reviewList = reviewDAO.selectByKey(keyword);
		
		JdbcUtil.close(conn);
		return reviewList;
	}
	public ArrayList<ReviewBean> selectAllReview() {
		ArrayList<ReviewBean> reviewList = null;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		reviewList = reviewDAO.selectAll();
		
		JdbcUtil.close(conn);
		return reviewList;
	}
}
