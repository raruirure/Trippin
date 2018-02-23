package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.seller.SellerCustomerManageAction;
import org.trippin.action.seller.SellerProductDeleteAction;
import org.trippin.action.seller.SellerProductManagerAction;
import org.trippin.action.seller.SellerProductRegistAction;
import org.trippin.action.seller.SellerProductUploadAction;

@WebServlet("*.seller")
public class SellerController extends Controller {

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/seller_customer_manage.seller".equals(command)) {
			action = new SellerCustomerManageAction();
		} else if("/seller_product_manage.seller".equals(command)) {
			action = new SellerProductManagerAction();
		} else if("/seller_product_upload.seller".equals(command)) {
			action = new SellerProductUploadAction();
		} else if("/productRegist.seller".equals(command)) {
			action = new SellerProductRegistAction();
		} else if("/prodelete.seller".equals(command)) {
			action = new SellerProductDeleteAction();
		} 

		actionforward = action.execute(req, resp);
		forward(actionforward, req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
}
