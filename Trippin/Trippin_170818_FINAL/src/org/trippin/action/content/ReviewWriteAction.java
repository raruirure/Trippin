package org.trippin.action.content;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class ReviewWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/content/reviewWrite.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
