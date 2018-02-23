package org.trippin.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.ProductCartUpdateEaService;
import org.trippin.vo.CartVo;

public class mpCartUpdateEaAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("action들어옴");
		ActionForward forward=null;
		CartVo cartVo = new CartVo();
		int cart_no = Integer.parseInt(req.getParameter("RowCheck")); //장바구니번호
		//String pro_cd = req.getParameter("pro_cd");
		int cart_ea = Integer.parseInt(req.getParameter("cart_ea"));
		//System.out.println("cart_ea: "+cart_ea+", cart_no: "+cart_no);
		
		ProductCartUpdateEaService cartUpdateService = new ProductCartUpdateEaService();
		cartUpdateService.selectByProCd(cart_no, cart_ea);
		
		forward = new ActionForward("mypage_product_cart.order", true);
		return forward;
	}

}
