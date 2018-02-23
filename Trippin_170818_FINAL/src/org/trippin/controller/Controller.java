package org.trippin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.ActionForward;

public class Controller extends HttpServlet {
	protected HttpSession session = null;
	protected ServletContext context = null;
	protected String makeCommand(HttpServletRequest req, HttpServletResponse resp) {
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String pattern = uri.substring(path.length());
		
		session = req.getSession();
		context = req.getServletContext();
		
		return pattern;
	}
	protected void forward(ActionForward forward, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		if(forward!=null) {
			if(forward.isRedirect()) {
				redirect(forward.getViewName(), resp);
			} else {
				RequestDispatcher view = req.getRequestDispatcher(forward.getViewName());
				view.forward(req, resp);
			}
		} else {
			context = req.getServletContext();
			redirect("index.html", resp);
		}
	}
	protected void redirect(String viewName, HttpServletResponse resp) throws IOException {
		resp.sendRedirect(viewName);
	}

}
