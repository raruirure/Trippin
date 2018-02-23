<%@page import="org.trippin.vo.CartVo"%>
<%@page import="org.trippin.vo.OrderVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.css">
  <link rel="stylesheet" type="text/css" href="css/mypage/mypage_aside_bulma.css">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <script src="js/bs_leftnavi.js"></script>

</head>
<style>
    /******** order box *****/
    .media-body {
        width:50%;

    }
    .table thead tr th {
        text-align: center;
    }

</style>

<script>
    $(document).ready(function(){
        //최상단 체크박스 클릭
        $("#checkall").click(function(){
            //클릭되었으면
            if($("#checkall").prop("checked")){
                //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
                $("input[name=chk]").prop("checked",true);
                //클릭이 안되있으면
            }else{
                //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
                $("input[name=chk]").prop("checked",false);
            }
        })


     /* error나서 일단 주석처리함  
     	$(function() {
            $("#datepicker1, #datepicker2").datepicker({
                dateFormat: 'yy-mm-dd'
            });
        }); */
    })


</script>

<body>
<%@include file="../include/header.jsp" %>
<!-- Left 메뉴 시작 -->
<div class="columns" style="min-height:700px;">
   <%@include file="mypage_aside.jsp" %>
    <!--  Left 메뉴 끝-->


    <!-- 메인 컨텐츠 시작 -->
    <div class="content column is-9" >
        <div class="title is-2" style="margin-top: 20px">주문내역</div>
        <hr>
        <div class="serachBox">
            <p class="filterMonth">조회기간:
                <input type="text" id="datepicker1" style="width:300px;"> ~
                <input type="text" id="datepicker2" style="width:300px;"> 
                <button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-search"></span> 검색</button>
            </p>
        </div>

        <div class="container">
            <div class="row">
                <div class=" col-md-9">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th class=" col-md-1"><input type="checkbox" id="checkall" /></th>
                            <th class="text-center col-md-4">상품명</th>
                            <th class="text-center col-md-3">구매일</th>
                            <th class="text-center col-md-3">구매액</th>
                            <th class="text-center col-md-2">비고</th>
                            <th> </th>
                        </tr>
                        </thead>
                        <tbody>
		                <%
		                if(request.getAttribute("orderList") != null){
		                	ArrayList<OrderVo> orderList = (ArrayList<OrderVo>)request.getAttribute("orderList");	
		                		for(int i=0;i<orderList.size();i++){
		                			OrderVo orderVo = orderList.get(i);	
		                %>
		                <tr>
			                <td class="col-sm-1 col-md-1 text-center"><input type="checkbox" name="chk" /></td>
			                <td class="text-center"><strong><%=orderVo.getPro_name()%></strong></td>
			                <td class="text-center ">
			                      
			                </td>
		           		    <td class="text-center "><%=orderVo.getPro_cnt() * orderVo.getPro_price()%></td>
		                	<td class="col-sm-1 col-md-1 text-center"><strong></strong></td>
		                 </tr>
						<%
	                		}
		                }
						%>
                        </tbody>
                        
                    </table>
                    <input type="button" class="btn btn-primary mypage_cancel" value="환불하기" style="float: right;">
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="../include/footer.jsp" %>
</body>
<script type="text/javascript" src="js/bulma.js"></script>
</html>