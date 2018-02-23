package org.trippin.action.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class MessageToNWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp){
		String viewName = "popup/message_write.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;		
	}

}
