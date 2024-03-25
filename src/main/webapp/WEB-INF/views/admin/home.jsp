<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<jsp:include page="../include/title.jsp" />
<link href="<c:url value='/resources/css/admin/home.css' />"
	rel="stylesheet" type="text/css">
<script>
	var colors = [ '#FF9898', '#FFAAFF', '#C2FFFB', '#737373', '#FF9898',
			'#8D8EFF', '#FFB347', '#5C69FF', '#FFAA6C' ];
	var places =["SSG 랜더스필드","고척스카이돔","잠실야구장", "수원kt위즈파크","광주기아챔피언스필드","창원nc파크","사직야구장","대구삼성라이온즈파크","한화생명이글스파크"];
	function showPointCount(pointNumber) {
		var countBox = document.getElementById('countBox');
		var point = document.getElementById('point' + pointNumber);

		var color = colors[pointNumber - 1];
		var place = places[pointNumber - 1];

		countBox.style.backgroundColor = color;
		countBox.innerHTML = place + '입니다' + "<br><p>자세한 정보를 알고싶으시면 로그인을 해주세요.</p>";
	}
</script>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<jsp:include page="./include/nav.jsp" />
		<div id="imgContainer" style="text-align: center">
		<img src="<c:url value='/resources/img/KoreaMap.png' />"
			alt="KoreaMap" id="mapImg" style="width: auto; height: auto;">
		<div id="point1" class="point" style="top: 20%; left: 47%;"
			onclick="showPointCount(1)"></div>
		<div id="point2" class="point" style="top: 20%; left: 48%;"
			onclick="showPointCount(2)"></div>
		<div id="point3" class="point" style="top: 20%; left: 49%;"
			onclick="showPointCount(3)"></div>
		<div id="point4" class="point" style="top: 25%; left: 48.5%;"
			onclick="showPointCount(4)"></div>
		<div id="point5" class="point" style="top: 60%; left: 48%;"
			onclick="showPointCount(5)"></div>
		<div id="point6" class="point" style="top: 60%; left: 53%;"
			onclick="showPointCount(6)"></div>
		<div id="point7" class="point" style="top: 60%; left: 55%;"
			onclick="showPointCount(7)"></div>
		<div id="point8" class="point" style="top: 50%; left: 54%;"
			onclick="showPointCount(8)"></div>
		<div id="point9" class="point" style="top: 40%; left: 50%;"
			onclick="showPointCount(9)"></div>
		<div id="countBox"
			style="position: absolute; top: 20%; left: 65%; width: 300px; height: auto;"></div>
	</div>
	


	<div class="footer">
		<jsp:include page="../include/footer.jsp" />
	</div>
</body>
</html>

