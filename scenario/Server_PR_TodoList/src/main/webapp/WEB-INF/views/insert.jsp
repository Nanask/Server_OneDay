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
	form.v1 {
		width: 80%;
		margin:10px auto;
	}

	
	form.v1 label, form.v1 input{
		display: inline-block;
		padding:5px;
		margin:5px;
	}
	
	form.v1 label {
		width:150px;
		text-align: right;
	}
	
	form.v1 input {
		width: 300px;
		border: 1px solid green;
		border-radius: 5px;
	}



</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	//alert("저장")
	document.querySelector("button.btn_save").addEventListener("click",function(ev){
		
		let dom = document;
		let td_date = dom.querySelector("input[name='td_date']");
		let td_time = dom.querySelector("input[name='td_time']");
		let td_writer = dom.querySelector("input[name='td_writer']");
		let td_place = dom.querySelector("input[name='td_place']");
		
		if(td_date.value == "") {
			alert("작성일은 반드시 입력해야 합니다")
			
			td_date.focus();
			return false;
		}
		if(td_time.value == "") {
			alert("작성시간은 반드시 입력해야 합니다")
			
			td_time.focus();
			return false;
		}
		if(td_writer.value == "") {
			alert("내용은 반드시 입력해야 합니다")
			gb_writer.focus();
			return false;
		}
		if(td_place.value == "") {
			alert("장소는 반드시 입력해야 합니다")
			gb_writer.focus();
			return false;
		}
		
		alert("저장버튼" + td_date.value + "\n"
				+ td_time.value + "\n"
				+ td_writer.value + "\n"
				+ td_place.value + "\n"
		)
		dom.querySelector("form.v1").submit();
		
	})

})
</script>
</head>
<body>
	<form class="v1" method=POST>
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
	<button class ="btn_save" type="button">저장</button>
	</div>
	</form>

</body>
</html>