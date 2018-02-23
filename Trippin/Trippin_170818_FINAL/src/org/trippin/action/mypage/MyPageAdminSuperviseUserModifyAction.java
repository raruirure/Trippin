package org.trippin.action.mypage;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.dao.MypageAdminDao;
import org.trippin.db.JdbcUtil;
import org.trippin.service.mypage.MypageUserModifyService;
import org.trippin.vo.MemberVo;

public class MyPageAdminSuperviseUserModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)throws IOException  {		
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		ActionForward forward = null;		
		boolean isModifySuccess = false;
		MemberVo memberVo = new MemberVo();
		
		String userId = req.getParameter("USER_ID");
		int userOutCheck = Integer.parseInt(req.getParameter("selectOutCheck"));
		
		
		memberVo.setUserId(userId);
		memberVo.setUserOutCheck(userOutCheck);
		System.out.println(userId);
		System.out.println(userOutCheck);
		
		MypageUserModifyService mypageUserModifyService = new MypageUserModifyService();
		
		isModifySuccess = mypageUserModifyService.modifyMemUser(memberVo);

		if(isModifySuccess){
			System.out.println("!!!");
		}else{
			System.out.println("222");
		}
		
		forward = new ActionForward("admin_supervise.mypage", true);
		
		
		

		return forward;
	}

}
