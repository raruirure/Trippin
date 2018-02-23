<%@page import="org.trippin.vo.PlanBean"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/result.css">
<link rel="stylesheet" type="text/css"href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="js/bs_leftnavi.js"></script>
<style>
	div.plan{
		margin:5px 0 5px 0;
     }
</style>
</head>

<body>

	<!--start of header-->
	<%@include file="../include/header.jsp"%>
	<!--end of header-->

	<!-- Left 메뉴 시작 -->
	<div class="columns">
		<div style="width:300px;">
		<%@include file="mypage_aside.jsp"%>
		</div>
		<!--  Left 메뉴 끝-->


		<!-- 메인 컨텐츠 시작 -->
		<div class="row" style="width:900px;">
			<div class="title is-2" style="margin-top: 20px">여행계획</div><hr>
			<%
				if(session.getAttribute("planList")!=null){
					ArrayList<PlanBean> planList = (ArrayList<PlanBean>)session.getAttribute("planList");
					for(int i=0; i<planList.size();i++){
						PlanBean plan = planList.get(i);
			%>
					<div class="col-lg-4" style="width:300px;">
					<div class="card plan">
				    	<div class="card-image">
				        	<figure class="image is-4by3">
				        		<%
				        			if(plan.getBanner_img() !=""){
				        		%>
				        			<img src="upload/<%=plan.getBanner_img() %>" alt="">
				        		<%		
				        			}else{
				        		%>
						        	<img src="http://placehold.it/300x225" alt="">	
						        <%		
				        			}
				        		%>
				            </figure>
				        </div>
				        <div class="card-content" style="height:60px;line-height: 60px;">
				        	<div class="content">
				            	<span class="tag is-dark"><%=plan.getMain_title() %></span>
				            </div>
				        </div>
				        <footer class="card-footer">
				        	<a class="card-footer-item"><i class="mdi mdi-heart" style="font-size:24px;"></i></a>
				            <a class="card-footer-item"><i class="material-icons">create</i></a>
				            <a href="planView.con?code=<%=plan.getCode() %>" class="card-footer-item"><i class="material-icons">search</i></a>
				        </footer>
					</div>
	            </div>	
			<%
					} // end of for
				} // end of if
			%>
	            <div class="col-lg-4" style="width:300px;">
					<div class="addReviewBox">
						<div class="card">
				            <a href="planWrite.con"><i class="fa fa-plus-circle fa-5x" aria-hidden="true" style="font-size: 80px; margin-bottom: 15px;"></i></a><br>
				            <span class="tag is-dark">#여행계획</span>
				        </div>
					</div>
	            </div>
		</div>
	</div>

	<%@include file="../include/footer.jsp"%>
	<script type="text/javascript" src="js/bulma.js"></script>
</body>
</html>