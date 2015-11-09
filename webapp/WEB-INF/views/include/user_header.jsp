<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="menu">
	<li><a href="/jblog/user/list">회원목록</a></li>
	<li><a href="/jblog/user/registerform">회원등록</a></li>
	<c:if test="${not empty authUser }">
		<li><a href="/jblog/user/logout">로그아웃</a></li>
	</c:if>
</ul>
