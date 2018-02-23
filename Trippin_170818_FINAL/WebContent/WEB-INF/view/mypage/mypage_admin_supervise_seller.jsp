<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<style>

</style>
<!--  ajax 처리 -->
<div id="adminBoard" class="columns is-mobile is-multiline">
	<!-- 회원관리 테이블 시작 -->
	<!-- ajax class = "column" -->
	<div class="column is-full-desktop is-full-mobile">


		<div class="nav-both1">
			<a class="serchBox"> 
			<input type="text" id="search3"placeholder="회원이름">
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
				<%
				if(session.getAttribute("member")!=null){
					MemberVo member = (MemberVo)session.getAttribute("member");
					if((ArrayList<MemberVo>)request.getAttribute("sellerList") != null ){
						ArrayList<MemberVo> sellerList = (ArrayList<MemberVo>)request.getAttribute("sellerList");%>
				<form name="sellserMember" method="post" action="admin_supervise_sellser_modify.mypage">
				<table class="table  AdminUser">
					<thead>				
						<tr>
							<th style="text-align:center">회원아이디</th>
							<th style="text-align:center">이름</th>
							<th style="text-align:center">비밀번호</th>
							<th style="text-align:center">생년월일</th>
							<th style="text-align:center">가입일자</th>
							<th style="text-align:center">사업자번호</th>
							<th style="text-align:center">회원상태</th>
							<th style="text-align:center">구분</th>
							<th style="text-align:center">판매승인</th>
						</tr>
					</thead>
					<%
					for(int i=0; i<sellerList.size(); i++){
					%>
					<tbody id="tbody">
						<tr>
							<td style="text-align:center" class="col-sm-1"><input type="hidden" name="USER_ID" value="<%=sellerList.get(i).getUserId() %>"><%=sellerList.get(i).getUserId() %></td>
							<td style="text-align:center" onclick="userImgFunction()"><a><%=sellerList.get(i).getUserName() %></a></td>
							<td style="text-align:center"><%=sellerList.get(i).getUserPass() %></td>
							<td style="text-align:center"><%=sellerList.get(i).getUserBirth() %></td>
							<td style="text-align:center"><%=sellerList.get(i).getDate().substring(0,10) %></td>
							<td style="text-align:center" onclick="onopen();" style="width:50px;">
										
											<input name="wrkr_no" type="text" value="<%=sellerList.get(i).getSellerNo() %>" readonly />
										
									</td>
							<td style="text-align:center"><%
								if(sellerList.get(i).getUserOutCheck()== 1){
								%> 									
									활동중
								<%
								}else if(sellerList.get(i).getUserOutCheck()==2){
								%>
									활동정지
								<%
								}
								%></td>		
							<td style="text-align:center">
							
															
							<select id="userOutCheck" name="selectOutCheck">
								<option><%if(sellerList.get(i).getUserOutCheck()== 1){
								%> 									
									활동중
								<%
								}else if(sellerList.get(i).getUserOutCheck()==2){
								%>
									활동정지
								<%
								}
								%></option>								
								<option value="1">활동중</option>
								<option value="2">활동정지</option>
							</select>	
							</td>
							<td style="text-align:center">
							<select id="sellerState" name="selectState" >								
								<option value="1">대기중</option>
								<option value="2">승인</option>
							</select>
							</td>
						</tr>						
					</tbody>
					<tfoot>
						<tr>

						</tr>
					</tfoot>
					<%}
					}
					}
					%>
				</table>
				<button id="adBtn" type="submit" class="button pull-right is-info is-focused">정보수정</button>
				</form>
			</div>
		</section>
		
	</div>
	<!-- ajax 종료 -->
</div>
