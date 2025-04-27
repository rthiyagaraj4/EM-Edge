<!DOCTYPE html>

<%@page import="eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.*"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.*"%>


<%@page import="java.util.ArrayList"%>

<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo" %>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.google.gson.Gson;" %>
<c:set var="path" value= "${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />
<title>ClinicalNotesSFS</title>

<link rel="stylesheet" href="${path}/eIPAD/css/SlideSFS.css" />
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<!-- <script type="application/javascript" src="../js/iscroll.js"></script> -->
<script src="../jquery-1.9.1.min.js"></script>

<%
	Locale appLocale; //for session values
	if (session.getAttribute("LOCALE") != null
			&& !session.getAttribute("LOCALE").equals(""))
		appLocale = new Locale((String) session.getAttribute("LOCALE"));
	else
		appLocale = new Locale("en");
	ResourceBundle csResBundle = ResourceBundle.getBundle(
			"eIPAD.chartsummary.common.resourcebundle.cslabels",
			appLocale);
		
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	String loggedInUser = patientContext.getLoggedInUser();
	String currentEncID = patientContext.getEncounterId();
	
	Gson gson = new Gson();
	String jsonFieldResDate = "";
	String jsonFieldResEnc = "";
	String viewPage = request.getParameter("viewPage");
	String finalStartDate = request.getParameter("finalStartDate");
	String finalEndDate = request.getParameter("finalEndDate");
	String selectedEncounterID ="";
	
	selectedEncounterID = request.getParameter("encounterID");
	//patientContext.setEncounterId((String)selectedEncounters);
