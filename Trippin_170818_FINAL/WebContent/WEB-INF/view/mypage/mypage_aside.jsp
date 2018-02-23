
<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	MemberVo member = (MemberVo)session.getAttribute("member");
	
	%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside.css">
<script src="js/mypage/mypage_aside.js"></script>
<style>
.gw-container.gw-main-container .gw-sidebar.gw-sidebar-fixed,
	.gw-container.gw-main-container .gw-sidebar.gw-sidebar-fixed:before {
	left: auto
}

.gw-sidebar {
	width: 320px;
	position: fixed;
	border: 1px solid #e5e5e5;
	border-width: 0 1px 0 0;
	background-color: #F2F2F2;
	bottom: 0;
	top: 0;
	left: 0;
}

.gw-sidebar .nano-pane {
	background: rgba(255, 255, 255, 0);
	font-size: 15px;
}

.gw-sidebar .gw-nav-list {
	border-right: 1px solid #CCC;
}

.gw-sidebar .gw-nav-list li a {
	padding-left: 20px;
}

.gw-nav-list {
	margin: 0;
	padding: 0;
	list-style: none
}

.gw-nav-list>li:first-child {
	border-top: 0;
}

.gw-nav-list>li {
	display: block;
	padding: 0;
	margin: 0;
	border: 0;
	border-top: 1px solid #fcfcfc;
	border-bottom: 1px solid #e5e5e5;
	position: relative;
	text-decoration: none;
}

@
-webkit-keyframes
    arrow-slide { 0% {
	
}

100%
{
-webkit-transform
:rotate(225deg)
;

            
z-index
:
3

        
}
}
@
-webkit-keyframes
    arrow-slide1 { 0% {
	
}

100%
{
-webkit-transform
:rotate(225deg)
;

            
z-index
:
3

        
}
}
.gw-nav-list>li.arrow-down:after {
	content: '';
	width: 7px;
	height: 7px;
	position: absolute;
	right: 10px;
	top: 15px;
	border-top: 1px solid #bababa;
	border-left: 1px solid #bababa;
	-webkit-transform: rotate(45deg);
	-webkit-animation: arrow-slide .5s 0s ease both;
}

.gw-nav-list>li.init-arrow-down:after {
	content: '';
	width: 7px;
	height: 7px;
	position: absolute;
	right: 10px;
	top: 15px;
	border-right: 1px solid #bababa;
	border-bottom: 1px solid #bababa;
	-webkit-transform: rotate(45deg);
}

.gw-nav-list>li.arrow-up:after {
	content: '';
	width: 7px;
	height: 7px;
	position: absolute;
	right: 10px;
	top: 15px;
	border-right: 1px solid #bababa;
	border-bottom: 1px solid #bababa;
	-webkit-transform: rotate(45deg);
	-webkit-animation: arrow-slide1 .5s 0s ease both;
}

.gw-nav-list>li.init-arrow-up:after {
	content: '';
	width: 7px;
	height: 7px;
	position: absolute;
	right: 10px;
	top: 15px;
	border-top: 1px solid #bababa;
	border-left: 1px solid #bababa;
	-webkit-transform: rotate(45deg);
}

.gw-nav-list>li.active {
	background-color: #232B2D;
}

.gw-nav-list>li>a {
	display: block;
	height: 38px;
	line-height: 36px;
	padding: 0 16px 0 14px;
	color: white;
	text-shadow: none !important;
	font-size: 13px;
	text-decoration: none;
}

.gw-open>a {
	outline: 0;
}

.gw-nav-list>li.gw-open {
	border-bottom-color: #e5e5e5
}

.gw-nav-list>li.gw-open>a {
	background-color: #fafafa;
	color: #1963aa
}

.gw-nav-list .gw-open>a, .gw-nav-list .gw-open>a:hover, .gw-nav-list .gw-open>a:focus
	{
	background-color: #fafafa
}

.gw-nav .gw-open>a, .gw-nav .gw-open>a:hover, .gw-nav .gw-open>a:focus {
	background-color: #eee;
	border-color: #428bca;
}

.gw-nav-list>li.active>a, .gw-nav-list>li.active>a:hover, .gw-nav-list>li.active>a:focus,
	.gw-nav-list>li.active>a:active {
	background-color: #232b2d color: #F5F7FA;
	font-weight: bold;
	font-size: 13px;
}

