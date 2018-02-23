<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
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

	<!-- review_form -->
	<div class="container review_form">
		<!-- review_form_name -->
		<form name="planWrite" enctype="multipart/form-data">
		<div class="section review_form_heading" id="image-holder">
			<input type="hidden" id="plan_daycnt" name="plan_daycnt">
			<div class="columns">
				<div class="column" style="margin:80px 0 80px 0;">
					<input type="text" class="input" placeholder="제목 입력" id="plan_form_title" name="plan_form_title" style="height:50px;">
					<div class="review_plus_icon column">
						<input type="file" name="banner_img" id="main_banner_upload" >
					</div>
				</div>
			</div>
		</div>

		<!-- 기간 지정 -->
		<div class="review_form_date columns">
			<div class="column is-2" style="text-align:center;">
				<select id="selectContinents" name="selectContinents">
					<option value="asia">아시아</option>
					<option value="europe">유럽</option>
					<option value="oseania">오세아니아</option>
					<option value="america">아메리카</option>
					<option value="africa">아프리카</option>
				</select>
			</div>
			<div class="column is-3">
				<input class="input" type="text" id="from" name="fromCal" style="width:280px">
			</div>
			<div class="column is-1" id="datepicker1" style="line-height: 50px;">
				<i class="fa fa-calendar" aria-hidden="true" style="font-size:24px"></i>
			</div>
			<div class="column is-1">
				<div class="title review_form_date_tilde">~</div>
			</div>
			<div class="column is-3">
				<input class="input is-one-quarter" type="text" id="to" name="toCal" style=";width:280px">
			</div>
			<div class="column is-1" id="datepicker2" style="line-height: 50px;">
				<span class="icon"> <i class="fa fa-calendar" aria-hidden="true" style="font-size:24px"></i>
				</span>
			</div>
			<div class="column is-2"></div>
		</div>
		<div class="tabs box is-fullwidth formMenu">
			<ul>
				<li class="link"><a><span class="icon"><i class="fa fa-list"></i></span> <span class="active_menu">일정</span></a></li>
				<li class="link"><a><span class="icon"><i class="fa fa-map" aria-hidden="true"></i></span> <span class="active_menu">지도</span></a></li>
			</ul>
		</div>
		<div class="spacer"></div>

		<!-- 일정 -->
		<div id="review_schedule">
			<div class="columns">
				<div class="column is-2">
					<!-- 상세 날짜 설정 -->
					<div class="review_form_day_box">
						<button id="plus_date" type="button">
							<i class="fa fa-plus" aria-hidden="true"></i>
						</button>
					</div>
				</div>
				<div class="column is-10">
					<!-- review form menu -->
					<!-- load -->
					<div class="review_form_content">
						<div class="box review_form_content_route">
							<span class="content_detail_font">상세 일정</span>
								<textarea class="textarea plan_form_content_detail" cols="130" rows="50" name="plan_form_content_detail" id="content_detail"></textarea>
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
						<iframe src="showMainMap.map" scrolling=no name=ifmPlanMap width="100%" height="100%" frameborder=0 style="border-width:0px; border-color:white; border-style:solid;"></iframe>
					</div>
					<input class="input city_search_space_result" type="text" placeholder="도시" id="search1" style="width:840px;">
					<input type="hidden" id="mapCode">
					<button type="button" class="button city_search_space_btn" id="searchPlanMapCode" name="searchPlanMapCode">검색</button>
					<button type="button" class="button city_search_space_btn" id="receiveMapCode" name="receiveMapCode">좌표저장</button>
					<!-- 도시 검색용..? 검색버튼은 -->

					<input class="input review_form_content_city" type="text" placeholder="도시 > 도시 > 도시 (경로)" id="plan_input_for_search" name="plan_input_for_search" readonly="readonly">
				</div>
			</div>
		</div>
		<div class="spacer revew_form_spacer"></div>
		<button class="plan_form_btn review_btn_right" type="submit">작성완료</button>
        <button class="plan_form_btn review_btn_right" type="reset">작성취소</button>
        <button class="plan_form_btn review_btn_right" type="button">목록</button>
        </form>
	</div>
	<script>
$(document).ready(function(){
	var arrPlan = [];
	var msgPlan = "";
	$("#searchPlanMapCode").click(function(){
		var sendMapCode = $("#search1").val();
		  document.ifmPlanMap.location='showMainMap.map?sendMapCode='+sendMapCode;
	});
	$("#receiveMapCode").click(function(){
		  var sendMapCode = ifmPlanMap.document.getElementById("sendMapCode").value;
		  
		  if(sendMapCode!=""){
			  arrPlan.push(sendMapCode);
				for(var i=0;i<arrPlan.length;i++){
					msgPlan += arrPlan[i]+"&";
				}
				$("#plan_input_for_search").val(msgPlan);
				msgPlan="";
			}else{
				alert("값을 입력하세요!");
			}
	});
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
	$("form[name=planWrite]").on('submit',function(){
		//유효성 테스트
		if($("#plan_form_title").val() == ""){
			alert("제목을 입력해주세요.");
			return;
		}
		if($("#from").val() == ""){
			alert("시작 날짜를 입력해주세요.");
			return;
		}
		if($("#to").val() == ""){
			alert("종료 날짜를 입력해주세요.");
			return;
		}
		if($("#content_detail").val() == ""){
			alert("내용을 입력해주세요.");
			return;
		}
		if($("#plan_input_for_search").val() == ""){
			alert("경로를 선택해주세요.");
			return;
		}

		this.action="planWrite_ok.con";
	    this.method="post";
	    this.submit();
	});
	var idx = 1;
	$("#plus_date").click(function() {
		var txt = "<button type='button' class='button review_form_day_btn' id='date"+idx+"' onclick='addDivision("+idx+");'>day "+idx+"</button>"; 
		document.getElementById("plan_daycnt").value = idx;
		idx++;
		$(this).before(txt);
	});
});
</script>
<script src="js/writeform_Datepicker.js"></script>
<script src="js/image_upload_popup.js"></script>

<script>
function addDivision(idx){
	document.planWrite.plan_form_content_detail.value += "<span class='label label-default' id=day"+idx+">| DAY"+idx+"|</span>";
}
</script>
</body>
</html>