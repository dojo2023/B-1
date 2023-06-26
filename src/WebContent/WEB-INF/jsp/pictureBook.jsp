<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>図鑑|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/payment.css">
</head>
<body>

<header>


<h2>図鑑</h2>

<!-- table使い方把握できてないのでSCCの時に合わせて変えてくださいごめんなさい
　　　　キャラクターの画像と番号表示 -->
<table>
<c:forEach var="e" items="${userid}" >
<tr>
<td>
		<img src="./img/characters/${e.charpic}"><br>
</td>
</tr>
</c:forEach>
</table>

<input type="button" onclick="history.back()" value="部屋に戻る">
<!-- <input type="submit" value="部屋に戻る"> -->

</header>

<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
<title>Insert title here</title>
</head>

<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

</body>
</html>