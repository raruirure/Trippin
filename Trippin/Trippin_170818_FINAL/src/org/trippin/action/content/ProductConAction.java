package org.trippin.action.content;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.content.ProductConService;
import org.trippin.service.content.ReviewCommentReadService;
import org.trippin.vo.ProductVo;
import org.trippin.vo.ReviewCommentVo;

public class ProductConAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ReviewCommentReadService service_review_read = new ReviewCommentReadService();
		
		String pro_cd = req.getParameter("pro_cd");
		ArrayList<ReviewCommentVo> read_list = service_review_read.getCommentReviewAll(pro_cd);
		if(read_list!=null){
			session.setAttribute("read_list", read_list);
		}		
		req.setAttribute("pro_cd",req.getParameter("pro_cd")); 		
		
		ProductConService service = new ProductConService();
		ProductVo proContent = service.getProductCon(pro_cd);
		if(proContent!=null) {
			req.setAttribute("procontent", proContent);
		}
		String viewName = "WEB-INF/view/content/product_detailView.jsp";
		ActionForward forward = null;
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
