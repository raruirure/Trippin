<%@page import="org.trippin.vo.MemberVo"%>
<%@page import="org.trippin.vo.LocationBean"%>
<%@page import="org.trippin.vo.ReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
<link rel="stylesheet" type="text/css" href="css/reviewplan.css">
<link rel="stylesheet" type="text/css" href="css/calendar.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
</head>
<body>
	<jsp:include page="../include/header.jsp"></jsp:include>

	<!-- header 끝 -->
	<%
		if(session.getAttribute("review")!=null){
			ReviewBean review = (ReviewBean)session.getAttribute("review");
	%>
	
	<!-- review_form -->
	<div class="container review_form">
		<!-- review_form_name -->
		<div class="section review_view_heading">
			<div class="columns">
				<div class="column">
					<div class="review_name box"><%=review.getMain_title() %></div>
				</div>
			</div>
		</div>


		<!-- 기간 지정 -->
			<div class="review_form_date columns">
				<div class="column is-3"></div>
				<div class="column is-3">
					<input class="input" type="text" placeholder="Disabled input" value="<%=review.getSdate() %>" disabled>
				</div>
				<div class="column is-1">
					<div class="title review_form_date_tilde">~</div>
				</div>
				<div class="column is-3">
					<input class="input is-one-quarter" type="text" placeholder="Disabled input" value="<%=review.getEdate() %>" disabled>
				</div>
			</div>

		<div class="tabs box is-fullwidth formMenu">
			<ul>
				<li class="link">
					<a><span class="icon"><i class="fa fa-list"></i></span> <span class="active_menu">일정</span></a></li>
				<li class="link">
					<a><span class="icon"><i class="fa fa-map" aria-hidden="true"></i></span> 
					<span class="active_menu">지도</span></a>
				</li>
			</ul>
		</div>
		<div class="spacer"></div>

		<!-- 일정 -->
		<div id="review_schedule">
		<div class="columns" >
			<!-- 일정 하루씩 보기 sidebar -->
				<div class="column is-2">
					<div id="review_view_day_box">
						<%
							for(int i=0;i<review.getReview_DayCnt();i++){
						%>
								<a href="#day<%=i+1 %>" class="button review_form_day_btn" id="review_DayCnt<%=i+1 %>">day <%=i+1 %></a>
						<%		
							}
						%>
					</div>
				</div>
			<div class="column is-10">
				<!-- review form menu -->

				<!-- load -->
				<div class="review_form_content">
					<div class="box review_form_content_route">
						<table class="review_plan_view_content_detail">
							<tr>
								<th colspan="2">상세일정</th>
							</tr>
							<tr class="detail_form">
								<td colspan="2"><%=review.getReview_content() %></td>
							</tr>
						</table>
						<div class="container">
							<div class="review_form_image_detail">불러온 이미지 띄우는 곳</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<!-- 경로 -->
		<div class="columns" id="reviewMap">
			<div class="column is-12">
			<div class="box review_form_content_route">
                    <div class="review_form_content_map">
                    	<iframe src="showViewMap.map" scrolling=no name=ifmViewMap width="100%" height="100%" frameborder=0 style="border-width:0px; border-color:white; border-style:solid;"></iframe>
                    </div>
                    <input class="input review_form_content_city" type="text" placeholder="도시 > 도시 > 도시 (경로)" disabled>
                </div>
			</div>
		</div>
		<div class="spacer revew_form_spacer"></div>
		<%
			MemberVo member = (MemberVo)session.getAttribute("member");
			if(review.getUser_id().equals(member.getUserId())){
		%>
		<button class="button review_form_btn review_btn_right" onclick="location.href='reviewDelete.con?code=<%=review.getCode()%>'">삭제</button>
		<button class="button review_form_btn review_btn_right" onclick="location.href='reviewUpdate.con?code=<%=review.getCode()%>'">수정</button>
		<%
			}
		%>
		<button class="button review_form_btn review_btn_right"onclick="location.href='go.mypage'">목록</button>
		<button class="button review_form_btn review_btn_right">관심경로</button>
		<button class="button review_form_btn review_btn_right">
			<i class="fa fa-heart-o" aria-hidden="true"></i>추천
		</button>
		<!-- 누르면 <i class="fa fa-heart" aria-hidden="true"></i> -->
		<button class="button review_form_btn">
			<i class="fa fa-flag" aria-hidden="true"></i>신고
		</button>
		<%
			}
		%>	
		            <div class="box rewview_form_content_box">
                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="http://placehold.it/128x128">
                        </p>
                    </figure>
                    <div class="media-content">
                        <p class="control">
                            <textarea class="textarea rewview_form_content" placeholder="댓글을 입력해주세요..."></textarea>
                        </p>
                        <nav class="level">
                            <div class="level-left">
                                <div class="level-item">
                                    <a class="button is-info">댓글 달기</a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </article>
                <hr>
                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="http://placehold.it/128x128">
                        </p>
                    </figure>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>Barbara Middleton</strong> <small> · 3 hrs</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                                <br>
                            </p>
                        </div>
                    </div>
                    <div class="spacer"></div>
                </article>

                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="http://placehold.it/128x128">
                        </p>
                    </figure>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>Barbara Middleton</strong> <small> · 3 hrs</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                                <br>
                            </p>
                        </div>
                    </div>
                    <div class="spacer"></div>
                </article>

                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="http://placehold.it/128x128">
                        </p>
                    </figure>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>Barbara Middleton</strong> <small> · 3 hrs</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                                <br>
                            </p>
                        </div>
                    </div>
                    <div class="spacer"></div>
                </article>
                <article class="media">
                    <figure class="media-left">
                        <p class="image is-64x64">
                            <img src="http://placehold.it/128x128">
                        </p>
                    </figure>
                    <div class="media-content">
                        <div class="content">
                            <p>
                                <strong>Barbara Middleton</strong> <small> · 3 hrs</small>
                                <br>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                                <br>
                            </p>
                        </div>
                    </div>
                    <div class="spacer"></div>
                </article>
           </div>
	</div>
</body>
<script>
	$(document).ready(function(){
		$(".formMenu ul li").each(function(idx, item) {
			$(item).click(function() {
				if (idx == 0) {
					$("#review_schedule").css("display", "block");
					$("#reviewMap").css("display", "none");
				} else {
					$("#review_schedule").css("display", "none");
					$("#reviewMap").css("display", "block");
				}
			})
		});
	});
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAJKoE7aehEeAAUh18KV_P2WdfHTq1Q3Qw&callback=initMap"></script>
<script src="js/writeform_Datepicker.js"></script>
<script src="js/image_upload_popup.js"></script>
<script src="js/content/plusDetailSchdule.js"></script>
<script src="js/content/viewPage.js"></script>
</html>