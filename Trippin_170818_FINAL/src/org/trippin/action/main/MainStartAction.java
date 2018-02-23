package org.trippin.action.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.plan.PlanListService;
import org.trippin.service.product.ProductSelectService;
import org.trippin.service.review.ReviewListService;
import org.trippin.vo.PlanBean;
import org.trippin.vo.ProductVo;
import org.trippin.vo.ReviewBean;

public class MainStartAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String viewName = "WEB-INF/view/main.jsp";
		ActionForward forward = null;

		String category = "99";
		String select = "s1";
		
		PlanListService planListService = new PlanListService();
		ReviewListService reviewListService = new ReviewListService();
		ProductSelectService pss = new ProductSelectService();
		
		ArrayList<PlanBean> MainPlan = null;
		ArrayList<ReviewBean> MainReview = null;
		ArrayList<ProductVo> MainProduct = null;
			try {
				MainPlan = planListService.selectAllPlan();
				MainReview = reviewListService.selectAllReview();
				MainProduct = pss.ProductListAll(category, select);
				
				session.setAttribute("MainPlan", MainPlan);
				session.setAttribute("MainReview", MainReview);
				session.setAttribute("MainProduct", MainProduct);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		forward = new ActionForward(viewName, false);
		return forward;
	}


}
