package org.trippin.action.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.ProductPayService;
import org.trippin.vo.CartVo;
import org.trippin.vo.ProductVo;

public class ProductPayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName="WEB-INF/view/order/product_pay.jsp";
		ActionForward forward=null;
		
		ProductPayService productPayService = new ProductPayService();
		
		CartVo cartVo = new CartVo();
	
		//장바구니에서 결제
		if(req.getParameter("no") != null) {
			int no = Integer.parseInt(req.getParameter("no"));
			System.out.println("no>>>"+no);
			cartVo = productPayService.getCartByNo(no); 
			cartVo = productPayService.getProductByProCd(cartVo); //옵션내용가져오기
			req.setAttribute("cartPayVo", cartVo);
		}//상품상세보기에서 결제
		else {
			String pro_cd = req.getParameter("pro_cd");
			String pro_detail_cd = req.getParameter("cartNum"); //옵션번호
			int cart_ea = Integer.parseInt(req.getParameter("pro_order_cnt")); //인원수
			
			cartVo.setPro_cd(pro_cd);
			cartVo.setPro_detail_cd(pro_detail_cd);
			
			cartVo = productPayService.getProductByProCd(cartVo); //옵션내용가져오기
			cartVo.setCart_ea(cart_ea);
			req.setAttribute("cartPayVo", cartVo);
			
		}
		//System.out.println("cartVO>>>>>>>>>>>>>>>>>>>"+cartVo);
		
				
		forward = new ActionForward(viewName, false);
		return forward;
	}

}
