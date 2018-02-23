<%@page import="org.trippin.dao.ProductDao"%>
<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.dao.ReviewDAO"%>
<%@page import="org.trippin.vo.ReviewBean"%>
<%@page import="org.trippin.db.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.trippin.dao.PlanDAO"%>
<%@page import="org.trippin.vo.PlanBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
<link rel="stylesheet" type="text/css" href="../css/result.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
<title>상품 미리 보기</title>
<style>
th, td{
	height:40px;
	line-height: 40px;
}
</style>
</head>
<body>
	<%
		String compCode1 = request.getParameter("compCode1");
		String compCode2 = request.getParameter("compCode2");
		ProductVo proContent1 = null;
		ProductVo proContent2 = null;
		Connection conn = JdbcUtil.getConnection();
		
		ProductDao dao = ProductDao.getInstance();
		dao.setConnection(conn);
		
		proContent1 = dao.getProductCon(compCode1);
		if( proContent1.getPro_display()==1)  {
			dao.setProductHit(proContent1.getPro_cd());
		}
		proContent2 = dao.getProductCon(compCode2);
		if( proContent2.getPro_display()==1)  {
			dao.setProductHit(proContent2.getPro_cd());
		}
	%>
	<div class="row" style="background: white;width:1000px;margin:0;">
			<div class="col-lg-4" style="width:300px;">
				<div class="card">
					<div class="card-image">
						<figure class="image is-4by3">
							<img src="<%=proContent1.getPro_img() %>" alt="">
						</figure>
					</div>
					<div class="card-content">
						<div class="content">
							<span class="tag is-dark"><%=proContent1.getPro_name() %></span>
						</div>
						<div class="content">
							<strong class="timestamp"><%=proContent1.getPro_price()%></strong>
						</div>
					</div>
				</div>
            </div>
            <div class="col-lg-4" style="width:400px;">
				<table class="table" id="overView">
					<tr>
						<th>구분</th>
						<th>A상품</th>
						<th>B상품</th>
					</tr>
					<tr>
                      	<th>상품명</th>
                      	<td>[입력]</td>
                      	<td>[입력]</td>
                  	</tr>
<tr>
                      	<th>가격</th>
                      	<td>[입력]</td>
                      	<td>[입력]</td>
                  	</tr>
                  	<tr>
                      	<th>기간</th>
                      	<td>[입력]</td>
                      	<td>[입력]</td>
                  	</tr>
                  	<tr>
                      	<th>경로</th>
                      	<td>[입력]</td>
                      	<td>[입력]</td>
                  	</tr>
                  	<tr>
                      	<th>기타</th>
                      	<td>[입력]</td>
                      	<td>[입력]</td>
                  	</tr>
                  	<tr>
                  		<th><center><a class="btn btn-info" role="button" href="#">상세보기 »</a></th></center>
                  	</tr>
              	</table>
			</div>
			<div class="col-lg-4" style="width:300px;">
				<div class="card">
					<div class="card-image">
						<figure class="image is-4by3">
							<img src="<%=proContent2.getPro_img() %>" alt="">
						</figure>
					</div>
					<div class="card-content">
						<div class="content">
							<span class="tag is-dark"><%=proContent2.getPro_name() %></span>
						</div>
						<div class="content">
							<strong class="timestamp"><%=proContent2.getPro_price()%></strong>
						</div>
					</div>
				</div>
            </div>
		</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%
JdbcUtil.close(conn);
%>
</body>
</html>