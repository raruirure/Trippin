package org.trippin.action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.member.MemberJoinService;
import org.trippin.vo.MemberVo;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		String[] eleName = {
				"user_level", "join_userId", "join_userName", "join_userPwd", "join_userBirthday",
				"join_sellerNumber"};
		String[] inputVal = new String[6];
		MemberJoinService service = new MemberJoinService();
		
		for(int i=0; i<eleName.length; i++) {
			inputVal[i] = new String(req.getParameter(eleName[i]).getBytes("ISO-8859-1"), "UTF-8");
			if(inputVal[0].equals("1") && i==eleName.length-2) {
				break;
			}
		}
		MemberVo member = new MemberVo(Integer.parseInt(inputVal[0]), inputVal[1], inputVal[2], inputVal[3], inputVal[4], inputVal[5]);
		boolean isOk = service.setMember(member);
		//req.setAttribute("joinSuccess", isOk);
		ActionForward forward = new ActionForward("intro.main", true);
		return forward;
	}

}
