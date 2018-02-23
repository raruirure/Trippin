package org.trippin.action.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.plan.PlanListService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.PlanBean;

public class MyPagePlanAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String viewName = "WEB-INF/view/mypage/mypage_trip_plan.jsp";
		HttpSession session = req.getSession(); 
		ActionForward forward = null;
		PlanListService planListService = new PlanListService();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		String userId = vo.getUserId();
		ArrayList<PlanBean> planList = null;
		try {
			planList = planListService.selectPlanById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(planList==null){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('Á¶È¸½ÇÆÐ')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			if(session.getAttribute("planList")!=null) {
				session.removeAttribute("planList");
			}
			session.setAttribute("planList", planList);
			forward = new ActionForward(viewName, false);
		}
		
		return forward;
	}
}
