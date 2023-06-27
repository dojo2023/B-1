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
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->

<!-- メイン ここから -->

<div class="area">
<!-- グラフの埋め込み -->

<!--  今回はvarStatusを用いてループの回数を先頭に付けたindexを設定している-->


<input 	type="hidden"	id="data"  value="${j}"><br>


<div class="chart-container" style="position:relative;width:400px;height:400px;margin: auto;text-align:center;">
<canvas id="Chart"></canvas>
</div>


<div class="paytb">
<table>
 <tr>
    <th>現在の貯金額</th> <th>目標貯金額</th>
 </tr>
 <tr>
 	<td class="TextTyping"><c:out value="${acv.bbank}" />円</td> <td class="TextTyping"><c:out value="${acv.ggoal}" />円</td>
 </tr>
</table>

<table>
 <tr>
    <th>支出合計</th>
 </tr>
 <tr>
 	<td class="TextTyping"><c:out value="${acv.paymoney}" />円</td>
 </tr>
</table>

<table>
 <tr>
    <th>現在のポイント数</th>
 </tr>
 <tr>
 	<td class="TextTyping"><c:out value="${acv.pointpm}" />pt</td>
 </tr>
</table>
</div><!-- paytb -->

</div><!-- area -->


<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
<!-- ↓収支グラフのデータ取得 ここから -->
<script>
labelsData = [
	<c:forEach var="e" items="${paydetailList}" >
	'${e.paycategory}',
	</c:forEach>
	];
datasValue = [
	<c:forEach var="e" items="${paydetailList}" >
	'${e.paymoney}',
	</c:forEach>
];
</script>
<!-- ↑収支グラフのデータ取得 ここまで -->
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
<script src="js/achievement.js"></script>
</body>

</html>