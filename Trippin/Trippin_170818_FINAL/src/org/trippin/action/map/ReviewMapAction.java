package org.trippin.action.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class ReviewMapAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/map/ReviewMap.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
