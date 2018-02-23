package org.trippin.service.plan;

import java.sql.Connection;

import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;

public class PlanViewService {
	public PlanBean selectPlanByCode(String code) throws Exception{
		PlanBean plan = null;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		plan = planDAO.selectByCode(code);
		
		
		JdbcUtil.close(conn);
		return plan;
	}

	public boolean deletePlanByCode(String code) {
		boolean delPlanOK = false;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		delPlanOK = planDAO.deletePlanByCode(code);
		
		
		JdbcUtil.close(conn);
		return delPlanOK;
	}
}
