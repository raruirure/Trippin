$("form[name=tripProductMakingForm]").submit(
		function() {
			event.preventDefault();
			console.log("제출");
			// 유효성검사
			var regNum = /^[0-9]*$/;
			var regExp = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

			if (this.pro_name.value == "") {
				alert("상품명은 필수 입력사항입니다.");
				this.pro_name.focus();
				return;
			}
			if (this.pro_price.value == "") {
				alert("상품가격은 필수 입력사항입니다.\n ex)1500000");
				this.pro_price.focus();
				return;
			}
			if (!regNum.test(this.pro_price.value)) {
				alert('상품가격은 숫자만 입력가능합니다.');
				this.pro_price.focus();
				return;
			}
			if (this.pro_total_date.value == "") {
				alert("여행기간은 필수 입력사항입니다.\n ex)20");
				this.pro_total_date.focus();
				return;
			}
			if (!regNum.test(this.pro_total_date.value)) {
				alert('여행기간은 숫자만 입력가능합니다.');
				this.pro_total_date.focus();
				return;
			}
			if (this.pro_sdate_1.value == "") {
				alert("여행시작날짜는  필수 입력사항입니다.\n ex)20170813");
				this.pro_sdate_1.focus();
				return;
			}
			if (!regNum.test(this.pro_sdate_1.value)
					|| this.pro_sdate_1.value.length != 8) {
				alert('여행시작날짜는 숫자 8자리로만 입력가능합니다.\n ex)20170813');
				this.pro_sdate_1.focus();
				return;
			}
			if (this.pro_sdate_1.value.length == 8) {
				var isOk = isValidDate(this.pro_sdate_1.value);
				if (!isOk) {
					alert("잘못된 날짜 입력, 입력날짜를 확인해주세요");
					this.pro_sdate_1.focus();
					return;
				}
			}
			if (this.pro_cnt_1.value == "") {
				alert("인원수는  필수 입력사항입니다.\n ex)20");
				this.pro_cnt_1.focus();
				return;
			}
			if (!regNum.test(this.pro_cnt_1.value) || this.pro_cnt_1.value < 1 ) {
				alert('인원수는 1이상의 숫자만 입력가능합니다.\n ex)20');
				this.pro_cnt_1.focus();
				return;
			}
			if ($("pro_content").val() == "") {
				alert("상품 상세 정보는  필수 입력사항입니다.");
				this.pro_context.focus();
				return;
			}
			// 판매자정보
			if (this.seller_business_name.value == "") {
				alert("상호명은  필수 입력사항입니다.");
				this.seller_business_name.focus();
				return;
			}
			if (this.seller_agent.value == "") {
				alert("대표자는  필수 입력사항입니다.");
				this.seller_agent.focus();
				return;
			}
			if (this.seller_phonenum.value == ""){
				alert("전화번호는  필수 입력사항입니다.");
				this.seller_phonenum.focus();
				return;
			}
			if( !regExp.test(this.seller_phonenum.value) ) {
			    alert("잘못된 전화번호 입니다.");
			    this.seller_phonenum.focus();
				return;
			}
			// 주소
			if (this.seller_address_post.value == "") {
				alert("우편번호는  필수 입력사항입니다.");
				this.seller_address_post.focus();
				return;
			}
			if (this.seller_address.value == "") {
				alert("주소는  필수 입력사항입니다.");
				this.seller_address.focus();
				return;
			}
			if (this.seller_address_detail.value == "") {
				alert("상세주소는 필수 입력사항입니다.");
				this.seller_address_detail.focus();
				return;
			}

			// 유효성검사 끝

			this.action = "productRegist.seller";
			this.method = "post";
			this.submit();
		});

$(".reBtn").click(function() {
	history.back();
})

// 날짜 유효성 검사
function isValidDate(dateStr) {
	var year = dateStr.substr(0, 4);
	var month = dateStr.substr(4, 2);
	var day = dateStr.substr(6, 2);
	var today = new Date();
	var yearNow = today.getFullYear();
	var monthNow = today.getMonth()+1;
	var dayNow = today.getDate();
	
	if(monthNow<10) {
		monthNow = String(0) + String(monthNow);
	}
	var strToday = String(yearNow)+String(monthNow)+String(dayNow);
	
	if(strToday > dateStr){ 
		return false; 
	}
	
	if (year < 1900 || year < yearNow) {
		return false;
	}
	if (month < 1 || month > 12) {
		return false;
	}
	if (day < 1 || day > 31) {
		return false;
	}
	if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
		return false;
	}
	if (month == 2) {
		var leapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if (day > 29 || day == 29 && !leapYear) {
			return false;
		}
	}
	return true;
}
$("#pro_img").on("change", handleImgFileSelect);

function handleImgFileSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f) {
		if(!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}
		
		sel_file = f;
		
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#upImgSrc").attr("src", e.target.result);
		}
		reader.readAsDataURL(f);
	});
}

