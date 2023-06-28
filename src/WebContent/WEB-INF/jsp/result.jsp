<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</header>
<!--↓登録成功か失敗かの変数  -->
<h1 class="TextTyping">${result.title}</h1>
<!--↓どこに戻るかのURL指定  -->
<p class="TextTyping"><a href="${result.backTo}">次へ進む</a></p>
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
</body>
</html>