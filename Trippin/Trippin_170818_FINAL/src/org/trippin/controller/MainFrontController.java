package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.main.MainPlanAction;
import org.trippin.action.main.MainProductAction;
import org.trippin.action.main.MainReviewAction;
import org.trippin.action.main.MainStartAction;
import org.trippin.action.search.ResultMainMapAction;
import org.trippin.action.search.ResultMapAction;
import org.trippin.action.search.SearchResultAction;


@WebServlet("*.main")
public class MainFrontController extends Controller{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/intro.main".equals(command)) {
			action = new MainStartAction();
		} else if("/review.main".equals(command)) {
			action = new MainReviewAction();
		} else if("/plan.main".equals(command)) {
			action = new MainPlanAction();
		} else if("/product.main".equals(command)) {
			action = new MainProductAction();
		} else if("/search.main".equals(command)) {
			action = new SearchResultAction();
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
