package org.trippin.service.order;

import java.sql.Connection;

import org.trippin.dao.CartDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;

public class ProductCartAddService {

	public void insertCartVo(CartVo cartVo) {
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartDao.insertCartVo(cartVo);
		
		JdbcUtil.close(conn);
	}

	public boolean getSearchByProCd(String pro_cd, String cartNum, String user_id) {
		boolean existInCart = false;
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		existInCart = cartDao.searchByProCd(pro_cd,cartNum,user_id);
		
		JdbcUtil.close(conn);
		return existInCart;
	}

	public void setUpdateCart(int cart_ea, String pro_cd, String cartNum, String user_id) {
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartDao.updateCartEa(cart_ea, pro_cd, cartNum, user_id);
		
		JdbcUtil.close(conn);
		
	}

	public CartVo getOptionInfo(String pro_cd, String cartNum) {
		CartVo cartVo = null;
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartVo = cartDao.selectByDInfo(pro_cd,cartNum);
		
		JdbcUtil.close(conn);
		return cartVo;
	}

}
