<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.results.response.ResultsResponse"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.results.healthobject.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eIPAD.chartsummary.results.request.ResultsCatConstants"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.*"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<script type="text/javascript">
//result values horiz scroller object
var resValuesScroll;
var currentScrollingResultDiv;
var LinkedResPopupScroll;
function assignResValuesScroll(){
		//When the result values are scrolled iscroll object is assigned to this div
	  $('.resItemsWrapperDiv').bind('touchstart click', function(event) { 
		  //alert(currentScrollingResultDiv);
		  var currentDiv = $(this).attr('id');
		  //alert(currentDiv);
		  if(currentScrollingResultDiv){
			  
			  if(currentScrollingResultDiv != currentDiv){
				  resValuesScroll = new iScroll(currentDiv, {
						hScrollbar : false,
						vScroll : false
				});
				currentScrollingResultDiv = currentDiv;
				
			  }
		  }
		  else{
			  currentScrollingResultDiv = currentDiv;
			  resValuesScroll = new iScroll(currentDiv, {
					hScrollbar : false,
					vScroll : false
			});
		  }
		  

		  
	  });  
}
document.addEventListener('DOMContentLoaded', assignResValuesScroll, false);
$(document).ready(function(){
	//Binding the iscroll intiation event to results data cells
	assignResValuesScroll();
	computeResultDataFrameWidth();
	//Assigning the horizontal scroller width to accomodate all the data
	$("[id^='reswiscroller-']").each(function(index,value){
		var colNum = parseInt($(this).data("colnum"));
		if(colNum<10){
			colNum = 10;
		}
		var scrollerWidth = colNum*116;
		//alert(colNum);
		$(this).css("width", scrollerWidth+"px");
	});
	scrollerRefresh(CSMainScroll);
});

var resultsDataFrameWidth;

function computeResultDataFrameWidth(){
	resultsDataFrameWidth = $("#resultDataFrame").width();
	resultLeftColWidth = $(".resultItemsNameCol").width();
	resultRightColWidth = resultsDataFrameWidth - resultLeftColWidth;
	//alert(resultRightColWidth);
	$(".resultItemsDataCol").each(function(index,value){
		$(this).css("width", resultRightColWidth+"px");
	});
}


//This event is fired whenever a message is sent from the parent window
//In case of orientationchange event 'OrientationChange' message is received from the parent iframe
window.addEventListener("message", function(e){
    var msgvalue = e.data;
    //alert(msgvalue); 
    if(msgvalue=='OrientationChange'){
    	computeResultDataFrameWidth();
    	scrollerRefresh(CSMainScroll);
    }
}, false);



function showResNotesPopup(obj,popupId){
	
	var buttonHeight = $(obj).height();
	var buttonWidth = $(obj).width();
	var popupObj = $("#"+popupId);

    
    var popupTitle = $(obj).data("title");
    //alert(encodeURI($(obj).data("linkurl")));
    var url = $(obj).data("linkurl");
    var accessionNum = escape($(obj).data("accessionnum"));
    url = url + accessionNum;
    //alert(url);
    //var linkurl = encodeURI(url);
    //alert(linkurl);
    var scrollerId = popupId+"-scroller";
    var wrapperId = popupId+"-wrapper";
    var contentsId = popupId+"-contents";
    
    //var LinkedResPopupScroll;

    //clearing the contents
    $("#"+contentsId).empty();

    $("#"+popupId+"-title").html(popupTitle);
    
	$(popupObj).show();
	$("#dvMez").show();
	$("#dvMez").data("popid",popupId);
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
	if(LinkedResPopupScroll!=null){
		LinkedResPopupScroll.refresh();
	}
    $("#"+contentsId).load(url, function(){
    	
    	LinkedResPopupScroll = new iScroll(wrapperId, {
    		useTransform : true,
    		zoom : false,
    		onBeforeScrollStart : function(e) {
    			var target = e.target;
    			while (target.nodeType != 1) target = target.parentNode;

    			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' ){
    				e.preventDefault();
    			}

    			e.stopPropagation();
    		}
    	});
    	if(LinkedResPopupScroll!=null){
    		LinkedResPopupScroll.refresh();
    	}
    });

}

