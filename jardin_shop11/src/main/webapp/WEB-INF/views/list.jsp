<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
		<th>글번호</th>
		<th>작성자</th>
		<th>글제목</th>
		<th>글내용</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="blist" items="${list }">
	<tr>
		<td>${blist.bId }</td>
		<td>${blist.bName }</td>
		<td>${blist.bTitle }</td>
		<td>${blist.bContent }</td>
		<td>${blist.bDate }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>