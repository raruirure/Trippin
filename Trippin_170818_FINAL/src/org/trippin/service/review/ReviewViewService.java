package org.trippin.service.review;

import java.sql.Connection;

import org.trippin.dao.PlanDAO;
import org.trippin.dao.ReviewDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewBean;

public class ReviewViewService {
	public ReviewBean selectReviewByCode(String code) throws Exception{
		ReviewBean review = null;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		review = reviewDAO.selectByCode(code);
		
		
		JdbcUtil.close(conn);
		return review;
	}

	public boolean deleteReviewByCode(String code) {
		boolean delReviewOK = false;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		delReviewOK = reviewDAO.deleteReviewByCode(code);
		
		
		JdbcUtil.close(conn);
		return delReviewOK;
	}
}
