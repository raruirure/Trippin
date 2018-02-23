package org.trippin.service.order;

import java.sql.Connection;

import org.trippin.dao.CartDao;
import org.trippin.db.JdbcUtil;

public class mpCartDeleteService {

	public void deleteByNo(int no) {
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartDao.deleteByNo(no);
		
		JdbcUtil.close(conn);
	}

}
