<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=8" />

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
    <script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <script src="js/bs_leftnavi.js"></script>

</head>
<style>
    

</style>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyARgVOTeLt21uD8ln4sQS29UvDcVv92ANE"></script>
<script>
    // In the following example, markers appear when the user clicks on the map.
    // Each marker is labeled with a single alphabetical character.
    var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var labelIndex = 0;

    function initialize() {
        var bangalore = { lat: 12.97, lng: 77.59 };
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: bangalore
        });

        // This event listener calls addMarker() when the map is clicked.
        google.maps.event.addListener(map, 'click', function(event) {
            addMarker(event.latLng, map);
        });

        // Add a marker at the center of the map.
        addMarker(bangalore, map);
    }

    // Adds a marker to the map.
    function addMarker(location, map) {
        // Add the marker at the clicked location, and add the next-available label
        // from the array of alphabetical characters.
        var marker = new google.maps.Marker({
            position: location,
            label: labels[labelIndex++ % labels.length],
            map: map
        });
    }

    google.maps.event.addDomListener(window, 'load', initialize);
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
    <div class="content column is-9">
        <div class="title is-2" style="margin-top: 20px">관심경로</div>
        <hr>
        <!-- map box -->
        <div class="nav map">
            <div id="map"></div>
        </div>
        <!-- map box -->
        <div class="row" style="margin-top: 10px; margin-left: 15px;">
            <div class=" col-md-11">
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
                        <td class="col-sm-1 col-md-1 text-center"></td>
                    </tr>
                    <tr>
                        <th class=" col-md-1">경로</th>
                        <td class="col-sm-1 col-md-1 text-center"><strong>도쿄 오사카 북해도</strong></td>
                        <th class=" col-md-1"></th>
                        <td class="col-sm-1 col-md-1 text-center"></td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" id="child1" class="btn btn-success" style="float:right">삭제하기</button>
            </div>
        </div>

    </div>
</div>


<%@include file="../include/footer.jsp" %>
</body>
<script async type="text/javascript" src="js/bulma.js"></script>
<script>

    $(function() {
        $("#clickMe").click(
            function(){
                $("#dialog1").dialog({modal:true,open:function() { },width:300});
            });
    });

</script>
</html>