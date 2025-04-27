<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,eCA.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>  

<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String divID="";
	int chartWidth=0,chartHeight=0;
	int  yAxisMin=0, yAxisMax=0;
	String xAxisDataType="", yAxisDataType="";
	String xAxisTitle="", yAxisTitle="";
	String splitRange ="";
	String valuesRange ="";
	String legendName = "";
	
	divID = request.getParameter("divID");	
	yAxisMin = request.getParameter("yAxisMin") == null ? 0 :  Integer.parseInt(request.getParameter("yAxisMin"));		
	yAxisMax = request.getParameter("yAxisMax") == null ? 200 :  Integer.parseInt(request.getParameter("yAxisMax"));
	xAxisDataType = request.getParameter("xAxisDataType");
	yAxisDataType = request.getParameter("yAxisDataType");
	splitRange = request.getParameter("splitRange");
	valuesRange = request.getParameter("valuesRange");
	legendName	= request.getParameter("legendName") == null ? "" :  (String)request.getParameter("legendName");
	chartWidth = request.getParameter("chartWidth") == null ? 100 : Integer.parseInt(request.getParameter("chartWidth"));		
	chartHeight = request.getParameter("chartHeight") == null ? 200 : Integer.parseInt(request.getParameter("chartHeight"));
	
	xAxisTitle	=request.getParameter("xAxisTitle")== null ? "" : (String) request.getParameter("xAxisTitle");
	yAxisTitle	= request.getParameter("yAxisTitle")== null ? "" : (String) request.getParameter("yAxisTitle");

%>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCA/Kendo/js/kendo.all.min.js"  type="text/javascript"></script>
		<script src="../../eCA/js/KendoChart.js"  type="text/javascript"></script>
		<link href="../../eCA/Kendo/styles/kendo.common.min.css" rel='stylesheet' />
		<link href="../../eCA/Kendo/styles/kendo.default.min.css" rel='stylesheet' />

			
        <div id="<%= divID%>"></div>
            
			
            <script>             

                $(document).ready(
                   function() {
                        // Initialize the chart with a delay to make sure
                        // the initial animation is visible
                        createChart("#<%= divID%>","<%=legendName%>",<%= yAxisMin%>,<%= yAxisMax%>,"<%=xAxisTitle%>","<%=yAxisTitle%>","<%= xAxisDataType%>","<%= yAxisDataType%>","<%= splitRange%>","<%= valuesRange%>");
						/*
                        $("#example").bind("kendo:skinChange", function(e) {
                            createChart("#<%= divID%>","<%=legendName%>",<%= yAxisMin%>,<%= yAxisMax%>,"<%=xAxisTitle%>","<%=yAxisTitle%>","<%= xAxisDataType%>","<%= yAxisDataType%>","<%= splitRange%>","<%= valuesRange%>");	
                        });
						*/
                    }

                   
                );

                
                
            </script>
            <style>                
				#<%=divID%> {
					text-align: "left";
                    width: <%=chartWidth%>px;
                    height: <%=chartHeight%>px;   					
                }
            </style>

