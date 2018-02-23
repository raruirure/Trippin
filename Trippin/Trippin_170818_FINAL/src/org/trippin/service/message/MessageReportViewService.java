package org.trippin.service.message;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageReportViewService {
	public ArrayList<MessageVo> getMessageReportAll(){
		ArrayList<MessageVo> message_list = null;
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance(); 
		dao.setConnection(conn); 
		
		message_list = dao.getMessageReportAll();
		JdbcUtil.close(conn);
		return message_list;
	}
}
