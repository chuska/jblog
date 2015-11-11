<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog - J2EE 이야기</title>
<link rel="stylesheet" href="/jblog/assets/css/theme.css">
</head>
<body class="jblog">
	<div class="continer">
		<c:import url="/WEB-INF/views/include/blog_header.jsp"></c:import>
	    <table class="content">
			<tr><td height="10">&nbsp;</td></tr>
			<tr>
	      		<td width="20">&nbsp;</td>
	      		<td width="530" valign="top">
		      	<!-- 포스트 시작 --> 
		      	<table>
		      		<tr><td class="posttitle">${map.POST_TITLE }</td></tr>
		      		<tr><td class="postdate">${map.MODIFIDDATE}</td></tr>
		      		<tr>
		      			<td class="postcontent">
		      			${map.POST_CONTENT }
		      			</td>
		      		</tr>
		      		<tr><td height="5">&nbsp;</td></tr>
		      		<tr><td class="postwriter">posted by ${map.USER_NAME }  in ${map.TITLE }, 덧글 1</td></tr>
		      		<tr><td height="5">&nbsp;</td></tr>
		      		<tr><td height="5">
			      	<c:forEach items="${commentsList}" var="commentslist" varStatus="status">
			      		<table>
			      			<tr><td class="tdcontent">${commentslist.content }</td></tr>
			      			<tr><td class="tdcontent">commented by ${commentslist.commentUserName } at ${commentslist.createdDate }</td></tr>
			      		</table>
		      		</c:forEach>
			      		<table>
			      			<tr><td class="tdcontent">호이호이~</td></tr>
			      			<tr><td class="tdcontent">commented by 둘리 at 2015/06/06</td></tr>
			      		</table>
			      		<!-- 덧글 보여주기  끝 -->		      		
		      		</td></tr>
		      		<tr><td height="5">
			      		<!-- 새 덧글 시작 -->
			      		<table>
			      			<tr><td height="5">&nbsp;</td></tr>
			      			<tr>
			      				<td width="120"><input class="inputtext" type="text" size="15" name="name"></td>
	      						<td width="380" class="tdcontent">이름</td>      						
	      					</tr>
			      			<tr><td colspan="10" class="tdcontent">
			      			<textarea name="content" class="inputtextarea" rows="2" cols="80"></textarea></td></tr>
			      			<tr><td height="5">&nbsp;</td></tr>
			      			<tr>
	      						<td colspan="10" align="right">&nbsp;<input type="submit" value="덧글추가"></td>
	      					</tr>
			      		</table>
			      		<!-- 새 덧글 끝 -->		      		
		      		</td></tr>	      		
		      		<tr><td height="5">&nbsp;</td></tr>
		      	</table>
		      	<!-- 포스트 끝-->      	
		      	</td>
		      	<td width="20">&nbsp;</td>
		      	<td width="190" valign="top">
		      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->
		      	<table>
		      		<tr>
		      			<td>
				      		<a href="/toLogin">로그인</a>&nbsp;&nbsp;
				      		<a href="/logout">로그아웃</a>&nbsp;&nbsp;
		   					<a href="/kickscar/admin">블로그 관리</a>
			      		</td>
			      	</tr>
		      		<tr><td height="5px">&nbsp;</td></tr>
		      		<tr><td><img height="80px" src="/jblog/assets/images/j2eelogo.jpg"></td></tr>
		      		<tr><td height="5px">&nbsp;</td></tr>
		      		<tr><td class="categorytitle">카테고리</td></tr>
		      		<c:forEach items="${cateList}" var="vo" varStatus="status">
		      		<tr><td class="categoryitem"><a class="title" href="#">${vo.categoryName }</a></td></tr>
		      		</c:forEach>
		      	</table>
		      	<!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
		      	</td>
	     	 </tr>
	    </table>
	    
	    <div class="blogfooter">
      		J2EE 이야기 is powered by JBlog
		</div>
	</div>	
</body>
</html>