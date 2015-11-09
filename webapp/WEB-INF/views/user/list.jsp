<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원목록</title>
<link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
	<div class="user-list">
		<c:set var='count' value='${fn:length(list) }'></c:set>
		<h2>블로그 사용자 수 : ${count }명</h2>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach items='${list}' var="vo" varStatus="status">
				<tr>
					<td>${ vo.userId}</td>
					<td>${vo.userName}</td>
					<td>${ vo.createdDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>