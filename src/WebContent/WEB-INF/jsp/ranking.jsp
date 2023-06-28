<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランキング|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/ranking.css">
</head>
<body>
<header>
<h1 class="TextTyping">かけいぼっち</h1>
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
<h2>ポイント所持数ランキング</h2>

<table class="rank">
<tr>
<th>順位</th>
<th>ユーザ名</th>
<th>pt</th>
<th>キャラクター</th>
</tr>
<!--↓ランキング一覧をクラス型に格納して、それを受けわたして、すべての値をループ  -->
<c:forEach var="e" items="${rankList}">
<tr>
<td class="TextTyping"><c:out value="${rank}" />位</td>
<td class="TextTyping"><c:out value="${e.username}" /></td>
<td class="TextTyping"><c:out value="${e.point}" />pt</td>
<td><img src="./img/characters/${e.pic}"style = "max-width:250px;"></td>
</tr>
<c:set value="${rank + 1}" var="rank"></c:set>>
</c:forEach>
</table>

<div class="score">
<!--↓あなたのrank  -->
<p class="TextTyping">あなたは<c:out value="${you}"/>位</p>
<!-- 累計ポイント出力  -->
<p class="TextTyping"><c:out value="${point}" />ptです</p>
</div>

<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
</body>
</html>