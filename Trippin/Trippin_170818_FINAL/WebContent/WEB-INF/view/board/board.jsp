<%@page import="org.trippin.vo.PageInfo"%>
<%@page import="org.trippin.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
if(request.getAttribute("boardList") != null){
	ArrayList<BoardVo> boardList = (ArrayList<BoardVo>) request.getAttribute("boardList");

	PageInfo npageInfo = (PageInfo)request.getAttribute("npageInfo");
	int nlistCount=npageInfo.getListCount();
	int nnowPage=npageInfo.getPage();
	int nmaxPage=npageInfo.getMaxPage();
	int nstartPage=npageInfo.getStartPage();
	int nendPage=npageInfo.getEndPage();
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/board/board2.css">
  <link rel="stylesheet" type="text/css" href="css/board/boardleft.css">
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
  .nblDiv{
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
	<!-- leftMenu  -->
	<aside class="column is-2 aside hero is-fullheight is-hidden-mobile board">
		<div class="main" id="board_content_side">
			<a class="item"><span id="goNotice" class="name board_defalut white_active">공지사항</span></a>
			<a class="item"><span id="goFree" class="name board_defalut">자유게시판</span></a>
		</div>
	</aside>
	<div class="content column is-10 board" id="board_content">
		<div class="title is-2">공지사항</div>
		<hr>
		
		<div class="nblDiv panel-block board">
		<%
			if(boardList != null && nlistCount >= 0){
		%>
			<table class="table board">
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
				<%if(nlistCount == 0 ) {
				%>
				<tr>
					<td colspan=5> 작성글이 없습니다.</td>
				</tr>	
				<%	
				}else { 
					for(int i=0;i<boardList.size();i++){
						BoardVo boardVo = boardList.get(i);
						String nNo = boardVo.getWrite_no().substring(1);
						int NoticeNo = Integer.parseInt(nNo);
					%>
					<tr>
						<td><%=NoticeNo%></td>
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
				<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				
				<%if(nnowPage<=1){ %>
					<li><a href="#">이전</a></li>
				<%}else{ %>
					<li><a href="begin.board?npage=<%=nnowPage-1 %>">이전</a>&nbsp;</li>
				<%} %>
				
				<%for(int a=nstartPage;a<=nendPage;a++){
					if(a==nnowPage){%>
						<li><a href="#"><%=a %></a>&nbsp;</li>
					<%}else{ %>
						<li><a href="begin.board?npage=<%=a %>"><%=a %></a>&nbsp;</li>
					<%} %>
				<%} %>
				
				<%if(nnowPage>=nmaxPage){ %>
					<li><a href="#">다음</a></li>
				<%}else{ %>
					<li><a id="next" href="begin.board?npage=<%=nnowPage+1 %>">다음</a></li>
				<% } %>
				
				<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			</ul>
		</nav>
		<% 
			}// end of listcount
		}//end of if(boardList!=null)
		%>
		
		<br>
		<%
		  MemberVo vo=null;
	      if(session.getAttribute("member")!=null){
	    		vo = (MemberVo)session.getAttribute("member");
	    		if(vo.getUserLevel()==3){		
		%>
				<p class="p center margin-bottom_5p">
				<a class="button is-info board">글쓰기</a>
				</p>
		<%
    			}
        	}
		%>
		
		<div class="board p1">
		<form name="noticeBoardSearchForm" method="post" >
			<select name="nBSSelect" class="board select">
				<option value="title">제목</option>
			</select> 
			<input name="nBSText" class="input search board" type="text" style="margin:0;" />
			<button id="bNlistSearchBtn" class="button is-outlined board"> <i class="material-icons">search</i></button>
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
			var nNum = $("tr:nth-child("+(idx+1)+")>td:nth-child(1)").text();
			var nBlistNum = 'N'+leadingZeros(nNum, 5);
			location.assign("noticeD.board?write_no="+nBlistNum);
			
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
		location.assign('normalW.board');
	});
	
</script>
</html>