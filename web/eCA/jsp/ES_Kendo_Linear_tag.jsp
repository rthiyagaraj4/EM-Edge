<!DOCTYPE html>
<!--
Created By: D. Sethuraman
Created Date: 21/01/2013
Used for: This page will be included to draw the Linear Gauge chart using Kendo Line Chart component.
Called from: CA module to display the Linear Gauge for the vitals, investigation results with one observations or result is available.
This page requires eleven parameters
1. divID: String to be used as div ID for each line chart to be drawn.
2. xAxisMin: Integer value to be used as minimum starting point of linear gauge 
3. xAxisMax: Integer value to be used as maximum point to be plotted in the linear gauge.
4. rCriticalLow: Integer value to be used to point the range critical low value
5. rNormalLow: Integer value to be used to point the range normal low value
6. rNormalHigh: Integer value to be used to point the range normal high value
7. rCriticalHigh: Integer value to be used to point the range critical high value
8. rLowColor: String value to be used to display the range low color 
9. rNormalColor: String value to be used to point the range normal color
10. rHighColor: String value to be used to point the range high color
11. pValue: Integer value to be used to point the actual result value

Example: "../../eCA/jsp/ES_Kendo_Linear.jsp?divID="+divID+"&xAxisMin="+xAxisMin+"&xAxisMax="+xAxisMax+"&rCriticalLow="+rCriticalLow+"&rNormalLow="+rNormalLow+"&rLowColor="+rLowColor+"&rNormalHigh="+rNormalHigh+"&rNormalColor="+rNormalColor+"&rCriticalHigh="+rCriticalHigh+"&rHighColor="+rHighColor+"&pValue="+pValue;
-->

<%@page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>  
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";
	String splitRange = "";	
	
	divID = request.getParameter("divID");
	
	xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));	
	
	splitRange = request.getParameter("splitRange");

	System.out.println(" - - inside ES_Kendo_Linear - - "+splitRange);	
	/*
	rCriticalLow = Integer.parseInt(request.getParameter("rCriticalLow"));
	rNormalLow = Integer.parseInt(request.getParameter("rNormalLow"));
	rNormalHigh = Integer.parseInt(request.getParameter("rNormalHigh"));
	rCriticalHigh = Integer.parseInt(request.getParameter("rCriticalHigh"));
	rLowColor = request.getParameter("rLowColor");
	rNormalColor = request.getParameter("rNormalColor");
	rHighColor = request.getParameter("rHighColor");
	*/
	pValue = Integer.parseInt(request.getParameter("pValue"));	
	
%>		
		<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
		<link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />

		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>

<!--<div id="<%= divID%>"></div>-->      
<div id="gauge-container">
	<kendo:linearGauge name="gauge">
		<kendo:linearGauge-pointer value="28" />
		<kendo:linearGauge-scale minorUnit="2" majorUnit="20" min="-40" max="60">
			<kendo:linearGauge-scale-ranges>
				<kendo:linearGauge-scale-range from="-40" to="-20" color="#2798df" />
				<kendo:linearGauge-scale-range from="30" to="45" color="#ffc700" />
				<kendo:linearGauge-scale-range from="45" to="60" color="#c20000" />
			</kendo:linearGauge-scale-ranges>
		</kendo:linearGauge-scale>
	</kendo:linearGauge>
</div>          

<style>
		#gauge-container {
        	background: transparent url("../../eCA/Kendo/gauge/linear-gauge-container-h.png") no-repeat 50% 50%;
            padding: 18px;
            width: 300px;
            height: 300px;
            text-align: center;
            margin: 0 auto;
        }

        #gauge {
            height: 300px;
            display: inline-block;
            *display: inline;
            zoom: 1;
        }

</style>

