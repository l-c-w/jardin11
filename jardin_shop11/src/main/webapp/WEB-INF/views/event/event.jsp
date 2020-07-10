<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
$(document).ready(function() {
	 sessionStorage.scrollTop = 0;
	
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
					<li><a href="event?event_type=event" id="leftNavi1">진행중 이벤트</a></li>
					<li><a href="event?event_type=fin_event" id="leftNavi2">종료된 이벤트</a></li>
					<li class="last"><a href="#" id="leftNavi3">당첨자 발표</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>진행중 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					
					<!-- list -->
					<div class="eventList">
						<ul>
							<!-- 반복 -->
							<c:forEach var="event_ing" items="${list }">
							<li onclick="location.href='event_view?e_code=${event_ing.e_code}&event_type=${sv.event_type }'" style="cursor: pointer;">
								<div class="img">
								
									<img src="uploadimages/${event_ing.file1 }" alt="진행중 이벤트" />
								</div>
									<fmt:formatDate value="${now }" pattern="yyyy/MM/dd" var="nowdate"/>
									<fmt:formatDate value="${event_ing.start_date }" pattern="yyyy/MM/dd" var="start_date"/>
									<fmt:formatDate value="${event_ing.end_date }" pattern="yyyy/MM/dd" var="end_date"/>
								<div class="txt">
									<c:if test="${start_date<=nowdate }">
									<div class="subject">[진행중]${event_ing.e_name }</div>
									</c:if>
									<c:if test="${start_date>nowdate }">
									<div class="subject">[진행예정]${event_ing.e_name }</div>
									</c:if>
									<div class="day">
									
									
									이벤트 기간 : ${start_date } ~ ${end_date }
									</div>
								</div>
							</li>
							</c:forEach>
							<!-- //반복 -->

							
						</ul>
					</div>
					<!-- //list -->

					<div class="btnAreaList">
						<!-- 페이징이동1 -->
						<div class="allPageMoving1">
						
						<!-- 첫 페이지로 -->
						<a href="event?curPage=1&option=${sv.option }&search=${sv.search}" class="n"><img src="images/btn/btn_pre2.gif" alt="처음으로"/></a>
						
						<!-- 앞 페이지로 -->
						<c:if test="${paging.prev_page }">
						<a href="event?curPage=${paging.start_page-1 }&option=${sv.option }&search=${sv.search}" class="pre"><img src="images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
						</c:if>
						
						<!-- 페이지블럭 -->
						<c:forEach var="index" begin="${paging.start_page }" end="${paging.end_page }" step="1">
						<c:if test="${paging.curPage eq index }">
						<a href="event?curPage=${index }&option=${sv.option }&search=${sv.search}">${index }</a>
						</c:if>
						<c:if test="${paging.curPage ne index }">
						<a href="event?curPage=${index }&option=${sv.option }&search=${sv.search}">${index }</a>
						</c:if>
						</c:forEach>
						
						<!-- 다음 페이지로 -->
						<c:if test="${paging.next_page }">
						<a href="event?curPage=${paging.end_page+1 }&option=${sv.option }&search=${sv.search}" class="next"><img src="images/btn/btn_next1.gif" alt="뒤페이지로"/></a>
						</c:if>
						
						<!-- 마지막 페이지로 -->
						<a href="event?curPage=${paging.page_cnt }&option=${sv.option }&search=${sv.search}" class="n"><img src="images/btn/btn_next2.gif" alt="마지막페이지로"/></a>

						</div>
						<!-- //페이징이동1 -->
					</div>
					
					<!-- 검색 -->
					<div class="searchWrap">
						<div class="search">
							<ul>
								<li class="web"><img src="images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
								<form action="event" name="event_search" method="post">
									<select name="option" id="option">
										<option value="all" />전체</option>
										<option value="title" />제목</option>
										<option value="content" />내용</option>
									</select>
								</li>
								<li><input type="text" name="search" class="searchInput" value="${sv.search }"  /></li>
								</form>
								<li class="web" onclick="event_search.submit()" style="cursor: pointer;"><img src="images/btn/btn_search.gif" alt="검색" /></li>
								<li class="mobile" onclick="event_search.submit()" style="cursor: pointer;"><img src="images/btn/btn_search_m.gif" alt="검색" /></li>
							</ul>
						</div>
					</div>
					<!-- //검색 -->

				</div>
			</div>
			<!-- //contents -->

		</div>

		<!-- quickmenu -->
		<div id="quick">
			<div class="cart"><a href="#">장바구니</a></div>
			<div class="wish">
				<p class="title">위시 리스트</p>
				
				<div class="list">
					<ul>	
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
						<li><a href="#"><img src="images/img/sample_wish.gif" alt="" /></a>
					</ul>
				</div>

				<div class="total">
					<a href="#none" class="wishLeft"><img src="images/btn/wish_left.gif" alt="" /></a>
					 <span class="page">1</span> / <span class="sum">3</span>
					<a href="#none" class="wishRight"><img src="images/btn/wish_right.gif" alt="" /></a>
				</div>

			</div>

			<div class="top"><a href="#">TOP&nbsp;&nbsp;<img src="images/ico/ico_top.gif" alt="" /></a></div>
		</div>
		<script type="text/javascript">
		$(function(){
			
			$(window).scroll(function(){
				var tg = $("div#quick");
				var xg = $("div#container");
				var limit = xg.height()- 500;
				var tmp = $(window).scrollTop();

				if (tmp > limit) {
					tg.css({"position" : "absolute","right" : "-150px","bottom" : "220px","top" : "auto"});
				}
				else {
					tg.css({"position" : "fixed","top" : "314px" , "margin-left" : "940px","right" : "auto"});
				}
			});

		});
		</script>
		<!-- //quickmenu -->

	</div>
	<!-- //container -->


<!-- footer 붙여넣기 -->
<jsp:include page="../main/footer.jsp"/>

	



</div>
</div>
</body>
</html>