package org.trippin.action.order;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.ProductCartAddService;
import org.trippin.service.order.mpCartDeleteService;
import org.trippin.vo.CartVo;
import org.trippin.vo.MemberVo;

public class mpCartDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ActionForward forward=null;
		CartVo cartVo = new CartVo();
		mpCartDeleteService mpCartDeleteService = new mpCartDeleteService();
		int no = Integer.parseInt(req.getParameter("no"));
		mpCartDeleteService.deleteByNo(no);
		
		forward = new ActionForward("mypage_product_cart.order", true);
		return forward;
	}

}
