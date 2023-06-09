<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>目標設定|かけいぼっち</title>

<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/setGoals.css">

</head>
<body>
<header>
<h1 class="TextTyping">かけいぼっち</h1>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->

</head>
<form method="POST" action="/Ifrit/setGoalsServlet">
<table class="set">
<tr>
<td>
	<label>目標貯金額<br>
	<input type="text" name="ggoal" placeholder="例：50000">円
	</label>
</td>
</tr>
<tr>
<td>
	<label>使用可能額(家賃・光熱費など固定費は除く)<br>
	<input type="text" name="gavailable" placeholder="例：100000">円
	</label>
</td>
</tr>
<tr>
<td>
	<label>目標期間<br>
	<input type="date" name="glimit" max="9999-12-31">
	</label>
</td>
</tr>
<tr>
<td>
	<label>ほしいもの・したいこと<br>
	<input type="text" name="gwant" placeholder="貯金の目的を書いてね">
	</label>
</td>
</tr>
<!--
<tr>
<td>
	<label><br>
	<input type="text" value="ファイル" name="" placeholder="貯金の目的を書いてね"></label></td><td><label><input type="file" name="gwantpic" accept=".png"></label>
 acceptでファイルの種類を指定できるかも…？.jpegとか

	画面内に選択した画像が表示される用にするときは以下のコードとJS組み合わせて使用

	 onchange="previewImage(this);" required>
	<img id="preview" src="" style = "max-width:150px;">

	↑↑　　小黒さんからコードもらったやつなので例になります

</td>
</tr>
 -->
<tr>
<td>
	<label>キャラクターの名前を決めてね<br>
	<input type="text" name="cname" placeholder="バケモノ">
	</label>
</td>
</tr>
<tr>
<td>
	<input type="submit" value="登録" class="button">
</td>
</tr>
</table>
</form>

<p class="TextTyping" id="tutorial2">このアプリの使い方</p>
<!-- 動画 -->
<video controls controls width="250">
<source src="videos/tutorial.mp4"></video>


<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
</body>
</html>