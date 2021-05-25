<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value ="${pageContext.request.contextPath }" var="rootPath" />
<style>
	
	table#list {
		 border-collapse: collapse;
         border : 1PX solid rgb(219, 250, 219);
         width : 50%;
         margin: 10PX auto;
         }
     table#list td, tr, th {
     	border-collapse: collapse;
     	/* 줄색상 바꾸기 */
         border : 1PX solid rgb(19, 51, 19);
         text-align: center;
     }    
         
	 table#list tr:hover {
		cousor : pointer;
		background-color: rgb(211, 236, 211);
		}
	th {
		background-color: rgb(141, 235, 141);
	}	
</style>
<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table#list").addEventListener("click",function(ev) {
			
			let tag_name = ev.target.tagName;
			if(tag_name == "TD") {
				let td_seq = ev.target.closest("TR").dataset.seq
				
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
	<c:forEach items="${LIST}" var="TD"
			varStatus="index">
		<tr data-seq="${TD.td_seq}">
			<td>${index.count}</td>
			<%-- <td>${TD.td_seq}</td> --%>
			<td>${TD.td_writer}</td>
			<td>${TD.td_date}</td>
			<td>${TD.td_time}</td>
			<td>${TD.td_place}</td>
		</tr>	
	</c:forEach>
</table>