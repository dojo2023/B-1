<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ↓共通部分 -->
<title>達成状況|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/achievement.css">
</head>
<body>
<!-- ヘッダー ここから -->
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
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->

<!-- メイン ここから -->


<!-- グラフの埋め込み -->

<hr>

<table>
 <tr>
    <th>現在の貯金額</th> <th>目標貯金額</th>
 </tr>
 <tr>
 	<td><c:out value="${bBank}" />円</td> <td><c:out value="${gGoal}" />円</td>
 </tr>
</table>

<table>
 <tr>
    <th>支出合計</th>
 </tr>
 <tr>
 	<td><c:out value="${payMoney}" />円</td>
 </tr>
</table>

<table>
 <tr>
    <th>現在のポイント数</th>
 </tr>
 <tr>
 	<td><c:out value="${pointPm}" />pt</td>
 </tr>
</table>






<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
</body>

</html>