<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" type="text/css" href="css/seller/seller_customer_manage.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="columns">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>

		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
			<div class="title is-2" style="margin-top: 20px">고객관리</div>
			<hr>
			<div class="cmbox box">
				<div class="cmListTitle box">
					<strong>구매 고객 목록</strong>
				</div>
				<div class="cmListCon">
					<table class="cmListtable table">
						<tr>
							<th class="column is-1"><input type="checkbox"></th>
							<th class="column is-2">지역</th>
							<th class="column is-3">상품명</th>
							<th class="column is-2">총인원수</th>
							<th class="column is-2">총가격</th>
							<th class="column is-2">구매자아이디</th>
						</tr>
						<tr class="cmListTr">
							<td><input type="checkbox"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
			<input type="button" class="cmListBtn button" value="구매정보"
				onclick="seller_purchaseInfo();">

			<div class="cmbox2 box">
				<div class="cmCancleTitle box">
					<strong>구매 취소 신청</strong>
				</div>
				<div class="cmCancleCon">
					<table class="cmCancletable table">
						<tr>
							<th class="column is-1"><input type="checkbox"></th>
							<th class="column is-2">지역</th>
							<th class="column is-3">상품명</th>
							<th class="column is-2">총인원수</th>
							<th class="column is-2">총가격</th>
							<th class="column is-2">구매자아이디</th>
							<th class="column is-2">취소여부</th>
						</tr>
						<tr>
							<td><input type="checkbox"></td>
							<td>123</td>
							<td>123</td>
							<td>123</td>
							<td>123</td>
							<td>111</td>
							<td>123</td>
						</tr>
					</table>
				</div>
			</div>

			<div class="cpBtnDiv">
				<input type="button" class="cmCCanBtn button" value="선택취소"
					onclick="seller_purchaseCancle();"> <input type="button"
					class="cmACanBtn button" value="전체취소">
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>

<script type="text/javascript" src="js/bulma.js"></script>
<script src="js/bs_leftnavi.js"></script>
<script type="text/javascript" src="js/seller/seller_purchaseInfo.js"></script>
<script type="text/javascript" src="js/seller/seller_purchaseCancle.js"></script>
<script type="text/javascript" src="js/seller/seller_customer_manage.js"></script>

</html>