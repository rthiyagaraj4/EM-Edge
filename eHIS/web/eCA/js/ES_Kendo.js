/*

Created By: D. Sethuraman 
Created Date: 21/01/2013
Used for: This script will be included in the main JSP page where the Kendo components will be drawn.
Called from: Functions available in the script will be called to re-draw the Kendo linear gauge and line chart component.

Function		Used For		Parameters
----------------------------------------------------------------------------------------
createGauge		Linear Gauge	gaugeDiv, pValue, xAxisMin, xAxisMax, splitRange  
createChart		Line Chart		gaugeDiv, yAxisMin, yAxisMax, xAxisDataType, yAxisDataType, splitRange, valuesRange
*/

	//function createLinear(gaugeDiv, pValue, xAxisMin, xAxisMax, rCriticalLow, rNormalLow, rLowColor, rNormalLow, rNormalHigh, rNormalColor, rNormalHigh, rCriticalHigh, rHighColor  ) {
	function createBar(gaugeDiv, pValue, xAxisMin, xAxisMax, splitRange ) {

		var majorUnit = (xAxisMax - xAxisMin)/5;
		
		var objSeries = [];
		
		var ranges = null;
		
		var rangeArray = splitRange.split("@");		
		
		for (var x=0; x<rangeArray.length; x++)
		{		
			ranges = rangeArray[x].split("~");					
		}
		
		var linearRange=new Array(rangeArray.length);
		for (var i=0; i <rangeArray.length; i++)
			linearRange[i]=new Array(3);		
		
		for (var x=0; x<rangeArray.length; x++)
		{						
			ranges = rangeArray[x].split("~");			
			for (var y=0;y<ranges.length;y++){				
				linearRange[x][y] =  ranges[y];								
			}			
			
		}		
		
		for (var i=0;i<linearRange.length;i++)
		{			
			objSeries.push({ "from": linearRange[i][0], "to": linearRange[i][1], "color": linearRange[i][2]});		
		}		
		
		var ranges1 = objSeries;
		
		$(gaugeDiv).kendoLinearGauge({
			renderAs: "canvas",
			theme: $(document).data("kendoSkin") || "default",
			pointer: {
				value: pValue,
				shape: "arrow",
				size: 15,
				color: "#000000"
			},
			scale: {
				majorUnit: majorUnit,
				minorUnit: 1,				
				min: xAxisMin,
				max: xAxisMax,				
				vertical:0,	
				ranges: ranges1,
				minorTicks: {visible: false},				
				line: {color:"#CCCCCC", width: 10}
			},
			transitions: false
		});
		/*
		var gauge = $(gaugeDiv).data("kendoLinearGauge");
		var image = gauge.imageDataURL();
		var iFrameID = gaugeDiv.substring(1,gaugeDiv.length);		
		document.getElementById(iFrameID).src = image;
		*/

	}	

	function createChart(gaugeDiv, yAxisMin, yAxisMax, xAxisDataType, yAxisDataType, splitRange, valuesRange) {
		
		var objSeries = [];
		
		var ranges = null;
		
		var rangeArray = splitRange.split("@");	
		
		var xType = "";
		
		for (var x=0; x<rangeArray.length; x++)
		{		
			ranges = rangeArray[x].split("~");					
		}
		
		var linearRange=new Array(rangeArray.length);
		for (var i=0; i <rangeArray.length; i++)
			linearRange[i]=new Array(3);		
		
		for (var x=0; x<rangeArray.length; x++)
		{						
			ranges = rangeArray[x].split("~");			
			for (var y=0;y<ranges.length;y++){				
				linearRange[x][y] =  ranges[y];								
			}			
			
		}		
		
		
		for (var i=0;i<linearRange.length;i++)
		{
			//objSeries.push({ "from": linearRange[i][0], "to": linearRange[i][1], "opacity": 100, "color": linearRange[i][2]});		
			objSeries.push({ "from": linearRange[i][0], "to": linearRange[i][1], "opacity": 0.25, "color": linearRange[i][2]});		
		}		
		
		var ranges1 = objSeries;

		var valuesArray = valuesRange.split("@");	
		
		var objSeries = [];

		var values = null;

		for (var x=0; x<valuesArray.length; x++)
		{		
			values = valuesArray[x].split("~");					
		}

		var lineRange=new Array(valuesArray.length);

		for (var i=0; i <valuesArray.length; i++)
			lineRange[i]=new Array(3);		
		
		for (var x=0; x<valuesArray.length; x++)
		{						
			values = valuesArray[x].split("~");			
			for (var y=0;y<values.length;y++){				
				lineRange[x][y] =  values[y];				
			}				
		}	
		
		var xAxis = new Array(lineRange.length);

		for (var i=0;i<lineRange.length;i++)
		{
			xAxis[i] = lineRange[i][0];
		}
		
		var yAxis = new Array(lineRange.length);
		
		for (var i=0;i<lineRange.length;i++)
		{
			yAxis[i] = lineRange[i][1];
			
			if (splitRange.length==0){
				if (yAxisMin == 0)
					yAxisMin = Math.round(parseInt(lineRange[i][1])-(0.10*parseInt(lineRange[i][1])));
				
				if (yAxisMin>=lineRange[i][1])
					yAxisMin = Math.round(parseInt(lineRange[i][1])-(0.10*parseInt(lineRange[i][1])));
				
				if (yAxisMax == 0)
					yAxisMax = Math.round(parseInt(lineRange[i][1])+(0.10*parseInt(lineRange[i][1])));
				
				if (yAxisMax<=lineRange[i][1])				
					yAxisMax = Math.round(parseInt(lineRange[i][1])+(0.10*parseInt(lineRange[i][1])));
			}
			
		}	
		
		var dateFormat = "";
		var xAxisType = "";
		var addedDate = "";
		
		if (xAxisDataType == "D")
		{
			xAxisType = "Date";
			
			for (var i=0; i < xAxis.length; i++) 
			{			
				addedDate = "";
				//xAxis[i] = xAxis[i] + ":00";
				addedDate = new Date(xAxis[i]);	
				xAxis[i] = formatDate(addedDate);
				//alert(" * * * xAxis["+i+"]: "+xAxis[i] +" *");
			}
			
			dateFormat =  "d/M/yyyy";

		}
		if (xAxisDataType == "D")
		{
			xType = "date";
		}

		$(gaugeDiv).kendoChart({	
			renderAs: "canvas",
			theme: $(document).data("kendoSkin") || "default",
			title: {
				text: ""
			},
			legend: {
						position: "bottom"

					},
			series: [{
				type: "line",
				data: yAxis, //y
				//categoryField: "date",
				labels: {
					// label template
					template: "#= value #",
					visible: true,
					border: {
						color: "#FF6600",
						width: 2
					},
					padding: 5
					
				 }

			}],
			transitions: false,
			categoryAxis: {
				//type: "date",	
				//baseUnit: "days",				
				title: {
					text: xAxisType,
					font: "14px verdana, geneva, sans-serif",
					color: "#3333CC"
				},
				majorTicks: {
					visible: false
				},
				line:{
					width:2
				},
				labels: {					
					dateFormats: {						
						days: dateFormat
					}					
				},		
				categories: xAxis
			},
			valueAxis: {
				min:yAxisMin,
				max:yAxisMax,
				title: {
					text: yAxisDataType,
					font: "14px verdana, geneva, sans-serif",
					color: "#3333CC"
				},
				majorTicks: {
					visible: false
				},
				line:{
					width:2
				},
				plotBands: ranges1
			}
		});
		/*
		var chart = $(gaugeDiv).data("kendoChart");
		var image = chart.imageDataURL();

		var iFrameID = gaugeDiv.substring(1,gaugeDiv.length);		
		document.getElementById(iFrameID).src = image;
		*/
		
	}
	
	function formatDate (d){
		var year = d.getFullYear();
		var month = d.getMonth();
	    var day = d.getDate();
	    
	    var hours = d.getHours();
	    var min = d.getMinutes();
	    var sec = d.getSeconds(); 
	    
	    month = month + 1;

	    month = month + "";

	    if (month.length == 1)
	    {
	        month = "0" + month;
	    }

	    day = day + "";

	    if (day.length == 1)
	    {
	        day = "0" + day;
	    }
	    
	    min = min + "";

	    if (min.length == 1)
	    {
	    	min = "0" + min;
	    }
	    
	    sec = sec + "";

	    if (sec.length == 1)
	    {
	    	sec = "0" + sec;
	    }

	    return day + '/' + month + '/' + year +' ' + hours + ':' + min ;

		
	}
	
	

   

