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
  <script src="js/board/boardWM.js"></script>
  <style>
  body {
  background-color: transparent;
  }
  #board_border_rightZ{
  padding:10px;
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
			<a class="item"><span id="goNotice" class="name board_defalut white_active">공지사항</span></a>
			<a class="item"><span id="goFree" class="name board_defalut">자유게시판</span></a>
		</div>
	</aside>
	<div class="content column is-10 board" id="board_content">
	
	<div class="title is-3">글 수정하기</div>
	<hr>
	<div class="panel-block board">
		<div id="board_modify">
			<%
				if(session.getAttribute("member")!=null){ 
					MemberVo member = (MemberVo)session.getAttribute("member");
					
					if (request.getAttribute("boardVo") != null) {
						BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
		   
			%>
			<form name="modifyBoardForm" action="modify_ok_board.board" method="post">
				<input type="hidden" name="write_no" value="<%= boardVo.getWrite_no()%>" />
				<input type="hidden" name="code_key" value="<%= boardVo.getCode_key()%>" />
				<table id="board_table">
					<tr>
						<th>분류</th>
						<td colspan=2 id="board_border_rightZ"
							class="board_td_width210">
						<% if(boardVo.getCode_key().equals("N")){%>
							공지게시판
						<% }else{ %>
							자유게시판
						<% } %></td>
					<tr>
						<th>작성자</th>
						<td colspan="2" name="user_name"><input
							class="input board_write" type="text" value="<%=member.getUserName() %>" readonly></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="2" ><input name="title" class="input board_title"
							type="text" value="<%=boardVo.getTitle()%>"></td>
					</tr>
	
					<tr id="board_con">
						<th>내용</th>
						<td colspan="2"><textarea name="content" id="textArea"
								rows="15" cols="80" style="margin-left: 2px;">
							<%=boardVo.getContent()%></textarea></td>
					</tr>
				</table>
				<%
					} // end of if(boardVo) 
				%>
				<div class="boardModifyOkBtn">
					<button id="board_modifyOkBtn" class="button is-info" style="float: right;">수정</button>
				</div>
			</form>
			<%
				} //end of if(member)
			%>
		</div>
	</div>
	</div>
</div>
</body>
</html>
