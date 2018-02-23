<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구매정보</title>
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
.seller_purcahseInfoContainer{
    padding: 20px;
}
.pInfoTopTable th{
    text-align: center;
}
.pInfoSubTitle{
    padding-bottom: 5px;
    margin-bottom: 20px;
    border-bottom: 2px solid #dddddd;
}
.pInfoTopTitle{
    border-bottom: 2px solid #0D131E;
    padding-bottom: 10px;
}
</style>
</head>
<body>
	<div class="seller_purcahseInfoContainer container">
		<div>
			<p class="pInfoTopTitle title is-4">구매정보</p>
		</div>
		<br>
		<br>
		<div class="pInfoTopTable">
			<div class="pInfoSubTitle">
				<strong>구매 회원 정보</strong>
			</div>
			<table class="table is-bordered">
				<tr>
					<th class="column is-2">회원명</th>
					<td class="column is-2">김길동</td>
					<th class="column is-2">회원 아이디</th>
					<td class="column is-2">gildong11</td>
					<th class="column is-2">구매일</th>
					<td class="column is-2">2017.10.12</td>
				</tr>
			</table>
		</div>
		<br>

		<div class="pCanclePInfoBox">
			<div class="pInfoSubTitle">
				<strong>구매 정보</strong>
			</div>
			<div class="pInfoDetail box">구매 정보</div>
		</div>
	</div>
</body>
</html>