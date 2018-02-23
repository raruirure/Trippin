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
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="js/bs_leftnavi.js"></script>
</head>
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
        document.getElementById(id).setAttribute("class", "fa fa-check-square-o fa-5x");
    };


</script>
<body>

<!--start of header-->
<%@include file="../include/header.jsp" %>
<!--end of header-->

<!-- Left 메뉴 시작 -->
<div class="columns">
   <%@include file="mypage_aside.jsp" %>
    <!--  Left 메뉴 끝-->


    <!-- 메인 컨텐츠 시작 -->
    <div class="content column is-9" >
        <div class="title is-2" style="margin-top: 20px">결제정보</div>
        <hr>
        <div class="container">
            <div class="row">
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
                                <div class="media-body" >
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
                <h2 class=" col-md-9">여행정보</h2>
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
                            <td class="col-sm-1 col-md-1 text-center" colspan="3"><strong>북해도 코스</strong></td>
                        </tr>
                        <tr>
                            <th class=" col-md-1">경로</th>
                            <td class="col-sm-1 col-md-1 text-center" colspan="3"><strong>도쿄 오사카 북해도</strong></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="margin-top: 40px;">
                <h2 class=" col-md-9">환불정보</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>
                        <div class="box">
                            <p>환불에 대해서는 일체 책임지지않습니다 </p>
                            <br>
                            <p>수수료에 대해서도 일체 책임지지않습니다 </p>
                            <br>
                        </div>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="margin-top: 40px;">
                <h2 class=" col-md-9">취소약관</h2>
                <div class=" col-md-9">
                    <table class="table">
                        <tbody>

                        <div class="box">
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ligula magna, tempus sed nisi in, convallis porttitor quam. Quisque auctor nisl metus, quis rhoncus mi molestie non. Phasellus ornare nisi et lobortis lacinia. Mauris quis dolor vulputate, malesuada lacus at, gravida ipsum. Nam a viverra mi. Aenean at consequat libero, in porta diam. In id ipsum nec purus mattis blandit quis sed nisi. Suspendisse nulla tellus, viverra eu urna ut, mollis pulvinar sem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin non magna sagittis, facilisis augue sed, ultricies felis. Mauris at neque sed nisl mollis aliquet. Etiam lacinia auctor dolor, sed condimentum odio efficitur a.
                            </p><br><p>

                            Sed at risus enim. Nunc aliquet tellus a purus blandit lobortis. Duis condimentum sapien sed orci ornare mollis. Praesent eleifend ante magna, quis commodo risus pellentesque in. Donec eget porta leo. Sed vel dictum est. Ut dui lorem, volutpat vel risus in, dictum euismod ex. Aenean laoreet dapibus nulla, nec viverra massa feugiat vitae. Vestibulum elementum nec nisi dictum rhoncus. Nam placerat mi eu tortor tincidunt commodo. Duis posuere, sapien a laoreet dapibus, elit tortor laoreet est, eget dapibus dui justo vitae ipsum. Praesent sed augue nec leo hendrerit iaculis sit amet efficitur ante. Nunc ac maximus mauris. Sed luctus erat id elit tempor, a aliquam lacus sodales.
                        </p><br><p>

                            Suspendisse sodales metus justo, ullamcorper iaculis purus interdum in. Sed ultricies enim felis, in interdum urna malesuada a. Morbi id ligula vel leo elementum dignissim quis vel purus. Donec iaculis, est ac maximus vestibulum, sapien mi lacinia urna, at laoreet felis lectus nec urna. Fusce egestas, neque vitae blandit scelerisque, leo arcu pellentesque risus, et volutpat neque nunc id massa. Aenean dapibus leo vel purus malesuada, eu ultrices nulla consequat. Duis erat orci, lobortis sed dictum id, pretium a nibh. Mauris pharetra ligula consequat gravida ornare.
                        </p><br><p>

                            Sed a gravida sapien. Nam malesuada feugiat nunc, eu varius risus suscipit non. Nulla vitae odio fermentum, varius ligula et, iaculis enim. Mauris tempor in dolor non aliquet. Pellentesque ac mauris a augue tempus pharetra. Nulla facilisi. Vivamus sit amet lacus sagittis, ullamcorper nisi sit amet, consequat eros. Sed faucibus nulla vitae erat tristique ornare.
                        </p><br><p>

                            Nullam sit amet magna ipsum. In tincidunt tincidunt tellus. Duis maximus vulputate elit sit amet auctor. Vestibulum a nunc consectetur, accumsan arcu eu, dapibus est. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec vitae massa eget nulla gravida porta eu et sem. Sed in lorem id lectus auctor lobortis sed vel libero. Nam dapibus risus eu sodales consectetur. Fusce luctus sollicitudin ante et sodales. Curabitur eget justo turpis. Vestibulum vel nunc tellus. Morbi accumsan urna nibh, at malesuada odio faucibus accumsan.
                        </p>

                        </div>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-8 col-md-offset-1" align="center" style="text-align:right;">
                <label for="entry.status" class="col-md-8" style=" float:right;">
                    <input style="width:20px;" type="checkbox" name="entry.1990496676" id="entry.status" value="check" required="">
                    상기내용을 확인하였습니다. </label><br><br>
                <button type="button" id="child1" class="btn btn-success" >돌아가기</button>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#productCancel">취소하기</button>
            </div>
            <!-- container -->
        </div>
        <!-- container -->
    </div>




    <!-- Modal -->
    <div class="modal fade" id="productCancel" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">취소확인</h4>
                </div>
                <div class="modal-body">
                    <p>구매하신 제품을 취소하시겠습니까?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-info order_completed_cancel"  data-dismiss="modal"><a href="취소완료.html" >ok</a></button>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="../include/footer.jsp" %>

</body>
<script type="text/javascript" src="js/bulma.js"></script>

<script>
    $(document).ready(function(){
        $("#myBtn").click(function(){
            $("#myModal").modal();
        });
    });
</script>
</html>

