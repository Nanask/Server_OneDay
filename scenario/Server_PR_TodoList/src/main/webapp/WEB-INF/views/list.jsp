<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />
<style>
	
	table#list {
		 border-collapse: collapse;
         border : 1PX solid grey;
         width : 50%;
         margin: 10PX auto;
         }
     table#list td, tr, th {
     	border-collapse: collapse;
         border : 1PX solid grey;
         text-align: center;
     }    
         
	 table#list tr:hover {
		cousor : pointer;
		background-color: #ddd;
		}
</style>
<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table#list").addEventListener("click",function(ev) {
			
			let tag_name = ev.target.tagName;
			if(tag_name == "TD") {
				let td_seq = ev.target.closest("TR").dataset.seq
				alert("저장화면으로")
				
				document.location.href="${rootPath}/todo/view?td_seq=" + td_seq
			}
		})
	})
</script>
<table id="list">
	<tr>
		<th>No.</th>
		<th>할일</th>
		<th>작성일자</th>
		<th>작성시간</th>
		<th>장소</th>
	</tr>
	<c:forEach items="${LIST}" var="TD">
		<tr data-seq="${TD.td_seq}">
			<td>${TD.td_seq}</td>
			<td>${TD.td_writer}</td>
			<td>${TD.td_date}</td>
			<td>${TD.td_time}</td>
			<td>${TD.td_place}</td>
		</tr>	
	</c:forEach>
</table>