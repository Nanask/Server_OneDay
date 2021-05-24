<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<label>작성일자</label>
	<input name="td_date" type="date" value="${TD.td_date}">
	</div>
	<div>
	<label>작성시간</label>
	<input name="td_time" type="time" value="${TD.td_time}">
	</div>
	<div> 
	<label>할일</label>
	<input name="td_writer" type="TEXT" value="${TD.td_writer}">
	</div>
	<div>
	<label>장소</label>
	<input name="td_place" type="TEXT" value="${TD.td_place}">
	<button class ="btn_white">추가</button>
	</div>

</body>
</html>