package org.trippin.service.order;

import java.sql.Connection;
import java.util.ArrayList;

import org.trippin.dao.OrderDao;
import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;
import org.trippin.vo.OrderVo;

public class OrderListService {

	public ArrayList<OrderVo> getOrderList(OrderVo orderVo) {
		ArrayList<OrderVo> orderList = null;
		Connection conn=JdbcUtil.getConnection();
		OrderDao orderDao = OrderDao.getInstance();
		orderDao.setConnection(conn);
		
		orderList = orderDao.selectAllById(orderVo);
		
		JdbcUtil.close(conn);
		return orderList;
	}

	public CartVo getOrderVo(String pro_cd) {
		CartVo cartVo = null;
		Connection conn=JdbcUtil.getConnection();
		OrderDao orderDao = OrderDao.getInstance();
		orderDao.setConnection(conn);
		
		cartVo = orderDao.selectByProcd(pro_cd);
		JdbcUtil.close(conn);
		return cartVo;
	}
	
	//orderVo 셋팅
	public OrderVo setOrderVo(String userId) {
		OrderVo orderVo = null;
		OrderVo orderVo2 = null;
		Connection conn=JdbcUtil.getConnection();
		OrderDao orderDao = OrderDao.getInstance();
		orderDao.setConnection(conn);
		
		orderVo = orderDao.setOrderVoById(userId);
		//System.out.println("service orderVo: "+orderVo.toString());
		orderVo2 = orderDao.setOderVoByVo(orderVo);
		
		JdbcUtil.close(conn);
		return orderVo2;
	}

}
