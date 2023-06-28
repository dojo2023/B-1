<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--↓　共通部分　-->
<title>キャラクターの部屋｜かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/room.css">

<!-- <style>* { outline: 1px solid #FF0000; }</style> -->

</head>

<body>
<header>
	<h1 class="TextTyping">かけいぼっち</h1>
</header>
<div id="container">
<form method="POST" action="/Ifrit/roomServlet">
<h2 class="TextTyping"><c:out value="${cname}" />の部屋</h2>
</form>
<div id='exam1'>
<nav id="n1">
	<ul id="g-navi1">
		<li id="roomli"><a href="/Ifrit/calendarServlet"><img src="/Ifrit/img/button/calendar.png" width="80" height="80" alt="カレンダーへ"></a></li>
		<li id="roomli"><a href="/Ifrit/paymentServlet"><img src="/Ifrit/img/button/money.png" width="80" height="80" alt="支出入力へ"></a></li>
		<li id="roomli"><a href="/Ifrit/achievementServlet"><img src="/Ifrit/img/button/goals.png" width="80" height="80" alt="達成状況へ"></a></li>
		<li id="roomli"><a href="/Ifrit/buytterServlet"><img src="/Ifrit/img/button/buytter.png" width="80" height="80" alt="Buytterへ"></a></li>
	</ul>
</nav>
</div>

<div id='exam2'>
<main id="main-area">
<!--↓　状態にあったキャラ画像表示　-->
<img src="./img/characters/${c_name}" width="400">

</div>

<!--↓　キャラステータス　-->
<div id='exam3'>

<table class="sbox">
    <tr>
        <td class="TextTyping">目標達成度：<c:out value="${gratio}" />%</td>
    </tr>
    <tr>
        <td class="TextTyping">出会って<c:out value="${meet}" />日目</td>
    </tr>
    <tr>
        <td class="TextTyping">状態：<c:out value="${health}" /></td>
    </tr>
    <tr>
        <td class="TextTyping">コメント：<c:out value="${comment}" /></td>
    </tr>

</table>
</div><!-- 'exam3' -->

</main><!-- main-area -->

<div id='exam4'>

<nav id="n2">
	<ul id="g-navi2">
		<li id="roomli"><a href="/Ifrit/dressServlet"><img src="/Ifrit/img/button/shop.png" width="80" height="80" alt="着せ替えショップへ"></a></li>
		<li id="roomli"><a href="/Ifrit/picturebookServlet"><img src="/Ifrit/img/button/book.png" width="80" height="80" alt="図鑑へ"></a></li>
			<!--↓　累計獲得ポイント表示　-->
		<li id="roomli"><br>現在のポイント<br><c:out value="${point_pm}" />PT</li>
			<!--↓　ランキング表示　-->
		<li id="roomli"><a href="/Ifrit/rankingServlet" id="ranking"><img src="/Ifrit/img/button/ranking.png" width="80" height="80" alt="ランキングへ"></a></li>
		<li id="roomli"><form method="POST" action="/Ifrit/roomServlet"><input type="submit" value="" id="portion" width="80" height="80" name="submit"></form></li>
	</ul>
</nav>

</div><!-- exam4 -->
</div><!-- container -->
<footer>
    <p>&copy;Ifrit.B</p>
</footer>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
</body>
</html>

