package org.trippin.action.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trippin.action.Action;
import org.trippin.action.ActionForward;
import org.trippin.service.order.PayOkService;
import org.trippin.service.order.ProductPayService;
import org.trippin.vo.CartVo;
import org.trippin.vo.OrderVo;
import org.trippin.vo.ProductVo;


public class ProductPayOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActionForward forward=null;
		OrderVo payOkVo = new OrderVo();
		
		String pro_cd = req.getParameter("pro_cd");
		String pro_detail_cd = req.getParameter("pro_detail_cd");
		int pro_cnt = Integer.parseInt(req.getParameter("pro_cnt"));
		String user_id = req.getParameter("user_id");
		
		payOkVo.setPro_cd(pro_cd);
		payOkVo.setPro_detail_cd(pro_detail_cd);
		payOkVo.setPro_cnt(pro_cnt);
		payOkVo.setUser_id(user_id);
		
		PayOkService payOkService = new PayOkService();
		payOkService.setInsertPayOk(payOkVo);
		
		forward = new ActionForward("user_order_list.mypage", true);
		return forward;
	}

}
