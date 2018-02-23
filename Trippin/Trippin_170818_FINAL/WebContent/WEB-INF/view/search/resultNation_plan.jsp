<%@page import="org.trippin.vo.PlanBean"%>
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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/result.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap-slider.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
  <script>
    $(document).ready(function(){
        $(".nationBtn").each(function(idx,item){
            $(item).click(function(){
                $(".searchLand").eq(idx).toggle();
            });
        });
        $(".card").click(function() {
        	$(location).attr('href','planView.con')
        });
    });
    
	$(function(){
		$("boardSelect").click(function(){
			var boardSelect = $("#boardSelect option:selected").val();
			alert($(this).val());
			
		});
	});
    </script>
    <style>
        .searchLand {
            background: white;
            color: gray;
            text-align: center;
        }
        .searchLand li:hover{
            background: #F2F2F2;
        }
        div.plan{
        	margin:5px 0 5px 0;
     		padding: 0 5px 0 5px;
        }
    </style>
</head>
<body>
    <!--start of header-->
   <jsp:include page="../include/header.jsp"></jsp:include>
    <!--end of header-->
    <!--Contents Start-->
    <div class="container" style="width:1200px;">
        <div class="columns">
            <aside class="column is-2 aside hero is-fullheight is-hidden-mobile" style="width:300px;">
               <div class="main" style="padding:0;">
                <div id="searchDetail">
                    
                <!-- category Parameter 추가  -->
                    <p><center><a href="plan.main?category=asia">아시아</a><button class="nationBtn">▼</button></center></p>
                    <hr>
                    <div class="searchLand">
                        <ul>
                            <li><a href="">한국</a></li>
                            <li><a href="">중국</a></li>
                            <li><a href="">일본</a></li>
                            <li><a href="">대만</a></li>
                            <li><a href="">태국</a></li>
                            <li><a href="">필리핀</a></li>
                        </ul>
                    </div>
                    <p><center><a href="plan.main?category=europe">유럽</a><button class="nationBtn">▼</button></center></p>
                    <hr>
                    <div class="searchLand">
                        <ul>
                            <li><a href="">영국</a></li>
                            <li><a href="">프랑스</a></li>
                            <li><a href="">독일</a></li>
                            <li><a href="">스페인</a></li>
                            <li><a href="">스위스</a></li>
                            <li><a href="">이탈리아</a></li>
                        </ul>
                    </div>
                    <p><center><a href="plan.main?category=oseania">오세아니아</a><button class="nationBtn">▼</button></center></p>
                    <hr>
                    <div class="searchLand">
                        <ul>
                            <li><a href="">호주</a></li>
                            <li><a href="">뉴질랜드</a></li>
                        </ul>
                    </div>
                    <p><center><a href="plan.main?category=america">아메리카</a><button class="nationBtn">▼</button></center></p>
                    <hr>
                    <div class="searchLand">
                        <ul>
                            <li><a href="">미국</a></li>
                            <li><a href="">캐나다</a></li>
                            <li><a href="">브라질</a></li>
                            <li><a href="">칠레</a></li>
                        </ul>
                    </div>
                    <p><center><a href="plan.main?category=africa">아프리카</a><button class="nationBtn">▼</button></center></p>
                    <hr>
                    <div class="searchLand">
                        <ul>
                            <li><a href="">토고</a></li>
                            <li><a href="">가나</a></li>
                            <li><a href="">나이지리아</a></li>
                            <li><a href="">기니</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            </aside>
            <div class="rows is-2" style="width:900px;padding:0px;">
            <nav class="level" style="margin:5px 0 5px 0;">
	            <!-- Left side -->
	            <div class="level-left"></div>
	            <!-- Right side -->
	            <div class="level-right box" style="width:860px;text-align:center;">
	            	<div class="level-right">
	            		<p class="level-item" class="places" style="margin:auto;">[ 해당 영역에 선택 된 여행지 나열 ]</p>
	            	</div>
	            	
	            	<!-- 대륙별 검색 설정 Start -->
     				<form name = "list_order">
	            	    <select onchange="location.href=this.value;" id="boardSelect" class="board select"   style="height:40px;border-radius:5px;">
	                	 	<option value="">정렬순서</option>
	               	 		<option value="plan.main?select=s1">좋아요별</option>
	               	 		<option value="plan.main?select=s2">조회별</option>
	            		</select>
	            	</form>
	            	<!-- end -->
	            </div>
	        </nav>
	        <!-- 컨텐츠 박스시작 -->
	        
	        <%
		        if(session.getAttribute("plan")!=null){
		        ArrayList<PlanBean> selectAll = (ArrayList<PlanBean>)session.getAttribute("plan");
		        
		        for(int i=0; i<selectAll.size();i++){
			        PlanBean plan = selectAll.get(i);
		        %>
	        
	             
	        <div class="col-lg-4 plan" id="reviewContent" style="width:300px;">
               <div class="card plan">
                   <div class="card-image">
                       <figure class="image is-4by3">
                          <%
                             if(plan.getBanner_img() !=null){
                          %>
                             <img src="upload/<%=plan.getBanner_img() %>" alt="">
                          <%      
                             }else{
                          %>
                             <img src="http://placehold.it/300x225" alt="">   
                          <%      
                             }
                          %>
                        </figure>
                    </div>
                    <div class="card-content" style="height:60px;line-height: 60px;">
                       <div class="content">
                           <span class="tag is-dark"><%=plan.getMain_title() %></span>
                        </div>
                    </div>
                    <footer class="card-footer">
                       <a class="card-footer-item"><i class="mdi mdi-heart" style="font-size:24px;"></i></a>
                        <a class="card-footer-item"><i class="material-icons">create</i></a>
                        <a href="planView.con?code=<%= plan.getCode() %>" class="card-footer-item"><i class="material-icons">search</i></a>
                    </footer>
               </div>
               </div>   
         <%
               } // end of for
            } // end of if
		%>				
	          
			</div>
    </div>
    <!--Contents End-->
    <!--Footer Start-->

    <!--Footer End-->
    </div>
    <!--Modal Area Start-->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
          <!-- Modal content Start-->
          <!-- Modal content End-->
        </div>
    </div>
    <!--Modal Area End-->
</body>
</html>