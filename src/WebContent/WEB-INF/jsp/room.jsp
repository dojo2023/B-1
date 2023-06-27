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

</head>

<body>
<header>
    <h1>かけいぼっち</h1>
</header>
<div id="container">
<form method="POST" action="/Ifrit/roomServlet">
<h2><c:out value="${cname}" />の部屋</h2>
</form>
<div id='exam1'>
<nav id="n1">
	<ul id="g-navi1">
		<li><a href="/Ifrit/calendarServlet"><img src="カレンダー画像" alt="カレンダーへ"></a></li>
		<li><a href="/Ifrit/paymentServlet"><img src="支出入力画像" alt="支出入力へ"></a></li>
		<li><a href="/Ifrit/achievementServlet"><img src="達成状況画像" alt="達成状況へ"></a></li>
		<li><a href="/Ifrit/buytterServlet"><img src="Buytter画像" alt="Butterへ"></a></li>
	</ul>
</nav>
</div>

<div id='exam2'>
<main id="main-area">
<!--↓　状態にあったキャラ画像表示　-->
<img src="./img/characters/${c_name}">

</div>

<!--↓　キャラステータス　-->
<div id='exam3'>

<table>
    <tr>
        <td>目標達成度：<c:out value="${gratio}" />%</td>
    </tr>
    <tr>
        <td>出会って<c:out value="${meet}" />日目</td>
    </tr>
    <tr>
        <td>状態：<c:out value="${health}" /></td>
    </tr>
    <tr>
        <td>コメント：<c:out value="${comment}" /></td>
    </tr>

</table>
</div><!-- 'exam3' -->

</main><!-- main-area -->

<div id='exam4'>

<nav id="n2">
	<ul id="g-navi2">
		<li><a href="/Ifrit/dressServlet"><img src="着せ替えショップ画像" alt="着せ替えショップへ"></a></li>
		<li><a href="/Ifrit/picturebookServlet"><img src="図鑑画像" alt="図鑑へ"></a></li>
			<!--↓　累計獲得ポイント表示　-->
		<li>現在の<c:out value="${point_pm}" />PT</li>
			<!--↓　ランキング表示　-->
		<li>ランキング<a href="/Ifrit/rankingServlet" id="ranking"><img src="ランキング画像" alt="ランキングへ"></a></li>
		<li><form method="POST" action="/Ifrit/roomServlet"><input type="submit" value="回復"name="submit"></form></li>
	</ul>
</nav>

</div><!-- exam4 -->
</div><!-- container -->
<footer>
    <p>&copy;Ifrit.B</p>
</footer>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stickyfill/2.1.0/stickyfill.min.js"></script>
<script src=./js/room.js"></script>
</body>
</html>

