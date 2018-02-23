<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.vo.ReviewBean"%>
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
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.1.0/css/bulma.min.css">
  <link rel="stylesheet" type="text/css" href="css/main/main.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap-slider.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" type="text/css" href="css/calendar.css">
  <link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
html,body{
	background:#f5f7fa;
}
</style>

</head>
<body>
<%@include file="include/header.jsp" %>
   
  <div id="page">

  <nav class="nav has-shadow" id="top">
    <div class="container">
      <div class="nav-both1">
          <a class="nav-item">
            <input type="text" id="search1">
          </a>    
      <span class="nav-toggle">
        <span></span>
        <span></span>
        <span></span>
      </span>
       </div>
       <div class="nav-both2">
        <span class="nav-item">
		  <button class="button" id="searchMainMapCode">지도검색</button>
          <a class="button main_add_path">추가</a>  
          <a class="button main_button_search" onclick="startSearch();">검색</a>
        </span>
       </div>
    </div>
  </nav>
  
 <nav class="nav has-shadow" id="top">
    <div class="container1">
          <a class="nav-item main_detailedInfor_drop_box">
            <i class="fa fa-caret-down main"></i>&nbsp;상세검색
          </a>
       
          <div class="main detail search">
              <ul>
                <li class="main big drop li first">
                   <span class="main relative up">날짜 설정</span> 
					<input type="text" id="from">
			<div id="datepicker1">
				<i class="fa fa-calendar" aria-hidden="true"></i>
			</div>
				<div class="title review_form_date_tilde">~</div>
				<input class="input is-one-quarter" type="text" id="to">
			<div id="datepicker2">
				<span class="icon"> <i class="fa fa-calendar"
					aria-hidden="true"></i>
				</span>
			</div>
                </li>
                  <li class="main big drop li">
                  <div class="panel panel-default">
                        <div class="panel-body">
                            <input type="text" id="mini"
                                    data-slider-min="10000" data-slider-max="200000"
                                    date-slider-step="10000" data-slider-value="14"/><br>
                            <span style="color: gray">선택 가격: <span id="miniVal">[가격 표시]</span></span>
                        </div>
                    </div>
                  </li>
                  <li class="main big drop li float_left"><input type="checkbox" class="main detailsearch checkbox">상품검색<input type="checkbox" class="main detailsearch checkbox left">후기검색</li>
              </ul>
          </div>
    </div>
  </nav>
  <div class="container profile">
    <div class="main_map_view">
    	<iframe src="showMainMap.map" scrolling=no name=ifmMainMap width="100%" height="100%" frameborder=0 style="border-width:0px; border-color:white; border-style:solid;"></iframe>
    </div>
      
      </div>
    
    <div class="spacer">
     
     </div>
    <nav class="level" style="margin:5px 0 20px 0;">
       		<div class="level-left">
        		<input type="text" class="main input for search" id="searchMain">
        	</div>
    </nav>
    <div class="columns main" style="text-align:center;">   
        <div class="rows is-2" style="display: inline-block;margin:auto;">
        
		        <!-- start of search content -->
		        <div class="container" style="margin:auto;width:900px;">
		        <!-- start of plan -->
		        <%
					if(session.getAttribute("MainPlan")!=null){
						ArrayList<PlanBean> MainPlan = (ArrayList<PlanBean>)session.getAttribute("MainPlan");
						for(int i=0; i<MainPlan.size();i++){
							PlanBean Mplan = MainPlan.get(i);
				%>
						<div class="col-lg-4" style="width:300px;">
						<div class="card plan">
					    	<div class="card-image">
					        	<figure class="image is-4by3">
					        		<%
					        			if(Mplan.getBanner_img() !=""){
					        		%>
					        			<img src="upload/<%=Mplan.getBanner_img() %>" class="planImg" alt="">
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
					            	<span class="tag is-dark planTitle"><%=Mplan.getMain_title() %></span>
					            	<input type="hidden" value="<%=Mplan.getCode()%>" class="planCode">
					            </div>
					        </div>
					        <footer class="card-footer">
					        	<a class="card-footer-item"><i class="mdi mdi-heart compPlan" style="font-size:24px;"></i></a>
					            <a class="card-footer-item"><i class="material-icons">create</i></a>
					            <a href="planView.con?code=<%=Mplan.getCode() %>" class="card-footer-item"><i class="material-icons">search</i></a>
					        </footer>
						</div>
		            </div>	
				<%
				break;
						} // end of for
					} else {
				%>
						<center><span>맞는 계획 검색 결과가 없습니다.</span></center>
				<%
					}
				%>
		        <!-- end of plan -->
		        <!-- start of review -->
		        <%
					if(session.getAttribute("MainReview")!=null){
						ArrayList<ReviewBean> MainReview = (ArrayList<ReviewBean>)session.getAttribute("MainReview");
						for(int i=0; i<MainReview.size();i++){
							ReviewBean review = MainReview.get(i);
				%>
						<div class="col-lg-4" style="width:300px;">
						<div class="card plan">
					    	<div class="card-image">
					        	<figure class="image is-4by3">
					        		<%
					        			if(review.getBanner_img() !=""){
					        		%>
					        			<img src="upload/<%=review.getBanner_img() %>" class="reviewImg" alt="">
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
					            	<span class="tag is-dark reviewTitle"><%=review.getMain_title() %></span>
					            	<input type="hidden" value="<%=review.getCode()%>" class="reviewCode">
					            </div>
					        </div>
					        <footer class="card-footer">
					        	<a class="card-footer-item"><i class="mdi mdi-heart compReview" style="font-size:24px;"></i></a>
					            <a class="card-footer-item"><i class="material-icons">create</i></a>
					            <a href="reviewView.con?code=<%=review.getCode() %>" class="card-footer-item"><i class="material-icons">search</i></a>
					        </footer>
						</div>
		            </div>	
					<%
					break;
							} // end of for
						} else {
							%>
							<center><span>맞는 후기 검색 결과가 없습니다.</span></center>
					<%
						}
					%>
		        <!-- end of review -->
		        <!-- start of product -->
		        <%
				        if(session.getAttribute("MainProduct")!=null){
				        ArrayList<ProductVo> MainProduct = (ArrayList<ProductVo>)session.getAttribute("MainProduct");
				        
				        for(int i=0; i<MainProduct.size();i++){
				        	ProductVo product = MainProduct.get(i);
			        %>	
			            <div class="col-lg-4 plan" style="width:300px;">
							<div class="card">
						          <div class="card-image">
						            <figure class="image is-4by3">
		                          <%
		                             if(product.getPro_img() !=null){
		                          %>
		                             <img src="images/upload/product/<%=product.getPro_img() %>" class="productImg" alt="">
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
				                         <span class="tag is-dark productTitle"><%=product.getPro_name() %></span>
				                         <input type="hidden" value="<%=product.getPro_cd()%>" class="productCode">
				                     </div>
				                  </div>
				                  <footer class="card-footer">
				                       <a class="card-footer-item"><i class="mdi mdi-heart compProduct" style="font-size:24px;"></i></a>
				                        <a class="card-footer-item"><i class="material-icons">create</i></a>
				                        <a href="productDetail.con?pro_cd=<%= product.getPro_cd() %>" class="card-footer-item"><i class="material-icons">search</i></a>
				                  </footer>
							</div>
			            </div>	
		         <%
		         		break;
		               } // end of for
		            }  else{// end of if
		            	%>
		            		<center><span>해당 상품이 등록되지 않았습니다.</span></center>
		            	<%
		            }
				%>
		        <!-- end of product -->
		        </div>
		        <!-- end of search content -->
			</div>
        
	</div>
</div>
<%@include file="include/footer.jsp" %>
<script>
            $(document).ready(function(){
            	$(".button.main_add_path").click(function(){
            		var value = $("#search1").val();
            		$(".main.input.for.search").val(value);
            	});
            	$(".button.main_button_search").click(function(){
            		<% 
            		 if(session.getAttribute("member")!=null){
            		%>	        				
            			<%
            			}else{
            			%>
            				alert("로그인 한 후에 이용가능합니다.");
            			<%
            			}
            			%>
            	});
            	
            	var sw=0;
                $(".main.detail.search").hide();
                $(".nav-item.main_detailedInfor_drop_box").click(function(){
                	if(sw==0){
                		$(".fa.fa-caret-down.main").addClass('main_triangle_rotate ');
                		sw=1;
                	}else if(sw==1){
                		$(".fa.fa-caret-down.main").removeClass('main_triangle_rotate ');
                		sw=0;
                	}
                    $(".main.detail.search").toggle();
                });
                $("#searchMainMapCode").click(function(){
                	var sendMapCode = $("#search1").val();
                	document.ifmMainMap.location='showMainMap.map?sendMapCode='+sendMapCode;
                });
                function addMainMapCode(){
              	  var sendMapCode = ifmMainMap.document.getElementById("sendMapCode").value;
              	  $("#main_input_for_search").val() = $("#main_input_for_search").val()+sendMapCode;
                }
            });
            function startSearch(){
            	var keyword = document.getElementById("searchMain").value;
            	location.assign("search.main?keyword="+keyword);
            }
          </script>
<script src="js/main/main_detail_menu.js"></script>
<script src="js/main/main.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="js/writeform_Datepicker.js"></script>
<script src="js/bootstrap-slider.js"></script>
</body>
</html>    