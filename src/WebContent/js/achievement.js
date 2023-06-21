'use strict';


// 円グラフの表示

let lineCtx = document.getElementById("Chart");
// 円グラフの設定
let lineConfig = {
	type: 'pie',
	data: {
		labels: ['食費', '娯楽費', '医療費'],

		datasets: [{
			label: '金額',
			data: [2500, 4000, 800],
			backgroundColor:['#66cdaa','#ffd700','#ffc6c1'],

		}],
	},
	options: {

	},
};
let lineChart = new Chart(lineCtx, lineConfig);

