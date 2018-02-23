package org.trippin.action.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.plan.PlanViewService;
import org.trippin.vo.PlanBean;

public class PlanUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String viewName = "WEB-INF/view/content/planUpdate.jsp";
		HttpSession session = req.getSession();
		ActionForward forward = null;
		PlanBean plan = null;
		String code = req.getParameter("code");
		PlanViewService planViewService = new PlanViewService();
		try {
			plan = planViewService.selectPlanByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(plan==null){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('조회실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			session.setAttribute("plan", plan);
			forward = new ActionForward(viewName, false);
		}
		return forward;
	}

}
