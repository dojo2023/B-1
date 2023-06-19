<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>カレンダー|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/calendar.css">
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




<!-- ↓カレンダー画面 -->カレンダー画面さん
 <div class="wrapper">
    <!-- xxxx年xx月を表示 -->
    <h1 id="header"></h1>

    <!-- ボタンクリックで月移動 -->
    <div id="next-prev-button">
        <button id="prev" onclick="prev()">‹</button>
        <button id="next" onclick="next()">›</button>
    </div>

    <!-- カレンダー -->
    <div id="calendar"></div>
</div>
<!-- ↑カレンダー画面 -->
<p>目標：<input type="text" name="gwant"></p>
						<!--欲しいもの↑-->

<p><input type="text" name="glimit から今日を引いた日数"><p/>


<!-- 背景の真ん中にキャラクターを表示する -->

<!-- 背景画像の下に現在の貯金額<input type="text" name="bbank">を表示させる -->

<!-- 現在の貯金額の右に目標金額<input type="text" name="ggoal">を表示させる -->
<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->



</body>
</html>