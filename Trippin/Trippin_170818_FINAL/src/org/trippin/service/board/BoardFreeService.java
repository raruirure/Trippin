package org.trippin.service.board;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class BoardFreeService {

	public ArrayList<BoardVo> getBoardFreeList(String code_key, int page, int limit, String fBSSelect, String fBSText) {
		ArrayList<BoardVo> boardList = null;
		
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		boardList = boardDao.selectAll(code_key, page, limit, fBSSelect, fBSText);
		
		JdbcUtil.close(conn);
		return boardList;
	}
	
	public int getListCount(String code_key, String fBSSelect, String fBSText) throws Exception{		
		
		int listCount = 0;
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		listCount = boardDao.selectListCount(code_key, fBSSelect, fBSText);
		
		JdbcUtil.close(conn);
		return listCount;
		
	}

}
