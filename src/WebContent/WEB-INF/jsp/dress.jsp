<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- ↓共通部分 -->
<title>着せ替え|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/dress.css">
</head>
<body>
<!-- ヘッダー ここから -->
<header>
</header>
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->

<!-- メイン ここから -->
<div id="container">
<h2 class="TextTyping"><c:out value="${names}" />の部屋</h2>
</div>
<h3 class="TextTyping">着せ替えショップ</h3>

<p class="TextTyping"><c:out value="${points}" />pt</p>

<table class="rank">
 <tr>
<c:forEach var="e" items="${Dress}">

 	<!-- 装飾品の画像 -->

 	<td><label>
 	<!-- ラジオボタンと必要なポイント数の表示 -->
 	<input type = "radio"name="check"value="${e.itempic}"id="radio"><img src="./img/items/${e.itempic}"style = "max-width:250px;">
 	</label></td>

</c:forEach>
 </tr>
</table>

<form method="post" action="/ifrit/dressServlet" class="" >
<input type="submit" name="dressup" value="着替える" class="button">
<input type="submit" name="buy" value="購入" class="button">
<br>
</form>

<a href="/Ifrit/roomServlet" class="TextTyping">部屋にもどる</a>





<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script src=./js/common.js></script>
</body>

</html>