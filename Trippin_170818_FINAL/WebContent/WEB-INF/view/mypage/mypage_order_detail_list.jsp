<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/bs_leftnavi.js"></script>

<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
<style>

    /******** order box *****/
    .media-body {
        width:80%;

    }
    .table thead tr th {
        text-align: center;
    }

</style>

<script>
    function change(id){
        document.getElementById(id).setAttribute("class", "fa fa-check-square-o fa-2x");
    };


</script>
<body>
<%@include file="../include/header.jsp" %>
<!-- Left 메뉴 시작 -->
<div class="columns">

   <%@include file="mypage_aside.jsp" %>
    <!--  Left 메뉴 끝-->


    <!-- 메인 컨텐츠 시작 -->
    <div class="content column is-9" >
        <div class="title is-2">주문상세정보</div>

        <div class="container">
            <div class="row">
                <h2>제품정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class=" col-md-2">주문번호/주문일</th>
                            <th class="col-md-6">상품명</th>
                            <th class="text-center col-md-1">수량</th>
                            <th class="text-center col-md-1">결제금액</th>
                        </tr>
                        </thead>
                        <tbody>
                        <td class="col-sm-1 col-md-1 text-center"><strong>4407-12053</strong></td>
                        <td >
                            <div class="media">
                                <a class="thumbnail" href="#" style="margin-right: 25px"> <img class="media-object"  style="width: 72px; height: 72px;"> </a>
                                <div class="media-body">
                                    <a href="#">◈관광형◈푸껫 5일_[최고의s 위치] 베스트웨스턴 | 마사지+열대과일 5종세트</a>
                                    <!--  <h5 class="media-heading"> by <a href="#">하나 투어</a></h5>
                                      <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>-->
                                </div>
                            </div>
                        </td>
                        <td class="text-center"><strong>2</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong></strong>1,200,000</td>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row" style="margin-top: 40px;">
                <h2>여행정보</h2>
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
                            <th class=" col-md-1">여행자1</th>
                            <td class="col-sm-1 col-md-1 text-center"><strong>2017.01.05</strong></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="margin-top: 40px;">
                <h2>취소정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th class=" col-md-1">취소약관</th>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5 col-md-offset-5" align="center">
                <i id="item" class="fa fa-square-o fa-2x" onclick="change(this.id)"></i>
                <button type="button" id="child1" class="btn btn-success" >돌아가기</button>
                <button type="button" class="btn btn-info" id="myBtn">구매취소</button>
            </div>
        </div>
    </div>
</div>

<%@include file="../include/footer.jsp" %>
    <script async type="text/javascript" src="../js/bulma.js"></script>

</body>
</html>