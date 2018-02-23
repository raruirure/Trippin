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

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String viewName = "WEB-INF/view/mypage/mypage_main.jsp";
		ActionForward forward = null;
		boolean delReviewOK = false;
		boolean delLocOK = false;
		String code = req.getParameter("code");
		ReviewViewService reviewViewService = new ReviewViewService();
		CodeViewService codeViewService = new CodeViewService();
		try {
			delReviewOK = reviewViewService.deleteReviewByCode(code);
			delLocOK = codeViewService.deleteByCode(code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!delReviewOK){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward("go.mypage", true);
		}
		return forward;
	}

}
