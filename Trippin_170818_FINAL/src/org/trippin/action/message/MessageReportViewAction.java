package org.trippin.action.message;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.message.MessageReportViewService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.MessageVo;

public class MessageReportViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		
		MessageReportViewService service_message_read = new MessageReportViewService();
		
		ArrayList<MessageVo> message_listR = service_message_read.getMessageReportAll();
		if(message_listR!=null){
			req.setAttribute("message_listR", message_listR);
		}		
		
		String viewName = "popup/message_report.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;		
	}

}
