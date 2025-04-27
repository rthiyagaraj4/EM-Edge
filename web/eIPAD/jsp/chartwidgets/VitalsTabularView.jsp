<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.vitals.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.healthobject.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
Locale appLocale;
if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);
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
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
	<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
	<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="${path}/eIPAD/kendo.web.min.js"></script>
	<script src="${path}/eIPAD/console.js"></script>
	 
	<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
	<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
	<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   <style>
   .buttonContainer 
	{
		margin-right: 10px;
	}
   .divVitalsContentTheme
	{
		background-color : #ffffff;
		border-right: 1px solid #08415e;
		border-left: 1px solid #08415e;
		border-bottom: 1px solid #08415e;
	}
	.dvTBVContainer
	{
		  position:relative;
		  width : 100%;
		  min-height:75px;
		  height: auto;
		  vertical-align : middle;
		  
	}
	.dvTBVContainerTheme
	{
		border-bottom : 1px solid #b2b2b21;
		box-shadow:         0 -2px 2px 0 #d3d3d3  ;
	    -moz-box-shadow:    0 -2px 2px 0 #d3d3d3 ;
	    -webkit-box-shadow: 0 -2px 2px 0 #d3d3d3 ;
		background: #fffefe; /* Old browsers */
		background: -moz-linear-gradient(top,  #fffefe 0%,  #ebebeb 100%);/* FF3.6+ */
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fffefe),color-stop(100%, #ebebeb) ); /* Chrome,Safari4+ */
		background: -webkit-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* Chrome10+,Safari5.1+ */
		background: -o-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* Opera 11.10+ */
		background: -ms-linear-gradient(top, #fffefe 0%,  #ebebeb 100%);/* IE10+ */
		background: linear-gradient(to bottom, #fffefe 0%,  #ebebeb 100%);/* W3C */
		filter: progid:DXImageTransform.Microsoft.gradient(  startColorstr='#fffefe',endColorstr='#ebebeb', GradientType=0 ); /* IE6-9 */
	}
	.dvControlTable
	{
		display : table;
		width : 100%;
		min-height : 75px;
		height: auto;
	}
	.dvControlRow
	{
		display : table-row;
		width : 100%;
		min-height : 75px;
		height: auto;
	}
	.Cell1
	{
		display : table-cell;
		width : 30%;
		min-height : 75px;
		height: auto;
		vertical-align : middle;
		text-align : right;
		border-right : 1px solid #ffffff;
		
	}
	.Cell2
	{
		display : table-cell;
		width : 70%;
		min-height : 75px;
		height: auto;
		vertical-align : middle;
		text-align : center;
		border-left : 1px solid #d3d3d3;
	}
	.dvControlLabel
	{
		position : relative;
		margin-right : 10px;
		font-family :Arial;
        font-size : 13px;
        font-weight : bold;
        color : #44484a;
		
	}
	.dvTabularView
	{
		position : relative;
		
		margin-right : 10px;
		margin-left : 10px;
		margin-top : 10px;
		overflow-x : hidden;
		border : 1px solid #055168 ;
		height : auto;
	}
	.dvdiscreteDesc
	{
		position : relative;
		float : left;
		width : 29.9%;	
		height : 1000px;
		border-right : 1px solid red;
		background-color : blue;
	}
	.dvdiscreteValue
	{
		position : relative;
		float : left;
		width : 69.9%;
		overflow:hidden;
		height : 1000px;
		border-left : 1px solid orange;
		background-color : pink;
	}
	.dvResultsTable
	{
		display : table;
		min-height : 75px;
		height: auto;	
		width : 100%;
	}
	.dvReslutsRow1
	{
		display : table-row;
		width : 100%;
		min-height : 75px;
		height: auto;
		
	}
	.dvResultsCol1
	{
		display : table-cell;
		width : 2%;
		min-height : 75px;
		height: auto;
		vertical-align : top;
		
		
	}
	.dvResultsCol2
	{
		display : table-cell;
		width : 98%;
		min-height : 75px;
		height: auto;
		
		/*border-left : 1px solid #00485e;*/
		
	}
	.dvVitalsResultHeader
	{
		position : relative;
		width : 100%;
		height : 40px;
		width : 200px;
	}
	.dvResultsHeaderTable
	{
		display : table;
		width: 100%;
		height : 40px;
	}
	.dvResultsHeaderRow
	{
		display : table-row;
		width : 100%;
		height : 40px;
	}
	.dvResultsHeaderCol
	{
		display : table-cell;
		width : 100%;
		height : 40px;	
		vertical-align : middle;
		text-align : center;
	}
	.dvResultsValueTable
	{
		display : table;
		width: 100%;
		height : 60px;
	}
	.dvResultsValueRow
	{
		display : table-row;
		width : 100%;
		height : 60px;
	}
	.dvResultsValueCol
	{
		display : table-cell;
		width : 100%;
		height : 60px;	
		vertical-align : middle;
		text-align : center;
	}
	.dvHeaderDate
	{
		position : relative;
		width : 100px;
		height : 40px;
		float : left;
		vertical-align : middle;
		text-align : center;
		border-left : 1px solid #60adc4;
		border-right : 1px solid #00485e;
		
	}
	.dvResultsHeaderBorder
	{
		border-left : 1px solid #055168;
		border-bottom : 1px solid #33373d;
		border-right : 1px solid #00485e;
		border-top : 1px solid #055168;
		/*
		font-size : 12px;
		font-weight : bold;
		font-family :Arial;
		color : #ffffff;
		margin-left : 10px;
		text-shadow: 0px 2px #133d49;
		*/
	}
	.dvResultsValueBorder
	{
		border-bottom : 1px solid #33373d;
		border-right : 1px solid #055168;
		border-top : 1px solid #055168;
		/*border-left : 1px solid #00485e;*/
	}
	.dvVitalsResultHeaderTheme
	{
	   
		box-shadow:         0 -2px 2px 0 #133d49;
	    -moz-box-shadow:    0 -2px 2px 0 #133d49 ;
	    -webkit-box-shadow: 0 -2px 2px 0 #133d49 ;
		background: #439eba; /* Old browsers */
		background: -moz-linear-gradient(top,  #439eba 0%,  #227e99 100%);/* FF3.6+ */
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #439eba),color-stop(100%,  #227e99) ); /* Chrome,Safari4+ */
		background: -webkit-linear-gradient(top, #439eba 0%,   #227e99 100%);/* Chrome10+,Safari5.1+ */
		background: -o-linear-gradient(top, #439eba 0%,   #227e99 100%);/* Opera 11.10+ */
		background: -ms-linear-gradient(top, #439eba 0%,   #227e99 100%);/* IE10+ */
		background: linear-gradient(to bottom, #439eba 0%,   #227e99 100%);/* W3C */
		filter: progid:DXImageTransform.Microsoft.gradient(  startColorstr='#439eba',endColorstr=' #227e99', GradientType=0 ); /* IE6-9 */
	}
	.vitalsSwipeWrapper
	{
		position : relative;
		width : 200px;
		min-height : 75px;
		height : auto;
		overflow : hidden;
		
		
	}
	.vitalsScroller
	{
		position : relative;
		min-height : 75px;
		height : auto;
		width : 1000px;
	}
	.dvDateFont
	{
	    word-break: break-word;
	    vertical-align : top;
	    text-align : center;
	    margin-top : 14px;
		font-size : 12px;
		font-weight : bold;
		font-family :Arial;
		color : #ffffff;
		text-shadow: 0px 2px #133d49;
		
	}
	.dvHeaderFont
	{
	    position : relative;
		vertical-align : top;
	    padding-top : 14px;
		font-size : 12px;
		font-weight : bold;
		font-family :Arial;
		color : #ffffff;
		margin-left : 10px;
		text-shadow: 0px 2px #133d49;
	}
	.dvVitals
	{
		position:relative;
		height:60px;
		width:200px;
		border-left :  1px solid #ffffff;
		border-right : 1px solid #c7cfd2;
		border-top :  1px solid #ffffff;
		border-bottom : 1px solid #c7cfd2;
	}
	.dvVitalsTheme
	{
	    background : #f4f8fb;
		background: -moz-linear-gradient(top, #f4f8fb 0%, #fefefe 35%, #f0f3f6 60%, #e6ecf2 100%); 
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f4f8fb), color-stop(35%,#fefefe), color-stop(60%,#f0f3f6), color-stop(100%,#e6ecf2)); 
		background: -webkit-linear-gradient(top, #f4f8fb 0%,#fefefe 35%, #f0f3f6 60%,#e6ecf2 100%); 
		background: -o-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%); 
		background: -ms-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);
	 	background: linear-gradient(to bottom, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);  
	    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f4f8fb', endColorstr='#e6ecf2',GradientType=0 ); 
	}
	.dvVitalsBorderTheme
	{
	 /*
	    border-left : 1px solid #ffffff;
	    border-right : 1px solid #c7cfd2;
	    */
	    border-bottom : 1px solid #c7cfd2;
	    border-top :  1px solid #ffffff;
	}
	.dvVitalsTheme1
	{

	    background : #f4f8fb;
		background: -moz-linear-gradient(top, #f4f8fb 0%, #fefefe 35%, #f0f3f6 60%, #e6ecf2 100%); 
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f4f8fb), color-stop(35%,#fefefe), color-stop(60%,#f0f3f6), color-stop(100%,#e6ecf2)); 
		background: -webkit-linear-gradient(top, #f4f8fb 0%,#fefefe 35%, #f0f3f6 60%,#e6ecf2 100%); 
		background: -o-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%); 
		background: -ms-linear-gradient(top, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);
	 	background: linear-gradient(to bottom, #f4f8fb 0%,#fefefe 35%,#f0f3f6 60%,#e6ecf2 100%);  
	    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f4f8fb', endColorstr='#e6ecf2',GradientType=0 ); 
	}
	.dvMeasureContainer
	{
		position:relative;
		width : 100%;
		height : 30px;
		vertical-align : bottom;
		
		
	}
	.dvMeasureFont
	{
		margin-left : 10px;
		padding-top : 13.5px;
		font-size : 13px;
		font-weight : bold;
		font-family :Arial;
		color : #44484a;
		
	}
	.dvMeasureUnits
	{
		position:relative;
		width : 100%;
		height : 30px;
		vertical-align : top;
	}
	.dvUnitsFont
	{
		margin-left : 10px;
		padding-bottom : 13.5px;
		font-size : 13px;
		font-weight : bold;
		font-family :Arial;
		color : #878787;
	}
	.dvValueContainer
	{
		position : relative;
	    border-left : 1px solid #ffffff;
	    border-right : 1px solid #c7cfd2;
		width : 100px;
		height : 60px;
		float : left;
		vertical-align : middle;
		text-align : center;
	}
	.dvVitalsIconContainer
	{
		position : relative;
		width : 30px;
		height : 100%;
		float:left;
		text-align : center;
		
	}
	.dvVitalsValue
	{
		position : relative;
		width : 70px;
		height : 100%;
		float:left; 
		text-align : center;
		
		padding-top : 23.5px;
		font-size : 13px;
		font-weight : bold;
		font-family :Arial;
		color : #44484a;
		
	}
	.dvVitalsValueFont
	{
		margin-top : 23.5px;
		font-size : 13px;
		font-weight : bold;
		font-family :Arial;
		color : #44484a;
	}
   </style>
   <script>
   document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
   document.addEventListener('DOMContentLoaded', vitalsChartScroll, false);
   var vitalsScroll ;
   var screenOrienttation = "landscape";
   var vitalsResultScroll;
   var bValueLoaded = false;
   function cancelTransaction(){
		var path = document.getElementById("hdnPath").value + "/mobile/chartsummary/ChartWidgetsView";
		window.parent.document.getElementById('ChartSummaryIframe').src = path;
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
 function changeOrientation(orient, EMHFheight)
 {
	   	var CSHFheight = $('#allergyHeader').height();
	   	HFheight = EMHFheight;
	   	screenOrienttation = orient;
	   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
	   //	alert(content_height);
	   	document.getElementById("divcnt").style.height = content_height+"px";
	   	if(bValueLoaded) // if tab view load properly, assign the wrapper width;
	   	{
		   	 $("[data-type = 'ComboBox']").each(function(index, value) { 
				 $(this).data("kendoMultiSelect").close();		
			 });
		   	// setCombostyle();
			 setVitalsWrapperWidth();
			 setVitalsScrollerWidth();
			 vitalsResultScrollRefresh();
	   	}
	    scrollRefresh();
 }
 $(document).ready(function () {
	   parent.setOnLoadContentPaneHeight();
	   loadTabularView();
	   /*
	   setVitalsScrollerWidth();
	   setVitalsResultScroll();
	   scrollRefresh();
	   vitalsResultScrollRefresh();
	   */
 });
 function setCombostyle()
 {
	 $('#chartConfig').css("width" , "0%");
	// alert("hello");
	 $('#chartConfig').css("width" , "90%");
	 
 }
 function loadTabularView()
 {
	 
	 bValueLoaded = false;
	 path = $('#hdnPath').val();
	 //var query = DV=t&SV=s
	// var obj = new object();
	// obj.code = "s,t";
	// var data =
		/*
     var arrEvent = [];
     var oCombo = new Object();
     oCombo.DV =  $('#hdnComboValue').val();
     arrEvent.push(oCombo);
     */
    // var comboValues = JSON.stringify(arrEvent)
	
	 $('#dvTabularView').load( path + "/LatestVitals?isRankRequired=N&fromScreen=VV&DV=" + $('#hdnComboValue').val() ,function(response, status, xhr){
		if(status == "error")
		{
			alert("Error Loading the page");	
		}
		else
		{
			$(document).ready(function () {
				 bValueLoaded = true;
				 setVitalsWrapperWidth();
				 setVitalsScrollerWidth();
				 setVitalsResultScroll();
				 scrollRefresh();
				 vitalsResultScrollRefresh();
			});
		}
	 });
	 
 }
 function setVitalsWrapperWidth()
 {
	 $('#vitalsSwipeWrapper').css('width' , "0px");
	 var colWidth = $('#dvResultsCol2').width();
	 colWidth = colWidth + "px";
	 $('#vitalsSwipeWrapper').css('width' , colWidth);
	 
 }
 function setVitalsScrollerWidth()
 {
	 //dvHeaderDate
	 $('#vitalsScroller').css('width' , "0px");
	 var scrollWidth = 0;
	 var count = 0;
	 var dummyWidth =  $('#dvResultsCol2').width();//$('#vitalsSwipeWrapper').width();
	 $(".dvHeaderDate").each(function(index, value) {
		 scrollWidth = scrollWidth + 110;
		 
	 });
	// alert(scrollWidth);
	 if(scrollWidth < dummyWidth)
	 {
		 dummyWidth = dummyWidth + 110;
		 dummyWidth = dummyWidth + "px";
		    $('#vitalsScroller').css('width' , dummyWidth);
	 }
	 else
	 {
		 var width =  scrollWidth  + "px";
		 $('#vitalsScroller').css('width' , width);
	  }
	 
 }
 function setVitalsResultScroll()
 {
	 var dummyWidth =  $('#vitalsSwipeWrapper').width();
	 var hScrollwidth = $('#vitalsScroller').width();
	 if(hScrollwidth > dummyWidth)
	 {
		 
		 vitalsResultScroll = new iScroll('vitalsSwipeWrapper', {
				hScrollbar : false
		});
	  }
		
 }
 function vitalsResultScrollRefresh()
 {
	 if( vitalsResultScroll != null)
		 {
		 	vitalsResultScroll.refresh();
		 }
 }
 function myFunction()
 {
	 alert("hi");
 }
   </script>
</head>
<body style = "padding :0px;display : block;margin: 0px; height: 100%; width: 100%;" >
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name="frmvitalsTabView" id="frmvitalsTabView" id="frmvitalsTabView" style="width: 100%; height: 100%" >
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
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Vitals Table View</div>
										</div>
										<div class="AllergyCell" style="width: 1%">
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="buttonContainer">
														</div>
													</div>
													<div class="AllergyCell"
														style="width: auto; text-align: right">
														<div class="buttonContainer">
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
				   <div data-role = "none" class = "dvTBVContainer dvTBVContainerTheme">
				   		<div data-role = "none" class = "dvControlTable" >
				   			<div data-role = "none" class = "dvControlRow">
				   				<div data-role = "none" class = "Cell1">
				   					<div data-role = "none" class = "dvControlLabel">
				   						Vitals
				   					</div>
				   				</div>
				   				<div data-role = "none" class = "Cell2">
				   					  <select id="chartConfig" multiple="multiple" style = "margin:10px" data-type = "ComboBox">
				   					    <%
					   					 if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse())
					   					 {
						   				       int nVitalsConfigList = 0;
						   					   List<VitalsConfig> listVitalConfig = null;
						   					   if(oVitalsConfigResponse.getListVitalConfig() != null)
						   					   {
						   						   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
						   						   nVitalsConfigList = listVitalConfig.size();
						   					   }
						   					   if(nVitalsConfigList > 0)
						   					   {
							   						int nVitalsConfigLoopCount = 0;
													for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
													{
														String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
														String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
														%>
															<option value = "<%=eventCode%>"><%= DiscreteMeasureDescription%></option>
														<% 
													}
						   					   }
					   					 }
				   					    %>
								      </select>
				   					 <script>
				   					 $(document).ready(function() {
				   						 $("#chartConfig").kendoMultiSelect({
				   						  change: function(e) {
				   							 // alert(this.value())
				   							 $('#hdnComboValue').val(this.value());
				   							 loadTabularView();
				   						  }
				   						 });
				   					 });
				   					 </script>
				   				</div>
				   			</div>
				   		</div>
				   </div><!-- control container end -->
				   <div data-role = "none" class = "dvTabularView" id = "dvTabularView">
				   	
				   </div> <!-- tabular View end -->
				</div>
			</div>
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
				<input type="hidden" name="hdnComboValue" id="hdnComboValue" id="hdnComboValue"  />
		</form>
	</div>
</body>
</html>

