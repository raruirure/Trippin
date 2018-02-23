package org.trippin.action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.member.MemberLoginService;
import org.trippin.vo.MemberVo;

public class MemberLoginAction implements Action {
	HttpSession session = null;
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = null;
		MemberLoginService service = new MemberLoginService();
		MemberVo member = new MemberVo();
		
		String userId = req.getParameter("userId");
		String userPass = req.getParameter("userPwd");
		member.setUserId(userId);
		member.setUserPass(userPass);
		
		MemberVo loginMem = service.getMemberInfo(member); // service 에서 db로 연결할 것 처리
		if(loginMem != null){
			session = req.getSession();
			session.setAttribute("member", loginMem);
		}
		forward = new ActionForward("intro.main", true);
		return forward;
	}
}