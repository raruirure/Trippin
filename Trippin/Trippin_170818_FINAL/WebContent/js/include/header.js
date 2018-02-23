$(document).ready(function() {
	$(".close i").each(function(idx,item){
		$(item).click(function() {
			if(idx==0) {
				$("#login_form").css("display","none");
				$("input[name=uname]").val("");
				$("input[name=psw]").val("");				
			} else {
				$("#join_form").css("display","none");
				$("input[name=userid]").val("");
				$("input[name=pwd]").val("");
				$("input[name=confirmPwd]").val("");
			}
		});
	});

	$('form[name="member_login"]').submit(function() {
		event.preventDefault();
		if(this.userId.value=="") {
			alert("아이디를 입력해주세요!");
			this.userId.focus();
			return;
		}
		if(this.userPwd.value=="") {
			alert("비밀번호를 입력해주세요!");
			this.userPwd.focus();
			return;
		}

		this.action = "login.member";
		this.method = "post";
		this.submit();
	});
	$(".memberProfile").click(function(){
		$(".mainProfile_drop").toggle();
	});
	
	$("#headerDrop_logout").click(function(){
		location.assign("logout.member");
	});
	
	// join change
	$('input[name=seller_btn]').click(function() {
		$("form").each(function() {  
            this.reset();  
         }); 
		$(this).css({
			"background-color":"#333B58",
			"color": "#F6F7F7"
		});
		$('input[name=general_user_btn]').css('background-color','#cccccc');
		$('.seller_level').css("display","block");
		$('input[name="user_level"]').val("2"); // hidden tag
	});
	$('input[name=general_user_btn]').click(function() {
		$("form").each(function() {  
            this.reset();  
         });
		$(this).css({
			"background-color":"#333B58",
			"color": "#F6F7F7"
		});
		$('input[name=seller_btn]').css('background-color','#cccccc');
		$('.seller_level').css("display","none");
		$('.seller_level').val("0");
		$('input[name="user_level"]').val("1"); // hidden tag 
	});
	
	
	/*join validity check*/
	$("input[name=join_userPwdConfirm]").keyup(function() {
		if($("input[name=join_userPwd]").val() != $(this).val()) {
			$("#notEqualPwd").css("display","block");
		} else {
			$("#notEqualPwd").css("display","none");
		}
	});
	
	// email validate
	var reg_email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
	var reg_sellerNum = /[(0-9)]{10}/; // 사업자 번호 숫자
	$('form[name=generalJoin]').submit(function() {
		event.preventDefault();
	
		if(this.join_userId.value=="") {
			alert("아이디를 입력해주세요");
			this.join_userId.focus();
			return;
		} else if(!reg_email.test(this.join_userId.value)) {
			alert("아이디 입력오류! 유효한 이메일을 입력해주세요");
			this.join_userId.focus();
			return;
		} else if(this.join_userName.value=="") {
			alert("비밀번호를 입력해주세요");
			this.join_userName.focus();
			return;
		}else if(this.join_userPwdConfirm.value=="") {
			alert("비밀번호확인을 입력해주세요");
			this.join_userPwdConfirm.focus();
			return;
		} else if(this.join_userBirthday.value=="" || this.join_userBirthday.value.length!=6) {
			alert("생년월일 6자리를 입력해주세요");
			this.join_userBirthday.focus();
			return;
		} else if(this.join_userBirthday.value.length==6) {
			var isOk = isValidDate(this.join_userBirthday.value);
			if(!isOk) {
				alert("잘못된 생년월일 입력, 생년월일을 확인해주세요");
				this.join_userBirthday.focus();
				return;
			}
		} 
		if(this.user_level.value==2) {
			// 2이면 판매자 회원가입
			if( !reg_sellerNum.test(this.join_sellerNumber.value) ) {
				alert("사업자 번호 -을 제외한 숫자 10자리를 입력해주세요!");
				this.join_sellerNumber.focus();
				return;
			} else{
				var checkSeller = isValidSellerNum(this.join_sellerNumber.value);
				if( !checkSeller ) {
					alert("사업자 등록번호가 아닙니다");
					this.join_sellerNumber.focus();
					return;
				}
			}
		} // 유효성 체크 끝
		
		// submit
		this.action = "join.member";
		this.method = "post";
		this.submit();
	});
})

/* 사업자 번호 유효성 체크 */
function isValidSellerNum(sellerNo) {
	var sum=0;
	var checkKey = [1,3,7,1,3,7,1,3,5];
	for(var i=0; i<9; i++) {
		sum += checkKey[i] * sellerNo.charAt(i);
	}
	var key = Math.floor((checkKey[8] * sellerNo.charAt(8))/10);
	sum = 10 - (sum+key)%10;
	if(sum == sellerNo.charAt(9)) return true;
	else return false;
}

/* 생일 유효성 체크 */
function isValidDate(dateStr) {
	var sYear = dateStr.substr(0,1);
	var eYear = dateStr.substr(1,1);
	
	var month = Number(dateStr.substr(2,2));
	var day = Number(dateStr.substr(4,2));
	var today = new Date();
	var yearNow = today.getFullYear();
	var monthNow = today.getMonth()+1;
	var dayNow = today.getDate();
	
	
	
	console.log(today);
	if(today < dateStr) {
		return false;
	}

	var year = "";
	if(sYear==0) {
		year = Number(20+sYear+eYear);
	} else {
		year = Number(19+sYear+eYear);
	}

	if(year<1900 || year>yearNow) {
		return false;
	} 
	if(month<1 || month>12) {
		return false;
	}
	if(day<1 || day>31) {
		return false;
	}
	if((month==4||month==6||month==9||month==11) && day==31) {
		return false;
	}
	if(month==2) {
		var leapYear = year%4==0 && year%100!=0 || year%400==0;
		if(day>29 || day==29&& !leapYear) {
			return false;
		}
	}
	return true;
}
