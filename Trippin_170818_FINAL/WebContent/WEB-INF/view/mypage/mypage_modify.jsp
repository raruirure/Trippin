<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
<link rel="stylesheet" type="text/css" href="css/mypage/mypage_modify.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

</head>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

<%
	if(session.getAttribute("member")!=null){
		MemberVo vo = (MemberVo)session.getAttribute("member");
%>

	<div class="columns">
		<!-- leftBar -->
		<jsp:include page="../mypage/mypage_aside.jsp"></jsp:include>

		<!-- 메인 컨텐츠 시작 -->
		<div class="content column is-9">
			<div class="title is-2" style="margin-top: 20px">정보수정</div>
			<hr>
			<form action="modify_action_pro.mypage" name="modifyMember" method="post" enctype="multipart/form-data">
				<input type="hidden" id="success" name="success" value="1" />
				
				
				<div class="modifyInfo">ID</div>
				<div class="modifyResults"><%=vo.getUserId() %></div>
				<div class="linespace_mymodi"></div>
				<div class="modifyInfo">NAME</div>
				<div class="modifyResults"><%=vo.getUserName() %></div>
				<div class="linespace_mymodi"></div>
				<div class="modifyInfo">Birthday</div>
				<div class="modifyResults"><%=vo.getUserBirth() %></div>
				<!-- 판매자인 경우에만 사업자번호 보여지게  -->
				
				<% 
				if(vo.getUserLevel()==2){
				%>
				<div class="linespace_mymodi"></div>
				<div id="sellerNumber">
					<div class="modifyInfo">사업자 번호</div>
					<div class="modifyResults"><%=vo.getSellerNo() %></div>
				
				</div>
				<%
				}
				%>
				<!-- 판매자정보 끝 -->
				
				<div class="linespace_mymodi"></div>
				<div class="modifyInfo">Password</div>
				<div class="modifyResults">
					<input type="password" id="modi_userPwd" class="modi_input" name="modi_userPwd"> 
				</div>
				<div class="linespace_mymodi"></div>
				<div class="modifyInfo_long">Confirm Password</div>
				<div class="modifyResults">
					<input type="password" id="modi_confirmUserPwd" class="modi_input" name="modi_confirmUserPwd">
				</div>
				<div class="linespace_mymodi"></div>
				<div class="modifyInfo">사진</div>
				<div class="modifyResultsImg">
					<div id="image-holder">
						<img src="images/user.png" id="modi_userImg">
					</div>	
					<div>
						<a class="button is-light" ><input id="fileUpload" name="profilePhoto" type="file"></a>
					</div>
				</div>
				<div class="modi_endLine"></div>
				<div class="modi_btnright">
					<button type="submit" name="modifyMember_submit_btn" class="button is-primary">수정 완료</button>
				</div>
			</form>
			<form action="drop_action_pro.mypage" method="post">
			<input type="hidden" id="drop" name="drop" value="1" />
			
			<button class="button" name="memberWithdrawal">회원탈퇴</button>
			</form>
		</div>
	</div>
<%
	}
%>
	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>

<script type="text/javascript" src="js/bulma.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bs_leftnavi.js"></script>


<!-- 추가부분 170811 -->

<script>
$('form[name="modifyMember"]').on("submit",function(){
	event.preventDefault();
	if($("#modi_userPwd").val() ==""){
		alert("비밀번호를 입력해주세요");
		return;
	}
	if($("#modi_confirmuserPwd").val() ==""){
		alert("비밀번호 확인을 다시 해주세요")
		return;
	}
	
	if($("#modi_userPwd").val() != $("#modi_confirmUserPwd").val()){
		alert("비밀번호가 서로 다릅니다.")
		return;
	}
	
	this.submit();
	
});
</script>

<script>
$("#fileUpload").on('change', function () {

    if (typeof (FileReader) != "undefined") {

        var image_holder = $("#image-holder");
        var user_img=$("#modi_userImg");
        
        user_img.empty();
        image_holder.empty();

        var reader = new FileReader();
        reader.onload = function (e) {
            $("<img />", {
                "src": e.target.result,
                "id": "modi_userImg"
            }).appendTo(image_holder);

        }

        image_holder.show();
        reader.readAsDataURL($(this)[0].files[0]);
    } 
});

</script>


</html>