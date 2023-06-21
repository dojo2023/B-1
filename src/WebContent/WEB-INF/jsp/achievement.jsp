<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- EL式 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width,initial-scale=1.0">
<!-- ↓共通部分 -->
<title>達成状況|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/achievement.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js "></script>
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
<div class="chart-container" style="position:relative;width:400px;height:400px;margin: auto;text-align:center;">
<canvas id="Chart"></canvas>
</div>



<table>
 <tr>
    <th>現在の貯金額</th> <th>目標貯金額</th>
 </tr>
 <tr>
 	<td><!--<c:out value="${acv.bbank}" />-->円</td> <td><!--<c:out value="${acv.ggoal}" />-->円</td>
 </tr>
</table>

<table>
 <tr>
    <th>支出合計</th>
 </tr>
 <tr>
 	<td><!--<c:out value="${acv.paymoney}" />-->円</td>
 </tr>
</table>

<table>
 <tr>
    <th>現在のポイント数</th>
 </tr>
 <tr>
 	<td><!--<c:out value="${acv.pointpm}" />-->pt</td>
 </tr>
</table>




<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
<script src="js/achievement.js"></script>
</body>

</html>