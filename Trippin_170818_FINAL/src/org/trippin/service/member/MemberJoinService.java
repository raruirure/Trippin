package org.trippin.service.member;

import java.sql.Connection;

import org.trippin.dao.MemberDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.MemberVo;

public class MemberJoinService {
	public boolean setMember(MemberVo member) {
		boolean isOk = false;
		Connection conn = JdbcUtil.getConnection();
		MemberDao dao = MemberDao.getInstance();
		dao.setConnection(conn);
		isOk = dao.setTRMember(member);
		if(isOk && member.getUserLevel() == 2) {
			isOk = dao.setTRMemberSeller(member);
		}
		JdbcUtil.close(conn);
		return isOk;
	}
}
