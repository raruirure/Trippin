package org.trippin.action.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.dao.MemberDao;
import org.trippin.dao.MemberModifyDao;
import org.trippin.db.JdbcUtil;
import org.trippin.service.mypage.MypageModifyService;
import org.trippin.vo.MemberVo;

public class MyPageDropAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		MypageModifyService service = new MypageModifyService();
		ActionForward forward = null;
		int result = 0;
		
		
		String userId = "";
		int num = Integer.parseInt(req.getParameter("drop"));
		
		MemberVo vo = (MemberVo) session.getAttribute("member");
		
		MemberModifyDao member = MemberModifyDao.getInstance();
		
		Connection conn = JdbcUtil.getConnection();
		member.setConnection(conn);
		
		vo.setUserId(vo.getUserId());
		
		result = member.dropMember(vo);
		session.invalidate();
		JdbcUtil.close(conn);
		
		forward = new ActionForward("intro.main", true);
		return forward;
		
	}

}
