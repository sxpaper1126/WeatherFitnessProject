<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장소별 날씨 정보</title>
<link
	href="${pageContext.request.contextPath}/resources/css/admin/weather.css"
	rel="stylesheet" type="text/css">
</head>
<script>
	var colors = [ '#FF9898', '#FFAAFF', '#C2FFFB', '#737373', '#FF9898',
			'#8D8EFF', '#FFB347', '#5C69FF', '#FFAA6C' ];
	
	var places = [ "SSG 랜더스필드", "고척스카이돔", "잠실야구장", "수원kt위즈파크", "광주기아챔피언스필드",
			"창원nc파크", "사직야구장", "대구삼성라이온즈파크", "한화생명이글스파크" ];
	
	var avgTemp = (${Location1_Temperature}+${Location2_Temperature}+${Location3_Temperature}+${Location4_Temperature}+${Location5_Temperature}+
	${Location6_Temperature}+${Location7_Temperature}+${Location8_Temperature}+${Location9_Temperature})/9;
	avgTemp = avgTemp.toFixed(2);
	window.onload = function () {
        document.getElementById('avgTemp').innerHTML += ' 평균 기온: ' + avgTemp + '°C';
    };
    
	function showPointCount(pointNumber) {
		var countBox = document.getElementById('countBox');
		var point = document.getElementById('point' + pointNumber);

		var color = colors[pointNumber - 1];
		var place = places[pointNumber - 1];
		
		countBox.style.backgroundColor = color;
		countBox.innerHTML = '<p>' + place + '입니다</p></br></br>';
		if (pointNumber === 1) {
			countBox.innerHTML += '<p>기온: ${Location1_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location1_PrecipitationType}	(0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location1_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location1_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location1_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 2) {
			countBox.innerHTML += '<p>기온: ${Location2_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location2_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location2_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location2_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location2_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 3) {
			countBox.innerHTML += '<p>기온: ${Location3_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location3_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location3_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location3_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location3_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 4) {
			countBox.innerHTML += '<p>기온: ${Location4_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location4_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location4_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location4_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location4_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 5) {
			countBox.innerHTML += '<p>기온: ${Location5_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location5_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location5_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location5_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location5_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 6) {
			countBox.innerHTML += '<p>기온: ${Location6_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location6_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location6_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location6_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location6_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 7) {
			countBox.innerHTML += '<p>기온: ${Location7_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location7_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location7_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location7_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location7_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 8) {
			countBox.innerHTML += '<p>기온: ${Location8_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location8_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location8_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location8_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location8_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else if (pointNumber === 9) {
			countBox.innerHTML += '<p>기온: ${Location9_Temperature}°C</p>';
			countBox.innerHTML += '<p>강수형태: ${Location9_PrecipitationType}	 (0: 없음, 1: 비, 2: 비/눈, 3: 눈)</p>';
			countBox.innerHTML += '<p>1시간 강우량: ${Location9_Rainfall1h}mm</p>';
			countBox.innerHTML += '<p>풍향: ${Location9_WindDirection}</p>';
			countBox.innerHTML += '<p>풍속: ${Location9_WindSpeed}m/s</p>';
			countBox.innerHTML += '<p style="text-align:right; float:right;">${date}</p>';
		} else {
			countBox.innerHTML += "오류";
		}
		
	} 
</script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	let moveToTop = function() {
		document.body.scrollIntoView({behavior: "smooth"});
	};
