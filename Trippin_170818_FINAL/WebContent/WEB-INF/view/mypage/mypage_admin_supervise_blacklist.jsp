<%@page import="org.trippin.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="css/board_notice.css"> -->
<%
	ArrayList<MemberVo> blackList=(ArrayList<MemberVo>)request.getAttribute("blackList");
%>
<div id="adminBoard" class="columns is-mobile is-multiline">
	<!-- 회원관리 테이블 시작 -->

	<div class="column is-full-desktop is-full-mobile">


		<div class="nav-both1">
			<a class="serchBox"> <input type="text" id="search3"
				placeholder="회원이름">
				<button id="adSerchBtn" class="button is-info is-focused">회원검색</button>
				<select class="adSerchSort pull-right select">
					<option>아이디별</option>
					<option>회원이름</option>
					<option>가입일자</option>
					<option>회원상태</option>
			</select>
			</a>
		</div>
		<section class="panel">
		<p class="panel-heading">회원정보</p>
		<div class="panel-block">
			<form name="userMember" method="post" action="admin_supervise_black_modify.mypage">
			<table class="table  AdminUser">
				<thead>
				<%
				if(blackList != null ){
				%>
					<tr>
						<th style="text-align:center" class="col-sm-1">회원아이디</th>
						<th style="text-align:center">이름</th>
						<th style="text-align:center">비밀번호</th>
						<th style="text-align:center">신고일자</th>
						<th style="text-align:center">게시글번호</th>
						<th style="text-align:center">회원상태</th>
						<th style="text-align:center">구분</th>
					</tr>
				</thead>
				<tbody>
				<%
				for(int i=0; i<blackList.size(); i++){
				%>
					<tr>
						<td  style="text-align:center"class="col-sm-1"><input type="hidden" name="USER_ID" value="<%=blackList.get(i).getUserId() %>"><%=blackList.get(i).getUserId() %></td>
						<td  style="text-align:center"onclick="userImgFunction()"><a><%=blackList.get(i).getUserName() %></a></td>
						<td style="text-align:center"><%=blackList.get(i).getUserPass() %></td>
						<td style="text-align:center"></td>
						<td style="text-align:center"></td>
						<td style="text-align:center"><%
								if(blackList.get(i).getUserOutCheck()== 1){
								%> 									
									활동중
								<%
								}else if(blackList.get(i).getUserOutCheck()==2){
								%>
									활동정지
								<%
								}
								%></td>
						<td style="text-align:center">
							<select id="userOutCheck" name="selectOutCheck">
								
								<option value="1">활동중</option>
								<option value="2">활동정지</option>
							</select>	
						</td>
					</tr>
					
				</tbody>
				<tfoot>
					<tr>

					</tr>
				</tfoot>
				<%
				}
				}
				%>
			</table>
			<button type="submit" id="adBtn" class="button pull-right is-info is-focused">정보수정</button>
		</form>
		</div>
		</section>
		
	</div>
</div>