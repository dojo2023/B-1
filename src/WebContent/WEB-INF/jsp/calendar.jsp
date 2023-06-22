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
    <form method="GET" action = "/Ifrit/paymentServlet"><div id="calendar"></div></form>
    </div>
   </div>

<div id="under"> <!-- カレンダー下のテーブル -->
<table>
<tr>
 	<td>目標:<c:out value="${wnt.gwant}" /></td><td>残り日数<c:out value="${wnt.until}" /></td>
 </tr>											<!-- 達成日までの残り日数はglimit - 今日 -->
</table>
<table>
 <tr>
 	<td></td><c:out value="${wnt.charpic}" />  <!-- 背景の真ん中にキャラクターを表示する -->
 </tr>
</table>

<table>
 <tr>
 	<td>現在の貯金額<c:out value="${wnt.bbank}" /></td><td>目標金額<c:out value="${wnt.ggoals}" /></td>
 </tr>  <!-- 背景画像の下に現在の貯金額<input type="text" name="bbank">を表示させる -->
</table><!-- 現在の貯金額の右に目標金額<input type="text" name="ggoal">を表示させる -->
</div>







<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->


<script src="./js/calendar.js"></script>
</body>
</html>