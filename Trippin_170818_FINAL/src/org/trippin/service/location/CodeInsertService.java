package org.trippin.service.location;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.LocationDAO;
import org.trippin.db.JdbcUtil;

public class CodeInsertService {
	public boolean insertCode(String code, ArrayList<String> codeList, String sql) {
		boolean isInsertSuccess = false;
		Connection conn = JdbcUtil.getConnection();
		LocationDAO locationDAO = LocationDAO.getInstance();
		locationDAO.setConnection(conn);
		boolean locInsert = locationDAO.insertCode(code,codeList,sql);
		
		if(locInsert){
			isInsertSuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isInsertSuccess;		
	}
}
