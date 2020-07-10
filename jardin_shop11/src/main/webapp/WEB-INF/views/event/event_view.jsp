<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="css/content.css?v=Y" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/top_navi.js"></script>
<script type="text/javascript" src="js/left_navi.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.anchor.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<script type="text/javascript" src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
//댓글 작성후 위치 고정
$(window).scroll(function() {
    sessionStorage.scrollTop = $(this).scrollTop();
});

$(document).ready(function() {
	 if (sessionStorage.scrollTop != "undefined") {
		 if(sessionStorage.scrollTop>1000){
			 $(window).scrollTop($("#save_point").offset().top);
	     }else{
	    	 $(window).scrollTop(0);
	     }
		 
	 }
});


</script>
</head>
<body>

<!-- 헤더 붙여넣기 -->
<jsp:include page="../main/header.jsp"/>



	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="main">HOME</a></li>
				<li><a href="event?event_type=event">EVENT</a></li>
				<li class="last">진행중 이벤트</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">EVENT<span>이벤트</span></div>
				<ul>	
				<c:choose>
				<c:when test="${r_paging.event_type eq 'event' }">
					<li><a href="event?event_type=event" id="leftNavi1">진행중 이벤트</a></li>
					<li><a href="event?event_type=fin_event">종료된 이벤트</a></li>
					</c:when>
					<c:when test="${r_paging.event_type eq 'fin_event' }">
					<li><a href="event?event_type=event" >진행중 이벤트</a></li>
					<li><a href="event?event_type=fin_event" id="leftNavi1">종료된 이벤트</a></li>
					</c:when>
					</c:choose>
					<li class="last"><a href="#" id="leftNavi3">당첨자 발표</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
				<!-- 진행,종료에 따른 출력 분기 -->
				<c:choose>
					<c:when test="${r_paging.event_type eq 'event' }">
						<h2><strong>진행중 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					</c:when>
						<c:when test="${r_paging.event_type eq 'fin_event' }">
					<h2><strong>종료된 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득했던 이벤트 목록을 확인하실 수 있습니다.</span></h2>
					</c:when>
				</c:choose>
					
					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<!-- 이벤트 이름 -->
									<li>${event_view.e_name }</li>
								</ul>
							</div>
							<!-- 이벤트 기간 -->
							<div class="day">
								<p class="txt">이벤트 기간<span>${event_view.start_date } ~ ${event_view.end_date }</span></p>
							</div>
						</div>
						<!-- 본문 이미지 -->
						<div class="viewContents">
							<img src="uploadimages/${event_view.file2 }" alt="내부 이미지" />
							${event_view.e_content }
						</div>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							<col width="100px" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									<td><a href="#">상품 재입고는 언제 되나요?</a></td>
									<td>&nbsp;</td>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td>다음 글이 없습니다.</td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->


					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in" id="save_point">
							<!-- 댓글 갯수 -->
								<p class="txt">총 <span class="orange">${reply_count }</span> 개의 댓글이 달려있습니다.</p>
								<!-- 리플 작성 form -->
								<form action="reply" method="post" name="reply" id="reply">
									<input type="hidden" name="e_code" value="${event_view.e_code }">
									<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" name="r_pw" /></p>
									<textarea class="replyType" name="r_content"></textarea>
								</form>
							</li>
							<li id="input_btn" onclick="reply_write('${event_view.e_code }','${r_paging.event_type }')" style="cursor: pointer;margin-left: 10px;"><a class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>
					
					<!-- 리플 뿌려주기 -->
					<div class="replyBox">
						<c:forEach var="replyList" items="${reply_list }" >
						<ul id="${replyList.r_number }">
							<!-- 작성자 -->
							<li class="name">${replyList.id }
							<!-- 날짜비교 당일이면 시간으로 출력-->
							<fmt:formatDate var="now_date" value="${now }" pattern="yyyy/MM/dd"/>
							<fmt:formatDate var="r_date" value="${replyList.r_date }" pattern="yyyy/MM/dd"/>
							
							<c:choose>
							<c:when test="${now_date eq r_date }">
								<span>[<fmt:formatDate value="${replyList.r_date }" pattern="hh:mm"/>] </span>
								</c:when>
							<c:when test="${now_date ne r_date }">
								<span>[<fmt:formatDate value="${replyList.r_date }" pattern="yy/MM/dd"/>] </span>
								</c:when>
							</c:choose>
							</li>
							<!-- 본문 출력 -->
							<li class="txt" ><!-- <textarea class="replyType" style="border: none;"> -->
								<!-- 비밀글일 시 -->
								<c:choose> 
								<c:when test="${not empty replyList.r_pw}">
								
								<!-- 작성자 본인 체크 -->
								<c:choose >
								<c:when test="${replyList.id eq sessionScope.user_id }">
								<span class="orange" id="${replyList.r_number }lock">※ 비밀글입니다.</span></a><br>
								${replyList.r_content }
								</c:when>
								<c:when test="${replyList.id ne sessionScope.user_id }">
								<span class="orange">※ 비밀글입니다.</span>
								</c:when>
								</c:choose>
								
								</c:when>
								
								<!-- 비밀글이 아닐 시 -->
								<c:when test="${empty replyList.r_pw}">
								<div>
								${replyList.r_content }
								</div>
								</c:when>
								</c:choose>
								
							</li>
							<!-- 수정삭제 버튼 출력 본인일 경우만 표시 -->
							<c:if test="${sessionScope.user_id eq replyList.id }">
							<li class="btn" >
								<a onclick="update('${replyList.r_number }','${replyList.r_content }','${replyList.id }')" style="cursor: pointer;" class="rebtn">수정</a>
								<a onclick="del('${replyList.r_number }',)" style="cursor: pointer;" class="rebtn">삭제</a>
							</li>
							</c:if>
						</ul>
						
						</c:forEach>
						
					</div>
					<!-- //댓글 -->
					
					<div class="btnAreaList">
						<!-- 페이징이동1 -->
						<c:if test="${r_paging.listCnt ne 0 }">
						<div class="allPageMoving1">
						
						<!-- 첫 페이지로 -->
						<a href="event_view?e_code=${r_paging.e_code }&curPage=1&event_type=${r_paging.event_type }" class="n"><img src="images/btn/btn_pre2.gif" alt="처음으로" class="page_move"/></a>
						
						<!-- 앞 페이지로 -->
						<c:if test="${r_paging.prev_page }">
						<a href="event_view?e_code=${r_paging.e_code }&curPage=${r_paging.start_page-1 }&event_type=${r_paging.event_type }" class="pre"><img src="images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
						</c:if>
						
						<!-- 페이지블럭 -->
						<c:forEach var="index" begin="${r_paging.start_page }" end="${r_paging.end_page }" step="1">
						<c:if test="${r_paging.curPage eq index }">
						<a href="event_view?e_code=${r_paging.e_code }&curPage=${index }&event_type=${r_paging.event_type }" class="page_move">${index }</a>
						</c:if>
						<c:if test="${r_paging.curPage ne index }">
						<a href="event_view?e_code=${r_paging.e_code }&curPage=${index }&event_type=${r_paging.event_type }" class="page_move">${index }</a>
						</c:if>
						</c:forEach>
						
						<!-- 다음 페이지로 -->
						<c:if test="${r_paging.next_page }">
						<a href="event_view?e_code=${r_paging.e_code }&curPage=${r_paging.end_page+1 }&event_type=${r_paging.event_type }" class="next"><img src="images/btn/btn_next1.gif" alt="뒤페이지로"/></a>
						</c:if>
						
						<!-- 마지막 페이지로 -->
						<a href="event_view?e_code=${r_paging.e_code }&curPage=${r_paging.page_cnt }&event_type=${r_paging.event_type }" class="n"><img src="images/btn/btn_next2.gif" alt="마지막페이지로"/></a>

						</div>
						</c:if>
						<!-- //페이징이동1 -->
					</div>


					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bRight">
							<ul>
								<!-- 이벤트 타입에 따라 목록 버튼 다르게 -->
								<c:choose>
									<c:when test="${r_paging.event_type eq 'event'}">
									<li><a href="event" class="sbtnMini mw">목록</a></li>	
									</c:when>
									<c:when test="${r_paging.event_type eq 'fin_event'}">
									<li><a href="event?event_type=fin_event" class="sbtnMini mw">목록</a></li>	
									</c:when>
								</c:choose>
								
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
				
				</div>
			</div>
			<!-- //contents -->


