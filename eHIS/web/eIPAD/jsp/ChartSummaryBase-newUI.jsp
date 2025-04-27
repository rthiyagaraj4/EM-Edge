<%@page import="eIPAD.chartsummary.common.constants.WidgetItems"%>
<%@page import="eIPAD.chartsummary.common.response.WidgetOrderResponse"%>
<%@page import="eIPAD.chartsummary.common.bc.WidgetOrderBC"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo" %>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>

<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
String scrollToWidget = request.getParameter("scrollToWidget")==null?"":request.getParameter("scrollToWidget");
%>

<!DOCTYPE html> 
<html> 
<head> 
<title></title>  

<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" />   --%>

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.3.1.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.3.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADUserPre.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/ActiveProblems.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/UserPreference.js"></script>
<link href="${path}/eIPAD/css/kendo.dataviz.min.css" rel="stylesheet">
 <link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
 <link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
 <script src="${path}/eIPAD/kendo.all.min.js"></script> 
<script src="${path}/eIPAD/kendo.dataviz.min.js"></script>
<script type="text/javascript">
var CSMainScroll ;
var path;
var bclinicalNotesLoaded = false; //c
var bOrientationChanged = false; //cn
var clinicalNotesFilterBy = "A"; //cn
var notesHorizontalScroll; //cn
var currentNotesHScrollingId; //cn
var currentNotesScrollingId; //cn
var cnNoteType; //cn
var bfullViewOpen = false; //cn
var bAccordionViewLoaded = false; //cn
var arrCnVisitedPages = []; //cn
var cnCurrentPage = 0; //cn
var prevCnNoteType = ""; //cn
var bVitalsLoaded = false;
function assignCSScroll() {
		 setTimeout(function () {
			CSMainScroll = new iScroll('ChartSummaryMainWrapper', {
			useTransform: true,
			zoom: false,
			onBeforeScrollStart: function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;

			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
			e.preventDefault();
			}
			});
	}, 100); 
}
document.addEventListener('touchmove', function(e) {
	e.preventDefault();
}, false);
document.addEventListener('DOMContentLoaded', assignCSScroll, false);
//---------vitals start---------------------
//var vitalsWidth;

function assignVitalsWrapperWidth()
{
	//$("#vitalsSwipeWrapper").css("width" , "200px");//dummy width
	var swipeContentCellWidth = $("#vitalsTable").width();
	//alert(swipeContentCellWidth);
	swipeContentCellWidth = swipeContentCellWidth + "px";
	//alert(swipeContentCellWidth);
	$("#vitalsSwipeWrapper").css("width" , swipeContentCellWidth);
	
}

function assignVitalsScrollerWidth()
{
	var swipeContentCellWidth = $("#vitalsTable").width();
	var vitalsScrollerWidth = 0;
	var vitalsBubbleCount = 0;
	//vitalWidgetContainer
	$(".vitalWidgetContainer").each(function(index, value) {
		vitalsScrollerWidth = vitalsScrollerWidth + $(this).width();
		vitalsBubbleCount++;
	});
	if(vitalsScrollerWidth <= swipeContentCellWidth )
	{
		vitalsScrollerWidth = swipeContentCellWidth + "px";
	}
	else
	{
			vitalsScrollerWidth = vitalsScrollerWidth + vitalsBubbleCount * 10 + "px";
	}
	$("#vitalsScroller").css("width" , vitalsScrollerWidth);
	
}

