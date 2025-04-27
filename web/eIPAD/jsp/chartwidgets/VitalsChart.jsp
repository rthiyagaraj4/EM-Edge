<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.healthobject.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
VitalsConfigResponse oVitalsConfigResponse = null;
CurrentAndHistoryResponse oCurrentAndHistoryResponse = null;
if(request.getAttribute("VitalsConfigResponse") != null)
{
	oVitalsConfigResponse = (VitalsConfigResponse)request.getAttribute("VitalsConfigResponse");
	
}
if(request.getAttribute("CurrentAndHistoryResponse") != null)
{
	oCurrentAndHistoryResponse = (CurrentAndHistoryResponse)request.getAttribute("CurrentAndHistoryResponse");
}
Gson gson =new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
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
   
   <link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
   <link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
   <script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>




</style>
<script>
   document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
   document.addEventListener('DOMContentLoaded', vitalsChartScroll, false);
   var vitalsScroll ;
   var screenOrienttation = "landscape";
   var chartWidth = 670;
   var chartHeight = 462; // to hold the height of the chart container.
   var arrEventCode = []; // to hold the list of event codes for line chart.
   var arrXAxis = []; // to hold the x axis values for the selected discrete measure.
   var arrYAxis = []; // to hold the y axis values for the selected discrete measure. 
   var arrEventCodeIndex = []; // to hold the index of the event code;
   function changeOrientation(orient, EMHFheight)
   {
	   	var CSHFheight = $('#allergyHeader').height();
	   	HFheight = EMHFheight;
	   	screenOrienttation = orient;
	   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
	   	document.getElementById("divcnt").style.height = content_height+"px";
	   
	   	if(screenOrienttation == "landscape") // to display the sfs based on the orientation
		 {
			 
			$('#lineChartContainer').css("left" , "15%");
			$('#lineChartContainer').css("top" , "15%");
		 }
		 else
		 {
		     $('#lineChartContainer').css("left" , "2%");	
		     $('#lineChartContainer').css("top" , "20%");
		 }
		assignVitalsColumnWidth();
	    scrollRefresh();
	   // assignLineChartTop();
   }
   function assignVitalsColumnWidth() // to assign the spark line chart columns during loading and orientation change so that the kendo chart is made to fit for the repective screen size
   {
	    var vitalsTableWidth = 0;
	    $("[data-id = 'table']").each(function(index, value) { 
	    	vitalsTableWidth = $(this).width();
		 });
	    var remainingWidth = vitalsTableWidth - 120;
	    var col1Width = remainingWidth * 0.25 + "px";
	    var col2Width = remainingWidth * 0.75 + "px";
	    $("[data-id = 'col1']").each(function(index, value) { 
			 $(this).css("width" , col1Width);
		 });
	    $("[data-id = 'col2']").each(function(index, value) { 
			 $(this).css("width" , col2Width);
		 });
	    $("[data-id = 'col3']").each(function(index, value) { 
			 $(this).css("width" , "120px");
		 });
   }
   function vitalsChartScroll() {
		 setTimeout(function () {
			 vitalsScroll = new iScroll('divcnt', {
			useTransform: true,
			zoom: false,
			onBeforeScrollStart: function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;

			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
			e.preventDefault();
			}
			});
	}, 1000); 
}
   function scrollRefresh()
   {
    	if(vitalsScroll != null)
   		   vitalsScroll.refresh();
   }
   $(document).ready(function () {
	   parent.setOnLoadContentPaneHeight();
   });
   function cancelTransaction(){
		var path = document.getElementById("hdnPath").value + "/mobile/chartsummary/ChartWidgetsView";
		window.parent.document.getElementById('ChartSummaryIframe').src = path;
	}
   function showMezzaineWindow() // this function is used to show the mezzaine window.
   {
   		$('#dvMez').css("display","block");
   		setTimeout(function() {
   			$("#dvMez").on("click",closeMezzaineWindow);
   		}, 500);
   }
   function closeMezzaineWindow()
   {
   		$('#dvMez').css("display","none");
   		$("#dvMez").off();
   		var popid = $("#dvMez").data("popid");
		$("#"+popid).hide();
   		$("#dvMez").data("popid","");
   	
   }
   function closeLineChart()
   {
	   closeMezzaineWindow();
	   $('#dvLineChart').css("display" , "none");
	   $('#lineChartFrame').attr("src" , "");
	   
   }
   function showLineChartGraph(objContainer) // to show the line chart on clicking of a particular row.
   {
	    showMezzaineWindow();
	    $('#dvLineChart').css("display" , "block");
	    $("#dvMez").data("popid","dvLineChart");
	  //  assignLineChartTop();
	    if(arrEventCode != null && arrEventCode.length > 0 && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)
		{
			var evCode = $(objContainer).attr("data-eventCode");
			var currentPageNumber = $.inArray(evCode, arrEventCode);
				if(currentPageNumber != -1)
				{
				  var selectedIndex = arrEventCodeIndex[currentPageNumber];
				  callLineChart(arrEventCode.length,selectedIndex,evCode,currentPageNumber);
				}
		}
   }
   function paginateLineChart(eventCode,action) // function will be called when next and previous arrow buttons are clicked
   {
	  
	   if(action == "Next")
	   {
		       if(arrEventCode != null && arrEventCode.length > 0  && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)
			   {
			  		 var currentPageNumber = $.inArray(eventCode, arrEventCode);
			  		 if(currentPageNumber != -1)
			  		 {
			  			currentPageNumber = currentPageNumber + 1;
			  				if(currentPageNumber < arrEventCodeIndex.length && currentPageNumber < arrEventCode.length && currentPageNumber >= 0)
			  				{
			  					var evntCode = arrEventCode[currentPageNumber];
								var selectedIndex = arrEventCodeIndex[currentPageNumber];
								callLineChart(arrEventCode.length,selectedIndex,evntCode,currentPageNumber);
			  				}
			  		 }
			   }
	   }
	   if(action == "Previous")
	   {
		       if(arrEventCode != null && arrEventCode.length > 0  && arrEventCodeIndex != null && arrEventCodeIndex.length > 0)
			   {
			  		 var currentPageNumber = $.inArray(eventCode, arrEventCode);
			  		 if(currentPageNumber != -1)
			  		 {
			  			currentPageNumber = currentPageNumber - 1;
			  				if(currentPageNumber < arrEventCodeIndex.length && currentPageNumber < arrEventCode.length && currentPageNumber>= 0)
			  				{
			  					var evntCode = arrEventCode[currentPageNumber];
								var selectedIndex = arrEventCodeIndex[currentPageNumber];
								callLineChart(arrEventCode.length,selectedIndex,evntCode,currentPageNumber);
			  				}
			  		 }
			   }
	   }
	   
   }

   function setAxisArray(rowCount) // to set the x - axis and y - axis value for the selected discrete measure
   {
	  // var XObjArr = JSON.parse($("#hdn" + rowCount).val());
	  // var YObjArr = JSON.parse($("#hdnDate" + rowCount).val());
	  try
	  {
		  var XObjArr = JSON.parse($("#hdnDate" + rowCount).val()); //JSON.parse($("#hdn" + rowCount).val());
		   var YObjArr = JSON.parse($("#hdn" + rowCount).val());
		   clearAxisArray();
		   
		   if(XObjArr != null)
		   {
				var i = 0;
				for(i = 0 ; i < XObjArr.length; i++)
				{
					arrXAxis.push(XObjArr[i].eventDateTime);	
					//alert(XObjArr[i].eventDateTime);
				}
				//alert(arrXAxis.length);
		   }
		   else
		   {
			   arrXAxis = null;
			   arrXAxis = [];
		   }
		   if(YObjArr != null)
		   {
			    var i = 0;
				for(i = 0 ; i < YObjArr.length; i++)
				{
					arrYAxis.push(YObjArr[i].resultNumber);	
					//alert(YObjArr[i].eventDateTime);
				}  
				//alert(arrYAxis.length);
		   }
		   else
			   {
			   		arrYAxis = null;
			   		arrYAxis = [];
			   }
	  }
	  catch(e)
	  {
		//  alert("exception" + e);
	  }
	  
   }
   function clearAxisArray()
   {
	    arrYAxis = null;
  		arrYAxis = [];
  		arrXAxis = null;
	    arrXAxis = [];
   }
   function callLineChart(totalRecords,selectedRecord,selectedEventCode,currentPageNumber)
   {
	    setAxisArray(selectedRecord);
	    var desc = $('#hdnDesc' + selectedRecord).val();
	    var nl = $('#hdnNormalLow' + selectedRecord).val();
	    var nh = $('#hdnNormalHigh' + selectedRecord).val(); 
	    var UOM = $('#hdnUOM' + selectedRecord).val();
        var queryString = "?TR=" + totalRecords + "&SR=" + selectedRecord + "&SEC=" + selectedEventCode + "&TI=" + UOM+"&NL=" + nl + "&NH=" + nh+ "&PNO=" + currentPageNumber+"&DESC=" + desc;
        var path = $('#hdnPath').val() + "/eIPAD/jsp/chartwidgets/LineChart.jsp" + queryString;
        $('#lineChartFrame').attr("src" , path);
        
        
   }
   function assignLineChartTop()
   {
	 //  $('#dvLineChart').css("display" , "none");
	   var lineChartTop = calculateLinchartTop() ;
	   lineChartTop = lineChartTop + "px";
	   var lineChartLeft = calculateLineChartLeft();
	   lineChartLeft = lineChartLeft + "px";
	//   $('#dvLineChart').css("display" , "block");
	   $('#lineChartContainer').css("margin-top", lineChartTop);
	   $('#lineChartContainer').css("margin-left", lineChartLeft);
   }
   function calculateLineChartLeft()
   {
	   
	   var dvLineChartLeft =  $('#dvLineChart').width() -10;
	   //alert(dvLineChartLeft);
	   var lineChartWidth = dvLineChartLeft - chartWidth;
	   var left = 0;
	   if(lineChartWidth > 0)
		   {
		      left = lineChartWidth / 2;
		   }
	   
	   return left;
   }
   function calculateLinchartTop()
   {
	  // alert($('#dvLineChart').height());
	   var dvLineChartheight = $('#dvLineChart').height();  
	   var lineChartHeight = dvLineChartheight - chartHeight;
	   var top = 0;
	   if(lineChartHeight > 0)
	   {
			 top = lineChartHeight / 2;  
	   }
	   return top;
   }
   function getXAxis()
   {
	 //alert(arrXAxis.reverse());
	   return arrXAxis.reverse();
   }
   function getYAxis()
   {
	  //alert(arrYAxis.reverse());
	   return arrYAxis.reverse();
   }
   function getEventCode()
   {
	   return arrEventCode;
   }
   function getDesc()
   {
	   
   }
   </script>
