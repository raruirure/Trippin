package org.trippin.service.order;

import java.sql.Connection;

import org.trippin.dao.CartDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;

public class ProductPayService {

	public CartVo getCartByNo(int no) {
		CartVo cartVo = new CartVo();
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartVo = cartDao.selectByNo(no);
		
		JdbcUtil.close(conn);
		return cartVo;
	}

	public CartVo getProductByProCd(CartVo _cartVo) {
		CartVo cartVo = new CartVo();
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartVo = cartDao.selectByDetail(_cartVo); 
		
		JdbcUtil.close(conn);
		return cartVo;
	}

}
