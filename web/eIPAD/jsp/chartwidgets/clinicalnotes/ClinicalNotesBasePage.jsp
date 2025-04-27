<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo" %>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>

<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
PatContext patientContextInsit = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
String currentEcID = patientContextInsit.getEncounterId();
	
%>

<!DOCTYPE html> 
<html> 
<head> 
<title></title>  

<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.3.1.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.3.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/mCommon.css" /> 
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<script type="text/javascript">

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
var bclinicalNotesLoaded = false; //cn
var currentNotesScrollingId; //cn
var currentNotesHScrollingId; //cn
var CSMainScroll ;
var notesHorizontalScroll; //cn
var path;
var AccNumber = [];

$(document).ready(function(){
	path = $('#hdnPath').val();
	var transactionOccurred = $("#transactionOccurred").val();
	if(transactionOccurred == 'true'){
		showTransactionMessage();
	}
$(window).resize(function() {
		 var resWidth =($(window).width() - 235)+'px';
		   $('.rightContentWrap').css({'width':resWidth});
		   assignSliderWidth();
		   setScrollerWidth()
	});
	
    $("#SlideSfsFrame").append("<div class='loadingCartItem'></div>");	
	//$("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet");
	
	/*if($('#hdnCurrentEncID').val() != undefined){
		//$("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet?encounterID="+$('#hdnCurrentEncID').val());
		chooseEncounterFilter($('#hdnCurrentEncID').val(),'clinicalNotes','fullViewEncounter');
	}*/
});

function showTransactionMessage(){
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}
function addCnoteSpinner(){
	$("#ChartSummaryBlock").find("#ClinicalNotes").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function remCnoteSpinner(){
	$("#ChartSummaryBlock").find("#ClinicalNotes").find("#spinnerDiv").remove();
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

	window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet");
}
function openClinicalEvents(){
	$("#PageLoadingAnimation").show();
	window.parent.$('#hdnopeningPage').val('clinicalEvents');
	window.parent.$("#ChartsBaseForm").submit();
}
function openPharmacyOrders(){
	$("#PageLoadingAnimation").show();
	parent.openPharmacyOrders();
}
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
		},
		bounce: false,
	    //momentum: false
		useTransform: true,
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true
		});
}, 100); 
}
document.addEventListener('DOMContentLoaded', assignCSScroll, false);