function openStrResPopup(obj,popupId){
	
var popupObj = $("#"+popupId);

    
    var popupTitle = $(obj).data("title");
    var data = $(obj).data("resstrvalue");
    var scrollerId = popupId+"-scroller";
    var wrapperId = popupId+"-wrapper";
    var contentsId = popupId+"-contents";
    
    
    //clearing the contents
    $("#"+contentsId).empty();

    $("#"+popupId+"-title").html(popupTitle);
    $("#"+contentsId).html(data);
    
	$(popupObj).show();
	$("#dvMez").show();
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
	$("#dvMez").data("popid",popupId);
	  

/*     $("#"+contentsId).load(linkurl, function(){
    	var LinkedResPopupScroll;
    	LinkedResPopupScroll = new iScroll(wrapperId, {
    		useTransform : true,
    		zoom : false,
    		onBeforeScrollStart : function(e) {
    			var target = e.target;
    			while (target.nodeType != 1) target = target.parentNode;

    			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' ){
    				e.preventDefault();
    			}

    			e.stopPropagation();
    		}
    	});
    	if(LinkedResPopupScroll!=null){
    		LinkedResPopupScroll.refresh();
    	}
    }); */
	
	
}

function showResGraphPopup(obj,popupId){
	
	var buttonHeight = $(obj).height();
	var buttonWidth = $(obj).width();
	var popupObj = $("#"+popupId);

    
    var popupTitle = $(obj).data("title");
    var uom = $(obj).data("uom");
    //var linkurl = encodeURI($(obj).data("linkurl"));
    var scrollerId = popupId+"-scroller";
    var wrapperId = popupId+"-wrapper";
    var contentsId = popupId+"-contents";
    
    //clearing the contents
    $("#"+contentsId).empty();

    $("#"+popupId+"-title").html(popupTitle + " (" + uom+")");
    
	$(popupObj).show();
	$("#dvMez").show();
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
	$("#dvMez").data("popid",popupId);
	var gcategories = $(obj).data("xaxis");
	var gcategories_arr = gcategories.split(",");
	/* var gcategories_arr = $.map(gcategories.split(','), function(value){
	    return parseFloat(value);
	    // or return +value; which handles float values as well
	}); */
	var gdata = $(obj).data("yaxis");
	//alert(gdata);
	//var gdata_arr = gdata.split(",");
	var gdata_arr = $.map(gdata.toString().split(','), function(value){
	    return parseFloat(value);
	});
	
	//show only latest 25 results in graph
	gdata_arr.slice(0, 25);
	gcategories_arr.slice(0,25);
	
	gdata_arr.reverse();
	gcategories_arr.reverse();
	
	var normalLow = 0;
	var normalHigh = 0;
	normalLow = parseFloat($(obj).data("normallow"));
	normalHigh = parseFloat($(obj).data("normalhigh"));
	var uom = $(obj).data("uom");
	var valueAxisTitle = "";
	if(uom){
		valueAxisTitle = "Values in " + uom;
	}
	var chartwidth = $("#CSCommonPopUpContainer").width() - 20; //20 margin
	//alert(gdata_arr);
	
	var scatterChartData = [];
	for(i=0;i<gcategories_arr.length;i++){
	 var xyPair = [new Date(gcategories_arr[i]),gdata_arr[i]];
	 scatterChartData.push(xyPair);
	}
	   //alert(scatterChartData);

	$("#"+contentsId).kendoChart({
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
	         format: "{1}",
	     }
	});
	
	
  
	
    //var LinkedResPopupScroll;
	/* LinkedResPopupScroll = new iScroll(wrapperId, {
		useTransform : true,
		zoom : false,
		onBeforeScrollStart : function(e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;

			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' ){
				e.preventDefault();
			}

			e.stopPropagation();
		}
	});
	if(LinkedResPopupScroll!=null){
		LinkedResPopupScroll.refresh();
	} */
    
    
}

</script>
<style>


</style>

