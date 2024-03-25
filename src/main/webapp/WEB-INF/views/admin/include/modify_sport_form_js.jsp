<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function modifySportForm() {
		console.log('modifySportForm() CALLED!!');
		
		let form = document.modify_sport_form;
		
		if (form.sport_name.value == '') {
			alert('Input Sport NAME.');
			form.sport_name.focus();
			
		} else if (form.temperature.value == '') {
			alert('Input Temperature.');
			form.temperature.focus();
			
		} else if (form.rainfall.value == '') {
			alert('Input Rain Information.');
			form.rainfall.focus();
			
		} else if (form.sport_info.value == '') {
			alert('INPUT Sport Information.');
			form.sport_info.focus();
		} else {
			form.submit();
			
		}
		
	}

</script>