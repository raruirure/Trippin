package org.trippin.service.board;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class BoardNoticeService {

	public ArrayList<BoardVo> getBoardNoticeList(String code_key, int page, int limit, String nBSSelect, String nBSText) {
		ArrayList<BoardVo> boardList = null;
		
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		boardList = boardDao.selectAll(code_key, page, limit, nBSSelect, nBSText);
		
		JdbcUtil.close(conn);
		return boardList;
	}

	public int getListCount(String code_key, String nBSSelect, String nBSText) {
		int listCount = 0;
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		listCount = boardDao.selectListCount(code_key, nBSSelect, nBSText);
		
		JdbcUtil.close(conn);
		return listCount;
	}

}
