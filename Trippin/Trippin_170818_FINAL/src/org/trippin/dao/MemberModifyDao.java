package org.trippin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.trippin.vo.MemberVo;
import org.trippin.db.*;

public class MemberModifyDao {
	private Connection conn;
	private static MemberModifyDao instance;
	
	private MemberModifyDao() {};
	public static MemberModifyDao getInstance(){
		if(instance == null){
			instance = new MemberModifyDao();
		}
		return instance;
	}
	
	public void setConnection(Connection conn){
		this.conn = conn;
	}
	

	// 회원 정보 수정 기능
	public int updateMember(MemberVo vo){
		PreparedStatement pstmt = null;
		int updateCount =0;
		String sql1 = "UPDATE TR_MEMBER SET USER_PASS= ? WHERE USER_ID= ?";
		String sql2 = "UPDATE TR_MEMBER SET USER_PASS= ?, USER_PROFILE=? WHERE USER_ID= ?";
		System.out.println(vo.getUserId());
/*		System.out.println(vo.getUserPass());
		System.out.println(vo.getUserProfile());
*/
		
		//System.out.println(conn);
		try {
			if(vo.getUserProfile()==null){
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, vo.getUserPass());
				pstmt.setString(2, vo.getUserId());
				updateCount = pstmt.executeUpdate();
				if(updateCount >0){
					System.out.println("정보수정 완료");
				}
			} else if(vo.getUserProfile()!=null){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, vo.getUserPass());
				pstmt.setString(2, vo.getUserProfile());
				pstmt.setString(3, vo.getUserId());
				updateCount = pstmt.executeUpdate();
				if(updateCount >0){
					System.out.println("정보수정 완료");
				}
			}
			
		} catch (Exception e) {
			System.out.println("정보수정 실패 했습니다" );
			e.printStackTrace();
		} finally{
			//db 연결java에 선언된 close 호출
			JdbcUtil.close(pstmt);
		}

		return updateCount;
	}
	
	// 회원 정보 삭제(hidden) 기능
	public int dropMember(MemberVo vo){
		int dropCount =0;
		PreparedStatement pstmt = null;
		String sql ="UPDATE TR_MEMBER SET USER_OUT_CHECK =2 WHERE USER_ID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			dropCount = pstmt.executeUpdate();
			if(dropCount>0){
				System.out.println("탈퇴 완료");
			}
		} catch (Exception e) {
			System.out.println("탈퇴가 실패 했습니다" +e);
		} finally{
			JdbcUtil.close(pstmt);
		}
		
		return dropCount;
	}


	

}