.gw-nav-list>li>a, .gw-nav-list .gw-nav-header {
	margin: 0
}

.gw-nav-list>li.active>a>[class*="icon-"] {
	font-weight: normal
}

.gw-nav-list>li.active>a:hover:before {
	display: none
}

.gw-nav-list>li.active:before {
	display: inline-block;
	content: "";
	position: absolute;
	right: -2px;
	top: -1px;
	bottom: 0;
	z-index: 1;
	border: 2px solid #1fc8db;
	border-width: 0 2px 0 0
}

.gw-nav-list li.gw-open>a:after {
	display: none
}

.gw-nav-list>li a>.gw-arrow {
	display: inline-block;
	width: 14px !important;
	height: 14px;
	line-height: 14px;
	text-shadow: none;
	font-size: 18px;
	position: absolute;
	right: 11px;
	top: 11px;
	padding: 0;
	color: #666
}

.gw-nav-list>li a:hover>.gw-arrow, .gw-nav-list>li.active>a>.gw-arrow,
	.gw-nav-list>li.gw-open>a>.gw-arrow {
	color: #1963aa
}

.gw-nav-list>li>a>[class*="icon-"]:first-child {
	display: inline-block;
	vertical-align: middle;
	min-width: 30px;
	text-align: center;
	font-size: 18px;
	font-weight: normal;
	margin-right: 2px
}

.gw-nav-list>li.active .gw-submenu {
	display: block -webkit-box-shadow: inset 0px 0px 5px rgba(0, 0, 0, 0.13);
	-moz-box-shadow: inset 0px 0px 5px rgba(0, 0, 0, 0.13);
	box-shadow: inset 0px 0px 5px rgba(0, 0, 0, 0.13);
}

.gw-nav-list>li .gw-submenu {
	font-size: 13px;
	display: none;
	list-style: none;
	margin: 0;
	padding: 0;
	position: relative;
	background-color: rgba(35, 43, 45, 0.3);
	border-top: 1px solid #e5e5e5;
}

.gw-submenu {
	background-color: #fff;
}

.gw-nav-list>li .gw-submenu>li {
	margin-left: 0;
	position: relative
}

.gw-nav-list>li .gw-submenu>li>a {
	display: block;
	position: relative;
	color: #616161;
	padding: 7px 0 9px 43px;
	margin: 0;
	border-top: 1px dotted #e4e4e4;
	font-size: 14px;
	text-decoration: none;
}

.gw-nav-list>li .gw-submenu>li>a:focus {
	text-decoration: none
}

.gw-nav-list>li .gw-submenu>li>a:hover {
	text-decoration: none;
	color: #1fc8db;
	background-color: rgba(25, 25, 50, 0.1);
}

.gw-nav-list>li .gw-submenu>li.active:after {
	display: inline-block;
	content: "";
	position: absolute;
	right: -1px;
	top: -1px;
	bottom: 0;
	z-index: 1;
	border: 2px solid #1fc8db;
}

.gw-nav-list>li .gw-submenu>li.active>a {
	color: #1fc8db
}

.gw-nav-list>li .gw-submenu>li a>[class*="icon-"]:first-child {
	display: none;
	font-size: 12px;
	font-weight: normal;
	width: 18px;
	height: auto;
	line-height: 12px;
	text-align: center;
	position: absolute;
	left: 10px;
	top: 11px;
	z-index: 1;
	background-color: #FFF
}

.gw-nav-list>li .gw-submenu>li.active>a>[class*="icon-"]:first-child,
	.gw-nav-list>li .gw-submenu>li:hover>a>[class*="icon-"]:first-child {
	display: inline-block
}

.gw-nav-list>li .gw-submenu>li.active>a>[class*="icon-"]:first-child {
	color: #c86139
}

.gw-nav-list>li>.gw-submenu>li:first-child>a {
	border-top: 0px;
}

.gw-nav-list li .gw-submenu {
	overflow: hidden
}

.gw-nav-list li.active.gw-open>.gw-submenu>li.active.gw-open>a.dropdown-toggle:after
	{
	display: none
}

.gw-nav-list li.active>.gw-submenu>li.active>a:after {
	display: none
}

.gw-nav-list li.active.gw-open>.gw-submenu>li.active>a:after {
	display: block
}

