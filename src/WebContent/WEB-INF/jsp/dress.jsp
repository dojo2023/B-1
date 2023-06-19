<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><!-- ↓共通部分 -->
<title>着せ替え|かけいぼっち</title>
<link rel="stylesheet" href="css/dress.css">
</head>
<body>
<!-- ヘッダー ここから -->
<header>
<h2><c:out value="${cName}" />の部屋</h2>
</header>
<!-- ヘッダー ここまで -->
<!-- 共通部分 ここまで -->

<!-- メイン ここから -->

<h3>着せ替えショップ</h3>

<p><c:out value="${pointPm}" />pt</p>

<table>
<c:forEach var="" items="${itemList}">
 <tr>
 	<!-- 装飾品の画像 -->
 	<td>装飾品の画像<img src="./upload/${itemBuy}"><br>
 	<!-- ラジオボタンと必要なポイント数の表示 -->
 	ラジオボタンと必要なポイント数の表示<input type="radio" name="" value=""> <c:out value="${itemId}" />pt </td>
 </tr>
</c:forEach>
</table>

<form method="post" action="/ifrit/dressServlet" class="" >
<input type="submit" name="dressup" value="着替える">
<input type="submit" name="buy" value="購入">
<br>
</form>

<input type="button" onclick="history.back()" value="部屋に戻る">




<!-- ↓共通部分 ここから -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 ここまで -->
</body>

</html>