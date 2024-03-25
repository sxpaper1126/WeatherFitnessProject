<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

	function deleteSport(sport_name) {
		console.log('deleteSport() CALLED!!');
		
		let result = confirm('(' + sport_name + ')를(을) 정말 삭제 하시겠습니까?');
		
		if (result)
			location.href = "<c:url value='/info/admin/deleteSportConfirm?sport_name='/>" + sport_name;

	}

</script>