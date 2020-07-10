<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="main">메인으로 가기</a><br>
<a href="list">글 리스트 보기</a><br>
<a href="join_page">회원가입</a><br>
<a href="ewrite_page">이벤트 작성</a><br>
</body>


</html>