%>
<script type="text/javascript">
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
$.extend($.expr[":"], { //search as you type
	"containsIN": function(elem, i, match, array) {
	return (elem.textContent || elem.innerText || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
	});
var SLSfsScrollMain;

var SLSfsScrollEC;
var SLSfsScrollPB;
var SLSfsScrollNT;
var SLSfsScrollMAS;
var SLSfsScrollST;



var currentViewMore;
var viewLessHeight;
var arrNT = [];
var arrMAS = [];
var arrPB = [];
var arrST = [];
var arrML = [];
var arrSPL = [];
var arrSN = [];
function CNFilterLoaded() {
	SLSfsScrollMain=  new IScroll('#SLSfsWrapperMain', { 	
	        scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true 
        } );
	
	try{
		SLSfsScrollEC = new IScroll('#SLSfsWrapperEC', { scrollbars: true, click: true,  mouseWheel: true } );
		SLSfsScrollNT = new IScroll('#SLSfsWrapperNT', { scrollbars: true, click: true,  mouseWheel: true } );
		SLSfsScrollMAS = new IScroll('#SLSfsWrapperMAS', { scrollbars: true, click: true,  mouseWheel: true } );
		SLSfsScrollPB = new IScroll('#SLSfsWrapperPB', { scrollbars: true, click: true,  mouseWheel: true } );
		SLSfsScrollST = new IScroll('#SLSfsWrapperST', { scrollbars: true, click: true,  mouseWheel: true } );
	}
	catch(err){
		
	}
}
function hideSlideSFS(){
//$("#CNFilterHeader").hide();
$("#SlideSfsFrame").hide();
	$('.slidesFrameWrap').css({'display':'none'});/*changed*/
	$('.rightContentWrap').css({'width':'100%'});/*changed*/
	$("#SlideSFSOpener").show();
	$(".sliderSwipe").show();
	assignSliderWidth();
	setScrollerWidth();
	isOpened=false;
	if($('#hdnActiveEncID').val() != undefined){
		$("#SLSfsTickEN"+$('#hdnActiveEncID').val()).hide();
		chooseEncounterFilter($('#hdnActiveEncID').val(),'clinicalNotes','fullViewEncounter');
	}
}
//swipe left close filter /*changed*/
$( document ).on( "swipeleft", "#SlideSfsFrame", function( e ) {
	hideSlideSFS();
});
function refreshMain(){
	/* $("CNFilterContent").empty();
	$("CNFilterContent").show(); */
	if(SLSfsScrollNT != undefined)
		SLSfsScrollNT.refresh();
	if(SLSfsScrollMAS != undefined)
		SLSfsScrollMAS.refresh();
	if(SLSfsScrollPB != undefined)
		SLSfsScrollPB.refresh();
	if(SLSfsScrollST != undefined)
		SLSfsScrollST.refresh();
	if(SLSfsScrollMain != undefined)
		SLSfsScrollMain.refresh();
	$("#listNT").find(".listItemNT").show();
	$("#listMAS").find(".listItemMAS").show();
	$("#listPB").find(".listItemPB").show();
	$("#listST").find(".listItemST").show();
	$("#listML").find(".listItemML").show();
	$("#listSPL").find(".listItemSPL").show();
	$(".SLSfsTickVisible").hide();
	$(".SLSfsAfterSelectionTheme").hide();
	if($('#hdnActiveEncID').val() != undefined){
		$("#SLSfsTickEN"+$('#hdnActiveEncID').val()).hide();
		chooseEncounterFilter($('#hdnActiveEncID').val(),'clinicalNotes','fullViewEncounter');
	}
	
	if($('#searchInputSFSPB').length > 0)
	 $('#searchInputSFSPB').val('');
	if($('#searchInputSFSNT').length > 0)
	$('#searchInputSFSNT').val('');
	if($('#searchInputSFSMAS').length > 0)
	$('#searchInputSFSMAS').val('');
	if($('#searchInputSFSST').length > 0)
	$('#searchInputSFSST').val('');
	arrNT.splice(0,arrNT.length);
	arrMAS.splice(0,arrMAS.length);
	arrPB.splice(0,arrPB.length);
	arrST.splice(0,arrST.length);
	arrML.splice(0,arrML.length);
	arrSPL.splice(0,arrSPL.length);
	arrSN.splice(0,arrSN.length);
	clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
	$("#AfterSelectionNT").html('');
}

function CNFilterShowTick(val, type){ 
	if(type=="PB"){	
	 arrPB =[];
		if($("#SLSfsTickPB"+val).is(":visible")){
			var index = arrPB.indexOf(val);
			arrPB.splice(index, 1);
			$("#SLSfsTickPB"+val).hide();
		}
		else{
			arrPB.push(val); 
			$("#SLSfsTickPB"+val).show();
			}
	}
	if(type=="NT"){	
		if($("#SLSfsTickNT"+val).is(":visible")){
			var index = arrNT.indexOf(val);
			arrNT.splice(index, 1);
			$("#SLSfsTickNT"+val).hide();
			
		}
		else{
			arrNT.push(val); 
			$("#SLSfsTickNT"+val).show();
			
			}
		if(arrNT.length > 0){
			$('.searchByNotes').addClass("enableSearch");
		}else{
			$('.searchByNotes').removeClass("enableSearch")
		}
	}
	if(type=="MAS"){
		arrMAS =[];
		 if($("#SLSfsTickMAS"+val).is(":visible")){
			 $("#SLSfsTickMAS"+val).hide();
			 $('div[id^="SLSfsTickMAS"]').hide();
			 
		 }else{
			 arrMAS.push(val);
			 $('div[id^="SLSfsTickMAS"]').hide();
			 $("#SLSfsTickMAS"+val).show();
			 
		 }
		
	}
	if(type=="SN"){
		arrSN =[];
		 if($("#SLSfsTickSN"+val).is(":visible")){
			 $("#SLSfsTickSN"+val).hide();
			 $('div[id^="SLSfsTickSN"]').hide();
		 }else{
			 arrSN.push(val);
			 $('div[id^="SLSfsTickSN"]').hide();
			 $("#SLSfsTickSN"+val).show(); 
		 }
		
	}
	if(type=="ST"){	
		arrST = [];
		if($("#SLSfsTickST"+val).is(":visible")){
			var index = arrST.indexOf(val);
			arrST.splice(index, 1);
			$("#SLSfsTickST"+val).hide();
		}
		else{
			arrST.push(val); 
			$("#SLSfsTickST"+val).show();
			}
	}
	if(type !="NT"){	
		addCnoteSpinner();
		clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
	}
	if(arrNT.length == 0 && type =="NT" ){
		clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
	}
	if(SLSfsScrollNT != undefined)
		SLSfsScrollNT.refresh();
	if(SLSfsScrollMAS != undefined)
		SLSfsScrollMAS.refresh();
	if(SLSfsScrollPB != undefined)
		SLSfsScrollPB.refresh();
	if(SLSfsScrollST != undefined)
		SLSfsScrollST.refresh();
	
	SLSfsScrollMain.refresh();
}
function searchByNoteType(event){
	event.stopPropagation();
	addCnoteSpinner();
	clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
		
		 if($("#AfterSelectionNT").is(":visible")){
				$("#AfterSelectionNT").empty();
			}
			if(arrNT.length>0){
				$("#NTAfterSel").show();
				for(var i=0;i<arrNT.length;i++){
					var specCode= arrNT[i];
					var specDesc ="";
					$("[data-speccode = '"+specCode+"']").each(function (i,v ){
						specDesc = $(this).data("specdesc");
					});
		 			var inblockNT ='<div id="inBlockItem'+specCode+'" class="row SLSfsInlineBlock SLSfsInlineBlockTheme"> <div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme"> '+ specDesc +' </div><div class="cell SLSfsInlineBlockClose" onclick="removeInblockItem(&quot;'+specCode+'&quot;,&quot;NT&quot;)"><img src="${path}/eIPAD/images/Close10x10.PNG"></div></div>';
		 			$("#AfterSelectionNT").append(inblockNT);    
			 	}
				var addmoreNT ='<div class="row SLSfsInlineBlock SLSfsInlineBlockTheme"> <div class="cell SLSfsInlineBlockCell SLSfsInlineBlockCellTheme" onclick="addmoreFilter(&quot;NT&quot;)"> Add more </div> </div>';
				$("#AfterSelectionNT").append(addmoreNT);
				$("#AfterSelectionNT").show();
				$("#contentNT").hide();
	 		    $("#textBoxNT").hide();
			}
			
		
	SLSfsScrollMain.refresh();
}
function myList(val,type){
	if(type=="ML"){
		if($("#SLSfsTickMLPract").is(":visible")){
			var index = arrML.indexOf(val);
			arrML.splice(index, 1);
			$("#SLSfsTickMLPract").hide();
			clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
		}
		else{
			arrML.push(val); 
			$("#SLSfsTickMLPract").show();
			clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
		}
	}
	if(type=="SPL"){
		if($("#SLSfsTickMLServ").is(":visible")){
			var index = arrML.indexOf(val);
			arrSPL.splice(index, 1);
			$("#SLSfsTickMLServ").hide();
			clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
		}
		else{
			arrSPL.push(val); 
			$("#SLSfsTickMLServ").show();
			clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
		}
	}
}

function CNFilterClearTxt(current,other1,other2,other3){
	document.getElementById("searchInputSFS"+current).value = "";
	$("#list"+current).find(".listItem"+current).show();
	if(current='NT'){
		SLSfsScrollNT.refresh();
	}
	if(current='MAS'){
		SLSfsScrollMAS.refresh();
	}
	if(current='PB'){
		SLSfsScrollPB.refresh();
	}
	if(current='ST'){
		SLSfsScrollST.refresh();
	}
}

function CNFilterSectionToggle(current){
	$("#content"+current).toggle();
	$("#textBox"+current).toggle();
	$("#ViewMore"+current).toggle();
	
	
	 if($("#content"+current).is(":visible")){
			$("#arrow"+current).addClass('SLSfsarrow');
		}
		else{
			$("#arrow"+current).removeClass('SLSfsarrow')	;
		}
	 
	SLSfsScrollMain.refresh();
	 
	if(SLSfsScrollEC != null){
	SLSfsScrollEC.refresh();}
	
	if(SLSfsScrollPB != null){
	SLSfsScrollPB.refresh();}
	
	if(SLSfsScrollNT != null){
	SLSfsScrollNT.refresh();}
	
	if(SLSfsScrollMAS != null){
	SLSfsScrollMAS.refresh();}
	
	if(SLSfsScrollST != null){
	SLSfsScrollST.refresh();}
	 
}

function addmoreFilter(current){
	
	$("#data"+current).height(viewLessHeight); 
	$("#content"+current).show();
	$("#textBox"+current).show();
	$("#ViewMore"+current).show();
	$("#AfterSelection"+current).hide();
	$('#AfterSelection'+current).empty();
	if($("#content"+current).is(":visible")){
			$("#arrow"+current).addClass('SLSfsarrow');
	}
	$('.listItem'+current).show();
	SLSfsScrollNT.refresh();
}
function removeInblockItem(val,type){
	//$("#inBlockItem"+val).remove();
	if(type=="NT") {
		$("#inBlockItem"+val).remove();
		$("#SLSfsTickNT"+val).hide();
		var index = arrNT.indexOf(val);
		arrNT.splice(index,1);
			if(arrNT.length<1){
				 $("#NTAfterSel").hide();
				 $("#AfterSelectionNT").html('');
				//$("#AfterSelectionSP").empty();
				//$("#dataSP").height(viewLessHeight);
				//$("#refSP").addClass('sfsReloadDefault');
				SLSfsScrollNT.refresh();
			}
	}
	
	
	clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
}
/*refresh filetr*/
 function refreshFilter(current,event){
	 event.stopPropagation();
	if(current == 'NT'){
		arrNT =[];
		 $('div[id^="SLSfsTickNT"]').hide();
		  $("#AfterSelectionNT").html('');
		SLSfsScrollNT.refresh();
	}
	/*if(current == 'ST'){
		arrST =[];
		 $('div[id^="SLSfsTickST"]').hide();
		SLSfsScrollST.refresh();
	}
	if(current == 'PB'){
		arrPB =[];
		 $('div[id^="SLSfsTickPB"]').hide();
		SLSfsScrollPB.refresh();
	}*/
	clinicalNotesFilter(arrPB,arrNT,arrMAS,arrST,arrML,arrSPL,arrSN);
	SLSfsScrollMain.refresh();
}
 
 
 
/*time frame slider start*/
 
 
  	var dateArrayStr = $("#hdnEncounterDate").val();
  	var dateArrSize = $("#hdnDateArrCount").val();
	dateArray = $.parseJSON(dateArrayStr);
	
	var encArrayStr = $("#hdnEncounterEnc").val();
  	var encArrSize = $("#hdnEncArrCount").val();
	encArray = $.parseJSON(encArrayStr);
	
	var datePos = dateArrSize - 1;
	var encPos = encArrSize - 1;

	var cuurentDate = new Date();
	var currDate = new Date();
	var srtDate = new Date(currDate.setMonth(currDate.getMonth() - 3));
	
	var startDate = kendo.toString(srtDate, 'yyyy/M/d' ).split('\/');	
	if(startDate[1].length == 2){
		var prevDate = new Date(startDate[0]+"/"+startDate[1]+"/"+startDate[2]);
	}else{
		var prevDate = new Date(startDate[0]+"/0"+startDate[1]+"/"+startDate[2]);
	}

	prevDate.setHours(0,0,0);
	cuurentDate.setHours(0,0,0);
	
	parent.setTimeFrame=function(){
	$('.startLabel').text(kendo.toString(prevDate, 'd MMM yyyy' ));
    var viewModel = kendo.observable({
        // 24*60*60*1000 = 86400000
        selectedStartDate: prevDate,
        selectedEndDate: cuurentDate,
		datepickerStartValue:prevDate,
		datepickerEndValue:cuurentDate,
        selectedDateRange: [],
		pickerStartTime:'',
		pickerEndTime:'',
        selectedDatesChanged: function(){
				//to set slider on select date picker
				if(viewModel.selectedEndDate.getTime() <= viewModel.datepickerStartValue.getTime()){
					alert("start date should be less than current date");
					viewModel.set('datepickerStartValue',viewModel.selectedStartDate);
					viewModel.set("pickerStartTime",viewModel.selectedStartDate.getTime());
				}
				if(viewModel.selectedStartDate.getTime() > viewModel.datepickerEndValue.getTime()){
					alert("end date should not be less than start date");
					viewModel.set('datepickerEndValue',viewModel.selectedEndDate);
					viewModel.set("pickerEndTime",viewModel.selectedEndDate.getTime())
				}
				if(viewModel.selectedStartDate.getTime() <= viewModel.datepickerStartValue.getTime()){
					//does not allow to select lesser date of start date
					viewModel.pickerStartTime = viewModel.datepickerStartValue.getTime();
				}else{
					alert("select correct daterange");
					viewModel.set('datepickerStartValue',viewModel.selectedStartDate);
					viewModel.set("pickerStartTime",viewModel.selectedStartDate.getTime());
					
				}
				if(viewModel.selectedEndDate.getTime() >= viewModel.datepickerEndValue.getTime())	{
					//does not allow to select greater date of end date
					viewModel.pickerEndTime = viewModel.datepickerEndValue.getTime();
				}else{
					alert("select correct daterange");
					viewModel.set('datepickerEndValue',viewModel.selectedEndDate);
					viewModel.set("pickerEndTime",viewModel.selectedEndDate.getTime())
				}
            	viewModel.updateDateSlider();
            	//to hide datepickers for default dates
            	/*var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
            	var startMatch = (kendo.toString(new Date(dateRange[0]), 'd MMM yyyy' ) ==  kendo.toString(new Date(prevDate), 'd MMM yyyy' ));
            	var endMatch = (kendo.toString(new Date(dateRange[1]), 'd MMM yyyy' ) ==  kendo.toString(new Date(cuurentDate), 'd MMM yyyy' ));
            	
            	if(startMatch && endMatch){
						$('.selectedDates').hide();
				}else{
					$('.selectedDates').show();
				}*/
        },
        dateStart: '',
        dateEnd: '',
        dateRangeChanged: function(){
            var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
            var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy' );
            var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy' );
            viewModel.set('dateStart', startdate);
            viewModel.set('dateEnd', enddate);
            viewModel.set('selectedDateRange', dateRange);
			//to set datepicker on drag 
			viewModel.set('datepickerStartValue',new Date(dateRange[0]));
			viewModel.set('datepickerEndValue',new Date(dateRange[1]));
			/*if(startdate == kendo.toString(new Date(prevDate), 'd MMM yyyy' ) && enddate == kendo.toString(new Date(cuurentDate), 'd MMM yyyy' )){
					$('.selectedDates').hide();
			}else{
				$('.selectedDates').show();
			}*/
        },
        updateDateSlider: function(){
            if ( viewModel.selectedStartDate <= viewModel.selectedEndDate)
            {
                // reinitialize the date slider, since sliders do not support dynamic changes
                var slider = $("#dateSlider").data("kendoRangeSlider");
                    if (slider){
                var wrapper = slider.wrapper;
                var element = slider.element;
                slider.destroy();
                wrapper.before(element.show());
                wrapper.remove();
            }
            $("#dateSlider").kendoRangeSlider({
                largeStep: 86400000,
                smallStep: 86400000,
                min: viewModel.selectedStartDate.getTime(),
                max: viewModel.selectedEndDate.getTime(),
                tickPlacement:'none',
                value: [viewModel.selectedStartDate.getTime(), viewModel.selectedEndDate.getTime()],
				selectionStart:(viewModel.pickerStartTime == '')  ? viewModel.selectedStartDate.getTime() : viewModel.pickerStartTime,
				selectionEnd: (viewModel.pickerEndTime == '') ? viewModel.selectedEndDate.getTime() : viewModel.pickerEndTime,
                tooltip: {
                    template: kendo.template('#=kendo.toString(new Date(selectionStart), \'M/d/yyyy\' ) # to #=kendo.toString(new Date(selectionEnd), \'M/d/yyyy\' ) #')
                },
                change: viewModel.dateRangeChanged
            });
                viewModel.resizeSliders();
                viewModel.dateRangeChanged();
            }
                     
        },
        resizeSliders: function(){
            // resize the sliders to fill the container
              var sliders = $("[data-role='rangeslider']");
                sliders.each(function (index, ele) {        
                var slider = $(ele).getKendoRangeSlider();
                slider.wrapper.css("width", "100%");
                //slider.resize();
            });
        }
    });
    

    kendo.bind('body', viewModel);
    viewModel.updateDateSlider();
    viewModel.resizeSliders();

	}
//search by time frame
var temp;
var i;
var j=0;
//var openingPage="clinicalNotes";
var selectedDateArr = [];
function SearchByTimeFrame(){
	var dateRange = $("#dateSlider").data("kendoRangeSlider").value();
	var startdate = kendo.toString(new Date(dateRange[0]), 'd MMM yyyy' );
    var enddate = kendo.toString(new Date(dateRange[1]), 'd MMM yyyy' );
    
    var startDateformat = kendo.toString(new Date(startdate), 'yyyy/MM/dd' );
    var startDateformatfinal =  startDateformat.split('\/');
    var finalStartDate = startDateformatfinal[0]+'-'+startDateformatfinal[1]+'-'+startDateformatfinal[2];
    
    var endDateformat = kendo.toString(new Date(enddate), 'yyyy/MM/dd' );
    var endDateformatfinal =  endDateformat.split('\/');
    var finalEndDate = endDateformatfinal[0]+'-'+endDateformatfinal[1]+'-'+endDateformatfinal[2];
    
    
    var viewPage="fullViewTimeRange";
    
	//removing selected notetypes and ticks
	arrNT=[];
	$("#AfterSelectionNT").html('');
	$(".SLSfsTickVisible").hide();
	$('.searchByNotes').removeClass("enableSearch")
	EncountersInRange(finalStartDate,finalEndDate,viewPage);
}
   
    //var firstEnc = encArray[encPos]; logic of timeframe with encounter n date together inside SearchByTimeFrame function
   /*  if(dateArrSize>0){
    	for(i=0;i<dateArrSize;i++){
    		var formatdate = dateArray[j].split(' ')[0].split('\/');
    		var formatDate1 =  new Date(formatdate[2]+"-"+formatdate[1]+"-"+formatdate[0]);
    		
    		var finalEcDate =new Date(formatDate1).getTime();
    		var finalEndDate =new Date(enddate).getTime();
    		var finalstartdate = new Date(startdate).getTime();
    		
    		if(finalEcDate < finalEndDate && finalEcDate > finalstartdate ){
    			temp = dateArray[j];
    			alert(temp);
    			selectedDateArr.push(temp);
    			EncountersInRange(selectedDateArr,openingPage);
    		}
    		j++;
    	}
    }       */
    function iScrollRefresh(){
	      setTimeout(function(){
	    	  SLSfsScrollEC.refresh(); 
	      }, 500);
	    }
$(document).ready(function(){
	CNFilterLoaded();
	parent.setTimeFrame();
	//arrow setting intial for EC
	if($("#contentEC").is(":visible")){
		$("#arrowEC").addClass('SLSfsarrow');
		if(SLSfsScrollEC != null){
			SLSfsScrollEC.refresh();
		}
	}
	iScrollRefresh();
	
	$("#ViewLessPB").hide();
	$("#ViewLessNT").hide();
	$("#ViewLessMAS").hide();
	$("#ViewLessST").hide();
	$("#ViewLessST").hide();
	//initially closed state
	
	$("#contentTF").hide();
	$("#contentPB").hide();
	$("#textBoxPB").hide();
	$("#contentNT").hide();
	$("#textBoxNT").hide();
	$("#contentMAS").hide();
	$("#textBoxMAS").hide();
	$("#contentST").hide();
	$("#textBoxST").hide();
	
	if(SLSfsScrollEC != null){
	SLSfsScrollEC.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollEC.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});}
	
	if(SLSfsScrollPB != null){
	SLSfsScrollPB.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollPB.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});}
	
	if(SLSfsScrollNT != null){
	SLSfsScrollNT.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollNT.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});}
	
	if(SLSfsScrollMAS != null){	
	SLSfsScrollMAS.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollMAS.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});}
	
	if(SLSfsScrollST != null){
	SLSfsScrollST.on('beforeScrollStart', function () {
		SLSfsScrollMain.disable();
	});
	SLSfsScrollST.on('scrollEnd', function () {
		SLSfsScrollMain.enable();
	});}
	
	$('#SLSfsWrapperMain').on('touchstart click', function(){
		SLSfsScrollMain.enable();
	});
	$("#searchInputSFSPB").keyup(function(){
		var rows = $("#listPB").find(".listItemPB").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
		});
	$("#searchInputSFSNT").keyup(function () {
		var rows = $("#listNT").find(".listItemNT").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
			SLSfsScrollNT.refresh();
		});
	$("#searchInputSFSMAS").keyup(function () {
		var rows = $("#listMAS").find(".listItemMAS").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
		});
	$("#searchInputSFSST").keyup(function () {
		var rows = $("#listST").find(".listItemST").hide();
		   if (this.value.length) {
		       var data = this.value.split(" ");
		       $.each(data, function (i, v){
		       		var val = v.toLowerCase(); 
		       		rows.filter(":containsIN('" + val + "')").show();
					});
		   		}
		   	else rows.show();	
		});
		
		$(".selectedDates input").kendoDatePicker({
				format: "dd/MM/yyyy"
		});
	$('div[id^="SLSfsTickEN"]').hide();
	$("#SLSfsTickEN"+$('#hdnCurrentEncID').val()).show();
});

