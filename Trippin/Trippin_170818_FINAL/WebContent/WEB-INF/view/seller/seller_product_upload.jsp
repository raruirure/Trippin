<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" type="text/css" href="css/seller/seller_product_upload.css">
<title>TRIPPIN</title>
  <link rel="icon" href="images/favicon_trippin.JPG">
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<div class="columns" style="width:1200px; margin:auto;">
<%
 if(session.getAttribute("member")!=null) {
	MemberVo vo = (MemberVo)session.getAttribute("member"); 
	String sellerNo = vo.getSellerNo();
	String sellerNoDiv = sellerNo.substring(0, 3) + "-" + sellerNo.substring(3, 5) + "-" + sellerNo.substring(5, 10);
%>
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>

		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9" >
			<div class="title is-2" style="margin-top: 20px">상품등록</div>
			<hr>
			<table id="uptable" class="table is-bordered">
				<tr>
					<td class="subtitle is-5">여행 상품<br>기본 정보 입력
					</td>
					<td class="subtitle is-5">여행 상품<br>상세 정보 입력
					</td>
					<td class="subtitle is-5">여행지 / 여행상품<br>선택
					</td>
					<td class="subtitle is-5">여행 지역<br>입력(지도)
					</td>
				</tr>
			</table>
			<div class=upcontents>
			<form name="tripProductMakingForm" enctype="multipart/form-data" >
				<div class="upImgBox">
					<img id="upImgSrc" src="">
					<input type="file" name="pro_img" id="pro_img" size=400>
				</div>
				<div class="box basicContents">
					<div class="bConTitle box">
						<strong>기본 정보 입력</strong>
					</div>
					<table class="uptable table">
						<tbody>
							<tr>
								<br>
								<td class="has-text-right"><strong>카테고리</strong></td>
								<td>
									<div class="select">
										<select id="pro_category" name="pro_category">
											<option value="asia">아시아</option>
											<option value="europe">유럽</option>
											<option value="africa">아프리카</option>
											<option value="oceania">오세아니아</option>
											<option value="northamerica">북아메리카</option>
											<option value="southamerica">남아메리카</option>
											
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td class="has-text-right"><strong>상품명</strong></td>
								<td><input name="pro_name" class="upinput input" type="text" >
								</td>
							</tr>
							<tr>
								<td class="has-text-right"><strong>가격</strong></td>
								<td><input name="pro_price" class="upinput input" type="text">
								</td>
							</tr>
							
						</tbody>
					</table>

				</div>
				<div class="box updetailCon">
					<div class="bDetailTitle box">
						<strong>상세 정보 입력</strong>
					</div>
					
					<section class="upDetailinfo panel">
					<p class="panel-heading">
						<strong>날짜/인원수 옵션</strong>
					</p>
					<div class="panel-block">
						<table class="table is-fullwidth">
							<tr>
								<th class="column is-2">여행기간</th>
								<th><input name="pro_total_date" type="text" class="input"></th>
								<td>전체 여행 기간이 며칠인지 입력해 주세요</td>
							</tr>
							<tr>
								<th class="column is-2"></th>
								<th>여행 시작 날짜</th>
								<th>인원수</th>
							</tr>
							<tr>
								<th class="column is-2">옵션 1</th>
								<td class="column is-6">
									<input name="pro_sdate_1" type="text" class="input">
								</td>
								<td class="column is-4">
									<input name="pro_cnt_1" type="text" class="input">
								</td>
							</tr>
							<tr>
								<th class="column is-2">옵션 2</th>
								<td>
									<input name="pro_sdate_2" type="text" class="input">
								</td>
								<td>
									<input name="pro_cnt_2" type="text" class="input">
								</td>
							</tr>
							<tr>
								<th class="column is-2">옵션 3</th>
								<td>
									<input name="pro_sdate_3" type="text" class="input">
								</td>
								<td>
									<input name="pro_cnt_3" type="text" class="input">
								</td>
							</tr>
							<tr>
								<th class="column is-2">옵션 4</th>
								<td>
									<input name="pro_sdate_4" type="text" class="input">
								</td>
								<td>
									<input name="pro_cnt_4" type="text" class="input">
								</td>
							</tr>
							<tr>
								<th class="column is-2">옵션 5</th>
								<td>
									<input name="pro_sdate_5" type="text" class="input">
								</td>
								<td>
									<input name="pro_cnt_5" type="text" class="input">
								</td>
							</tr>
						</table>
					</div>
					</section>

					<section class="upDetailinfo panel">
					<p class="panel-heading">
						<strong>상품 상세 정보</strong>
					</p>
					<div class="panel-block">
						<textarea name="pro_content" class="textarea" placeholder="상품 설명 입력" rows="10"></textarea>
					</div>
					</section>
					<br>
					<section class="upDetailinfo panel">
					<p class="panel-heading">
						<strong>판매자 정보</strong>
					</p>
					<div class="panel-block">
						<table class="table is-fullwidth">
							<tr>
								<th class="column is-4">판매자 아이디</th>
								<td><input name="seller_id" class="input" type="text" value="<%=vo.getUserId() %>" readonly></td>
							</tr>
							<tr>
								<th class="column is-4">상호명 / 대표자</th>
								<td><input name="seller_business_name" class="input producTextBoxSize" type="text"> <span class="productFont">/</span> 
								<input name="seller_agent" class="input producTextBoxSize" type="text"></td>
							</tr>
							<tr>
								<th class="column is-4">사업자 등록번호</th>
								<td><input class="input" type="text" value="<%= sellerNoDiv %>" readonly></td>
							</tr>
							<tr>
								<th class="column is-4">전화번호</th>
								<td><input name="seller_phonenum" class="input" type="text"></td>
							</tr>
							<tr>
								<th class="column is-4" rowspan="2">회사주소</th>
								<td>
									<input name="seller_address_post" type="text" class="input" id="seller_address_post" placeholder="우편번호" style="width: 40%;" readonly>
									
									<input type="button" class="button" onclick="execDaumPostcode()" value="우편번호 찾기">
								<br>
									<input name="seller_address" type="text" class="input" id="seller_address" placeholder="주소" style="width: 60%;" readonly>
									<input name="seller_address_detail" type="text" class="input" id="seller_address_detail" placeholder="상세주소" style="width: 38%;">
								</td>
							</tr>
						</table>
					</div>
					</section>

				</div>

				<div class="upMapBox box">
					<div class="upMapTitle box">
						<strong>여행 지역 입력</strong>
					</div>
					<div class="upMapImg">
						<div id="upMapImgBox">
							<iframe src="showMainMap.map" scrolling=no name=ifmProcMap width="100%" height="100%" frameborder=0 style="border-width:0px; border-color:white; border-style:solid;"></iframe>
						</div>
						<br> <input class="uptext input column is-10" type="text" placeholder="여행 지역 입력" id="searchProc"> &nbsp;&nbsp; 
						<a class="upBtn button is-info" id="searchProcMapCode" name="searchProcMapCode">검색</a>&nbsp; 
						<a class="upBtn button is-info" id="receiveMapCode" name="receiveMapCode">추가</a> 
						<input class="input column is-12" type="text" placeholder="여행 경로 표시" id="proc_input_for_search" name="proc_input_for_search" readonly="readonly">
					</div>
				</div>

				<div class="upBtnBox">
					<input type="submit" class="upBtn button is-primary" value="등록" >
					<input type="button" class="reBtn button is-primary" value="취소">
				</div>
				</form>
			</div>
		</div>
<%
 }
%>		
	</div>

	<!-- footer -->
	<jsp:include page="../include/footer.jsp"></jsp:include>
<script>
var arrProc = [];
var msgProc = "";
$("#searchProcMapCode").click(function(){
	var sendMapCode = $("#searchProc").val();
	  document.ifmProcMap.location='showMainMap.map?sendMapCode='+sendMapCode;
});
$("#receiveMapCode").click(function(){
	  var sendMapCode = ifmProcMap.document.getElementById("sendMapCode").value;
	  
	  if(sendMapCode!=""){
		  arrProc.push(sendMapCode);
			for(var i=0;i<arrProc.length;i++){
				msgProc += arrProc[i]+"&";
			}
			$("#proc_input_for_search").val(msgProc);
			msgProc="";
		}else{
			alert("값을 입력하세요!");
		}
});
</script>
<script src="js/bs_leftnavi.js"></script>
<script src="js/seller/seller_product_upload.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/seller/find_address_postcode.js"></script>
</body>
</html>