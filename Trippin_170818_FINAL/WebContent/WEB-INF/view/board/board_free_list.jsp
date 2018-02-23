<%@page import="org.trippin.vo.PageInfo"%>
<%@page import="org.trippin.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
if(request.getAttribute("boardList") != null){
	ArrayList<BoardVo> boardList = (ArrayList<BoardVo>) request.getAttribute("boardList");

	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/board/board2.css">
  <link rel="stylesheet" type="text/css" href="css/board/boardleft.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="js/board/boardMenu.js"></script>
  <script src="js/board/boardList.js"></script>
  <style>
  body {
  background-color: transparent;
  }
  .fbTable tr{
  	height:50px;
  }
  .fblDiv{
  	min-height:500px;
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
		<div class="fblDiv panel-block board">
		<%
			if(boardList != null && listCount >= 0){
		%>
			<table class="fbTable table board">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<%if(listCount == 0 ) {
				%>
				<tr>
					<td colspan=5> 작성글이 없습니다.</td>
				</tr>	
				<%	
				}else { 
					for(int i=0;i<boardList.size();i++){
						BoardVo boardVo = boardList.get(i);
						String fNo = boardVo.getWrite_no().substring(1);
						int FreeNo = Integer.parseInt(fNo);
					%>
						<tr>
							<td><%=FreeNo%></td>
							<td><%=boardVo.getTitle() %></td>
							<td><%=boardVo.getUser_name() %></td>
							<td><%=boardVo.getRdate().substring(0,10) %></td>
							<td><%=boardVo.getHit() %></td>
						</tr>		
						
				<%
					} //end of for
				}//end of else
				%>
				</tbody>
			</table>
		</div>
		
		<nav aria-label="Page navigation">
			<ul class="pagination board">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				
				<%if(nowPage<=1){ %>
					<li><a href="#">이전</a></li>
				<%}else{ %>
					<li><a href="freeList.board?page=<%=nowPage-1 %>">이전</a>&nbsp;</li>
				<%} %>
				
				<%for(int a=startPage;a<=endPage;a++){
					if(a==nowPage){%>
						<li><a href="#"><%=a %></a>&nbsp;</li>
					<%}else{ %>
						<li><a href="freeList.board?page=<%=a %>"><%=a %></a>&nbsp;</li>
					<%} %>
				<%} %>
				
				<%if(nowPage>=maxPage){ %>
					<li><a href="#">다음</a></li>
				<%}else{ %>
					<li><a id="next" href="freeList.board?page=<%=nowPage+1 %>">다음</a></li>
				<% } %>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
		<% 
			}// end of listcount
		}//end of if(boardList!=null)
		%>
		
		<br>
		<p class="p center margin-bottom_5p">
		<a class="button is-info board">글쓰기</a>
		</p>
		<br>
		
		<div class="board p1">
		<form name="freeBoardSearchForm" method="post" >
			<select name="fBSSelect" class="board select">
				<option value="title">제목</option>
				<option value="user_name">작성자</option>
			</select> 
			<input name="fBSText" class="input search board" type="text" style="margin:0;">
			<button id="bFlistSearchBtn" class="button is-outlined board"> <i class="material-icons">search</i></button>
		</form>
		</div>
	
	</div>
</div>
</body>
<script>
	$('.board tr td:nth-of-type(2)').each(function(idx,item){
		$(item).click(function(){
			<%
			if(session.getAttribute("member")!=null){ 
			%>
			var fNum = $("tr:nth-child("+(idx+1)+")>td:nth-child(1)").text();
			var freeBlistNum = 'F'+leadingZeros(fNum, 5);
			location.assign("freeD.board?write_no="+freeBlistNum);
			<%
			}else{
			%>
				alert("로그인 한 후에 이용가능합니다.");
				
			<%
			}//end of else
			%>
		});
	});
	
	var leadingZeros = function (date, num) {
		 var zero = '';
		 date = date.toString();
		
		 if (date.length < num) {
		  for (i = 0; i < num - date.length; i++)
		   zero += '0';
		 }
		 return zero + date;
	}

	$('.button.is-info.board').click(function() {
		<% 
		if(session.getAttribute("member") != null){
		%>
			location.assign('normalW.board');	
		<%
		}else{
		%>
			alert("로그인 한 후에 이용가능합니다.");
		<%
		}
		%>
	});
</script>
</html>