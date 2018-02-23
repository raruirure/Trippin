<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.trippin.vo.MemberVo"%>
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
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" type="text/css"
	href="css/seller/seller_product_manage.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

</head>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="columns">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>

		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
		
			<div class="title is-2" style="margin-top: 20px">상품관리</div>
			<hr>
			<div class="pmbox box">
				<div class="pmListTitle box">
					<strong>등록 상품 목록</strong>
				</div>
				<div class="pmListCon">
					<table class="pmtable table">
						<tr>
							<th class="column is-1"><input type="checkbox" id="checkAll"></th>
							<th class="column is-2">상품번호</th>
							<th class="column is-2">지역</th>
							<th class="column is-3">상품정보</th>
							<th class="column is-2">가격</th>
							<th class="column is-2">등록일</th>
						</tr>
						<%
							if (request.getAttribute("proList") != null) {
								ArrayList<ProductVo> prolist = (ArrayList<ProductVo>) request.getAttribute("proList");
								for (ProductVo vo : prolist) {
						%>
						<tr class="productlist" id="<%= vo.getPro_cd() %>">
							<th>
								<input type="checkbox" class="chk" value=<%= vo.getPro_cd() %>>
								<input class="disControl" type="hidden" value="<%= vo.getPro_display()%>">
							</th>
							<td><%= vo.getPro_cd() %></td>
							<td><%= vo.getPro_category() %></td>
							<td><%= vo.getPro_name() %></td>
							<td><%= vo.getPro_price() %></td>
							<td><%= vo.getPro_rdate() %></td>
						</tr>
						<%
						}
							}
						%>

					</table>
				</div>
			</div>
			<input id="registPro" type="button" class="pmBtn button is-primary" value="신규등록">
				<input id="deletePro" type="button" class="pmBtn button is-primary" value="삭제">
		</div>
	</div>

	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
<script>
$("#registPro").click(function(){
	<%
				MemberVo member = (MemberVo)session.getAttribute("member");
				if(member.isSellerState()==2) {
	%>	
					location.assign("seller_product_upload.seller");
	<%			
				} else {
					%>
					alert("관리자의 승인이 진행중입니다!");
					<%
				}
	%>
});
$(".productlist td").click(function() {
	var id = $(this).parent().attr('id');
	var display = $(this).parent().find('.disControl').val();
	if(display!=1) {
		alert("존재하지 않는 상품정보 입니다! 관리자에게 문의해주세요");
	} else {
		location.href = "productDetail.con?pro_cd="+id;
	}
})

</script>
<script type="text/javascript" src="js/bulma.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bs_leftnavi.js"></script>
<script src="js/seller/seller_product_manage.js"></script>

</html>