<%
ResultsResponse resultsResponse = (ResultsResponse)request.getAttribute("ResultsResponse");
String groupBy = (String)request.getAttribute("GroupBy");
boolean isSuccessResponse = false;
boolean isEmptyResponse = true;
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
ArrayList<ResultHO> resultHOList = new ArrayList<ResultHO>();

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


if(resultsResponse!=null){
	isSuccessResponse = resultsResponse.isSuccessResponse();
	isEmptyResponse = resultsResponse.isEmptyDataResponse();
	resultHOList = resultsResponse.getResults();
	errorList = resultsResponse.getErrorsList();
	if(resultHOList!=null && !resultHOList.isEmpty())
		isEmptyResponse = false;
}
%> 



<div style="" class="resultDataParent resultDataParentTheme" id="resultDataParent" data-role = "none">
<form id="ResultDataForm" class="ResultDataForm" action="" method="post" name="ResultDataForm" id="ResultDataForm"> 

<% if(isSuccessResponse && !isEmptyResponse) {
	if(groupBy.equals(ResultsCatConstants.GROUPBY_SUBCATEGORY)){
%>
	<div><!-- Results data view starts here -->

	<%
	for(int i=0;i<resultHOList.size();i++){
		ResultHO resultHO = resultHOList.get(i);
		String histRecType = resultHO.getCategoryCode();
		ArrayList<ResultSubCategory> resultSubCategoryList = resultHO.getResSubCat();
		for(int j=0;j<resultSubCategoryList.size();j++){
			ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
			ArrayList<Date> allDates = resultSubCategory.getAllDates();
			ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
			if(!resultGroupItemList.isEmpty()){
				
		
		%>
		<div style="clear: both;"></div>
		<div style="display:table;" class="resultItemsNameCol">
			<div style="display:table-row">
				<div style="display:table-cell;vertical-align:middle;" class="resSubCatLeftRow ResSubCatRowTheme"><div style="" class="resCellDataPad"><%=resultSubCategory.getSubCategoryName() %></div> </div>
			</div>
			<div style="display:table-row">
				<div style="display:table-cell;">
					<div style="" class="resItemsTabColTheme resItemsLeftTabCol">
						<div style="display:table;">
							<%
							String curGroupCode = "";
							for(int a=0;a<resultGroupItemList.size();a++){
								ResultGroupItem resultGroupItem = resultGroupItemList.get(a);
								String groupName = resultGroupItem.getResultGroupName();
								String groupCode = resultGroupItem.getResultGroupCode();
								String resultName = resultGroupItem.getResultName();
								String resultCode = resultGroupItem.getResultCode();
								if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
									
								
							%>
							<div style="display:table-row">
								<div style="display:table-cell;vertical-align:middle;" class="ResGrpItemTheme resItemsLeftRow"><div class="resCellDataPad"><%= groupName%></div> </div>
							</div>
								<%
								}
								String resultRowStyle="ResItemTheme";
								//if there is no group name, then the result row should be in grouprow style
								if(groupCode == null || groupCode.equals("")){
									resultRowStyle="ResGrpItemTheme";
								}
								%>
							
							<div style="display:table-row">
								<div style="display:table-cell;vertical-align:middle;" class="resItemsLeftRow <%=resultRowStyle%>">
									<div style="display:table;width:100%">
										<div style="display:table-row">
											<div style="display:table-cell;vertical-align:middle;" class="resCellDataPad"><%= resultName%></div>
											<% if(resultGroupItem.getResultDataType().equals("NUM")){ %>
											<div style="display:table-cell;vertical-align:middle;" class="resItemsChartImg" onclick="showResGraphPopup(this,'CSCommonPopUpContainer')"
											data-title="<%= resultName%>" data-yaxis="<%=resultGroupItem.getResultValuesCSV() %>" data-xaxis="<%=resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")%>"
											data-uom="<%=resultGroupItem.getResultUom()%>" data-normallow="<%=resultGroupItem.getNormalLow()%>" data-normalhigh="<%=resultGroupItem.getNormalHigh()%>">
											
											<img src="${path}/eIPAD/images/BarChart.png"/></div>
											<%} %>
										</div>
									</div>
								</div>
							</div>
								<%
								curGroupCode = groupCode;
							}%>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	<!-- Data Cells div -->
	<%
		int emptyCellsToPrint = 0;
		if(allDates.size()<10){
			//if the number of cell is less than 10 print empty cell just making the tabular format look neat
			emptyCellsToPrint = 10 - allDates.size();
		}
	%>
		<div class="resItemsWrapperDiv resultItemsDataCol" id="reswiwrapper-<%=resultSubCategory.getSubCategoryCode() %>">
			<div id="reswiscroller-<%=resultSubCategory.getSubCategoryCode()%>" style="" data-colnum="<%=allDates.size()%>">
				<div style="display:table;">
					<div style="display:table-row">
						<div style="display:table">
							<div style="display:table-row">
								<%for(int x=0;x<allDates.size();x++){ 
									Date xDate = allDates.get(x);
									String dateStr = sdf.format(xDate);
								%>
								<div style="display:table-cell;vertical-align:middle;text-align:center" class="resSubCatRightRow ResSubCatRowTheme">
									<div style=:display:table;"><div style="display:table-row"><div style="display:table-cell; vertical-align:middle;text-align:center;" class="resCatHeadInnerCell ResCatHeadInnerTheme"><%=dateStr%></div></div></div>
								</div>
								<%} 
								if(emptyCellsToPrint > 0){
									for(int e=0;e<emptyCellsToPrint;e++){
								%> 
								<div style="display:table-cell;vertical-align:middle;text-align:center" class="resSubCatRightRow ResSubCatRowTheme">
									<div style=:display:table;"><div style="display:table-row"><div style="display:table-cell; vertical-align:middle;text-align:center;" class="resCatHeadInnerCell ResCatHeadInnerTheme"></div></div></div>
								</div>
								<%
									}
								} 
								%>
								
							</div>
						</div>
					</div>
					<div style="display:table-row">
						<div style="display:table-cell;">
							<div style="" class="resItemsTabColTheme resItemsRightTabCol">
								<div style="display:table;"> 
									<%
									String curGroupCode2 = "";
									for(int b=0;b<resultGroupItemList.size();b++){
										ResultGroupItem resultGroupItem = resultGroupItemList.get(b);
										String groupName = resultGroupItem.getResultGroupName();
										String groupCode = resultGroupItem.getResultGroupCode();
										String resultName = resultGroupItem.getResultName();
										String resultCode = resultGroupItem.getResultCode();
										String contSysId = resultGroupItem.getContrSysId();
										String resultDataType = resultGroupItem.getResultDataType();
										String uom = resultGroupItem.getResultUom();
										//ArrayList<ResultValue> resultValueList = resultGroupItem.getResValues();
										ArrayList<ResultValue> resultValueList = resultGroupItem.getResValuesForDates(allDates);
										if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode2)){
										// group header row	-- display empty cells
										
									%>
									<div style="display:table-row"><!-- group name row with empty data cells -->
										<%for(int x=0;x<allDates.size();x++){ %>
										<div style="display:table-cell;" class="resItemsRightCell ResGrpItemTheme"></div>
										<%} %>
										<%if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										%> 
										<div style="display:table-cell;" class="resItemsRightCell ResGrpItemTheme"></div>
										<%
											}
										} %>
									</div>
										
									<%
										}
										curGroupCode2 = groupCode;
											%>
									<div style="display:table-row" class="">
									<%
										String resultRowStyle="ResItemTheme";
									//if there is no group name, then the result row should be in grouprow style
										if(groupCode == null || groupCode.equals("")){
											resultRowStyle="ResGrpItemTheme";
										}
										for(int n=0;n<resultValueList.size();n++){
											
											ResultValue resultValue = resultValueList.get(n);
											if(resultValue.getDate().equals("NULL") && resultValue.getAccessionNum().equals("NULL")) {
												//display empty cell
											%>
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>"></div>
											<% 
											}
											else{
												
												//display data cell
											%>
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>">
													<div style="display:table;width:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemNormIconCell">
																<%
																if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.NORMAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_NORMAL.gif"/></div>
																<%} 
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.ABNORMAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Abnormal.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Critical.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.LOW)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Low.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.HIGH)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_High.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALLOW)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_CriticallyLow.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALHIGH)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_CriticallyHigh.gif"/></div>
																<%} 
																else{ %>
																<div class="" style=""><img src="${path}/eIPAD/images/SNoData.PNG"/></div>
																<%} %>
															</div>
															<%if(resultDataType.equals("NUM")){ %>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemValueCell">
																<div class="ResValueText" style=""><%= resultValue.getDblAsStrValue()%></div>
																<div class="ResUomText"><%=uom %></div>
															</div>
															<%} 
															else if(resultDataType.equals("STR")){
															%>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemValueCell">
																<div class="ResValueText" data-resstrvalue="<%= resultValue.getStrValue()%>" onclick="openStrResPopup(this,'CSCommonPopUpContainer')" data-title="Event Details"><%= resultValue.getStrValue()%></div>
															</div>
															<%} 
															else if(resultDataType.equals("HTM") || resultDataType.equals("TXT")){
															%>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" onclick="showResNotesPopup(this,'CSCommonPopUpContainer')" 
															data-linkurl="${path}/mobile/chartsummary/ResultNotesView?HistRecType=<%=histRecType%>&ContSysId=<%=contSysId%>&ContrSysEventCode=<%=resultCode%>&AccessionNum=" 
															data-title="Event Details" data-accessionnum="<%=resultValueList.get(n).getAccessionNum()%>">
																<div class=""><img src="${path}/eIPAD/images/NoteType.png"/></div>
															</div>
															<%} %>
														</div>
													</div>
												</div>
												
											<% 
											}

										}
										if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										%> 
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>"></div>
										<%
											}
										} 
										%>
									
									</div>
									<%
						
									}%>
									</div>
								</div>
							</div>
						</div>
									 
				</div> 
			</div>
		</div>
		
	<%
		}
	
		}
		}
		%>
		</div>
		<%
		}else{%>
		
		
		<div><!-- Results data view starts here group by category for others category -->

	<%
	for(int i=0;i<resultHOList.size();i++){
		ResultHO resultHO = resultHOList.get(i);
		String histRecType = resultHO.getCategoryCode();
		ArrayList<Date> allDates = resultHO.getAllDates();
		int emptyCellsToPrint = 0;
		if(allDates.size()<10){
			//if the number of cell is less than 10 print empty cell just making the tabular format look neat
			emptyCellsToPrint = 10 - allDates.size();
		}
		ArrayList<ResultSubCategory> resultSubCategoryList = resultHO.getResSubCat(); %>
		
		<div style="clear: both;"></div>
		<div style="display:table;" class="resultItemsNameCol">
			<div style="display:table-row">
				<div style="display:table-cell;vertical-align:middle;" class="resSubCatLeftRow ResSubCatRowTheme"><div style="" class="resCellDataPad"><%=resultHO.getCategoryName() %></div> </div>
			</div>
			<div style="display:table-row">
				<div style="display:table-cell;">
					<div style="" class="resItemsTabColTheme resItemsLeftTabCol">
						<div style="display:table;">
							<%
							for(int j=0;j<resultSubCategoryList.size();j++){
								ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
								ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
								if(!resultGroupItemList.isEmpty()){
							String curGroupCode = "";
							for(int a=0;a<resultGroupItemList.size();a++){
								ResultGroupItem resultGroupItem = resultGroupItemList.get(a);
								String groupName = resultGroupItem.getResultGroupName();
								String groupCode = resultGroupItem.getResultGroupCode();
								String resultName = resultGroupItem.getResultName();
								String resultCode = resultGroupItem.getResultCode();
								if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
									
								
							%>
							<div style="display:table-row">
								<div style="display:table-cell;vertical-align:middle;" class="ResGrpItemTheme resItemsLeftRow"><div class="resCellDataPad"><%= groupName%></div> </div>
							</div>
								<%
								}
								String resultRowStyle="ResItemTheme";
								//if there is no group name, then the result row should be in grouprow style
								if(groupCode == null || groupCode.equals("")){
									resultRowStyle="ResGrpItemTheme";
								}
								%>
							
							<div style="display:table-row">
								<div style="display:table-cell;vertical-align:middle;" class="resItemsLeftRow <%=resultRowStyle%>">
									<div style="display:table;width:100%">
										<div style="display:table-row">
											<div style="display:table-cell;vertical-align:middle;" class="resCellDataPad"><%= resultName%></div>
											<% if(resultGroupItem.getResultDataType().equals("NUM")){ %>
											<div style="display:table-cell;vertical-align:middle;" class="resItemsChartImg" onclick="showResGraphPopup(this,'CSCommonPopUpContainer')"
											data-title="<%= resultName%>" data-yaxis="<%=resultGroupItem.getResultValuesCSV() %>" data-xaxis="<%=resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")%>"
											data-uom="<%=resultGroupItem.getResultUom()%>" data-normallow="<%=resultGroupItem.getNormalLow()%>" data-normalhigh="<%=resultGroupItem.getNormalHigh()%>">
											
											<img src="${path}/eIPAD/images/BarChart.png"/></div>
											<%} %>
										</div>
									</div>
								</div>
							</div>
								<%
								curGroupCode = groupCode;
							}
							}
							}%>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="resItemsWrapperDiv resultItemsDataCol" id="reswiwrapper-<%=resultHO.getCategoryCode() %>">
			<div id="reswiscroller-<%=resultHO.getCategoryCode() %>" style="" data-colnum="<%=allDates.size()%>">
				<div style="display:table;">
					<div style="display:table-row">
						<div style="display:table">
							<div style="display:table-row">
								<%for(int x=0;x<allDates.size();x++){ 
									Date xDate = allDates.get(x);
									String dateStr = sdf.format(xDate);
								%>
								<div style="display:table-cell;vertical-align:middle;text-align:center" class="resSubCatRightRow ResSubCatRowTheme">
									<div style=:display:table;"><div style="display:table-row"><div style="display:table-cell; vertical-align:middle;text-align:center;" class="resCatHeadInnerCell ResCatHeadInnerTheme"><%=dateStr%></div></div></div>
								</div>
								<%} 
								if(emptyCellsToPrint > 0){
									for(int e=0;e<emptyCellsToPrint;e++){
								%> 
								<div style="display:table-cell;vertical-align:middle;text-align:center" class="resSubCatRightRow ResSubCatRowTheme">
									<div style=:display:table;"><div style="display:table-row"><div style="display:table-cell; vertical-align:middle;text-align:center;" class="resCatHeadInnerCell ResCatHeadInnerTheme"></div></div></div>
								</div>
								<%
									}
								} 
								%>
								
							</div>
						</div>
					</div>
					<div style="display:table-row">
						<div style="display:table-cell;">
							<div style="" class="resItemsTabColTheme resItemsRightTabCol">
								<div style="display:table;"> 
									<%
									for(int j=0;j<resultSubCategoryList.size();j++){
								ResultSubCategory resultSubCategory = resultSubCategoryList.get(j); 
								ArrayList<ResultGroupItem> resultGroupItemList = resultSubCategory.getResGrpItems();
								if(!resultGroupItemList.isEmpty()){
									String curGroupCode2 = "";
									for(int b=0;b<resultGroupItemList.size();b++){
										ResultGroupItem resultGroupItem = resultGroupItemList.get(b);
										String groupName = resultGroupItem.getResultGroupName();
										String groupCode = resultGroupItem.getResultGroupCode();
										String resultName = resultGroupItem.getResultName();
										String resultCode = resultGroupItem.getResultCode();
										String contSysId = resultGroupItem.getContrSysId();
										String resultDataType = resultGroupItem.getResultDataType();
										String uom = resultGroupItem.getResultUom();
										//ArrayList<ResultValue> resultValueList = resultGroupItem.getResValues();
										ArrayList<ResultValue> resultValueList = resultGroupItem.getResValuesForDates(allDates);
										if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode2)){
										// group header row	-- display empty cells
										
									%>
									<div style="display:table-row"><!-- group name row with empty data cells -->
										<%for(int x=0;x<allDates.size();x++){ %>
										<div style="display:table-cell;" class="resItemsRightCell ResGrpItemTheme"></div>
										<%} %>
										<%if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										%> 
										<div style="display:table-cell;" class="resItemsRightCell ResGrpItemTheme"></div>
										<%
											}
										} %>
									</div>
										
									<%
										}
										curGroupCode2 = groupCode;
											%>
									<div style="display:table-row" class="">
									<%
										String resultRowStyle="ResItemTheme";
									//if there is no group name, then the result row should be in grouprow style
										if(groupCode == null || groupCode.equals("")){
											resultRowStyle="ResGrpItemTheme";
										}
										for(int n=0;n<resultValueList.size();n++){
											
											ResultValue resultValue = resultValueList.get(n);
											if(resultValue.getDate().equals("NULL") && resultValue.getAccessionNum().equals("NULL")) {
												//display empty cell
											%>
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>"></div>
											<% 
											}
											else{
												
												//display data cell
											%>
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>">
													<div style="display:table;width:100%">
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemNormIconCell">
																<%
																if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.NORMAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_NORMAL.gif"/></div>
																<%} 
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.ABNORMAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Abnormal.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICAL)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Critical.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.LOW)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_Low.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.HIGH)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_High.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALLOW)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_CriticallyLow.gif"/></div>
																<%}
																else if(resultValue.getNormalcyInd().equals(ResultValue.Normalcy.CRITICALHIGH)){%>
																<div class="" style=""><img src="${path}/eIPAD/images/SNI_CriticallyHigh.gif"/></div>
																<%} 
																else{ %>
																<div class="" style=""><img src="${path}/eIPAD/images/SNoData.PNG"/></div>
																<%} %>
															</div>
															<%if(resultDataType.equals("NUM")){ %>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemValueCell">
																<div class="ResValueText" style=""><%= resultValue.getDblAsStrValue()%></div>
																<div class="ResUomText"><%=uom %></div>
															</div>
															<%} 
															else if(resultDataType.equals("STR")){
															%>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemValueCell">
																<div class="ResValueText" data-resstrvalue="<%= resultValue.getStrValue()%>" onclick="openStrResPopup(this,'CSCommonPopUpContainer')" data-title="Event Details"><%= resultValue.getStrValue()%></div>
															</div>
															<%} 
															else if(resultDataType.equals("HTM") || resultDataType.equals("TXT")){
															%>
															<div style="display:table-cell;vertical-align:middle;text-align:center;" onclick="showResNotesPopup(this,'CSCommonPopUpContainer')" 
															data-linkurl="${path}/mobile/chartsummary/ResultNotesView?HistRecType=<%=histRecType%>&ContSysId=<%=contSysId%>&AccessionNum=<%=resultValueList.get(n).getAccessionNum()%>&ContrSysEventCode=<%=resultCode%>" 
															data-title="Event Details">
																<div class=""><img src="${path}/eIPAD/images/NoteType.png"/></div>
															</div>
															<%} %>
														</div>
													</div>
												</div>
												
											<% 
											}

										}
										if(emptyCellsToPrint > 0){
											for(int e=0;e<emptyCellsToPrint;e++){
										%> 
												<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resItemsRightCell <%=resultRowStyle%>"></div>
										<%
											}
										} 
										%>
									
									</div>
									<%
						
									}
									}
									}%>
									</div>
								</div>
							</div>
						</div>
									 
				</div> 
			</div>
		</div>

	<%
	}
	%>
</div>
		<%}
	} else{ %>
		
		<div class="WidgetVwErrContainer">
			<%
			for(int k=0;k<errorList.size();k++){
			%>
			<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%= errorList.get(k).getErrorMessage()%></div>
			<%} %>
		</div>
	<%} %>
	
</form>
</div>



