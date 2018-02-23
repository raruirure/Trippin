<%@page import="org.trippin.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo vo = (MemberVo)session.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/messages/message_write.css">
  <script src="<%=request.getContextPath()%>/message_popup.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<page>  
  <div class="container"> 
      <div class="nav-left nav-menu">
     	 <a class="button is-default board" href="message_normal_write_view.msg">일반</a>
      <%
      if(vo.getUserLevel()!=4){
      %>
         <a class="button is-default board" href="message_report_write_view.msg">신고</a>
      <%
      }else{
    	  
      }
      %>
      </div>
      
 <form name="message_normal_write">
      <div id="table" style="width:780px; margin-left:10px;">
        <table class="table is-bordered">
          <tr>
             <th style="width:100px;">제목</th>
             <td colspan="3"><input class="message_title" type="text" name="title"></td>
          </tr>
          <tr>             
             <th>보낸 사람</th>
             <td style="width:200px;"><%=vo.getUserId() %></td>
             <th style="width:100px;">받는 사람</th>
             <td style="width:200px;"><input id="email" type="text" name="responser"></td>
          </tr>
          <tr id="content">
             <th style="width:100px;">내용</th>
             <td colspan="3"><textarea id="area" cols="91" rows="9" name="content"></textarea></td>
          </tr>
        </table>
      </div>
         <div id="message_send">
         <button class="button is-primary board" type="submit">보내기</button>
      <%
      	if(vo.getUserLevel()!=4){
      %>
         <a class="button is-primary board" href="reviewViewN.msg">목록</a>    
      <%
      	}else{
      %>
      	<a class="button is-primary board" href="reviewViewR.msg">목록</a>    
      <%		
      	}
      %>
         </div>
      </form>
       
      </div>
</page>        
</body>
</html>
<script>
$(document).ready(function(){
	$("form[name=message_normal_write]").submit(function(){
		event.preventDefault();
		if($("input[name=title]").val()==""){
			alert("제목을 입력하세요");
			$("input[name=title]").focus();
			return;
		}
		
		if($("input[name=responser]").val()==""){
			alert("받는 사람을 입력하세요");
			$("input[name=responser]").focus();
			return;
		}	
		
		if($("textarea[name=content]").val()==""){
			alert("내용을 입력하세요");
			$("input[name=content]").focus();
			return;			
		}
		
		
		alert("쪽지를 보냈습니다.");
		this.action="writeN.msg";
		this.method="post";
		this.submit();
	})
})
</script>