//--------vitals end------------------------
function showFullViewNotes(obj) {
	var nt = $(obj).attr("data-expandNoteType");
	$("[data-fullView = 'true']").each(function(index, value) {
		$(this).hide();
	});
	arrCnVisitedPages = null;
	arrCnVisitedPages = [];
	$("[data-noteType = " + cnNoteType +"]").show();
	if(cnNoteType != nt)
	{
		$("[data-fullviewNoteType = " + nt +"]").show();
		$("[data-noteType = " + nt +"]").show();
		bfullViewOpen = true;
	    $("[data-fullviewNoteType = " + nt +"]").load( path + "/mobile/chartsummary/ClinicalNotesView?filterBy=" +clinicalNotesFilterBy + "&noteType=" + nt+ "&viewType=AccordionView",function(){
			$(document).ready(function(){
				//bclinicalNotesLoaded = true;
				accordionNotesViewDimensions(nt);
				horizontalNotesScroll(nt);
				scrollerRefresh(CSMainScroll);
				bAccordionViewLoaded = true;
				cnCurrentPage = 0;
				if(arrCnVisitedPages != null)
				{
					var PageID = nt + "0";
					arrCnVisitedPages.push(PageID);	
				}
			});
			
		});
	    
	    $("[data-imagaeNoteType = " + cnNoteType +"]").attr("src" , path + "/eIPAD/images/Expandview.png");
	    cnNoteType = nt;
	    $("[data-imagaeNoteType = " + nt +"]").attr("src" , path + "/eIPAD/images/Collapseview.png");
	    
	}
	else
	{
		if(bfullViewOpen)
		{
			$("[data-fullviewNoteType = " + nt +"]").hide();
			$("[data-noteType = " + nt +"]").show();
			bfullViewOpen = false;
			$("[data-imagaeNoteType = " + nt +"]").attr("src" , path + "/eIPAD/images/Expandview.png");
		}
		else
		{
			//horizontalNotesScroll(nt);
			$("[data-fullviewNoteType = " + nt +"]").show();
			$("[data-noteType = " + nt +"]").show();
			bfullViewOpen = true;
			if(notesHorizontalScroll != null)
			{
				//accordionNotesViewDimensions(cnNoteType);
				//alert(notesHorizontalScroll.currPageX);
				notesHorizontalScroll.refresh();
				//notesHorizontalScroll.scrollToPage(cnCurrentPage,0);
				//alert(notesHorizontalScroll.currPageX);
			}
			$("[data-imagaeNoteType = " + nt +"]").attr("src" , path + "/eIPAD/images/Collapseview.png");
		}
		scrollerRefresh(CSMainScroll);
	}
}
function horizontalNotesScroll(noteType)
{
	//notesHorizontalScroll = null;
	//$(".fullViewWrapper").bind('touchstart click', function(event) {
		//alert("notetype =" + noteType);
		var currentNotesId = $("[data-fullViewWrapper = " + noteType +"]").attr('id');
		//alert("hi");
		// var currentNotesId = $(this).attr('id');
		 if(currentNotesHScrollingId != null)
		 {
			 //alert("global =" +currentNotesHScrollingId);
			 //alert( "local = " + currentNotesId)
			 if(currentNotesHScrollingId != currentNotesId)
			 {
				// alert("hi2");
				 notesHorizontalScroll = new iScroll(currentNotesId, {
						hScrollbar : false,
						snap: true,
						momentum: false,
						vScroll : false,
						onScrollEnd: function () {
							//alert(this.currPageX);
							loadFullViewBubbleNotes(this.currPageX,noteType);
						}
				});
				 currentNotesHScrollingId = currentNotesId;	
			 }
		 }
		 else
		 {
			// alert("hi12");
			 currentNotesHScrollingId = currentNotesId;
			 notesHorizontalScroll = new iScroll(currentNotesId, {
					hScrollbar : false,
					snap: true,
					momentum: false,
					vScroll : false,
					onScrollEnd: function () {
						//alert(this.currPageX);
						loadFullViewBubbleNotes(this.currPageX,noteType);
					}
			});
			 
		 }
	//});
}
function scrollToPage(pageNumber,cuuDivObj,noteType)
{
	cnCurrentPage = pageNumber;

	if(notesHorizontalScroll != null)
	{
		//accordionNotesViewDimensions(cnNoteType);
		//alert(notesHorizontalScroll.currPageX);
		//notesHorizontalScroll.refresh();
		notesHorizontalScroll.scrollToPage(cnCurrentPage,0);
	//	loadFullViewBubbleNotes(pageNumber,noteType);
		//alert(notesHorizontalScroll.currPageX);
	}
}
function loadFullViewBubbleNotes(pageNumber,noteType)
{
	cnCurrentPage = pageNumber;
	//alert("pagenumber = " + cnCurrentPage);
	var pageId = noteType + pageNumber;
	if(pageNumber != null && pageNumber != "")
	{
		pageNumber = parseInt(pageNumber);	
	}
	var startIndex = 0;
	startIndex = (pageNumber * 15);
	var endIndex = startIndex + 15;
	var pageCount = $("[data-pageId = " + pageId  +"]").attr("data-pageCount");
	if(pageCount != null && pageCount != "")
	{
		pageCount = parseInt(pageCount);	
	}
	//alert($.inArray(pageId, arrCnVisitedPages));
	var bPageIdLoaded = false;
	if(arrCnVisitedPages != null && $.inArray(pageId, arrCnVisitedPages) != -1)
	{
		bPageIdLoaded = true;	
	}
	//alert("pageloaded =" + bPageIdLoaded)
	if(pageCount > 1 && !bPageIdLoaded)
	{
		$("[data-pageId = " + pageId  +"]").load( path + "/mobile/chartsummary/ClinicalNotesView?filterBy=" +clinicalNotesFilterBy + "&noteType=" + noteType+ "&viewType=addNoteBubble&startIndex=" + startIndex+ "&endIndex=" + endIndex,function(){
			
		});
	}
	$("[data-pageIconNoteType= "+ noteType+"]").each(function(index, value) {
		
		 $(this).removeClass("selectedPageIcons").addClass("normalPageIcons");
		 if($(this).attr("data-pageIconNumber") == pageNumber)
		 {
			 $(this).removeClass("normalPageIcons").addClass("selectedPageIcons");
		 }
	});
	
	arrCnVisitedPages.push(pageId);
}
function accordionNotesViewDimensions(noteType)
{
	var count = 0;
	$("[data-child = " + noteType +"]").each(function(index, value) {
		count++;
	});
	var fullViewScrollerWidth = count * 100 + "%";

	$("[data-fullViewScroller = " + noteType +"]").each(function(index, value) {
		
		$(this).css("width", fullViewScrollerWidth);

	});
	var childWidth = 100 / count + "%";

	$("[data-child = " + noteType +"]").each(function(index, value) {
		
		$(this).css("width", childWidth);
	});
}

