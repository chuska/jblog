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
		<div class="head">
			<h1 class="blogtitle">J2EE 이야기</h1>
			<p class="blogtag">
				자바, 컨퍼런스, java
			</p>
			<ul>
		      <li><a href="">로그아웃</a></li>
		      <li><a href="">내 블로그 가기</a></li>
		    </ul>  
		</div>
		<table class="content">
		  <tr><td height="10" colspan="10">&nbsp;</td></tr>
	      <tr>
	      	<td height="10" width="20">&nbsp;</td>
	      	<td width="530" valign="top" class="tdcontent">
		      	<!-- 메뉴 시작 -->     
		      	<a class="title" href="">기본설정</a>
		      	&nbsp;&nbsp; 
	    	  	<strong>카테고리</strong>
	    	  	&nbsp;&nbsp;
	      		<a class="title" href="">글작성</a>
	      		&nbsp;&nbsp;
	      		<!-- 메뉴 끝 -->           	
	      	</td> 
	      </tr>
	      <tr><td height="5">&nbsp;</td></tr>
	      <tr>
	      	<td height="10">&nbsp;</td>
	      	<td>
	      	
	      	<!-- 작업 화면  시작 -->           	
	      	<table class="tbl-category">
	      		<tr>
	      			<td>번호</td>
	      			<td>카테고리명</td>
	      			<td>보이기</td>
	      			<td>포스트 수</td>
	      			<td>설명</td>
	      			<td>삭제</td>      			
	      		</tr>
				<tr>
					<td>1</td>
					<td>프로그래밍</td>
					<td>타이틀</td>
					<td>10</td>
					<td>프로그래밍에 관한 이것 저것</td>
					<td>&nbsp;<img height="9" src="/jblog/assets/images/delete.jpg"></td>
				</tr>  
			</table>
	      	<table>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td class="tdcontent" height="5"><b>새로운 카테고리 추가</b></td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>      		
	      		<tr>
	      			<td width="150" class="inputlabel">카테고리명 :</td>
	      			<td><input class="inputtext" type="text" size="40" name="categoryName"></td>
	      		</tr>
	      		<tr>
	      			<td width="150" class="inputlabel">보이기 유형 :</td>
	      			<td class="tdcontent">
	      				<input type="radio" name="displayType" checked>타이틀&nbsp;&nbsp;
	      				<input type="radio" name="displayType">텍스트&nbsp;&nbsp;</td>      			
	      		</tr>
	      		<tr>
	      			<td width="150" class="inputlabel">설명 :</td>
	      			<td><input class="inputtext" type="text" size="50" name="description"></td>
	      		</tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr>
	      			<td colspan="10" align="center">&nbsp;<input type="submit" value="카테고리 추가"></td>
	      		</tr>      		      		
	      	</table>      		      	
	      	<!-- 작업 화면  끝 -->  
	      	         	      	
	      	</td>
	      </tr>
	      <tr>
	      	<td height="10" colspan="10">&nbsp;</td>
	      </tr>
	    </table>
	    <div class="blogfooter">
      		J2EE 이야기 is powered by JBlog
		</div>
	</div>
   	
</body>
</html>