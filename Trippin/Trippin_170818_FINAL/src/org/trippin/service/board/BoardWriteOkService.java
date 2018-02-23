package org.trippin.service.board;

import java.sql.Connection;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class BoardWriteOkService {

	public boolean boardWriteOk(BoardVo vo) {
		boolean isWriteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		BoardDao dao = BoardDao.getInstance();
		dao.setConnection(conn);
		
		int insertCount = dao.insert_Board(vo);
		
		if(insertCount > 0) {
			isWriteSuccess = true;
		}

		JdbcUtil.close(conn);	
		return isWriteSuccess;
	}

}
