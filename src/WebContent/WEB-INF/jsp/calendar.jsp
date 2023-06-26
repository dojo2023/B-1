<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>カレンダー|かけいぼっち</title>
<link rel="stylesheet" href="/Ifrit/css/common.css">
<link rel="stylesheet" href="/Ifrit/css/calendar.css">
</head>
<body>
<header>
<h1>かけいぼっち</h1>
<nav class="menu">
<ul>
	<li><a href="/Ifrit/calendarServlet">カレンダー</a></li>
	<li><a href="/Ifrit/achievementServlet">達成状況</a></li>
	<li><a href="/Ifrit/buytterServlet">投稿</a></li>
	<li><a href="/Ifrit/roomServlet">お部屋</a></li>
	<li><a href="/Ifrit/rankingServlet">ランキング</a></li>
	<li><a href="/Ifrit/loginServlet">ログアウト</a></li>
	<li><a href="/Ifrit/resultGoalsServlet">目標達成</a></li>
</ul>
</nav>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
  <div class="area">
	<div class="wrapper" >
	    <!-- xxxx年xx月を表示 -->
	    <h1 id="header"></h1>

    	<!-- ボタンクリックで月移動 -->
	    <div id="next-prev-button">
	        <button id="prev" onclick="prev()">◀</button>
	        <button id="next" onclick="next()">▶</button>
	    </div><!-- next-prev-button -->

    	<!-- カレンダー -->
    	<div id="calendar"></div>
    </div>
   </div>

<div id="under"> <!-- カレンダー下のテーブル -->
<table>
<tr>
 	<td>目標:<c:out value="${wnt.gwant}" /></td><td>残り<c:out value="${wnt.until}" />日</td>
 </tr>											<!-- 達成日までの残り日数はglimit - 今日 -->
</table>
<table id="char">
 <tr>
 	<td class="char"><img class="backpic" src="./img/characters/${wnt.backpic}" style = "max-width:600px;">
 				     <img class="charpic" src="./img/characters/${wnt.charpic}" style = "max-width:200px;">
 	</td>
 </tr>
</table>
<table>
 <tr>
 	<td>現在の貯金額<c:out value="${wnt.bbank}" /></td><td>目標金額<c:out value="${wnt.ggoals}" /></td>
 </tr>
</table>
</div>







<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->


<script src="./js/calendar.js"></script>
</body>
</html>