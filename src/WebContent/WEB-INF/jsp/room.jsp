<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--↓　共通部分　-->
<title>キャラクターの部屋　｜　かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/room.css">
</head>

<body>
<header>
    <h1>かけいぼっち</h1>
</header>

<h2><c:out value="${c_name}" />の部屋</h2>

<a href="/Ifrit/calendarServelet"><img src="カレンダー画像" alt="カレンダーへ"></a>
<a href="/Ifrit/paymentServelet"><img src="支出入力画像" alt="支出入力へ"></a>
<a href="/Ifrit/achievementServelet"><img src="達成状況画像" alt="達成状況へ"></a>
<a href="/Ifrit/buytterServelet"><img src="Buytter画像" alt="Butterへ"></a>
<a href="/Ifrit/dressServelet"><img src="着せ替えショップ画像" alt="着せ替えショップへ"></a>
<a href="/Ifrit/pictureBookServlet"><img src="図鑑画像" alt="図鑑へ"></a>

<!--↓　状態にあったキャラ画像表示　-->
<img src="./img/characters/${c_name}">

<!--↓　キャラステータス　-->
<table>
    <tr>
        <td>目標達成度：<c:out value="" /></td>
    </tr>
    <tr>
        <td>出会って<c:out value="" />日目</td>
    </tr>
    <tr>
        <td>状態：<c:out value="" /></td>
    </tr>
    <tr>
        <td>コメント：<c:out value="" /></td>
    </tr>

<!--↓　累計獲得ポイント表示　-->
<h3><c:out value="/${point_pm}" /></h3>

<!--↓　ランキング表示　-->
<a href="/Ifrit/rankingServlet"><img src="ランキング画像" alt="ランキングへ"></a>

</table>


<footer>
    <p>&copy;Ifrit.B</p>
</footer>

</body>
</html>

