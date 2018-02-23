<%@page import="org.trippin.vo.MemberVo"%>
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

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" 	href="css/mypage/mypage_aside_bulma.css">

</head>
<style>
.nav-both1 {
	margin-bottom: 10px;
}

.serchBox input[type="text"] {
	width: 150px;
}
input[type="text"] {
	width: 100px;
}

.section {
	background-color: #fff;
	padding-left: 0;
	padding-right: 0;
}

.panel-heading {
	margin-botton: 0;
}


.panel-block{
	max-height: 500px; 
	width: 100%; 
	overflow-x: hidden; 
	overflow-y: scroll;"
}
div#adminBoard {
    min-width: 850px;
}

</style>

<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>
	<!-- content 시작 -->
	<div class="columns">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>
		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
			<div class="title is-2" style="margin-top: 20px">고객관리</div>
			<hr>				
		    <div class="nav-both1">
   				<button id="ccdBtn" class="button is-focused" onclick="loadSeller()">판매자</button>
				<button id="cadBtn" class="button is-focused" onclick="loadUser()">일반회원</button>
				<button id="ccdBtn" class="button is-focused" onclick="loadBlack()">블랙리스트</button>
			</div>
			<!-- 최초 페이지 include -->
			<section class="section">
				<div id="mypage_seller"></div>	
			</section>
		</div>
	</div>
		<!-- footer -->
		<jsp:include page="../include/footer.jsp"></jsp:include>
</body>

<script>
	$(document).ready(function(){
		$('#mypage_seller').load('admin_supervise_seller.mypage')
	})
</script>

<!-- ajax 부분 -->
<script>
    function loadUser() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	//각 페이지의 div id  adminBoard 를 불러온다.
                document.getElementById("adminBoard").innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("POST", "admin_supervise_user.mypage", true);
        xhttp.send();
    }
    
    function loadSeller() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("adminBoard").innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("POST", "admin_supervise_seller.mypage", true);
        xhttp.send();
    }    

    function loadBlack() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("adminBoard").innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("POST", "admin_supervise_blacklist.mypage", true);
        xhttp.send();
    }     
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
              "http://www.ftc.go.kr/info/bizinfo/communicationViewPopup.jsp?wrkr_no="+sellserMember.wrkr_no.a;
          window.open(url, "communicationViewPopup", "width=750, height=700;");
      }
  </script>
</html>