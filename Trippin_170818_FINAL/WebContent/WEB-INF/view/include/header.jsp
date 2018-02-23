<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/main/login_modal.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
<style>
	#top{
		text-align:center;
		
	}
	.container{
		padding:0;
	}

	.nav-left{
		width:600px;
		padding:0;
		margin:0;
	}
	.nav-right.nav-menu{
		width:600px;
		padding:0;
		margin:0;
	}
	#top a:hover{
		text-decoration: none;	
	}
	
	#header_dropbox_triangle{
            content: '';
            position:absolute;
            border-bottom: 20px solid #FFF0F0;
            border-right: 20px solid transparent;
            border-left: 20px solid transparent;
            width:0;
            height:0;
            left:64px;
            top:3px;
            z-index:3;
            padding:0;
            margin:0;
    }

        #header_dropbox_box{
            width:180px;
            height:80px;
            background:#FFF0F0;
            position:absolute;
            box-shadow:4px 4px 4px black;
            top:20px;
            padding:0;
            margin:0;
            
        }
        .mainProfile_drop{
            position:absolute;
            padding:0;
            margin:0;
            top:25px;
            right:0;
        }
        #header_dropbox_box ul{
            height:100%;
            padding:0;
            text-align: center;
            margin:0;
            margin-top:15px;
            margin-left:15px;
        }
        
        #header_dropbox_box li{
            list-style: none;
            float:left;
            font-size:8pt;
            text-align: center;
            margin:10px;
            margin-top:0px;
            display: inline-block;
            border:0;
            background:transparent;
        }
        .material-icons.email{
            color: #FFE0B2;
            font-weight: bold;
        }
        .memberProfileImg{
        	position:relative;
        	padding:0;
        	margin-right: 3px;
        }
        
        .fa.fa-user.headerProfileImg.headerProfileImg{
        	margin:0;
        	font-size:24px;
        	margin-top:3px;
        	color:black;
        	padding:0;
			line-height: 23px;
			text-align: center;
			vertical-align: middle;
			width:19px;
			height:23px;
        }
        
        #header_logo{
        	width:130px;
        	height:24px;
        }
        
        .headermenu.nav-item.is-tab{
        	width:69px;
        	height:52px;
        	font-size:11pt;
        	color:black;
        }
</style>
<script>
	$(document).ready(function(){
	    $("#headerDrop_myPage").click(function(){
	        <%
	        MemberVo vo=null;
	        if(session.getAttribute("member")!=null){
	    		vo = (MemberVo)session.getAttribute("member");
	    		if(vo.getUserLevel()==1){
	        %>
	    			location.assign("go.mypage");
	    	<%
	    		}else if(vo.getUserLevel()==2){
	    	%>
	    			location.assign("seller_product_manage.seller");
	    	<%
	    		}else if(vo.getUserLevel()==3){
	    	%>
	    			location.assign("admin_supervise.mypage");
	    	<%
	    		}
	        } // end of if
	    	%>
	    	});
		
		
		$(".log-in").click(function(){
			$("#login_form").css({
				display:"block"
			});
		});
		$(".register").click(function(){
			$("#join_form").css({
				display:"block"
			});
		});
		$(".logingoogle").click(function(){
			$("#login_form").css({
				display:"none"
			});
			$("#login_google").css({
				display:"block"
			});
		});
	});
	function message_popup(){
		<% 
		if((MemberVo)session.getAttribute("member")!=null){
			vo = (MemberVo)session.getAttribute("member");
			if(vo.getUserLevel()!=4){
		%>
		window.open('reviewViewN.msg',
				'upload_image', 'width=815, height=360, menubar=no, status=no, toolbar=no, location=no, resizable=no, fullscreen=no');
		<%
			}else{
		%>
		window.open('reviewViewR.msg',
				'upload_image', 'width=815, height=360, menubar=no, status=no, toolbar=no, location=no, resizable=no, fullscreen=no');		
		<%
			}
		} // end of if
		%>
	}		
