<%@page import="com.company.sport.admin.member.AdminMemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="<c:url value='/resources/css/admin/include/nav.css' />"
	rel="stylesheet" type="text/css">

<jsp:include page="./nav_js.jsp" />

<nav>

	<div id="nav_wrap">

		<%
		AdminMemberVo loginedAdminMemberVo = (AdminMemberVo) session.getAttribute("loginedAdminMemberVo");
		if (loginedAdminMemberVo != null) {
		%>

		<div class="menu">
			<ul>
				<li><a href="<c:url value='/admin/member/logoutConfirm' />">로그아웃</a></li>
				<li><a href="<c:url value='/admin/member/modifyAccountForm' />">계정수정</a></li>

				<c:if test="${loginedAdminMemberVo.a_m_id eq 'super admin'}">

					<li><a href="<c:url value='/admin/member/listupAdmin' />">관리자목록</a></li>
				</c:if>
				<li><a href="<c:url value='/info/admin/registerSportForm' />">등록</a></li>
				<li><a href="<c:url value='/admin/member/getPlaceWeather' />">Home</a></li>


			</ul>
		</div>
		<%
		} else {
		%>
		<div class="menu">
			<ul>
				<li><a href="<c:url value='/admin/member/loginForm' />">로그인</a></li>
				<li><a href="<c:url value='/admin/member/createAccountForm' />">회원가입</a></li>
			</ul>
		</div>
		<%
		}
		%>
		<br> <br> <br> <br>
		<div class="search">

			<form action="<c:url value='/info/admin/searchSportConfirm' />"
				name="search_sport_form" method="get">
				<input type="text" name="sport_name"
					placeholder="Enter the name of Sport ."> <input
					type="button" value="search" onclick="searchSportForm();">
			</form>

		</div>
	</div>
	<br> <br>
</nav>