</script>

	
<!-- main table STARTS -->
<div id="CNFilterHeader" style="width:100%;height:100%; position: relative; display: table;">
<div class="row" style="height: 2%;">
  <div class="cell">
	<div style="width:100%;height:40px"><!-- MR1 -->
		<div>
			<div class="table" style="width:100%;">
				<div class="row SLSfsHeader SLSfsHeaderTheme">
					<div class="cell SLSfsHeaderText SLSfsHeaderTextTheme">SEARCH / FILTER</div>
					<div class="cell SLSfsHeaderCell" id="refMain" onclick="refreshMain()"><img src = "${path}/eIPAD/images/Reload24x24.png" /></div>
					<div class="cell SLSfsHeaderCell"  onclick="hideSlideSFS()"><img src = "${path}/eIPAD/images/CloseSearch24x24.png" /></div>
				</div>
			</div>
		</div>
	</div>		
	</div>
	</div>
	
	<%
	int nLoopCount = 0;
	int nRowCount = 0;
	String specCode= "";
	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc
	%>
<!-- 	<div class="row" id="CNFilterContent" style="height:98%; width:100%"> MR2
		<div class="cell"> 
			<div style="width:100%;height:98%;overflow:hidden;position:relative">-->
				<div  style="height: 98%;display:table-row">
				<div class="cell">
				<div id="SLSfsWrapperMain" style="overflow: hidden;position: relative;width: 100%;height:100%;">
					<div id="SLSfsScrollerMain" style="position: absolute;width: 100%;height: auto;">
						<div class="table" id="SLSfsMainTable" style="width:100%;position:relative;background:#cfd6e1">
							<%-- <div class="listItemMAS" style="width:100%; height:40px;" onclick="myList('<%=loggedInUser%>','SPL')" data-fecility="<%=loggedInUser%>">
								<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme">My speciality Notes</div>
								<div class="cell SLSfsListTick SLSfsListTickTheme"><div class="SLSfsTickVisible SLSfsTickVisibleTheme" id="SLSfsTickMLServ" style="display:none"></div></div>
							</div>
							<div class="listItemPB" style="width:100%; height:40px;" onclick="myList('<%=loggedInUser%>','ML')" data-loggedInUser="<%=loggedInUser%>">
								<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme">My Notes</div>
								<div class="cell SLSfsListTick SLSfsListTickTheme"><div class="SLSfsTickVisible SLSfsTickVisibleTheme" id="SLSfsTickMLPract" style="display:none"></div></div>
							</div> --%>
							<!-- My spl notes and My notes -->
							<!-- Encounter selection STARTS -->
							
							  
							<%
							
							EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
							ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
							EncounterHO currentEncounter = new EncounterHO();
							if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
								allEncArrayList = allEncountersResp.getEncounterList();
						
							}
						
							%>
							<div class="table encounterTimeframeWrap">
							<div class="table filterTextWrap">
							<div class="row" id="headingEC" style="height:40px">
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('EC')" style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >ENCOUNTER</div>
											<%-- <div class="cell SLSfsHeaderCell SLSfsHeaderCellCountTheme"><%=nLstCountPB%></div> --%>
											<div class="cell SLSfsHeaderCellTab SLSfsarrow" id="arrowEC" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<div class="row" id="contentEC">
								<div class="cell">
									<div class="SLSfsNormalView" id="dataEC">
										<div id="SLSfsWrapperEC" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerEC">
										   		<div class="table" id="listEC" style="width:100%; height:100%;">
										   		
															
															
															
															<%
																for(int i=0;i<allEncArrayList.size();i++){ 
																	EncounterHO iEncounter = allEncArrayList.get(i);
																	%>
															<div class="listItemEC" style="width:100%; height:40px;" onclick="chooseEncounterFilter('<%=iEncounter.getEncounterId()%>','clinicalNotes','fullViewEncounter')">
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="">
																	<div class="">
																		<div class="cell" style="vertical-align:middle"><div class="ipOPText"><%=iEncounter.getPatientClass()%></div></div>
																		<div class="cell">
																			<p style="font-size:13px;color:#797b7c">EN ID <%=iEncounter.getEncounterId()%></p>
																			<p style="font-size:10px;color:#d3c9c9"><%=iEncounter.getFromDate() %> &nbsp <%=iEncounter.getToDate()%></p>
																		</div>
																	</div>
																</div>
																<%-- <div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme"><%=iEncounter.getPractShortName()%> EN ID - <%=iEncounter.getEncounterId()%> <%=iEncounter.getFromDate() %></div> --%>
																<div class="cell SLSfsListTick SLSfsListTickTheme"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickEN<%=iEncounter.getEncounterId()%>" style="display:none"></div></div>
															</div>
															<%
																	}
															%>
															<input type = "hidden" name ="hdnCurrentEncID" id ="hdnCurrentEncID" value = "<%=selectedEncounterID%>"/> <%-- <%=allEncArrayList.get(0).getEncounterId()%> --%>
															<input type = "hidden" name ="hdnActiveEncID" id ="hdnActiveEncID" value = "<%=patientContext.getEncounterId()%>"/> <%-- <%=allEncArrayList.get(0).getEncounterId()%> --%>
											   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							</div>
							<!-- Encounter selection ENDS -->
							<!-- TimeFrame STARTS -->
							<%
							ArrayList<String> dateArray = new ArrayList<String>();
							ArrayList<String> encArray = new ArrayList<String>();
							
							for(int i=0;i<allEncArrayList.size();i++){ 
							EncounterHO EncounterLst = allEncArrayList.get(i);
							dateArray.add(EncounterLst.getFromDate());
							encArray.add(EncounterLst.getEncounterId());
							}
							int hdnDateArrCount = dateArray.size();
							int hdnEncArrCount = encArray.size();
							jsonFieldResDate = gson.toJson(dateArray);
							jsonFieldResEnc = gson.toJson(encArray);
							%>
							<div class="table filterTextWrap">
							<input type = "hidden" name ="hdnDateArrCount" id ="hdnDateArrCount" value = '<%=hdnDateArrCount%>'/>
							<input type = "hidden" name ="hdnEncArrCount" id ="hdnEncArrCount" value = '<%=hdnEncArrCount%>'/>
							<input type = "hidden" name ="hdnEncounterDate" id ="hdnEncounterDate" value = '<%=jsonFieldResDate%>'/>
							<input type = "hidden" name ="hdnEncounterEnc" id ="hdnEncounterEnc" value = '<%=jsonFieldResEnc%>'/>
							<div class="row" id="headingTF" style="height:40px">
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('TF')"  style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >TIME FRAME</div>
											<div class="cell SLSfsHeaderCellTab " id="arrowTF" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<div class="row" id="contentTF">
								<div class="cell">
									<div class="SLSfsNormalView" id="dataTF">
										<div id="SLSfsWrapperTF" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerTF">
										   		<div class="table" id="listTF" style="width:100%; height:100%;">
													<div class="listItemTF" style="width:100%;" onclick="" data-speccode="" data-specdesc="">
														<div class="cell timeFrameSlider"><div id="dateSlider"><input/> <input/></div></div>
														<div class="rangeLabels">
															<span class="startLabel"></span>
															<span class="endLabel">Today</span>
														</div>
														<div class="selectedDates">
															 <input data-role="datepicker" data-bind="value:datepickerStartValue, events:{change:selectedDatesChanged}"/>
															 <input data-role="datepicker"  data-bind="value:datepickerEndValue, events:{change:selectedDatesChanged}"/>
															 <div class="timeFrameSearch" onclick="SearchByTimeFrame()">
																<div class="WidgetButtonTheme" id="btnsfs">
															 	 	<img src="${path}/eIPAD/images/Search18x18.png" width="16px" ;="" height="16px" style="padding-top: 3px;">
															 	</div>
															</div>
																
														</div>
													</div>
											   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							</div>
							<!-- TimeFrame ENDS -->
							</div>
							</div>
							<div class="table"  style="width:100%;position:relative;background:#eaedf2;">
							<div class="table allFilterBgwarp">
                            <!-- Clinical Notes Type STARTS -->
                            
                            <div class="table filterTextWrap">
							<%
							ClinicalNotesFieldResponse oClint = objBC.getNoteTypeListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> NoteTypeList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsNT;//obj to get field values
							NoteTypeList = oClint.getFieldList();
							int nLstCountNT = NoteTypeList.size();
							
						   	%>
							<% if(nLstCountNT > 0){%>
							<div class="row" id="headingNT" style="height:40px">
							<%}else{%>
								<div class="row disabledRow" id="headingNT" style="height:40px">
							<%}%>
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('NT')" style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >NOTE TYPE<span class="clearFilter" onclick="refreshFilter('NT',event)">CLEAR</span><span class="searchByNotes" onclick="searchByNoteType(event)"><img  src ="${path}/eIPAD/images/SearchGray16x16.png" /></span></div>
											<!-- <div class="cell slSfsHeaderCell" onclick="refresh('SP','PR','NU')"> <img  id="refSP" src = "../images/ReloadGrySFS.png"  style="padding-top:4px"/></div> -->
											<%-- <div class="cell SLSfsHeaderCell SLSfsHeaderCellCountTheme"><%=nLstCountNT%></div> --%>
											<div class="cell SLSfsHeaderCellTab " id="arrowNT" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<%
							if(nLstCountNT > 10){
							%>
							<div class="row" id="textBoxNT" style="width:100%; height:40px; background:#ffffff; ">
								<div class="cell">
									<div class="table SLSfsDivShadow SLSfsDivShadowTheme">
										<div class="row" style="height:40px">
											<div class="cell" style="vertical-align:middle; text-align: center;">
												<input type="text" id="searchInputSFSNT" class="SLSfsDivLevelTxtBox" style="color:#9da5b3;"/>
											</div>
											<div class="cell"  style="vertical-align: middle; text-align: center;">
												<div class=" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme" onclick="CNFilterClearTxt('NT','MAS','PB','ST')"><img src="${path}/eIPAD/images/Close-small.png" style="width:10px; height:10px"></div>
											</div>
								    	</div>
									</div>
								</div>
							</div>
							<%
							}
							try {
							if(nLstCountNT > 0){
							%>
							<div class="row" id="contentNT">
								<div class="cell">
								<%-- <%
								if(nLstCountNT > 4){
								%> 
									<div class="SLSfsNormalView" id="dataNT">
									<%
								}
								else{
									%>
									<div class="SLSfsNormalViewAuto" id="dataNT">
									<%
							   	}
									%> --%>
									<div class="SLSfsNormalView" id="dataNT">
										<div id="SLSfsWrapperNT" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerNT">
										   		<div class="table" id="listNT" style="width:100%; height:100%;">
												 	   	<%
												 	   		for(nLoopCount=0; nLoopCount<nLstCountNT; nLoopCount++){ 
													 	  		oCNFieldItemsNT = NoteTypeList.get(nLoopCount);
													 		  	if(oCNFieldItemsNT != null ){
													 			specCode = oCNFieldItemsNT.getCode();
								 
								 				 	   %>   
															<div class="listItemNT" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%=specCode%>','NT')" data-speccode="<%=specCode%>" data-specdesc="<%=oCNFieldItemsNT.getDesc()%>">
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textNT<%=specCode%>"><%=oCNFieldItemsNT.getDesc()%></div><%-- <%=oCNFieldItemsNT.getDetail()%> count --%>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divNT<%=specCode%>"><div class="SLSfsTickVisible SLSfsTickVisibleTheme" id="SLSfsTickNT<%=specCode%>" style="display:none"></div></div>
															</div>
													 	<%
												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 %>
													   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							<%
							}
							if(nLstCountNT > 4){
							%>
							<!-- <div class="row" id="ViewMoreNT" style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme" onclick="viewMore('NT','MAS','PB','ST')"> View More </div>
										</div>
									</div>
								</div>	
							</div> -->
							<!-- <div class="row" id="ViewLessNT"  style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme"  onclick="viewLess('NT','MAS','PB','ST')"> Close </div>
										</div>
									</div>
								</div>	
						    </div> -->
						    <%
							}
						    %>
						    <div class="row SLSfsAfterSelectionTheme" id="NTAfterSel">
						   		<div class="cell">
									<div class="table" style="padding-left:10px;display:block" id="AfterSelectionNT"></div>
								</div>
                            </div>
                            </div>
                            <% } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}%> 
                           <!-- Clinical Notes Type ENDS -->
                           <!-- Med n AncServ STARTS -->
                            <div class="table filterTextWrap">
                            <%
							ClinicalNotesFieldResponse oClintMAS = objBC.getMedServListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> MedServList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsMAS;//obj to get field values
							MedServList = oClintMAS.getFieldList();
							int nLstCountMAS = MedServList.size();
							
						   	%>
							<% if(nLstCountMAS > 0){%>
								<div class="row" id="headingMAS" style="height:40px">
							<%}else{%>
								<div class="row disabledRow" id="headingMAS" style="height:40px">
							<%}%>
						   
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('MAS')" style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >MED SERVICES</div>
											<%-- <div class="cell SLSfsHeaderCell SLSfsHeaderCellCountTheme"><%=nLstCountMAS%></div> --%>
											<div class="cell SLSfsHeaderCellTab " id="arrowMAS" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<%
							if(nLstCountMAS > 10){
							%>
							<div class="row" id="textBoxMAS" style="width:100%; height:40px; background:#ffffff; ">
								<div class="cell">
									<div class="table SLSfsDivShadow SLSfsDivShadowTheme">
										<div class="row" style="height:40px">
											<div class="cell" style="vertical-align:middle; text-align: center;">
												<input type="text" id="searchInputSFSMAS" class="SLSfsDivLevelTxtBox" style="color:#9da5b3;"/>
											</div>
											<div class="cell"  style="vertical-align: middle; text-align: center;">
												<div class=" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme" onclick="CNFilterClearTxt('MAS','NT','PB','ST')"><img src="${path}/eIPAD/images/Close-small.png" style="width:10px; height:10px"></div>
											</div>
								    	</div>
									</div>
								</div>
							</div>
							<%
							}
							try {
							if(nLstCountMAS > 0){
							%>
							<div class="row" id="contentMAS">
								<div class="cell">
								<%-- <%
								if(nLstCountMAS > 4){
								%> 
									<div class="SLSfsNormalView" id="dataMAS">
									<%
								}
								else{
									%>
									<div class="SLSfsNormalViewAuto" id="dataMAS">
									<%
							   	}
									%> --%>
									<div class="SLSfsNormalView" id="dataMAS">
										<div id="SLSfsWrapperMAS" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerMAS">
										   		<div class="table" id="listMAS" style="width:100%; height:100%;">
												 	   	<%
												 	   		for(nLoopCount=0; nLoopCount<nLstCountMAS; nLoopCount++){ 
													 	  		oCNFieldItemsMAS = MedServList.get(nLoopCount);
													 		  	if(oCNFieldItemsMAS != null ){
													 			specCode = oCNFieldItemsMAS.getCode();
								 
								 				 	   %>   
															<div class="listItemMAS" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%=specCode%>','MAS')" data-speccode="<%=specCode%>" data-specdesc="<%=oCNFieldItemsMAS.getDesc()%>">
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textMAS<%=specCode%>"><%=oCNFieldItemsMAS.getDesc()%></div><%-- <%=oCNFieldItemsMAS.getDetail()%> count --%>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divMAS<%=specCode%>"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickMAS<%=specCode%>" style="display:none"></div></div>
															</div>
													 	<%
												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 %>
													   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							<%
							}
							if(nLstCountMAS > 4){
							%>
							<!-- <div class="row" id="ViewMoreMAS" style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme" onclick="viewMore('MAS','NT','PB','ST')"> View More </div>
										</div>
									</div>
								</div>	
							</div> -->
							<!-- <div class="row" id="ViewLessMAS"  style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme"  onclick="viewLess('MAS','NT','PB','ST')"> Close </div>
										</div>
									</div>
								</div>	
						    </div> -->
						    <%
							}
						    %>
						    <div class="row SLSfsAfterSelectionTheme" id="MASAfterSel">
						   		<div class="cell">
									<div class="table" style="padding-left:10px;display:block" id="AfterSelectionMAS"></div>
								</div>
                            </div>
                            </div>
                             <% } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}%>
                            
                            <!-- Med n AncServ ENDS -->
                            <!-- Status STARTS -->
                            <div class="table filterTextWrap">
                            <%
                            ClinicalNotesFieldResponse oClintStatus = objBC.getStatusListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);
                            List<ClinicalNotesFieldItem> StatusList;
                            ClinicalNotesFieldItem oCNFieldItemsStatus;
                            StatusList = oClintStatus.getFieldList();
                            int nLstCountStatus = StatusList.size();
							try {
						   	%>
							<% if(nLstCountStatus > 0){%>
								<div class="row" id="headingST" style="height:40px">
							<%}else{%>
							<div class="row disabledRow" id="headingST" style="height:40px">
							<%}%>
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('ST')" style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >STATUS</div>
											<%-- <div class="cell SLSfsHeaderCell SLSfsHeaderCellCountTheme"><%=nLstCountStatus%></div> --%>
											<div class="cell SLSfsHeaderCellTab " id="arrowST" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<%
							if(nLstCountStatus > 10){
							%>
							<div class="row" id="textBoxST" style="width:100%; height:40px; background:#ffffff; ">
								<div class="cell">
									<div class="table SLSfsDivShadow SLSfsDivShadowTheme">
										<div class="row" style="height:40px">
											<div class="cell" style="vertical-align:middle; text-align: center;">
												<input type="text" id="searchInputSFSST" class="SLSfsDivLevelTxtBox" style="color:#9da5b3;"/>
											</div>
											<div class="cell"  style="vertical-align: middle; text-align: center;">
												<div class=" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme" onclick="CNFilterClearTxt('ST','NT','MAS','PB')"><img src="${path}/eIPAD/images/Close-small.png" style="width:10px; height:10px"></div>
											</div>
								    	</div>
									</div>
								</div>
							</div>
						   	<%
							}
							if(nLstCountStatus > 0){
						   	%>
							<div class="row" id="contentST">
								<div class="cell">
								<%-- <%
								if(nLstCountStatus > 4){
								%> 
									<div class="SLSfsNormalView" id="dataST">
									<%
								}
								else{
									%>
									<div class="SLSfsNormalViewAuto" id="dataST">
									<%
							   	}
									%> --%>
									<div class="SLSfsNormalView" id="dataST">
										<div id="SLSfsWrapperST" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerST">
										   		<div class="table" id="listST" style="width:100%; height:100%;">
												 	   	<%
												 	   		for(nLoopCount=0; nLoopCount<nLstCountStatus; nLoopCount++){ 
												 	   			oCNFieldItemsStatus = StatusList.get(nLoopCount);
													 		  	if(oCNFieldItemsStatus != null ){
													 			specCode = oCNFieldItemsStatus.getCode();
								 
								 				 	   %>   
															<div class="listItemST" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%=specCode%>','ST')" data-speccode="<%=specCode%>" data-specdesc="<%=oCNFieldItemsStatus.getDesc()%>">
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textST<%=specCode%>"><%=oCNFieldItemsStatus.getDesc()%></div><%-- <%=oCNFieldItemsStatus.getDetail()%> count --%>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divST<%=specCode%>"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickST<%=specCode%>" style="display:none"></div></div>
															</div>
													 	<%
												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 %>
													   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							<%
							   	}
							if(nLstCountStatus > 4){
							%>
							<!-- <div class="row" id="ViewMoreST" style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme" onclick="viewMore('ST','NT','MAS','PB')"> View More </div>
										</div>
									</div>
								</div>	
							</div> -->
							<!-- <div class="row" id="ViewLessST"  style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme"  onclick="viewLess('ST','NT','MAS','PB')"> Close </div>
										</div>
									</div>
								</div>	
						    </div> -->
						    <%
							}
						    %>
						    <div class="row SLSfsAfterSelectionTheme" id="STAfterSel">
						   		<div class="cell">
									<div class="table" style="padding-left:10px;display:block" id="AfterSelectionST"></div>
								</div>
                            </div>
                            </div>
                            <% } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}%> 
                            <!-- Status ENDS -->
                            <!-- Performed by STARTS -->
                            <div class="table filterTextWrap">
                            <%
							ClinicalNotesFieldResponse oClintPB = objBC.getPerformedByListSfs(patientContext, viewPage, finalStartDate, finalEndDate, selectedEncounterID);//for response
						 	List<ClinicalNotesFieldItem> PerformedByList;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsPB;//obj to get field values
							PerformedByList = oClintPB.getFieldList();
							int nLstCountPB = PerformedByList.size();
							
						   	%>
							<% if(nLstCountPB > 0){%>
								<div class="row" id="headingPB" style="height:40px">
							<%}else{%>
							<div class="row disabledRow" id="headingPB" style="height:40px">
							<%}%>
						   	 
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock"  onclick="CNFilterSectionToggle('PB')"style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >BY PRACTITIONER</div>
											<%-- <div class="cell SLSfsHeaderCell SLSfsHeaderCellCountTheme"><%=nLstCountPB%></div> --%>
											<div class="cell SLSfsHeaderCellTab" id="arrowPB"><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<%
							if(nLstCountPB > 10){
							%>
							<div class="row" id="textBoxPB" style="width:100%; height:40px; background:#ffffff; ">
								<div class="cell">
									<div class="table SLSfsDivShadow SLSfsDivShadowTheme">
										<div class="row" style="height:40px">
											<div class="cell" style="vertical-align:middle; text-align: center;">
												<input type="text" id="searchInputSFSPB" class="SLSfsDivLevelTxtBox" style="color:#9da5b3;"/>
											</div>
											<div class="cell"  style="vertical-align: middle; text-align: center;">
												<div class=" SLSfsTextBoxCloseButton SLSfsTextBoxCloseButtonTheme" onclick="CNFilterClearTxt('PB','NT','MAS','ST')"><img src="${path}/eIPAD/images/Close-small.png" style="width:10px; height:10px"></div>
											</div>
								    	</div>
									</div>
								</div>
							</div>
							<%
							}
							try {
							if(nLstCountPB > 0){
							%>
							<div class="row" id="contentPB">
								<div class="cell">
								<%-- <%
								if(nLstCountPB > 4){
								%> 
									<div class="SLSfsNormalView" id="dataPB">
									<%
								}
								else{
									%>
									<div class="SLSfsNormalViewAuto" id="dataPB">
									<%
							   	}
									%> --%>
									<div class="SLSfsNormalView" id="dataPB">
										<div id="SLSfsWrapperPB" style="background-color: #ffffff;"> 
											<div id="SLSfsScrollerPB">
										   		<div class="table" id="listPB" style="width:100%; height:100%;">
											 	   	<%
											 	   		for(nLoopCount=0; nLoopCount<nLstCountPB; nLoopCount++){ 
											 	   			oCNFieldItemsPB = PerformedByList.get(nLoopCount);
												 		  	if(oCNFieldItemsPB != null ){
												 			specCode = oCNFieldItemsPB.getCode();
								 
								 				 	   %>   
															<div class="listItemPB" style="width:100%; height:40px;" onclick="CNFilterShowTick('<%=specCode%>','PB')" data-speccode="<%=specCode%>" data-specdesc="<%=oCNFieldItemsPB.getDesc()%>">
																<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textPB<%=specCode%>"><%=oCNFieldItemsPB.getDesc()%></div> <%-- <%=oCNFieldItemsPB.getDetail()%> --> Count--%>
																<div class="cell SLSfsListTick SLSfsListTickTheme" id="divPB<%=specCode%>"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickPB<%=specCode%>" style="display:none"></div></div>
															</div>
													 	<%
												  				}
												  					nRowCount = nRowCount + 1;
															} 
													 %>
											   </div>
							  				</div>
										</div>
									</div>
								</div>
							</div>
							<%
							   	}
							if(nLstCountPB > 4){
							%>
							<!-- <div class="row" id="ViewMorePB" style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme" onclick="viewMore('PB','NT','MAS','ST')"> View More </div>
										</div>
									</div>
								</div>	
							</div> -->
							<!-- <div class="row" id="ViewLessPB"  style="height:40px">
								<div class="cell">
									<div class="table SLSfsCategoryViewMore SLSfsCategoryViewMoreTheme">
										<div class="row">
											<div class="cell SLSfsTabText SLSfsTabTextTheme"  onclick="viewLess('PB','NT','MAS','ST')"> Close </div>
										</div>
									</div>
								</div>	
						    </div> -->
							<%
							}
							%>
							
						    <div class="row SLSfsAfterSelectionTheme" id="PBAfterSel">
						   		<div class="cell">
									<div class="table" style="padding-left:10px;display:block" id="AfterSelectionPB"></div>
								</div>
                            </div>
                            </div>
                            <% } 
								catch( Exception e ){
									e.printStackTrace();
								}
								finally{
								}%> 
                            <!-- performed by ENDS -->
						</div><!-- allFilterBgwarp end-->
                            <!-- showNotes STARTS-->
                            <%-- <div class="table filterTextWrap">
                            <div class="row" id="headingSN" style="height:40px">
								<div class="cell">
									<div class="table" style="width:100%;height:40px">
										<div class="row SLSfsCategoryBlock" onclick="CNFilterSectionToggle('SN')" style="width:100%; height:40px;">
											<div class="cell SLSfsDivText SLSfsDivTextTheme" >SHOW NOTES</div>
											<!-- <div class="cell slSfsHeaderCell" onclick="refresh('SP','PR','NU')"> <img  id="refSP" src = "../images/ReloadGrySFS.png"  style="padding-top:4px"/></div> -->
											<div class="cell SLSfsHeaderCellTab " id="arrowSN" ><img  src ="${path}/eIPAD/images/DownarrowSFS.png" /></div>
										</div>
									</div>
								</div>
							</div>
							<div class="row" id="contentSN">
								<div class="cell">
							   		<div class="table" id="listSN" style="width:100%; height:100%;">
										<div class="listItemSN" style="width:100%; height:40px;"  data-speccode="RV"> <!-- onclick="CNFilterShowTick('RV','SN')" -->
											<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textSN1">Awaiting Review</div>
											<div class="cell SLSfsListTick SLSfsListTickTheme" id="divSN1"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickSNRV" style="display:none"></div></div>
										</div>
										<div class="listItemSN" style="width:100%; height:40px;"  data-speccode="SN"> <!-- onclick="CNFilterShowTick('SN','SN')" -->
											<div class= "cell SLSfsViewItemText SLSfsViewItemTextTheme" id="textSN2">Awaiting Completion</div>
											<div class="cell SLSfsListTick SLSfsListTickTheme" id="divSN2"><div class="SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme" id="SLSfsTickSNSN" style="display:none"></div></div>
										</div>
									</div>
								</div>
							</div>
                            </div> --%>
                            <!-- showNotes ENDS-->
                             <%-- <!-- mySpecialityList STARTS -->
                            <%
                           /*  int nLoopCount = 0;
                        	int nRowCount = 0;
                        	String specCode= "";
                        	ClinicalNotesBC objBC = new ClinicalNotesBC();//calling bc */
							ClinicalNotesFieldResponse oClintSPL = objBC.getMySpecialityList(patientContext);//for response
						 	List<ClinicalNotesFieldItem> MySpecialityListSFS;//to get the list
							ClinicalNotesFieldItem oCNFieldItemsSPL;//obj to get field values
							MySpecialityListSFS = oClintSPL.getFieldList();
							int nLstCountSPL = MySpecialityListSFS.size(); 
							
							%>
							<input type = "hidden" name ="hdnCount" id ="hdnCount" value = "<%=nLstCountSPL%>"/>
							<input type = "hidden" name ="hdnLoggedInUser" id ="hdnLoggedInUser" value = "<%=loggedInUser%>"/>
							<%
							for(nLoopCount=0; nLoopCount<nLstCountSPL; nLoopCount++){ 
								oCNFieldItemsSPL = MySpecialityListSFS.get(nLoopCount);
								  	if(oCNFieldItemsSPL != null ){
									specCode = oCNFieldItemsSPL.getDesc();
							%>
							<input type = "hidden" name ="hdnSpeciality" id ="hdnSpeciality<%=nLoopCount%>" value = "<%=specCode%>"/>
							<%
								  	}
							}
							%> --%>
						</div>
					</div>
				</div>
				</div><!-- cell close-->
				</div><!-- row end-->
			<!-- 	</div>
			
	</div>
	</div> -->
</div>


	



