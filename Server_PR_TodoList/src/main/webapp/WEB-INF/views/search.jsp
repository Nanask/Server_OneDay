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
	<table>
	<tr>
		<th>No.</th>
		<th>할일</th>
		<th>작성일자</th>
		<th>작성시간</th>
		<th>장소</th>
	</tr>
	<c:forEach items="${TDLIST}" var="TD">
		<tr>
			<td>${TD.td_seq}</td>
			<td>${TD.td_writer}</td>
			<td>${TD.td_date}</td>
			<td>${TD.td_time}</td>
			<td>${TD.td_place}</td>
		</tr>	
	</c:forEach>
</table>

</body>
</html>