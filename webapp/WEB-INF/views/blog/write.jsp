<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog - J2EE 이야기</title>
<Link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body class="jblog">
	<div class="continer">
		<c:import url="/WEB-INF/views/include/blog_header.jsp"></c:import>
	    <table class="content">
	      <tr><td height="10" colspan="10">&nbsp;</td></tr>
	      <tr>
	      	<td height="10" width="20">&nbsp;</td>
	      	<td width="530" valign="top" class="tdcontent">
		      	<!-- 메뉴 시작 -->     
		      	<a class="title" href="/jblog/blog/basic?blogNo=${blogNo }">기본설정</a>
		      	&nbsp;&nbsp; 
	    	  	<a class="title" href="/jblog/blog/category?blogNo=${blogNo }">카테고리</a>
	    	  	&nbsp;&nbsp;
	      		<strong>글작성</strong>
	      		&nbsp;&nbsp;
	      		<!-- 메뉴 끝 -->           	
	      	</td>
	      </tr>
	      <tr><td height="5">&nbsp;</td></tr>
	      <tr>
	      	<td height="10">&nbsp;</td>
	      	<td>
	      	<!-- 작업 화면  시작 -->     
	      	<form action="/jblog/blog/writer-insert" method="post">      
	      	<table>
	      		<tr>
	      			<td width="50" class="inputlabel">제목 :</td>
	      			<td width="390">
	      				<input class="inputtext" type="text" size="60" name="title">
	      				<input type="hidden" id="blogNo" name="blogNo" value="${blogNo }"/>
	      			</td>
	      			<td width="300">
		      			<select class="inputtextarea" name="categoryNo">
		      				<c:forEach items="${categoryList}" var="cateList" varStatus="status">
		      				<option value="${cateList.categoryNo}">${cateList.categoryName}</option>
		      				</c:forEach>
		      			</select>
	      			</td>
	      		</tr>
	      		<tr>
	      			<td width="50" class="inputlabel">내용 :</td>
	      			<td colspan="10"><textarea name="content" class="inputtextarea" rows="10" cols="100"></textarea></td>
	      		</tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr>
	      			<td colspan="10" align="center">&nbsp;<input type="submit" value="확인"></td>
	      		</tr>
	      	</table>
	      	</form>
	      	<!-- 작업 화면  끝 -->      
	      	</td>
	      </tr>
	      <tr>
	      	<td height="10">&nbsp;</td>
	      </tr>
	    </table>
	    <div class="blogfooter">
      		J2EE 이야기 is powered by JBlog
		</div>
	</div>   	
</body>
</html>