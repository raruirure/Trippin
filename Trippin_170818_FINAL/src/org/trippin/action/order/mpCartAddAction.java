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
import org.trippin.vo.CartVo;
import org.trippin.vo.MemberVo;

public class mpCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = null;
		ActionForward forward=null;
		CartVo _cartVo = null;
		boolean existCart = false;
		CartVo cartVo = new CartVo();
		session=req.getSession();
		ProductCartAddService productCartAddService = new ProductCartAddService();

		String pro_cd = req.getParameter("pro_cd");
		String cart_name = req.getParameter("pro_name");
		String cartNum = req.getParameter("cartNum"); //옵션
		int cart_ea = Integer.parseInt(req.getParameter("pro_order_cnt"));//인원수
		int cart_price = Integer.parseInt(req.getParameter("cart_price"));
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		String user_id = member.getUserId();
		
		//상품코드, 옵션선택이 같은 상품이 있는지 확인
		existCart = productCartAddService.getSearchByProCd(pro_cd, cartNum, user_id);
		if(existCart) {
			//카트에 존재하면 수량 추가
			productCartAddService.setUpdateCart(cart_ea, pro_cd, cartNum, user_id);
		}else {
			//카트에 없으면 새로 추가
			_cartVo = productCartAddService.getOptionInfo(pro_cd,cartNum);
			
			cartVo.setPro_cd(pro_cd);
			cartVo.setPro_detail_cd(cartNum);
			cartVo.setPro_name(cart_name);
			cartVo.setCart_ea(cart_ea);
			cartVo.setPro_price(cart_price);
			cartVo.setUser_id(user_id);
			cartVo.setPro_sdate(_cartVo.getPro_sdate());
			cartVo.setPro_edate(_cartVo.getPro_edate());
			
			productCartAddService.insertCartVo(cartVo);
		}
		
		forward = new ActionForward("mypage_product_cart.order", true);
		return forward;
	}

}
