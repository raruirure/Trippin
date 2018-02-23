package org.trippin.action.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.message.MessageNormalWriteService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.MessageVo;


public class MessageNormalWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MessageNormalWriteService message_service = new MessageNormalWriteService();
		HttpSession session = req.getSession();
		MemberVo member_vo = (MemberVo)session.getAttribute("member");
		String title = req.getParameter("title");
		String responser = req.getParameter("responser");
		String content = req.getParameter("content");
		String viewName="";
		
		MessageVo msg_vo = new MessageVo();
		msg_vo.setTitle(title);
		msg_vo.setSend_user_id(member_vo.getUserId());
		msg_vo.setRes_user_id(responser);
		msg_vo.setMessage_content(content);
		// �궡�슜 �냼�솚
		int res = message_service.setNormalMessage(msg_vo);
		if(member_vo.getUserLevel()!=4){
			viewName = "reviewViewN.msg";
		}else{
			viewName = "reviewViewR.msg";
		}
		ActionForward forward = null;
		forward = new ActionForward(viewName, true);
		return forward;
	}
}