package org.trippin.service.location;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.trippin.dao.LocationDAO;
import org.trippin.dao.PlanDAO;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.LocationBean;
import org.trippin.vo.PlanBean;

public class CodeViewService {
	public LocationBean selectPlanByCode(String code){
		LocationBean loc = null;
		Connection conn = JdbcUtil.getConnection();
		LocationDAO locationDAO = LocationDAO.getInstance();
		locationDAO.setConnection(conn);
		
		loc = locationDAO.selectByCode(code);
		
		JdbcUtil.close(conn);
		return loc;
	}

	public boolean deleteByCode(String code) {
		boolean delLocOK = false;
		Connection conn = JdbcUtil.getConnection();
		LocationDAO locationDAO = LocationDAO.getInstance();
		locationDAO.setConnection(conn);
		delLocOK = locationDAO.deleteLocByCode(code);
		
		
		JdbcUtil.close(conn);
		return delLocOK;
	}
}
