package org.trippin.action.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.message.MessageNormalDeleteService;
import org.trippin.service.message.MessageReportDeleteService;

public class MessageReportDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MessageReportDeleteService d_service = new MessageReportDeleteService();
		
		if(req.getParameterValues("mycheck")!=null){
			String[] checkbox = req.getParameterValues("mycheck");
			d_service.DeleteReportMessage(checkbox);
		} else{		
			if(req.getParameter("idx")!=null){
				String idx = req.getParameter("idx");
				d_service.DeleteReportMessage(idx);
			} else{
			
			}
		}
		
		String viewName = "reviewViewR.msg";
		ActionForward forward = null;
		forward = new ActionForward(viewName, true);
		return forward;				
	}

}
