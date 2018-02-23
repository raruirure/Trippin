<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.trippin.vo.LocationBean"%>
<!DOCTYPE html>
<html> 
<head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" /> 
  <title>Google Maps Multiple Markers</title> 
  <script src="http://maps.google.com/maps/api/js?sensor=false" 
          type="text/javascript"></script>
  <style>
  	#map{
  		height:380px;
  	}
  </style>
</head>
<%
	LocationBean loc = (LocationBean)session.getAttribute("loc");
%> 
<body>
  <div id="map"></div>
  <input type="hidden" value="">
  <script type="text/javascript">
  function init() {
	var pointX1 = "<%=loc.getPointX1()%>";
	var pointY1 = "<%=loc.getPointY1()%>";
	var pointX2 = "<%=loc.getPointX2()%>";
	var pointY2 = "<%=loc.getPointY2()%>";
	var pointX3 = "<%=loc.getPointX3()%>";
	var pointY3 = "<%=loc.getPointY3()%>";
	var pointX4 = "<%=loc.getPointX4()%>";
	var pointY4 = "<%=loc.getPointY4()%>";
	var pointX5 = "<%=loc.getPointX5()%>";
	var pointY5 = "<%=loc.getPointY5()%>";
	var pointX6 = "<%=loc.getPointX6()%>";
	var pointY6 = "<%=loc.getPointY6()%>";
	var pointX7 = "<%=loc.getPointX7()%>";
	var pointY7 = "<%=loc.getPointY7()%>";
	var pointX8 = "<%=loc.getPointX8()%>";
	var pointY8 = "<%=loc.getPointY8()%>";
	var pointX9 = "<%=loc.getPointX9()%>";
	var pointY9 = "<%=loc.getPointY9()%>";
	var pointX10 = "<%=loc.getPointX10()%>";
	var pointY10 = "<%=loc.getPointY10()%>";
    var locations = [
      ['A',pointX1 ,pointY1 , 1],
      ['B',pointX2 ,pointY2 , 2],
      ['C',pointX3 ,pointY3 , 3],
      ['D',pointX4 ,pointY4 , 4],
      ['E',pointX5 ,pointY5 , 5],
      ['F',pointX6 ,pointY6 , 6],
      ['G',pointX7 ,pointY7 , 7],
      ['H',pointX8 ,pointY8 , 8],
      ['I',pointX9 ,pointY9 , 9],
      ['G',pointX10 ,pointY10 , 10]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 14,
      center: new google.maps.LatLng(pointX1, pointY1),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i][0]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  }
  </script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA9LyjdZ5Cw5XuC0eEGNLNA1xa1R_Zkd8I &libraries=places&callback=init"
         async defer></script>
</body>
</html>