</script>
<nav class="nav has-shadow" id="top">
		<div class="container">
			<div class="nav-left">
				<a class="nav-item" href="intro.main"> 
				<img id="header_logo" src="images/logo_7.png" alt="Description" width="130px">
				</a>
			</div>
			<span class="nav-toggle"> <span></span> <span></span> <span></span>
			</span>
			<div class="nav-right nav-menu">
				<a class="headermenu nav-item is-tab" href="review.main"> 후기 </a>
				<a class="headermenu nav-item is-tab" href="plan.main"> 계획 </a>
				<a class="headermenu nav-item is-tab" href="product.main"> 상품</a>
				<a class="headermenu nav-item is-tab" href="begin.board"> 게시판 </a> 
				<span class="nav-item">
				<% 
				if(session.getAttribute("member")==null){
				%>
				<a class="button log-in" onclick="document.getElementById('login_form').style.display='block'">Log in</a>
				<a class="button is-info register" onclick="document.getElementById('join_form').style.display='block'">Sign up</a>
				<%
				}else{
					MemberVo member = (MemberVo)session.getAttribute("member");
					
				%>
				<div class="memberProfile">
				<div class="memberProfileImg" style="float: left;">
					<i class="fa fa-user headerProfileImg headerProfileImg" aria-hidden="true"></i>
				</div>
					<div class="mainProfile_drop">
   						<div id="header_dropbox_triangle"></div>
			        	<div id="header_dropbox_box">
				            <ul>
				                <li onclick="message_popup();"><i class="material-icons email">email</i><br>쪽지</li>
				                <li id="headerDrop_myPage"><i class="material-icons email">border_color</i><br>마이<br>페이지</li>
				                <li id="headerDrop_logout"><i class="material-icons email">exit_to_app</i><br>로그아웃</li>
				            </ul>
			      		</div>
				    </div>
				<span style="float: left; line-height: 30px; font-size: 10pt; font-weight: 300;"><%= member.getUserName() %>	</span>
				<%
				}
				%>
				</div>
				</span>
			</div>
		</div>
	</nav>
  <div id="login_form" class="modal">
	<form class="modal-content" name="member_login" method="post">
		<div class="close">
			<i class="fa fa-times"></i>
		</div>
		<h1 class="title">Login</h1>
			<b>ID</b><br>
			<p>
			<input class="input" type="text" placeholder="아이디는 이메일입니다" name="userId" required>
			</p>
			<b>Password</b><br>
			<p>
			<input class="input" type="password" placeholder="비밀번호를 입력해주세요" name="userPwd" required>
			</p>
			<a class="login_a_form">아이디 · 비밀번호 찾기</a><br>
			<button class="button is-primary loginBtn" type="submit">로그인</button>
			<button class="button is-default loginBtn" id="BTN_GOOGLE_LOGIN">
				<img src="images/google.png" class="googleimg">
				구글 계정으로 로그인하기
			</button>
			<hr>
			<p>
			트리핀 계정이 없으세요?
			<button class="button is-primary is-outlined login_toJoin_btn">회원가입</button>
			</p>
	</form>
</div>
<div id="join_form" class="modal">
	<div class="modal-content member_join">
		<div class="close">
			<i class="fa fa-times"></i>
		</div>
		<h1 class="title">Sign Up</h1>
		<p class="registerBtn">
			<input type="button" class="button" name="general_user_btn" value="일반사용자"> 
			<input type="button" class="button" name="seller_btn" value="판매자">
		</p>
		<form name="generalJoin" method="post">
			<input type="hidden" name="user_level" value="1">
			<input type="button" class="button is-light" value="중복검사" name="id_dupliCheck">
			<b id="ID_line">ID</b>
			<p>
			<input class="input" type="text" placeholder="아이디는 이메일입니다" name="join_userId" required>
			</p>
			<b>이름</b><br>
			<p>
			<input class="input" type="text" placeholder="이름" name="join_userName" required>
			</p>
			<b>Password</b><br>
			<p>
			<input class="input" type="password" placeholder="비밀번호" name="join_userPwd" required>
			</p>
			<b>Confirm Password</b>
			<div id="notEqualPwd">비밀번호가 다릅니다!</div>
			<p>
			<input class="input" type="password" placeholder="비밀번호 확인" name="join_userPwdConfirm" required>
			</p>
			<b>생년월일</b><br>
			<p>
			<input class="input" type="text" placeholder="생년월일 (ex, 170804)" name="join_userBirthday" required>
			</p>
			<div class="seller_level">
				<b>사업자번호</b><br>
				<p>
					<input class="input" type="text" placeholder="- 없이 입력해주세요"
						name="join_sellerNumber">
				</p>
			</div>
			<p>
			<input type="checkbox" class="JoincheckboxSize"> 이용약관에 대한 동의 (필수)
            <a href="#" class="fontcolorJoin">전문보기</a><br>
            <input type="checkbox" class="JoincheckboxSize"> 개인정보 수집 및 이용 동의 (필수)
            <a href="#" class="fontcolorJoin">전문보기</a>
            </p>
            <input id="general_join_req" class="button is-primary loginBtn" type="submit" value="회원가입">
         </form>
         
            <hr>
			<p>
			트리핀 계정이 있나요?
			<button class="button is-primary is-outlined login_toJoin_btn">로그인</button>
			</p>
	</div>

