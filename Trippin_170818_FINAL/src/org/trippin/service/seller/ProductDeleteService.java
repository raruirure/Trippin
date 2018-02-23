package org.trippin.service.seller;

import java.sql.Connection;

import org.trippin.dao.ProductDao;
import org.trippin.db.JdbcUtil;

public class ProductDeleteService {

	public boolean setProductList(String[] pro_cd) {
		boolean isOk = false;
		ProductDao dao = ProductDao.getInstance();
		Connection conn = JdbcUtil.getConnection();
		dao.setConnection(conn);
		isOk = dao.setProductList(pro_cd);
		JdbcUtil.close(conn);
		return isOk;
	}

}
