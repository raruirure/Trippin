package org.trippin.service.mypage;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.MypageAdminDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MypageUserModifyService {	

	public boolean modifyMemUser(MemberVo memberVo) {
		
		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MypageAdminDao dao = MypageAdminDao.getInstance();
		dao.setConnection(conn);
		
		int modifyCount = dao.modifyUserMem(memberVo);
		
		if(modifyCount > 0){
			isModifySuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isModifySuccess;
	}

	
}
