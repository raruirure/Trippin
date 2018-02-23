package org.trippin.service.mypage;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.MypageAdminDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MypageSellerModifyService {

	public boolean modifyMemSeller(MemberVo memberVo) {
		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MypageAdminDao dao = MypageAdminDao.getInstance();
		dao.setConnection(conn);
		
		int modifyCount = dao.modifySellerMem(memberVo);
		
		if(modifyCount > 0){
			isModifySuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isModifySuccess;
	}

	public boolean modifySellerOk(MemberVo memberVo) {
		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MypageAdminDao dao = MypageAdminDao.getInstance();
		dao.setConnection(conn);
		
		int modifyCount = dao.modifySellerOk(memberVo);
		
		if(modifyCount > 0){
			isModifySuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isModifySuccess;
	}
	

	
}
