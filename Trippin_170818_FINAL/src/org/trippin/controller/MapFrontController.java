package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.map.ResultMainMapAction;
import org.trippin.action.map.ResultMapAction;
import org.trippin.action.map.ReviewMapAction;
import org.trippin.action.map.ViewMapAction;


@WebServlet("*.map")
public class MapFrontController extends Controller{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/showMap.map".equals(command)) {
			action = new ResultMapAction();
		} else if("/showMainMap.map".equals(command)) {
			action = new ResultMainMapAction();
		} else if("/showViewMap.map".equals(command)) {
			action = new ViewMapAction();
		} else if("/showReviewMap.map".equals(command)) {
			action = new ReviewMapAction();
		} else {
			action = new ResultMapAction();
		}
		actionforward = action.execute(req, resp);
		forward(actionforward, req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
