<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--↓　共通部分　-->
<title>キャラクターの部屋　｜　かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/room.css">
<style>* { outline: 1px solid #FF0000; }</style>
</head>

<body>
<header>
    <h1>かけいぼっち</h1>
</header>

<h2><c:out value="${cname}" />の部屋</h2>
<table>
	<tr>
		<td><a href="/Ifrit/calendarServelet"><img src="カレンダー画像" alt="カレンダーへ"></a></td>
	</tr>
	<tr>
		<td><a href="/Ifrit/paymentServelet"><img src="支出入力画像" alt="支出入力へ"></a></td>
	</tr>
	<tr>
		<td><a href="/Ifrit/achievementServelet"><img src="達成状況画像" alt="達成状況へ"></a></td>
	</tr>
	<tr>
		<td><a href="/Ifrit/buytterServelet"><img src="Buytter画像" alt="Butterへ"></a></td>
	</tr>
</table>

<!--↓　状態にあったキャラ画像表示　-->
<img src="./img/characters/${c_name}">


<!--↓　キャラステータス　-->
<table>
    <tr>
        <td>目標達成度：<c:out value="${gratio}" />%</td>
    </tr>
    <tr>
        <td>出会って<c:out value="${meet}" />日目</td>
    </tr>
    <tr>
        <td>状態：<c:out value="${health}" /></td>
    </tr>
    <tr>
        <td>コメント：<c:out value="${comment}" /></td>
    </tr>
    <tr>
		<td><a href="/Ifrit/dressServelet"><img src="着せ替えショップ画像" alt="着せ替えショップへ"></a></td>
	</tr>
	<tr>
		<td><a href="/Ifrit/pictureBookServlet"><img src="図鑑画像" alt="図鑑へ"></a></td>
	</tr>

	<!--↓　累計獲得ポイント表示　-->
	<tr>
		<td id="point_pm">現在の<c:out value="${point_pm}" />PT</td>
	</tr>

	<!--↓　ランキング表示　-->
	<tr>
		<td id="ranking">ランキング<a href="/Ifrit/rankingServlet"><img src="ランキング画像" alt="ランキングへ"></a></td>
	</tr>
</table>


<footer>
    <p>&copy;Ifrit.B</p>
</footer>

</body>
</html>

