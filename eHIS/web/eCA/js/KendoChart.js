function createChart(gaugeDiv, legendName, yAxisMin, yAxisMax, xAxisTitle, yAxisTitle, xAxisDataType, yAxisDataType, splitRange, valuesRange) {
		
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
		
		var addedDate = "";
		
		if (xAxisDataType == "D")
		{				
			dateFormat =  "d/M/yyyy";

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
				name: legendName,
				labels: {
					// label template
					template: "#= value #",			
					visible: true 
					/* display with broder in pointer					
					border: {
						color: "#FF6600",
						width: 2
					},
					padding: 5
					*/
				}
			}],
			transitions: false,
			categoryAxis: {
				//type: "date",	
				//baseUnit: "days",				
				title: {
					text: xAxisTitle,
					font: "14px verdana, geneva, sans-serif",
					color: "#3333CC"
				},
				majorTicks: {
					visible: true
				},
				line:{
					width:2
				},
				labels: {					
					rotation: -90,
					dateFormats: {						
						days: dateFormat
					}					
				},		
				categories: xAxis,
				justified: true
			},
			valueAxis: {
				min:yAxisMin,
				max:yAxisMax,
				//majorUnit: 30,
				title: {
					text: yAxisTitle,
					font: "14px verdana, geneva, sans-serif",
					color: "#3333CC"
				},
				majorTicks: {
					visible: true
				},
				line:{
					width:2
				},
				plotBands: ranges1
			},
			 tooltip: {
                    visible: true,
                    format: "{0}%",
                    template: "#= series.name #: #= value #"
                }
		});
		
		
	}


