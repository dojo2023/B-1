<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿画面|かけいぼっち</title>
<link rel="stylesheet" href="/Ifrit/css/common.css">
<link rel="stylesheet" href="/Ifrit/css/buytter.css">

<!--  <style>* { outline: 1px solid #FF0000; }</style>  -->

</head>
<body>
<!-- ヘッダーここから -->
<!-- 1, 共通機能のヘッダー -->
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
<!-- 1, 共通機能のヘッダーおわ -->
<!-- ヘッダーここまで -->
<!-- ↓２, サブタイトル(Buytterロゴ画像)↓ -->
<h2><img src="/Ifrit/img/???/???.png" alt="Buytter"></h2>
<!-- メインここから -->
<main>
<!-- ↓３,４,５(TLと投稿と検索のボタン)↓ -->
  <div class="wrapper">
  <ul class="tab">
    <li><a href="#tlbox">TL</a></li>
    <li><a href="#buyeetbox">投稿</a></li>
    <li><a href="#searchbox">検索</a></li>
  </ul>
<!-- ↑３,４,５(TLと投稿と検索のボタン)おわ↑ -->

<!-- ６～２０はここから -->

<!-- ６～１３(TL画面)はここから -->
<div id="tlbox" class="area">
	<!-- ↓６(リロードボタン)↓ -->
	<div class="reload">

			<input type="button" onclick="window.location.reload();" value="&#x21BA" name="Submit">

	</div>
	<!-- ↑６(リロードボタン)おわ↑ -->
	<!-- 投稿が無かった時の処理 -->
	<c:if test="${empty buyeetList}" >
		<p>一致するデータはありません。</p>
	</c:if>

	<!-- ↓７～１２(TLの繰り返し構文)↓ -->

	<c:forEach var="e" items="${buyeetList}" >


		<table class="TL">
			<tr>
				<td><form method="POST" action="/Ifrit/buytterServlet"><label>ID:<c:out value="${e.user_id}" /></label></form></td>
				<td><form method="POST" action="/Ifrit/buytterServlet"><label><c:out value="${e.created_at}" /></label></form></td>
			</tr>
			<tr>
				<td><form method="POST" action="/Ifrit/buytterServlet"><label><c:out value="${e.b_comment}" /></label></form></td>
			</tr>
			<tr>
				<td><form method="POST" action="/Ifrit/buytterServlet"><label><img src="./upload/${e.b_pic}" alt="画像のっふぁ"style = "max-width:250px;"></label></form></td>
			</tr>
			<tr>
				<td><form method="POST" action="/Ifrit/buytterServlet"><input type="hidden" name="Submit2" value="${e.id}"><input type="submit" name="Submit" value="nice buy!!"></form></td>
				<td><form method="POST" action="/Ifrit/buytterServlet"><c:out value="${e.buyte_sum}" /></form></td>
			</tr>

		</table>


	</c:forEach>

	<!-- ↑７～１２(投稿の繰り返し構文)おわ↑ -->
<!-- tlbox -->
</div>

<!-- ↓１４～１７(投稿画面)↓ -->
<div id="buyeetbox" class="area">
		<form method="POST" action="/Ifrit/buytterServlet"enctype="multipart/form-data">

	<table class="buyeet">
		<tr><td>投稿コメント</td></tr>
		<tr><td><input type="text" name="postComment" placeholder="コメントを入力してね"></td></tr>
		<tr><td>投稿画像</td></tr>
		<tr><td><input type="file" name="postPic" accept="image/*"required></td></tr>
		<tr><td><input type="submit" value="バイートする" name="Submit"></td></tr>
	</table>

		</form>
<!-- buyeetbox --></div>
<!-- ↑１４～１７(投稿画面)おわ↑ -->

<!-- ↓１４，１８～２０(検索画面)↓ -->
<div id="searchbox" class="area">
		<form method="POST" action="/Ifrit/buytterServlet">

	<table class="search">
		<tr>
		<td><input type="text" name="searchBox" placeholder="キーワードを入力してね"></td>
		<td><input type ="submit" name="Submit" value="検索ボタン" width="100" height="40" src="/Ifrit/img/???/???.png" alt=" 検索"></td>
		</tr>
		<tr>
		<td><label>最近の検索</label></td>
		</tr>
		<tr>
		<td><c:forEach var="e" items="${searchHistory}" >
				<c:out value="${searchHistory}" />
				</c:forEach></td>
		</tr>
	</table>

		</form>
<!-- searchbox --></div>
<!-- ↑１４，１８～２０(検索画面)おわ↑ -->

<!--wrapper--></div>

<!-- ６～２０ここまで -->
</main>
<!-- メインここまで -->
<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src="./js/buytter.js"></script>
</body>
</html>