<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランキング画面</title>
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
<c:forEach var="e" items="${rankList}">
<tr>
<td><c:out value="${e.rank}" /></td>
<td><c:out value="${e.name}" /></td>
<td><c:out value="${e.pt}" /></td>
<td><img src="./upload/${e.pic}"></td>
</tr>
</c:forEach>
<p>あなたは<c:out value="${rank.you}"/>位</p>
<p><c:out value="${rank.point}" />ptです</p>
<footer>
<p>&copy;Ifrit.B</p>
</footer>
</table>





<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->


</body>
</html>