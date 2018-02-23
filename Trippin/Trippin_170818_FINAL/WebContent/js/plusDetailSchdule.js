$(document).ready(function(){
var idx = 1;
$("#plus_date").click(function() {
	console.log($(this));
	var txt = "<button class='button review_form_day_btn'>day "+idx+"</button>"; 
	idx++;
	$(this).before(txt);
});
});