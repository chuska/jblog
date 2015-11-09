<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<form action="#" >		
    <table class="main-tbl">
      <tr>
      	<td height="30">
      	<c:choose>
   		<c:when test='${empty authUser }'>
     		<a href="/jblog/user/loginform"><strong>로그인</strong></a>
     		&nbsp;&nbsp;
     	</c:when>	
     	<c:otherwise>
       		<a href="/jblog/user"><strong>로그아웃</strong></a>
     		&nbsp;&nbsp;
      		<a href="/jblog/blog/main"><strong>내 블로그 가기</strong></a>
     		&nbsp;&nbsp;
     	<c:when test = '${authUser.role == admin}'> 
    		<a href="/jblog/user/list"><strong>관리자</strong></a>
			&nbsp;&nbsp;
		</c:when>
		</c:otherwise>
		</c:choose>
      	</td>
      </tr>      
      <tr>
      	<td height="20">
      		<input type="text" name="searchKeyword" size="50">
      		<input type="submit" value="검색">
      	</td>
      </tr>
      <tr>
      	<td height="20" class="tdcontent">
      		<input type="radio" name="searchCondition" checked>블로그 제목
      		&nbsp;&nbsp;
      		<input type="radio" name="searchCondition">태그
      		&nbsp;&nbsp;
      		<input type="radio" name="searchCondition">블로거
		</td>
      </tr>
    </table>
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
					<td>${ vo.userName}</td>
					<td>${ vo.createdDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
   	</form>
</body>
</html>