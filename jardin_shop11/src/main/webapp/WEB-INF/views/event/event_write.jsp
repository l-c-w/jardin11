<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{width: 800px; border: 1px solid black; padding: 50px;}
label {display: block; width: 100px;}
#e_name{width: 715px;}
#sub{position:relative; top:50px; left: 380px;}
h4{display: inline-block; margin-right: 5px;}
	
}
</style>
</head>
<c:if test="${write_check }">
	<script >
		alert("등록되었습니다.");
	</script>
</c:if>
<body>
	<h1>이벤트 등록</h1>
	<div>
	<form action="event_write" method="post" name="event_write" enctype="multipart/form-data">
		<label for=""><h4>이벤트명</h4></label><input type="text" name="e_name" id="e_name"><br>
		<label for=""><h4>이벤트 내용</h4></label><textarea name="e_content" id="e_content" cols="100" rows="10" ></textarea><br>
		<h4>시작일</h4><input type="date" name="start_date" id="start_date">  ~  <h4>종료일</h4><input type="date" name="end_date" id="end_date"> 
		
		<label for=""><h4>썸네일</h4></label><input type="file" name="thumb" id="thumb"><br>
		<label for=""><h4>파일2</h4></label><input type="file" name="conpic" id="conpic"><br>
		
		<input type="submit" value="전송" id="sub">
	</div>	
	</form>

</body>
</html>