<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>図鑑|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/pictureBook.css">
</head>
<body>



<h2 class="TextTyping">図鑑</h2>

<!-- table使い方把握できてないのでSCCの時に合わせて変えてくださいごめんなさい
　　　　キャラクターの画像と番号表示 -->
<table class="rank">
<c:forEach var="e" items="${userid}" varStatus="i">
<c:if test="${(i.index+1)%4==0}" var="flg"/>
<c:if test="${!flg}">
<c:if test="${(i.index+1)%4==1}">
<tr>
</c:if>
<td>
<img src="./img/characters/${e.charpic}"style = "max-width:250px;">
<c:out value="${e.charid}"/>


</td>
<c:if test="${flg}">
<td>
<img src="./img/characters/${e.charpic}"style = "max-width:250px;">
<c:out value="${e.charid}"/>
</td>
</tr>
</c:if>

</c:if>
</c:forEach>
</table>

<input type="button" onclick="history.back()" value="部屋に戻る">
<!-- <input type="submit" value="部屋に戻る"> -->

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
<style>

</style>
</html>