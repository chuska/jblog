<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>
<!-- <script type="text/javascript">
	console.log(dd);
	var checkedVal = $(':input:radio[name=searchValue]:checked').val();
	console.log(checkedVal);
	$('#check').val(checkedVal);
</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/main.css">

</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<form id="search" action="/jblog/main/search" method="post">
		<table class="main-tbl">
			<tr>
				<td height="30"><c:choose>
						<c:when test='${empty authUser }'>
							<a href="/jblog/user/loginform"><strong>로그인</strong></a>
     						&nbsp;&nbsp;
     					</c:when>
						<c:otherwise>
							<a href="/jblog/user/logout"><strong>로그아웃</strong></a>
     						&nbsp;&nbsp;
      						<a href="/jblog/blog/main"><strong>내 블로그 가기</strong></a>
     						&nbsp;&nbsp;
     						<c:if test='${authUser.role == "admin"}'>
								<a href="/jblog/user/list"><strong>관리자</strong></a>
								&nbsp;&nbsp;
							</c:if>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>

				<td height="20"><input type="text" id="searchKeyword"
					name="searchKeyword" size="50"> <input type="submit"
					value="검색"></td>

			</tr>

			<tr>
				<td height="20" class="tdcontent"><input type="radio"
					name="radioValue" value="title" checked>블로그 제목 &nbsp;&nbsp;
					<input type="radio" name="radioValue" value="name">사용자
					&nbsp;&nbsp; <input type="radio" name="radioValue" value="tag">태그</td>
			</tr>
		</table>
		<c:choose>
			<c:when test='${not empty map.list }'>
				<div class="user-list">
					<c:set var='count' value='${fn:length(map.list) }'></c:set>
					<h2>검색수 : ${map.totalCount }</h2>
					<table>
						<tr>
							<th>블로그 제목</th>
							<th>블로그 주인</th>
							<th>태그</th>
						</tr>

						<c:forEach items='${map.list}' var='vo'>
							<tr>
								<td><a href="/jblog/blog/${vo.BLOG_NO }">${vo.TITLE }</a></td>
								<td>${ vo.USER_NAME }</td>
								<td>${ vo.TAG }</td>
							</tr>
						</c:forEach>
					</table>
					<div class="pager">
						<ul>
							<c:if test="${map.prevPage > 0 }">
								<li class="pg-prev"><a
									href="/jblog/main/search?p=${map.prevPage }&searchKeyword=${map.searchKeyword }&radioValue=${map.radioValue }">◀
										이전</a></li>
							</c:if>
							<c:forEach begin="${map.startPage }" end="${map.endPage }"
								var="pageIndex" step="1">
								<c:choose>
									<c:when test="${pageIndex > map.pageCount }">
										<li class="disable">${pageIndex }</li>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${pageIndex == map.currentPage }">
												<li>${pageIndex }</li>
											</c:when>
											<c:otherwise>
												<li><a
													href="/jblog/main/search?searchKeyword=${map.searchKeyword }&radioValue=${map.radioValue }&p=${pageIndex}">${pageIndex }</a></li>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${map.nextPage > 0 }">
								<li class="pg-next"><a
									href="/jblog/main/search?p=${map.nextPage }&searchKeyword=${map.searchKeyword }&radioValue=${map.radioValue }">다음
										▶</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</c:when>
		</c:choose>
	</form>
</body>
</html>