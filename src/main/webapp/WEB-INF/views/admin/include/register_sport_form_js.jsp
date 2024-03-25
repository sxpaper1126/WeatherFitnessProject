<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function registerSportForm() {
		console.log('registerBookForm() CALLED!!');
		
		let form = document.register_sport_form;
		
		if (form.sport_name.value == '') {
			alert('INPUT Sport Name.');
			form.sport_name.focus();
			
		} else if (form.temperature.value == '') {
			alert('INPUT Temperature.');
			form.temperature.focus();
			
		} else if (form.rainfall.value == '') {
			alert('INPUT Rainfall.');
			form.rainfall.focus();
			
		} else if (form.sport_info.value == '') {
			alert('INPUT Sport Infomation.');
			form.sport_info.focus();
			
		}  else {
			form.submit();
			
		}
		
	}

</script>