$(document).ready(function(){
/* detail page start*/
$("#board_list_notice").click(function() {
	location.assign('begin.board');
});

$("#nboard_modify").click(function() {
	document.noticeDetailForm.action='modifyFormBoard.board';
	document.noticeDetailForm.submit();
});
$("#nboard_delete").click(function() {
	event.preventDefault();
	if(confirm("삭제하시겠습니까?")==true){
		document.noticeDetailForm.action='deleteBoard.board';
		document.noticeDetailForm.submit();
	}else{
		return;
	}
}) ;


$("#board_list_free").click(function() {
	location.assign('freeList.board');
});


$("#fboard_modify").click(function() {
	document.freeDetailForm.action='modifyFormBoard.board';
	document.freeDetailForm.submit();
});
$("#fboard_delete").click(function() {
	event.preventDefault();
	if(confirm("삭제하시겠습니까?")==true){
		document.freeDetailForm.action='deleteBoard.board';
		document.freeDetailForm.submit();
	}else{
		return;
	}
}) 
/* detail page end */
});