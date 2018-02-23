package org.trippin.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.mypage.MypageSellerService;
import org.trippin.service.mypage.MypageUserService;
import org.trippin.vo.MemberVo;

public class MyPageAdminSuperviseSellerAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/mypage/mypage_admin_supervise_seller.jsp";
		ActionForward forward = null;
		
		ArrayList<MemberVo> sellerList = new ArrayList<MemberVo>();
		MypageSellerService mypageUserService = new MypageSellerService();
		
		sellerList = mypageUserService.getSellerList();
		req.setAttribute("sellerList", sellerList);
		forward = new ActionForward(viewName, false);
		
		return forward;
	}
	
	
}
