<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="eIPAD.chartsummary.results.healthobject.*"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page import="eIPAD.chartsummary.results.response.ResultsResponse"%>
<%@ page import="java.util.*"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<%

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />

<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<link href="${path}/eIPAD/css/kendo.dataviz.min.css" rel="stylesheet">
<script src="${path}/eIPAD/kendo.dataviz.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
var recordScroll ;
var graphScroll;
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', allergyScroll, false);
function allergyScroll() {
	 setTimeout(function () {
		recordScroll = new iScroll('ResGraphLeftItems', {
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
	 
	 graphScroll = new iScroll('ResGraphRightItems', {
			useTransform: true,
			zoom: false,
			onBeforeScrollStart: function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;

			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
			e.preventDefault();
			}
			});
}
function scrollRefresh()
{
	if(recordScroll != null)
		recordScroll.refresh();
	if(graphScroll != null)
		graphScroll.refresh();
}
function changeOrientation(orient, EMHFheight)
{
	computeResultDataFrameWidth();
	setSparklineGraphBoxWidth();
	destroyAllVisibleSparklines();
	var CSHFheight = $('#allergyHeader').height();
	HFheight = EMHFheight;
	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
	document.getElementById("divcnt").style.height = content_height+"px";
	screenOrienttation = orient;
	computeLeftRightFrameHeight();
	alterSparkLineWidth();
	buildAllVisibleSparklines();
	scrollRefresh();
/* 	if(screenOrienttation == "landscape") // to display the sfs based on the orientation
	 {
		 
		$('#lineChartContainer').css("left" , "15%");
		$('#lineChartContainer').css("top" , "15%");
	 }
	 else 
	 {
	     $('#lineChartContainer').css("left" , "2%");	
	     $('#lineChartContainer').css("top" , "20%");
	 } */
	
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
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").data("popid","");
	$("#dvMez").off();
}
function closeLineChart()
{
	   closeMezzaineWindow();
	   $("#dvMez").data("popid","");
	   $('#ResChartCommonPopUpContainer').css("display" , "none");
	  
	   
}
$(document).ready(function () {
	
	 parent.setOnLoadContentPaneHeight();
	 computeResultDataFrameWidth();
	 computeLeftRightFrameHeight();
	 setSparklineGraphBoxWidth();
	 
	 //checkall = $("#PTCR");
	 //checkall.prop("indeterminate", true);
	 //alert("see PTCR");
	 //checkall.attr('checked','checked');
	//checkall = document.getElementById('PTCR');
	//checkall.indeterminate = true;
	//alert("see PTCR");
	//checkall.checked = true;
	//checkall.indeterminate = false;
});
function gotoCS(){
	var path = document.getElementById("hdnPath").value + "/mobile/chartsummary/ChartWidgetsView";
	window.location.replace(path);
}



function computeLeftRightFrameHeight(){
	resultsDataFrameHeight = $("#divcnt").height();
	resultLeftHeaderHeight = $("#ResGraphLeftHeader").height();
	resultLeftItemsHeight = resultsDataFrameHeight - resultLeftHeaderHeight;
	$("#ResGraphLeftItems").css("height", resultLeftItemsHeight+"px" );
	
	//Right
	$("#ResChartRightDiv").css("height",resultsDataFrameHeight);
	$("#ResGraphRightItems").css("height",resultsDataFrameHeight);
	
}



//This event is fired whenever a message is sent from the parent window
//In case of orientationchange event 'OrientationChange' message is received from the parent iframe
/* window.addEventListener("message", function(e){
    var msgvalue = e.data;
    alert(msgvalue); 
    if(msgvalue=='OrientationChange'){
    	computeResultDataFrameWidth();
    	
    }
}, false); */

function computeResultDataFrameWidth(){
	resultsDataFrameWidth = $("#divcnt").width();
	resultLeftColWidth = $("#ResChartLeftDiv").width();
	resultRightColWidth = resultsDataFrameWidth - resultLeftColWidth;
	$("#ResChartRightDiv").css("width", resultRightColWidth+"px");
	
	
	//alert(resultRightColWidth);
	/* $(".resultItemsDataCol").each(function(index,value){
		$(this).css("width", resultRightColWidth+"px");
	}); */
}

function resultItemsSelect(obj){
	
	var objId = $(obj).attr("id");
	var checkVal = $(obj).prop("checked")
	//alert(objId);
	//select each and every sub item
	$("[id^='"+objId+"__']").each(function(index,value){
		
		//alert(checkVal);
		$(this).prop("checked",checkVal);
	});
	
	
	//if one or few and not all items under a parent is unchecked put the parent to indeterminate state
	//if all items under a parent are unchecked, put the parent to unchecked state
	//if all items under a parent are checked, put the parent to checked state.

	var n;
	var parentID;
	var idCopy = objId;
	//Iterating through the parent ids, by stripping the child's specific ID
	while(idCopy.lastIndexOf("__") > 0){
		n = idCopy.lastIndexOf("__");
		idCopy = idCopy.substring(0,n);
		//alert(idCopy);
		var parentObj = $("#"+idCopy);
		if(parentObj){
			var childCount = $("[id^='"+idCopy+"__']").length;
			var checkedCount = 0;
			var unCheckedCount = 0;
			$("[id^='"+idCopy+"__']").each(function(index,value){
				var isChecked = $(this).prop("checked")
				if(isChecked){
					checkedCount++;
				}else{
					unCheckedCount++
				}
				//alert(checkVal);
				//$(this).prop("checked",checkVal);
			});
			//alert(childCount+"  "+checkedCount+"  "+unCheckedCount);
			if(checkedCount == 0 && unCheckedCount == childCount){
				//alert("all unchecked");
				$(parentObj).prop('checked', false);
				$(parentObj).prop("indeterminate", false);
				//$(parentObj).removeAttr('checked');
			}
			else if(unCheckedCount == 0 && checkedCount == childCount){
				//alert("all checked");
				
				//$(parentObj).removeAttr('checked');
				$(parentObj).prop('checked', true);
				$(parentObj).prop("indeterminate", false);
				
				//$(parentObj).attr('checked','checked');
			}
			else{
				//alert("indeterminate");
				$(parentObj).prop("indeterminate", true);
			}
		}
	}
	var selectedCount = 0;
	//  show/hide selected/unselected graphs
	$("[data-resultgraph='true']").each(function(index,value){
		//selectedCount = 0;
		var divCount = $(this).data("count");
		var isResChecked = $(this).prop("checked");
		if(isResChecked){
			
			$("#ResultSGraphContainer"+divCount).show();
			//setSparklineGraphBoxWidth();
			/* if(SparkLineGraphBoxWidth == 0){
				
				alert(SparkLineGraphBoxWidth);
			} */
			
			var graphAreaWid = SparkLineGraphBoxWidth - $(".resSGraphCurrValCell").width() - $("#ResChartLeftPanelButton").width();
			$("#ResSGraphArea"+divCount).css("width", graphAreaWid+"px" );
			buildSparkLine(divCount);
			/* if($("#ResSGraphArea"+divCount).is(':empty')) {
				
			} */
			selectedCount++;
			
		}else{
			$("#ResultSGraphContainer"+divCount).hide();
		}
		
	});
	
	$("#SelectedItemsCount").html(selectedCount);
	
	if(graphScroll != null)
		graphScroll.refresh();
	
	
	
}

function alterSparkLineWidth(){
	var currCellWid = $(".resSGraphCurrValCell").width();
	//alert(currCellWid);
	var grWid = SparkLineGraphBoxWidth - currCellWid - $("#ResChartLeftPanelButton").width();
	$(".resSGraphBoxAdjWid").css("width",grWid+"px");
	/* $(".resSGraphBoxAdjWid").each(function(index,value){
		id = $(this).attr("id");
		if($("#"+id).is(':visible')){
			var sparkline = $("#"+id).data("kendoSparkline");
			sparkline.refresh();
		}
	}); */
	//alert(grWid);
	
}
var SparkLineGraphBoxWidth;
function  setSparklineGraphBoxWidth(){
	SparkLineGraphBoxWidth = $("#ResGraphRightItems").width()-50;
	//alert(cellWidth);
	//alert(SparkLineGraphBoxWidth);
	//$(".resSGraphBoxAdjWid").css("width",SparkLineGraphBoxWidth);
	
}


function buildSparkLine(graphNum){
	
	var checkBoxID = $("[data-count='"+graphNum+"']").attr("id");
	var checkBoxObj= document.getElementById(checkBoxID);
	
	var title = $(checkBoxObj).data("resultname");
	var uom = $(checkBoxObj).data("uom");
	var curVal = $(checkBoxObj).data("lastvalue");
	var curDate = $(checkBoxObj).data("lastdate"); 
	
	
	
	var curNormInd = $(checkBoxObj).data("lastnorm");
	//var normImg = ' ';
	var normImg = '';
	
	if(curNormInd == 'N'){
		normImg = '${path}/eIPAD/images/BNI_NORMAL.gif';
	}
	else if(curNormInd == 'H'){
		normImg = '${path}/eIPAD/images/BNI_High.gif';
	}
	else if(curNormInd == 'L'){
		normImg = '${path}/eIPAD/images/BNI_Low.gif';
	}
	else if(curNormInd == 'C'){
		normImg = '${path}/eIPAD/images/BNI_Critical.gif';
	}
	else if(curNormInd == 'A'){
		normImg ='${path}/eIPAD/images/BNI_Abnormal.gif';
	}
	else if(curNormInd == 'G'){
		normImg = '${path}/eIPAD/images/BNI_CriticallyHigh.gif';
	}
	else if(curNormInd == 'S'){
		normImg = '${path}/eIPAD/images/BNI_CriticallyLow.gif';
	}
	else{
		normImg = '${path}/eIPAD/images/BNoData.PNG';
	}
	
	//Populate other items inside the graph box
	$("#ResSGraphTitle"+graphNum).html(title);
	if(uom){
		$("#ResSGraphTitleUOM"+graphNum).html("["+uom+"]");
	}
	
	$("#ResSGraphUOM"+graphNum).html(uom);
	$("#ResSGraphCurrentValue"+graphNum).html(curVal);
	$("#ResSGraphCurrentDate"+graphNum).html(curDate);
	
	
	$("#ResSGraphCurrentNormInd"+graphNum).attr('src',normImg);
	
	drawSparklineGraph(graphNum);

	
}

function drawSparklineGraph(graphNum){
	
	var checkBoxID = $("[data-count='"+graphNum+"']").attr("id");
	var checkBoxObj= document.getElementById(checkBoxID);
	
	var valCSV = $(checkBoxObj).data("valuecsv"); 
	var dateCSV = $(checkBoxObj).data("datecsv");
	var valArr = $.map(valCSV.toString().split(','), function(value){
	    return parseFloat(value);
	});
	var dateArr = $.map(dateCSV.toString().split(','), function(value){
	    return new Date(value);
	});
	//alert(dateArr);
	//valArr.slice(0, 25);
	valArr = valArr.reverse();
	//draw graph 
	/* $("#ResSGraphArea"+graphNum).kendoSparkline({
        type: "line",
        data: valArr,
        tooltip: {
            format: "{0}"
        }
    }); */
	var scatterChartData = [];
	for(i=0;i<valArr.length;i++){
		var xyPair = [dateArr[i],valArr[i]];
		scatterChartData.push(xyPair);
	}
	
	$("#ResSGraphArea"+graphNum).kendoChart({
	      
        series: [{
     	   type: "scatterLine",
     	   data: scatterChartData,
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
	
	
}

function hideSGraph(graphNum){
	$("#ResultSGraphContainer"+graphNum).hide();
	$("[data-count='"+graphNum+"']").prop('checked', false);
	var checkBoxID = $("[data-count='"+graphNum+"']").attr("id");
	var checkBoxObj= document.getElementById(checkBoxID);
	resultItemsSelect(checkBoxObj);
}

function hideChartLeftPane(){
	
	destroyAllVisibleSparklines();
	$("#ResChartLeftDiv").css("width","0px");
	$("#ResChartLeftDiv").hide();
	
	$("#ResChartLeftPanelButton").css("display","table-cell");
	$("#ResChartLeftPanelButton").css("width","60px");
	//$("#ResChartLeftPanelButton").css("width","60px");
	computeResultDataFrameWidth();
	setSparklineGraphBoxWidth();
	
	
	alterSparkLineWidth();
	buildAllVisibleSparklines();
}

function showChartLeftPane(){
	
	destroyAllVisibleSparklines();
	$("#ResChartLeftDiv").show();
	$("#ResChartLeftDiv").css("width","305px");
	$("#ResChartLeftPanelButton").css("width","0px");
	$("#ResChartLeftPanelButton").hide();
	
	//$("#ResChartLeftPanelButton").css("width","0px");
	computeResultDataFrameWidth();
	
	setSparklineGraphBoxWidth();
	alterSparkLineWidth();
	
	//alert(SparkLineGraphBoxWidth);
	
	buildAllVisibleSparklines();
	
}

function destroyAllVisibleSparklines(){
	$(".resSGraphBoxAdjWid").each(function(index,value){
		id = $(this).attr("id");
		if($("#"+id).is(':visible')){
			//alert("destoryed"+id);
			var sparkline = $("#"+id).data("kendoSparkline");
			sparkline.destroy();
			$(this).empty();
		}
	});
	
}
function buildAllVisibleSparklines(){
	$(".resSGraphBoxAdjWid").each(function(index,value){
		id = $(this).attr("id");
		if($("#"+id).is(':visible')){
			//alert("built"+id);
			var sparkline = $("#"+id).data("kendoSparkline");
			var graphNum = $(this).data("count");
			drawSparklineGraph(graphNum)
		}
	});
	
}

function openLineGraph(graphNum){
	 $('#ResChartCommonPopUpContainer').css("display" , "block");
	 $("#dvMez").show();
	 $("#dvMez").data("popid","ResChartCommonPopUpContainer");
	 setTimeout(function() {
			$("#dvMez").on("click",closeMezzaineWindow);
		}, 500);
	var checkBoxID = $("[data-count='"+graphNum+"']").attr("id");
	var obj = document.getElementById(checkBoxID);
	var gcategories = $(obj).data("datecsv");
	var gcategories_arr = gcategories.split(",");
	
	var gdata = $(obj).data("valuecsv");
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
	var valueAxisTitle ="";
	if(uom){
		valueAxisTitle = "Values in " + uom;
	}
	var resultName = $(obj).data("resultname");
	var totalResultsCount = $("#totalResultsCount").val();
	
	$("#ResLGraphTitle").html(resultName+" (" + uom+")");
	
	var scatterChartData = [];
	   for(i=0;i<gcategories_arr.length;i++){
		   var xyPair = [new Date(gcategories_arr[i]),gdata_arr[i]];
		   scatterChartData.push(xyPair);
	   }
	   //alert(scatterChartData);

    $("#ResLGraphBox").kendoChart({
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
	

	
	if(graphNum==1){
		//no prev navi
		$("#ResLGraphPrevNavi").attr("onclick","");
		$("#ResLGraphPrevNaviImg").attr("src","");
	}else{
		$("#ResLGraphPrevNavi").attr("onclick","openLineGraph("+(graphNum-1)+")");
		$("#ResLGraphPrevNaviImg").attr("src","${path}/eIPAD/images/ChartLeftArrow.PNG");
	}
	
	if(graphNum==totalResultsCount){
		//no prev navi
		$("#ResLGraphNextNavi").attr("onclick","");
		$("#ResLGraphNextNaviImg").attr("src","");
	}else{
		$("#ResLGraphNextNavi").attr("onclick","openLineGraph("+(graphNum+1)+")");
		$("#ResLGraphNextNaviImg").attr("src","${path}/eIPAD/images/ChartRightArrow.PNG");
	}
	
	$("[id^='ResLGraphPagi']").each(function(){
		$(this).removeClass("selectedPageIcons").addClass("normalPageIcons");
	});
	$("#ResLGraphPagi"+graphNum).removeClass("normalPageIcons").addClass("selectedPageIcons");
}


</script>
<style>

.resChartHeadArrowTriCell{
	width:15px
}
.resChartHeadArrowbtnCell{
	width:30px
}
.resChartHeadArrowBtnTabl{
	height:30px;
	width:30px;
}
.resGraphLeftItems{
	padding: 0px; 
	overflow: hidden;
	position:relative;
	width:300px;
}
.resChartHeadArrowProj{
	height:23px;
	width:5px;
	padding-top:6px;
}
.resChartLeftPaneTog{
	width:60px;
	padding-top:10px;
}
.resSGraphContBorder{
	margin:5px;
	border:2px solid #81ABBC;
	min-height:120px;
}
.resSGraphEnclosure{
	margin:5px;
}
.resSGraphCurrValCell{
	display:block;
	text-align:center;
	float:right;
	margin:5px;
	width:125px
}
</style>
</head>

<%
int totalResultsCount = (Integer)request.getAttribute("TotalResultsCount");
ResultsResponse labResultsResponse = (ResultsResponse)request.getAttribute("LabResultsResponse"); 
ResultsResponse radiologyResultsResponse = (ResultsResponse)request.getAttribute("RadiologyResultsResponse");
ResultsResponse surgeryResultsResponse = (ResultsResponse)request.getAttribute("SurgeryResultsResponse"); 
ResultsResponse diagnosticsResultsResponse = (ResultsResponse)request.getAttribute("DiagnosticsResultsResponse"); 
ResultsResponse othersResultsResponse = (ResultsResponse)request.getAttribute("OthersResultsResponse"); 

ArrayList<ResultsResponse> resultsResponseList = new ArrayList<ResultsResponse>();
if(!labResultsResponse.isEmptyDataResponse()&& labResultsResponse.isSuccessResponse()){
	resultsResponseList.add(labResultsResponse);
}
if(!radiologyResultsResponse.isEmptyDataResponse()&& radiologyResultsResponse.isSuccessResponse()){
	resultsResponseList.add(radiologyResultsResponse);
}
if(!surgeryResultsResponse.isEmptyDataResponse()&& surgeryResultsResponse.isSuccessResponse()){
	resultsResponseList.add(surgeryResultsResponse);
}
if(!diagnosticsResultsResponse.isEmptyDataResponse()&& diagnosticsResultsResponse.isSuccessResponse()){
	resultsResponseList.add(diagnosticsResultsResponse);
}
//Others result is not added since it has to be grouped by the category unlike by the subcategory
/* if(!othersResultsResponse.isEmptyDataResponse()&& othersResultsResponse.isSuccessResponse()){
	resultsResponseList.add(othersResultsResponse);
} */

int globalResultItemCounter = 0;
%>
<body>
   	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name="frmRecordAllergy" id="frmRecordAllergy" id="frmRecordAllergy" method="post" style="width: 100%; height: 100%" action="">

			
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
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Results Graph</div>
										</div>
										<div class="AllergyCell" style="width: 1%">
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell" style="width: auto; text-align: right">
														<div class="buttonContainer">
															<div class="WidgetButtonTheme" onclick="gotoCS()">
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
			<div id="divcnt" class="divAllergyContent divResChartsContentTheme" style="padding: 0px; overflow: hidden" data-role="none">
				<!-- <div style="width: 100%; height: auto; overflow: auto" data-role="none"> -->
					<div data-role="none" style="width: 100%; height: auto">
						<%if(totalResultsCount>0){ 
							
							ResultsResponse resultsResponse;
							ArrayList<ResultHO> resultHOList;
							ResultHO resultHO;
							String resultCategoryCode;
							ArrayList<ResultSubCategory> resultSubCategoryList;
							ResultSubCategory resultSubCategory;
							String resultSubCategoryCode;
							ArrayList<ResultGroupItem> resultGroupItemList;
							ResultGroupItem resultGroupItem;
							ArrayList<ResultValue> resultValueList;
							ResultValue resultValue;
						%>
						<div style="" id="ResChartLeftDiv" class="resChartLeftDiv">
						<div style="display:table;width:100%">
							<div style="display:table-row">
								<div style="display:table-cell"> <!-- Cell that contains Result items + Result Header -->
									<div style="display:table;" class="resChartVwHeadTheme resChartVwItemRow"  id="ResGraphLeftHeader">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;" class=""><div class="resChartVwItemText">Selected Items - <div id="SelectedItemsCount" style="display:inline">0</div></div></div>
									 		<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resChartHeadArrowTriCell"><div class="resChartHeadArrowTriTheme"></div></div>
									 		<div style="display:table-cell;vertical-align:middle;text-align:center;" class="resChartHeadArrowbtnCell">
										 		<div style="display:table;" class="resChartHeadArrowBtnTabl resChartHeadArrowTheme">
										 			<div style="display:table-row">
										 				<div style="display:table-cell;vertical-align:middle;text-align:center">
										 					<img src="${path}/eIPAD/images/MenuIcon.png" onclick="hideChartLeftPane()"/>
										 				</div>
										 			</div>
										 		</div>
										 	</div>
									 	</div>
									</div>
								
						
						<div id="ResGraphLeftItems" class="resGraphLeftItems" style="" data-role="none">
							<div style="width: 100%; height: auto; overflow: auto" data-role="none">
							<div style="display:table;width:100%">
							<div style="display:table-row">
								<div style="display:table-cell">		
							<!--  Lab, surgery, diagnostics, radiology Results Starts -->
								<%for(int h=0;h<resultsResponseList.size();h++){ 
									resultsResponse = resultsResponseList.get(h);
									resultHOList = resultsResponse.getResults();
									for(int i=0;i<resultHOList.size();i++){
										resultHO = resultHOList.get(i);
										resultCategoryCode = resultHO.getCategoryCode();
										resultSubCategoryList = resultHO.getResSubCat();
								%>
									
									<div style="display:table;width:100%;" class="resChartVwCatHeadTheme resChartVwItemRow">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;" class="">
									 			<div class="resChartVwItemText"><%=resultHO.getCategoryName() %></div>
									 		</div>
									 	</div>
									</div>
									
										<%for(int j=0;j<resultSubCategoryList.size();j++){
											resultSubCategory = resultSubCategoryList.get(j);
											resultSubCategoryCode = resultSubCategory.getSubCategoryCode();
											resultGroupItemList = resultSubCategory.getResGrpItems();
										%>
									<div style="display:table;width:100%;" class="resChartVwSubCatHeadTheme resChartVwItemRow">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;">
									 			<div style="display:table;">
									 				<div style="display:table-row">
									 					<div style="display:table-cell" class="resChartVwItemChkBox">
									 						<div class="csChkBoxTheme3">
																<input type="checkbox" id="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>" data-code="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>" data-resultgraph = "false"  onclick = "resultItemsSelect(this)">
																<label for="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>"></label>
															</div>
									 					</div>
									 					<div style="display:table-cell" class="resChartVwItemText"><%=resultSubCategory.getSubCategoryName() %></div>
									 				</div>
									 			</div>
									 		</div>
									 	</div>
									</div>
											
											<% if(!resultGroupItemList.isEmpty()){ %>
									<div style="display:table;width:100%;">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;" class="resChartVwGrpContTheme">
									 			<div style="margin:3px" class="resChartVwGrpContTheme">
										 			<div style="display:table;width:100%">
										 			<%
										 			String curGroupCode = "";
										 			for(int k=0;k<resultGroupItemList.size();k++) {
										 				resultGroupItem = resultGroupItemList.get(k);
														String groupName = resultGroupItem.getResultGroupName();
														String groupCode = resultGroupItem.getResultGroupCode();
														String resultName = resultGroupItem.getResultName();
														String resultCode = resultGroupItem.getResultCode();
														String dataCodePrefix = "";
														String resultRowStyle = "";
														if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
										 				%>
											 			<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;" class="resChartGrpItemTheme resChartVwItemRow">
																<div style="display:table">
																	<div style="display:table-row">
																		<div style="display:table-cell" class="resChartVwItemChkBox">
													 						<div class="csChkBoxTheme3">
																				<input type="checkbox" id="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>" data-code = "<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>" data-resultgraph = "false"  onclick = "resultItemsSelect(this)">
																				<label for="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>"></label>
																			</div>
													 					</div>
													 					<div style="display:table-cell" class="resChartVwItemText"><%= groupName%></div>
																	</div>
																</div>
															</div>
														</div>
										 				<%} 
														
														if(groupCode != null && !groupCode.equals("")){
															resultRowStyle="resChartItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode+"__"+groupCode;
														}
														//if there is no group name, then the result row should be in grouprow style -- if(groupCode == null || groupCode.equals(""))
														else{
															resultRowStyle="resChartGrpItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode;
														}
										 				%>
										 				<div style="display:table-row">
										 					<div style="display:table-cell;vertical-align:middle;" class="<%=resultRowStyle%> resChartVwItemRow">
										 						<div style="display:table;">
										 							<div style="display:table-row;">
										 								<div style="display:table-cell" class="resChartVwItemChkBox">
													 						<div class="csChkBoxTheme3">
													 							<% 
													 							resultValueList = resultGroupItem.getResValues(); 
													 							resultValue = resultValueList.get(0);
													 							%>
																				<input type="checkbox" id="<%=dataCodePrefix%>__<%=resultCode%>" data-count="<%=++globalResultItemCounter%>" data-code = "<%=dataCodePrefix%>__<%=resultCode%>" data-resultgraph = "true"  
																				data-datecsv="<%=resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")%>" data-valuecsv="<%=resultGroupItem.getResultValuesCSV()%>"
																				data-uom="<%=resultGroupItem.getResultUom() %>" data-lastvalue="<%=resultValue.getDblAsStrValue() %>"  data-lastdate="<%=resultValue.getDate("dd/MM/yyyy HH:mm")%>" 
																				data-lastnorm="<%=resultValue.getNormalcyInd().getNormalcyCode()%>" data-resultname = "<%=resultGroupItem.getResultName()%>" 
																				onclick = "resultItemsSelect(this)">
																				<label for="<%=dataCodePrefix%>__<%=resultCode%>"></label>
																			</div>
													 					</div>
													 					<div style="display:table-cell" class="resChartVwItemText"><%= resultName%></div>
										 							</div>
										 						</div>
																
															</div>
														</div>
										 			<%
										 			curGroupCode = groupCode;
										 			} %>
										 			</div>
									 			</div>
									 		</div>
									 	</div>
									</div>	
										<%	}
										}%>
								<%
									}
								} %>
								
						<!--  Lab, surgery, diagnostics, radiology Results Ends -->
						
						
						
						<!--  Others Results Starts -->
								<%if(!othersResultsResponse.isEmptyDataResponse() && othersResultsResponse.isSuccessResponse()){ 
									resultHOList = othersResultsResponse.getResults();
									
								%>
									<div style="display:table;width:100%;" class="resChartVwCatHeadTheme resChartVwItemRow">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;" class="">
									 			<div class="resChartVwItemText">Others</div> <!-- TODO Localize -->
									 		</div>
									 	</div>
									</div>
								<%
									for(int i=0;i<resultHOList.size();i++){
										resultHO = resultHOList.get(i);
										resultCategoryCode = resultHO.getCategoryCode();
										resultSubCategoryList = resultHO.getResSubCat();
								%>
									<%-- <div style="display:table;width:100%;" class="resChartVwSubCatHeadTheme resChartVwItemRow">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;">
									 			<div class="resChartVwItemText"><%=resultHO.getCategoryName() %></div>
									 		</div>
									 	</div>
									</div> --%>
									<div style="display:table;width:100%;" class="resChartVwSubCatHeadTheme resChartVwItemRow">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;">
									 			<div style="display:table;">
									 				<div style="display:table-row">
									 					<div style="display:table-cell" class="resChartVwItemChkBox">
									 						<div class="csChkBoxTheme3">
																<input type="checkbox" id="<%=resultCategoryCode%>" data-code="<%=resultCategoryCode%>" data-resultgraph = "false"  onclick = "resultItemsSelect(this)">
																<label for="<%=resultCategoryCode%>"></label>
															</div>
									 					</div>
									 					<div style="display:table-cell" class="resChartVwItemText"><%=resultHO.getCategoryName() %></div>
									 				</div>
									 			</div>
									 		</div>
									 	</div>
									</div>
									<div style="display:table;width:100%;">
									 	<div style="display:table-row">
									 		<div style="display:table-cell;vertical-align:middle;text-align:left;" class="resChartVwGrpContTheme">
									 			<div style="margin:3px" class="resChartVwGrpContTheme">
								<%
										for(int j=0;j<resultSubCategoryList.size();j++){
											resultSubCategory = resultSubCategoryList.get(j);
											resultSubCategoryCode = resultSubCategory.getSubCategoryCode();
											resultGroupItemList = resultSubCategory.getResGrpItems();
								%>
											
											<% if(!resultGroupItemList.isEmpty()){ %>
									
										 			<div style="display:table;width:100%">
										 			<%
										 			String curGroupCode = "";
										 			for(int k=0;k<resultGroupItemList.size();k++) {
										 				resultGroupItem = resultGroupItemList.get(k);
														String groupName = resultGroupItem.getResultGroupName();
														String groupCode = resultGroupItem.getResultGroupCode();
														String resultName = resultGroupItem.getResultName();
														String resultCode = resultGroupItem.getResultCode();
														String dataCodePrefix = "";
														String resultRowStyle = "";
														
														if(groupCode!=null && !groupCode.equals("") && !groupCode.equals(curGroupCode)){
										 			
										 				%>
														<div style="display:table-row">
															<div style="display:table-cell;vertical-align:middle;" class="resChartGrpItemTheme resChartVwItemRow">
																<div style="display:table">
																	<div style="display:table-row">
																		<div style="display:table-cell" class="resChartVwItemChkBox">
													 						<div class="csChkBoxTheme3">
																				<input type="checkbox" id="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>" data-code = "<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>" data-resultgraph = "false"  onclick = "resultItemsSelect(this)">
																				<label for="<%=resultCategoryCode%>__<%=resultSubCategoryCode%>__<%=groupCode%>"></label>
																			</div>
													 					</div>
													 					<div style="display:table-cell" class="resChartVwItemText"><%= groupName%></div>
																	</div>
																</div>
															</div>
														</div>
														
										 				<%} 
														if(groupCode != null && !groupCode.equals("")){
															resultRowStyle="resChartItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode+"__"+groupCode;
														}
														//if there is no group name, then the result row should be in grouprow style -- if(groupCode == null || groupCode.equals(""))
														else{
															resultRowStyle="resChartGrpItemTheme";
															dataCodePrefix = resultCategoryCode+"__"+resultSubCategoryCode;
														}
										 				%>
														<div style="display:table-row">
										 					<div style="display:table-cell;vertical-align:middle;" class="<%=resultRowStyle%> resChartVwItemRow">
										 						<div style="display:table;">
										 							<div style="display:table-row;">
										 								<div style="display:table-cell" class="resChartVwItemChkBox">
													 						<div class="csChkBoxTheme3">
													 							<% 
													 							resultValueList = resultGroupItem.getResValues(); 
													 							resultValue = resultValueList.get(0);
													 							%>
																				<input type="checkbox" id="<%=dataCodePrefix%>__<%=resultCode%>" data-count="<%=++globalResultItemCounter%>" data-code = "<%=dataCodePrefix%>__<%=resultCode%>" data-resultgraph = "true"  
																				data-datecsv="<%=resultGroupItem.getResultDateCSV("yyyy/MM/dd HH:mm:ss")%>" data-valuecsv="<%=resultGroupItem.getResultValuesCSV()%>"
																				data-uom="<%=resultGroupItem.getResultUom() %>" data-lastvalue="<%=resultValue.getDblAsStrValue() %>"  data-lastdate="<%=resultValue.getDate("dd/MM/yyyy HH:mm")%>" 
																				data-lastnorm="<%=resultValue.getNormalcyInd().getNormalcyCode()%>" data-resultname = "<%=resultGroupItem.getResultName()%>"
																				data-normallow="<%=resultGroupItem.getNormalLow() %>" data-normalhigh="<%=resultGroupItem.getNormalHigh() %>"
																				onclick = "resultItemsSelect(this)">
																				<label for="<%=dataCodePrefix%>__<%=resultCode%>"></label>
																			</div>
													 					</div>
													 					<div style="display:table-cell" class="resChartVwItemText"><%= resultName%></div>
										 							</div>
										 						</div>
																
															</div>
														</div>
										 			<%
										 			curGroupCode = groupCode;
										 			} %>
										 			</div>
									 				
										<%	}
										}%>
												</div>
									 		</div>
									 	</div>
									</div>
								<%
									}
								} %>
								
						<!--  Others Results Ends -->
										</div>
									</div>
									</div>
								</div>
							</div>
							</div>
								<div style="display:table-cell"><!-- cell that contains sticking out part of the first row.(Bow like structure for expanding and collapsing the first column) -->
									<div class="resChartHeadArrowProj resChartHeadArrowTheme"></div>
									
								</div>
							</div> 
						</div>
						</div>
						
						<div id="ResChartRightDiv"  style="float:right">
							<div id="ResGraphRightItems" style="padding: 0px; overflow: hidden;position:relative" data-role="none"><!-- Scroll wrapper -->
								<div style="width: 100%; height: auto; overflow: auto" data-role="none"> <!-- Scroll scroller -->
								<div style="display:table;width:100%">
								<div style="display:table-row">
								<div style="display:table-cell;vertical-align:top;text-align:center;display:none" class="resChartLeftPaneTog" id="ResChartLeftPanelButton">
									<div class="WidgetButtonTheme" data-role="none" onclick="showChartLeftPane()"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
								</div>
								<div style="display:table-cell"> 
									<div  class="resSGraphContBorder">
									<div class="resSGraphEnclosure">
						
									<%for(int l=1;l<=globalResultItemCounter;l++) {
									%>
										<div id="ResultSGraphContainer<%=l %>" data-count="<%=l %>" style="display:none;padding-top:5px;padding-bottom:5px;padding-left:2px;padding-right:2px;" >
										<div style="border:1px solid #aaa;">
											<div style="display:table;width:100%;">
												<div style="display:table-row"><!-- Sparkline graph header row -->
													<div style="display:table-cell;">
														<div style="display:table;width:100%" class="resSGraphHeaderTheme">
															<div style="display:table-row">
																<div style="display:table-cell;height:30px;vertical-align:middle;text-align:left">
																	<div style="padding-left:4px"> <div id="ResSGraphTitle<%=l%>" style="display:inline-block"></div><div style="display:inline" id="ResSGraphTitleUOM<%=l%>"></div></div>
																</div>
																<div style="display:table-cell;width:30px;height:30px;vertical-align:middle;text-align:center">
																	<div data-role = "none" class="resSGraphCloseTheme" onclick="hideSGraph(<%=l %>)">
																		<img src = "${path}/eIPAD/images/Close-small.png" style ="margin-top:5px;margin-left:2px"></img>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>

												<div style="display:table-row"><!-- Sparkline graph body row -->
													<div style="display:table-cell;width:100%;height:130px">
														
																<div style="display:block;vertical-align:middle;float:left"> <!--  Sparkline graph -->
																	<div id="ResSGraphArea<%=l %>" data-count="<%=l %>" style="height:120px;" class="resSGraphBoxAdjWid"  onclick="openLineGraph(<%=l %>)"></div>
																</div>
																<div class="resSGraphCurrValCell"><!-- Current value container -->
																		<div data-role = "none" class="currrentVitalsContainerTheme" style="display:table;width:115px;">
																			<div style="display:table-row">
																				<div style="display:table-cell;vertical-align:middle;text-align:center;">
																					<img src="" id="ResSGraphCurrentNormInd<%=l%>"></img>
																				</div>
																			</div>
																 			<div style="display:table-row">
																				<div style="display:table-cell;vertical-align:middle;text-align:center;max-width:110px;">
																 					<div data-role = "none" class="vitalsValueTheme" id="ResSGraphCurrentValue<%=l%>" style="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;"></div>
																 				</div>
																 			</div>
																			<div style="display:table-row">
																				<div style="display:table-cell;vertical-align:middle;text-align:center;max-width:110px;">
																					<div data-role = "none" class="vitalsUnitTheme" id="ResSGraphUOM<%=l%>" style="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;"></div>	
																				</div>
																 			</div>
																 			<div style="display:table-row">
																				<div style="display:table-cell;vertical-align:middle;text-align:center">
																 					<div data-role = "none" class="vitalsDateTheme" id="ResSGraphCurrentDate<%=l%>"></div>
																 				</div>
																 			</div>
																 		</div>
																</div>
															
													</div>												
												</div>
											</div>
										</div>
										</div>
									<%} %>
									</div>
									</div>
									</div>
									</div>
									</div>
								</div>
						
							</div>

						</div>
						<%} else{%>
						<div class="WidgetVwErrContainer">
							<div class="WidgetErrorResponse WidgetErrorResponseTheme">No results available for the patient</div><!-- TODO Localize -->
						</div>
						<%} %>
					</div>
				<!-- </div> -->
			</div>
			<!-- scrolling div ends -->
			
			
			<!-- line chart graph container starts -->
			<div data-role = "none" id = "dvMez" class = "dvMezzaine" data-popid=""></div>
			<div data-role = "none" class = "resChartCommonPopUpContainer" id = "ResChartCommonPopUpContainer">
			 	<div data-role="none" class="resLineChartContainer" id="lineChartContainer">
					<div id="divParent" class="divParent" data-role="none" style="padding: 0px">
						<div data-role = "none" class = "lineChartTitle" onclick = "closeLineChart()">
							<div data-role = "none" class = "graphTitle">
								<div data-role = "none" class = "dvTitle" id="ResLGraphTitle"></div>
							</div>
							<div data-role = "none" class = "graphCloseButtonArea">
								<div data-role = "none" class = "graphCloseButton graphCloseButtonTheme">
									<img src = "${path}/eIPAD/images/Close10x10.PNG" style = "position:relative;margin-top:3px;margin-left : 5px"></img>
								</div>
							</div>
						</div>
						<div data-role = "none" class = "graphContainer">
							
							<div data-role = "none" class = "graphArea">
							   <div data-role = "none" class = "navigateIconsContainer" id="ResLGraphPrevNavi" onclick = "navigatePage('Previous')">
								<div data-role = "none" class = "navigateIcons">
									<img id="ResLGraphPrevNaviImg" src = "${path}/eIPAD/images/ChartLeftArrow.PNG" ></img>
								</div>
							  </div>
								<div data-role = "none" class = "lineChartArea">
									<div data-role = "none" id= "ResLGraphBox"></div>
								</div>
							  <div data-role = "none" class = "navigateIconsContainer" id="ResLGraphNextNavi" onclick = "navigatePage('Next')">
								<div data-role = "none" class = "navigateIcons">
									<img id="ResLGraphNextNaviImg" src = "${path}/eIPAD/images/ChartRightArrow.PNG" ></img>
								</div>
							 </div>
								
							</div>
							
						</div>
						<div data-role = "none" class = "graphFooter">
							<%for(int i=1;i<=globalResultItemCounter;i++){ %>
							  <div data-role = "none" class = "normalPageIcons" id="ResLGraphPagi<%=i %>" style = "margin-bottom : 5px"></div>
							<%} %>
						</div>
					</div>
			   </div>
	  		</div> 
			<!-- popup container ends -->
			<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
			<input type="hidden" name="totalResultsCount" id="totalResultsCount" id="totalResultsCount" value="<%= totalResultsCount %>"
		</form>
	</div>
</body>
</html>

