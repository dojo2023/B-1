<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>支出入力|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/payment.css">
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

<h2 class="date"><c:out value="${today}"/></h2>
<table>
	<tr>
	<td>今日使えるお金：<c:out value="${gavailable}"/>円</td>
</tr>
<tr><td>
<form method="POST" action="/Ifrit/paymentServlet">
<input type="hidden" name="payment_date" value="${today}">
<select name="paymentCategory">
	<option value="">カテゴリー選択</option>
	<option value="食費">食費</option>
	<option value="外食費">外食費</option>
	<option value="交通費">交通費</option>
	<option value="日用品">日用品</option>
	<option value="衣服">衣服</option>
	<option value="医療費">医療費</option>
	<option value="美容費">美容費</option>
	<option value="ペット費用">ペット費用</option>
	<option value="娯楽費">娯楽費</option>
</select>
</td>
<td><input type="text" name="paymoney">円
<input type="submit" value="登録"></td>
</form>

</tr>
</table>
<div id="paylist">
<table>
	<c:forEach var="e" items="${paymentsList}">
	<tr>
	<td><c:out value="${e.paycategory}"/>:
		<c:out value="${e.paymoney}"/><br></td>
	</tr>
</c:forEach>

</table>
</div><!-- paylist -->


<p>支出の合計<c:out value="${paymoney}"/>円</p>
</div>

<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

</body>
</html>