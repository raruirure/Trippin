<%@page import="org.trippin.vo.ProductVo"%>
<%@page import="org.trippin.vo.ReviewCommentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bulma.css">
<link rel="stylesheet" type="text/css" href="css/content/product.css">
<link rel="stylesheet" type="text/css" href="css/content/product_detailView.css">
<link rel="stylesheet" type="text/css" href="css/content/comment.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<title>TRIPPIN</title>
<link rel="icon" href="images/favicon_trippin.JPG">

</head>
<%
ProductVo vo = (ProductVo)request.getAttribute("procontent");
%>
<body>
	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<!-- contents -->
	<div class="section product-header">
		<div class="container">
			<div class="columns">
				<div class="column">
					<span class="title is-3"><%= vo.getPro_name() %></span> <span
						class="title is-3 has-text-muted">&nbsp;|&nbsp;</span> <span
						class="title is-4 has-text-muted"><%= vo.getPro_category() %></span>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="section">
			<div class="container">
				<div class="columns">
					<div class="column is-6">
						<div class="image is-2by2">
							<img src="<%=request.getContextPath() + "/" + ProductVo.SAVEFOLDER + "/" + vo.getPro_img() %>">
						</div>
					</div>
					<div class="column is-5 is-offset-1">
						<div class="title is-2"><%= vo.getPro_name() %></div>
						
						<hr>
						<form name="proViewForm" method="post">
						<input type="hidden" name="pro_cd" value="<%=vo.getPro_cd()%>" />
						<input type="hidden" name="pro_name" value="<%=vo.getPro_name() %>" />
						<table class="table">
							<tbody>
								<tr>
									<td class="has-text-right"><strong>경로</strong></td>
									<td></td>
								</tr>
								<tr>
									<td class="has-text-right"><strong>가격</strong></td>
									<td><input type="hidden" name="cart_price" value="<%= vo.getPro_price()%>"><%= vo.getPro_price() %></td>
								</tr>
								<tr>
									<td class="has-text-right"><strong>인원수</strong></td>
									<td>
									<i class="fa fa-minus cart-icon" id="cnt_minus"></i>
									&nbsp; <input type="text" name="pro_order_cnt"
										class="input has-text-centered" value="1"
										style="width: 40px; height: 30px;"> &nbsp; 
											<i class="fa fa-plus cart-icon" id="cnt_plus"></i>
									</td>
								</tr>
								<tr>
									<td class="has-text-right"><strong>일정</strong></td>
									<td><select name="cartNum">
											<%
												String[] edate = vo.getPro_edate();
												String[] sdate = vo.getPro_sdate();
												int[] cnt = vo.getPro_cnt();
												for (int i = 0; i < edate.length; i++) {
											%>
											<option value="<%=i+1%>"><%=sdate[i] %> - <%=edate[i] %> / <%=cnt[i]%>명</option>
											<%
												}
											%>
									</select></td>
								</tr>
							</tbody>
						</table>
						<div id="productBtn">
							<a class="cartBtn button is-primary" href="#" onclick="cartBtn()">장바구니</a>
							<a class="payBtn button is-primary" href="#" onclick="payBtn()">결제</a>
						</div>
						</form>
						<br>
					</div>
				</div>
			</div>
		</div>
		<div class="section">
			<div class="productContainer container">
				<div class="productDViewTabs tabs">
					<ul>
						<li class="is-active"><a>상품정보</a></li>
						<li><a>상품리뷰(1)</a></li>
						<li><a>Q&A(4)</a></li>
						<li><a>판매자정보</a></li>
					</ul>
				</div>
				
				<!-- 상품상세정보 box -->
				<div class="pDetailbox box">
					<p><%= vo.getPro_content() %></p>
				</div>
				<!-- 상품상세정보 box end -->

				<!-- 리뷰 box -->
				<div class="pReviewBox box">
					<p class="subtitle is-4">상품리뷰(1)</p>

					<!-- 리뷰 댓글 -->
					<div class="pvComment box">
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						
						<!-- 리뷰 작성 폼 시작-->
						<form name="content_review_form">										
						<div class="media-content">
							<p class="control">
								<input type="hidden" name="code" value="P" />
								<input type="hidden" name="pro_cd" value=<%=request.getAttribute("pro_cd") %> />
								<textarea class="textarea" placeholder="상품리뷰를 작성해주세요." name="content_review_content"  cols=80></textarea>
							</p>
							<nav class="level">
							<div class="pCommentWriteBtn level-right">
								<div class="level-item">
									<button type="submit" class="button is-info">작성하기</button>
								</div>
							</div>
							</nav>
						</div>
						</form>
						
						</article>
						
							<!-- 댓글 나오는 부분 -->
					 	<%
					 	ArrayList<ReviewCommentVo> read_list = (ArrayList<ReviewCommentVo>)session.getAttribute("read_list");
							for(int i =0;i<read_list.size();i++){
								ReviewCommentVo reivewvo = read_list.get(i);
						%>
						<hr>
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						<div class="media-content">
							<div class="content">
								<p>
									<strong><%=reivewvo.getUserId() %></strong> <small> · 3 hrs</small> <br> <%=reivewvo.getReCmtContent() %>
								</p>
							</div>
						</div>
						</article>
						<div class="spacer"></div>
						<%
							}	// end of for
						%>
					<!-- 리뷰 댓글end -->
				</div>
				</div>
				<!-- 리뷰 box end -->
				
				<!-- Q&A box-->
				<div class="pQnaBox box">
					<p class="subtitle is-4">Q&A (3)</p>

					<!-- Q&A 댓글 -->
					<div class="pQnaComment box">
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						<div class="media-content">
							<p class="control">
								<textarea class="textarea" placeholder="Q&A작성"></textarea>
							</p>
							<nav class="level">
							<div class="pCommentWriteBtn level-right">
								<div class="level-item">
									<a class="button is-info">작성하기</a>
								</div>
							</div>
							</nav>
						</div>
						</article>
						<hr>
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						<div class="media-content">
							<div class="content">
								<p>
									<strong>User1</strong> <small> · 3 hrs</small> <br> 좋네요
								</p>
							</div>
						</div>
						</article>
						<div class="spacer"></div>
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						<div class="media-content">
							<div class="content">
								<p>
									<strong>User2</strong> <small> · 3 hrs</small> <br> 그냥그래요.
								</p>
							</div>
						</div>
						</article>
						<div class="spacer"></div>
						<article class="media"> <figure class="media-left">
						<p class="image is-64x64">
							<img src="http://placehold.it/128x128">
						</p>
						</figure>
						<div class="media-content">
							<div class="content">
								<p>
									<strong>User3</strong> <small> · 3 hrs</small> <br> 안녕하세요
								</p>
							</div>
						</div>
						</article>
					</div>
					<!-- Q&A 댓글 end -->
				</div>
				<!-- Q&A box end -->

				<!-- 판매자 정보 box -->
				<div class="pSellerBox box">
					<p class="subtitle is-4">판매자 정보</p>
					<table class="table is-fullwidth">
						<tr>
							<th class="column is-4">판매자 아이디</th>
							<td><%= vo.getSeller_id() %></td>
						</tr>
						<tr>
							<th class="column is-4">상호명 / 대표자</th>
							<td><%= vo.getSeller_business_name() %> / <%= vo.getSeller_agent() %></td>
						</tr>
						<tr>
							<th class="column is-4">사업자 등록번호</th>
							<td><%= vo.getSeller_num() %></td>
						</tr>
						<tr>
							<th class="column is-4">전화번호</th>
							<td><%= vo.getSeller_phonenum() %></td>
						</tr>
						<tr>
							<th class="column is-4">회사주소</th>
							<td>[<%= vo.getSeller_address_post() %>]<%= vo.getSeller_address() %> <%= vo.getSeller_address_detail() %></td>
						</tr>
					</table>

				</div>
				<!-- 판매자 정보 box end -->
				
			</div>
		</div>
	</div>

	<!--  footer  -->
	
	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
<script src="js/content/product_detailView.js"></script>
<script>

function cartBtn(){
	event.preventDefault();
	
	var pViewForm = document.proViewForm;
	pViewForm.action = "mypage_product_cart_add.order";
	pViewForm.submit();
}

function payBtn(){
	event.preventDefault();
	
	var pViewForm = document.proViewForm;
	pViewForm.action = "product_pay.order";
	pViewForm.submit();
}

</script>
</html>