<script type="text/javascript" src="js/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
$(function(){
	
	var winWidth = $(window).width();
	if(winWidth > 767){
		var layerCheck = 540;
	}else{
		var layerCheck = 320;
	}

	 /* $(".passwordBtn").fancybox({
		'autoDimensions'    : false,
		'showCloseButton'	: false,
		'width' : layerCheck,
		'padding' : 0,
		'type'			: 'iframe',
		'onComplete' : function() {
			$('#fancybox-frame').load(function() { // wait for frame to load and then gets it's height
			$('#fancybox-content').height($(this).contents().find('body').height());
			});
		}
	}); */
	

});

//댓글 작성
function reply_write(e_code,event_type) {
	//세션체크
	log_check='<%=session.getAttribute("user_id")%>';
	
	alert('${sessionScope.user_id}');
	
	if(log_check=='null'){
	var con = confirm("로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하시겠습니까?");
		if (con) {
			location.href='login_page';
		}else{
		return;			
		}	
	}else{
		var reply=$("form[name=reply]").serialize();
		$.ajax({
			type:"post",
			url:"reply",
			data:reply,
			dataType:"json",
			success: function () {
				alert("댓글을 작성하였습니다.");
				location.href="event_view?e_code="+e_code+"&event_type="+event_type;
				 $(window).scrollTop($("#save_point").offset().top);
			},
			error: function () {
				alert("작성 실패");
			}
		});
	}	
}

