$(document).ready(function(){

$("form[name=writeBoardForm]").submit(function(){
	event.preventDefault();
	if(this.title.value == ""){
		alert("제목을 입력하세요.");
		this.title.focus();
		return;
	}
	if(this.content.value==""){
		alert("내용을 입력하세요.");
		this.content.focus();
		return;
	} 
	
	this.action="normalWOK.board";
	this.method="post";
	this.submit();
	
});

	
$("form[name=modifyBoardForm]").submit(function() {
	event.preventDefault();
	if (this.title.value == "") {
		alert("제목을 입력하세요.");
		this.title.focus();
		return;
	}
	if (this.content.value == "") {
		alert("내용을 입력하세요.");
		this.content.focus();
		return;
	} 
	this.action = "modify_ok_board.board";
	this.method = "post";
	this.submit();
});

});
