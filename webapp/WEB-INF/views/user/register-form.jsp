<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원등록</title>
<Link rel="stylesheet" href="/jblog/assets/css/theme.css">
<script type="text/javascript"
	src="/jblog/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
	$(function() {
		$(".form-r-user").submit(function() {
			//아이디 중복체크
			if ($("#image-checked").is(":visible") == false) {
				alert("아이디 중복 체크를 해야 합니다.");
				$("#id").focus();
				return false;
			}
			//비밀번호
			if ($("#password").val() == "") {
				alert("비밀번호가 비어 있습니다.");
				$("#password").focus();
				return false;
			}
			//이름 체크
			if ($("#name").val() == "") {
				alert("이름이 비어 있습니다.");
				$("#name").focus();
				return false;
			}
			return true;
		});
		$("#id").change(function() {
			$("#image-checked").hide();
			$("#btn-checkid").show();
		})
		$("#btn-checkid").click(function() {
			var id = $("#id").val();
			if (id == "") {
				return;
			}
			//ajax 통신
			$.ajax({
				url : "/jblog/api/user/checkid",
				type : "get",
				dataType : "json",
				data : "id=" + id,
				contentType : 'application/json',
				success : function(response) {
					console.log(response);
					if (response.result == "fail") {
						console.error(response.message);
						return;
					}
					if (response.data == false) {
						alert("사용중인 아이디 입니다. 다른 아이디를 사용해 주세요.");
						$("#id").focus();
						return;
					}
					// 등록 가능한 이메일 처리 //
					$("#image-checked").show();
					$("#btn-checkid").hide();
				},
				error : function(jqXHR, status, e) {
					console.log(status + " : " + e);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1 class="s-logo">jBlog</h1>
	<c:import url="/WEB-INF/views/include/user_header.jsp"></c:import>
	<form class="form-r-user" method="post" action="/jblog/user/register">
		<table>
			<tr>
				<td><label>아이디</label> <input id="id" type="text" name="userId">
					<img id="image-checked" src="/jblog/assets/images/checked.png" style="width: 12px; display: none; padding-top:18px; padding-left:4px">
					<input id="btn-checkid" type="button" value="중복체크"></td>
			</tr>
			<tr>
				<td><label>비밀번호</label> <input id="password" type="password"
					name="password"></td>
			</tr>
			<tr>
				<td><label>이름</label> <input id="name" type="text"
					name="userName"></td>
			</tr>
			<tr>
				<td><label>권한</label> <label>유저</label> <input type="radio"
					name="role" value="user" checked="checked"> <label>관리자</label>
					<input type="radio" name="role" value="admin"></td>
			</tr>
			<tr>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>

	</form>
</body>
</html>