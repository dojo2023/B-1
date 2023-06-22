'use strict';

//ここでは1組、9種類のデータを受け取ると仮定して設定する
//配列の宣言

let data = [];

//各要素へのデータの格納今回はindexによる
data[0] = document.getElementById("foods").value; //食費
data[1] = document.getElementById("restaurant").value; //外食費
data[2] = document.getElementById("transport").value; //交通費
data[3] = document.getElementById("dailyitems").value; //日用品
data[4] = document.getElementById("clothes").value; //衣服
data[5] = document.getElementById("medical").value; //医療費
data[6] = document.getElementById("beauty").value; //美容費
data[7] = document.getElementById("pets").value; //ペット費
data[8] = document.getElementById("entertainment").value; //娯楽費


// 円グラフの表示

let lineCtx = document.getElementById("Chart");
// 円グラフの設定
let lineConfig = {
	type: 'pie',
	data: {
		labels: ['foods', 'restaurant', 'transport', 'dailyitems', 'clothes',
		 'medical', 'beauty', 'pets', 'entertainment'],

		datasets: [{
			label: '金額',
			data: [data[0],data[1], data[2],data[3],data[4],data[5],data[6],data0[7],data[8]],
			backgroundColor:['#66cdaa','#ffd700','#ffc6c1'],

		}],
	},
	options: {

	},
};
let lineChart = new Chart(lineCtx, lineConfig);

