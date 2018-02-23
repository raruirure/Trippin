package org.trippin.service.order;

import java.sql.Connection;

import org.trippin.dao.OrderDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.OrderVo;

public class PayOkService {

	public void setInsertPayOk(OrderVo payOkVo) {
		Connection conn = JdbcUtil.getConnection();
		OrderDao payokdao = OrderDao.getInstance();
		payokdao.setConnection(conn);
		
		payokdao.insertPayOk(payOkVo);
		
		JdbcUtil.close(conn);
	}

}
