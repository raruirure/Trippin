package org.trippin.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class MemberLogoutAction implements Action {
	HttpSession session = null;
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/main.jsp";
		ActionForward forward = null;
		session = req.getSession();
		session.removeAttribute("member");
		session.removeAttribute("cartList");
		forward = new ActionForward(viewName, false);
		return forward;
	}
}