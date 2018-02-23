$("#checkAll").click(function() {
	if($(this).prop("checked")) {
		$(".chk").prop("checked",true);
	} else {
		$(".chk").prop("checked",false);
	}
})
$("#deletePro").click(function() {
	var chk_ProCD = "";
	$(".chk:checked").each(function() {
		var procd = $(this).parent().parent().attr('id');
		chk_ProCD = chk_ProCD + procd + "/";
	})
	if(chk_ProCD == '') {
		alert('삭제할 대상을 선택하세요');
		return false;
	}
	location.href="prodelete.seller?dinfo="+chk_ProCD;
})