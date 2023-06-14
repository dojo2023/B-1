<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>目標設定|かけいぼっち</title>

<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/setGoals.css">

</head>
<body>
<header>
<h1>かけいぼっち</h1>
</header>
<!-- ↑共通部分（ｃｓｓとタイトル名は変更してください）ここまで -->

</head>
<form method="POST" action="/Ifrit/setGoalsServlet">
<table>
<tr>
<td>
	<label>目標貯金額<br>
	<input type="text" name="ggoal">
	</label>
</td>
</tr>
<tr>
<td>
	<label>使用可能額(家賃・光熱費など固定費は除く)<br>
	<input type="text" name="gavailable">
	</label>
</td>
</tr>
<tr>
<td>
	<label>目標期間<br>
	<input type="date" name="glimit" max="9999-12-31">
	</label>
</td>
</tr>
<tr>
<td>
	<label>ほしいもの・したいこと</label><br>
	<input type="text" name="gwant">
	</label>
</td>
</tr>
<tr>
<td>
	<label><br>
	<input type="file" name="gwantpic" accept="image">
	<!-- acceptでファイルの種類を指定できるかも…？.jpegとか

	画面内に選択した画像が表示される用にするときは以下のコードとJS組み合わせて使用

	 onchange="previewImage(this);" required>
	<img id="preview" src="" style = "max-width:150px;">

	↑↑　　小黒さんからコードもらったやつなので例になります -->
	</label>
</td>
</tr>
<tr>
<td>
	<label>キャラクターの名前を決めてね<br>
	<input type="text" name="cname">
	</label>
</td>
</tr>
<tr>
<td>
	<input type="submit" value="とうろく">
</td>
</tr>
</table>
</form>


<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->

</body>
</html>