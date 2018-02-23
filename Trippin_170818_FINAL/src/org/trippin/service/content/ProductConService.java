package org.trippin.service.content;

import java.sql.Connection;

import org.trippin.dao.ProductDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.ProductVo;

public class ProductConService {

	public ProductVo getProductCon(String pro_cd) {
		ProductVo proContent = null;
		
		Connection conn = JdbcUtil.getConnection();
		ProductDao dao = ProductDao.getInstance();
		dao.setConnection(conn);
		proContent = dao.getProductCon(pro_cd);
		if( proContent.getPro_display()==1)  {
			dao.setProductHit(proContent.getPro_cd());
		}
		JdbcUtil.close(conn);
		return proContent;
	}

}
