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
	
		<div class="title is-3">글쓰기</div>
		<hr>
		<div id="board_content"> 

		<%
		if(session.getAttribute("member")!=null){ 
			MemberVo member = (MemberVo)session.getAttribute("member");
		%>
		<div class="boardWriteBtn">
		<form name="writeBoardForm" action="normalWOK.board" method="post">
			<input type="hidden" name="user_id" value="<%= member.getUserId() %>" />
	          <table id="board_table">
	          	  <tr>
	          	  	<th>분류</th>
	          	  	<td colspan=2 id="board_border_rightZ" class="board_td_width210">
		          	  	<select name="code_key" id="board_table_select_category">
						<%
							if(member.getUserLevel()==3){
		          	  	%>
		          	  		<option value="N">공지사항</option>
		          	  	<%
							}
						
		          	  	%>
		          	  			<option value="F">자유게시판</option>
		          	  	</select>
	          	  	</td>
	              <tr>
	                 <th>작성자</th>
	                 <td colspan="2"><input class="input board_write" type="text" name="user_name" value="<%=member.getUserName()%>" readonly></td>      
	              </tr>  
	              <%
						} //end of if(session)
	              %>
	              <tr>
	                 <th>제목</th>
	                 <td colspan="2"><input  name="title" class="input board_title" type="text"></td>      
	              </tr>                    
	              <tr>
	                 <th>내용</th>
	                 <td colspan="2"><textarea  name="content"  rows="15" cols="80" style="margin-left:2px;"></textarea></td>
	              </tr>
	          </table>
	          <div class="boardWriteBtn">
	          <button id="board_write" class="button is-info" style=" float:right;">작성</button>
	          </div>
	       </form>            
		   </div>
		</div>
	</div>
</div>
</body>
</html>