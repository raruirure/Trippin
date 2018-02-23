package org.trippin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.action.order.mpCartAction;
import org.trippin.action.order.mpCartAddAction;
import org.trippin.action.order.mpCartDeleteAction;
import org.trippin.action.order.mpCartUpdateEaAction;
import org.trippin.action.order.ProductPayAction;
import org.trippin.action.order.ProductPayOkAction;

@WebServlet("*.order")
public class OrderController extends Controller{

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String command = makeCommand(req, resp);
		ActionForward actionforward = null;
		Action action = null;
		
		if("/mypage_product_cart.order".equals(command)) {
			action = new mpCartAction();
		} else if("/mypage_product_cart_add.order".equals(command)) {
			action = new mpCartAddAction(); //장바구니 추가
		} else if("/mp_cart_updateEa.order".equals(command)) {
			action = new mpCartUpdateEaAction(); //인원수 수정
		} else if("/mp_cart_delete.order".equals(command)) {
			action = new mpCartDeleteAction(); //장바구니 삭제
		} else if ("/product_pay.order".equals(command)) {
			action = new ProductPayAction();
		} else if ("/product_pay_ok.order".equals(command)) {
			action = new ProductPayOkAction();
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
