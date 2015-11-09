<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인</title>
<link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<form class="form-login" method="post" action="/jblog/user/login">
		<label>아이디</label> <input type="text" name="userId"> <label>비밀번호</label>
		<input type="password" name="password">
		<c:if test="${param.result=='error' }">
			<p>로그인이 실패 했습니다.</p>
		</c:if>
		<input type=submit value=확인> <input type="reset" value="취소">
	</form>
</body>
</html>