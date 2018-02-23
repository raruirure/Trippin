package org.trippin.service.message;

import java.sql.Connection;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;

public class MessageReportDeleteService {

	public void DeleteReportMessage(String[] checkbox) {
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance();
		dao.setConnection(conn);
		
		for(int i=0; i<checkbox.length;i++){
			if(checkbox[i].equals("on")){
				return;
			}
			dao.DeleteReportMessage(checkbox[i]);
		}
		JdbcUtil.close(conn);
	}

	public void DeleteReportMessage(String idx) {
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance();
		dao.setConnection(conn);
		dao.DeleteReportMessage(idx);
		JdbcUtil.close(conn);
	}
}
