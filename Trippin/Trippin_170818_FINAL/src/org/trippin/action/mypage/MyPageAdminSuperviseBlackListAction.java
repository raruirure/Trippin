package org.trippin.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.mypage.MypageBlackService;
import org.trippin.service.mypage.MypageUserService;
import org.trippin.vo.MemberVo;

public class MyPageAdminSuperviseBlackListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/mypage/mypage_admin_supervise_blacklist.jsp";
		ActionForward forward = null;
		
		ArrayList<MemberVo> blackList = new ArrayList<MemberVo>();
		MypageBlackService  mypageblackService = new MypageBlackService();
		
		blackList = mypageblackService.getBlackList();
		req.setAttribute("blackList", blackList);
		
		
		
		forward = new ActionForward(viewName, false);
		
		return forward;
	}
	
	
}
