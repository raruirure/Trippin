$(document).ready(function(){
	
var boardMenu = ['begin.board','freeList.board'];
$('#board_content_side a').each(function(idx,item){
	$(item).click(function(){
		location.assign(boardMenu[idx]);
		var boardMenu_detail = document.getElementsByClassName("name board_defalut");
		for(var i=0;i<2;i++){
			if(boardMenu_detail[i]==boardMenu_detail[idx]){
				$(boardMenu_detail[i]).addClass('white_active');
			}else{
				$(boardMenu_detail[i]).removeClass('white_active');
			}
		}
	})
});


});