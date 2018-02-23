<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.vo.PlanBean"%>
<%@page import="org.trippin.vo.ReviewBean"%>
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
  <link rel="stylesheet" type="text/css" href="css/calendar.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="//cdn.materialdesignicons.com/2.0.46/css/materialdesignicons.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap-slider.css">
  <style>
	div.plan{
    	margin:5px 0 5px 0;
     	padding: 0 5px 0 5px;
     }
  </style>
  <script>
  	var compNo=0;
    $(document).ready(function(){
   	 	//var openViewDetail = document.getElementsByClassName("openViewDetail");
    	/* $(".openViewDetail").each(function(idx,item){
    		$(item).click(function(){
    			result_Detail_View(idx);
            });
    	}); */
    	$("#openComp1").click(function(){
    		var compCode1 = $("#compCode1").val();
    		var compCode2 = $("#compCode2").val();
    		if(compCode1.length > 4 || compCode2.length > 4){
    			alert("계획 / 후기만 선택해주세요");
    			return;
    		}
    		if(compCode1 == ""){
    			alert("비교 상품을 선택해 주세요.");
    			return;
    		} else {
    			if(compCode2 == ""){
        			alert("두 번째 비교 상품을 선택해 주세요.");
        			return;
        		}
    		}
    		result_Detail_Comp1(compCode1,compCode2);
    	});
    	$("#openComp2").click(function(){
    		var compCode1 = $("#compCode1").val();
    		var compCode2 = $("#compCode2").val();
    		if(compCode1.length < 4 || compCode2.length < 4){
    			alert("패키지 상품만 선택해주세요");
    			return;
    		}
    		if(compCode1 == ""){
    			alert("비교 상품을 선택해 주세요.");
    			return;
    		} else {
    			if(compCode2 == ""){
        			alert("두 번째 비교 상품을 선택해 주세요.");
        			return;
        		}
    		}
    		result_Detail_Comp2(compCode1,compCode2);
    	});
        $(".resultBtn").each(function(idx,item){
            $(item).click(function(){
                $(".DetailView").eq(idx).toggle();
            });
        });
        $(".compPlan").each(function(idx,item){
            $(item).click(function(){
                if(compNo == 0){
                	var compTitle1 = $(".planTitle").eq(idx).text();
                	var compImg1 = $(".planImg").eq(idx).attr('src');
                	var compCode1 = $(".planCode").eq(idx).val();
                	$("#compCode1").val(compCode1);
                	$("#compTitle1").text(compTitle1);
                	$("#compImg1").attr('src',compImg1);
                	
                	compNo++;
                }else {
                	var compTitle2 = $(".planTitle").eq(idx).text();
                	var compImg2 = $(".planImg").eq(idx).attr('src');
                	var compCode2 = $(".planCode").eq(idx).val();
                	$("#compCode2").val(compCode2);
                	$("#compTitle2").text(compTitle2);
                	$("#compImg2").attr('src',compImg2);
                	compNo=0;
                }
            });
        });
        $(".compReview").each(function(idx,item){
            $(item).click(function(){
                if(compNo == 0){
                	var compTitle1 = $(".reviewTitle").eq(idx).text();
                	var compImg1 = $(".reviewImg").eq(idx).attr('src');
                	var compCode1 = $(".reviewCode").eq(idx).val();
                	$("#compCode1").val(compCode1);
                	$("#compTitle1").text(compTitle1);
                	$("#compImg1").attr('src',compImg1);
                	
                	compNo++;
                }else {
                	var compTitle2 = $(".reviewTitle").eq(idx).text();
                	var compImg2 = $(".reviewImg").eq(idx).attr('src');
                	var compCode2 = $(".reviewCode").eq(idx).val();
                	$("#compCode2").val(compCode2);
                	$("#compTitle2").text(compTitle2);
                	$("#compImg2").attr('src',compImg2);
                	compNo=0;
                }
            });
        });
        $(".compProduct").each(function(idx,item){
            $(item).click(function(){
                if(compNo == 0){
                	var compTitle1 = $(".productTitle").eq(idx).text();
                	var compImg1 = $(".productImg").eq(idx).attr('src');
                	var compCode1 = $(".productCode").eq(idx).val();
                	$("#compCode1").val(compCode1);
                	$("#compTitle1").text(compTitle1);
                	$("#compImg1").attr('src',compImg1);
                	
                	compNo++;
                }else {
                	var compTitle2 = $(".productTitle").eq(idx).text();
                	var compCode2 = $(".productCode").eq(idx).val();
                	var compImg2 = $(".productImg").eq(idx).attr('src');
                	$("#compTitle2").text(compTitle2);
                	$("#compImg2").attr('src',compImg2);
                	$("#compCode2").val(compCode2);
                	
                	compNo=0;
                }
            });
        });
        $('.button-checkbox').each(function () {

        // Settings
        var $widget = $(this),
            $button = $widget.find('button'),
            $checkbox = $widget.find('input:checkbox'),
            color = $button.data('color'),
            settings = {
                on: {
                    icon: 'glyphicon glyphicon-check'
                },
                off: {
                    icon: 'glyphicon glyphicon-unchecked'
                }
            };

        // Event Handlers
        $button.on('click', function () {
            $checkbox.prop('checked', !$checkbox.is(':checked'));
            $checkbox.triggerHandler('change');
            updateDisplay();
        });
        $checkbox.on('change', function () {
            updateDisplay();
        });

        // Actions
        function updateDisplay() {
            var isChecked = $checkbox.is(':checked');

            // Set the button's state
            $button.data('state', (isChecked) ? "on" : "off");

            // Set the button's icon
            $button.find('.state-icon')
                .removeClass()
                .addClass('state-icon ' + settings[$button.data('state')].icon);

            // Update the button's color
            if (isChecked) {
                $button
                    .removeClass('btn-default')
                    .addClass('btn-' + color + ' active');
            }
            else {
                $button
                    .removeClass('btn-' + color + ' active')
                    .addClass('btn-default');
            }
        }

        // Initialization
        function init() {

            updateDisplay();

            // Inject the icon if applicable
            if ($button.find('.state-icon').length == 0) {
                $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i> ');
            }
        }
        init();
    });
    });
    </script>
