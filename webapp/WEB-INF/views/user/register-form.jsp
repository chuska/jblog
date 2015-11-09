<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원등록</title>
<Link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<ul class="menu">
		<li><a href="">회원목록</a></li>
		<li>회원등록</li>
		<li><a href="">로그아웃</a></li>
	</ul>
	<form class="form-r-user" method="post" action="/jblog/user/register">
		<label>아이디</label>
		<input type="text" name="userId">
		<label>비밀번호</label>
		<input type="text" name="password">
		<label>이름</label>
		<input type="text" name="userName">
		<input type="submit" value="등록">
	</form>
</body>
</html>