package org.trippin.service.board;

import java.sql.Connection;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;

public class DeleteBoardService {

	public boolean deleteBoard(String write_no) {
		boolean isDeleteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		int deleteCount = boardDao.Delete_Board(write_no);
		
		if(deleteCount > 0) {
			isDeleteSuccess=true;
		} 
		
		JdbcUtil.close(conn);
		return isDeleteSuccess;
	}

}
