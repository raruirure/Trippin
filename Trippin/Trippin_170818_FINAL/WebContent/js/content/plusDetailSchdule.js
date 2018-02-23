$(document).ready(function(){
var idx = 1;
$("#plus_date").click(function() {
	console.log($(this));
	var txt = "<button class='button review_form_day_btn'>day "+idx+"</button>"; 
	idx++;
	$(this).before(txt);
});
});
$(".formMenu ul li").each(function(idx, item) {
	$(item).click(function() {
		if(idx==0) {
			$("#review_schedule").css("display","block");
			$("#reviewMap").css("display","none");
			
		} else {
			
			$("#review_schedule").css("display","none");
			$("#reviewMap").css("display","block");
		}
	})
})

$(window).scroll(function() {
	var window_top = $(window).scrollTop();
	var standard = $(".review_view_heading").offset().top;
	$("#review_view_day_box").animate({
		top : window_top + standard + "px"
	}, 0.5);
})