function loadClinicalNotes(filterBy,viewPage,finalStartDate,finalEndDate,encounterID){
	if(filterBy == "A")
	{	
		clinicalNotesFilterBy = "";
	}
	else if(filterBy == "N")
	{		
		if(clinicalNotesFilterBy != null  &&  clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf("NUR$") == -1 )
		{
			clinicalNotesFilterBy = clinicalNotesFilterBy + ",NUR$";
		}
		else
		{
			clinicalNotesFilterBy = "NUR$";
		}
	}
	else if(filterBy == "P")
	{
		if(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf("PHY$") == -1)
		{
			clinicalNotesFilterBy = clinicalNotesFilterBy + ",PHY$";
		}
		else
		{
			clinicalNotesFilterBy = "PHY$";
		}
	}
	else if(filterBy == "C")
	{
		if(clinicalNotesFilterBy != null && clinicalNotesFilterBy.length > 0 && clinicalNotesFilterBy.indexOf("CLI$") == -1)
		{
			clinicalNotesFilterBy = clinicalNotesFilterBy + ",CLI$";
		}
		else
		{
			clinicalNotesFilterBy = "CLI$";
		}
	}
	else
	{
		clinicalNotesFilterBy = "";
	}
	
	var firstClick=false;
	var splAvailable=null	;
	if($("[filter-type="+filterBy+"]").hasClass('notesIconSelectedTheme'))
	{
		firstClick=true;
		clinicalNotesFilterBy = "";
		splAvailable="";
		$(".dataContainerFullView").show();			
		$("#CNdivcnt").find(".clinicalNotesContent").show();  
	}
	else
	{
		splAvailable=viewPage;		
		$("#CNdivcnt").find(".clinicalNotesContent").show();  
	}
	
if(viewPage=='widgetView'){	
     	$("#clinicalNotesFrame").append("<div class='loadingCartItem'></div>");	
	    $("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=widgetView&filterBy=" +clinicalNotesFilterBy,function(){
		scrollerRefresh(CSMainScroll);
		bclinicalNotesLoaded = true;
		bfullViewOpen = false;
		cnNoteType = "";
		bAccordionViewLoaded = false;
		currentNotesHScrollingId = "";
		arrCnVisitedPages = null;
		arrCnVisitedPages = [];
		cnCurrentPage = 0;
		
		$("[data-filterIcon = 'T']").each(function(index, value) {
			if($(this).attr('filter-type') != filterBy){
				$(this).removeClass("notesIconSelectedTheme");
			}
			});
			
			
		if(firstClick){
			
					$("[filter-type="+filterBy+"]").removeClass("notesIconSelectedTheme");
				}else{
					
					$("[filter-type="+filterBy+"]").addClass("notesIconSelectedTheme");
		}
		
	});
	}
	
else
{
	$("#clinicalNotesFrame").append("<div class='loadingCartItem'></div>");
	$("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=widgetView&filterBy=" +clinicalNotesFilterBy,function(){
		scrollerRefresh(CSMainScroll);
		bclinicalNotesLoaded = true;
		bfullViewOpen = false;
		cnNoteType = "";
		bAccordionViewLoaded = false;
		currentNotesHScrollingId = "";
		arrCnVisitedPages = null;
		arrCnVisitedPages = [];
		cnCurrentPage = 0;
		
		
		var arrSPL =[];			
		$(".dataContainerFullView").hide();
		arrSPL.push(splAvailable); 
		if(splAvailable)
		{
			var specialityCount = document.getElementById("hdnCount").value;
			for(var i=0; i<specialityCount; i++){
				var noteType = document.getElementById("hdnSpeciality"+i).value;
				$('.dataContainerFullView[data-notetype='+noteType+']').show();
			}			
		}
		else
		{
			
			$(".dataContainerFullView").each(function(){
				$(this).show();
			});
		}
	
		$("[data-filterIcon = 'T']").each(function(index, value) {
				if($(this).attr('filter-type') != filterBy)
				{
					$(this).removeClass("notesIconSelectedTheme");
				}
			});
			if(firstClick){
					$("[filter-type="+filterBy+"]").removeClass("notesIconSelectedTheme");
					
				}else{
					$("[filter-type="+filterBy+"]").addClass("notesIconSelectedTheme");
					
			}
		hideNoteAndBubbles();
		 //var splWidgetCount =$('.clinicalNotesContent:visible').length; dataContainerFullView
		 //$('#ClinicalNotesCountBtn').val(splWidgetCount);
		 
		 if(filterBy == "SPL"){
		 var splWidgetCount =$('.dataContainerFullView:visible').length; 
		 $('#ClinicalNotesCountBtn').val(splWidgetCount);
		 }
		
		if($('.clinicalNotesContent:visible').length >= 1){
			$('.mySpecialityNoRecords').hide();
			scrollerRefresh(CSMainScroll)
		}else{
			$('.mySpecialityNoRecords').show();
			scrollerRefresh(CSMainScroll)
		}
	});
	
}
   hideNoteAndBubbles();
   clinicalNotesFilterBy = "";// clear all exist filters

}
function hideNoteAndBubbles(){
	$(".clinicalNotesContent").each(function (i,v ){
				 if ($(this).find(".dataContainerFullView:visible").length == 0)
				 {
					$(this).hide();
				 }
				 else{
					 $(this).show();
				 }	 
			});
			$(".bubbleDivider").each(function (i,v ){
				if($(this).prevUntil(".bubbleDivider").is(":visible") && $(this).nextUntil(".bubbleDivider").is(":visible") ){
					$(this).show();
				}else{
					$(this).hide();
				}
			});
}

function userInstances(){
	
	this.userInsName="";
	this.userInsCont="";
	
}

function checkForUndefined(userValue){
	
	if(userValue==undefined){
		
		userValue="0";
	}
	
	return userValue;
}

