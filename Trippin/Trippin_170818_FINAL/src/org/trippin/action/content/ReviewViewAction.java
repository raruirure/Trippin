package org.trippin.action.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.location.CodeViewService;
import org.trippin.service.review.ReviewViewService;
import org.trippin.vo.LocationBean;
import org.trippin.vo.ReviewBean;

public class ReviewViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String viewName = "WEB-INF/view/content/reviewView.jsp";
		HttpSession session = req.getSession();
		ActionForward forward = null;
		ReviewBean review = null;
		LocationBean loc = null;
		String code = req.getParameter("code");
		ReviewViewService reviewViewService = new ReviewViewService();
		CodeViewService codeViewService = new CodeViewService();
		try {
			review = reviewViewService.selectReviewByCode(code);
			loc = codeViewService.selectPlanByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(review==null){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('조회실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			session.setAttribute("review", review);
			session.setAttribute("loc", loc);
			forward = new ActionForward(viewName, false);
		}
		return forward;
	}

}
