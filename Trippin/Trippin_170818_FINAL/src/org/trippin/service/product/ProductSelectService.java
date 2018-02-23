package org.trippin.service.product;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.ProductDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ProductVo;

public class ProductSelectService {
	public ArrayList<ProductVo> ProductListAll(String category, String select) throws Exception{
		
		ArrayList<ProductVo> selectAll = null;
		Connection conn = JdbcUtil.getConnection();
		ProductDao productDAO = ProductDao.getInstance();
		productDAO.setConnection(conn);
		selectAll = productDAO.selectAll(category, select);

		JdbcUtil.close(conn);
		return selectAll;	
	}
public ArrayList<ProductVo> ProductListByKey(String keyword) throws Exception{
		
		ArrayList<ProductVo> selectAll = null;
		Connection conn = JdbcUtil.getConnection();
		ProductDao productDAO = ProductDao.getInstance();
		productDAO.setConnection(conn);
		selectAll = productDAO.selectByKey(keyword);

		JdbcUtil.close(conn);
		return selectAll;	
	}	
}
