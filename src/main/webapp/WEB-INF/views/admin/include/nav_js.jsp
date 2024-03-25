<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function searchSportForm() {
		console.log('searchSportForm() CALLED!!');
		
		let form = search_sport_form;
		
		if (form.sport_name.value == '') {
			alert('Enter the name of sport');
			form.sport_name.focus();
			
		} else {
			form.submit();
			
		}
		
	}

</script>