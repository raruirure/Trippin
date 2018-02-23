$(document).ready(function(){
	$(".btn.btn-primary.mypage_cancel").click(function(){
		location.assign("user_check_cancel.mypage");
	})
	
	$(".btn.btn-info.order_completed_cancel").click(function(){
		location.assign("order_completed_cancel.mypage");
	})
});