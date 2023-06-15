<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿画面</title>

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
	<li>カレンダー</li>
	<li>達成状況</li>
	<li>投稿</li>
	<li>お部屋</li>
	<li>ランキング</li>
	<li>ログアウト</li>
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
<table>
	<tr>
		<td><input type="button" onclick="location.href='(tlboxだけを表示)????????'" value="TL"></td>
		<td><input type="submit" onclick="(buyeetboxだけを表示)???????????" value="投稿"></td>
		<td><input type="submit" onclick="(searchboxだけを表示)???????????" value="検索"></td>
	</tr>
</table>
<!-- ↑３,４,５(TLと投稿と検索のボタン)おわ↑ -->

<!-- ６～２０はここから -->

<!-- ６～１３(TL画面)はここから -->
<div class="tlbox">

<!-- ↓６(リロードボタン)↓ -->
<input type="button" onclick="window.location.reload();" value="リロード" name="tlReload">
<!-- ↑６(リロードボタン)おわ↑ -->

<!-- 投稿が無かった時の処理 -->
<c:if test="${empty buyeetList}">
	<p>一致するデータはありません。</p>
</c:if>

<!-- ↓７～１２(投稿の繰り返し構文)↓ -->
<c:forEach var="e" items="${buyeetList}" >
	<form method="POST" action="/buytterServlet">

	<table>
		<tr><td><label><c:out value="${tlUsername}" /></label></td><td><label><c:out value="${tlTime}" /></label></td></tr>
		<tr><td><label><c:out value="${tlComment}" /></label></td></tr>
		<tr><td><label><c:out value="${tlPicture}" /></label></td></tr>
		<tr><td><input type="checkbox" name="tlStump" value="nice buy!!"></td>
			<td><c:out value="${tlStumpNumber}" /></td></tr>
	</table>

	</form>
</c:forEach>
<!-- ↑７～１２(投稿の繰り返し構文)おわ↑ -->

</div>

<!-- ↓１４～１７(投稿画面)↓ -->
<div class="buyeetbox">
	<form method="POST" action="/buytterServlet">

<table>
	<tr><td><input type="button" onclick="window.location.reload();" value="キャンセル" name="cansell"></td></tr>
	<tr><td>投稿コメント</td></tr>
	<tr><td><input type="text" name="postComment"></td></tr>
	<tr><td>投稿画像</td></tr>
	<tr><td>投稿画像を入れるやつ</td></tr>
	<tr><td><input type="submit" onclick="(バイートする処理)???????????" value="バイートする" name="postSubmit"></td></tr>
</table>

	</form>
</div>
<!-- ↑１４～１７(投稿画面)おわ↑ -->

<!-- ↓１４，１８～２０(検索画面)↓ -->
<div class="searchbox">
	<form method="POST" action="/buytterServlet">

<table>
	<tr><td><input type="button" onclick="window.location.reload();" value="キャンセル" name="cansell"></td></tr>
	<tr><td><input type="text" name="searchBox"></td>
		<td><input type ="image" name="searchSubmit" width="100" height="40" src="/Ifrit/img/???/???.png" alt=" 検索"></td></tr>
	<tr><td><label>最近の検索</label></td></tr>
	<tr><td><c:forEach var="e" items="${searchHistory}" >
				<c:out value="${searchHistory}" />
			</c:forEach></td></tr>
</table>

	</form>
</div>
<!-- ↑１４，１８～２０(検索画面)おわ↑ -->

<!-- ６～２０ここまで -->
</main>
<!-- メインここまで -->
<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
</body>
</html>