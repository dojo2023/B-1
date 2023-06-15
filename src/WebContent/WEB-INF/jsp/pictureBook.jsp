<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- ユーザが付けたキャラの名前を表示 -->
<h2><c:out value="${c_name}" />の部屋</h2>

<h3>図鑑</h3>

<!-- table使い方把握できてないのでSCCの時に合わせて変えてくださいごめんなさい
　　　　キャラクターの画像と番号表示 -->
<table>
<c:forEach var="e" items="${charList}" >
<tr>
<td>
		<c:out value="${char_pic}"/><br>
		<c:out value="${char_id}"/>
</td>
</tr>
</c:forEach>
</table>

<input type="submit" value="部屋に戻る">

</header>

<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->
<title>Insert title here</title>
</head>
<body>
図鑑
</body>
</html>