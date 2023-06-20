'use strict';

// 円グラフの表示
let lineCtx = document.getElementById("Chart");
let lineConfig = {
	type:'pie',
	data: {
		labels: ['食費','娯楽費','医療費','交際費'],
		datasets:[{
			label: 'blue',
			data:[2500,4000,800,5000],
			backGroundColor: 'yellow'
		}]
	}
};
let lineChart = new Chart(lineCtx, lineConfig);
