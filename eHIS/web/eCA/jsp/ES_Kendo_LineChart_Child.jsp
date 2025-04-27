<!DOCTYPE html>
<!--
Created By: D. Sethuraman 
Created Date: 21/01/2013
Used for: This page will be included to draw the line chart using Kendo Line Chart component.
Called from: CA module to display the line chart for the vitals, investigation results when more than one observations or results are available.
This page requires Seven parameters 
1. divID: To be used as div ID for each line chart to be drawn.
2. yAxisMin: Integer value of Y-Axis minimum
3. yAxisMax: Integer Value of Y-Axis Maximum
4. xAxisdataType: String Data of X-Axis data type
5. yAxisdataType: String Data of Y-Axis data type
6. splitRange: String value contains the ranges (From, To and Color).
7. valuesRange: String value contains the ranges (xAxis and yAxis values).

Example: "../../eCA/jsp/ES_Kendo_LineChart_Child.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange;
-->

<%@page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
	
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String divID="";
	//int  yAxisMin=0, yAxisMax=0;
	double  yAxisMin=0.0, yAxisMax=0.0;
	String xAxisDataType="", yAxisDataType="";
	String splitRange ="";
	String valuesRange ="";

	divID = request.getParameter("divID");	
	//yAxisMin = Integer.parseInt(request.getParameter("yAxisMin"));		
	//yAxisMax = Integer.parseInt(request.getParameter("yAxisMax"));
	yAxisMin = Double.parseDouble(request.getParameter("yAxisMin"));		
	yAxisMax = Double.parseDouble(request.getParameter("yAxisMax"));
	System.out.println(" ::: yAxisMin ::: "+yAxisMin+" :::: yAxisMax :::: "+yAxisMax);
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	System.out.println(" ::: xAxisDataType ::: "+xAxisDataType+" :::: yAxisDataType :::: "+yAxisDataType);
	splitRange = request.getParameter("splitRange");
	System.out.println(" ::: splitRange ::: "+splitRange);
	splitRange = splitRange.replace('>', '#');	
	valuesRange = request.getParameter("valuesRange");
	
	System.out.println(" ::: splitRange ::: "+splitRange+" ::: valuesRange ::: "+valuesRange);

%>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>
<script src="../../eCA/js/ES_Kendo.js"  type="text/javascript"></script>
<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
<link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />

<div id="<%= divID%>"></div>
<script>             
	
	$(document).ready(function() {
		setTimeout(function() {
			// Initialize the chart with a delay to make sure
			// the initial animation is visible
			createChart("#<%= divID%>",<%= yAxisMin%>,<%= yAxisMax%>,"<%= xAxisDataType%>","<%= yAxisDataType%>","<%= splitRange%>","<%= valuesRange%>");
			

			$("#example").bind("kendo:skinChange", function(e) {
				createChart("#<%= divID%>",<%= yAxisMin%>,<%= yAxisMax%>,"<%= xAxisDataType%>","<%= yAxisDataType%>","<%= splitRange%>","<%= valuesRange%>");	
			});
		}, 800);

		$(".configuration").bind("change", refresh);
	});
	
	function refresh() {
		var chart = $("#<%=divID%>").data("kendoChart"),
			series = chart.options.series,
			categoryAxis = chart.options.categoryAxis,
			baseUnitInputs = $("input:radio[name=baseUnit]"),
			aggregateInputs = $("input:radio[name=aggregate]");

		for (var i = 0, length = series.length; i < length; i++) {
			series[i].aggregate = aggregateInputs.filter(":checked").val();
		};

		categoryAxis.baseUnit = baseUnitInputs.filter(":checked").val();

		chart.refresh();
	}
	$(window).load(function() {		
		setTimeout(function() {
			parent.printPage();
		}, 1000);
	});
</script>




	<style>                
		#<%=divID%> {
			text-align: "left";
			width: 400px;
			height: 232px;   					
		}
	</style>



