package org.trippin.service.message;

import java.sql.Connection;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageReportWriteService {
	public int setReportMessage(MessageVo message_vo){
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance();
		dao.setConnection(conn);
		int res = dao.SendReportMessage(message_vo);
		JdbcUtil.close(conn);
		return res;
	}
}
