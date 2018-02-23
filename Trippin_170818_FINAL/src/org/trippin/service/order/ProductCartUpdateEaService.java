package org.trippin.service.order;

import java.sql.Connection;

import org.trippin.dao.CartDao;
import org.trippin.db.JdbcUtil;

public class ProductCartUpdateEaService {

	public void selectByProCd(int cart_no, int cart_ea) {
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartDao.updateCartEa(cart_no, cart_ea);
		
		JdbcUtil.close(conn);
		
	}

}
