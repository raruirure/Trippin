package org.trippin.service.message;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageNormalViewService {
	public ArrayList<MessageVo> getMessageNormalAll(String userid){
		ArrayList<MessageVo> message_list = null;
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance(); 
		dao.setConnection(conn); 
		System.out.println(userid);
		message_list = dao.getMessageNormalAll(userid);
		JdbcUtil.close(conn);
		return message_list;
	}
}
