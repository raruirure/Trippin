package org.trippin.action.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.review.ReviewListService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ReviewBean;

public class MyPageReViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)  throws IOException{
		String viewName = "WEB-INF/view/mypage/mypage_main.jsp";
		HttpSession session = req.getSession(); 
		ActionForward forward = null;
		ReviewListService reviewListService = new ReviewListService();
		MemberVo vo = (MemberVo)session.getAttribute("member");
		String userId = vo.getUserId();
		ArrayList<ReviewBean> reviewList = null;
		try {
			reviewList = reviewListService.selectReviewById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(reviewList==null){
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('Á¶È¸½ÇÆÐ')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			if(session.getAttribute("reviewList")!=null) {
				session.removeAttribute("reviewList");
			}
			session.setAttribute("reviewList", reviewList);
			forward = new ActionForward(viewName, false);
		}
		
		return forward;
	}
}