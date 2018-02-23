package org.trippin.service.seller;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ProductDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ProductVo;

public class SellerProManagerService {

	public ArrayList<ProductVo> getProductList(String seller_id) {
		ArrayList<ProductVo> proList = null;
		Connection conn = JdbcUtil.getConnection();
		ProductDao dao = ProductDao.getInstance();
		dao.setConnection(conn);
		proList = dao.getProductList(seller_id);
		JdbcUtil.close(conn);
		return proList;
	}

}
