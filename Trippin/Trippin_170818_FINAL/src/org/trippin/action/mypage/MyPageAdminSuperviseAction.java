package org.trippin.action.mypage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class MyPageAdminSuperviseAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/mypage/mypage_admin_supervise.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		
		return forward;
	}
	
	
}
