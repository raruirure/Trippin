package org.trippin.service.order;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.CartDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;
import org.trippin.vo.ProductVo;

public class ProductCartService {

	public ArrayList<CartVo> selectAllById(String user_id) {
		ArrayList<CartVo> cartList = null;
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		cartList=cartDao.selectAll(user_id);
		
		JdbcUtil.close(conn);
		return cartList;
	}

	public ProductVo selectByDetailCd(String pro_detail_cd) {
		ProductVo pVo = null;
		Connection conn = JdbcUtil.getConnection();
		CartDao cartDao = CartDao.getInstance();
		cartDao.setConnection(conn);
		
		//pVo = cartDao.selectByDetail(pro_detail_cd);
		
		JdbcUtil.close(conn);
		return pVo;
	}
}
