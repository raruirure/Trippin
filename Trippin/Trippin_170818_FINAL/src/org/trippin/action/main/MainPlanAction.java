package org.trippin.action.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.plan.PlanSelectService;
import org.trippin.vo.PlanBean;

public class MainPlanAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String viewName = "WEB-INF/view/search/resultNation_plan.jsp";
		ActionForward forward = null;
		ArrayList<PlanBean> plan = null;
		
		
		String category = "99";
		if(req.getParameter("category") !=null){
			category = req.getParameter("category");
		}
		
		String select = "s1";
		if(req.getParameter("select") !=null){
			select = req.getParameter("select");
		}
		
		
		PlanSelectService pss = new PlanSelectService();
		
		try {
			plan = pss.PlanListAll(category, select);
			if(plan==null){
				 resp.setContentType("text/html;charset=UTF-8");
			     PrintWriter out = resp.getWriter();
			     out.println("<script>");
			     out.println("alert('議고쉶�떎�뙣')");
			     out.println("history.back();");
			     out.println("</script>");
			} else {
				session.setAttribute("plan", plan);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
