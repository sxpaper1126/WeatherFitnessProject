<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	let moveToTop = function() {
		document.body.scrollIntoView({behavior: "smooth"});
	};
</script>
<link href="<c:url value='/resources/css/admin/show_sport.css' />" rel="stylesheet" type="text/css">

</head>
<body>

	<jsp:include page="../../include/header.jsp" />
	
	<jsp:include page="../include/nav.jsp" />
	<div class="mainContents">
	
	<section class="section">
		
		<div id="section_wrap">
		
			<div class="word">
			
				<h3>운동 정보 및 팁</h3>
				
			</div>
			
			<div class="sport_list">
			
				<table>
					<thead>
						<tr>
							<th>스포츠</th>
							<th>기온</th>
							<th>비</th>
							<th>정보</th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach var="item" items="${infoVos}">
							<tr>
								<td>
								<c:url value='/info/admin/sportDetail' var='detail_url'>
									<c:param name='sport_name' value='${item.sport_name}'/>
								</c:url>
								<a href="${detail_url}">${item.sport_name}</a>
								</td>
								<td>${item.temperature}</td>
								<td>${item.rainfall}</td>
								<td>${item.sport_info}</td>
		
							</tr>
						</c:forEach>
						
					</tbody>
					
				</table>
				
			</div>
		
		</div>
		
	</section>
	<aside class="aside">
		<button>
			<img src="${pageContext.request.contextPath}/resources/img/top.png"
				width="30px" height="30px" onclick="moveToTop()">
		</button>
	</aside>
	</div>
	<div class="footer">
	<jsp:include page="../../include/footer.jsp" />
	</div>

</body>
</html>