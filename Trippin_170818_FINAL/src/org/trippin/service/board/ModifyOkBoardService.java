package org.trippin.service.board;

import java.sql.Connection;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class ModifyOkBoardService {

	public boolean modifyBoard(BoardVo boardVo) {
		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		int modifyCount = boardDao.modify_Board(boardVo);
		
		if(modifyCount > 0) {
			isModifySuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isModifySuccess;
	}

}
