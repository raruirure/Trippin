package org.trippin.action.mypage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.mypage.MypageSellerModifyService;
import org.trippin.service.mypage.MypageUserModifyService;
import org.trippin.vo.MemberVo;

public class MyPageAdminSuperviseSellerModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
		ActionForward forward = null;		
		boolean isModifySuccess = false;
		boolean isModifySuccess1 = false;
		
		MemberVo memberVo = new MemberVo();
		
		int selectState = Integer.parseInt(req.getParameter("selectState"));
		String userId = req.getParameter("USER_ID");
		int userOutCheck = Integer.parseInt(req.getParameter("selectOutCheck"));	
		memberVo.setSellerState(selectState);
		memberVo.setUserId(userId);
		memberVo.setUserOutCheck(userOutCheck);		
		
		
		System.out.println(userId);
		System.out.println(userOutCheck);
		System.out.println(selectState);
		
		MypageSellerModifyService mypageSellerModifyService = new MypageSellerModifyService();
		
		isModifySuccess =  mypageSellerModifyService.modifyMemSeller(memberVo);
		isModifySuccess1 = mypageSellerModifyService.modifySellerOk(memberVo);
				
		if(isModifySuccess){
			System.out.println("변경 완료");
		}else{
			System.out.println("실패");
		}
		if(isModifySuccess1){
			System.out.println("판매자 변경 완료");
		}else{
			System.out.println("실패");
		}
		
		
		forward = new ActionForward("admin_supervise.mypage", true);
		
		
		return forward;
	}

}
