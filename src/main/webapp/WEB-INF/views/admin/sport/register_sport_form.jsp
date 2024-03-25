 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/register_sport_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/register_sport_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>운동 정보 및 꿀팁 작성</h3>
				
			</div>
		
			<div class="register_sport_form">
			
				<form action="<c:url value='/info/admin/registerSportConfirm' />" name="register_sport_form" method="post" enctype="multipart/form-data">
					
					<input type="text" name="sport_name" placeholder="INPUT Sport Name."> <br>
					<input type="text" name="temperature" placeholder="INPUT Temperature."> <br>
					<input type="text" name="rainfall" placeholder="INPUT Rainfall Information."> <br>
					<input type="text" name="sport_info" placeholder="INPUT Sport Information."> <br>
					<input type="file" name="file"><br>
					<input type="button" value="register sport" onclick="registerSportForm();"> 
					<input type="reset"	value="reset">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	<div class="footer">
	<jsp:include page="../../include/footer.jsp" />
	</div>
	
	
</body>
</html>