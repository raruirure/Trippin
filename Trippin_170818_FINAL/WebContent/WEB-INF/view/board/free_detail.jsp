<%@page import="org.trippin.vo.BoardVo"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/board/board2.css">
  <link rel="stylesheet" type="text/css" href="css/board/board_notice.css">
  <link rel="stylesheet" type="text/css" href="css/board/boardleft.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="js/board/boardMenu.js"></script>
  <script src="js/board/boardDetail.js"></script>
  <style>
  body {
  	background-color: transparent;
  }
  #board_table td{
  	padding: 10px;
  }
  #board_list_free{
  	margin:10px;
  }
  #fboard_delete, #fboard_modify{
 	float:right;
  	margin:10px 5px;
  }
  </style>
  <title>TRIPPIN</title>
  <link rel="icon" href="images/favicon_trippin.JPG">
</head>
<body>
<!-- header -->
<jsp:include page="../include/header.jsp"></jsp:include>

<div class="columns board">
	<aside class="column is-2 aside hero is-fullheight is-hidden-mobile board">
		<div class="main" id="board_content_side">
			<a class="item"><span id="goNotice" class="name board_defalut">공지사항</span></a>
			<a class="item"><span id="goFree" class="name board_defalut white_active">자유게시판</span></a>
		</div>
	</aside>
	
	<div class="content column is-10 board" id="board_content">
		<div class="title is-2">자유게시판</div>
		<hr>
		<%
		if(session.getAttribute("member")!=null){ 
			MemberVo member = (MemberVo)session.getAttribute("member");
			if(request.getAttribute("boardVo") != null){
				BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
			
		%>
		<div class="panel-block board">
		<form method="post" name="freeDetailForm" >
			<input type="hidden" name="write_no" value="<%=boardVo.getWrite_no() %>" />
			<input type="hidden" name="code_key" value="<%=boardVo.getCode_key() %>" />
			<table id="board_table">
				<tr>
					<th>이름</th>
					<td style="width:250px; "><%=boardVo.getUser_name() %></td>
					<th>등록일</th>
					<td><%=boardVo.getRdate().substring(0,10) %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=boardVo.getTitle() %></td>
				</tr>
				<tr id="border_con">
					<th>내용</th>
					<td colspan="3"><%=boardVo.getContent() %></td>
				</tr>
			</table>
			<div class="fboardWriteBtn">
				<input type="button" id="board_list_free" class="button is-primary" value="목록" />
				<%
					if(member.getUserId().equals(boardVo.getUser_id()) || member.getUserLevel()== 3){
				%>
				<input type="button" id="fboard_delete" class="button is-primary" value="삭제"  />
				<input type="button" id="fboard_modify" class="button is-primary" value="수정"  />
				<%
						}//end of if(boardVo)
					}
				}
				%>
			</div>
		</form>
		
			<hr>
			<!--  댓글 -->
			<article>
				<div class="media-content">
					<p class="control">
						<textarea class="textarea rewview_form_content"
							placeholder="댓글을 입력해주세요..."></textarea>
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
							<strong>Barbara Middleton</strong> <small> · 3 hrs</small> <br>
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta
							eros lacus, nec ultricies elit blandit non. Suspendisse
							pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus
							turpis. <br>
						</p>
					</div>
				</div>
				<div class="spacer"></div>
			</article>
		
		<!--  댓글끝! -->
		
		</div>
	</div>
</div>
</body>
</html>
