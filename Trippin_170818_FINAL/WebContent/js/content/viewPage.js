$(document).ready(function(){
	$(window).scroll(function() {
		var window_top = $(window).scrollTop();
		if(window_top <450){
			window_top = 350;
		}
		var standard = $(".review_view_heading").offset().top;
		$("#review_view_day_box").animate({
			top : window_top + standard + "px"
		}, 2);
	}) 
})