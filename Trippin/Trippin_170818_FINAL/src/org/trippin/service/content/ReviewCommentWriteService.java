package org.trippin.service.content;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ReviewCommentDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewCommentVo;
import org.trippin.vo.MemberVo;

public class ReviewCommentWriteService {
	public static void getProductReviewComment(ReviewCommentVo Rc_vo){
		Connection conn = JdbcUtil.getConnection();
		ReviewCommentDao dao = ReviewCommentDao.getInstance(); 
		dao.setConnection(conn);
		dao.insertReviewComment(Rc_vo);
		JdbcUtil.close(conn);
	}

	public int getReviewNum(String pro_cd) {
		Connection conn = JdbcUtil.getConnection();
		ReviewCommentDao dao = ReviewCommentDao.getInstance(); 
		dao.setConnection(conn);
		int num = dao.getReviewNum(pro_cd);
		JdbcUtil.close(conn);
		return num;
	}
	
}
