<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
	String selectedRecord = "" ;
    String totalRecords = "" ;
    String eventCode = "";
    String desc = "";
    String normalLow = "";
    String normalHigh = "";
    String yAxisTitle = "";
    int currentPageNumber = 0;
    int nTotalRecords = 0;
    
    
    if(request.getParameter("SR") != null)
    {
    	selectedRecord = request.getParameter("SR");
    }
    if(request.getParameter("TR") != null)
    {
    	totalRecords = request.getParameter("TR");
    	if(!request.getParameter("TR").equals(""))
    	{
    		try
    		{
    			nTotalRecords = Integer.parseInt(request.getParameter("TR"));
    		}
    		catch(Exception e)
    		{
    			nTotalRecords = 0;
    		}
    	}
    }
    if(request.getParameter("SEC") != null)
    {
    	eventCode = request.getParameter("SEC");
    }
    if(request.getParameter("NL") != null)
    {
    	normalLow = request.getParameter("NL");
    }
    if(request.getParameter("NH") != null)
    {
    	normalHigh = request.getParameter("NH");
    }
    if(request.getParameter("DESC") != null)
    {
    	desc = request.getParameter("DESC");
    }
    if(request.getParameter("TI") != null)
    {
    	yAxisTitle = request.getParameter("TI");
    }
    if(request.getParameter("PNO") != null && !request.getParameter("PNO").equals(""))
    {
    	try
    	{
    		currentPageNumber = Integer.parseInt(request.getParameter("PNO"));
    	}
    	catch(Exception e)
    	{
    		currentPageNumber = 0;
    	}
    }
%>
<!DOCTYPE html>
<html>
<head>
   <meta name="apple-mobile-web-app-capable" content="yes" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
   <link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
   <link rel="stylesheet" href="${path}/eIPAD/css/kendo.dataviz.min.css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
   <script src="${path}/eIPAD/kendo.dataviz.min.js"></script>
   <script src="${path}/eIPAD/console.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
   <link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
   <link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
   <style>
   

   </style>
   <script>
   var xAxis = [];
   var yAxis = [];
   var normalLow = 0;
   var normalHigh = 0;
   var valueAxisTitle = "";
   document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
   function setYAxisTitle()
   {
	   var tempTitle = $('#hdnVT').val();
	   if(tempTitle != null && tempTitle != ""){
		   valueAxisTitle = "Values in " + tempTitle;
	   }
   }
   function setNormalValues()
   {
	   var nl = $('#hdnNL').val();
	   var nh = $('#hdnNH').val();
	   if(nl != null && nl != "" && nh != null && nh != "")
		 {
		     normalLow = parseInt(nl);
		     normalHigh = parseInt(nh);
		  }
   }
   function createChart() {
	   var scatterChartData = [];
	   for(i=0;i<xAxis.length;i++){
		   var xyPair = [new Date(xAxis[i]),yAxis[i]];
		   scatterChartData.push(xyPair);
	   }
	   //alert(scatterChartData);

       $("#lineChart").kendoChart({
           title: {
               text: ""
           },
           legend: {
               position: "bottom"
           },
           chartArea: {
               background: ""
           },
           seriesDefaults: {
               
               style: "smooth"
           },
           series: [{
        	   type: "scatterLine",
        	   data: scatterChartData,
        	   
        	   markers: {
                   size: 10
               }
                
           }],
           valueAxis: {
               labels: {
                   format: "{0:d}" 
               },
               title: {
            	      text: valueAxisTitle ,
            	      font: "12px Arial",
            	      rotation: -90
            	    },
              
               line: {
                   visible: false
               },
               axisCrossingValue: -10
           },
           categoryAxis: {
        	   labels: {
        		      rotation: 95
        		    },
                
               axisCrossingValue: -10,
               baseUnitStep: "auto",
             

               majorGridLines: {
                   visible: false
               }
           },
           xAxis: {
        	    type: "date",
        	    baseUnit: "days",
        	    labels: {
        	        dateFormats: {
        	          days: "MMM-d"
        	        }
        	      }
		  },
          yAxis: {
        	   
                plotBands: [
                          { from: normalLow, 
                        	  to: normalHigh , 
                        	  color: "Green", 
                        	  opacity: 0.4 }
                        ]
              },
           tooltip: {
               visible: true,
               format: "Date:{0:dd-MMM-yy HH:mm}<br>Value:{1}",
           }
       });
   }
   $(document).ready(function () {
	  
	  // alert(yAxis);
	  
	  
	  try
	  {
		   xAxis = window.parent.getXAxis();
		   yAxis = window.parent.getYAxis();
		   setNormalValues();	
		   setYAxisTitle();
	       createChart();
	  }
	  catch(e)
	  {
		  alert(e);
	  }
   });
   function closeLineChart()
   {
	   window.parent.closeLineChart();
   }
   function navigatePage(action)
   {
	 
	 //  alert("hi");
	 /*
	 alert(action);
	   var selectedRecord = $('#hdnSelectedRecord').val();
	   //if(isNaN(selectedRecord))
		 //  {
		       alert("sele");
		   		var rowCount = parseInt(selectedRecord);
		   		if(action == "Next")
		   		{
		   			rowCount = rowCount + 1;	
		   		}
		   		else
		   			{
		   		  rowCount = rowCount - 1;	
		   			}
		   		window.parent.paginateLineChart(rowCount) ;
		//   }
	   */
	   var eventCode = $('#hdnEventCode').val();
	   window.parent.paginateLineChart(eventCode,action);
	 
	   
   }
   </script>
