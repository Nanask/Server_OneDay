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
	table {
		 border-collapse: collapse;
         border : 1PX solid grey;
         width : 50%;
         margin: 10PX auto;
         }
    td, tr, th {
     	border-collapse: collapse;
         border : 1PX solid grey;
         text-align: center;
     }    
</style>
</head>
<body>
	<table>
		<tr>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>할일</th>
			<th>장소</th>
		</tr>
		<tr>
			<td>${TD.td_date}</td>
			<td>${TD.td_time}</td>
			<td>${TD.td_writer}</td>
			<td>${TD.td_place}</td>
			
			
		</tr>
	</table>
	
	<div class="view_btn">
		<button class="btn_home">처음으로</button>
		<button class="btn_insert">추가하기</button>
		<button class="btn_update">수정하기</button>
		<button class="btn_delete">삭제하기</button>
	
	</div>

</body>
</html>