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
<h1>かけいぼっち</h1>
<nav class="menu">
<ul>
	<li>カレンダー</li>
	<li>達成状況</li>
	<li>投稿</li>
	<li>お部屋</li>
	<li>ランキング</li>
	<li>ログアウト</li>
</ul>
</nav>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
<p>現在のランキング一覧</p>

<table>
<tr>
<th>順位</th>
<th>ユーザ名</th>
<th>pt</th>
<th>キャラクター</th>
</tr>
<!--↓ランキング一覧をクラス型に格納して、それを受けわたして、すべての値をループ  -->
<c:forEach var="e" items="${rankList}">
<tr>
<td><c:out value="${rank}" /></td>
<td><c:out value="${e.username}" /></td>
<td><c:out value="${e.point}" /></td>
<td><img src="./img/characters/${e.pic}"style = "max-width:250px;"></td>
</tr>
<c:set value="${rank + 1}" var="rank"></c:set>>
</c:forEach>
</table>

<!--↓あなたのrank  -->
<p>あなたは<c:out value="${you}"/>位</p>
<!-- 累計ポイント出力  -->
<p><c:out value="${point}" />ptです</p>

<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->


</body>
</html>