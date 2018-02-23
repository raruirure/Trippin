<%@page import="org.trippin.vo.MessageVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo member_vo = (MemberVo)session.getAttribute("member");
	ArrayList<MessageVo> message_listN = (ArrayList<MessageVo>)request.getAttribute("message_listR");
	int totalRecordSize = message_listN.size();	// 총 게시글 숫자
	int recordPerPage = 10;	// 1 페이지 당 게시글 수
	int pagePerBlock = 5;	// 1개 화면에 나올 페이지 갯수
	
	int totalPageSize = (int)Math.ceil((double)totalRecordSize/recordPerPage);	// 게시글 10개 당 총 페이지 수
	int curPage = 0;	// 현재 페이지
	if(request.getAttribute("curPage")!=null){
		curPage = Integer.parseInt(request.getAttribute("curPage")+"");
		// ""를 붙여야 Integer.parseInt가 작동함.
	}
	
	int curBlock = 0;
	if(request.getAttribute("curBlock")!=null){
		curBlock = Integer.parseInt(request.getAttribute("curBlock")+"");
		// ""를 붙여야 Integer.parseInt가 작동함.
	}
	
	int beginNum = curPage*recordPerPage;	//0번째 숫자 : 123부터 출력(message_listN가 끝의 값부터 있기 때문)	
	int beginPageNum = curBlock*pagePerBlock;	// 맨 앞이 0페이지
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/messages/message_report.css">

</head>
<body>
<page>  
  <div class="container"> 
      <div class="nav-left nav-menu">
      	<p class="message_p_center message_big_title">신고쪽지</p>                                
      </div>
	  <form name='my_form'>
      	<div id="table" style="width:780px; margin-left:10px;">
        	<table class="table is-bordered">
          	<thead>
             <th style="width:30px;"><input type='checkbox' onclick='check_all();'/></th>
             <th style="width:200px;">보낸 사람</th>
             <th>내용</th>
             <th style="width:150px;">신고일</th>
          </thead>
         <%
          for(int i=beginNum;i<beginNum+recordPerPage;i++){
        	  if(i >= totalRecordSize) break;
        	  MessageVo vo_N =  message_listN.get(i);
          %>
          <tbody>
             <td><input type="checkbox" name='mycheck' value="<%=vo_N.getNo() %>"></td>  
             <td><%=vo_N.getSend_user_id() %></td>  
             <td><a href="ReportDetail.msg?idx=<%=vo_N.getNo() %>"><p><%=vo_N.getTitle() %></p></a></td>  
             <td><%=vo_N.getSend_date() %></td>  
          </tbody>
         <%
          }
         %>
      	</table>
      	
      </div>
      <div id="btn">   
      	 <button type="submit" class="button is-primary board">삭제</button>     
       </div>
       </form>
       
<nav aria-label="Page navigation">       
	    <ul class="pagination board">
           <% 
  		if(curBlock>0){
  			%>
  					<li><a href="reviewViewR.msg?curBlock=<%=curBlock-1%>&curPage=<%=(curBlock-1)*pagePerBlock %>">이전</a></li>
  			<%
  					}
  					for(int i=beginPageNum;i<beginPageNum+pagePerBlock;i++){
  						if(i>totalPageSize-1) break;
  			%>
  						<li><a href="reviewViewR.msg?curPage=<%=i %>&curBlock=<%=curBlock %>"><%=i+1 %></a></li>
  			<% 
  					}
  					if(curBlock<totalPageSize/pagePerBlock){
  			%>
  						<li><a href="reviewViewR.msg?curBlock=<%=curBlock+1%>&curPage=<%=(curBlock+1)*pagePerBlock %>">다음</a></li>
  			<%	
  					}	
     	    %>
       	    </ul>                
       </nav>
       
         <div id="message_write">
			 <a class="button is-primary board" href="message_normal_write_view.msg">글쓰기</a> 
         </div>
      </div>
<script src="<%=request.getContextPath()%>/js/message_popup.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/include/header.js"></script>  
</page>        
</body>
</html>
<script>
$(document).ready(function(){
	$("form[name=my_form]").submit(function(){
		event.preventDefault();
		this.method="post";
		this.action="ReportDelete.msg";
		this.submit();
	})
})
</script>
