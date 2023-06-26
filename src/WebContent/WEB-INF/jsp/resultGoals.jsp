<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--↓　共通部分　-->
<title>目標達成|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/resultGoals.css">

</head>
<body>
    <header>
        <h1>かけいぼっち</h1>
    </header>
    <!--↓　目標達成か失敗かのテキスト　-->
    <h2><c:out value="${result}" /></h2>

    <!--↓　目標達成か失敗かの画像　-->
	<img src="./img/characters/${c_name}"style = "max-width:250px;">


    <p>次の目標を決めませんか？</p>

    <input type="button" onclick="location.href='/Ifrit/setGoalsServlet'" value="はい">
    <input type="button" onclick="location.href='/Ifrit/loginServlet'" value="いいえ">

    <footer>
        <p>&copy;Ifrit.B</p>
    </footer>
</body>
</html>


