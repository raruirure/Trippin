package org.trippin.service.plan;

import java.sql.Connection;

import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;

public class PlanUpdateService {
	public boolean UpdatePlan(PlanBean plan, String code) {
		boolean isUpdateSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		boolean updatePlan = planDAO.updatePlan(plan,code);
		
		if(updatePlan){
			isUpdateSuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isUpdateSuccess;
	}
}
