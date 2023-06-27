<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>新規登録|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/register.css">
</head>
<body>
<header>
<h1 class="TextTyping">かけいぼっち</h1>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
</head>
<body>
<h2 class="TextTyping">新規登録</h2>
<form method="POST" action="/Ifrit/registerServlet">
<table>
<tr>
<th>new ID</th>
<td><input type="text" name="userid"></td>
</tr>
<tr>
<th>new PW</th>
<td><input type="password" name="userpw"></td>
</tr>
<tr>
<th>ユーザ名</th>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>※一度登録したユーザ名は変更できません。</td>
</tr>
<tr>
<td><input type="submit" name="regist" value="登録"></td>
<td><input type="button" onclick="window.history.back();" value="戻る"></td>
</tr>
</table>

</form>
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