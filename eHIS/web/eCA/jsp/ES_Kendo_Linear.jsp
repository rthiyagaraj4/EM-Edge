<!DOCTYPE html>
<!--
Created By: D. Sethuraman 
Created Date: 21/01/2013
Used for: This page will be included to draw the Linear Gauge chart using Kendo Line Chart component.
Called from: CA module to display the Linear Gauge for the vitals, investigation results with one observations or result is available.
This page requires five parameters
1. divID: String to be used as div ID for each line chart to be drawn.
2. xAxisMin: Integer value to be used as minimum starting point of linear gauge. 
3. xAxisMax: Integer value to be used as maximum point to be plotted in the linear gauge.
4. splitRange: String value contains the ranges (From, To and Color).
5. pValue: Integer value to be used to point the actual result value.

Example: "../../eCA/jsp/ES_Kendo_Linear.jsp?divID="+divID+"&xAxisMin="+xAxisMin+"&xAxisMax="+xAxisMax+"&splitRange="+splitRange+"&pValue="+pValue;
-->
<%@page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>  
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	double  xAxisMin=0.0, xAxisMax=0.0, rCriticalLow=0.0, rNormalLow=0.0, rNormalHigh=0.0, rCriticalHigh=0.0, pValue=0.0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";
	String splitRange = "";	
	String strPValue = "";
	
	divID = request.getParameter("divID");	
	//xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	//xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));	
	
	xAxisMin = Double.parseDouble(request.getParameter("xAxisMin"));
	xAxisMax = Double.parseDouble(request.getParameter("xAxisMax"));
	
	splitRange = request.getParameter("splitRange");
	splitRange = splitRange.replace('>', '#');
	//pValue = Integer.parseInt(request.getParameter("pValue"));
	strPValue = request.getParameter("pValue");
	
%>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>
<script src="../../eCA/js/ES_Kendo.js"  type="text/javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
<link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />
<body>			
<div id="<%= divID%>"></div>           

<script>
           
	$(document).ready(function() {	
		setTimeout(function() {
			createBar("#<%=divID%>",<%=strPValue%>, <%=xAxisMin%>, <%=xAxisMax%>, "<%=splitRange%>");
		}, 400);
        $(".configuration").bind("change", refresh);
    });

	
    function refresh() {					
        var gauge = $("#<%=divID%>").data("kendoLinearGauge"),
            showLabels = $("#labels").prop("checked"),
            showRanges = $("#ranges").prop("checked"),
            isVertical = $("#vertical").prop("checked"),
            positionInputs = $("input[name='labels-position']"),
            options = gauge.options;

        options.transitions = false;
        options.scale.labels.visible = showLabels;
        options.scale.vertical = isVertical;
        options.scale.ranges = showRanges ? window.configuredRanges : [];

        $("#gauge-container-<%= divID%>").toggleClass("horizontal", 1);

        gauge.refresh();					
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
        height: 50px;   					
    }				
</style>
</body>
</html>

