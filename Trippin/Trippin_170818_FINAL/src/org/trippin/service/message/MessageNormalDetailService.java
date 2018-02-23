package org.trippin.service.message;

import java.sql.Connection;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageNormalDetailService {
	public MessageVo getMessageDetail(int idx){
		MessageVo vo = new MessageVo();
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance(); 
		dao.setConnection(conn); 
		
		vo = dao.getMessageDetail(idx);
		JdbcUtil.close(conn);
		return vo;
	}
}
