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
		<div class="head">
			<h1 class="blogtitle">J2EE 이야기</h1>
			<p class="blogtag">
				자바, 컨퍼런스, java
			</p>
		</div>
	    <table class="content">
			<tr><td height="10">&nbsp;</td></tr>
			<tr>
	      		<td width="20">&nbsp;</td>
	      		<td width="530" valign="top">
		      	<!-- 포스트 시작 --> 
		      	<table>
		      		<tr><td class="posttitle">JavaOne 컨퍼런스가 열립니다.</td></tr>
		      		<tr><td class="postdate">2012/06/06</td></tr>
		      		<tr>
		      			<td class="postcontent">
		      			6월 27일부터 30일까지 샌프란시스코 모스콘센터에서 2005 JavaOneSM 컨퍼런스가 열립니다. 
		      			심도깊은 강의와 실생활에서의 혁신, 공상적인 관점에 이르기까지 Java의 강력함을 발견할 수 있습니다. 
		      			컨퍼런스에 참가하셔서 Java 탄생 10주년을 축하해주세요. 또한, 전세계의 전문가들, 혁신자들과 의견을 
		      			교환할 수 있는 좋은 기회가 될 것입니다.
		      			</td>
		      		</tr>
		      		<tr><td height="5">&nbsp;</td></tr>
		      		<tr><td class="postwriter">posted by kickscar in J2EE, 덧글 1</td></tr>
		      		<tr><td height="5">&nbsp;</td></tr>
		      		<tr><td height="5">
			      		<!-- 덧글 보여주기 시작 -->
			      		<table>
			      			<tr><td class="tdcontent">안녕하세요. 좋은글 고맙습니다.</td></tr>
			      			<tr><td class="tdcontent">commented by 길동 at 2015/06/06</td></tr>
			      		</table>
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
		      		<tr><td class="categoryitem"><a class="title" href="#">프로그래밍</a></td></tr>
	    	  		<tr><td class="categoryitem"><a class="title" href="#">여행</a></td></tr>
	      			<tr><td class="categoryitem"><a class="title" href="#">사진</a></td></tr>	      		
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