package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;
import org.trippin.vo.ProductVo;

public class ProductDao {
	private Connection conn;
	private static ProductDao instance;

	private ProductDao() {
	}

	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}

	private String getProductCode() {
		String sql = "SELECT MAX(no) FROM tr_product";
		Statement stmt = null;
		ResultSet rs = null;
		int no = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				no = rs.getInt(1);
				no++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		String pro_cd = "p";
		String number = String.format("%05d", no);
		pro_cd = pro_cd.concat(number);
		return pro_cd;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public String registProduct(ProductVo vo) {
		boolean isOk = false;
		String sql = "INSERT INTO tr_product(seller_id,pro_cd,pro_name,pro_category,pro_price,pro_img,pro_content) "
				+ "VALUES(?,?,?,?,?,?,?)";
		int res = 0;
		PreparedStatement pstmt = null;
		String pro_cd = getProductCode();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSeller_id());
			pstmt.setString(2, pro_cd);
			pstmt.setString(3, vo.getPro_name());
			pstmt.setString(4, vo.getPro_category());
			pstmt.setInt(5, vo.getPro_price());
			pstmt.setString(6, vo.getPro_img());
			pstmt.setString(7, vo.getPro_content());
			res = pstmt.executeUpdate();
			if (res > 0) {
				isOk = true;
			} else {
				pro_cd = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return pro_cd;
	}

	public boolean registProductDetail(ProductVo vo, int count) {
		boolean isOk = false;
		String[] sql = new String[6];
		for (int i = 1; i <= count; i++) {
			if (i == 1) {
				sql[i] = "INSERT INTO tr_product_detail(pro_cd,pro_detail_cd,pro_cnt,pro_sdate,pro_edate) VALUES(?,?,?,?,?)";
			} else {
				sql[i] = sql[i - 1].concat(", (?,?,?,?,?)");
			}
		}

		int res = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql[count]);
			for (int i = 1; i <= count; i++) {
				int number = (i - 1) * 5;
				pstmt.setString(number + 1, vo.getPro_cd());
				pstmt.setInt(number + 2, i);
				if (i == 1) {
					pstmt.setInt(number + 3, vo.getPro_cnt_1());
					pstmt.setString(number + 4, vo.getPro_sdate_1());
				} else if (i == 2) {
					pstmt.setInt(number + 3, vo.getPro_cnt_2());
					pstmt.setString(number + 4, vo.getPro_sdate_2());
				} else if (i == 3) {
					pstmt.setInt(number + 3, vo.getPro_cnt_3());
					pstmt.setString(number + 4, vo.getPro_sdate_3());
				} else if (i == 4) {
					pstmt.setInt(number + 3, vo.getPro_cnt_4());
					pstmt.setString(number + 4, vo.getPro_sdate_4());
				} else {
					pstmt.setInt(number + 3, vo.getPro_cnt_5());
					pstmt.setString(number + 4, vo.getPro_sdate_5());
				}
				String[] edate = vo.getPro_edate();
				pstmt.setString(number + 5, edate[i - 1]);
			}
			res = pstmt.executeUpdate();
			if (res > 0)
				isOk = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return isOk;
	}

	public boolean registSellerInfo(ProductVo vo) {
		boolean isOk = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TR_MEMBER_SELLER SET BUSINESS_NAME=?, SELLER_AGENT=?, SELLER_PHONENUM=?, SELLER_ADDRESS_POST=?, SELLER_ADDRESS=?, SELLER_ADDRESS_DETAIL=? where USER_ID=?";
		int res = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSeller_business_name());
			pstmt.setString(2, vo.getSeller_agent());
			pstmt.setString(3, vo.getSeller_phonenum());
			pstmt.setInt(4, vo.getSeller_address_post());
			pstmt.setString(5, vo.getSeller_address());
			pstmt.setString(6, vo.getSeller_address_detail());
			pstmt.setString(7, vo.getSeller_id());
			res = pstmt.executeUpdate();
			if (res > 0) {
				isOk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return isOk;
	}

	public ArrayList<ProductVo> getProductList(String seller_id) {
		ArrayList<ProductVo> proList = new ArrayList<ProductVo>();
		String sql = "SELECT pro_cd,pro_category,pro_name,pro_price,pro_rdate,pro_display FROM tr_product WHERE seller_id=? ORDER BY pro_rdate DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setPro_cd(rs.getString(1));
				vo.setPro_category(rs.getString(2));
				vo.setPro_name(rs.getString(3));
				vo.setPro_price(rs.getInt(4));
				vo.setPro_rdate(rs.getString(5).substring(0, 10));
				vo.setPro_display(rs.getInt(6));
				proList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return proList;
	}

	public ProductVo getProductCon(String pro_cd) {
		ProductVo vo = null;
		String sql1 = "SELECT * FROM TR_PRODUCT_VIEW WHERE PRO_CD=?";
		String sql2 = "SELECT * FROM TR_PRODUCT_DETAIL WHERE PRO_CD=? order by PRO_DETAIL_CD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, pro_cd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new ProductVo();
				vo.setSeller_id(rs.getString(1));
				vo.setSeller_num(rs.getString(2));
				vo.setSeller_business_name(rs.getString(3));
				vo.setSeller_agent(rs.getString(4));
				vo.setSeller_phonenum(rs.getString(5));
				vo.setSeller_address_post(rs.getInt(6));
				vo.setSeller_address(rs.getString(7));
				vo.setSeller_address_detail(rs.getString(8));
				vo.setPro_cd(rs.getString(9));
				vo.setPro_name(rs.getString(10));
				vo.setPro_category(rs.getString(11));
				vo.setPro_price(rs.getInt(12));
				vo.setPro_img(rs.getString(13));
				vo.setPro_display(rs.getInt(14));
				vo.setPro_content(rs.getString(15));
				vo.setPro_hit(rs.getInt(16));
				vo.setPro_rdate(rs.getString(17));
			}
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);

			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, pro_cd);
			rs = pstmt.executeQuery();
			int idx = 0;
			String[] edate = new String[5];
			String[] sdate = new String[5];
			int[] cnt = new int[5];
			while (rs.next()) {
				cnt[idx] = rs.getInt("PRO_CNT");
				sdate[idx] = rs.getString("PRO_SDATE");
				edate[idx] = rs.getString("PRO_EDATE");
				idx++;
			}

			String[] pro_edate = new String[idx];
			String[] pro_sdate = new String[idx];
			int[] pro_cnt = new int[idx];
			System.arraycopy(edate, 0, pro_edate, 0, idx);
			System.arraycopy(sdate, 0, pro_sdate, 0, idx);
			System.arraycopy(cnt, 0, pro_cnt, 0, idx);
			vo.setPro_edate(pro_edate);
			vo.setPro_sdate(pro_sdate);
			vo.setPro_cnt(pro_cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return vo;
	}

	public void setProductHit(String pro_cd) {
		String sql = "UPDATE TR_PRODUCT SET PRO_HIT=PRO_HIT+1 WHERE PRO_CD=?";
		PreparedStatement pstmt = null;
		int res = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_cd);
			res = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public boolean setProductList(String[] pro_cd) {
		String sql1 = "DELETE FROM TR_PRODUCT_DETAIL WHERE PRO_CD=?";
		String sql2 = "DELETE FROM TR_PRODUCT WHERE PRO_CD=?";
		PreparedStatement pstmt = null;
		int[] res = null;
		boolean isOk = false;

		try {
			pstmt = conn.prepareStatement(sql1);
			for (int i = 0; i < pro_cd.length; i++) {
				pstmt.setString(1, pro_cd[i]);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			res = pstmt.executeBatch();
			JdbcUtil.close(pstmt);

			pstmt = conn.prepareStatement(sql2);
			for (int i = 0; i < pro_cd.length; i++) {
				pstmt.setString(1, pro_cd[i]);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			res = pstmt.executeBatch();
			JdbcUtil.close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			isOk = true;
			for (int i = 0; i < res.length; i++) {
				if (res[i] <= 0) {
					isOk = false;
					break;
				}
			}
		}
		return isOk;
	}

	
	
	//170817 pcw
	public ArrayList<ProductVo> selectAll(String category, String select) {

		ArrayList<ProductVo> selectAll = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String paramSelect = select;

		if (paramSelect.equals("s1")) {
			String sql = "SELECT seller_id, A.PRO_CD, PRO_DETAIL_CD, pro_name, pro_category, pro_price, pro_img, pro_display, pro_content, pro_hit, pro_rdate FROM tr_product A, tr_product_detail B WHERE CONCAT(A.NO,A.PRO_CD) = CONCAT(B.NO,B.PRO_CD) AND PRO_CATEGORY = ?";
			switch (category) {
			case "99":
				sql = "SELECT seller_id, A.PRO_CD, PRO_DETAIL_CD, pro_name, pro_category, pro_price, pro_img, pro_display, pro_content, pro_hit, pro_rdate FROM tr_product A, tr_product_detail B WHERE CONCAT(A.NO,A.PRO_CD) = CONCAT(B.NO,B.PRO_CD) AND PRO_CATEGORY in('asia','europe','oseania','america','africa') order by A.PRO_CD ";
				break;
			}

			try {
				pstmt = conn.prepareStatement(sql);
				if (!(category.equals("99")))
					pstmt.setString(1, category);
				rs = pstmt.executeQuery();

				selectAll = new ArrayList<ProductVo>();
				while (rs.next()) {

					String seller_id = rs.getString(1);
					String pro_cd = rs.getString(2);
					String pro_detail_cd = rs.getString(3);
					String pro_name = rs.getString(4);
					String pro_category = rs.getString(5);
					int pro_price = rs.getInt(6);
					String pro_img = rs.getString(7);
					int pro_display = rs.getInt(8);
					String pro_content = rs.getString(9);
					int pro_hit = rs.getInt(10);
					String pro_rdate = rs.getString(11);

					selectAll.add(new ProductVo(seller_id, pro_cd, pro_detail_cd, pro_name, pro_category, pro_price,
							pro_img, pro_display, pro_content, pro_hit, pro_rdate));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			// end of tryCatch
		} else if (paramSelect.equalsIgnoreCase("s2")) {
			String sql = "SELECT seller_id, A.PRO_CD, PRO_DETAIL_CD, pro_name, pro_category, pro_price, pro_img, pro_display, pro_content, pro_hit, pro_rdate FROM tr_product A, tr_product_detail B WHERE CONCAT(A.NO,A.PRO_CD) = CONCAT(B.NO,B.PRO_CD) AND PRO_CATEGORY = ?";
			switch (category) {
			case "99":
				sql = "SELECT seller_id, A.PRO_CD, PRO_DETAIL_CD, pro_name, pro_category, pro_price, pro_img, pro_display, pro_content, pro_hit, pro_rdate FROM tr_product A, tr_product_detail B WHERE CONCAT(A.NO,A.PRO_CD) = CONCAT(B.NO,B.PRO_CD) AND PRO_CATEGORY in('1','2','3','4','5') order by A.PRO_CD DESC";
				break;
			}

			try {
				pstmt = conn.prepareStatement(sql);
				if (!(category.equals("99")))
					pstmt.setString(1, category);
				rs = pstmt.executeQuery();

				selectAll = new ArrayList<ProductVo>();
				while (rs.next()) {

					String seller_id = rs.getString(1);
					String pro_cd = rs.getString(2);
					String pro_detail_cd = rs.getString(3);
					String pro_name = rs.getString(4);
					String pro_category = rs.getString(5);
					int pro_price = rs.getInt(6);
					String pro_img = rs.getString(7);
					int pro_display = rs.getInt(8);
					String pro_content = rs.getString(9);
					int pro_hit = rs.getInt(10);
					String pro_rdate = rs.getString(11);

					selectAll.add(new ProductVo(seller_id, pro_cd, pro_detail_cd, pro_name, pro_category, pro_price,
							pro_img, pro_display, pro_content, pro_hit, pro_rdate));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		return selectAll;

	}

	public ArrayList<ProductVo> selectByKey(String keyword) {

		ArrayList<ProductVo> selectAll = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT seller_id, A.PRO_CD, PRO_DETAIL_CD, pro_name, pro_category, pro_price, pro_img, pro_display, pro_content, pro_hit, pro_rdate FROM tr_product A, tr_product_detail B WHERE CONCAT(A.NO,A.PRO_CD) = CONCAT(B.NO,B.PRO_CD) AND  pro_name like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();

			selectAll = new ArrayList<ProductVo>();
			while (rs.next()) {

				String seller_id = rs.getString(1);
				String pro_cd = rs.getString(2);
				String pro_detail_cd = rs.getString(3);
				String pro_name = rs.getString(4);
				String pro_category = rs.getString(5);
				int pro_price = rs.getInt(6);
				String pro_img = rs.getString(7);
				int pro_display = rs.getInt(8);
				String pro_content = rs.getString(9);
				int pro_hit = rs.getInt(10);
				String pro_rdate = rs.getString(11);

				selectAll.add(new ProductVo(seller_id, pro_cd, pro_detail_cd, pro_name, pro_category, pro_price,
						pro_img, pro_display, pro_content, pro_hit, pro_rdate));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return selectAll;

	}
	
	public ArrayList<ProductVo> getProductListQuery(String query) {
		String sql = "SELECT pro_cd,pro_name,pro_img,pro_hit FROM tr_product WHERE pro_name like ? order by pro_hit desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVo vo = new ProductVo();
				vo.setPro_cd(rs.getString("pro_cd"));
				vo.setPro_name(rs.getString("pro_name"));
				vo.setPro_img(rs.getString("pro_img"));
				vo.setPro_hit(rs.getInt("pro_hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return list;
	}

}
