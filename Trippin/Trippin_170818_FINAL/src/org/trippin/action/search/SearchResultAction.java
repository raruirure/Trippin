package org.trippin.action.search;

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

public class SearchResultAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String viewName = "WEB-INF/view/search/result.jsp";
		ActionForward forward = null;
		String keyword = req.getParameter("keyword");
		String category = "99";
		String select = "s1";
		
		PlanListService planListService = new PlanListService();
		ReviewListService reviewListService = new ReviewListService();
		ProductSelectService pss = new ProductSelectService();
		
		ArrayList<PlanBean> allPlan = null;
		ArrayList<ReviewBean> allReview = null;
		ArrayList<ProductVo> allProduct = null;
		
		if("".equals(keyword)){
			try {
				allPlan = planListService.selectAllPlan();
				allReview = reviewListService.selectAllReview();
				allProduct = pss.ProductListAll(category, select);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				allPlan = planListService.selectPlanByKey(keyword);
				allReview = reviewListService.selectReviewByKey(keyword);
				allProduct = pss.ProductListByKey(keyword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(allPlan != null) {
			session.setAttribute("allPlan", allPlan);
		}
		if(allReview != null) {
			session.setAttribute("allReview", allReview);
		}
		if(allProduct != null) {
			session.setAttribute("allProduct", allProduct);
		}
		forward = new ActionForward(viewName, false);
		return forward;
	}
}
