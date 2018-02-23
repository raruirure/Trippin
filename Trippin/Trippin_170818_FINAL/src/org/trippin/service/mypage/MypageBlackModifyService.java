package org.trippin.service.mypage;

import java.sql.Connection;

import org.trippin.dao.MypageAdminDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MypageBlackModifyService {

	public boolean modifyMemBlack(MemberVo memberVo) {
		boolean isModifySuccess = false;
		Connection conn = JdbcUtil.getConnection();
		MypageAdminDao dao = MypageAdminDao.getInstance();
		dao.setConnection(conn);
		
		int modifyCount = dao.modifyBlackMem(memberVo);
		
		if(modifyCount > 0){
			isModifySuccess = true;
		}
		
		JdbcUtil.close(conn);
		return isModifySuccess;
	}

}