//댓글창 수정창으로 변경
function update(r_number,r_content,id) {
	//바뀔 창 아이디
	var target = "#"+r_number;
	//비밀글 여부 체크
	var lock_ch = "#"+r_number+"lock";
	var lock = $(lock_ch).text();
	//수정 버튼 클릭시 다른 글 수정버튼 숨기기, 글작성 등록글 비활성화
	$(".btn").hide();
	$("#input_btn").attr('onclick', '').unbind('click');
	
	var html="";
	
	html= html+'<form action="r_update" method="post" name="r_update">'+
				'<input type="hidden" value='+r_number+' name="r_number">'+
				'<li class="name">'+id+'<li class="in">';
	
	if (lock.indexOf("비밀글")!==-1) {
	html= html+'<p class="password" style="display: inline-block;">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" name="r_pw" /></p><span class="ntic">※ 글 작성시 입력한 비밀번호를 입력해주세요.</span>';
	}
	
	html= html+'<textarea class="replyType" name="r_content">'+r_content+'</textarea></li>'+
		'<li class="btn"><a onclick="update_ok()" style="cursor: pointer;" class="rebtn">확인</a>'+
		'<a onclick="document.location.reload(true);" style="cursor: pointer;" class="rebtn">취소</a></li></form>';
	//html 변경
	$(target).html(html);
}

//댓글 수정 확인
function update_ok() {
	//수정내용 담기
	var r_data = $("form[name=r_update]").serialize();
	//수정확인 체크
	var u_check = confirm("댓글을 수정하시겠습니까?");
	if(!u_check){
		return;
	}
	
	$.ajax({
		type:"post",
		url:"r_update",
		data:r_data,
		dataType:"json",
		success: function (data) {
			if(data==1){
			alert("댓글이 수정되었습니다.");
			document.location.reload(true);
			}else if(data==-1){
				alert("비밀번호가 다릅니다.");
			}else{
				alert("오류가 발생하였습니다.")
			}
		},
		error: function () {
			alert("수정 실패");
		}
		});
}

//댓글 삭제
function del(r_number) {
	//삭제할 창 아이디
	var target = "#"+r_number;
	//비밀글 체크
	var lock_ch = "#"+r_number+"lock";
	var lock = $(lock_ch).text();
	
	//삭제 확인
	var del_check = confirm("댓글을 삭제하시겠습니까?");
	if(!del_check){
		return;
	}
	
	//비밀글일 경우 비밀번호 입력창 띄우기
	if (lock.indexOf("비밀글")!==-1){
		var popupWidth = 500;
		var popupHeight = 300;

		var popupX = (window.screen.width / 2) - (popupWidth / 2);
		var popupY= (window.screen.height / 2) - (popupHeight / 2);
		
		window.open('password?r_number='+r_number,'viewer', 'width=500, height=300,left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);	
	}else{
		var r_number=JSON.stringify({"r_number":r_number});
		$.ajax({
			type:"post",
			url:"r_del",
			data:r_number,
			contentType:"application/json",
			dataType:"json",
			success: function (data) {
				if(data==1){
					alert("댓글이 삭제되었습니다.");
					document.location.reload(true);
					}else if(data==-1){
						alert("비밀번호가 다릅니다.");
					}else{
						alert("오류가 발생하였습니다.")
					}
				},
				error: function () {
					alert("실패");
				}
				});
	}
}


</script>

		</div>
	</div>
	<!-- //container -->

<!-- footer 붙여넣기 -->
<jsp:include page="../main/footer.jsp"/>

</div>
</div>
</body>
</html>