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
  <link rel="stylesheet" type="text/css" href="css/messages/message_report_write.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<page>  
  <div class="container"> 
      <div class="nav-left nav-menu">
         <a class="button is-default board" href="message_normal_write_view.msg">일반</a>
         <a class="button is-default board" href="message_report_write_view.msg">신고</a>
      </div>
      
 	<form name="message_report_write">
      <div id="table" style="width:780px; margin-left:10px;">
        <table class="table is-bordered">
          <tr>
             <th style="width:100px;">제목</th>
             <td colspan="3"><input name="title" class="message_title" type="text"></td>
          </tr>
          <tr>             
             <th>신고자</th>
             <td style="width:200px;"><%=vo.getUserId() %></td>
             <th>게시자</th>
             <td style="width:200px;"><input name="register" type="text" style="position:absolute; width:240px;"></td>
          </tr>
          
          <tr>             
             <th style="width:100px;">게시판 종류</th>
             <td style="width:200px;">
                 <select name="board">
                     <option value="">게시판 종류</option>
                     <option value="후기게시판">후기게시판</option>
                     <option value="계획게시판">계획게시판</option>
                     <option value="상품게시판">상품게시판</option>
                     <option value="지역게시판">지역게시판</option>
                     <option value="질문게시판">질문게시판</option>
                 </select>
             </td>
             <th style="width:100px;">게시물 주소</th>
             <td style="width:200px;"><input name="address" type="text" style="position:absolute; width:240px;"></td>
          </tr>
          <tr id="content">
             <th style="width:100px;">사유</th>
             <td colspan="3"><textarea name="content" id="area" cols="91" rows="9"></textarea></td>
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
	$("form[name=message_report_write]").submit(function(){
		event.preventDefault();
		if($("input[name=title]").val()==""){
			alert("제목을 입력하세요");
			$("input[name=title]").focus();
			return;
		}
		
		if($("input[name=register]").val()==""){
			alert("게시자를 입력하세요");
			$("input[name=register]").focus();
			return;
		}
		
		if($("select[name=board]").val()==""){
			alert("게시판 종류를 선택하세요.");
			$("select[name=board]").focus();
			return;
		}		
		
		if($("input[name=address]").val()==""){
			alert("게시물 주소를 입력하세요");
			$("input[name=address]").focus();
			return;			
		}
		
		if($("textarea[name=content]").val()==""){
			alert("사유를 입력하세요");
			$("input[name=content]").focus();
			return;			
		}
		
		alert("쪽지를 보냈습니다.");
		this.action="writeR.msg";
		this.method="post";
		this.submit();
	});
})
</script>