<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBlog - J2EE 이야기</title>
<Link rel="stylesheet" href="/jblog/assets/css/theme.css">
<script type="text/javascript" src ="/jblog/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
var pageNumber =1;
var jbox;
var dataCount;
var fetchList = function(){
	console.log($("#blogNo").val());
	$.ajax( {

		url : "/jblog/api/blog/category",

		type: "get",

		dataType: "json",

		data: "blogNo="+$("#blogNo").val(),

		contentType: 'application/json',
		
		success: function(response){
			
			dataCount = response.data.length;
			
			if(response.result == "fail")
			{
				console.error(response.messaage);
				return;
			}
			
			//카테고리 리스트 
			$.each(response.data,function(index,data){
				
				categoryList(index,data);
			});
		},

		error: function( jqXHR, status, e ){
		console.log( status + " : " + e );
		}

		});
}
var categoryList = function(index,data)
{
	var dataNum = dataCount - index;
	var $listDiv= $("#categoryList");
	var html = "<tr class ='tr-category' id='tr_category"+data.categoryNo+"' >"
		+"<td>"+dataNum+"</td>"
		+"<td>"+data.categoryName+"</td>"
		+"<td>"+data.displayType+"</td>"
		+"<td>"+data.cntDisplayPost+"</td>"
		+"<td>"+data.description+"</td>"
		+"<td>&nbsp;<input type='button' class ='btn-delete' height='9' src='/jblog/assets/images/delete.jpg' data-no='"+data.categoryNo+"' value ='삭제'></td>"
	    +"</tr>";
	$listDiv.after(html);
}

var categoryAdd = function(data)
{
	var dataNum = dataCount = dataCount+1;
	var $listDiv= $(".tbl-category"); 
	var html = "<tr class ='tr-category' id='tr_category" +data.categoryNo+ "'  >"
		+"<td>"+dataNum+"</td>"
		+"<td>"+data.categoryName+"</td>"
		+"<td>"+data.displayType+"</td>"
		+"<td>"+data.cntDisplayPost+"</td>"
		+"<td>"+data.description+"</td>"
		+"<td>&nbsp;<input type='button' class ='btn-delete' height='9' src='/jblog/assets/images/delete.jpg' data-no='"+data.categoryNo+"' value ='삭제'></td>"
	    +"</tr>";
	    /* <img calss ='btn-delete' height='9' src='/jblog/assets/images/delete.jpg'> */
	$listDiv.append(html);
}

$(function(){
	
	$(document).on( "click", ".btn-delete", function(){
		
		var dataNo =$(this).attr("data-no");
		
		$.ajax( {

			url : "/jblog/api/blog/delete",

			type: "get",

			dataType: "json",

			data: "cate_no="+dataNo,

			contentType: 'application/json',
			
			success: function(response){
				console.log(response)
				if(response.result == "fail")
				{
					console.error(response.messaage);
					return;
				}
				if(response.data==true)
				{
					$("#tr_category"+dataNo).remove();
				}else
				{
					alert("비밀번호가 틀립니다.");				
				}
			},

			error: function( jqXHR, status, e ){
			console.log( status + " : " + e );
			}

			});
	});
	
	//추가버튼
	$("#btn-add").click(function(){
		//이름 , 비밀번호 ,contenct 가져오기 
		var contentVal 	= $(':radio[name="displayType"]:checked').val();
		var categoryName =$("#categoryName").val();
		var description = $("#description").val();
		var blogNo = $("#blogNo").val(); 
		
		//ajax
		$.ajax( {

			url : "/jblog/api/blog/insert",

			type: "get",

			dataType: "json",
			
			data: "categoryName=" + categoryName+"&blogNo="+blogNo+"&description="+description+"&displayType="+contentVal,
			
			contentType: 'application/json',
			
			success: function(response){
				console.log(response)
				if(response.result == "fail")
				{
					console.error(response.messaage);
					return;
				}
				
				categoryAdd(response.data);
			},

			error: function( jqXHR, status, e ){
			console.log( status + " : " + e );
			}

			});
		
		 $("#categoryName").val("");
		 $("#description").val("");
		 $(":radio[name='displayType']").attr("checked", true); 

	})
	
	
	 fetchList();
})

</script>
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
		      	<a class="title" href="/jblog/blog/basic?blogNo=${blogVo.blogNo}&title=${title }&tag=${tag }">기본설정</a>
		      	&nbsp;&nbsp; 
	    	  	<strong>카테고리</strong>
	    	  	&nbsp;&nbsp;
	      		<a class="title" href="/jblog/blog/writer?blogNo=${blogVo.blogNo}&title=${title }&tag=${tag }">글작성</a>
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
	      		<tr id ="categoryList">
	      			<td>번호</td>
	      			<td>카테고리명</td>
	      			<td>보이기</td>
	      			<td>포스트 수</td>
	      			<td>설명</td>
	      			<td>삭제</td>      			
	      		</tr>
								
			</table>
	      	<table>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr><td class="tdcontent" height="5"><b>새로운 카테고리 추가</b></td></tr>
	      		<tr><td height="5">&nbsp;</td></tr>      		
	      		<tr>
	      			<td width="150" class="inputlabel">카테고리명 :</td>
	      			<td><input class="inputtext"  type="text" size="40" id="categoryName" name="categoryName"></td>
	      		</tr>										
	      		<tr>
	      			<td width="150" class="inputlabel">보이기 유형 :</td>
	      			<td class="tdcontent">
	      				<input type="radio" name="displayType" value="타이틀" checked>타이틀&nbsp;&nbsp;
	      				<input type="radio" name="displayType" value="텍스트">텍스트&nbsp;&nbsp;</td>      			
	      		</tr>
	      		<tr>
	      			<td width="150" class="inputlabel">설명 :</td>
	      			<td><input class="inputtext" type="text" size="50" id="description" name="description"></td>
	      		</tr>
	      		<tr><td height="5">&nbsp;</td></tr>
	      		<tr>
	      			<td colspan="10" align="center">&nbsp;<input id="btn-add" type="button" value="카테고리 추가"></td>
	      			<td><input type="hidden" id="blogNo" value="${blogVo.blogNo}"/></td>
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