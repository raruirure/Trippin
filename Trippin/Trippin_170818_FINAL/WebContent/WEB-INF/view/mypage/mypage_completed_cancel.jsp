<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TRIPPIN</title>
    <link rel="icon" href="images/favicon_trippin.JPG">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/bs_leftnavi.js"></script>

</head>
<style>

    /******** order box *****/
    .media-body {
        width:50%;

    }
    .table thead tr th {
        text-align: center;
    }

</style>

<body>
<!--start of header-->
<%@include file="../include/header.jsp" %>
<!--end of header-->
<div class="columns">
   <%@include file="mypage_aside.jsp" %>
    <!--  Left 메뉴 끝-->

    <!-- 메인 컨텐츠 시작 -->
    <div class="content column is-9" >
        <div class="title is-2">취소가 완료되었습니다</div>

        <div class="container">
            <div class="row">
                <h2>제품정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th class=" col-md-1">출발일</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.05</strong></td>
                            <th class=" col-md-1">도착일</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.09</strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">상품명</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>북해도 코스</strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">경로</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>도쿄 오사카 북해도</strong></td>

                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="margin-top: 40px;">
                <h2>환불정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th class=" col-md-1">주문번호</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.05</strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">구매날짜</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.09</strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-9">환불날짜</th>
                            <td class="col-sm-9 col-md-1 text-center"><strong>2017.03.01</strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">상품명</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>세계일주 </strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">구매금액</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>1,200,000 </strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">환불금액</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>700,000</strong></td>
                            <th class=" col-md-1"></th>
                            <td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="margin-top: 40px;">
                <h2>여행자 정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>

                        <tr>
                            <th class=" col-md-1">여행자1</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.05</strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">여행자2</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>도쿄 오사카 북해도</strong></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

<%@include file="../include/footer.jsp" %>
    <script async type="text/javascript" src="../js/bulma.js"></script>
	

</body>
</html>