</head>
<body style = "padding :0px;display : block;margin: 0px; height: 100%; width: 100%;">
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<div data-role = "none" class = "lineChartTitle" onclick = "closeLineChart()">
			<div data-role = "none" class = "graphTitle">
				<div data-role = "none" class = "dvTitle"> <%=desc %>(<%=yAxisTitle %>) </div>
			</div>
			<div data-role = "none" class = "graphCloseButtonArea">
				<div data-role = "none" class = "graphCloseButton graphCloseButtonTheme">
					<img src = "${path}/eIPAD/images/Close10x10.PNG" style = "position:relative;margin-top:3px;margin-left : 5px"></img>
				</div>
			</div>
		</div>
		<div data-role = "none" class = "graphContainer">
			
			<div data-role = "none" class = "graphArea">
			   <div data-role = "none" class = "navigateIconsContainer" onclick = "navigatePage('Previous')">
				<div data-role = "none" class = "navigateIcons">
					<img src = "${path}/eIPAD/images/ChartLeftArrow.PNG" ></img>
				</div>
			  </div>
				<div data-role = "none" class = "lineChartArea">
					<div data-role = "none" id = "lineChart"></div>
				</div>
			  <div data-role = "none" class = "navigateIconsContainer" onclick = "navigatePage('Next')">
				<div data-role = "none" class = "navigateIcons">
					<img src = "${path}/eIPAD/images/ChartRightArrow.PNG" ></img>
				</div>
			 </div>
				
			</div>
			
		</div>
		<div data-role = "none" class = "graphFooter">
	      <%
	      int nCount =0;
		  String className = "normalPageIcons";
		  for(nCount = 0 ; nCount < nTotalRecords; nCount ++)
		  {
			  if(nCount == currentPageNumber)
			  {
				  className = "selectedPageIcons";
			  }
			  %>
			  <div data-role = "none" class = "<%=className%>" style = "margin-bottom : 5px"></div>
			  <% 
			  className = "normalPageIcons";
		  }
	      %>
		</div>
	</div>
	<input  type = "hidden" name = "hdnSelectedRecord" id = "hdnSelectedRecord" value = "<%=selectedRecord%>"/>
	<input  type = "hidden" name = "hdnTotalRecords" id = "hdnTotalRecords" value = "<%=totalRecords%>"/>
	<input  type = "hidden" name = "hdnEventCode" id = "hdnEventCode" value = "<%=eventCode%>"/>
	<input  type = "hidden" name = "hdnNL" id = "hdnNL" value = "<%=normalLow%>"/>
	<input  type = "hidden" name = "hdnNH" id = "hdnNH" value = "<%=normalHigh%>"/>
	<input type = "hidden" name = "hdnVT" id = "hdnVT" value = "<%=yAxisTitle %>" />
</body>
</html>

