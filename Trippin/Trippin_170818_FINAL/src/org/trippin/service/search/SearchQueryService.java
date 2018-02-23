package org.trippin.service.search;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.PlanDAO;
import org.trippin.dao.ProductDao;
import org.trippin.dao.ReviewDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;
import org.trippin.vo.ProductVo;
import org.trippin.vo.ReviewBean;

public class SearchQueryService {

	public ArrayList<ArrayList> getQueryResultslist(String query) {
		ArrayList<ArrayList> main_search_list = new ArrayList<ArrayList>();
		
		Connection conn = JdbcUtil.getConnection();
		/* �썑湲�, 怨꾪쉷, �긽�뭹 �닚�쑝濡� 由ъ뒪�듃 異쒕젰 */
		ReviewDAO reviewdao = ReviewDAO.getInstance();
		reviewdao.setConnection(conn);
		ArrayList<ReviewBean> reviewlist = reviewdao.getReviewlistQuery(query);
		if(!reviewlist.isEmpty()) {
			System.out.println("후기 검색 결과");
			main_search_list.add(reviewlist);
		}
		
		PlanDAO plandao = PlanDAO.getInstance();
		plandao.setConnection(conn);
		ArrayList<PlanBean> planlist = plandao.getPlanlistQuery(query);
		if(!planlist.isEmpty()) {
			System.out.println("계획 검색 결과");
			main_search_list.add(planlist);
		}
		
		ProductDao productDao = ProductDao.getInstance();
		productDao.setConnection(conn);
		ArrayList<ProductVo> productlist = productDao.getProductListQuery(query);
		if(!productlist.isEmpty()) {
			System.out.println("상품 검색 결과");
			main_search_list.add(productlist);
		}
		JdbcUtil.close(conn);
		if(main_search_list.isEmpty()) {
			main_search_list = null;
		}
		return main_search_list;
	}

}
