package org.trippin.service.plan;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;

public class PlanListService {
	public ArrayList<PlanBean> selectPlanById(String userId) {
		ArrayList<PlanBean> planList = null;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		planList = planDAO.selectById(userId);
		
		JdbcUtil.close(conn);
		return planList;
	}
	public ArrayList<PlanBean> selectPlanByKey(String keyword) {
		ArrayList<PlanBean> planList = null;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		planList = planDAO.selectByKey(keyword);
		
		JdbcUtil.close(conn);
		return planList;
	}
	public ArrayList<PlanBean> selectAllPlan() {
		ArrayList<PlanBean> planList = null;
		Connection conn = JdbcUtil.getConnection();
		PlanDAO planDAO = PlanDAO.getInstance();
		planDAO.setConnection(conn);
		planList = planDAO.selectAll();
		
		JdbcUtil.close(conn);
		return planList;
	}
}
