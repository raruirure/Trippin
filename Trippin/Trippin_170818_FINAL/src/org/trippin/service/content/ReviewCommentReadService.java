package org.trippin.service.content;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ReviewCommentDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ReviewCommentVo;

public class ReviewCommentReadService {
	public ArrayList<ReviewCommentVo> getCommentReviewAll(String pro_cd){
		Connection conn = JdbcUtil.getConnection();
		ReviewCommentDao dao = ReviewCommentDao.getInstance(); 
		dao.setConnection(conn);
		ArrayList<ReviewCommentVo> review_list=dao.SelectAll(pro_cd);
		JdbcUtil.close(conn);
		return review_list;
	}
}