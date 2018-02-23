package org.trippin.service.board;

import java.sql.Connection;

import org.trippin.dao.BoardDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.BoardVo;

public class BoardFreeDetailService {

	public BoardVo getFreeDetail(String write_no) {
		BoardVo boardVo = null;
		Connection conn = JdbcUtil.getConnection();
		BoardDao boardDao = BoardDao.getInstance();
		boardDao.setConnection(conn);
		
		// 조회수 업데이트
		int updateCount = boardDao.updateReadCount(write_no);
		
		if(updateCount > 0) {
			System.out.println(">>>>>>>>>>조회수 업데이트 성공");
		}else {

			System.out.println(">>>>>>>>>>조회수 업데이트 실패");
		}
		boardVo = boardDao.seletByWriteNo(write_no);
		JdbcUtil.close(conn);
		
		return boardVo;
	}

	

}