.gw-nav-tabs li[class*=" icon-"], .nav-tabs li[class^="icon-"] {
	width: 1.25em;
	display: inline-block;
	text-align: center
}
</style>

<aside class="leftbox is-2 aside hero is-fullheight is-hidden-mobile">
	<div>
		<!-- profile box 시작 -->
		<div class="profile-box has-text-centered">

			<%
			if(session.getAttribute("member")==null){
					
			%>
				<img src="http://placehold.it/300x225" alt="">	
			<%
			}else {
			%>	
				<img src="upload/<%=member.getUserProfile() %>">

			<%
			}
			%>
		
		
		
			<div class="card-content">
				<div class="card-user">
					<div class="card-user-name">
						<a ><%=member.getUserName() %></a> <!-- <a href="#" id="clickMe"> -->
						<!-- <i onclick="imgPopup()" class="fa fa-camera-retro fa-2x" style="font-size:20px;"></i></a> -->
					</div>
				</div>
			</div>
		</div>

		<!-- profile box 끝 -->

		<!-- left Content 시작 -->
		<div class="main list-group no-border"
			style="padding: 0; margin: 0;">
			<ul class="sidebar" class="slidebar">
				<div class="left-bar list-group no-border">
					<ul class="gw-nav gw-nav-list">
						<%
				        if(session.getAttribute("member")!=null){
				        	
				    		if(member.getUserLevel()==1){
						%>
					
						<li class="init-un-active"><a href="user_review.mypage"> <span
								class="icon" style="width: 40px; margin-top: 5px;">
								<i class="fa fa-home"></i></span>
								<span class="name ">여행후기</span></a></li>
						<li class="init-un"><a href="user_plan.mypage"> <span
								class="icon" style="width: 40px; margin-top: 5px;"><i
									class="fa fa-map-marker"></i></span><span class="name">여행계획</span></a></li>
						
						<li class="init-arrow-down"><a href="javascript:void(0)"><span
								class="icon" style="width: 40px; margin-top: 5px;"><i
									class="fa fa-shopping-cart"></i></span><span class="name">주문관리</span></a>
							<ul class="gw-submenu">
								<li><a href="mypage_product_cart.order">장바구니</a></li>
								<li><a href="user_order_list.mypage">주문내역</a></li>
							</ul></li>
							
						<li class="init-un"><a href="user_path.mypage"> <span
								class="icon" style="width: 40px; margin-top: 5px;"><i
									class="fa fa-thumbs-up"></i></span><span class="name">관심경로</span></a></li>
						<li class="init-un"><a href="user_modify.mypage"><span class="icon"
								style="width: 40px; margin-top: 5px;"><i
									class="fa fa-pencil"></i></span><span class="name">정보수정</span></a>
						</li>
						<%
				    		}else if(member.getUserLevel()==2){
						%>
						
						<!-- 판매자 메뉴 -->
						<li class="init-arrow-down"><a href="javascript:void(0)"><span
								class="icon" style="width: 40px; margin-top: 5px;"><i
									class="fa fa-shopping-cart"></i></span><span class="name">판매관리</span></a>
							<ul class="gw-submenu">
								<li><a href="seller_product_manage.seller">상품관리</a></li>
								<li><a href="seller_customer_manage.seller">고객관리</a></li>
							</ul>
						</li>
						<li class="init-un"><a href="user_modify.mypage"><span class="icon"
								style="width: 40px; margin-top: 5px;"><i
									class="fa fa-pencil"></i></span><span class="name">정보수정</span></a>
						</li>
						<%
				    		}else if(member.getUserLevel()==3){
						%>
						
						<!-- 관리자 메뉴 -->
						<li class="init-arrow-down"><a href="javascript:void(0)"><span
								class="icon" style="width: 40px; margin-top: 5px;"><i
									class="fa fa-cogs"></i></span><span class="name">관리자 메뉴</span></a>
							<ul class="gw-submenu">
								<li><a href="admin_supervise.mypage">고객관리</a></li>
								<li><a href="admin_report.mypage">신고게시판</a></li>
							</ul>
						</li>
						<%
				    		}
				        }
						%>	
					</ul>
				</div>

			</ul>
		</div>


		<!-- left Content 끝 -->
	</div>
</aside>

<!-- 이미지 업로드 스크립트 -->
<script>
function imgPopup(){
	var imgPopup = window.open('mypage_imgpopup.mypage','','width=550,height=300');

}


</script>