</script>
<script>
function redirectToSportInfo() {
    var redirectURL = "${pageContext.request.contextPath}/info/admin/showSport";
    window.location.href = redirectURL;
}
</script>
<script>
$(document).ready(function () {
	$('.btn').hover(function() {
		$(this).addClass('reverse');
	}, function () {
		$(this).removeClass('reverse');
	});
});
</script>
<body>
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../include/nav.jsp" />
	<div class="mainContents">


		<nav class="nav">
			<details id="list">
				<summary>Contents List</summary>
				<p class="btn">
					<a href='#place'>장소</a>
				</p>
				<p class="btn">
					<a href='#recSport'>스포츠 추천</a>
				</p>
				<p class="btn">
					<a href='#' onclick="redirectToSportInfo()">운동 정보 및 팁</a>
				</p>
			</details>
		</nav>

		<section class="section">
			<article id="place">
				<div id="imgContainer" style="text-align: center">
					<img
						src="${pageContext.request.contextPath}/resources/img/KoreaMap.png"
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
						style="position: absolute; top: 10%; left: 65%; width: 300px; height: 350px;">
						빨간색 포인터를 누르면 정보가 보입니다.
					</div>
				</div>
			</article>

			<article id="forecast">

				<table id="forWeather">
					<tr>

						<td id="avgTemp" style="text-align: center">전국 구장별</td>
					</tr>
					<tr>
						<td colspan="7" style="text-align: left; padding-left: 160px;">${Location1_baseDate[0]}기준
							6시간의 날씨 예측</td>
					</tr>
					<tr id="fWeather" style="background-color: #99D9EA;">
						<td>시간(정시)</td>
						<td>${Location1_fcstTime[0]}</td>
						<td>${Location1_fcstTime[1]}</td>
						<td>${Location1_fcstTime[2]}</td>
						<td>${Location1_fcstTime[3]}</td>
						<td>${Location1_fcstTime[4]}</td>
						<td>${Location1_fcstTime[5]}</td>

					</tr>
					<tr>
						<td>예측 강우량(mm)</td>
						<td>${Location1_fcstValue[0]}</td>
						<td>${Location1_fcstValue[1]}</td>
						<td>${Location1_fcstValue[2]}</td>
						<td>${Location1_fcstValue[3]}</td>
						<td>${Location1_fcstValue[4]}</td>
						<td>${Location1_fcstValue[5]}</td>
					</tr>
					<tr>
						<td>날씨</td>
						<td id="img1"><img src="" style="height: 50px; width: 50px;"></td>
						<td id="img2"><img src="" style="height: 50px; width: 50px;"></td>
						<td id="img3"><img src="" style="height: 50px; width: 50px;"></td>
						<td id="img4"><img src="" style="height: 50px; width: 50px;"></td>
						<td id="img5"><img src="" style="height: 50px; width: 50px;"></td>
						<td id="img6"><img src="" style="height: 50px; width: 50px;"></td>
					</tr>

				</table>
			</article>
			<script>
        var fcstValues = [
            ${Location1_fcstValue[0]},
            ${Location1_fcstValue[1]},
            ${Location1_fcstValue[2]},
            ${Location1_fcstValue[3]},
            ${Location1_fcstValue[4]},
            ${Location1_fcstValue[5]}
        ];

        function changeImage(index, newValue) {
            var imgId = "img" + (index + 1);
            var imgElement = document.getElementById(imgId);

            var imagePath = newValue == 0
                ? "${pageContext.request.contextPath}/resources/img/sunny.jpg"
                : "${pageContext.request.contextPath}/resources/img/rain.jpg";
            
            imgElement.querySelector('img').src = imagePath;
        }

        
        for (var i = 0; i < fcstValues.length; i++) {
            changeImage(i, fcstValues[i]);
        }
    </script>

			<article id="recSport">
			<div style="clear: both;">
				<br><br><br>
			</div>
				<div class="nowInfo">
					<div  id="" style="text-align: center;">
						전국 날씨 평균<br> <br> 현재 기온 : ${location_Temperature}°C<br>
						현재 강수량 : ${location_Rainfall1h}mm<br> 현재 풍속 :
						${location_WindSpeed}m/s<br>
					</div>
					<div>
						<table>
							<c:forEach var="sport" items="${recommendedSports}">
								<tr>
									<td class="rec">추천 : ${sport}</td>
								</tr>
							</c:forEach>
						</table>
					</div>

				</div>
			</article>
			<article id="#"></article>
		</section>
	</div>
	<aside class="aside">
		<button>
			<img src="${pageContext.request.contextPath}/resources/img/top.png"
				width="30px" height="30px" onclick="moveToTop()">
		</button>
	</aside>
	<div class="footer">
		<jsp:include page="../../include/footer.jsp" />
	</div>

</body>
</html>