function loadClinicalNotes(filterBy,viewPage,finalStartDate,finalEndDate,encounterID){
	
	//clinicalNotesFilterBy = filterBy;
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
		//clinicalNotesFilterBy = "PHY$";
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
		//clinicalNotesFilterBy = "CLI$";
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
		
	
		
	if(viewPage=='fullView'){
		
		
     	
		addCnoteSpinner();
	   $("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=fullView&filterBy=" +clinicalNotesFilterBy,function(){
		remCnoteSpinner();
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
	else if(viewPage=='fullViewTimeRange'){
		$("#clinicalNotesFrame").append("<div class='loadingCartItem'></div>");	
		$("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewTimeRange&filterBy=" +clinicalNotesFilterBy+"&finalStartDate="+finalStartDate+"&finalEndDate="+finalEndDate,function(){
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
			disabledRows();
			
		});
		}
	else if(viewPage=='fullViewEncounter'){
		$("#clinicalNotesFrame").append("<div class='loadingCartItem'></div>");
		$("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewEncounter&filterBy=" +clinicalNotesFilterBy+"&encounterID="+encounterID,function(){
			scrollerRefresh(CSMainScroll);
			bclinicalNotesLoaded = true;
			bfullViewOpen = false;
			cnNoteType = "";
			bAccordionViewLoaded = false;
			currentNotesHScrollingId = "";
			arrCnVisitedPages = null;
			arrCnVisitedPages = [];
			cnCurrentPage = 0;
			setTimeout(function(){
				parent.setTimeFrame();
				$('div[id^="SLSfsTickEN"]').hide();
				$("#SLSfsTickEN"+encounterID).show();
			},0);	
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
			disabledRows();
		});
		}
		else
		{
		
			addCnoteSpinner();
			$("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=fullView&filterBy=" +clinicalNotesFilterBy,function(){
				remCnoteSpinner();
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
				if($('.clinicalNotesContent:visible').length >= 1){
					$('.mySpecialityNoRecords').hide();
				}else{
					$('.mySpecialityNoRecords').show();
				}
			});
		}
		hideNoteAndBubbles();
		clinicalNotesFilterBy = "";// clear all exist filters
}
function disabledRows(){
	var filterNote ={
				"listItemNT":[],
				"listItemMAS":[],
				"listItemST":[],
				"listItemPB":[]
			}
			$(".dataContainerFullView:visible").each(function (i,v ){
				filterNote['listItemMAS'].push($(this).attr('data-serv'));
				filterNote['listItemST'].push($(this).attr('data-status'));
				filterNote['listItemPB'].push($(this).attr('data-perform'));
				filterNote['listItemNT'].push($(this).parents('.swipeWrapper').attr('data-notetype'));
			});
			$('.SlideSfsFrame').find(".listItemNT[data-speccode],.listItemST[data-speccode],.listItemMAS[data-speccode],.listItemPB[data-speccode]").hide();
			$('#headingNT,#headingMAS,#headingST,#headingPB').removeClass('disabledRowRecords');
			for (var key in filterNote) {
				  if (filterNote.hasOwnProperty(key) && filterNote[key].length > 0)  {
					 for(var i=0; i<filterNote[key].length; i++){
						 $('.SlideSfsFrame').find("."+key+"[data-speccode='"+filterNote[key][i]+"']").show();
					 }	 
				  }else{
					if($('.SlideSfsFrame').find("."+key+":visible").length == 0){
						$('.SlideSfsFrame').find("."+key).parents('div[id^="content"]').siblings('div[id^="heading"]').addClass('disabledRowRecords');
						$('.SlideSfsFrame').find("."+key).parents('div[id^="content"]').hide();
						$('.SlideSfsFrame').find(".disabledRowRecords").siblings('div[id^="textBox"]').hide();
					}
				  }
			}
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

function scrollerRefresh(scroller){
	if(scroller != null){
		scroller.refresh();
	}
	
}



function clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN){
	//closing fullview on filter
	$("[data-fullView = 'true']").each(function(index, value) {
		$("[data-noteType = " + $(this).attr('data-fullviewnotetype')+"]").find(".swipeWrapper").show();
		$(this).hide();
	});
	cnNoteType ='';
	var totalCount = arrPB.length + arrNT.length + arrMAS.length + arrST.length + arrML.length + arrSPL.length +arrSN.length;
	var filterNote ={
				"listItemNT":[],
				"listItemMAS":[],
				"listItemST":[],
				"listItemPB":[]
			}
	if(totalCount>0){
		$("#CNdivcnt").find(".clinicalNotesContent").show(); 
	rows= $("#CNdivcnt").find(".dataContainerFullView").hide();
		var MatchedValues ='';
		if(arrNT.length > 1){
			for(var i=0; i<arrNT.length; i++){
					 MatchedValues = "[data-notetype = '"+arrNT[i]+"']";
					 if(arrMAS.length > 0)
						 MatchedValues += "[data-serv = '"+arrMAS[0]+"']";
					 if(arrST.length > 0)
						 MatchedValues += "[data-status = '"+arrST[0]+"']";
					 if(arrPB.length > 0)
						 MatchedValues += "[data-perform = '"+arrPB[0]+"']";
					$('.dataContainerFullView'+MatchedValues).show();
			 }	
		}else{
			if(arrNT.length > 0)
			 MatchedValues = "[data-notetype = '"+arrNT[0]+"']";
			 if(arrMAS.length > 0)
				 MatchedValues += "[data-serv = '"+arrMAS[0]+"']";
			 if(arrST.length > 0)
				 MatchedValues += "[data-status = '"+arrST[0]+"']";
			 if(arrPB.length > 0)
				 MatchedValues += "[data-perform = '"+arrPB[0]+"']";
			$('.dataContainerFullView'+MatchedValues).show();
		}
		
		
		if(arrSPL.length>0){
			var specialityCount = document.getElementById("hdnCount").value;
			
			for(var i=0; i<specialityCount; i++){
				var noteType = document.getElementById("hdnSpeciality"+i).value;
				$("[data-notetype = '"+noteType+"']").each(function (i,v ){
					$(this).show();
				});
			}
		}
	}
	else if(totalCount==0){
		rows= $("#CNdivcnt").find(".clinicalNotesContent").show();  
		$("#CNdivcnt").find(".dataContainerFullView").show();   
			 
		 }
	//searchbynotes icon functionality
	if(arrNT.length > 0){
			$('.searchByNotes').addClass("enableSearch");
		}else{
			$('.searchByNotes').removeClass("enableSearch")
	}	  
	$(".clinicalNotesContent").each(function (i,v ){
			 if ($(this).find(".dataContainerFullView:visible").length == 0)
			 {
				$(this).hide();
			 }
			 else{
				 $(this).show();
			 }	 
	});
		if($('.clinicalNotesContent:visible').length >= 1){
			$('.mySpecialityNoRecords').hide();
		}else{
			$('.mySpecialityNoRecords').show();
		}
	$(".dataContainerFullView:visible").each(function (i,v ){
			filterNote['listItemMAS'].push($(this).attr('data-serv'));
			filterNote['listItemST'].push($(this).attr('data-status'));
			filterNote['listItemPB'].push($(this).attr('data-perform'));
			filterNote['listItemNT'].push($(this).parents('.swipeWrapper').attr('data-notetype'));
	});
	$('.SlideSfsFrame').find(".listItemNT[data-speccode],.listItemST[data-speccode],.listItemMAS[data-speccode],.listItemPB[data-speccode]").hide();
	for (var key in filterNote) {
		  if (filterNote.hasOwnProperty(key) && filterNote[key].length > 0)  {
			 for(var i=0; i<filterNote[key].length; i++){
				 $('.SlideSfsFrame').find("."+key+"[data-speccode='"+filterNote[key][i]+"']").show();
			 }	
			
		  }  
	}
	
	
	$(".bubbleDivider").each(function (i,v ){
		if($(this).prevUntil(".bubbleDivider").is(":visible") && $(this).nextUntil(".bubbleDivider").is(":visible") ){
			$(this).show();
		}else{
			$(this).hide();
		}
	});
	remCnoteSpinner();
 }

$(document).ready(function(){
	parent.setOnLoadContentPaneHeight();
	loadClinicalNotes('A','fullView','','','');//cn
});

function closeClinicalNotes(){ 
	parent.closeChartSummary();
	
}


function changeOrientation(orient, EMHFheight){
	bOrientationChanged = true; //cn
	var CSHFheight = $('#CSHeader').height() + $('#CSFooter').height();
	var content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px
	document.getElementById("ChartSummaryMainWrapper").style.height = content_height+"px";
	
	if(bclinicalNotesLoaded){
		assignSliderWidth();
		setScrollerWidth();
		if(myScrollnotes != null){
			myScrollnotes.refresh();	
		}
		
		if(bAccordionViewLoaded){
			//accordionNotesViewDimensions(cnNoteType);
		}
		if(notesHorizontalScroll != null){
			//accordionNotesViewDimensions(cnNoteType);
			//alert(notesHorizontalScroll.currPageX);
			notesHorizontalScroll.refresh();
			notesHorizontalScroll.scrollToPage(cnCurrentPage,0);
			//alert(notesHorizontalScroll.currPageX);
		}
	}
}
function accordionNotesViewDimensions(noteType){
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
		 if(width <= 200)
			width = 120;
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
var filteredNotes =[];
function showFullViewNotes(obj, type){
	var nt = $(obj).attr("data-expandNoteType");
	$("[data-fullView = 'true']").each(function(index, value) {
		$(this).hide();
	});
	arrCnVisitedPages = null;
	arrCnVisitedPages = [];

	$("[data-noteType = " + cnNoteType +"]").find(".swipeWrapper").show();
	if(cnNoteType != nt)
	{
		filteredNotes =[];
		$("[data-noteType = " + nt +"]").find(".swipeWrapper .dataContainerFullView:visible").each(function(index, value) {
			filteredNotes.push($(this).attr('data-accnumber'));
		});
		
		$("[data-fullviewNoteType = " + nt +"]").show();
		$("[data-noteType = " + nt +"]").find(".swipeWrapper").hide();
		bfullViewOpen = true;
		var encounterID = document.getElementById("hdnSelEncID").value;
		
		if(type == "normalView" ){
	    $("[data-fullviewNoteType = " + nt +"]").load( path + "/mobile/chartsummary/ClinicalNotesView?filterBy=" +clinicalNotesFilterBy + "&noteType=" + nt+ "&viewType=AccordionView&viewPage=fullViewEncounter&encounterID=" + encounterID,function(){
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
				
				
				$(".notesFullViewTable .notesBubbleContainer").hide();
				$(".notesFullViewTable .notesBubbleContainer").each(function(index, value) {
					if(filteredNotes.indexOf($(this).attr('data-accnumber')) != -1){
						$(this).show();
					}
				});
				
			});
			
		});
	    }
	    else if (type == "timeRangeView" ){
	    	var startDate = document.getElementById("hdnStrDate").value;
	    	var endDate = document.getElementById("hdnEndDate").value;
	    	$("[data-fullviewNoteType = " + nt +"]").load( path + "/mobile/chartsummary/ClinicalNotesView?filterBy=" +clinicalNotesFilterBy + "&noteType=" + nt+ "&viewType=AccordionViewTimeRange&viewPage=fullViewTimeRange&finalStartDate=" + startDate + "&finalEndDate=" + endDate ,function(){
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
				
				
				$(".notesFullViewTable .notesBubbleContainer").hide();
				$(".notesFullViewTable .notesBubbleContainer").each(function(index, value) {
					if(filteredNotes.indexOf($(this).attr('data-accnumber')) != -1){
						$(this).show();
					}
				});
				
			});
			
		});
	    }
	    $("[data-imagaeNoteType = " + cnNoteType +"]").attr("src" , path + "/eIPAD/images/Expandview.png");
	    cnNoteType = nt;
	    $("[data-imagaeNoteType = " + nt +"]").attr("src" , path + "/eIPAD/images/Collapseview.png");
	    
	}
	else
	{
		if(bfullViewOpen)
		{
			$("[data-fullviewNoteType = " + nt +"]").hide();
			$("[data-noteType = " + nt +"]").find(".swipeWrapper").show();
			bfullViewOpen = false;
			$("[data-imagaeNoteType = " + nt +"]").attr("src" , path + "/eIPAD/images/Expandview.png");
		}
		else
		{
			//horizontalNotesScroll(nt);
			$("[data-fullviewNoteType = " + nt +"]").show();
			$("[data-noteType = " + nt +"]").find(".swipeWrapper").hide();
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

var openingPage = "clinicalNotes"; 

var setTimeFrame;
function EncountersInRange(finalStartDate,finalEndDate,viewPage){
	document.getElementById("hdnStrDate").value = finalStartDate;
	document.getElementById("hdnEndDate").value = finalEndDate;
	$('div[id^="SLSfsTickEN"]').hide();	
	loadClinicalNotes("A",viewPage,finalStartDate,finalEndDate,'');	
	$("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewTimeRange&finalStartDate="+finalStartDate+"&finalEndDate="+finalEndDate);
}
function chooseEncounterFilter(encounterID, openingPages, viewPage){
	//addCnoteSpinner();
	//	parent.setTimeFrame();
		 document.getElementById("hdnSelEncID").value = encounterID;
		/*  if($("#SLSfsTickEN"+encounterID).is(":visible")){ //On/Off logic is commented. do not remove.
				if($('#contentEC .listItemEC').length ==1){
						return;
				}
			  $('div[id^="SLSfsTickEN"]').hide();
			  $("#SLSfsTickEN"+encounterID).hide();
			 loadClinicalNotes('A',viewPage,' ',' ','');
		 }else{ */
			 //clearing notetype and ticks
			arrNT=[];
			$("#AfterSelectionNT").html('');
			$(".SLSfsTickVisible").hide();
			$('.searchByNotes').removeClass("enableSearch");
		
			 $('div[id^="SLSfsTickEN"]').hide();
			 $("#SLSfsTickEN"+encounterID).show();
			 loadClinicalNotes('A',viewPage,' ',' ',encounterID);
			 //$("#clinicalNotesFrame").load( path + "/mobile/chartsummary/ClinicalNotesView?viewPage=fullViewEncounter&filterBy=A&encounterID="+encounterID);
			 $("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewEncounter&encounterID="+encounterID);
		/*  }  */
		
		parent.setTimeFrame();
}
function chooseShowNotesFilter(showNotes){
	

	 /* if($("#SLSfsTickSN"+showNotes).is(":visible")){
		 $("#SLSfsTickSN"+showNotes).hide();
		 $('div[id^="SLSfsTickSN"]').hide()
		 loadClinicalNotes('A',viewPage,' ',' ','');
	 }else{
		 $('div[id^="SLSfsTickSN"]').hide();
		 $("#SLSfsTickSN"+showNotes).show();
		 loadCNFilter(showNotes);
	 } */
}

function closePopup(popupId){
	var popupObj = $("#"+popupId);
	$("#dvMez").hide();
	$("#dvMez").data("popid","");
	$(popupObj).hide();
	$("#dvMez").off();
}

var isOpened = false;
function showSlideSFS()
{
	isOpened=true;
	//parent.setTimeFrame();
	//$("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet");
	$("#SlideSfsFrame").load(path+"/mobile/ClinicalNotesSFSServlet?viewPage=fullViewEncounter&encounterID="+$('#currentECID').val());
	$('#SlideSfsFrame').show();/*changed*/
	$('.slidesFrameWrap').css({'display':'table-cell'});/*changed*/
	$("#SlideSFSOpener").hide();
	var resWidth =($(window).width() - 235)+'px';
   	$('.rightContentWrap').css({'width':resWidth});
   	assignSliderWidth();
   	setScrollerWidth();
	$(".sliderSwipe").hide();
}
function hideSlideSFS(){
	$("#SlideSfsFrame").hide();
	$("#SlideSFSOpener").show();
	$(".sliderSwipe").show();
}
//swipe left close filter /*changed*/
$( document ).on( "swiperight", ".sliderSwipe", function( e ) {
	showSlideSFS();
});
$( document ).on( "swiperight", "#SlideSFSOpener", function( e ) {
	
	showSlideSFS();
});
function openPharmacyOrders(){
	$("#PageLoadingAnimation").show();
	parent.openPharmacyOrders();
}									

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
.absoluteCenter {
  margin: auto;
  position: absolute;
  top: 0; left: 0; bottom: 0; right: 0;
}
.slideSfsOpener
{
	position:absolute;
	z-index:6000;
	top: calc(100%/2); 
}
.SlideSfsFrame{
	width:235px;
	height:calc(100% - 10px);
	position:absolute; 
	z-index:5000;
	margin-top:5px;
	background-color: #eaedf2;
}
.slidesFrameWrap{
	display:none;
}
.sliderSwipe{
	position: absolute;
	width: 20px;
	height: 100%;
}
#PageLoadingAnimation{
	z-index: 10000;
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background-color: #808080;
	opacity: 0.6;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	display: none; 
}

</style>
<%-- <%
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
%> --%>

<%
String formValErrClass = "";
String transactionMessage = "";
String transactionResult = "";
String transactionOccurred = "false";
if(request.getParameter("transactionOccurred") != null && request.getParameter("transactionOccurred").equals("true")){
	transactionOccurred = request.getParameter("transactionOccurred") == null?"":request.getParameter("transactionOccurred");
	transactionMessage = request.getParameter("transactionMessage") == null?"":request.getParameter("transactionMessage");
	transactionResult = request.getParameter("transactionResult") == null?"":request.getParameter("transactionResult");
	if(transactionResult.equals("0")){ 
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
	 <div data-role = "none" id = "dvMez" class = "blurPopup" onclick="" data-popid="" onclick="closeMez()"></div> 
		<div style="display:table;table-layout:fixed;width: 100%;">
		<div style="display:table-row">
			<div  class="slidesFrameWrap">
				<!-- Slide SFS popup STARTS -->
								<div class="SlideSfsFrame" id="SlideSfsFrame"></div>
								<input type = "hidden" name ="currentECID" id ="currentECID" value = "<%=currentEcID%>"/>
				<!-- Slide SFS popup ENDS -->
			</div>
			<div style="display:table-cell;" class="rightContentWrap">
		
	<!--  Slide SFS overlay button STARTS -->
  	     <div class="sliderSwipe" ></div>
    <div  class="slideSfsOpener" onclick="showSlideSFS()" id="SlideSFSOpener"><img id="sfsSearchImg" src="${path}/eIPAD/images/Open_window.png"/></div>
		
	<!--  Slide SFS overlay button ENDS -->
	
	
	
	<div class = "ChartSummaryParent ChartSummaryParentTheme"  style="position:inherit" data-role="page" >
		<div class="ChartSummaryBlock" id="ChartSummaryBlock" data-role = "none">
		
		<div id="PageLoadingAnimation" class="absoluteCenter"></div>
		
			<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
				<div class="ChartSummaryMainTable" data-role = "none">
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
																	<div style="display:table;width:100%"  onclick="chooseEncounterForNote('')">
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
																			<div style="display:table;width:100%" class="<%=cssClassName %>" onclick="chooseEncounterForNote('<%=iEncounter.getEncounterId()%>')">
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
										encLeftNaviClickFunc = "chooseEncounterForNote('')";
									}
									else{
										encLeftNaviClickFunc = "chooseEncounterForNote('"+allEncArrayList.get(selectedEncIndex-1).getEncounterId()+"')";
									}
									if(selectedEncIndex+1 >= allEncArrayList.size()){
										encRightNaviStyle = "WidgetButtonDisableTheme";
									}
									else{
										encRightNaviClickFunc = "chooseEncounterForNote('"+allEncArrayList.get(selectedEncIndex+1).getEncounterId()+"')";
									}
								%>
							
								<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
									<div class="ChartSummaryHeaderRow" data-role = "none">
										<div class="ChartSummaryHeaderIconCol" data-role = "none">
											<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
										</div>
										<div class="ChartSummaryHeaderTextCol" data-role = "none">
											<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">Clinical Notes</div><!-- TODO replace with message bundle text -->
										</div> 
										<%-- <div class="ChartSummaryHeaderEncLeftCol" data-role = "none">
										<div class="commonButtonTbl">
											<div class="<%=encLeftNaviStyle %>" data-role = "none" onclick="<%=encLeftNaviClickFunc%>"><img src="${path}/eIPAD/images/Previous16x16.png"></div>
										</div>
										</div> --%>
										
										
										<%-- <div class="ChartSummaryHeaderEncListCol" data-role = "none">
											<div class="CSHeaderEncID" onclick="toggleEncListPopup()">
												<div class="CSHeaderEncIDLabel"><%=csResBundle.getString("common.enId") %></div>
												<div class="CSHeaderEncIDLabel"><%=allEncArrayList.get(selectedEncIndex).getEncounterId()%>,</div>
												<div class="CSHeaderEncIDLabel"><%=allEncArrayList.get(selectedEncIndex).getPatientClass()%></div>
												<div class="CSHeaderEncIDLabelright"><img src="${path}/eIPAD/images/Down12x12.png" class="ChartSummaryHeaderEncDrpImg">	</div>
												<div class="CSHeaderEncIDLabelright"><%if(selectedEncIndex+1<10){%>0<%}%><%=selectedEncIndex+1%>/<%if(allEncArrayList.size()<10){%>0<%}%><%=allEncArrayList.size()%>	</div>
											</div> --%>
										
											<%-- <div class="ChartSummaryHeaderEncList ChartSummaryHeaderEncListTheme" data-role = "none" style="display:table" onclick="toggleEncListPopup()"><%if(allEncArrayList.size() > 1){%>toggleEncListPopup()<%}%>
												<div class="ChartSummaryHeaderEncLstContainer" data-role = "none">
													<div class="ChartSummaryHeaderEncIDLabel" data-role = "none"><%=csResBundle.getString("common.enId") %> - </div> <!-- TODO replace with localized text -->
													<div class="ChartSummaryHeaderEncID" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getEncounterId()%>,</div>
													<div class="ChartSummaryHeaderEncPatClass" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getPatientClass()%> - </div>
													<div class="ChartSummaryHeaderEncPracName" data-role = "none"><%=allEncArrayList.get(selectedEncIndex).getPractShortName()%></div>
													<div class="ChartSummaryHeaderEncCount" data-role = "none"><%if(selectedEncIndex+1<10){%>0<%}%><%=selectedEncIndex+1%>/<%if(allEncArrayList.size()<10){%>0<%}%><%=allEncArrayList.size()%></div>
													<div class="ChartSummaryHeaderEncDrpIcon" data-role = "none"><img src="${path}/eIPAD/images/Down12x12.png" class="ChartSummaryHeaderEncDrpImg"></div>
												</div>
											</div> --%>
										<!-- </div> -->
										
										<%-- <div class="ChartSummaryHeaderEncRightCol" data-role = "none">
										<div class="commonButtonTbl">
											<div class="<%=encRightNaviStyle %>" data-role = "none" onclick="<%=encRightNaviClickFunc%>"><img src="${path}/eIPAD/images/Next16x16.png"></div>
										</div>
										</div> --%>
										<%-- <div class="ChartSummaryHeaderEncRightCol" data-role="none">
											<div class="WidgetButtonTheme" data-role = "none" onclick=""><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
										</div> --%>
										<div class="ChartSummaryHeaderEncRightCol" data-role="none" onclick="closeClinicalNotes()">
										
											<div class="WidgetButtonTheme" data-role = "none" onclick="closeClinicalNotes()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
					<div id="ClinicalNotes" class="divClinicalNotesContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none"> 
					<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="ChartSummaryPageContent">
						<div data-role = "none" class = "ChartSummaryPageContentCell">
							
							<div data-role = "none" class = "ChartSummaryMainWrapper" id="ChartSummaryMainWrapper" style=" overflow:hidden;position:relative">
								<div class="ChartSummaryMainScroller" id="ChartSummaryMainScrollerID" style="width:100%;height:auto" data-role = "none"><!-- scrolling content starts -->
									<div id="clinicalNotesFrame" class="ChartWidgetframe" data-role="none" style = "padding:0px;"></div>
								</div><!-- scrolling content ends -->
								
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup, but not currently used in Orders - STARTS CONSIDER FOR REMOVAL TODO-->
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
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup but not currently used in Orders - ENDS-->
								
								<!-- Transaction message -->
								<div class="<%=formValErrClass %> CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"><%=transactionMessage %></div>
								</div>
								<!-- End of Transaction message -->
								
							</div>

						</div>
					</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageFooter"  id="CSFooter">
						<div data-role = "none" class = "ChartSummaryPageFooterCell">
						<div data-role = "none" class = "ChartSummaryPageFooterCont">
							<div data-role = "none" class = "ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme">
								<div data-role = "none" class = "ChartSummaryPageFooterRow">
									<div data-role = "none" class = "ChartSummaryPageFooterFirstCol"></div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openChartSummaryFrame()">
										<div data-role = "none" class = "ChartSummaryPageFooterText"><%=csResBundle.getString("common.chartSummary") %></div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme" onclick="openClinicalNotes()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Clinical<br/>Notes</div>
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
									<div data-role = "none" class = "ChartSummaryPageFooterLastCol"></div>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
				<input type="hidden" name="transactionOccurred" id="transactionOccurred" id="transactionOccurred" value="<%=transactionOccurred %>"/>
				<input type = "hidden" name = "hdnSelEncID" id = "hdnSelEncID" value ="<%=patientContext.getEncounterId()%>" />
				<input type = "hidden" name = "hdnStrDate" id = "hdnStrDate" value =" " />
				<input type = "hidden" name = "hdnEndDate" id = "hdnEndDate" value =" " />
			</form>
		</div>
		
		<div style="width:100%;height:100%;display:none;" id="clinicalNotesDiv">
		<div style="display:table;width:100%;height:100%;" >
			<div style="display:table-row">
				<div style="display:table-cell;padding:5px;">
					<div style="display:table;width:100%;height:100%;position:relative" id="clinicalNotesDiv">
						<div style="display:table-row">
							<div style="display:table-cell;width:100%;height:100%;background:white;position:absolute" id="ClinicalNotesContentDisplay">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		
	</div>
		<!-- end of table row -->
		</div>
	</div>
	</div>
</body>
</html>

