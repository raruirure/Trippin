	var sw=0;
	function check_all() {
		if(sw==0){
			for(i=0; i < my_form.mycheck.length; i++) {
				my_form.mycheck[i].checked = true;
			}
			sw=1;
		}else if(sw==1){
			for(i=0; i < my_form.mycheck.length; i++) {
				my_form.mycheck[i].checked = false;
			}
			sw=0;
		}
	}
	

	
	
