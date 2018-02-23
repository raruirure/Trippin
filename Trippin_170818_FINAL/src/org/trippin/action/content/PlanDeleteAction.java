package org.trippin.action.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.location.CodeViewService;
import org.trippin.service.plan.PlanViewService;
import org.trippin.vo.LocationBean;
import org.trippin.vo.PlanBean;

public class PlanDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String viewName = "WEB-INF/view/mypage/mypage_trip_plan.jsp";
		ActionForward forward = null;
		boolean delPlanOK = false;
		boolean delLocOK = false;
		String code = req.getParameter("code");
		PlanViewService planViewService = new PlanViewService();
		CodeViewService codeViewService = new CodeViewService();
		try {
			delPlanOK = planViewService.deletePlanByCode(code);
			delLocOK = codeViewService.deleteByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!delPlanOK){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward("user_plan.mypage", true);
		}
		return forward;
	}
}
