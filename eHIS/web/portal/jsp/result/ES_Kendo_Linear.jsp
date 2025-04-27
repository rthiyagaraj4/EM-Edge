<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
<%
	int  xAxisMin=0, xAxisMax=0, rCriticalLow=0, rNormalLow=0, rNormalHigh=0, rCriticalHigh=0, pValue=0;
	int majorUnit=0,minorUnit=0;
	String divID="", rLowColor="", rNormalColor="", rHighColor="";

	divID = request.getParameter("divID");	
	
	xAxisMin = Integer.parseInt(request.getParameter("xAxisMin"));
	xAxisMax = Integer.parseInt(request.getParameter("xAxisMax"));
	rCriticalLow = Integer.parseInt(request.getParameter("rCriticalLow"));
	rNormalLow = Integer.parseInt(request.getParameter("rNormalLow"));
	rNormalHigh = Integer.parseInt(request.getParameter("rNormalHigh"));
	rCriticalHigh = Integer.parseInt(request.getParameter("rCriticalHigh"));
	rLowColor = request.getParameter("rLowColor");
	rNormalColor = request.getParameter("rNormalColor");
	rHighColor = request.getParameter("rHighColor");
	pValue = Integer.parseInt(request.getParameter("pValue"));
	majorUnit = Integer.parseInt(request.getParameter("majorUnit"));
	minorUnit = Integer.parseInt(request.getParameter("minorUnit"));
	
%>
			<!--<div id="gauge-container-<%= divID%>">-->
                <div id="<%= divID%>"></div>
            <!--</div>-->

            <script>
                

                $(document).ready(function() {
                    createGauge("#<%=divID%>",<%=pValue%>, <%=xAxisMin%>, <%=xAxisMax%>, <%=rCriticalLow%>, <%=rNormalLow%>, "#<%=rLowColor%>", <%=rNormalLow%>, <%=rNormalHigh%>, "#<%=rNormalColor%>", <%=rNormalHigh%>, <%=rCriticalHigh%>, "#<%=rHighColor%>", <%=majorUnit%>, <%=minorUnit%>);

                    $(".configuration").bind("change", refresh);

                    $(document).bind("kendo:skinChange", function(e) {
                        createGauge("#<%=divID%>",<%=pValue%>, <%=xAxisMin%>, <%=xAxisMax%>, <%=rCriticalLow%>, <%=rNormalLow%>, "#<%=rLowColor%>", <%=rNormalLow%>, <%=rNormalHigh%>, "#<%=rNormalColor%>", <%=rNormalHigh%>, <%=rCriticalHigh%>, "#<%=rHighColor%>", <%=majorUnit%>, <%=minorUnit%>);
						refresh();                        
                    });

                    window.configuredRanges = $("#<%= divID%>").data("kendoLinearGauge").options.scale.ranges;
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

                    gauge.redraw();
                }				
            </script>

            <style>
                #gauge-container-<%= divID%> {
                    text-align: center;
                    margin-left: 30px;
					background: transparent url("../../images/linear-gauge-container-h.png") no-repeat 50% 50%;                   
                    padding: 18px;
                    width: 300px;
                    height: 300px;
                }

                #gauge-container.horizontal {
                    background-image: url("../../images/linear-gauge-container-h.png");
                }

                #<%=divID%> {
					text-align: "left";
                    width: 400px;
                    height: 50px;   					
                }
            </style>
