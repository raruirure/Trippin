package org.trippin.action.main;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.review.ReviewListService;
import org.trippin.service.review.ReviewSelectService;
import org.trippin.vo.ReviewBean;

public class MainReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String viewName = "WEB-INF/view/search/resultNation_review.jsp";
		ActionForward forward = null;
		ArrayList<ReviewBean> review = null;
		
		
		
		//��瑜� category parameter �솗�씤
		String category = "99"; // category 湲곕낯�꽑�깮�옄 99;
		if(req.getParameter("category") != null){
			category = req.getParameter("category");
		}
		
		//Select Box �꽑�깮 �젙�젹
		String select = "s1"; //醫뗭븘�슂 湲곕낯�꽑�깮�옄  s1
		if(req.getParameter("select") !=null){
			select = req.getParameter("select");
		}
		
		
		System.out.println(category);
		System.out.println(select);
		 
		//�꽌鍮꾩뒪 �뿰寃�
		ReviewSelectService rss = new ReviewSelectService();
		
		try {
			review = rss.ReviewListAll(category, select);
			if(review==null){
				  resp.setContentType("text/html;charset=UTF-8");
			         PrintWriter out = resp.getWriter();
			         out.println("<script>");
			         out.println("alert('議고쉶�떎�뙣')");
			         out.println("history.back();");
			         out.println("</script>");
			} else {
				session.setAttribute("review", review);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
				
		
		
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
