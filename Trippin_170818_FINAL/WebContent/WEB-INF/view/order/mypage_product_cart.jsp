
<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.vo.CartVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" type="text/css" href="css/order/mypage_product_cart.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<%
request.setCharacterEncoding("utf-8");
%>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="columns" style="min-height:700px;">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>
		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
			<div class="title is-2" style="margin-top: 20px">장바구니</div>
			<hr>
			<div>
			<form name = "cartTableForm" method="post">
				<table class="cartTable table is-narrow ">
					<tr id="ctTitle is-selected">
						<th><input name="allCheck" type="checkbox" /></th>
						<th>상품명</th>
						<th>기간</th>
						<th>상품가격</th>
						<th>수량</th>
						<th>구매예정가</th>
					</tr>
					
				 	
					<%
					if(session.getAttribute("cartList") == null){
					%>
						<tr class="stCon tr default">
							<td colspan="7"><strong>장바구니에 담긴 상품이 없습니다.</strong></td>
						</tr>
					<% 
					}else{
						ArrayList<CartVo> cartList =(ArrayList<CartVo>)session.getAttribute("cartList");
						for(int i=0;i<cartList.size();i++){
							CartVo cartVo = cartList.get(i);	
					%>
					<tr class="stCon tr default" id="<%=cartVo.getPro_cd()%>">
						<td><input name="RowCheck" type="checkbox" value="<%= cartVo.getNo()%>"/></td>
						<td>
							<%=cartVo.getPro_name() %>
							<input type="hidden" name="pro_detail_cd" value="<%=cartVo.getPro_detail_cd()%>" />
						</td>
						<td><%=cartVo.getPro_sdate() %> ~ <%=cartVo.getPro_edate() %></td>
						<td><%=cartVo.getPro_price() %></td>
						<td><input name="cart_ea" type="text" style="width:30px;" value="<%=cartVo.getCart_ea() %>" />
							<input type="button" class="cartBtn button is-hovered" value="수정" /></td>
						<td><%=cartVo.getPro_price() * cartVo.getCart_ea() %></td>
					</tr>
					<%
						} //end of for
					} //end of else
					%>
				</table>
				<hr>
				<button type="button" id="ccdBtn" class="button is-focused">선택삭제</button>
				<button type="button" id="cadBtn" class="button is-focused">전체삭제</button>
				<button type="button" id="cpBtn" class="button is-info is-focused">주문하기</button>
			</form>
			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bs_leftnavi.js"></script>
<script>
$(".cartTable tr:not(:first-child) td:nth-child(2)").each(function(idx,item){
	$(item).click(function(){
		var id = $(this).parent().attr('id');
		location.href = "productDetail.con?pro_cd="+id;
	})
})

//수정버튼
$(".cartBtn").click(function(){
	event.preventDefault();
	var cartForm = $("form[name=cartTableForm]");
	cartForm.action = "mp_cart_updateEa.order";
	cartForm.method="post";
	cartForm.submit();
});

$('input[name=allCheck]').on('change', function(){
	  $('input[name=RowCheck]').prop('checked', this.checked);
});

	
$("#cpBtn").click(function(){
	var chk_ProCD = "";
	var procd = "";
	$("input[name=RowCheck]:checked").each(function() {
		procd = $(this).attr('value');
		chk_ProCD = chk_ProCD + procd + "/";
		console.log(procd);
	});
	if(chk_ProCD==""){
		alert("주문할 상품을 선택해주세요!");
		return;
	}
	location.href="product_pay.order?no="+procd; 
});

/* 
 * 전체삭제
 	$("#cadBtn").click(function(){
	var chk_ProCD = "";
	var procd = "";
	$("input[name=RowCheck]:checked").each(function() {
		procd = $(this).attr('value');
		chk_ProCD = chk_ProCD + procd + "/";
		//console.log(procd);
	
	});
	if(chk_ProCD==""){
		alert("삭제할 상품을 선택해주세요!");
		return;
	}
	location.assign("mp_cart_delete.order?no="+procd);
}); */
$("#ccdBtn").click(function(){
	var chk_ProCD = "";
	var procd = "";
	$("input[name=RowCheck]:checked").each(function() {
		procd = $(this).attr('value');
		chk_ProCD = chk_ProCD + procd + "/";
		//console.log(procd);
	
	});
	if(chk_ProCD==""){
		alert("삭제할 상품을 선택해주세요!");
		return;
	} 
	location.assign("mp_cart_delete.order?no="+procd);
});

</script>
</html>