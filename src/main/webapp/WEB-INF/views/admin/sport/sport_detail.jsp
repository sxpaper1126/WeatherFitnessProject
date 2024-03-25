<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../../include/title.jsp" />

<link href="<c:url value='/resources/css/admin/sport_detail.css' />"
	rel="stylesheet" type="text/css">

<jsp:include page="../include/sport_detail_js.jsp" />

</head>
<body>

	<jsp:include page="../../include/header.jsp" />

	<jsp:include page="../include/nav.jsp" />

	<section>

		<div id="section_wrap">

			<div class="word">

				<h3>${infoVo.sport_name}의 Detail정보</h3>

			</div>

			<div class="sport_detail">
				<table>
					<thead>
						<tr>
							<td colspan="2"><img
								src="<c:url value="/libraryUploadImg/${infoVo.thumbnail}"/>"></td>
						</tr>
					</thead>
					<tr>
						<td>스포츠</td>
						<td>${infoVo.sport_name}</td>
					</tr>
					<tr>
						<td>기온</td>
						<td>${infoVo.temperature}</td>
					</tr>
					<tr>
						<td>비</td>
						<td>${infoVo.rainfall}</td>
					</tr>
					<tr>
						<td>정보</td>
						<td>${infoVo.sport_info}</td>
					</tr>
					<tr>
						<td>등록일</td>
						<td>${infoVo.reg_date}</td>
					</tr>
					<tr>
						<td>수정일</td>
						<td>${infoVo.mod_date}</td>
					</tr>
				</table>
				</li>
				</ul>

			</div>

			<div class="buttons">

				<c:url value='/info/admin/modifySportForm' var='modify_url'>
					<c:param name='sport_name' value='${infoVo.sport_name}' />
				</c:url>
				<a class="modify_sport_button" href="${modify_url}">정보 수정</a>

				<c:url value='/info/admin/deleteSportForm' var='delete_url'>
					<c:param name='sport_name' value='${infoVo.sport_name}' />
				</c:url>

				<a class="delete_sport_button" href="#none"
					onclick="deleteSport('${infoVo.sport_name}')">정보 삭제</a>

			</div>

		</div>

	</section>
	<br><br>
	<div class="footer">
		<jsp:include page="../../include/footer.jsp" />
	</div>

</body>
</html>