</head>
<body>
    <!--start of header-->
       <jsp:include page="../include/header.jsp"></jsp:include>
    <!--end of header-->
    <!--Contents Start-->
    <div class="container" style="width:1200px;">
        <div class="container box" style="width:1200px;">
        <!-- Main container -->
            <nav class="level">
                <!-- Left side -->
                <div class="level-left">
                <!--선택된 여행지 이름 나열-->
                    <p class="level-item">선택 여행지</p>
                </div>
                <!-- center -->
                <div class="level-center">
                <!--선택된 여행지 이름 나열-->
                    <p class="level-item" class="places">
                    	<%= request.getAttribute("query") %>
                    </p>
                </div>
                <!-- Right side -->
                <div class="level-right">
                    <p class="level-item">◀</p>
                    <p class="level-item">▶</p>
                </div>
            </nav>
        </div>
        <div>
        </div>
        <div class="columns">
            <aside class="column is-2 aside hero is-fullheight is-hidden-mobile" style="width:300px;">
               <div class="main" style="padding:0;">
                <!--aside map start-->
                <div id="aside map">
                    <iframe src="showMap.map" scrolling=no name=ifmMap width=275px height=275px frameborder=0 style="border-width:0px; border-color:white; border-style:solid;"></iframe>
                </div>
                <!--aside search start-->
                <div id="search">
                    <p class="resultSearch">
                        <input class="input" type="text" placeholder="Search" id="searchMapCode">
                    </p>
                    <p class="resultSearch">
                        <button class="button" style="width:49%;" onclick="receiveMapCode();">ADD</button>
                        <button class="button" style="width:49%;" onclick="startSearch();">Search</button>
                    </p>
                </div>
                <!--aside searchDetail start-->
                <div id="searchDetail">
                    <p><center>날짜 설정<span><button class="resultBtn">▼</button></span></center></p>
                    <hr>
					<div class="DetailView">
						<div class="">
							<input class="input is-one-quarter" type="text" id="from" style="width:100px;">
							<span class="icon" style="height:32px;margin: 5px 0 5px 0;line-height: 32px;">
								<i id="datepicker1" class="fa fa-calendar" aria-hidden="true"></i>
							</span>
							<input class="input is-one-quarter" type="text" id="to" style="width:100px;">
							<span class="icon" style="height:32px;margin: 5px 0 5px 0;line-height: 32px;"> 
								<i id="datepicker2" class="fa fa-calendar" aria-hidden="true"></i>
							</span>
						</div>
                    <hr>
                    </div>
                    <!-- <p><center>가격대 조절<button class="resultBtn">▼</button></center></p>
                    <hr>
                    <div class="DetailView">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <input type="text" id="mini"
                                    data-slider-min="10000" data-slider-max="200000"
                                    date-slider-step="10000" data-slider-value="14"/><br>
                            <span style="color: gray">선택 가격: <span id="miniVal">[가격 표시]</span></span>
                        </div>
                    </div>
                        <hr>
                    </div> -->
                    <p><center>상품 비교<button class="resultBtn">▼</button></center></p>
                    <hr>
                    <div class="DetailView" style="height:200px">
                        <div class="DetailView col-md-2 col-lg-6" style="margin:0;padding:0;">
                        <div class="card">
                          <div class="card-image">
                            <figure class="image is-4by3">
                              <img src="http://placehold.it/300x225" id="compImg1" alt="">
                            </figure>
                          </div>
                          <div class="card-content">
                            <div class="content">
                              <span class="tag is-dark" id="compTitle1" style="font-size:10px;text-align:center">#Title</span>
                              <input type="hidden" id="compCode1">
                            </div>
                          </div>
                        </div>
                        </div>
                        <div class="DetailView col-md-2 col-lg-6"style="margin:0;padding:0;">
                        <div class="card">
                          <div class="card-image">
                            <figure class="image is-4by3">
                              <img src="http://placehold.it/300x225" id="compImg2" alt="">
                            </figure>
                          </div>
                          <div class="card-content">
                            <div class="content">
                              <span class="tag is-dark" id="compTitle2" style="font-size:10px;text-align:center">#Title</span>
                              <input type="hidden" id="compCode2">
                            </div>
                          </div>
                        </div>
                        </div>
                        <center><button class="btn" id="openComp1" style="width:134px;">후기/계획 비교하기</button><button class="btn" id="openComp2" style="width:134px;">상품 비교하기</button></center>
                        <hr>
                    </div>
                </div>
                <!--aside searchCheck start-->
                <!-- <div id="searchCheck">
                    <p class="resultSearch">
                        <span class="button-checkbox">
                            <button type="button" class="btn" data-color="primary">후기검색</button>
                            <input type="checkbox" class="hidden" checked />
                        </span>
                        <span class="button-checkbox">
                            <button type="button" class="btn" data-color="primary">상품검색</button>
                            <input type="checkbox" class="hidden" checked />
                        </span>
                    </p>
                </div> -->
            </div>
            </aside>
	        <div class="rows is-2" style="width:900px;padding:0px;">
	            <nav class="level" style="margin:5px 0 5px 0;">
		            <!-- Left side -->
		            <div class="level-left"></div>
		            <!-- Right side -->
		            <div class="level-right box" style="width:860px;text-align:center;">
		            	<div class="level-right">
		            		<p class="level-item" class="places" style="margin:auto;">[ 후기 / 계획 / 상품 ]</p>
		            	</div>
		                <select class="board select" style="height:40px;border-radius:5px;">
		                <option>가격별</option>
		                <option>조회별</option>
		            </select>
		            </div>
		        </nav>
		        <!-- start of search content -->
		        <div class="container" style="width:900px">
		        <!-- start of plan -->
		        <div class="title is-3" style="margin-top: 20px">여행계획</div><hr>
		        <%
					if(session.getAttribute("allPlan")!=null){
						ArrayList<PlanBean> allPlan = (ArrayList<PlanBean>)session.getAttribute("allPlan");
						for(int i=0; i<allPlan.size();i++){
							PlanBean plan = allPlan.get(i);
				%>
						<div class="col-lg-4" style="width:300px;">
						<div class="card plan">
					    	<div class="card-image">
					        	<figure class="image is-4by3">
					        		<%
					        			if(plan.getBanner_img() !=""){
					        		%>
					        			<img src="upload/<%=plan.getBanner_img() %>" class="planImg" alt="">
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
					            	<span class="tag is-dark planTitle"><%=plan.getMain_title() %></span>
					            	<input type="hidden" value="<%=plan.getCode()%>" class="planCode">
					            </div>
					        </div>
					        <footer class="card-footer">
					        	<a class="card-footer-item"><i class="mdi mdi-heart compPlan" style="font-size:24px;"></i></a>
					            <a class="card-footer-item"><i class="material-icons">create</i></a>
					            <a href="planView.con?code=<%=plan.getCode() %>" class="card-footer-item"><i class="material-icons">search</i></a>
					        </footer>
						</div>
		            </div>	
				<%
						} // end of for
					} else {
				%>
						<center><span>맞는 계획 검색 결과가 없습니다.</span></center>
				<%
					}
				%>
		        <!-- end of plan -->
		        </div>
		        <div class="container" style="width:900px">
		        <!-- start of review -->
		        <div class="title is-3" style="margin-top: 20px">여행후기</div><hr>
		        <%
					if(session.getAttribute("allReview")!=null){
						ArrayList<ReviewBean> allReview = (ArrayList<ReviewBean>)session.getAttribute("allReview");
						for(int i=0; i<allReview.size();i++){
							ReviewBean review = allReview.get(i);
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
							} // end of for
						} else {
							%>
							<center><span>맞는 후기 검색 결과가 없습니다.</span></center>
					<%
						}
					%>
		        <!-- end of review -->
		        </div>
		        <div class="container" style="width:900px">
		        <!-- start of product -->
		        <div class="title is-3" style="margin-top: 20px">여행상품</div><hr>
		        <%
				        if(session.getAttribute("allProduct")!=null){
				        ArrayList<ProductVo> allProduct = (ArrayList<ProductVo>)session.getAttribute("allProduct");
				        
				        for(int i=0; i<allProduct.size();i++){
				        	ProductVo product = allProduct.get(i);
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
				                       <a class="card-footer-item"><i class="mdi mdi-heart compProduct" style="font-size:24px;"><%=product.getPro_hit() %></i></a>
				                        <a class="card-footer-item"><i class="material-icons">create</i></a>
				                        <a href="productDetail.con?pro_cd=<%= product.getPro_cd() %>" class="card-footer-item"><i class="material-icons">search</i></a>
				                  </footer>
							</div>
			            </div>	
		         <%
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
    <!--Contents End-->
    <!--Footer Start-->

    <!--Footer End-->
  </div>
  <script src="js/bootstrap-slider.js"></script>
  <script>
  $("#mini").slider({
      formatter: function(value){
          return '현재값: '+value;     
      }
  });
  $("#mini").on("slide",function(slideEvt){
      $("#miniVal").text(slideEvt.value);
  });
  function searchMapCode(){
	  var sendMapCode = $("#searchMapCode").val();
	  document.ifmMap.location='showMap.map?sendMapCode='+sendMapCode;
  }
  function receiveMapCode(){
	  var sendMapCode = ifmMap.document.getElementById("sendMapCode").value;
	  alert(sendMapCode);
  }
  function startSearch(){
  	var keyword = document.getElementById("searchMapCode").value;
  	location.assign("search.main?keyword="+keyword);
  }
  function result_Detail_Comp1(compCode1,compCode2){
		window.open('popup/resultDetailComp.jsp?compCode1='+compCode1+'&compCode2='+compCode2,
				'Detail_Comp', 'width=1200px, height=330px, menubar=no, status=no, toolbar=no, location=no, resizable=no, fullscreen=no');
	}
  function result_Detail_Comp2(compCode1,compCode2){
		window.open('popup/resultDetailComp2.jsp?compCode1='+compCode1+'&compCode2='+compCode2,
				'Detail_Comp', 'width=1200px, height=330px, menubar=no, status=no, toolbar=no, location=no, resizable=no, fullscreen=no');
	}
  </script>
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="js/writeform_Datepicker.js"></script>

</html>
