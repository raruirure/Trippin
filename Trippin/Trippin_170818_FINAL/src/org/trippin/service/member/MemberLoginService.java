package org.trippin.service.member;

import java.sql.Connection;

import org.trippin.dao.MemberDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MemberLoginService {

	public MemberVo getMemberInfo(MemberVo member) {
		Connection conn = JdbcUtil.getConnection();
		MemberDao dao = MemberDao.getInstance();
		dao.setConnection(conn);
		MemberVo memLogin = dao.selectById(member.getUserId());
		if( memLogin!=null && member.getUserPass().equals(memLogin.getUserPass()) ) {
			if(memLogin.getUserOutCheck()==2) {
				return null;
			}
			if(memLogin.getUserLevel() == 2) {
				memLogin = dao.selectSellerInfo(memLogin);
			}
			return memLogin;
		}
		// user level
		// user Name
		// user image
		return null;
	}
	
}
