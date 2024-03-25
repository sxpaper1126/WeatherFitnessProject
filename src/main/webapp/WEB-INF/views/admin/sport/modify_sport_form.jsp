<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/modify_sport_form.css' />" rel="stylesheet" type="text/css">

<jsp:include page="../include/modify_sport_form_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	
	<section>
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>수정 형식</h3>
				
			</div>
		
			<div class="modify_sport_form">
			
				<form action="<c:url value='/info/admin/modifySportConfirm' />" name="modify_sport_form" method="post" enctype="multipart/form-data">
					
					
					
					<input type="text" name="sport_name" value="${infoVo.sport_name}" placeholder="Input Sport NAME."> <br>
					<input type="text" name="temperature" value="${infoVo.temperature}" placeholder="Input Temperature Information."> <br>
					<input type="text" name="rainfall" value="${infoVo.rainfall}" placeholder="Input Rain Information."> <br>
					<input type="text" name="sport_info" value="${infoVo.sport_info}" placeholder="INPUT Sport Information."> <br>
					
					
					<input type="file" name="file"><br>
					<input type="button" value="modify sport" onclick="modifySportForm();"> 
					<input type="reset" value="reset">
					
				</form>
				
			</div>
		
		</div>
		
	</section>
	<div class="footer">
	<jsp:include page="../../include/footer.jsp" />
	</div>
	
	
</body>
</html>