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
        <td>目標達成度：</td>
    </tr>
    <tr>
        <td>出会って〇日目</td>
    </tr>
    <tr>
        <td>状態：</td>
    </tr>
    <tr>
        <td>コメント：</td>
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














サーブレット
class Sample {
    public static void main(String args[]) {
        Random rand = new Random();
        int num = rand.nextInt(10) + 100;
        System.out.println(0);
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
        System.out.println(7);
        System.out.println(8);
        System.out.println(9);
    }
}

switch (num){
    case 0:System.out.println("喋る前に飲む");

break;
case 1:System.out.println("喋る前に飲む");
break;
case 2:System.out.println("好きな飲み物は、ジンジャーハイボールです");
break;
case 3:System.out.println("人間は失敗をして学習する生き物です");
break;
case 4:System.out.println("今日も一日がんばろう");
break;
case 5:System.out.println("今日も頑張ったね！生きててえらいぞ！");
break;
case 6:System.out.println("ガムを飲み込むと、消化されないらしいよ！");
break;
case 7:System.out.println("日本の歯医者の数はコンビニの数より多い。");
break;
case 8:System.out.println("喉が痛いときにマシュマロを食べると痛みが和らぐ。（ゼラチンが喉を保護してくれるため）");
break;
case 9:System.out.println("プーマとアディダスの創設者は兄弟、そして仲がめっちゃ悪い。");
break;
}