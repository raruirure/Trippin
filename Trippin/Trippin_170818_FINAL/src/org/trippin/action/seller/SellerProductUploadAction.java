package org.trippin.action.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;

public class SellerProductUploadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/seller/seller_product_upload.jsp";
		ActionForward forward = null;
		
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
