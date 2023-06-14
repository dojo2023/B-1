<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<!-- ↓共通部分（ｃｓｓとタイトル名は変更してください）-->
<title>カレンダー|かけいぼっち</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/calendar.css">
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




<!-- ↓カレンダー画面 -->カレンダー画面さん
  <div class="calendar-container">
    <h1>October 2020</h1>
    <table class="calendar">
      <tr>
        <th>SUN</th>
        <th>MON</th>
        <th>TUE</th>
        <th>WED</th>
        <th>THU</th>
        <th>FRI</th>
        <th>SAT</th>
      </tr>
      <tr class="day">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>1</td>
        <td>2</td>
        <td>3</td>
      </tr>
      <tr class="day">
        <td>4</td>
        <td>5</td>
        <td>6</td>
        <td>7</td>
        <td>8</td>
        <td>9</td>
        <td>10</td>
      </tr>
      <tr class="day">
        <td>11</td>
        <td>12</td>
        <td>13</td>
        <td>14</td>
        <td>15</td>
        <td>16</td>
        <td>17</td>
      </tr>
      <tr class="day">
        <td>18</td>
        <td>19</td>
        <td>20</td>
        <td>21</td>
        <td>22</td>
        <td>23</td>
        <td>24</td>
      </tr>
      <tr class="day">
        <td>25</td>
        <td>26</td>
        <td>27</td>
        <td>28</td>
        <td>29</td>
        <td>30</td>
        <td>31</td>
      </tr>
    </table>
  </div>
<!-- ↑カレンダー図 -->

<p>目標：<input type="text" name="gwant"></p>
						<!--欲しいもの↑-->

<p><input type="text" name="glimit から今日を引いた日数"><p/>


<!-- 背景の真ん中にキャラクターを表示する -->

<!-- 背景画像の下に現在の貯金額<input type="text" name="bbank">を表示させる -->

<!-- 現在の貯金額の右に目標金額<input type="text" name="ggoal">を表示させる -->
<!-- ↓共通部分 -->
<footer>
<p>&copy;Ifrit.B</p>
</footer>
<!-- ↑共通部分 -->



</body>
</html>