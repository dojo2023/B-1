<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/result.css">
</head>
<body>
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
</head>
<body>
<h1><c:out value="${result.title}" /></h1>
<h2><a href="${result.backTo}">リターン</a></h2>
<footer>
<p>&copy;Ifrit.B</p>
</footer>
</body>
</html>