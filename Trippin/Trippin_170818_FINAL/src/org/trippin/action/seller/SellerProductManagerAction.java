package org.trippin.action.seller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.seller.SellerProManagerService;
import org.trippin.vo.MemberVo;
import org.trippin.vo.ProductVo;

public class SellerProductManagerAction implements Action{
	HttpSession session=null;
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/seller/seller_product_manage.jsp";
		ActionForward forward = null;
		session = req.getSession();
		SellerProManagerService service = new SellerProManagerService();
		MemberVo member = (MemberVo)session.getAttribute("member");
		String seller_id = member.getUserId();
		ArrayList<ProductVo> proList = service.getProductList(seller_id);
		req.setAttribute("proList", proList);
		forward = new ActionForward(viewName, false);
		return forward;
	}
}
