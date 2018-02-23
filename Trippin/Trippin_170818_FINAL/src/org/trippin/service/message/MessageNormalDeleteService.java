package org.trippin.service.message;

import java.sql.Connection;

import org.trippin.dao.MessageDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MessageVo;

public class MessageNormalDeleteService {
	public void DeleteNormalMessage(String[] checkbox){
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance();
		dao.setConnection(conn);
		
		for(int i=0; i<checkbox.length;i++){
			if(checkbox[i].equals("on")){
				return;
			}
			dao.DeleteNormalMessage(checkbox[i]);
		}
		JdbcUtil.close(conn);
	}

	public void DeleteNormalMessage(String idx) {
		Connection conn = JdbcUtil.getConnection();
		MessageDao dao = MessageDao.getInstance();
		dao.setConnection(conn);
		dao.DeleteNormalMessage(idx);
		JdbcUtil.close(conn);
	}
}
