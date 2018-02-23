package org.trippin.action.message;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.vo.MemberVo;
import org.trippin.vo.MessageVo;
import org.trippin.service.message.MessageReportWriteService;

public class MessageReportWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		MessageReportWriteService message_service = new MessageReportWriteService();
		HttpSession session = req.getSession();
		MemberVo member_vo = (MemberVo)session.getAttribute("member");
		
		String title = req.getParameter("title");
		String register = req.getParameter("register");
		String content = req.getParameter("content");
		String board = req.getParameter("board");
		String address = req.getParameter("address");
		String viewName="";
		
		// 0 遺�遺꾩� Write_no濡� �닔�젙 �븘�슂.
		MessageVo msg_vo = new MessageVo();
		msg_vo.setTitle(title);
		msg_vo.setSend_user_id(member_vo.getUserId());
		System.out.println(member_vo.getUserId());
		msg_vo.setRes_user_id(register);
		msg_vo.setMessage_content(content);
		msg_vo.setWrite_class(board);
		msg_vo.setWrite_address(address);
		// �궡�슜 �냼�솚
		int res = message_service.setReportMessage(msg_vo);
		
		if(member_vo.getUserLevel()!=3){
			viewName = "reviewViewN.msg";
		}else{
			viewName = "reviewViewR.msg";
		}
		ActionForward forward = null;
		forward = new ActionForward(viewName, true);
		return forward;
	}
}
