<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Pie</title>
</head>
<body>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/exporting.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/highcharts.js"></script>
<script type="text/javascript">
$(document).ready(function () {
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
            data: getUserPieData()
        }]
    });
    
    function getUserPieData(){
    	var pieData = new Array();
    	$.ajax({
    		url : '<%=request.getContextPath()%>/user/pieData',
    		async : false,
    		type : 'GET',
    		success : function(data){
    			for(var i = 0 ; i < data.length; i++){
    				pieData.push(data[i]);
    			}
    		},
    		error : function(data){
    			console.log('Something error!');
    		}
    	});
    	return pieData;
    }
});
</script>
</body>
</html>