function updateWidgetItemsCount(){
 
 var ClinicalNotesCount =$("#ClinicalNotesCountBtn").val();
 console.log("ClinicalNotesCount:"+checkForUndefined(ClinicalNotesCount));
 $("#countDisplayNOTES").text(checkForUndefined(ClinicalNotesCount));
	//clicnical notes
	
	//ClinicalNotesCountBtn
	
	 var allergyCount =$("#allergyViewCount").val();
	 console.log("allergyCount:"+checkForUndefined(allergyCount));
	$("#countDisplayALLERGY").text(checkForUndefined(allergyCount));
	//allergy
	
	//allergyViewCount
	
	
	var procedureDetailsCount =$("#procedureDetailsViewCount").val();
	console.log("procedureDetailsCount:"+checkForUndefined(procedureDetailsCount));
	$("#countDisplayPROCEDURE").text(checkForUndefined(procedureDetailsCount));
	//procedure details viewPage
	
	//procedureDetailsViewCount
	
	
	var activeProblemCount =$("#activeProblemViewCount").val();
	console.log("activeProblemCount:"+checkForUndefined(activeProblemCount));
	$("#countDisplayPROBLEMS").text(checkForUndefined(activeProblemCount));
	//active problem
	
	//activeProblemViewCount
	
	
	var resultsCount =$("#resultsViewCount").val();
	console.log("resultsCount:"+checkForUndefined(resultsCount));
	$("#countDisplayRESULTS").text(checkForUndefined(resultsCount));
	//Results 
	
	//resultsViewCount
	
	var pendingOrderCount =$("#pendingOrderViewCount").val();
	console.log("pendingOrderCount:"+checkForUndefined(pendingOrderCount));
	$("#countDisplayPENDINGORDERS").text(checkForUndefined(pendingOrderCount));
	//pending Order
	
	//pendingOrderViewCount
	var currentMedicationCount =$("#currentMedicationViewCount").val();
	console.log("currentMedicationCount:"+checkForUndefined(currentMedicationCount));
	$("#countDisplayMEDICATIONS").text(checkForUndefined(currentMedicationCount));
	//current medication
	
	//currentMedicationViewCount

}

$(document).ready(function(){
	
	//var allAddedCount=[];
	
	$("#userPrefernceMainWrapper").hide();
	
	parent.setOnLoadContentPaneHeight();
	path = $('#hdnPath').val();
	$("#VitalsFrame").load(path + "/LatestVitals?isRankRequired=S&fromScreen=CV" ,function(response, status, xhr){
		//alert("hi");
		//alert(status);
		//alert(xhr.statusText);
		if(status == "error")
		{
			$("#transactionMessageContent").append("Error in Loading Vitals View");
			
			$("#transactionMsg").attr("class" , "formValErrorTheme CSTransactionMessage");
			showTransactionMessage();
		}
		else
		{
			//allAddedCount.push();
			updateWidgetItemsCount();
			scrollerRefresh(CSMainScroll);
			bVitalsLoaded = true;
		}

	});
	var scrollToWidget = $("#scrollToWidget").val();
	$("#AllergyWidgetframe").append("<div class='loadSpinner'></div>");
	$("#AllergyWidgetframe").load( path + "/chartsummary/AllergyServlet",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
	});
	$("#procWidgetframe").append("<div class='loadSpinner'></div>");
	$("#procWidgetframe").load( path + "/mobile/chartsummary/ProcedureView",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
	});
	$("#ProblemsDiagnosisWidgetframe").append("<div class='loadSpinner'></div>");
	$("#ProblemsDiagnosisWidgetframe").load( path + "/mobile/chartsummary/ProblemsDiagnosisView",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
		setTimeout(function () {
		if(scrollToWidget && scrollToWidget=="APD"){
			CSMainScroll.scrollToElement(".ProblemsDiagnosisWidgetframe",0);
		}
		}, 100);
	});
	$("#ResultsWidgetframe").append("<div class='loadSpinner'></div>");
	$("#ResultsWidgetframe").load( path + "/mobile/chartsummary/ResultsView",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
	});
	$("#PendingOrdersframe").append("<div class='loadSpinner'></div>");
 	$("#PendingOrdersframe").load( path + "/mobile/chartsummary/PendingOrdersView",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
	});
	$("#CurrentMedicationFrame").append("<div class='loadSpinner'></div>");
 	$("#CurrentMedicationFrame").load( path + "/mobile/chartsummary/CurrentMedicationView?filterByVal=all",function(){
		updateWidgetItemsCount();
		scrollerRefresh(CSMainScroll);
	});
	loadClinicalNotes("A");//cn	
	if(transactionOccured){
		showTransactionMessage();
	}

});

function scrollerRefresh(scroller){
	if(scroller != null){
		scroller.refresh();
	}
	
}
var width;
function assignSliderWidth()
{	
	$(".swipeWrapper").each(function(index, value) {  
		$(this).css("width","200px"); // assigning dummy width.
	
	});
   // var notesScrollerWidth = 0;
	$(".swipeTable").each(function(index, value) {      
		var contentCount =  $(this).attr('data-count');
		//var noteTypeValue = $(this).attr('data-noteType');
		 width = $(this).width() - $("[data-content = '" + contentCount + "']").width();
		
		$(".swipeWrapper").each(function(index, value) {  
			$(this).css("width",width);
			var idCount = $(this).attr('data-IdCount');
		
		});//swipewrapper
		
    });//swipetable

}
function setScrollerWidth()
{
	var swipecount = 1;
	$(".swipeWrapper").each(function(index, value) {  	
		var idCount = $(this).attr('data-IdCount');
		var noteTypeValue = $(this).attr('data-noteType');
		var noteScrollerWidth = 0;
		
		$("[data-noteTypeValue = '" + noteTypeValue + "']").each(function(index, value) { 
			noteScrollerWidth = noteScrollerWidth + $(this).width();
			swipecount++;
		});//notetype
		if(noteScrollerWidth < width)
			noteScrollerWidth = width  + "px";
		else
			noteScrollerWidth =  noteScrollerWidth  + swipecount * 8+"px";
				
		$('#notesScroller' + idCount).css("width",noteScrollerWidth);
		//noteScrollerWidth = 0;
	});//swipewrapper
}
function changeOrientation(orient, EMHFheight)
{
	bOrientationChanged = true; //cn
	var CSHFheight = $('#CSHeader').height() + $('#CSFooter').height();
	var content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px
	document.getElementById("ChartSummaryMainWrapper").style.height = content_height+"px";
	
	
	if(bVitalsLoaded)
	{
		$("#vitalsSwipeWrapper").css("width" , "10px");
	}
	/*
	if(CSMainScroll != null)
		CSMainScroll.refresh();
	*/
	if(bclinicalNotesLoaded)
	{
		assignSliderWidth();
		setScrollerWidth();
		if(myScrollnotes != null)
		{
			myScrollnotes.refresh();	
		}
		//alert(notesHorizontalScroll);
		if(bAccordionViewLoaded)
		{
			//accordionNotesViewDimensions(cnNoteType);
		}
		if(notesHorizontalScroll != null)
		{
			//accordionNotesViewDimensions(cnNoteType);
			//alert(notesHorizontalScroll.currPageX);
			notesHorizontalScroll.refresh();
			notesHorizontalScroll.scrollToPage(cnCurrentPage,0);
			//alert(notesHorizontalScroll.currPageX);
		}
	}
	if(bVitalsLoaded)
	{
		assignVitalsWrapperWidth();
		assignVitalsScrollerWidth();
		if(vitalsScroll != null)
		{
			vitalsScroll.refresh();	
		}
		
	}
	if(CSMainScroll != null)
		CSMainScroll.refresh();
}
function showTransactionMessage(){
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}

