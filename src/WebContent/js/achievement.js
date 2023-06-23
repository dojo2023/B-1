'use strict';


// 円グラフの表示
let lineCtx = document.getElementById("Chart");

let lineConfig = {
	type: 'pie',
	data: {
		labels: labelsData,

		datasets: [{
			label: '金額',
			data: datasValue ,
			backgroundColor:['#66cdaa','#ffd700','#ffc6c1','#fffff2','#f2ffff','#f3ffff','#ff4fff','#ff5fff','#ffff6f'],

		}],
	},
	options: {

	},
};
let lineChart = new Chart(lineCtx, lineConfig);