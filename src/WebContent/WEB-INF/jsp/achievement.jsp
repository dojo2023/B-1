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
	<li>カレンダー</li>
	<li>達成状況</li>
	<li>投稿</li>
	<li>お部屋</li>
	<li>ランキング</li>
	<li>ログアウト</li>
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