var transactionOccured = false;
function closeChartSummary(){
	parent.closeChartSummary();
	
}
var EncListScroll;
function toggleEncListPopup(){
	if(EncListScroll == null){
		EncListScroll = new iScroll('EncListcontainer-wrapper', {
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
	}
	$("#EncListPopup").toggle();
	if($('#EncListPopup').is(':visible')){
		$('#dvMez').show();
		$("#dvMez").data("popid","EncListPopup");
		setTimeout(function() {
			$("#dvMez").on("click",closeMez);
		}, 500);
	}
	if($('#EncListPopup').is(':hidden')){
		$('#dvMez').hide();
		$("#dvMez").data("popid","");
		$("#dvMez").off();
	}
	if(EncListScroll!=null && $('#EncListPopup').is(':visible')){
		EncListScroll.refresh();
	}

}
function closeMez(){
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").hide();
	$("#dvMez").off();
}

function chooseEncounter(encIdSelected){
	parent.chooseEncounter(encIdSelected);
}

function chooseEncounterForNote(encIdSelected, openingPage){
	 parent.chooseEncounterForNote(encIdSelected,openingPage);
}

function closePopup(popupId){
	var popupObj = $("#"+popupId);
	$("#dvMez").hide();
	$("#dvMez").data("popid","");
	$(popupObj).hide();
	$("#dvMez").off();
}

function openOrdersFrame(){
	$("#PageLoadingAnimation").show();
	window.location.replace(path+"/mobile/charts/orders/MNewOrderServlet");
}
function openChartSummaryFrame(){
	$("#PageLoadingAnimation").show();
	window.location.replace(path+"/mobile/chartsummary/ChartWidgetsView");
}
function openClinicalNotes(){
	$("#PageLoadingAnimation").show();	
	window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet"); 

}
function openClinicalEvents(){
	$("#PageLoadingAnimation").show();
	//window.parent.$('#hdnopeningPage').val('clinicalEvents');
	//window.parent.$("#ChartsBaseForm").submit();
	window.location.replace(path+"/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventsBasePage.jsp"); 
}
function openPharmacyOrders(){
	$("#PageLoadingAnimation").show();
	parent.openPharmacyOrders();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
#ChartSummaryMainWrapper .loadSpinner {
	width: 100%;
	height: 80px;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	position:static;
}
</style>
<%
TransactionResponse transactResp;
String formValErrClass = "";
String transactMsg = "";
if(request.getAttribute("TRANSACTION_RESPONSE") != null){%>
	<script>
			transactionOccured = true;
	</script>
	<%
	transactResp = (TransactionResponse)request.getAttribute("TRANSACTION_RESPONSE");
	ArrayList<ErrorInfo> errorList = transactResp.getErrorsList();
	for(ErrorInfo e:errorList){
		transactMsg = transactMsg + e.getErrorMessage() + " ";
	}
	if(transactResp.getTransactionResult() == TransactionResponse.SUCCESS){ 
		formValErrClass= "formValSuccessTheme";
	}
	else{
		formValErrClass= "formValErrorTheme";
	}
}

EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
EncounterHO currentEncounter = new EncounterHO();
if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
	allEncArrayList = allEncountersResp.getEncounterList();
	currentEncounter = allEncArrayList.get(0);
}
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String selectedEncounter = "";
boolean secondaryEncSelected = false;
int selectedEncIndex = 0;
if(patientContext.getSelectedEncounterId()!= null && !patientContext.getSelectedEncounterId().equals("")){
	selectedEncounter = patientContext.getSelectedEncounterId();
	secondaryEncSelected = true;
}
%> 


</head>
<body style="display: block; margin: 0px; height: 100%; width: 100%;">
<div id="PageLoadingAnimation" class="absoluteCenter"></div>
	<div class = "ChartSummaryParent ChartSummaryParentTheme" data-role="page">
		<div class="ChartSummaryBlock" id="ChartSummaryBlock" data-role = "none">
			<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
				<div class="ChartSummaryMainTable" style="position:relative;" data-role = "none">
					<div data-role = "none" class ="ChartSummaryPageHeader" id="CSHeader">
						<div class="ChartSummaryHeaderCell" data-role = "none">
							<div class="ChartSummaryHeaderCont" data-role = "none">
							
							
								<!-- Encounter popup starts -->
								<div id="EncListPopup" class="EncListPopParentContainer">
									<div class="EncListPopupArrowUpTheme"></div>
									<div class="EncListAreaContainer EncListAreaContainerTheme">
										<div style="display:table;width:100%">
<!-- 											<div style="display:table-row">
												<div style="display:table-cell">
												Header starts here
													<div style="display:table;width:100%" class="EncPopHeaderHeader EncPopHeaderHeaderTheme">
														<div style="display:table-row">
															<div style="display:table-cell;width:25%;vertical-align:middle;text-align:center">
																<div class="EncPopHeaderButtonTheme" style="text-align:center" onclick="hideEncListPopup()">Cancel</div>
															</div>
															<div class="EncPopHeaderTextTheme" style="display:table-cell;vertical-align:middle;width:50%">Encounter</div>
															<div style="display:table-cell;width:25%;vertical-align:middle;text-align:center">
																<div class="EncPopHeaderButtonTheme" style="text-align:center" onclick="chooseEncounter('')">Current</div>
															</div>
														</div>
													</div>
												header ends here
												</div>
											</div> -->
											<!-- <div style="display:table-row">
												<div style="display:table-cell">
												Slider for Patient class filter starts here
													<div class="EncPopClassFilterContainer">
														<div style="display:table;width:100%;" class="EncPopSliderContainerTheme EncPopSliderContainer">
														
														</div>
													</div>
												Slider for Patient class filter starts here
												</div>
											</div> -->
											<div style="display:table-row">
												<div style="display:table-cell">
												<!--All Encounters List content starts here-->
													<div class="EncPopCurrentEncContainerTheme">
														<div style="display:table;width:100%">
															<div style="display:table-row">
																<div style="display:table-cell" class="EncPopCurrentEncStripTheme">
																<!-- Current/Base Encounter item starts -->
																	<div style="display:table;width:100%"  onclick="chooseEncounter('')">
																		<div style="display:table-row;" class="EncPopListRow" >
																			<div style="display:table-cell;" class="EncPopListIconCol"><img src="${path}/eIPAD/images/OutPatient32x32.png"></div>
																			<div style="display:table-cell;" class="EncPopListDetCol">
																				<div class="EncPopCurPractTextTheme"><%=currentEncounter.getPractShortName()%></div>
																				<div class="EncPopCurIdTextTheme">EN ID - <%=currentEncounter.getEncounterId()%></div>
																			</div>
																			<div style="display:table-cell;vertical-align:bottom;text-align:right"><div  class="EncPopCurDateTextTheme"><%=currentEncounter.getFromDate() %></div></div>
																			<div style="display:table-cell;" class="EncPopListIconCol"></div>
																		</div>
																	</div>
																<!-- Current/Base Encounter item ends -->
																</div>
															</div>
														</div>
													</div>
													<div>
														<div style="display:table;width:100%">
															<div style="display:table-row">
																<div style="display:table-cell">
																<!-- Other Encounter items scroller starts-->
																	<div id="EncListcontainer-wrapper" class="EncListPopupWrapper">
																		<div id="EncListcontainer-contents" class="EncListPopupScroller">
																		<%if(allEncArrayList!=null && allEncArrayList.size()>1){
																		%>
	
																			<%for(int i=1;i<allEncArrayList.size();i++){ 
																			EncounterHO iEncounter = allEncArrayList.get(i);
																			String cssClassName = "EncPopNormEncStripTheme";
																			if(secondaryEncSelected && selectedEncounter.equals(iEncounter.getEncounterId())){
																				cssClassName = "EncPopSelEncStripTheme";
																				selectedEncIndex = i;
																			}
																			%>
																			<!-- Other Encounter items starts -->
																			<div style="display:table;width:100%" class="<%=cssClassName %>" onclick="chooseEncounter('<%=iEncounter.getEncounterId()%>')">
																				<div style="display:table-row;" class="EncPopListRow" >
																					<div style="display:table-cell;" class="EncPopListIconCol"><img src="${path}/eIPAD/images/OutPatient32x32.png"></div>
																					<div style="display:table-cell;" class="EncPopListDetCol">
																						<div class="EncPopPractTextTheme"><%=iEncounter.getPractShortName()%></div>
																						<div class="EncPopIdTextTheme">EN ID - <%=iEncounter.getEncounterId()%></div>
																					</div>
																					<div style="display:table-cell;vertical-align:bottom;text-align:right"><div  class="EncPopDateTextTheme"><%=iEncounter.getFromDate() %></div></div>
																					<div style="display:table-cell;" class="EncPopListIconCol"><img src="${path}/eIPAD/images/Right_Arrow.png"></div>
																				</div>
																			</div>
																			<%
																			}
																			
																			%>
																			<!-- Other Encounter items ends -->

																		<%} %>
																		</div>
																	</div>
																
																<!-- Other Encounter items scroller ends  -->
																</div>
															</div>
														</div>
													</div>
												<!--All Encounters List content ends here -->
												</div>
											</div>
										</div>
										
									</div>
								</div>
								<!-- Encounter popup ends -->
					
								<% 
									String encLeftNaviStyle = "WidgetButtonTheme";
									String encRightNaviStyle = "WidgetButtonTheme";
									String encLeftNaviClickFunc = "";
									String encRightNaviClickFunc = "";
									if(selectedEncIndex <= 0){
										encLeftNaviStyle = "WidgetButtonDisableTheme";
									}
									//select base encounter
									else if(selectedEncIndex == 1){
										encLeftNaviClickFunc = "chooseEncounter('')";
									}
									else{
										encLeftNaviClickFunc = "chooseEncounter('"+allEncArrayList.get(selectedEncIndex-1).getEncounterId()+"')";
									}
									if(selectedEncIndex+1 >= allEncArrayList.size()){
										encRightNaviStyle = "WidgetButtonDisableTheme";
									}
									else{
										encRightNaviClickFunc = "chooseEncounter('"+allEncArrayList.get(selectedEncIndex+1).getEncounterId()+"')";
									}
								%>
							
								<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
									<div class="ChartSummaryHeaderRow" data-role = "none">
										<div class="ChartSummaryHeaderIconCol">
											<div class="WidgetButtonTheme" id="userPrefrences" onclick="userPreferedClick();"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
										</div> 
										
									<%-- 	<div class="ChartSummaryHeaderIconCol button" data-role = "none">
											<div class="WidgetButtonTheme " data-role = "none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
										</div>
										 --%>
										
										<div class="ChartSummaryHeaderTextCol" data-role = "none">
											<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none"><%=csResBundle.getString("common.chartSummary") %></div><!-- TODO replace with message bundle text -->
										</div> 
										<div class="ChartSummaryHeaderEncLeftCol" data-role = "none">
											<div class="<%=encLeftNaviStyle %>" data-role = "none" onclick="<%=encLeftNaviClickFunc%>"><img src="${path}/eIPAD/images/Previous16x16.png"></div>
										</div>
									<%-- 	<div class="ChartSummaryHeaderEncLeftCol" data-role = "none">
											<div class="<%=encLeftNaviStyle %>" data-role = "none" onclick="<%=encLeftNaviClickFunc%>"><img src="${path}/eIPAD/images/Previous16x16.png"></div>
										</div> --%>
										<div class="ChartSummaryHeaderEncListCol" data-role = "none">
											<%-- <div class="CSHeaderEncID" onclick="toggleEncListPopup()">
												<div class="CSHeaderEncIDLabel"><%=csResBundle.getString("common.enId") %></div>
												<div class="CSHeaderEncIDLabel"><%=allEncArrayList.get(selectedEncIndex).getEncounterId()%>,</div>
												<div class="CSHeaderEncIDLabel"><%=allEncArrayList.get(selectedEncIndex).getPatientClass()%></div>
												<div class="CSHeaderEncIDLabelright"><img src="${path}/eIPAD/images/Down12x12.png" class="ChartSummaryHeaderEncDrpImg">	</div>
												<div class="CSHeaderEncIDLabelright"><%if(selectedEncIndex+1<10){%>0<%}%><%=selectedEncIndex+1%>/<%if(allEncArrayList.size()<10){%>0<%}%><%=allEncArrayList.size()%>	</div>
											</div> --%>
											<%-- <%if(allEncArrayList.size() > 1){%>toggleEncListPopup()<%}%> --%>
											<div class="ChartSummaryHeaderEncList ChartSummaryHeaderEncListTheme" data-role = "none" style="display:table" onclick="toggleEncListPopup()">
												<div class="ChartSummaryHeaderEncLstContainer" data-role = "none">
													<div class="ChartSummaryHeaderEncIDLabel" data-role = "none"><%=csResBundle.getString("common.enId") %> - </div> <!-- TODO replace with localized text -->
													<div class="ChartSummaryHeaderEncID" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getEncounterId()%>,</div>
													<div class="ChartSummaryHeaderEncPatClass" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getPatientClass()%> - </div>
													<div class="ChartSummaryHeaderEncPracName" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getPractShortName()%></div>
													<div class="ChartSummaryHeaderEncCount" data-role = "none"><%if(selectedEncIndex+1<10){%>0<%}%><%=selectedEncIndex+1%>/<%if(allEncArrayList.size()<10){%>0<%}%><%=allEncArrayList.size()%></div>
													<div class="ChartSummaryHeaderEncDrpIcon" data-role = "none"><img src="${path}/eIPAD/images/Down12x12.png" class="ChartSummaryHeaderEncDrpImg"></div>
												</div>
											</div>
										</div>
										
										<div class="ChartSummaryHeaderEncRightCol" data-role = "none">
											<div class="<%=encRightNaviStyle %>" data-role = "none" onclick="<%=encRightNaviClickFunc%>"><img src="${path}/eIPAD/images/Next16x16.png"></div>
										</div>
										<div class="ChartSummaryHeaderEncRightCol" data-role="none">
											<div class="WidgetButtonTheme" data-role = "none" onclick="closeChartSummary()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="ChartSummaryPageContent">
						<div data-role = "none" class = "ChartSummaryPageContentCell">
							<div data-role = "none" class = "ChartSummaryMainWrapper" id="ChartSummaryMainWrapper" style=" overflow:hidden;position:relative">
							
								   <div class="ChartSummaryMainScroller" style="width:100%;overflow:hidden" data-role = "none"><!-- scrolling content starts -->
								    
								   
									<%
									WidgetOrderBC bc = new WidgetOrderBC();
									
									
									 
									 
									WidgetOrderResponse widgetOrderResp = bc.getUserWidgetOrder(patientContext);
									if(widgetOrderResp.isSuccessResponse()){
										ArrayList<WidgetItems> activeWidgets = widgetOrderResp.getActiveWidgets();
										for(int x=0;x<activeWidgets.size();x++){
											WidgetItems currentItem = activeWidgets.get(x); 
											if(currentItem.getWidgetId().equals(WidgetItems.VITALS.getWidgetId())){
									%>
												<div data-role = "none" id = "VitalsFrame" class="ChartWidgetframe VITALS" style = "padding:0px"></div>
									<%
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.ALLERGY.getWidgetId())){
									%>
												<div id="AllergyWidgetframe" class="ChartWidgetframe ALLERGY" style = "padding:0px"></div>
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PROCEDURE.getWidgetId())){
									%>
												<div id="procWidgetframe" class="ChartWidgetframe PROCEDURE" data-role = "none" style = "padding:0px"></div>
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PROBLEMS.getWidgetId())){
									%>
												<div id="ProblemsDiagnosisWidgetframe" class="ChartWidgetframe PROBLEMS ProblemsDiagnosisWidgetframe" data-role = "none" style = "padding:0px"></div>
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.NOTES.getWidgetId())){
									%>
												<div id="clinicalNotesFrame" class="ChartWidgetframe NOTES" data-role = "none" style = "padding:0px"></div>
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.RESULTS.getWidgetId())){
									%>
												<div id="ResultsWidgetframe" class="ChartWidgetframe RESULTS" data-role = "none" style = "padding:0px"></div>
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.PENDINGORDERS.getWidgetId())){
									%>
												<div id="PendingOrdersframe" class="ChartWidgetframe PENDINGORDERS" data-role = "none" style = "padding:0px"></div>					
									<%			
											}
											else if(currentItem.getWidgetId().equals(WidgetItems.MEDICATIONS.getWidgetId())){
									%>
												<div id="CurrentMedicationFrame" class="ChartWidgetframe MEDICATIONS" data-role = "none" style = "padding:0px"></div>								
									<%			
											}
									%>
									<%
										}
									}
									else{ %>
									<div data-role = "none" id = "VitalsFrame" class="ChartWidgetframe" style = "padding:0px"></div>
									<div id="AllergyWidgetframe" class="ChartWidgetframe" style = "padding:0px"></div>
									<div id="procWidgetframe" class="ChartWidgetframe" data-role = "none" style = "padding:0px"></div>
									<div id="ProblemsDiagnosisWidgetframe" class="ChartWidgetframe ProblemsDiagnosisWidgetframe" data-role = "none" style = "padding:0px"></div>
									<div id="clinicalNotesFrame" class="ChartWidgetframe" data-role = "none" style = "padding:0px"></div>
									<div id="ResultsWidgetframe" class="ChartWidgetframe" data-role = "none" style = "padding:0px"></div>
									<div id="PendingOrdersframe" class="ChartWidgetframe" data-role = "none" style = "padding:0px"></div>
									<div id="CurrentMedicationFrame" class="ChartWidgetframe" data-role = "none" style = "padding:0px"></div>
									
									<%} %>
								</div><!-- scrolling content ends -->
								<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="closeMez()" data-popid=""></div>
								
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - STARTS -->
								<div id="CSCommonPopUpContainer" class="CSCommonPopUpContainer">
									<!-- <div id="CSCommonPopUpContainer-arrowUp" class="CSCommonPopup-arrowUpTheme"></div> -->
									<div  class="CSCommonPopup CSCommonPopupTheme">
										<div style="display:table;width:100%;height:100%">
											<div style="display:table-row">
												<div style="display:table-cell;height:40px">
													<div style="display:table" class="CSCommonPopupHeader CSCommonPopupHeaderTheme">
														<div style="display:table-row">
															<div style="display:table-cell;width:100px;vertical-align:middle;text-align:left">
																<div class="CSCommonPopupCloseBtnTheme" id="CSCommonPopupCloseBtn" onclick="closePopup('CSCommonPopUpContainer')">Close</div>
															</div>
															<div style="display:table-cell;width:80%;vertical-align:middle;text-align:center;padding-right:150px;" class="CSCommonPopupHeaderTextTheme" id="CSCommonPopUpContainer-title"></div>
														</div>
													</div>
												</div>
											</div>
											<div style="display:table-row; ">
												<div class="SFSBackgroundTheme" style="display:table-cell;/* width:100% */;">
											<div id="CSCommonPopUpContainer-wrapper" class="CSCommonPopupWrapper" style="margin:10px;background:#fff;height:332px;">
													
														<div id="CSCommonPopUpContainer-scroller" class="CSCommonPopupScroller">
															<div id="CSCommonPopUpContainer-contents" class="CSCommonPopupContents">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- <div id="CSCommonPopUpContainer-arrowDown" class="CSCommonPopup-arrowDownTheme"></div> -->
								</div>
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - ENDS-->
								
								<!-- Transaction message -->
								<div class="<%=formValErrClass %> CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"><%=transactMsg %></div>
								</div>
								<!-- End of Transaction message -->
								<div class=" CSTransactionMessage" id="transactionMsg_userpref" style="bottom: 10px; left: 10px; display: none;z-index:10000">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent_userpref"></div>
								</div>
								
							</div>

						</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageFooter"  id="CSFooter">
						<div data-role = "none" class = "ChartSummaryPageFooterCell">
						<div data-role = "none" class = "ChartSummaryPageFooterCont">
							<div data-role = "none" class = "ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme">
								<div data-role = "none" class = "ChartSummaryPageFooterRow">
									<div data-role = "none" class = "ChartSummaryPageFooterFirstCol" style=""></div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme" onclick="openChartSummaryFrame()">
										<div data-role = "none" class = "ChartSummaryPageFooterText"><%=csResBundle.getString("common.chartSummary") %></div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openClinicalNotes()"><!-- openClinicalNotes() -->
										<div data-role = "none" class = "ChartSummaryPageFooterText"> Clinical<br/>Notes</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOrdersFrame()">
										<div data-role = "none" class = "ChartSummaryPageFooterText"><%=csResBundle.getString("common.order") %></div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openClinicalEvents()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Clinical Events</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openPharmacyOrders()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Pharmacy Order</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterLastCol" style=""></div>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<div data-role = "none" class = "userPrefernceMainWrapper" id="userPrefernceMainWrapper" 
				style="top:42px;bottom:0px;left: 0;z-index: 6000;overflow: hidden;position: absolute;margin-left: 0px;width: 100%;display: table-row;">
				</div>
				<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
				<input type = "hidden" name = "scrollToWidget" id = "scrollToWidget" value ="<%=scrollToWidget %>" />

			</form>
		</div>
	</div>

</body>
</html>


