package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;
import org.trippin.vo.OrderVo;

public class OrderDao {
	private Connection conn;
	private static OrderDao instance; 
	private OrderDao() {}
	public static OrderDao getInstance(){
		if(instance == null){
			instance = new OrderDao();
		}
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public void insertPayOk(OrderVo payOkVo) {
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "INSERT INTO tr_product_sell(user_id, pro_cd, pro_cnt, pro_detail_cd) "
				+ "values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payOkVo.getUser_id());
			pstmt.setString(2, payOkVo.getPro_cd());
			pstmt.setInt(3, payOkVo.getPro_cnt());
			pstmt.setString(4, payOkVo.getPro_detail_cd());
			res=pstmt.executeUpdate();
			if(res>0){
				System.out.println(">>>>>>>>>>입력성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
	}
	
	//리스트 출력
	public ArrayList<OrderVo> selectAllById(OrderVo _orderVo) {
		ArrayList<OrderVo> orderList = new ArrayList<OrderVo>();
		OrderVo orderVo = new OrderVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_product_sell WHERE user_id = ? ORDER BY no DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _orderVo.getUser_id());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				orderVo.setPro_cd(rs.getString("pro_cd"));
				orderVo.setPro_detail_cd(rs.getString("pro_detail_cd"));
				orderVo.setUser_id(rs.getString("user_id"));
				orderVo.setPro_cnt(rs.getInt("pro_cnt"));
				orderVo.setPro_sell_date(rs.getString("pro_sell_date"));
				orderVo.setPro_cancel(rs.getString("pro_cancel"));
				
				orderVo.setPro_sdate(_orderVo.getPro_sdate());
				orderVo.setPro_edate(_orderVo.getPro_edate());
				orderVo.setPro_name(_orderVo.getPro_name());
				orderVo.setPro_price(_orderVo.getPro_price());
				orderList.add(orderVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		//System.out.println("orderVO List>>>>>>>>>>>>"+orderVo.toString());
		return orderList;
	}
	public CartVo selectByProcd(String pro_cd) {
		CartVo cartVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_cart WHERE pro_cd=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro_cd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cartVo = new CartVo();
				cartVo.setPro_name(rs.getString("cart_name"));
				cartVo.setCart_ea(rs.getInt("cart_ea"));
				cartVo.setPro_price(rs.getInt("cart_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return cartVo;
	}
	public OrderVo setOrderVoById(String userId) {
		OrderVo orderVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_product_sell WHERE user_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderVo = new OrderVo();
				orderVo.setPro_cd(rs.getString("pro_cd"));
				orderVo.setPro_detail_cd(rs.getString("pro_detail_cd"));
				orderVo.setUser_id(rs.getString("user_id"));
				orderVo.setPro_cnt(rs.getInt("pro_cnt"));
				orderVo.setPro_sell_date(rs.getString("pro_sell_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return orderVo;
	}
	public OrderVo setOderVoByVo(OrderVo _orderVo) {
		OrderVo orderVo = new OrderVo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_product WHERE pro_cd = ? ";
		String sql2 = "SELECT * FROM tr_product_detail WHERE pro_cd = ? AND pro_detail_cd = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _orderVo.getPro_cd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderVo.setUser_id(_orderVo.getUser_id());
				orderVo.setPro_cd(_orderVo.getPro_cd());
				orderVo.setPro_sell_date(_orderVo.getPro_sell_date());
				orderVo.setPro_cnt(_orderVo.getPro_cnt());
				orderVo.setPro_name(rs.getString("pro_name"));
				orderVo.setPro_price(rs.getInt("pro_price"));
			}
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, _orderVo.getPro_cd());
			pstmt.setString(2, _orderVo.getPro_detail_cd());
			//System.out.println("orderVo 2차 pstmt 시작: "+orderVo.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("2차 next들어옴");
				orderVo.setPro_detail_cd(_orderVo.getPro_detail_cd());
				orderVo.setPro_sdate(rs.getString("pro_sdate"));
				orderVo.setPro_edate(rs.getString("pro_edate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		//System.out.println("orderVo2>>>>"+orderVo.toString());
		return orderVo;
	}
	
	
}
