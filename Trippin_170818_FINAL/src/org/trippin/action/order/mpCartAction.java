package org.trippin.action.order;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.ProductCartService;
import org.trippin.vo.CartVo;
import org.trippin.vo.MemberVo;

public class mpCartAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName="WEB-INF/view/order/mypage_product_cart.jsp";
		ActionForward forward=null;
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = null;
		session=req.getSession();
		CartVo cartVo = new CartVo();
		ProductCartService pCartService = new ProductCartService();
		MemberVo member = (MemberVo) session.getAttribute("member");
		String user_id = member.getUserId();
		if(session.getAttribute("cartList") == null) {
			ArrayList<CartVo> cartList = new ArrayList<CartVo>();
			session.setAttribute("cartList", cartList);
		}
		ArrayList<CartVo> cartList = (ArrayList<CartVo>) session.getAttribute("cartList");
		cartList = pCartService.selectAllById(user_id);
		
		
		session.setAttribute("cartList", cartList);
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
