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
<!-- ヘッダー ここから -->
<header>
<h1>かけいぼっち</h1>
</header>
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->


<h2>ログイン</h2>

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

<a href = "/Ifrit/registerServlet">初めての方はこちら</a>

<p>チュートリアル動画</p>
<!-- 動画 -->
<video controls>
<source src="videos/dog.mp4"></video>

<!-- 共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- 共通部分 ここまで -->

</html>