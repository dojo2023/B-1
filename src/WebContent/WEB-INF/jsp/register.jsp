<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>カレンダー|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/register.css">
</head>
<body>
<header>
<h1>かけいぼっち</h1>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
</head>
<body>
<h2><img src=""></h2>
<form method="POST" action="/ifrit/refisterServlet">
<table>
<tr>
<th>new ID</th>
<td><imput type="text" name="userid"></td>
</tr>
<tr>
<th>new PW</th>
<td><imput type="password" name="userpw"></td>
</tr>
<tr>
<th>ユーザ名</th>
<td><imput type="text" name="username"></td>
</tr>
<tr>
<td>※一度登録したユーザ名は変更できません。</td>
</tr>
<tr>
<td><input type="submit" name="regist" value="登録"></td>
<td><input type=”button” onclick=”window.history.back();” value=”戻る”></td>
</tr>
</table>

</form>
<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

</body>
</html>