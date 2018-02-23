package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.member.MemberJoinAction;
import org.trippin.action.member.MemberLoginAction;
import org.trippin.action.member.MemberLogoutAction;

@WebServlet("*.member")
public class MemberFrontController extends Controller{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/logout.member".equals(command)) {
			action = new MemberLogoutAction();
		} else if("/login.member".equals(command)){
			action = new MemberLoginAction();
		} else if("/join.member".equals(command)) {
			action = new MemberJoinAction();
		}
		actionforward = action.execute(req, resp);
		forward(actionforward, req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
