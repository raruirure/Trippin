<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>취소정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
	
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style>
.seller_purcahseCancleContainer{
    padding: 20px;
}
.pCancleTopTable th{
    text-align: center;
}
.pCancleSubTitle{
    padding-bottom: 5px;
    margin-bottom: 20px;
    border-bottom: 2px solid #dddddd;
}
.pCancleTopTitle{
    border-bottom: 2px solid #0D131E;
    padding-bottom: 10px;
}
button.pCancleBtn{
    background-color: #ddd;
}
</style>
</head>
<body>
	<div class="seller_purcahseCancleContainer container">
		<div>
			<p class="pCancleTopTitle title is-4">취소 요청 상품</p>
		</div>
		<br>
		<br>
		<div class="pCancleTopTable">
			<div class="pCancleSubTitle">
				<strong>취소 요청 회원 정보</strong>
			</div>
			<table class="table is-bordered">
				<tr>
					<th class="column is-3">회원명</th>
					<td class="column is-3">김길동</td>
					<th class="column is-3">회원 아이디</th>
					<td class="column is-3">gildong11</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="pCanclePInfo">
			<div class="pCancleSubTitle">
				<strong>구매 정보</strong>
			</div>
			<div class="pCanclePInfoBox box">구매 정보</div>
		</div>
		<hr>
		<div class="pCancleBtnBox">
			<button class="pCancleBtn button is-fullwidth">취소 요청 승인</button>
		</div>
	</div>
</body>
</html>