</div>
<!-- /////////////////////////////////// start of javascript 스크립트 영역 /////////////////////////////////// -->
  <!-- TODO firebase SDK 링크 -->
  <script src="https://www.gstatic.com/firebasejs/4.2.0/firebase.js"></script>
   <script src="https://www.gstatic.com/firebasejs/3.8.0/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/3.8.0/firebase-auth.js"></script>
    <script src="https://www.gstatic.com/firebasejs/3.8.0/firebase-database.js"></script>
    <script src="https://www.gstatic.com/firebasejs/3.8.0/firebase-messaging.js"></script>
    <script>
      // Initialize Firebase
      var config = {
        apiKey: "AIzaSyCVbGqvMey8GKl_ANfJ3Xxoxoznkx3wMas",
        authDomain: "authlogin-f2db5.firebaseapp.com",
        databaseURL: "https://authlogin-f2db5.firebaseio.com",
        projectId: "authlogin-f2db5",
        storageBucket: "authlogin-f2db5.appspot.com",
        messagingSenderId: "662488577265"
      };
      firebase.initializeApp(config);
    </script>
  <script type="text/javascript">
  $(document).ready(function(){
	  

    /* TODO 버튼을 눌렀을 경우 구글 인증 동작하게 */
      $("#BTN_GOOGLE_LOGIN").click(function(){
          var provider = new firebase.auth.GoogleAuthProvider();
          
          firebase.auth().signInWithPopup(provider).then(function(result){
              //$("#AUTH_STATE").text(result.user.displayName+"님 로그인 하셨습니다.");
          });
          $("#login_form").css({
				display:"none"
			});
      });
    /* TODO 인증 상태 변화 감시하기 */
    firebase.auth().onAuthStateChanged(function(user){
    	if(user){
    		$("#AUTH_STATE").text(user.displayName+"님 로그인 하셨습니다.");
    		$("#BTN_LOGOUT").show();
    		//유저 정보 보여주기
    		$("#USER_NAME").text(user.displayName);
    		$("#USER_MAIL").text(user.email);
    		$("#USER_UID").text(user.uid);
    		$("#USER_PHOTO").attr('src',user.photoURL);
    		$("#USER_INFO").show();
    		$("#loginAUTH").hide();
    	}else{
    		$("#AUTH_STATE").text("(인증되지 않음)");
    		$("#BTN_LOGOUT").hide();
    		//유저 정보 감추기
    		$("#USER_INFO").hide();
    		$("#loginAUTH").show();
    	}
    });
    /* TODO 로그아웃 버튼을 눌렀을 때 인증 해제 하도록 하기 */
    $("#BTN_LOGOUT").click(function(){
    	firebase.auth().signOut().then(function(){
    		alert("인증이 해제되었습니다.");
    		location.assign("intro.main");
    	}, function(error){
    		alert(error.message);
    	})
    })
    
    /* header의 마이페이지 버튼 누를 때 방법 */
  });
  </script>
<!-- /////////////////////////////////// end of javascript 스크립트 영역 /////////////////////////////////// -->
<script src="js/include/header.js"></script>