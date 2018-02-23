package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.content.PlanDeleteAction;
import org.trippin.action.content.PlanUpdateAction;
import org.trippin.action.content.PlanUpdateOKAction;
import org.trippin.action.content.PlanViewAction;
import org.trippin.action.content.PlanWriteAction;
import org.trippin.action.content.PlanWriteOKAction;
import org.trippin.action.content.ProductConAction;
import org.trippin.action.content.ReviewCommentWriteAction;
import org.trippin.action.content.ReviewDeleteAction;
import org.trippin.action.content.ReviewViewAction;
import org.trippin.action.content.ReviewWriteAction;
import org.trippin.action.content.ReviewWriteOKAction;
import org.trippin.action.main.MainStartAction;

@WebServlet("*.con")
public class ContentFrontController extends Controller{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/reviewView.con".equals(command)) {
			action = new ReviewViewAction();
		} else if("/reviewWrite.con".equals(command)) {
			action = new ReviewWriteAction();
		} else if("/reviewWrite_ok.con".equals(command)) {
			action = new ReviewWriteOKAction();
		} else if("/reviewDelete.con".equals(command)) {
			action = new ReviewDeleteAction();
		} else if("/planView.con".equals(command)) {
			action = new PlanViewAction();
		} else if("/planWrite.con".equals(command)) {
			action = new PlanWriteAction();
		} else if("/planWrite_ok.con".equals(command)) {
			action = new PlanWriteOKAction();
		} else if("/planDelete.con".equals(command)) {
			action = new PlanDeleteAction();
		} else if("/planUpdate.con".equals(command)) {
			action = new PlanUpdateAction();
		} else if("/planUpdate_ok.con".equals(command)) {
			action = new PlanUpdateOKAction();
		} else if("/ContentReviewWrite.con".equals(command)){
			action = new ReviewCommentWriteAction();
		} else if("/productDetail.con".equals(command)) {
			action = new ProductConAction();
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
