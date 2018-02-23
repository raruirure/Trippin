package org.trippin.action.mypage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.mypage.MypageBlackModifyService;
import org.trippin.vo.MemberVo;

public class MyPageAdminSuperviseBlackListModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		ActionForward forward = null;		
		boolean isModifySuccess = false;
		MemberVo memberVo = new MemberVo();
		
		String blackUser = req.getParameter("USER_ID");
		int userOutCheck = Integer.parseInt(req.getParameter("selectOutCheck"));
		
		memberVo.setUserId(blackUser);
		memberVo.setUserOutCheck(userOutCheck);
		System.out.println(blackUser);
		System.out.println(userOutCheck);
		
		MypageBlackModifyService mypageBlackModifyService = new MypageBlackModifyService();
		
		isModifySuccess = mypageBlackModifyService.modifyMemBlack(memberVo);
		
		if(isModifySuccess){
			System.out.println("!!!");
		}else{
			System.out.println("222");
		}
		
		forward = new ActionForward("admin_supervise.mypage", true);
		
		return forward;
	}

}
