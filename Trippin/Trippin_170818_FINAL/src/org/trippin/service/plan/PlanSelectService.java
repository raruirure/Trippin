package org.trippin.service.plan;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;

public class PlanSelectService {
	public ArrayList<PlanBean> PlanListAll(String category, String select){
		ArrayList<PlanBean> selectAll = null;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO plandao = PlanDAO.getInstance();
		plandao.setConnection(conn);
		
		selectAll = plandao.selectListAll(category, select);
		
		JdbcUtil.close(conn);
		return selectAll;
		
	}
}
