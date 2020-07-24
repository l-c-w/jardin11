<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
#use_this{position:absolute; top: 200px; left: 100px;}
</style>
</head>
<body>
<div>
<h2>아이디 중복확인</h2><br>
	<form action="id_checking">
	<input type="text" name="check_id" id="check_id" placeholder="아이디를 입력하세요">
	<button type="button" name="check" onclick="checking(check_id.value)">중복확인</button>
	</form>
	<p class="result"></p>
	<button type="button" id="use_this" onclick="go_join(check_id.value)">사용하기</button>
	
</div>				

</body>
<script type="text/javascript">
$(document).ready(function () {
	$("#use_this").hide();
});

function checking(input_id) {
	var id_check2=/^[a-zA-Z]/;
	var id_check3=/^[a-zA-Z][a-zA-Z0-9]{1,}$/;
	
	if(!check_id.value){
		
		$(".result").text("아이디를 입력해주세요.");
		return;
	}
	
	if(!(id_check2.test(check_id.value))){
		$(".result").text("아이디는 숫자로 시작할 수 없습니다.");
		return false;
	}
	
	if(!(id_check3.test(check_id.value))){
		$(".result").text("아이디에 특수문자와 한글을 포함할 수 없습니다.");
		return false;
	}
	
	$.ajax({
		type:"post",
		url:"checking",
		async: false,
		data:JSON.stringify({"id":input_id}),
		contentType:"application/json",
		dataType:"json",
		success: function (data) {
			if(data==0){
				$(".result").text("사용가능한 아이디 입니다.")
				$("#use_this").show();
			}else{
				$(".result").text("중복된 아이디 입니다.")
				$("#use_this").text();
			}
		}	
	});
}

function go_join(input_id) {
	opener.document.getElementById("id").value=input_id;
	window.close();
}


</script>

</html>