<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@page import="org.trippin.vo.CartVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/order/product_pay.css">
<script src="js/order/product_pay.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style>
.ppayTable th,.touristInfoTable th, .touristInfoTable td .ppayTable td{
	text-align:center;
	font-size: 15px;
}
</style>
</head>
<%
request.setCharacterEncoding("utf-8");
%>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="productContainer container">
		<div class="section">
		<form name="pPayForm" method="post">
			<div class="container">
				<div class="title is-2">상품결제</div>

				<div class="paySubTitle">
					<strong>상품정보</strong>
				</div>
				<div class="payTable">
					<table class="ppayTable table is-fullwidth">
						<tr>
							<th class="column is-2">지역</th>
							<th class="column is-4">상품명</th>
							<th class="column is-3">기간</th>
							<th class="column is-2">가격</th>
							<th class="column is-2">인원수</th>
						</tr>
						<%
						if(request.getAttribute("cartPayVo") != null){
							CartVo cartVo = (CartVo)request.getAttribute("cartPayVo");
						%>
						<tr>
							<td>
								<%=cartVo.getPro_category() %>
								<input type="hidden" name="pro_cd" value="<%=cartVo.getPro_cd() %>" />
								<input type="hidden" name="pro_detail_cd" value="<%=cartVo.getPro_detail_cd() %>" />
								<input type="hidden" name="pro_cnt" value="<%=cartVo.getCart_ea() %>" />
							</td>
							<td><%=cartVo.getPro_name() %></td>
							<td><%=cartVo.getPro_sdate() %> ~ <%=cartVo.getPro_edate() %></td>
							<td><%=cartVo.getPro_price()%></td>
							<td><%=cartVo.getCart_ea() %></td>
						</tr>
					</table>
				</div>
				<br>
				<br>

				<div class="paySubTitle">
					<strong>이용약관</strong>
				</div>
				<div class="accessterms box">
					환불은 7일 이내에만 가능합니다.
				</div>
				<div class="accessCheck">
					<strong><input type="checkbox" class="checkbox" style="width:20px;">
						전체 약관 내용을 확인하였으며, 약관에 동의합니다.</strong>
				</div>
				<br>
				<br>

				<div class="paySubTitle">
					<strong>여행자정보</strong>
				</div>
				<%
					if(session.getAttribute("member") != null){
						MemberVo member = (MemberVo)session.getAttribute("member");
				%>
				<div class="touristInfo">
					<table class="touristInfoTable table is-fullwidth">
						<tr>
							<th>이름</th>
							<th>생년월일</th>
							<th>메일주소</th>
						</tr>
						<tr>
							<td><%=member.getUserName() %></td>
							<td><%=member.getUserBirth() %></td>
							<td><%=member.getUserId() %>
								<input type="hidden" name="user_id" value="<%=member.getUserId() %>" />
							</td>
						</tr>
					</table>
				</div>
				<%
					} //end of member Session
				%>
				<br>
				<br>

				<div class="paySubTitle">
					<strong>결제정보</strong>
				</div>
				<div class="payInfo box">
					<strong>총 가격 </strong> &nbsp;&nbsp;&nbsp; 
					<strong class="payInfoPrice"><%=cartVo.getPro_price() * cartVo.getCart_ea() %></strong>
				</div>
				<div class="payCheck">
					<strong><input type="checkbox" class="checkbox" style="width:20px;" />
						전체 약관 내용을 확인하였으며, 약관에 동의합니다.</strong>
				</div>
				<br>
				<br>
				<div class="payBtnBox">
					<a class="payCancleBtn button is-primary">취소</a> 
					<a class="payOkBtn button is-primary">결제</a>
				</div>
			</div>
		</form>
		</div>
	</div>
	<% 	}//end of cartVO session 
	%>
	<!-- footer -->

</body>
<script type="text/javascript" src="js/bulma.js"></script>
<script>
$(".payOkBtn").click(function(){
	event.preventDefault();
	var pPayForm = document.pPayForm;
	pPayForm.method="post";
	pPayForm.action="product_pay_ok.order";
	pPayForm.submit();
});
$(".payCancleBtn").click(function(){
	event.preventDefault();
	location.href = "user_order_list.mypage";
});
</script>
</html>