<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/board/board.css">
  <link rel="stylesheet" type="text/css" href="css/login.css">

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="js/header.js"></script>
  
</head>
<style>
.nav-both1 {
	margin-bottom: 10px;
}

input[type="text"] {
	width: 120px;
}

.section {
	background-color: #fff;
	padding-left: 0;
	padding-right: 0;
}

.panel-heading {
	margin-botton: 0;
}


</style>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="columns">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>
		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
			<div class="title is-2" style="margin-top: 20px">신고게시판</div>
			<hr>

			<div class="panel-block board">
				<table class="table board">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>신고자</th>
							<th>피신고자</th>
							<th>등록일</th>
							<th>신고횟수</th>
						</tr>
					</thead>
					<tbody>
						<tr class=board_notification_tr>
							<td class=board_notification_td></td>
							<td class=board_notification_td></td>
							<td onclick="userImgFunction()"><a></a></td>
							<td onclick="userImgFunction()"><a></a></td>							
							<td class=board_notification_td></td>
							<td class=board_notification_td></td>
						</tr>						
					</tbody>
				</table>
			</div>

			<nav aria-label="Page navigation">
			<ul class="pagination board">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">이전</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#">10</a></li>
				<li><a href="#">다음</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
			</nav>
			<!--       official mode
      <p class="p center margin_bottom"><a class="button is-info board">글쓰기</a></p> -->

			<br>
			<p class="board p1">
				<select class="board select">
					<option>제목</option>
					<option>글쓴이</option>
				</select> <input class="input search board" type="text" placeholder="입력">
				<a class="button is-outlined board"> <i class="material-icons">search</i>
				</a>
			</p>

		</div>

	</div>
	</div>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bs_leftnavi.js"></script>
<script src="js/order/mypage_product_cart.js"></script>
<script>
	function userImgFunction() {
		var myWindow = window.open("", "", "width=350,height=350");
	}
</script>
<script language="JavaScript">
      function onopen()
      {
          var url =
              "http://www.ftc.go.kr/info/bizinfo/communicationViewPopup.jsp?wrkr_no="+frm1.wrkr_no.value;
          window.open(url, "communicationViewPopup", "width=750, height=700;");
      }
  </script>
</html>