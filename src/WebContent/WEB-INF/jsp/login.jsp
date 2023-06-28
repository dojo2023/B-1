<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ↓共通部分 -->
<title>ログイン|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/login.css">
</head>

<body>
<div id="wrapper">
<canvas id="particle"></canvas>
<!--/wrapper--></div>
<!-- ヘッダー ここから -->
<header>
<!-- <h1 class="TextTyping">かけいぼっち</h1> -->
</header>
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->


<h2 class="TextTyping">ログイン</h2>
<span class="label label-danger"><font color="red">${message}</font></span>
<form method="post" action="/Ifrit/loginServlet" class="" >
<label>
ID<br>
<input type="text" name="userid" class=""><br>
</label>

<label>
パスワード<br>
<input type="password" name="userpw" class=""><br>
</label>

<br>
<input type="submit" name="" value="ログイン">
</form>
<br>
<a href = "/Ifrit/registerServlet" class="TextTyping">▶初めての方はこちら</a>

<p class="TextTyping" id="tutorial">このアプリの使い方</p>
<!-- 動画 -->
<video controls>
<source src="videos/dog.mp4"></video>

<!-- 共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- 共通部分 ここまで -->
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/particleText.js></script><!--https://github.com/55Kaerukun/particleText.jsからダウンロードして使用-->
<script src=./js/common.js></script>
<script src=./js/login.js></script>
</body>
</html>