<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
</head>

<body>
<%
	request.setCharacterEncoding("euc-kr");
	String dir = "C:\\Temp";
	int max = 1024*1024*5;
	String filename="";
	
	MultipartRequest mpr = new MultipartRequest (request, dir, max, "utf-8", new DefaultFileRenamePolicy());

	
	String realName = mpr.getOriginalFileName("file");
	String sysName = mpr.getFilesystemName("file");
	
	
	String fullpath = dir +"\\"+ sysName;
%>

<%-- 
<img src="<%=fullpath %>" width=500 height=350></img><br/>
realName :<%=realName%><br>
sysName : <%=filename %>
 --%>
<h1>프로필 입력이 완료 되었습니다!</h1>
</body>



</html>
