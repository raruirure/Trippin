package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.CartVo;

public class CartDao {
	private Connection conn;
	private static CartDao instance = null;
	private CartDao() {}
	public static CartDao getInstance() {
		if(instance==null) {
			instance = new CartDao();
		}
		return instance;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// 카트 목록
	public ArrayList<CartVo> selectAll(String _user_id) {
		ArrayList<CartVo> cartList = new ArrayList<CartVo>();
		CartVo cartVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_cart WHERE user_id = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, _user_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cartVo = new CartVo();
				cartVo.setNo(rs.getInt("no"));
				cartVo.setPro_cd(rs.getString("pro_cd"));
				cartVo.setPro_detail_cd(rs.getString("pro_detail_cd"));
				//String pro_category = rs.getString("pro_category");
				cartVo.setUser_id(rs.getString("user_id"));
				cartVo.setPro_name(rs.getString("cart_name"));
				cartVo.setPro_price(rs.getInt("cart_price"));
				cartVo.setCart_ea(rs.getInt("cart_ea"));
				cartVo.setPro_sdate(rs.getString("pro_sdate"));
				cartVo.setPro_edate(rs.getString("pro_edate"));
				cartList.add(cartVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return cartList;
	}
	
	// 주문
	public CartVo selectByNo(int no) {
		CartVo cartVo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tr_cart WHERE no = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cartVo = new CartVo();
				cartVo.setPro_cd(rs.getString("pro_cd"));
				cartVo.setPro_detail_cd(rs.getString("pro_detail_cd"));
				cartVo.setUser_id(rs.getString("user_id"));
				cartVo.setPro_name(rs.getString("cart_name"));
				cartVo.setPro_price(rs.getInt("cart_price"));
				cartVo.setCart_ea(rs.getInt("cart_ea"));
				cartVo.setPro_sdate(rs.getString("pro_sdate"));
				cartVo.setPro_edate(rs.getString("pro_edate"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return cartVo;
	}
	
	// 카트 담기
	public void insertCartVo(CartVo cartVo) {
		//CartVo _cartVo = new CartVo();
		PreparedStatement pstmt = null;
		int res=0;
		String sql2 = "INSERT INTO tr_cart(pro_cd,pro_detail_cd,user_id,cart_name,cart_price,cart_ea,pro_sdate,pro_edate) values(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, cartVo.getPro_cd());
			pstmt.setString(2, cartVo.getPro_detail_cd());
			pstmt.setString(3, cartVo.getUser_id());
			pstmt.setString(4, cartVo.getPro_name());
			pstmt.setInt(5, cartVo.getPro_price());
			pstmt.setInt(6, cartVo.getCart_ea());
			pstmt.setString(7, cartVo.getPro_sdate());
			pstmt.setString(8, cartVo.getPro_edate());
			res=pstmt.executeUpdate();
			if(res>0) {
				System.out.println("입력 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
		// 카트 수량추가
		public void updateCartEa (int cart_ea, String pro_cd, String pro_detail_cd, String user_id) {
			PreparedStatement pstmt = null;
			int res = 0;
			String sql = "UPDATE tr_cart SET cart_ea = cart_ea+? WHERE pro_cd = ? AND pro_detail_cd = ? AND user_id=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cart_ea);
				pstmt.setString(2, pro_cd);
				pstmt.setString(3, pro_detail_cd);
				pstmt.setString(4, user_id);
				res = pstmt.executeUpdate();
				if(res > 0) {
					System.out.println(">>>>>>>>>수량 수정 성공");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(pstmt);
			}
			
		}
		
		//카트 수량 업데이트
		public void updateCartEa (int cart_no, int cart_ea) {
			PreparedStatement pstmt = null;
			int res = 0;
			String sql = "UPDATE tr_cart SET cart_ea = ? WHERE no=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, cart_ea);
				pstmt.setInt(2, cart_no);
				res = pstmt.executeUpdate();
				if(res > 0) {
					System.out.println(">>>>>>>>>수량 수정 성공22");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(pstmt);
			}
			
		}
		
		// 카트 삭제
		public void deleteByNo(int no) {
			PreparedStatement pstmt = null;
			int res = 0;
			String sql = "DELETE FROM tr_cart WHERE no = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println(">>>>>>>>>삭제성공");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(pstmt);
			}
			
			
		}
		
		//동일상품 존재유무 확인
		public boolean searchByProCd(String pro_cd, String cartNum, String user_id) {
			boolean isOk = false;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM tr_cart WHERE pro_cd = ? AND pro_detail_cd = ? AND user_id=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, pro_cd);
				pstmt.setString(2, cartNum);
				pstmt.setString(3, user_id);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					isOk =  true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(pstmt);
			}
			return isOk;
		}
		
		//상품명, 상품 카테고리, 옵션검색
		public CartVo selectByDetail(CartVo _cartVo) {
			CartVo cartVo = new CartVo();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM tr_product WHERE pro_cd = ?";
			String sql1 = "SELECT * FROM tr_product_detail WHERE pro_cd = ? AND pro_detail_cd =?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, _cartVo.getPro_cd());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					cartVo.setPro_cd(rs.getString("pro_cd"));
					cartVo.setPro_category(rs.getString("pro_category"));
					cartVo.setPro_name(rs.getString("pro_name"));
					cartVo.setPro_price(rs.getInt("pro_price"));
					cartVo.setCart_ea(_cartVo.getCart_ea());
				}
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			
				pstmt=conn.prepareStatement(sql1);
				pstmt.setString(1, _cartVo.getPro_cd());
				pstmt.setString(2, _cartVo.getPro_detail_cd());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					cartVo.setPro_sdate(rs.getString("pro_sdate"));
					cartVo.setPro_edate(rs.getString("pro_edate"));
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			//System.out.println("cartVO : "+cartVo.toString());
			return cartVo;
		}
		
		//카트추가 - 옵션기간검색
		public CartVo selectByDInfo(String pro_cd, String cartNum) {
			CartVo cartVo = new CartVo();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql1 = "SELECT * FROM tr_product_detail WHERE pro_cd = ? AND pro_detail_cd =?";
			try {
				pstmt=conn.prepareStatement(sql1);
				pstmt.setString(1, pro_cd);
				pstmt.setString(2, cartNum);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					cartVo.setPro_sdate(rs.getString("pro_sdate"));
					cartVo.setPro_edate(rs.getString("pro_edate"));
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			//System.out.println("cartVO : "+cartVo.toString());
			return cartVo;
		}
}
