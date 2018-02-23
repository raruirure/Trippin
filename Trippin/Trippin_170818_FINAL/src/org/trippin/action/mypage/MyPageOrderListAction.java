package org.trippin.action.mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.OrderListService;
import org.trippin.vo.CartVo;
import org.trippin.vo.MemberVo;
import org.trippin.vo.OrderVo;

public class MyPageOrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewName = "WEB-INF/view/mypage/mypage_order_list.jsp";
		ActionForward forward = null;
		HttpSession session = null;
		OrderVo orderVo = null;
		session = req.getSession();
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		ArrayList<OrderVo> orderList = new ArrayList<OrderVo>();
		
		OrderListService orderListService = new OrderListService();
		orderVo = orderListService.setOrderVo(member.getUserId()); //orderVo에 설정
		
		orderList = orderListService.getOrderList(orderVo);
		
		req.setAttribute("orderList", orderList);
		forward = new ActionForward(viewName, false);
		return forward;
	}
}
