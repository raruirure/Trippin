package org.trippin.action.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.message.MessageReportDetailService;
import org.trippin.vo.MessageVo;

public class MessageReportDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MessageReportDetailService message_service = new MessageReportDetailService();
		
		int idx = Integer.parseInt(req.getParameter("idx").toString());
		MessageVo message_vo = message_service.getMessageDetail(idx);
		req.setAttribute("messageRDetail", message_vo);
		
		String viewName = "popup/message_report_content.jsp";
		ActionForward forward = null;
		forward = new ActionForward(viewName, false);
		return forward;		
	}

}
