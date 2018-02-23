package org.trippin.action.seller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.seller.ProductDeleteService;

public class SellerProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String viewName = "seller_product_manage.seller";
		ActionForward forward = null;
		String delete_cd = (String)req.getParameter("dinfo");
		String[] pro_cd = delete_cd.split("/");
		ProductDeleteService service = new ProductDeleteService();
		boolean isOk = service.setProductList(pro_cd);
		forward = new ActionForward(viewName, true);
		return forward;
	}
	
}
