package org.trippin.service.mypage;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.MypageAdminDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MypageBlackService {

	public ArrayList<MemberVo> getBlackList() {
		Connection conn = JdbcUtil.getConnection();
		MypageAdminDao dao = MypageAdminDao.getInstance();
		dao.setConnection(conn);
		ArrayList<MemberVo> memUser = dao.selectByBlack();
		JdbcUtil.close(conn);
		
		return memUser;
	}

	

}
