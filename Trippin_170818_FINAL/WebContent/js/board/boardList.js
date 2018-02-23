$(document).ready(function(){

	$("form[name=noticeBoardSearchForm]").submit(function(){
		event.preventDefault();
		if($("input[name=nBSText]").val()==null || $("input[name=nBSText]").val()==""){
			alert("검색어를 입력해주세요.");
			this.nBSText.focus();
			return;
		}
		this.action="begin.board";
		this.method="post";
		this.submit();
	});
	
	$("form[name=freeBoardSearchForm]").submit(function(){
 		event.preventDefault();
 		if($("input[name=fBSText]").val()==null || $("input[name=fBSText]").val()==""){
 			alert("검색어를 입력해주세요.");
 			this.fBSText.focus();
 			return;
 		}
		this.action="freeList.board";
		this.method="post";
		this.submit();
 	});
});
