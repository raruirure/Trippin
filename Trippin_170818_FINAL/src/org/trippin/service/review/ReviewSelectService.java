package org.trippin.service.review;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ReviewDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewBean;

public class ReviewSelectService {
	public ArrayList<ReviewBean> ReviewListAll(String category, String select) throws Exception{
		ArrayList<ReviewBean> selectAll = null; 
		Connection conn = JdbcUtil.getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(conn);
		//reveiw page display
		selectAll = reviewDAO.selectAll(category, select);
		
		JdbcUtil.close(conn);
		return selectAll;
	}
}
