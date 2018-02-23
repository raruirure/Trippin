	$(".productDViewTabs li").each(function(idx,item){
		$(item).click(function(){
			if(idx==0){
				$(".pDetailbox").css("display","block");
				$(".pReviewBox").css("display","none");
				$(".pQnaBox").css("display","none");
				$(".pSellerBox").css("display","none");
				
			}else if(idx==1){
				$(".pDetailbox").css("display","none");
				$(".pReviewBox").css("display","block");
				$(".pQnaBox").css("display","none");
				$(".pSellerBox").css("display","none");
				
			}else if(idx==2){
				$(".pDetailbox").css("display","none");
				$(".pReviewBox").css("display","none");
				$(".pQnaBox").css("display","block");
				$(".pSellerBox").css("display","none");
				
			}else if(idx==3){
				$(".pDetailbox").css("display","none");
				$(".pReviewBox").css("display","none");
				$(".pQnaBox").css("display","none");
				$(".pSellerBox").css("display","block");
				
			}
		});
	});
	
	$("form[name=content_review_form]").submit(function(){
		event.preventDefault();
		this.action="ContentReviewWrite.con";
		this.method="post";
		this.submit();
	});

	$("#cnt_minus").click(function() {
		var view = parseInt($("input[name=pro_order_cnt").val());
		if(view>1) {
			view = view-1;
			$("input[name=pro_order_cnt").val(view);
		}
	});
	$("#cnt_plus").click(function() {
		var view = parseInt($("input[name=pro_order_cnt").val());
		view = view+1;
		$("input[name=pro_order_cnt").val(view);
	})