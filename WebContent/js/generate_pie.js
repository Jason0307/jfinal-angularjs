var InitPie = function () {
  var initPie = function() {
  	 $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Browser market shares at a specific website, 2010'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data:  [
                    {
	                   name: 'Point 1',
					   color: '#00FF00',
					   y: 3
                    }, {
					   name: 'Point 2',
					   color: '#FF00FF',
					   y: 5
					}
                ]
        }]
    });  
}
    
    return {
        init: function () {
            initPie();
        }
    };
}();