<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/login_result.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/login_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>로그인 성공</h3>
				
			</div>
			
			<div class="others">
				
				<a href="<c:url value='/admin/member/logoutConfirm' />">logout</a>
				<a href="<c:url value='/admin/member/modifyAccountForm' />">modify account</a>
				
			</div>
		
		</div>
		
	</section>
	
	<div class="footer">
		<jsp:include page="../../include/footer.jsp" />
	</div>
	
</body>
</html>