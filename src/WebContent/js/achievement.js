'use strict';

//配列の宣言

let data0 = [];

//各要素へのデータの格納今回はindexによる
data0[0] = document.getElementById("0data").value;
data0[1] = document.getElementById("1data").value;
data0[2] = document.getElementById("2data").value;
data0[3] = document.getElementById("3data").value;
data0[4] = document.getElementById("4data").value;
data0[5] = document.getElementById("5data").value;
data0[6] = document.getElementById("6data").value;
data0[7] = document.getElementById("7data").value;
data0[8] = document.getElementById("8data").value;


// 円グラフの表示
let lineConfig = {
	type: 'pie',
	data: {
		labels: ['食費', '外食費', '交通費','日用品','衣服','医療費','美容費','ペット費','娯楽費'],

		datasets: [{
			label: '金額',
			data: [data0[0],data0[1],data0[2],data0[3],data0[4],data0[5],data0[6],data0[7],data0[8]],
			backgroundColor:['#66cdaa','#ffd700','#ffc6c1','#fffff2','#f2ffff','#f3ffff','#ff4fff','#ff5fff','#ffff6f'],

		}],
	},
	options: {

	},
};
let lineChart = new Chart(lineCtx, lineConfig);