</head>
<body style = "padding :0px;display : block;margin: 0px; height: 100%; width: 100%;">
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name="frmRecordAllergy" id="frmRecordAllergy" id="frmViewCharts" style="width: 100%; height: 100%" >
		     <!-- line chart graph container starts -->
		     <div data-role = "none" id = "dvMez" class = "dvMezzaine" data-popid="" ></div>
			  <div data-role = "none" class = "dvLineChart" id = "dvLineChart">
			 	<div data-role="none" class="lineChartContainer" id="lineChartContainer">
					<iframe id="lineChartFrame" frameborder="0" style="display: block;" scrolling="no" src="" class="popupIFrame"></iframe>
			   </div>
		 	 </div> 
			 <!-- line chart graph container ends -->
			<div id="allergyHeader" class="AllergyHeader" style="padding: 0px"
				data-role="none">
				<table cellpadding="0" cellspacing="0" class="tbAllergyHeader"
					data-role="none">
					<tr class="normalTr">
						<td class="normalTd">
							<div class="RecordAllergyHeader RecordAllergyHeaderTheme">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell" style="width: 99%; text-align: left">
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme"><%=csResBundle.getString("vitals.vitalschartview") %></div>
										</div>
										<div class="AllergyCell" style="width: 1%">
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="vitbuttonContainer">
														</div>
													</div>
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="vitbuttonContainer">
															<div class="WidgetButtonTheme" onclick="cancelTransaction()">
																<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="divcnt" class="divAllergyContent divVitalsContentTheme" style="padding: 0px;" data-role="none">
				<div style="width: 100%; height: auto; overflow: auto" data-role="none">
					<div data-role="none" style="width: 100%; height: auto">
						<%
						if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
						{
							   int nVitalsConfigList = 0;
							   List<VitalsConfig> listVitalConfig = null;
							   if(oVitalsConfigResponse.getListVitalConfig() != null)
							   {
								   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
								   if(oVitalsConfigResponse.getListVitalConfig() != null)
								   		nVitalsConfigList = listVitalConfig.size();
							   }
							   
							   if(nVitalsConfigList > 0)
							   {
								   int nVitalsConfigLoopCount = 0;
								   for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
								   {
										String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
										String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
										
										CurrentAndHistoryDM oCurrentAndHistoryDM = oCurrentAndHistoryResponse.getDiscreteMeasure(eventCode);
										if( DiscreteMeasureDescription != null &&  DiscreteMeasureDescription.length() > 11)
										{
											 DiscreteMeasureDescription =  DiscreteMeasureDescription.substring(0, 8) + "...";
										}
										if(oCurrentAndHistoryDM != null && oCurrentAndHistoryDM.getCurrentDiscreteValue() != null)
										{
											DiscreteValue oCurrentDiscreteValue = oCurrentAndHistoryDM.getCurrentDiscreteValue();
											String eventDescription = oCurrentAndHistoryDM.getEventDescription();
											if(eventDescription != null && eventDescription.length() > 15)
											{
												eventDescription = eventDescription.substring(0, 12) + "...";
											}
											NormalcyIndicator oNormalcyIndicator = oCurrentAndHistoryDM.getNormalcyIndicator(oCurrentDiscreteValue, "S");
											String iConName = oNormalcyIndicator.getSymbolIndicator();
											if(iConName != null && !iConName.equals(""))
											{
												iConName = "B" + iConName;
											}
											else
											{
												//iConName = "BNodata.PNG";
											}
											String resultValue = "";//oCurrentDiscreteValue.getResultNum();
											if(oCurrentDiscreteValue.getResultNum() != null && oCurrentDiscreteValue.getResultString() != null)
											{
												resultValue = oCurrentDiscreteValue.getResultNum().trim() + oCurrentDiscreteValue.getResultString().trim();
											}
											if(resultValue == null || resultValue.equals(""))
											{
												resultValue = "-----";
											}
											//LineChartAxisContainer oLineChartAxisContainer = oSparkLineDM.getLineChartAxisContainer();
											LineChartAxisContainer oLineChartAxisContainer = oCurrentAndHistoryResponse.getChartValues(oCurrentAndHistoryDM);
											if(oLineChartAxisContainer != null && oLineChartAxisContainer.getoGraphYAxisList() != null && oLineChartAxisContainer.getoGraphYAxisList().size() > 0)
											{
												List<GraphYAxis> lstGraphYAxis = oLineChartAxisContainer.getoGraphYAxisList();
												List<GraphXAxis> lstGraphXAxis = oLineChartAxisContainer.getoGraphXAxisList();
												%>
													<div data-role = "none" data-id = "table" class = "vitcontainer" id = "container<%=nVitalsConfigLoopCount%>" data-eventCode = "<%=eventCode%>" onclick = "showLineChartGraph(this)" data-count = "<%=nVitalsConfigLoopCount%>" >
													 	<div data-role = "none" data-id = "col1" class = "vitCol1 vitalsDescription" >
													 		<%=eventDescription %>
													 	</div>
													 	<div data-role = "none" data-id = "col2" class = "vitCol2" >
													 		  <div data-role = "none" style = "position:relative;overflow:hidden;width:100%;direction: rtl; height:100px" id="vitalsChart<%=nVitalsConfigLoopCount%>"></div>
													 	</div>
													 	<div data-role = "none" data-id = "col3" class = "vitCol3">
													 		<div data-role = "none"  class = "currrentVitalsContainer currrentVitalsContainerTheme" >
													 		    <div data-role = "none" class = "vitalsIcon">
													 		    	<img src = "${path}/eIPAD/images/<%=iConName %>" style = "position:relative;margin-top:1px"></img>
													 		    </div>
													 			<div data-role = "none" class = "vitalsValue vitalsValueTheme" style = "overflow:hidden"><%=resultValue%></div>
													 			<div data-role = "none" class = "vitalsUnit vitalsUnitTheme"><%= oCurrentAndHistoryDM.getUOM()%></div>
													 			<div data-role = "none" class = "vitalsDate vitalsDateTheme"><%=oCurrentDiscreteValue.getEventDateTime()%></div>
													 		</div>
													 	</div>
												  </div> 
												  <div class="rowDivider"></div>
												  <input type = "hidden" name = "hdn<%=nVitalsConfigLoopCount%>" id = "hdn<%=nVitalsConfigLoopCount%>" value = '<%=gson.toJson(lstGraphYAxis)%>' />
												  <input type = "hidden" name = "hdnDate<%=nVitalsConfigLoopCount%>" id = "hdnDate<%=nVitalsConfigLoopCount%>" value = '<%=gson.toJson(lstGraphXAxis)%>' />
												  <input type = "hidden" name = "hdnNormalLow<%=nVitalsConfigLoopCount%>" id = "hdnNormalLow<%=nVitalsConfigLoopCount%>" value = "<%=oCurrentAndHistoryDM.getNormalLow() %>" />
												  <input type = "hidden" name = "hdnNormalHigh<%=nVitalsConfigLoopCount%>" id = "hdnNormalHigh<%=nVitalsConfigLoopCount%>" value = "<%=oCurrentAndHistoryDM.getNormalHigh()%>" />
												  <input type = "hidden" name = "hdnDesc<%=nVitalsConfigLoopCount%>" id = "hdnDesc<%=nVitalsConfigLoopCount%>" value = "<%= listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc()%>" />
												  <input type = "hidden" name = "hdnUOM<%=nVitalsConfigLoopCount%>" id = "hdnUOM<%=nVitalsConfigLoopCount%>" value = "<%= oCurrentAndHistoryDM.getUOM()%>" />
												  <script>
												  $(document).ready(function () {
													  var dataYObj<%=nVitalsConfigLoopCount%> = JSON.parse($("#hdn<%=nVitalsConfigLoopCount%>").val());
													  var dataXObj<%=nVitalsConfigLoopCount%> = JSON.parse($("#hdnDate<%=nVitalsConfigLoopCount%>").val());
													  var xyData<%=nVitalsConfigLoopCount%> = [];
													  arrEventCode.push('<%=eventCode%>');
													  arrEventCodeIndex.push(<%=nVitalsConfigLoopCount%>);
													  if(dataYObj<%=nVitalsConfigLoopCount%> != null)
													  {
															for(var i = 0 ; i < dataYObj<%=nVitalsConfigLoopCount%>.length; i++)
															{
																
																var resultNum = dataYObj<%=nVitalsConfigLoopCount%>[i].resultNumber;
																var resultD = new Date(dataXObj<%=nVitalsConfigLoopCount%>[i].eventDateTime);
																var valueXY<%=nVitalsConfigLoopCount%> = [new Date(resultD),resultNum];
														       	  xyData<%=nVitalsConfigLoopCount%>.push(valueXY<%=nVitalsConfigLoopCount%>);
															}
													  }
												    
												   														   
													  $("#vitalsChart<%=nVitalsConfigLoopCount%>").kendoChart({
												      
												           series: [{
												        	   type: "scatterLine",
												        	   data: xyData<%=nVitalsConfigLoopCount%>,
												        	   markers: {
												        		   visible: false 
												               }
												        	   
												           }],
												          
												           xAxis: {
												        	    type: "date",
												        	    baseUnit: "months",
												        	    visible: false
												        	  },
												        
												          
												           yAxis: {
												        	    majorGridLines: {
												        	      visible: false
												        	    },
												           visible: false
												        	  },
												          
												           tooltip: {
												                  visible: true,
												                  format: "{1}",
												                   
												              } 
												       });
												   });
												  
												  </script>
												<% 
											}
										}
								   }
							   }
							   
						}//if
						else
						{
							   StringBuffer strMessage = new StringBuffer("");
							   if(oVitalsConfigResponse != null )
							   {
								   if(oVitalsConfigResponse.getErrorsList() != null)
								   {
									   int size = oVitalsConfigResponse.getErrorsList().size();
									   if(size > 0)
									   {
										   int nErrorCount = 0;
										   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
										   {
											  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
											  if(oVitalsConfigResponse.getErrorsList().get(nErrorCount) != null)
											  {
												  strMessage.append(oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage());
												 // message = message + oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage();
											  }
										   }
									   }
								   }
							   }
							   if(oCurrentAndHistoryResponse != null )
							   {
								   if(oCurrentAndHistoryResponse.getErrorsList() != null)
								   {
									   int size = oCurrentAndHistoryResponse.getErrorsList().size();
									   if(size > 0)
									   {
										   strMessage.append("   ");
										   int nErrorCount = 0;
										   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
										   {
											  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
											  if(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount) != null)
											  {
												  if( oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorType() != Errors.NO_CHART_CONFIGURED)
												  strMessage.append(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage());
												// message = message + oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage();
											  }
										   }
									   }
								   }
							   }
							   %>
							    <div data-role = "none" class="WidgetVwErrContainer">
							   		<div data-role = "none" class="WidgetErrorResponse WidgetErrorResponseTheme">
							   			<%=strMessage.toString() %>
							   		</div>
				   		    	</div>
							   <% 
						}
						%>
					</div>
				</div>
			</div>
			<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
		</form>
	</div>
</body>
</html>

