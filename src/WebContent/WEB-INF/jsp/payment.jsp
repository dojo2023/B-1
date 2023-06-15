<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>支出入力|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/payment.css">
</head>
<body>

<header>

<h1>かけいぼっち</h1>
<nav class="menu">
<ul>
	<li>カレンダー</li>
	<li>達成状況</li>
	<li>投稿</li>
	<li>お部屋</li>
	<li>ランキング</li>
	<li>ログアウト</li>
</ul>
</nav>

</header>

<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->

<p>今日の日付表示</p>

<p>今日使えるお金<c:out value="${gavailable}"/>円</p>

<form method="POST" action="/Ifrit/paymentServlet">
<select name="paymentCategory">
	<option value="">カテゴリー選択</option>
	<option value="food">食費</option>
	<option value="eatingout">外食費</option>
	<option value="transportation">交通費</option>
	<option value="householditem">日用品</option>
	<option value="dress">衣服</option>
	<option value="medicalcare">医療費</option>
	<option value="cosmetic">美容費</option>
	<option value="pet">ペット費用</option>
	<option value="entertainment">娯楽費</option>
</select>

<label>支出の入力</label>
<p><input type="text" name="paymoney">円</p>

<input type="submit" value="登録">
</form>

<table>
<tr>
<td><c:out value="${createdat}"/></td>
<td><c:out value="${paycategory}"/></td>
<td><c:out value="${paymoney}"/></td>
</tr>
</table>

<p>支出の合計<c:out value="${paymoney}"/>円</p>

<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

</body>
</html>