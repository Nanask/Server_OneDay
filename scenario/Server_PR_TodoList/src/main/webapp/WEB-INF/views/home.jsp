<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form {
		margin: auto;
	}

	h1{
	text-align: center;
	margin: 10px;
	padding: 20px;
	
	}
	label, input, button {
	text-align: center;
	margin: 10px;
	}
	
	div {
	text-align: center;
	margin: 10px;

	}
	

</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	document.querySelector("button.btn_search").addEventListener("click",function(ev) {
		
		document.location.href ="${rootPath}/todo/wirte?td_date=" + td_date
	})
})
</script>
</head>
<body>
	<form method="POST">
	<h1>To Do List</h1>
	<div>
	<label>날짜로 검색하기</label>
	<input name="td_date" type="date" value="${TD.td_date}">
	<button class ="btn_search">검색</button>
	</div>
	
	</form>
	<%@ include file="/WEB-INF/views/list.jsp" %>
</body>
</html>