<%@page import="org.trippin.vo.MessageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MessageVo vo = (MessageVo)request.getAttribute("messageRDetail");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/messages/message_report_content.css">
</head>
<body>
<page>  
  <div class="container"> 
      <div class="nav-left nav-menu">
        <p>일반 쪽지</p>
      </div>
      <div id="table" style="width:780px; margin-left:10px;">
        <table class="table is-bordered">
          <tr>
             <th style="width:100px;">제목</th>
             <td colspan="3"><%=vo.getTitle() %></td>
          </tr>
          <tr>             
		  	<th>신고인</th>
           	<td style="width:200px;"><%=vo.getSend_user_id() %></td>
            <th style="width:100px;">보낸 날짜</th>
            <td style="width:200px;"><%=vo.getSend_date() %></td>
          </tr>
          <tr>
          	<th>신고당한 사람</th>
          	<td colspan="3"><%=vo.getRes_user_id() %></td>
          </tr>
          <tr id="content">
             <th style="width:100px;">내용</th>
             <td colspan="3"><%=vo.getMessage_content() %></td>
          </tr>
        </table>
      </div>
      
       
         <div id="message_send">
       		 <a class="button is-primary board" href="ReportDelete.msg?idx=<%=vo.getNo() %>">삭제</a>
        	 <a class="button is-primary board" href="reviewViewR.msg">목록</a>    
         </div>
      </div>
</page>        
</body>
</html>