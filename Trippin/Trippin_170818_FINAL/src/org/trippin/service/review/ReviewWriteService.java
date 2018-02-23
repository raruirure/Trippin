package org.trippin.service.review;

import java.sql.Connection;

import org.trippin.dao.ReviewDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewBean;

public class ReviewWriteService {
	public boolean registReview(ReviewBean review) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		boolean insertReviewCommon = reviewDAO.insertReviewCommon(review);
		
		if(insertReviewCommon){
			isWriteSuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isWriteSuccess;
		
	}

	public int getCount() {
		int reviewCount = 0;
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		
		reviewCount = reviewDAO.getCount();
		
		return reviewCount;
	}
}
