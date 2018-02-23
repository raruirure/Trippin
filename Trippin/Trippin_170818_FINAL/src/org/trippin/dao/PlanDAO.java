package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.trippin.db.JdbcUtil;
import org.trippin.vo.PlanBean;
import org.trippin.vo.ReviewBean;

public class PlanDAO {
	Connection conn;
	private static PlanDAO planDAO;

	private PlanDAO() {
		// TODO Auto-generated constructor stub
	}

	public static PlanDAO getInstance(){
		if(planDAO == null){
			planDAO = new PlanDAO();
		}
		return planDAO;
	}

	public void setConnection(Connection conn){
		this.conn = conn;
	}

	public boolean insertPlanCommon(PlanBean plan) {
		boolean isOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "INSERT INTO plan(CODE_CLASS,WRITE_NO,CODE,MAIN_TITLE,USER_ID,SDATE,EDATE,CATEGORY,BANNER_IMG,plan_content,PLAN_DAYCNT) value(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getCode_class());
			pstmt.setInt(2, plan.getWrite_no());
			pstmt.setString(3, plan.getCode());
			pstmt.setString(4, plan.getMain_title());
			pstmt.setString(5, plan.getUser_id());
			pstmt.setString(6, plan.getSdate());
			pstmt.setString(7, plan.getEdate());
			pstmt.setString(8, plan.getCategory());
			pstmt.setString(9, plan.getBanner_img());
			pstmt.setString(10, plan.getPlan_content());
			pstmt.setInt(11, plan.getPlan_DayCnt());
			res = pstmt.executeUpdate();
			if(res!=0) {
				isOK = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return isOK;
	}

	public int getCount() {
		int cnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM plan";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return cnt;
	}

	public ArrayList<PlanBean> selectAll() {
		ArrayList<PlanBean> planList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLAN";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			planList = new ArrayList<PlanBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String plan_content = rs.getString(10);
				int plan_DayCnt = rs.getInt(11);
				planList.add(new PlanBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, plan_content,category,plan_DayCnt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return planList;
	}
	public ArrayList<PlanBean> selectById(String compId) {
		ArrayList<PlanBean> planList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLAN WHERE user_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, compId);
			rs = pstmt.executeQuery();
			planList = new ArrayList<PlanBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String plan_content = rs.getString(11);
				int plan_DayCnt = rs.getInt(12);
				planList.add(new PlanBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, plan_content,category,plan_DayCnt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return planList;
	}
	
	public ArrayList<PlanBean> selectByKey(String keyword) {
		ArrayList<PlanBean> planList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLAN WHERE main_title LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			planList = new ArrayList<PlanBean>();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String plan_content = rs.getString(11);
				int plan_DayCnt = rs.getInt(12);
				planList.add(new PlanBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, plan_content,category,plan_DayCnt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return planList;
	}
	
	public PlanBean selectByCode(String codeN) {
		PlanBean plan = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLAN WHERE code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, codeN);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String code_class = rs.getString(1);
				int write_no = rs.getInt(2);
				String code = rs.getString(3);
				String user_id = rs.getString(4);
				String main_title = rs.getString(5);
				String sdate = rs.getString(6);
				String edate = rs.getString(7);
				String category = rs.getString(8);
				String banner_img = rs.getString(9);
				String plan_content = rs.getString(10);
				int plan_DayCnt = rs.getInt(11);
				plan = new PlanBean(code_class, write_no, code, user_id, main_title, sdate, edate, banner_img, plan_content,category,plan_DayCnt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return plan;
	}

	public boolean deletePlanByCode(String code) {
		boolean delPlanOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "DELETE FROM plan where code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			res = pstmt.executeUpdate();
			if(res != 0) {
				System.out.println("占쏙옙占쏙옙占쏙옙 占싹뤄옙퓸占쏙옙占쏙옙求占�.");
				delPlanOK = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return delPlanOK;
	}

	public boolean updatePlan(PlanBean plan, String code) {
		boolean isOK = false;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "UPDATE PLAN SET user_id=?,main_title=?,sdate=?,edate=?,category=?,banner_img=?,plan_content=?,plan_daycnt=? WHERE code=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getUser_id());
			pstmt.setString(2, plan.getMain_title());
			pstmt.setString(3, plan.getSdate());
			pstmt.setString(4, plan.getEdate());
			pstmt.setString(5, plan.getCategory());
			pstmt.setString(6, plan.getBanner_img());
			pstmt.setString(7, plan.getPlan_content());
			pstmt.setInt(8, plan.getPlan_DayCnt());
			pstmt.setString(9, code);
			res = pstmt.executeUpdate();
			if(res!=0) {
				isOK = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return isOK;
	}
	
	//display DAO_170817 park
			public ArrayList<PlanBean> selectListAll(String category, String select) {
				ArrayList<PlanBean> selectAll = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String paramSelect = select;
				if(paramSelect.equals("s1")){
					String sql = "SELECT  CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, PLAN_CONTENT, PLAN_DAYCNT, HIT   FROM PLAN  WHERE CODE_CLASS='P' AND CATEGORY = ?";
					switch (category) {
					case "99":
						sql = "SELECT CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, PLAN_CONTENT, PLAN_DAYCNT, HIT   FROM PLAN WHERE CATEGORY in ('asia','europe','oseania','america','africa') order by code";
						break;
					} 
			
					try {
						pstmt = conn.prepareStatement(sql);
						if (!(category.equals("99")))
							pstmt.setString(1, category);
						rs = pstmt.executeQuery();
			
						selectAll = new ArrayList<PlanBean>();
						while (rs.next()) {
							String code_class = rs.getString(1);
							int WRITE_NO = rs.getInt(2);
							String code = rs.getString(3);
							String user_id = rs.getString(4);
							String main_title = rs.getString(5);
							String sdate = rs.getString(6);
							String edate = rs.getString(7);
							String CATEGORY = rs.getString(8);
							String banner_img = rs.getString(9);
							String plan_content = rs.getString(10);
							int plan_DayCnt = rs.getInt(11);
							int hit = rs.getInt(12);
			
							selectAll.add(new PlanBean( code_class,  WRITE_NO,  code,  user_id,  main_title,  sdate,
									 edate,  banner_img,  plan_content, CATEGORY, plan_DayCnt, hit));
							System.out.println(sql);

						}
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						JdbcUtil.close(rs);
						JdbcUtil.close(pstmt);
					}
				} else if(paramSelect.equals("s2")){
					String sql = "SELECT  CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, PLAN_CONTENT, PLAN_DAYCNT, HIT   FROM PLAN  WHERE CODE_CLASS='P' AND CATEGORY = ?";
					
					switch (category) {
					case "99":
						sql = "SELECT CODE_CLASS, WRITE_NO, CODE, USER_ID, MAIN_TITLE, SDATE, EDATE, CATEGORY, BANNER_IMG, PLAN_CONTENT, PLAN_DAYCNT, HIT   FROM PLAN WHERE CATEGORY in ('1','2','3','4','5') order by code desc ";
						break;
					}
			
					try {
						pstmt = conn.prepareStatement(sql);
						if (!(category.equals("99")))
							pstmt.setString(1, category);
						rs = pstmt.executeQuery();
			
						selectAll = new ArrayList<PlanBean>();
						while (rs.next()) {
							String code_class = rs.getString(1);
							int WRITE_NO = rs.getInt(2);
							String code = rs.getString(3);
							String user_id = rs.getString(4);
							String main_title = rs.getString(5);
							String sdate = rs.getString(6);
							String edate = rs.getString(7);
							String CATEGORY = rs.getString(8);
							String banner_img = rs.getString(9);
							String plan_content = rs.getString(10);
							int plan_DayCnt = rs.getInt(11);
							
			
							selectAll.add(new PlanBean( code_class,  WRITE_NO,  code,  user_id,  main_title,  sdate,
									 edate, CATEGORY,  banner_img,  plan_content,  plan_DayCnt));
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

			public ArrayList<PlanBean> getPlanlistQuery(String query) {
				String sql = "SELECT CODE,MAIN_TITLE,BANNER_IMG,HIT FROM PLAN WHERE MAIN_TITLE like ? order by hit desc";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				ArrayList<PlanBean> list = new ArrayList<PlanBean>();
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+query+"%");
					rs = pstmt.executeQuery();
					while(rs.next()) {
						PlanBean bean = new PlanBean();
						bean.setCode(rs.getString("CODE"));
						bean.setMain_title(rs.getString("MAIN_TITLE"));
						bean.setBanner_img(rs.getString("BANNER_IMG"));
						bean.setHit(rs.getInt("HIT"));
						list.add(bean);
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
