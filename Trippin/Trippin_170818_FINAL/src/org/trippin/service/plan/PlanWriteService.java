package org.trippin.service.plan;

import java.sql.Connection;

import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;

public class PlanWriteService {
	public boolean registPlan(PlanBean plan) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		boolean insertPlanCommon = planDAO.insertPlanCommon(plan);
		
		if(insertPlanCommon){
			isWriteSuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isWriteSuccess;
		
	}

	public int getCount() {
		int planCount = 0;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		
		planCount = planDAO.getCount();
		
		return planCount;
	}
}
